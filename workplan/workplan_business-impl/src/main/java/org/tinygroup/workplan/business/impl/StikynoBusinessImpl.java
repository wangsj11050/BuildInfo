package org.tinygroup.workplan.business.impl;

import java.util.List;

import org.tinygroup.buildinfo.common.util.NameUtil;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.workplan.business.inter.StikynoBusiness;
import org.tinygroup.workplan.dao.inter.TStikynoDao;
import org.tinygroup.workplan.dao.inter.pojo.TStikyno;

public class StikynoBusinessImpl implements StikynoBusiness {

	private TStikynoDao tstikynoDao;
	
	public TStikynoDao getTstikynoDao() {
		return tstikynoDao;
	}

	public void setTstikynoDao(TStikynoDao tstikynoDao) {
		this.tstikynoDao = tstikynoDao;
	}

	@Override
	public TStikyno getStikyno(Integer id) {
		// TODO Auto-generated method stub
		return tstikynoDao.getByKey(id);
	}

	@Override
	public TStikyno addStikyno(TStikyno stikyno) {
		// TODO Auto-generated method stub
		return tstikynoDao.add(stikyno);
	}

	@Override
	public int updateStikyno(TStikyno stikyno) {
		// TODO Auto-generated method stub
		return tstikynoDao.edit(stikyno);
	}

	@Override
	public List<TStikyno> getStikynoList(TStikyno stikyno) {
		// TODO Auto-generated method stub
		return tstikynoDao.getStikynoList(stikyno);
	}

	@Override
	public List<TStikyno> getIndexStikynoList(TStikyno stikyno, String order, String orderType) {
		// TODO Auto-generated method stub
		OrderBy orderBy = (order == null || "".equals(order)) ? null : new OrderBy(NameUtil.resolveNameDesc(order), !("desc".equals(orderType)) ? true : false);
		return tstikynoDao.getIndexStikynoList(stikyno, orderBy);
	}

}
