package org.tinygroup.buildinfo.business.impl;

import org.tinygroup.buildinfo.dao.inter.TsysDepDao;
import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysDep;
import org.tinygroup.buildinfo.business.inter.SysDepBusiness;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

import java.util.List;


/**
 * Created by Mr.wang on 2016/7/14.
 */
public class SysDepBusinessImpl implements SysDepBusiness{
    private TsysDepDao tsysDepDao;

    public TsysDepDao getTsysDepDao() {
        return tsysDepDao;
    }

    public void setTsysDepDao(TsysDepDao tsysDepDao) {
        this.tsysDepDao = tsysDepDao;
    }

    public TsysDep getById(String id) {
        return tsysDepDao.getByKey(id);
    }

    public int deleteByKeys(String... pks) {
        return tsysDepDao.deleteByKeys(pks);
    }

    public Pager<TsysDep> getPager(int start, int limit, TsysDep tsysDep, OrderBy... orderBies) {
        return tsysDepDao.searchPager(start, limit, tsysDep, orderBies);
    }

    public TsysDep add(TsysDep tsysDep) {
        return tsysDepDao.add(tsysDep);
    }

    public int update(TsysDep tsysDep) {
        return tsysDepDao.edit(tsysDep);
    }

    public boolean checkExists(TsysDep tsysDep) {
        return tsysDepDao.checkExist(tsysDep).size()>0?true:false;
    }

    public List getList(TsysDep tsysDep) {
        return tsysDepDao.query(tsysDep);
    }

	public List getTreeData(TreeData tree) {
		return tsysDepDao.getTreeData(tree);
	}

	public List getDepTreeByBranch(TreeData tree) {
		return tsysDepDao.getDepTreeByBranch(tree);
	}

}
