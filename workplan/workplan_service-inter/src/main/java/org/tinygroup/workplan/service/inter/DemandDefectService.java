package org.tinygroup.workplan.service.inter;

import org.tinygroup.workplan.dto.DemandDefectDto;

public interface DemandDefectService {

	public DemandDefectDto getDemandDefectByKey(Integer id);
	
	public DemandDefectDto addDemandDefect(DemandDefectDto demandDefectDto);
	
	public int updateDemandDefect(DemandDefectDto demandDefectDto);
	
	public int getUserDemandDefectCount(DemandDefectDto demandDefectDto);
	
	public int getFinishUserDemandDefectCount(DemandDefectDto demandDefectDto);
}
