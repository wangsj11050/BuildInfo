package org.tinygroup.buildinfo.app.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinygroup.buildinfo.service.inter.BuildAboutAsService;
import org.tinygroup.buildinfo.service.inter.BuildInfoServiceService;

@Controller
@RequestMapping("/about-us")
public class AboutUsAction extends BaseController {

	private BuildAboutAsService buildAboutAsService;
	private BuildInfoServiceService buildInfoServiceService;

	public BuildInfoServiceService getBuildInfoServiceService() {
		return buildInfoServiceService;
	}

	public void setBuildInfoServiceService(BuildInfoServiceService buildInfoServiceService) {
		this.buildInfoServiceService = buildInfoServiceService;
	}
	public BuildAboutAsService getBuildAboutAsService() {
		return buildAboutAsService;
	}

	public void setBuildAboutAsService(BuildAboutAsService buildAboutAsService) {
		this.buildAboutAsService = buildAboutAsService;
	}
	
	@RequestMapping("index")
	public String index(Model model){
		model.addAttribute("buildAboutAs",buildAboutAsService.getAboutAs());
		model.addAttribute("buildServiceList",buildInfoServiceService.getServicetypeList(null));
		return "buildinfo/about-us";
	}
}
