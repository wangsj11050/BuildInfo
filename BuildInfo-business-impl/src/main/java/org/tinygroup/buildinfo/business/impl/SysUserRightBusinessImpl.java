package org.tinygroup.buildinfo.business.impl;

import org.tinygroup.buildinfo.dao.inter.pojo.complex.TRightRef;
import org.tinygroup.buildinfo.ext.dao.inter.TUserRightRefDealDao;
import org.tinygroup.buildinfo.ext.dao.inter.TsysUserRightDao;
import org.tinygroup.buildinfo.ext.dao.inter.pojo.TsysUserRight;
import org.tinygroup.buildinfo.business.inter.SysUserRightBusiness;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public class SysUserRightBusinessImpl implements SysUserRightBusiness {
	private TsysUserRightDao tsysUserRightDao;

	private TUserRightRefDealDao tUserRightRefDealDao;
	
	public TsysUserRightDao getTsysUserRightDao() {
		return tsysUserRightDao;
	}

	public void setTsysUserRightDao(TsysUserRightDao tsysUserRightDao) {
		this.tsysUserRightDao = tsysUserRightDao;
	}

	public TUserRightRefDealDao gettUserRightRefDealDao() {
		return tUserRightRefDealDao;
	}

	public void settUserRightRefDealDao(TUserRightRefDealDao tUserRightRefDealDao) {
		this.tUserRightRefDealDao = tUserRightRefDealDao;
	}

	public TsysUserRight getById(Integer id) {
		return tsysUserRightDao.getByKey(id);
	}

	public Pager<TsysUserRight> getPager(int start, int limit,
										 TsysUserRight sysUserRight, OrderBy... orderBies) {
		return tsysUserRightDao.queryPager(start, 10000, sysUserRight, orderBies);
	}

	public TsysUserRight add(TsysUserRight sysUserRight) {
		return tsysUserRightDao.add(sysUserRight);
	}

	public int update(TsysUserRight sysUserRight) {
		return tsysUserRightDao.edit(sysUserRight);
	}

	public int deleteByKeys(Integer... pks) {
		return tsysUserRightDao.deleteByKeys(pks);
	}

	public boolean checkExists(TsysUserRight sysUserRight) {
		return tsysUserRightDao.query(sysUserRight).size() == 0 ? false : true;
	}

	public int[] grantRights(String userId,Integer[] menuIds, String createBy) {
		return tUserRightRefDealDao.grantRights(userId,menuIds, createBy);
	}

	public int revokeRights(String userCode,Integer[] userRightIds) {
		return tUserRightRefDealDao.revokeRights(userCode,userRightIds);
	}

	public Pager<TRightRef> queryRightsInUser(int start, int pageSize, String roleCode, TRightRef tRightRef, Boolean isAssigned) {
		return tUserRightRefDealDao.queryRightsInUser(start,10000,roleCode,tRightRef,isAssigned);
	}

}
