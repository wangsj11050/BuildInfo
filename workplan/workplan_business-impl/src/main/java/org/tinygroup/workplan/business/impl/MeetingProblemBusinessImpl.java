package org.tinygroup.workplan.business.impl;

import java.util.List;

import org.tinygroup.workplan.business.inter.MeetingProblemBusiness;
import org.tinygroup.workplan.dao.inter.TMeetingProblemDao;
import org.tinygroup.workplan.dao.inter.pojo.TMeetingProblem;

public class MeetingProblemBusinessImpl implements MeetingProblemBusiness {

	private TMeetingProblemDao meetingProblemDao;
	
	public TMeetingProblemDao getMeetingProblemDao() {
		return meetingProblemDao;
	}

	public void setMeetingProblemDao(TMeetingProblemDao meetingProblemDao) {
		this.meetingProblemDao = meetingProblemDao;
	}

	@Override
	public TMeetingProblem getMeetingProblemByKey(Integer id) {
		// TODO Auto-generated method stub
		return meetingProblemDao.getByKey(id);
	}

	@Override
	public TMeetingProblem addMeetingProblem(TMeetingProblem meetingProblem) {
		// TODO Auto-generated method stub
		return meetingProblemDao.add(meetingProblem);
	}

	@Override
	public int updateMeetingProblem(TMeetingProblem meetingProblem) {
		// TODO Auto-generated method stub
		return meetingProblemDao.edit(meetingProblem);
	}

	@Override
	public List<TMeetingProblem> getUserMeetingProblemList(TMeetingProblem meetingProblem) {
		// TODO Auto-generated method stub
		return meetingProblemDao.getUserMeetingProblemList(meetingProblem);
	}

	@Override
	public List<TMeetingProblem> getFinishUserMeetingProblemList(TMeetingProblem meetingProblem) {
		// TODO Auto-generated method stub
		return meetingProblemDao.getFinishUserMeetingProblemList(meetingProblem);
	}

}
