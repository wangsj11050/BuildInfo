package org.tinygroup.buildinfo.app.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinygroup.buildinfo.service.inter.BuildAdisverService;
import org.tinygroup.buildinfo.service.inter.BuildServiceCenterService;
import org.tinygroup.buildinfo.service.inter.dto.BuildAdisverDto;

@Controller
@RequestMapping("/adisver")
public class AdisverAction extends BaseController {

	private BuildServiceCenterService buildServiceCenterService;

	private BuildAdisverService buildAdisverService;

	public BuildAdisverService getBuildAdisverService() {
		return buildAdisverService;
	}

	public void setBuildAdisverService(BuildAdisverService buildAdisverService) {
		this.buildAdisverService = buildAdisverService;
	}
	
	public BuildServiceCenterService getBuildServiceCenterService() {
		return buildServiceCenterService;
	}

	public void setBuildServiceCenterService(BuildServiceCenterService buildServiceCenterService) {
		this.buildServiceCenterService = buildServiceCenterService;
	}
	
	@RequestMapping("index")
	public String index(Model model){
		model.addAttribute("buildServicecenterList",buildServiceCenterService.getServicecenterList(null));
		model.addAttribute("buildAdisverList",buildAdisverService.getAdisverList(null));
		return "buildinfo/adisver";
	}
	
	@RequestMapping("findAdisverByName")
	public String findAdisverByName(String key,Model model){
		model.addAttribute("buildServicecenterList",buildServiceCenterService.getServicecenterList(null));
		model.addAttribute("buildAdisverList",buildAdisverService.getAdisverByName(key));
		return "buildinfo/adisver";
	}
	
	@RequestMapping("findAdisver")
	public String findAdisver(BuildAdisverDto buildAdisverDto,Model model){
		model.addAttribute("buildServicecenterList",buildServiceCenterService.getServicecenterList(null));
		model.addAttribute("buildAdisverList",buildAdisverService.getAdisverList(buildAdisverDto));
		return "buildinfo/adisver";
	}
	
	@RequestMapping("inform")
	public String adisverInform(Integer id,Model model){
		model.addAttribute("buildAdisver",buildAdisverService.getAdisverById(id));
		return "buildinfo/adisver/adisverinform";
	}
}
