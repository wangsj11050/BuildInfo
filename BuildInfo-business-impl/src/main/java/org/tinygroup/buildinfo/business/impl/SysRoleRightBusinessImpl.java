package org.tinygroup.buildinfo.business.impl;

import org.tinygroup.buildinfo.ext.dao.inter.TRoleRightRefDealDao;
import org.tinygroup.buildinfo.ext.dao.inter.TsysRoleRightDao;
import org.tinygroup.buildinfo.dao.inter.pojo.complex.TRightRef;
import org.tinygroup.buildinfo.ext.dao.inter.pojo.TsysRoleRight;
import org.tinygroup.buildinfo.business.inter.SysRoleRightBusiness;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public class SysRoleRightBusinessImpl implements SysRoleRightBusiness {
	private TsysRoleRightDao tsysRoleRightDao;

	private TRoleRightRefDealDao tRoleRightRefDealDao;

	public TsysRoleRightDao getTsysRoleRightDao() {
		return tsysRoleRightDao;
	}

	public void setTsysRoleRightDao(TsysRoleRightDao tsysRoleRightDao) {
		this.tsysRoleRightDao = tsysRoleRightDao;
	}

	public TRoleRightRefDealDao gettRoleRightRefDealDao() {
		return tRoleRightRefDealDao;
	}

	public void settRoleRightRefDealDao(TRoleRightRefDealDao tRoleRightRefDealDao) {
		this.tRoleRightRefDealDao = tRoleRightRefDealDao;
	}

	public TsysRoleRight getById(Integer id) {
		return tsysRoleRightDao.getByKey(id);
	}

	public Pager<TsysRoleRight> getPager(int start, int limit,
			TsysRoleRight sysRoleRight, OrderBy... orderBies) {
		return tsysRoleRightDao.queryPager(start, limit, sysRoleRight, orderBies);
	}

	public TsysRoleRight add(TsysRoleRight sysRoleRight) {
		return tsysRoleRightDao.add(sysRoleRight);
	}

	public int update(TsysRoleRight sysRoleRight) {
		return tsysRoleRightDao.edit(sysRoleRight);
	}

	public int deleteByKeys(Integer... pks) {
		return tsysRoleRightDao.deleteByKeys(pks);
	}

	public boolean checkExists(TsysRoleRight sysRoleRight) {
		return tsysRoleRightDao.query(sysRoleRight).size() == 0 ? false : true;
	}

	public Pager queryRightsInRole(int start, int pageSize, Integer roleId, TRightRef tRightRef, Boolean isAssigned) {
		return tRoleRightRefDealDao.queryRightsInRole(start,10000,roleId,tRightRef,isAssigned);
	}

	public boolean grantRights(Integer roleId,Integer[] menuIds, String createBy) {
		tRoleRightRefDealDao.grantRights(roleId,menuIds, createBy);
		return true;
	}

	public boolean revokeRights(Integer roleId,Integer[] roleRightIds){
		int count = tRoleRightRefDealDao.revokeRights(roleId,roleRightIds);
		if(count > 0){
			return true;
		}else{
			return false;
		}
	}

}
