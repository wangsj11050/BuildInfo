package org.tinygroup.buildinfo.action.news;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinygroup.buildinfo.action.BaseController;

@Controller
@RequestMapping("sysnewsmenu")
public class BuildNewsMenuAction extends BaseController {

	@RequestMapping("news")
	public String news(){
		
		return "biz/buildinfo/news/buildnews.page";
	}
}
