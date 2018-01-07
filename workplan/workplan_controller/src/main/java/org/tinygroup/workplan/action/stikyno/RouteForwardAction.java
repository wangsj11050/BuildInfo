package org.tinygroup.workplan.action.stikyno;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.workplan.service.inter.RouteForwardService;

@Controller
@RequestMapping("/workroute")
public class RouteForwardAction extends BaseController {

	private RouteForwardService routeForwardService;
	
	public RouteForwardService getRouteForwardService() {
		return routeForwardService;
	}

	public void setRouteForwardService(RouteForwardService routeForwardService) {
		this.routeForwardService = routeForwardService;
	}

	@RequestMapping("userTaskRouteForward")
	public String userTaskRouteForward(String taskType){
		return "redirect:"+routeForwardService.userTaskRouteForward(taskType);
	}
}
