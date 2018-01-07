package org.tinygroup.buildinfo.action.pubdemand;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinygroup.buildinfo.action.BaseController;

@Controller
@RequestMapping("syspubdemandmenu")
public class BuildPubDemandMenuAction extends BaseController {

	@RequestMapping("pubdemand")
	public String news(){
		return "biz/buildinfo/pub-demand/buildpub_demand.page";
	}
}
