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
import org.tinygroup.workplan.dto.DemandDefectDto;
import org.tinygroup.workplan.service.inter.DemandDefectService;

@Controller
@RequestMapping("/workuserDemandDefect")
public class DemandDefectAction extends BaseController {

	private DemandDefectService demandDefectService;

	public DemandDefectService getDemandDefectService() {
		return demandDefectService;
	}

	public void setDemandDefectService(DemandDefectService demandDefectService) {
		this.demandDefectService = demandDefectService;
	}
	
	@RequestMapping("userDemandDefectProcess")
	@ResponseBody
	public Map<String,Integer> getUserDemandDefectProcess(HttpSession httpSession,DemandDefectDto demandDefectDto,Model model){
		if(demandDefectDto == null){
			demandDefectDto = new DemandDefectDto();
		}
		Map<String,Integer> returnMap = new HashMap<String,Integer>();
		UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
		demandDefectDto.setExtField_1(userInfo.getUserId());
		demandDefectDto.setExtField_2("5");
		int userDemandDefectCount = demandDefectService.getUserDemandDefectCount(demandDefectDto);
		int finishUserDemandDefect = demandDefectService.getFinishUserDemandDefectCount(demandDefectDto);
		returnMap.put("count", userDemandDefectCount);
		returnMap.put("finishCount", finishUserDemandDefect);
		return returnMap;
	}
}
