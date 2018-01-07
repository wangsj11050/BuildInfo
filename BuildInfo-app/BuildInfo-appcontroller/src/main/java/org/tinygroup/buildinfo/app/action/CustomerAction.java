package org.tinygroup.buildinfo.app.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinygroup.buildinfo.service.inter.BuildAdisverService;
import org.tinygroup.buildinfo.service.inter.BuildCustomerCaseService;
import org.tinygroup.buildinfo.service.inter.BuildInfoServiceService;

@Controller
@RequestMapping("/customer-case")
public class CustomerAction extends BaseController {

	private BuildCustomerCaseService buildCustomerCaseService;
	
	private BuildInfoServiceService buildInfoServiceService;

	public BuildInfoServiceService getBuildInfoServiceService() {
		return buildInfoServiceService;
	}

	public void setBuildInfoServiceService(BuildInfoServiceService buildInfoServiceService) {
		this.buildInfoServiceService = buildInfoServiceService;
	}
	
	public BuildCustomerCaseService getBuildCustomerCaseService() {
		return buildCustomerCaseService;
	}

	public void setBuildCustomerCaseService(BuildCustomerCaseService buildCustomerCaseService) {
		this.buildCustomerCaseService = buildCustomerCaseService;
	}

	@RequestMapping("index")
	public String index(Model model){
		model.addAttribute("buildCustomerCaseList",buildCustomerCaseService.getCustomerCaseList(null));
		model.addAttribute("buildServiceList",buildInfoServiceService.getServicetypeList(null));
		return "buildinfo/customer-case";
	}
	
	@RequestMapping("query")
	public String query(Integer id, Model model){
		model.addAttribute("buildCustomerCase",buildCustomerCaseService.getCustomerCaseById(id));
		model.addAttribute("buildServiceList",buildInfoServiceService.getServicetypeList(null));
		return "buildinfo/customer/caseinform";
	}
}
