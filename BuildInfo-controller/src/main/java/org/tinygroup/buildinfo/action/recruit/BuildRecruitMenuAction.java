package org.tinygroup.buildinfo.action.recruit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinygroup.buildinfo.action.BaseController;

@Controller
@RequestMapping("sysrecruitmenu")
public class BuildRecruitMenuAction extends BaseController {

	@RequestMapping("recruit")
	public String news(){
		return "biz/buildinfo/recruit/buildrecruit.page";
	}
}
