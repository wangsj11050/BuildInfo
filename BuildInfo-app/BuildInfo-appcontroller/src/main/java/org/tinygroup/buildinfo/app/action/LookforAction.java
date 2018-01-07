package org.tinygroup.buildinfo.app.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.service.inter.BuildInfoServiceService;
import org.tinygroup.buildinfo.service.inter.ServiceContentService;
import org.tinygroup.buildinfo.service.inter.dto.BuildServicecontentDto;
import org.tinygroup.buildinfo.service.inter.dto.BuildServicetypeDto;
import org.tinygroup.buildinfo.service.inter.dto.TreeDto;

@Controller
@RequestMapping("/look-for")
public class LookforAction extends BaseController {

	private BuildInfoServiceService buildInfoServiceService;

	private ServiceContentService serviceContentService;
	
	public BuildInfoServiceService getBuildInfoServiceService() {
		return buildInfoServiceService;
	}

	public void setBuildInfoServiceService(BuildInfoServiceService buildInfoServiceService) {
		this.buildInfoServiceService = buildInfoServiceService;
	}

	public ServiceContentService getServiceContentService() {
		return serviceContentService;
	}

	public void setServiceContentService(ServiceContentService serviceContentService) {
		this.serviceContentService = serviceContentService;
	}

	@RequestMapping("index")
	public String index(String serviceCode,Model model){
		model.addAttribute("serviceCode",serviceCode);
		model.addAttribute("buildServiceList",buildInfoServiceService.getServicetypeList(null));
		model.addAttribute("buildServicecontentList",serviceContentService.getServicecontentList(null));
		return "buildinfo/look-for";
	}
	
	@RequestMapping("Information")
	public String serviceContent(String serviceCode,Model model){
		BuildServicecontentDto buildServicecontentDto = null;
		if(serviceCode != null && !"".equals(serviceCode)){
			buildServicecontentDto = serviceContentService.getServiceContentByCode(serviceCode);
		}
		model.addAttribute("buildServiceList",buildInfoServiceService.getServicetypeList(null));
		
		model.addAttribute("serviceCode",serviceCode);
		model.addAttribute("buildServicecontentDto",buildServicecontentDto);
		
		return "buildinfo/lookfor/information.page";
		
	}
	
	@RequestMapping("likeServiceName")
	public String likeServiceContent(String serviceName,Model model){
		List<BuildServicetypeDto> buildServiceList = new ArrayList<BuildServicetypeDto>();
		if(serviceName != null && !"".equals(serviceName)){
			buildServiceList = buildInfoServiceService.getServiceTypeLikeName(serviceName);
		}
		model.addAttribute("queryServiceList",buildServiceList);
		model.addAttribute("buildServiceList",buildInfoServiceService.getServicetypeList(null));
		model.addAttribute("buildServicecontentList",serviceContentService.getServicecontentList(null));
		return "buildinfo/look-service";
	}
	
	@RequestMapping("getTreeData")
	@ResponseBody
	public List<TreeDto> getTreeData(TreeDto treeDto){
		return buildInfoServiceService.getServicetypeTreeData(treeDto);
	}
	
	@RequestMapping("gsjz")
	public String gsjz(String serviceCode,Model model){
		BuildServicecontentDto buildServicecontentDto = null;
		if(serviceCode != null && !"".equals(serviceCode)){
			buildServicecontentDto = serviceContentService.getServiceContentByCode(serviceCode);
		}
		model.addAttribute("buildServiceList",buildInfoServiceService.getServicetypeList(null));
		
		model.addAttribute("serviceCode",serviceCode);
		model.addAttribute("buildServicecontentDto",buildServicecontentDto);
		return "buildinfo/lookfor/gsjz.page";
	}
	
	@RequestMapping("gsjzInformation")
	public String gsjzservice(String serviceCode,String serviceName,Model model){
		BuildServicecontentDto buildServicecontentDto = null;
		if(serviceCode != null && !"".equals(serviceCode)){
			buildServicecontentDto = serviceContentService.getServiceContentByCode(serviceCode);
		}
		model.addAttribute("buildServiceList",buildInfoServiceService.getServicetypeList(null));
		
		model.addAttribute("serviceCode",serviceCode);
		model.addAttribute("buildServicecontentDto",buildServicecontentDto);
		BuildServicetypeDto buildServicetypeDto = new BuildServicetypeDto();
		if("jzzz".equals(serviceCode)){
			buildServicetypeDto.setParentService("jzzzl");
		}else{
			buildServicetypeDto.setParentService(serviceCode);
		}
		List<BuildServicetypeDto> list = buildInfoServiceService.getServicetypeList(buildServicetypeDto);
		if(list != null && !list.isEmpty()){
			model.addAttribute("showflag","Y");
			model.addAttribute("showbuildServiceList",list);
		}else{
			model.addAttribute("showflag","N");
		}
		model.addAttribute("serviceName",serviceName);
		return "buildinfo/lookfor/jzzzinformation.page";
		
	}
}
