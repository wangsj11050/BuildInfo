package org.tinygroup.buildinfo.business.impl;

import org.tinygroup.buildinfo.dao.inter.TsysDictItemDao;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysDictItem;
import org.tinygroup.buildinfo.business.inter.SysDictItemBusiness;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang on 2016/7/14.
 */
public class SysDictItemBusinessImpl implements SysDictItemBusiness{
    private TsysDictItemDao tsysDictItemDao;

    public TsysDictItemDao getTsysDictItemDao() {
        return tsysDictItemDao;
    }

    public void setTsysDictItemDao(TsysDictItemDao tsysDictItemDao) {
        this.tsysDictItemDao = tsysDictItemDao;
    }

    public TsysDictItem getById(Integer id) {
        return tsysDictItemDao.getByKey(id);
    }

    public int deleteByKeys(Integer... pks) {
        return tsysDictItemDao.deleteByKeys(pks);
    }

    public Pager<TsysDictItem> getPager(int start, int limit, TsysDictItem tsysUser, OrderBy... orderBies) {
        return tsysDictItemDao.queryPagerForSearch(start, limit, tsysUser, orderBies);
    }

    public TsysDictItem add(TsysDictItem tsysUser) {
        return tsysDictItemDao.add(tsysUser);
    }

    public int update(TsysDictItem tsysUser) {
        return tsysDictItemDao.edit(tsysUser);
    }

    public boolean checkExists(TsysDictItem tsysUser) {
        return tsysDictItemDao.checkExist(tsysUser).size()>0?true:false;
    }
}
