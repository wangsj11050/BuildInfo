package org.tinygroup.buildinfo.action.aboutas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.service.inter.BuildAboutAsService;

@Controller
@RequestMapping("sysaboutasmenu")
public class BuildAboutAsMenuAction extends BaseController{

	private BuildAboutAsService buildAboutAsService;
	
	public BuildAboutAsService getBuildAboutAsService() {
		return buildAboutAsService;
	}

	public void setBuildAboutAsService(BuildAboutAsService buildAboutAsService) {
		this.buildAboutAsService = buildAboutAsService;
	}

	@RequestMapping("aboutas")
	public String aboutas(Model model){
		model.addAttribute("aboutAs", buildAboutAsService.getAboutAs());
		return "biz/buildinfo/aboutAs";
	}
}
