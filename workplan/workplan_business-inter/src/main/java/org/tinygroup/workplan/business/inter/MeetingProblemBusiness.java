package org.tinygroup.workplan.business.inter;

import java.util.List;

import org.tinygroup.workplan.dao.inter.pojo.TMeetingProblem;

public interface MeetingProblemBusiness {

	TMeetingProblem getMeetingProblemByKey(Integer id);
	
	TMeetingProblem addMeetingProblem(TMeetingProblem meetingProblem);
	
	int updateMeetingProblem(TMeetingProblem meetingProblem);
	
	List<TMeetingProblem> getUserMeetingProblemList(TMeetingProblem meetingProblem);
	
	List<TMeetingProblem> getFinishUserMeetingProblemList(TMeetingProblem meetingProblem);
}
