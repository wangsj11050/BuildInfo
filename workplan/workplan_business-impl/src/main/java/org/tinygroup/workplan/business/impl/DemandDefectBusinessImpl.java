package org.tinygroup.workplan.business.impl;

import java.util.List;

import org.tinygroup.workplan.business.inter.DemandDefectBusiness;
import org.tinygroup.workplan.dao.inter.TDemandDefectDao;
import org.tinygroup.workplan.dao.inter.pojo.TDemandDefect;

public class DemandDefectBusinessImpl implements DemandDefectBusiness {

	private TDemandDefectDao demandDefectDao;
	
	
	public TDemandDefectDao getDemandDefectDao() {
		return demandDefectDao;
	}

	public void setDemandDefectDao(TDemandDefectDao demandDefectDao) {
		this.demandDefectDao = demandDefectDao;
	}

	@Override
	public TDemandDefect getDemandDefectByKey(Integer id) {
		// TODO Auto-generated method stub
		return demandDefectDao.getByKey(id);
	}

	@Override
	public TDemandDefect addDemandDefect(TDemandDefect tdemandDefect) {
		// TODO Auto-generated method stub
		return demandDefectDao.add(tdemandDefect);
	}

	@Override
	public int updateDemandDefect(TDemandDefect tdemandDefect) {
		// TODO Auto-generated method stub
		return demandDefectDao.edit(tdemandDefect);
	}

	@Override
	public List<TDemandDefect> getUserDemandDefectList(TDemandDefect tdemandDefect) {
		// TODO Auto-generated method stub
		return demandDefectDao.getUserDemandDefectList(tdemandDefect);
	}

	@Override
	public List<TDemandDefect> getFinishUserDemandDefectList(TDemandDefect tdemandDefect) {
		// TODO Auto-generated method stub
		return demandDefectDao.getFinishUserDemandDefectList(tdemandDefect);
	}

}
