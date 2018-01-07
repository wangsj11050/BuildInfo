package org.tinygroup.workplan.service.inter;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.workplan.dto.DemandPlannDto;

public interface DemandPlannService {

	DemandPlannDto getDemandPlannById(Integer id);
	
	DemandPlannDto addDemandPlann(DemandPlannDto demandPlannDto);
	
	int updateDemandPlann(DemandPlannDto demandPlannDto);
	
	int deleteDemandPlann(Integer[] ids);
	
	PageResponse getDemandPlannPager(PageRequest pageRequest, DemandPlannDto demandPlannDto);
	
	boolean CheckDemandPlannExists(DemandPlannDto demandPlannDto);
}
