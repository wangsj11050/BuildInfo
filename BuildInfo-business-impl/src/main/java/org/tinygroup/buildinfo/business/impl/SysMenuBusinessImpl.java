package org.tinygroup.buildinfo.business.impl;

import java.util.*;

import org.tinygroup.buildinfo.dao.inter.TsysMenuDao;
import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysMenu;
import org.tinygroup.buildinfo.business.inter.SysMenuBusiness;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public class SysMenuBusinessImpl implements SysMenuBusiness {
	private TsysMenuDao tsysMenuDao;
	

	public TsysMenuDao getTsysMenuDao() {
		return tsysMenuDao;
	}

	public void setTsysMenuDao(TsysMenuDao tsysMenuDao) {
		this.tsysMenuDao = tsysMenuDao;
	}

	public TsysMenu getById(Integer id) {
		return tsysMenuDao.getByKey(id);
	}

	public Pager<TsysMenu> getPager(int start, int limit,
			TsysMenu sysMenu, OrderBy... orderBies) {
		return tsysMenuDao.queryPagerForSearch(start, limit, sysMenu, orderBies);
	}

	public TsysMenu add(TsysMenu sysMenu) {
		return tsysMenuDao.add(sysMenu);
	}

	public int update(TsysMenu sysMenu) {
		return tsysMenuDao.edit(sysMenu);
	}

	public int deleteByKeys(Integer... pks) {
		return tsysMenuDao.deleteByKeys(pks);
	}

	public boolean checkExists(TsysMenu sysMenu) {
		return tsysMenuDao.checkExist(sysMenu).size() == 0 ? false : true;
	}

	public List<TsysMenu> getMenuInfos(TsysMenu sysMenu) {
		return tsysMenuDao.query(sysMenu);
	}

	public List getMenuTree(TreeData tree) {
		return tsysMenuDao.getMenuTree(tree);
	}

	public List<Integer> getSubTransIds(String userCode) {
		return tsysMenuDao.findSubTransIdByUser(userCode);
	}



	public List getSysMenuList(TsysMenu tsysMenu) {
		return tsysMenuDao.query(tsysMenu);
	}

	public List<Integer> findMenuIdsByUser(String userCode, OrderBy... orderArgs) {
//		OrderBy orderBy = new OrderBy("menu_id",true);
		return tsysMenuDao.findMenuIdsByUser(userCode);
	}

	@Override
	public List<Integer> findAppMenuIds(TsysMenu sysMenu) {
		// TODO Auto-generated method stub
		return tsysMenuDao.findAppMenuIds(sysMenu);
	}

}
