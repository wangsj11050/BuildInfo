package org.tinygroup.workplan.business.impl;

import java.util.List;

import org.tinygroup.buildinfo.common.util.NameUtil;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.workplan.business.inter.UserTaskBusiness;
import org.tinygroup.workplan.dao.inter.TUserTaskDao;
import org.tinygroup.workplan.dao.inter.pojo.TUserTask;

public class UserTaskBusinessImpl implements UserTaskBusiness {

	private TUserTaskDao tuserTaskDao;
	
	public TUserTaskDao getTuserTaskDao() {
		return tuserTaskDao;
	}

	public void setTuserTaskDao(TUserTaskDao tuserTaskDao) {
		this.tuserTaskDao = tuserTaskDao;
	}

	@Override
	public TUserTask getUserTaskByKey(Integer id) {
		// TODO Auto-generated method stub
		return tuserTaskDao.getByKey(id);
	}

	@Override
	public TUserTask addUserTask(TUserTask userTask) {
		// TODO Auto-generated method stub
		return tuserTaskDao.add(userTask);
	}

	@Override
	public int updateUserTask(TUserTask userTask) {
		// TODO Auto-generated method stub
		return tuserTaskDao.edit(userTask);
	}

	@Override
	public List<TUserTask> getUserTaskList(TUserTask userTask, String order, String ordertype) {
		// TODO Auto-generated method stub
		OrderBy orderBy = (order == null || "".equals(order)) ? null : new OrderBy(NameUtil.resolveNameDesc(order), !("desc".equals(ordertype)) ? true : false);
		return tuserTaskDao.getUserTaskList(userTask, orderBy);
	}

}
