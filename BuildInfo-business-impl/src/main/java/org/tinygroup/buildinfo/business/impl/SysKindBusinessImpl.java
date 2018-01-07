package org.tinygroup.buildinfo.business.impl;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.TsysKindDao;
import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysKind;
import org.tinygroup.buildinfo.business.inter.SysKindBusiness;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public class SysKindBusinessImpl implements SysKindBusiness {
	
	private TsysKindDao tsysKindDao;

	public TsysKindDao gettsysKindDao() {
		return tsysKindDao;
	}

	public void settsysKindDao(TsysKindDao tsysKindDao) {
		this.tsysKindDao = tsysKindDao;
	}

	public TsysKind getById(String officeCode) {
		return tsysKindDao.getByKey(officeCode);
	}

	public Pager<TsysKind> getPager(int start, int limit, TsysKind sysKind,
			OrderBy... orderBies) {
		return tsysKindDao.queryPagerForSearch(start, limit, sysKind, orderBies);
	}

	public TsysKind add(TsysKind sysOffice) {
		return tsysKindDao.add(sysOffice);
	}

	public int update(TsysKind sysOffice) {
		return tsysKindDao.edit(sysOffice);
	}

	public int deleteByKeys(String... pks) {
		return tsysKindDao.deleteByKeys(pks);
	}

	public boolean checkExists(TsysKind sysOffice) {
		return tsysKindDao.checkExist(sysOffice).size() == 0 ? false : true;
	}

	public List getKindTree(TreeData tree) {
		return tsysKindDao.getKindTree(tree);
	}

	public List getKindsList(TsysKind sysKind) {
		return tsysKindDao.query(sysKind);
	}

}
