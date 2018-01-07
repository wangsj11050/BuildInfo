package org.tinygroup.workplan.service.inter;

import java.util.List;

import org.tinygroup.workplan.dto.UserDemandChartDto;
import org.tinygroup.workplan.dto.UserTaskDto;

public interface UserTaskService {

	UserTaskDto getUserTaskByKey(Integer id);
	
	UserTaskDto addUserTask(UserTaskDto userTaskDto);
	
	int updateUserTask(UserTaskDto userTaskDto);
	
	List<UserDemandChartDto> getUserDemandChart(UserTaskDto userTaskDto, String order, String orderType);
}
