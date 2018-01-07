package org.tinygroup.workplan.action.stikyno;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.service.inter.dto.complex.UserInfo;
import org.tinygroup.workplan.dto.MeetingProblemDto;
import org.tinygroup.workplan.service.inter.MeetingProblemService;

@Controller
@RequestMapping("workUserMeetingProblem")
public class MeetingProblemAction extends BaseController {

	private MeetingProblemService meetingProblemService;

	public MeetingProblemService getMeetingProblemService() {
		return meetingProblemService;
	}

	public void setMeetingProblemService(MeetingProblemService meetingProblemService) {
		this.meetingProblemService = meetingProblemService;
	}
	
	@RequestMapping("userMeetingProblemProcess")
	@ResponseBody
	public Map<String,Integer> getUserMeetingProblemProcess(HttpSession httpSession,MeetingProblemDto meetingProblemDto,Model model){
		if(meetingProblemDto == null){
			meetingProblemDto = new MeetingProblemDto();
		}
		Map<String,Integer> returnMap = new HashMap<String,Integer>();
		UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
		meetingProblemDto.setDutyUser(userInfo.getUserId());
		meetingProblemDto.setStatus("4");
		int userMeetingProblemCount = meetingProblemService.getUserMeetingProblemCount(meetingProblemDto);
		int finishMeetingProblemCount = meetingProblemService.getFinishUserMeetingProblemCount(meetingProblemDto);
		returnMap.put("count", userMeetingProblemCount);
		returnMap.put("finishCount", finishMeetingProblemCount);
		return returnMap;
	}
}
