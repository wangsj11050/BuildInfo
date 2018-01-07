package org.tinygroup.buildinfo.action.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.service.inter.BuildInfoServiceService;

@Controller
@RequestMapping("sysbuildservicemenu")
public class BuildServicetypeMenuAction extends BaseController {

	private BuildInfoServiceService buildInfoServiceService;

	public BuildInfoServiceService getBuildInfoServiceService() {
		return buildInfoServiceService;
	}

	public void setBuildInfoServiceService(BuildInfoServiceService buildInfoServiceService) {
		this.buildInfoServiceService = buildInfoServiceService;
	}
	
	@RequestMapping("getDetails")
	public String getDetails(String serviceCode,Model model){
		model.addAttribute("buildServiceList",buildInfoServiceService.getServicetypeList(null));
		if(serviceCode != null){
			model.addAttribute("buildServicetypeDto",buildInfoServiceService.getServicetypeByCode(serviceCode));
		}
		return "biz/buildinfo/buildservice.page";
	}
	
	@RequestMapping("serviceCenter")
	public String serviceCenter(){
		
		return "biz/buildinfo/service-center/buildservice_center.page";
	}
}