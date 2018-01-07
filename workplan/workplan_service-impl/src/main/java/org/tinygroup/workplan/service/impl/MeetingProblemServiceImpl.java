package org.tinygroup.workplan.service.impl;

import java.util.List;

import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.workplan.business.inter.MeetingProblemBusiness;
import org.tinygroup.workplan.dao.inter.pojo.TMeetingProblem;
import org.tinygroup.workplan.dto.MeetingProblemDto;
import org.tinygroup.workplan.service.inter.MeetingProblemService;

public class MeetingProblemServiceImpl implements MeetingProblemService {

	private MeetingProblemBusiness meetingProblemBusiness;
	
	public MeetingProblemBusiness getMeetingProblemBusiness() {
		return meetingProblemBusiness;
	}

	public void setMeetingProblemBusiness(MeetingProblemBusiness meetingProblemBusiness) {
		this.meetingProblemBusiness = meetingProblemBusiness;
	}

	@Override
	public MeetingProblemDto getMeetingProbleByKey(Integer id) {
		// TODO Auto-generated method stub
		return BeanUtil.copyProperties(MeetingProblemDto.class, meetingProblemBusiness.getMeetingProblemByKey(id));
	}

	@Override
	public MeetingProblemDto addMeetingProble(MeetingProblemDto meetingProblemDto) {
		TMeetingProblem meetingProblem = BeanUtil.copyProperties(TMeetingProblem.class, meetingProblemDto);
		return BeanUtil.getCopiedPropertiesBean(MeetingProblemDto.class, meetingProblemBusiness.addMeetingProblem(meetingProblem));
	}

	@Override
	public int updateMeetingProblem(MeetingProblemDto meetingProblemDto) {
		TMeetingProblem meetingProblem = BeanUtil.copyProperties(TMeetingProblem.class, meetingProblemDto);
		return meetingProblemBusiness.updateMeetingProblem(meetingProblem);
	}

	@Override
	public int getUserMeetingProblemCount(MeetingProblemDto meetingProblemDto) {
		TMeetingProblem meetingProblem = BeanUtil.copyProperties(TMeetingProblem.class, meetingProblemDto);
		List<TMeetingProblem> meetingProblemList = meetingProblemBusiness.getUserMeetingProblemList(meetingProblem);
		return meetingProblemList == null ? 0 : meetingProblemList.size();
	}

	@Override
	public int getFinishUserMeetingProblemCount(MeetingProblemDto meetingProblemDto) {
		TMeetingProblem meetingProblem = BeanUtil.copyProperties(TMeetingProblem.class, meetingProblemDto);
		List<TMeetingProblem> finishMeetingProblemList = meetingProblemBusiness.getFinishUserMeetingProblemList(meetingProblem);
		return finishMeetingProblemList == null ? 0 : finishMeetingProblemList.size();
	}

}
