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
import org.tinygroup.workplan.dto.TrainUserProblemDto;
import org.tinygroup.workplan.service.inter.TrainUserProblemService;

@Controller
@RequestMapping("/workTrainUserProblem")
public class TrainUserProblemAction extends BaseController {

	private TrainUserProblemService trainUserProblemService;

	public TrainUserProblemService getTrainUserProblemService() {
		return trainUserProblemService;
	}

	public void setTrainUserProblemService(TrainUserProblemService trainUserProblemService) {
		this.trainUserProblemService = trainUserProblemService;
	}
	
	@RequestMapping("trainUserProblemProcess")
	@ResponseBody
	public Map<String,Integer> getTrainUserProblemProcess(HttpSession httpSession,TrainUserProblemDto trainUserProblemDto,Model model){
		if(trainUserProblemDto == null){
			trainUserProblemDto = new TrainUserProblemDto();
		}
		Map<String,Integer> returnMap = new HashMap<String,Integer>();
		UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
		trainUserProblemDto.setTrainUser(userInfo.getUserId());
		trainUserProblemDto.setExtField_1("1");
		int trainUserProblemCount = trainUserProblemService.getUserTrainUserProblemCount(trainUserProblemDto);
		int finishTrainUserProblemCount = trainUserProblemService.getFinishUserTrainUserProblemCount(trainUserProblemDto);
		returnMap.put("count", trainUserProblemCount);
		returnMap.put("finishCount", finishTrainUserProblemCount);
		return returnMap;
	}
}
