package org.tinygroup.buildinfo.app.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinygroup.buildinfo.service.inter.BuildAdisverService;
import org.tinygroup.buildinfo.service.inter.BuildCustomerCaseService;
import org.tinygroup.buildinfo.service.inter.BuildInfoServiceService;
import org.tinygroup.buildinfo.service.inter.BuildNewsService;

/**
 * Created by Mr.wang on 2016/7/31.
 */
@Controller
public class BuildIndexAction extends BaseController{
	
	private BuildInfoServiceService buildInfoServiceService;

	private BuildAdisverService buildAdisverService;

	public BuildAdisverService getBuildAdisverService() {
		return buildAdisverService;
	}

	public void setBuildAdisverService(BuildAdisverService buildAdisverService) {
		this.buildAdisverService = buildAdisverService;
	}
	
	public BuildInfoServiceService getBuildInfoServiceService() {
		return buildInfoServiceService;
	}

	public void setBuildInfoServiceService(BuildInfoServiceService buildInfoServiceService) {
		this.buildInfoServiceService = buildInfoServiceService;
	}
	
    @RequestMapping("/buildapp/home")
    public String execute(Model model){
    	model.addAttribute("buildServiceList",buildInfoServiceService.getServicetypeList(null));
    	
    	model.addAttribute("buildAdisverList",buildAdisverService.getAdisverList(null));
        return "buildinfo/buildinfohome";
    }
}
