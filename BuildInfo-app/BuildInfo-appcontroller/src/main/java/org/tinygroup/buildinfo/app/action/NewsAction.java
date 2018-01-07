package org.tinygroup.buildinfo.app.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinygroup.buildinfo.service.inter.BuildInfoServiceService;
import org.tinygroup.buildinfo.service.inter.BuildNewsService;

@Controller
@RequestMapping("/news")
public class NewsAction extends BaseController {

	private BuildNewsService buildNewsService;
	private BuildInfoServiceService buildInfoServiceService;

	public BuildInfoServiceService getBuildInfoServiceService() {
		return buildInfoServiceService;
	}

	public void setBuildInfoServiceService(BuildInfoServiceService buildInfoServiceService) {
		this.buildInfoServiceService = buildInfoServiceService;
	}

	public BuildNewsService getBuildNewsService() {
		return buildNewsService;
	}

	public void setBuildNewsService(BuildNewsService buildNewsService) {
		this.buildNewsService = buildNewsService;
	}

	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("buildNewsList", buildNewsService.getNewsList(null));
		model.addAttribute("buildServiceList",buildInfoServiceService.getServicetypeList(null));
		return "buildinfo/news";
	}

	@RequestMapping("query")
	public String query(Integer id, Model model) {
		model.addAttribute("buildNews", buildNewsService.getNewsById(id));
		model.addAttribute("buildServiceList",buildInfoServiceService.getServicetypeList(null));
		return "buildinfo/news/newsinform";
	}
}
