package org.tinygroup.buildinfo.app.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinygroup.buildinfo.service.inter.BuildAboutAsService;
import org.tinygroup.buildinfo.service.inter.BuildInfoServiceService;
import org.tinygroup.buildinfo.service.inter.BuildRecruitService;
import org.tinygroup.buildinfo.service.inter.dto.BuildRecruitDto;

@Controller
@RequestMapping("/recruit")
public class RecruitAction extends BaseController {
	private BuildRecruitService buildRecruitService;
	
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
	
	public BuildRecruitService getBuildRecruitService() {
		return buildRecruitService;
	}

	public void setBuildRecruitService(BuildRecruitService buildRecruitService) {
		this.buildRecruitService = buildRecruitService;
	}
	
	@RequestMapping("index")
	public String index(Model model){
		BuildRecruitDto buildRecruitDto = new BuildRecruitDto();
		buildRecruitDto.setRecruitState("1");
		model.addAttribute("buildAboutAs",buildAboutAsService.getAboutAs());
		model.addAttribute("buildRecruitList",buildRecruitService.getRecruitList(buildRecruitDto));
		model.addAttribute("buildServiceList",buildInfoServiceService.getServicetypeList(null));
		return "buildinfo/recruit";
	}
}
