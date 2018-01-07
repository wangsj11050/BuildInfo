package org.tinygroup.buildinfo.action.adisver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinygroup.buildinfo.action.BaseController;

@Controller
@RequestMapping("sysadisvermenu")
public class BuildAdisverMenuAction extends BaseController {

	@RequestMapping("adisver")
	public String news(){
		
		return "biz/buildinfo/adisver/buildadisver.page";
	}
}
