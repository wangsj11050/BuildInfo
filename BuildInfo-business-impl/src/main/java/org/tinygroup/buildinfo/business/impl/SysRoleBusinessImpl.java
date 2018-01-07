package org.tinygroup.buildinfo.business.impl;

import org.tinygroup.buildinfo.dao.inter.TsysRoleDao;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysRole;
import org.tinygroup.buildinfo.business.inter.SysRoleBusiness;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

import java.util.List;

/**
 * Created by Mr.wang on 2016/7/7.
 */
public class SysRoleBusinessImpl implements SysRoleBusiness{
    private TsysRoleDao tsysRoleDao;

	public TsysRoleDao getTsysRoleDao() {
		return tsysRoleDao;
	}

	public void setTsysRoleDao(TsysRoleDao tsysRoleDao) {
		this.tsysRoleDao = tsysRoleDao;
	}

	public Pager<TsysRole> getPager(int start, int limit, TsysRole role,
			OrderBy... orderBies) {
		 return tsysRoleDao.queryPagerForSearch(start,limit,role,orderBies);
	}

	public TsysRole add(TsysRole role) {
		return tsysRoleDao.add(role);
	}

	public int update(TsysRole role) {
		return tsysRoleDao.edit(role);
	}

	public boolean checkExists(TsysRole role) {
		return tsysRoleDao.checkExist(role).size()==0?false:true;
	}

	public List<TsysRole> getList(TsysRole role, OrderBy... orderBies) {
		return tsysRoleDao.query(role,orderBies);
	}

	public TsysRole getById(Integer id) {
		return tsysRoleDao.getByKey(id);
	}

	public int deleteByKeys(Integer... pks) {
		return tsysRoleDao.deleteByKeys(pks);
	}

}
