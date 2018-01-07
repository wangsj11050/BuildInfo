package org.tinygroup.workplan.business.inter;

import org.tinygroup.tinysqldsl.Pager;
import org.tinygroup.workplan.dao.inter.pojo.TDemandPlann;

public interface DemandPlannBusiness {

	TDemandPlann getDemandPlannById(Integer id);
	
	TDemandPlann addDemandPlann(TDemandPlann tdemandPlann);
	
	int updateDemandPlann(TDemandPlann tdemandPlann);
	
	int deleteDemandPlann(Integer[] ids);
	
	Pager getDemandPlannPager(int start, int pageSize, TDemandPlann tdemandPlann);
	
	boolean CheckDemandPlannExists(TDemandPlann tdemandPlann);
}
