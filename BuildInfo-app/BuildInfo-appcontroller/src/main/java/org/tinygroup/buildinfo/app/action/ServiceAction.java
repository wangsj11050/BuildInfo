package org.tinygroup.buildinfo.app.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinygroup.buildinfo.service.inter.BuildInfoServiceService;
import org.tinygroup.buildinfo.service.inter.BuildServiceCenterService;
import org.tinygroup.buildinfo.service.inter.ServiceContentService;
import org.tinygroup.buildinfo.service.inter.dto.BuildServicecontentDto;

@Controller
@RequestMapping("/service")
public class ServiceAction extends BaseController {

	private BuildInfoServiceService buildInfoServiceService;

	private ServiceContentService serviceContentService;
	
	private BuildServiceCenterService buildServiceCenterService;

	public BuildServiceCenterService getBuildServiceCenterService() {
		return buildServiceCenterService;
	}

	public void setBuildServiceCenterService(BuildServiceCenterService buildServiceCenterService) {
		this.buildServiceCenterService = buildServiceCenterService;
	}
	
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
	public String index(Model model){
		model.addAttribute("buildServicecenterList",buildServiceCenterService.getServicecenterList(null));
		model.addAttribute("buildServiceList",buildInfoServiceService.getServicetypeList(null));
		return "buildinfo/service";
	}
	
	@RequestMapping("servicecontent")
	public String serviceContent(String serviceName, String parentService,String serviceCode,Model model){
		BuildServicecontentDto buildServicecontentDto = null;
		if(serviceCode != null && !"".equals(serviceCode)){
			buildServicecontentDto = serviceContentService.getServiceContentByCode(serviceCode);
		}
		model.addAttribute("buildServiceList",buildInfoServiceService.getServicetypeList(null));
		model.addAttribute("serviceName",serviceName);
		model.addAttribute("parentService",parentService);
		model.addAttribute("serviceCode",serviceCode);
		model.addAttribute("buildServicecontentDto",buildServicecontentDto);
		return "buildinfo/service/serviceContent.page";
	}
}
