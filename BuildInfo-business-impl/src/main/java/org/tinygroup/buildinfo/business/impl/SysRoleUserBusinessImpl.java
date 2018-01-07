package org.tinygroup.buildinfo.business.impl;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.TsysRoleUserDao;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysRightRef;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysRole;
import org.tinygroup.buildinfo.dao.inter.pojo.complex.RoleUserRef;
import org.tinygroup.buildinfo.business.inter.SysRoleUserBusiness;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang on 2016/7/23.
 */
public class SysRoleUserBusinessImpl implements SysRoleUserBusiness{
    private TsysRoleUserDao tsysRoleUserDao;

    public TsysRoleUserDao getTsysRoleUserDao() {
        return tsysRoleUserDao;
    }

    public void setTsysRoleUserDao(TsysRoleUserDao tsysRoleUserDao) {
        this.tsysRoleUserDao = tsysRoleUserDao;
    }

    public TsysRightRef getById(Integer id) {
        return tsysRoleUserDao.getByKey(id);
    }

    public TsysRightRef add(TsysRightRef tsysRoleUser) {
        return tsysRoleUserDao.add(tsysRoleUser);
    }

    public int update(TsysRightRef tsysRoleUser) {
        return tsysRoleUserDao.edit(tsysRoleUser);
    }

    public int deleteByKeys(Integer... pks) {
        return tsysRoleUserDao.deleteByKeys(pks);
    }

    public List<TsysRightRef> getSysUserRoleList(TsysRightRef tsysRoleUser) {
        return tsysRoleUserDao.query(tsysRoleUser);
    }

    public boolean grantRoles(String userCode, Integer[] preAddRoleId) {
        tsysRoleUserDao.grantRoles(userCode,preAddRoleId);
        return true;
    }

    public boolean revokeRoles(String userCode, Integer[] preRemoveRoleId) {
        tsysRoleUserDao.revokeRoles(userCode,preRemoveRoleId);
        return true;
    }

    public Pager<RoleUserRef> queryRoleInUser(int start, int limit, String userCode, RoleUserRef roleUserRef, Boolean isAssign,
                                           Integer assignFlag,OrderBy... orderArgs) {
        return tsysRoleUserDao.queryRolesInUser(start,10000,userCode,roleUserRef,isAssign,assignFlag,orderArgs);
    }
}
