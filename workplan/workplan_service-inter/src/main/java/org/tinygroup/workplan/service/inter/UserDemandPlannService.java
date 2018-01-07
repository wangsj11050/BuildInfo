package org.tinygroup.workplan.service.inter;

import java.util.List;

import org.tinygroup.workplan.dto.UserDemandChartDto;
import org.tinygroup.workplan.dto.UserDemandPlannDto;

public interface UserDemandPlannService {

	UserDemandPlannDto getUserDemandPlannByKey(Integer id);
	
	UserDemandPlannDto addUserDemandPlann(UserDemandPlannDto userDemandPlannDto);
	
	int updateUserDemandPlann(UserDemandPlannDto userDemandPlannDto);
	
	List<UserDemandChartDto> getUserDemandChartList(UserDemandPlannDto userDemandPlannDto, String order, String orderType);

	public int getUserDemanndPlannCount(UserDemandPlannDto userDemandPlannDto);
	
	public int getFinishUserDemandPlannCount(UserDemandPlannDto userDemandPlannDto);
}
