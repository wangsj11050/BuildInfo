package org.tinygroup.buildinfo.business.impl;

import org.tinygroup.buildinfo.dao.inter.TsysDictEntryDao;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysDictEntry;
import org.tinygroup.buildinfo.business.inter.SysDictEntryBusiness;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang on 2016/7/14.
 */
public class SysDictEntryBusinessImpl implements SysDictEntryBusiness{
    private TsysDictEntryDao tsysDictEntryDao;

    public TsysDictEntryDao getTsysDictEntryDao() {
        return tsysDictEntryDao;
    }

    public void setTsysDictEntryDao(TsysDictEntryDao tsysDictEntryDao) {
        this.tsysDictEntryDao = tsysDictEntryDao;
    }

    public TsysDictEntry getById(Integer id) {
        return tsysDictEntryDao.getByKey(id);
    }

    public int deleteByKeys(Integer... pks) {
        return tsysDictEntryDao.deleteByKeys(pks);
    }

    public Pager<TsysDictEntry> getPager(int start, int limit, TsysDictEntry tsysUser, OrderBy... orderBies) {
        return tsysDictEntryDao.queryPagerForSearch(start, limit, tsysUser, orderBies);
    }

    public TsysDictEntry add(TsysDictEntry tsysUser) {
        return tsysDictEntryDao.add(tsysUser);
    }

    public int update(TsysDictEntry tsysUser) {
        return tsysDictEntryDao.edit(tsysUser);
    }

    public boolean checkExists(TsysDictEntry tsysUser) {
        return tsysDictEntryDao.checkExist(tsysUser).size()>0?true:false;
    }
}
