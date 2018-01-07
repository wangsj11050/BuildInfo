package org.tinygroup.buildinfo.action.service;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.service.inter.BuildInfoServiceService;
import org.tinygroup.buildinfo.service.inter.ServiceContentService;
import org.tinygroup.buildinfo.service.inter.dto.BuildServicecontentDto;
import org.tinygroup.buildinfo.service.inter.dto.BuildServicetypeDto;

@Controller
@RequestMapping("/workserviceContent")
public class BuildServicecontentAction extends BaseController {

	private ServiceContentService serviceContentService;

	private BuildInfoServiceService buildInfoServiceService;
	
	public ServiceContentService getServiceContentService() {
		return serviceContentService;
	}

	public void setServiceContentService(ServiceContentService serviceContentService) {
		this.serviceContentService = serviceContentService;
	}

	public BuildInfoServiceService getBuildInfoServiceService() {
		return buildInfoServiceService;
	}

	public void setBuildInfoServiceService(BuildInfoServiceService buildInfoServiceService) {
		this.buildInfoServiceService = buildInfoServiceService;
	}
	
	
	@RequestMapping("edit")
    public String get(String serviceCode, Model model){
        if(serviceCode !=null){
            BuildServicetypeDto buildServicetypeDto = buildInfoServiceService.getServicetypeByCode(serviceCode);
            BuildServicecontentDto buildServicecontentDto = serviceContentService.getServiceContentByCode(serviceCode);
            model.addAttribute("buildServicetypeDto",buildServicetypeDto);
            model.addAttribute("serviceContentDto",buildServicecontentDto);
        }
        return "/biz/buildinfo/service-content/servicecontent-edit";
    }
	
	@RequestMapping("update")
	@ResponseBody
	public Map<?,?> update(BuildServicecontentDto buildServicecontentDto, Model model){
		int count = serviceContentService.updateServiceContent(buildServicecontentDto);
		if(count > 0){
        	return resultMap(true,"修改成功!");
        }
        return resultMap(false,"修改失败!");
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Map<?,?> save(BuildServicecontentDto buildServicecontentDto, Model model){
		return (serviceContentService.addServiceContent(buildServicecontentDto) != null)?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
		
	}
}
