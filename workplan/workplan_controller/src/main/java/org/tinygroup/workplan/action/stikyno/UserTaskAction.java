package org.tinygroup.workplan.action.stikyno;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.service.inter.dto.complex.UserInfo;
import org.tinygroup.workplan.dto.UserTaskDto;
import org.tinygroup.workplan.service.inter.UserTaskService;

@Controller
@RequestMapping("/workusertask")
public class UserTaskAction extends BaseController{

	private UserTaskService userTaskService;

	public UserTaskService getUserTaskService() {
		return userTaskService;
	}

	public void setUserTaskService(UserTaskService userTaskService) {
		this.userTaskService = userTaskService;
	}
	
	@RequestMapping("getUserTaskList")
	@ResponseBody
	public List getUserTaskList(HttpSession httpSession,UserTaskDto userTaskDto,Model model){
		if(userTaskDto == null){
			userTaskDto = new UserTaskDto();
		}
		UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
		userTaskDto.setDutyUser(userInfo.getUserId());
		userTaskDto.setExtField_1("1");
		return userTaskService.getUserDemandChart(userTaskDto, "taskType", "asc");
	}
}
