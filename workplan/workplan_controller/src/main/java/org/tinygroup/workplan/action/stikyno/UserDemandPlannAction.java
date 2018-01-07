package org.tinygroup.workplan.action.stikyno;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.service.inter.dto.complex.UserInfo;
import org.tinygroup.workplan.dto.UserDemandPlannDto;
import org.tinygroup.workplan.service.inter.UserDemandPlannService;

@Controller
@RequestMapping("/workuserDemandPlann")
public class UserDemandPlannAction extends BaseController {

	private UserDemandPlannService userDemandPlannService;

	public UserDemandPlannService getUserDemandPlannService() {
		return userDemandPlannService;
	}

	public void setUserDemandPlannService(UserDemandPlannService userDemandPlannService) {
		this.userDemandPlannService = userDemandPlannService;
	}
	
	@RequestMapping("getUserDemandPlannList")
	@ResponseBody
	public List getUserDemandPlannList(HttpSession httpSession,UserDemandPlannDto userDemandPlannDto,Model model){
		if(userDemandPlannDto == null){
			userDemandPlannDto = new UserDemandPlannDto();
		}
		UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
		userDemandPlannDto.setDevelopmentUser(userInfo.getUserId());
		return userDemandPlannService.getUserDemandChartList(userDemandPlannDto, "plannState", "asc");
	}
	
	@RequestMapping("userDemandPlannProcess")
	@ResponseBody
	public Map<String,Integer> getUserDemandPlannProcess(HttpSession httpSession,UserDemandPlannDto userDemandPlannDto,Model model){
		if(userDemandPlannDto == null){
			userDemandPlannDto = new UserDemandPlannDto();
		}
		UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
		userDemandPlannDto.setDevelopmentUser(userInfo.getUserId());
		userDemandPlannDto.setPlannState("6");
		int userDemandPlannCouunt = userDemandPlannService.getUserDemanndPlannCount(userDemandPlannDto);
		int finishUserDemandPlannCouunt = userDemandPlannService.getFinishUserDemandPlannCount(userDemandPlannDto);
		Map<String,Integer> returnMap = new HashMap<String,Integer>();
		returnMap.put("count", userDemandPlannCouunt);
		returnMap.put("finishCount", finishUserDemandPlannCouunt);
		return returnMap;
	}
}
