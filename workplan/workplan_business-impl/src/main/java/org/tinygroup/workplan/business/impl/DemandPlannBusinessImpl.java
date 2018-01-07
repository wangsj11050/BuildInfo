package org.tinygroup.workplan.business.impl;

import org.tinygroup.tinysqldsl.Pager;
import org.tinygroup.workplan.business.inter.DemandPlannBusiness;
import org.tinygroup.workplan.dao.inter.TDemandPlannDao;
import org.tinygroup.workplan.dao.inter.pojo.TDemandPlann;

public class DemandPlannBusinessImpl implements DemandPlannBusiness {

	private TDemandPlannDao demandPlannDao;
	
	
	public TDemandPlannDao getDemandPlannDao() {
		return demandPlannDao;
	}

	public void setDemandPlannDao(TDemandPlannDao demandPlannDao) {
		this.demandPlannDao = demandPlannDao;
	}

	@Override
	public TDemandPlann getDemandPlannById(Integer id) {
		return demandPlannDao.getByKey(id);
	}

	@Override
	public TDemandPlann addDemandPlann(TDemandPlann tdemandPlann) {
		return demandPlannDao.add(tdemandPlann);
	}

	@Override
	public int updateDemandPlann(TDemandPlann tdemandPlann) {
		return demandPlannDao.edit(tdemandPlann);
	}

	@Override
	public int deleteDemandPlann(Integer[] ids) {
		return demandPlannDao.deleteByKeys(ids);
	}

	@Override
	public Pager getDemandPlannPager(int start, int pageSize, TDemandPlann tdemandPlann) {
		return demandPlannDao.queryPager(start, pageSize, tdemandPlann);
	}

	@Override
	public boolean CheckDemandPlannExists(TDemandPlann tdemandPlann) {
		// TODO Auto-generated method stub
		return demandPlannDao.checkExist(tdemandPlann).size() >0 ? true : false;
	}

}
