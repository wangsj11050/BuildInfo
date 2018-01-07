package org.tinygroup.workplan.action.stikyno;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinygroup.buildinfo.action.BaseController;

@Controller
@RequestMapping("sysworkmenu")
public class SysWorkMenuAction extends BaseController {

	@RequestMapping("demand_plann")
    public String execute(Model model) {
		return "biz/demand/demand_plann";
	}
	
}
