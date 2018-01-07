package org.tinygroup.buildinfo.business.impl;

import org.tinygroup.buildinfo.dao.inter.TsysUserLoginDao;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysUser;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysUserLogin;
import org.tinygroup.buildinfo.business.inter.SysUserLoginBusiness;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang on 2016/7/14.
 */
public class SysUserLoginBusinessImpl implements SysUserLoginBusiness{
    private TsysUserLoginDao tsysUserLoginDao;

    public TsysUserLoginDao getTsysUserLoginDao() {
        return tsysUserLoginDao;
    }

    public void setTsysUserLoginDao(TsysUserLoginDao tsysUserLoginDao) {
        this.tsysUserLoginDao = tsysUserLoginDao;
    }

    public TsysUserLogin getById(String id) {
        return tsysUserLoginDao.getByKey(id);
    }

    public int deleteByKeys(String... pks) {
        return tsysUserLoginDao.deleteByKeys(pks);
    }

    public Pager<TsysUserLogin> getPager(int start, int limit, TsysUserLogin tsysUser, OrderBy... orderBies) {
        return tsysUserLoginDao.queryPager(start, limit, tsysUser, orderBies);
    }

    public TsysUserLogin add(TsysUserLogin tsysUser) {
        return tsysUserLoginDao.add(tsysUser);
    }

    public int update(TsysUserLogin tsysUser) {
        return tsysUserLoginDao.edit(tsysUser);
    }

    public boolean checkExists(TsysUserLogin tsysUser) {
        return tsysUserLoginDao.query(tsysUser).size()>0?true:false;
    }

    public TsysUserLogin getByUser(TsysUser tsysUser) {
        return tsysUserLoginDao.queryByUser(tsysUser);
    }
}
