package org.tinygroup.buildinfo.business.impl;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.dao.inter.TsysOfficeUserDao;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysOffice;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysOfficeUser;
import org.tinygroup.buildinfo.business.inter.SysOfficeUserBusiness;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Mr.wang on 2016/7/21.
 */
public class SysOfficeUserBusinessImpl implements SysOfficeUserBusiness{
    private TsysOfficeUserDao tsysOfficeUserDao;

    public TsysOfficeUserDao getTsysOfficeUserDao() {
        return tsysOfficeUserDao;
    }

    public void setTsysOfficeUserDao(TsysOfficeUserDao tsysOfficeUserDao) {
        this.tsysOfficeUserDao = tsysOfficeUserDao;
    }

    public TsysOfficeUser getById(Integer id) {
        return tsysOfficeUserDao.getByKey(id);
    }

    public TsysOfficeUser add(TsysOfficeUser tsysOfficeUser) {
        return tsysOfficeUserDao.add(tsysOfficeUser);
    }

    public int update(TsysOfficeUser tsysOfficeUser) {
        return tsysOfficeUserDao.edit(tsysOfficeUser);
    }

    public int deleteByKeys(Integer... pks) {
        return tsysOfficeUserDao.deleteByKeys(pks);
    }

    public List<TsysOfficeUser> getSysOfficeList(TsysOfficeUser tsysOfficeUser) {
        return tsysOfficeUserDao.query(tsysOfficeUser);
    }

    public Pager<TsysOffice> queryOfficeInUser(int start, int limit, String userCode, TsysOffice tsysOffice, Boolean isAssign, OrderBy... orderArgs) {
        return tsysOfficeUserDao.queryOfficeInUser(start,10000,userCode,tsysOffice,isAssign,orderArgs);
    }

    public boolean updateUserOffices(String userCode, String[] officeId, String[] removeOfficeId) {
        if(officeId==null) return false;
        tsysOfficeUserDao.revokeUserOffices(userCode,officeId);
        tsysOfficeUserDao.grantUserOfficeBatch(userCode,officeId);
        return false;
    }

    public boolean grantUserOffices(String userCode, String[] preAddOfficeId) {
        tsysOfficeUserDao.grantUserOfficeBatch(userCode,preAddOfficeId);
        return true;
    }

    public boolean revokeUserOffices(String userCode, String[] preRemoveOfficeId) {
        tsysOfficeUserDao.revokeUserOffices(userCode,preRemoveOfficeId);
        return true;
    }

}
