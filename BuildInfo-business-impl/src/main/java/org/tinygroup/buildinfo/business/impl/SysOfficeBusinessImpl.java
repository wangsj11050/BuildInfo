package org.tinygroup.buildinfo.business.impl;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.TsysOfficeDao;
import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysOffice;
import org.tinygroup.buildinfo.business.inter.SysOfficeBusiness;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public class SysOfficeBusinessImpl implements SysOfficeBusiness {
	
	private TsysOfficeDao tsysOfficeDao;

	public TsysOfficeDao gettsysOfficeDao() {
		return tsysOfficeDao;
	}

	public void settsysOfficeDao(TsysOfficeDao tsysOfficeDao) {
		this.tsysOfficeDao = tsysOfficeDao;
	}

	public TsysOffice getById(String officeCode) {
		return tsysOfficeDao.getByKey(officeCode);
	}

	public Pager<TsysOffice> getPager(int start, int limit, TsysOffice sysOffice,
			OrderBy... orderBies) {
		return tsysOfficeDao.queryPagerForSearch(start, limit, sysOffice, orderBies);
	}

	public TsysOffice add(TsysOffice sysOffice) {
		return tsysOfficeDao.add(sysOffice);
	}

	public int update(TsysOffice sysOffice) {
		return tsysOfficeDao.edit(sysOffice);
	}

	public int deleteByKeys(String... pks) {
		return tsysOfficeDao.deleteByKeys(pks);
	}

	public boolean checkExists(TsysOffice sysOffice) {
		return tsysOfficeDao.checkExist(sysOffice).size() == 0 ? false : true;
	}

	public List getOfficeTree(TreeData tree) {
		return tsysOfficeDao.getOfficeTree(tree);
	}

	public List getOfficeTreeByDep(TreeData tree) {
		return tsysOfficeDao.getOfficeTreeByDep(tree);
	}

	public List getOfficeList(TsysOffice office) {
		return tsysOfficeDao.query(office);
	}

}
