package org.tinygroup.workplan.business.inter;

import java.util.List;

import org.tinygroup.workplan.dao.inter.pojo.TDemandDefect;

public interface DemandDefectBusiness {

	TDemandDefect getDemandDefectByKey(Integer id);
	
	TDemandDefect addDemandDefect(TDemandDefect tdemandDefect);
	
	int updateDemandDefect(TDemandDefect tdemandDefect);
	
	List<TDemandDefect> getUserDemandDefectList(TDemandDefect tdemandDefect);
	
	List<TDemandDefect> getFinishUserDemandDefectList(TDemandDefect tdemandDefect);
}
