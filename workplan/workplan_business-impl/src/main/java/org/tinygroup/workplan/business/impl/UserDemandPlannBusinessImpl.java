package org.tinygroup.workplan.business.impl;

import java.util.List;

import org.tinygroup.buildinfo.common.util.NameUtil;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.workplan.business.inter.UserDemandPlannBusiness;
import org.tinygroup.workplan.dao.inter.TUserDemandPlannDao;
import org.tinygroup.workplan.dao.inter.pojo.TUserDemandPlann;

public class UserDemandPlannBusinessImpl implements UserDemandPlannBusiness {

	private TUserDemandPlannDao userDemandPlannDao;
	
	public TUserDemandPlannDao getUserDemandPlannDao() {
		return userDemandPlannDao;
	}

	public void setUserDemandPlannDao(TUserDemandPlannDao userDemandPlannDao) {
		this.userDemandPlannDao = userDemandPlannDao;
	}

	@Override
	public TUserDemandPlann getUserDemandPlannByKey(Integer id) {
		// TODO Auto-generated method stub
		return userDemandPlannDao.getByKey(id);
	}

	@Override
	public TUserDemandPlann addUserDemandPlann(TUserDemandPlann userDemandPlann) {
		// TODO Auto-generated method stub
		return userDemandPlannDao.add(userDemandPlann);
	}

	@Override
	public int updateUserDemandPlann(TUserDemandPlann userDemandPlann) {
		// TODO Auto-generated method stub
		return userDemandPlannDao.edit(userDemandPlann);
	}

	@Override
	public List<TUserDemandPlann> getUserDemandChart(TUserDemandPlann userDemandPlann, String order, String orderType) {
		OrderBy orderBy = (order == null || "".equals(order)) ? null : new OrderBy(NameUtil.resolveNameDesc(order), !("desc".equals(orderType)) ? true : false);
		return userDemandPlannDao.getUserDemandChart(userDemandPlann, orderBy);
	}

	@Override
	public List<TUserDemandPlann> getUserDemanndPlannList(TUserDemandPlann userDemandPlann) {
		// TODO Auto-generated method stub
		return userDemandPlannDao.getUserDemanndPlannList(userDemandPlann);
	}

	@Override
	public List<TUserDemandPlann> getFinishUserDemandPlannList(TUserDemandPlann userDemandPlann) {
		// TODO Auto-generated method stub
		return userDemandPlannDao.getFinishUserDemandPlannList(userDemandPlann);
	}

}
