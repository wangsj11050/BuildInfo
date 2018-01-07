package org.tinygroup.workplan.service.inter;

import org.tinygroup.workplan.dto.MeetingProblemDto;

public interface MeetingProblemService {

	public MeetingProblemDto getMeetingProbleByKey(Integer id);
	
	public MeetingProblemDto addMeetingProble(MeetingProblemDto meetingProblemDto);
	
	public int updateMeetingProblem(MeetingProblemDto meetingProblemDto);
	
	int getUserMeetingProblemCount(MeetingProblemDto meetingProblemDto);
	
	int getFinishUserMeetingProblemCount(MeetingProblemDto meetingProblemDto);
}
