package org.tinygroup.buildinfo.business.inter;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.TsysRightRef;
import org.tinygroup.buildinfo.dao.inter.pojo.complex.RoleUserRef;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang on 2016/7/21.
 */
public interface SysRoleUserBusiness {
    TsysRightRef getById(Integer id);

    TsysRightRef add(TsysRightRef tsysRoleUser);

    int update(TsysRightRef tsysRoleUser);

    int deleteByKeys(Integer... pks);

    List<TsysRightRef> getSysUserRoleList(TsysRightRef tsysRoleUser);

    boolean grantRoles(String userCode,Integer[] preAddRoleId);

    boolean revokeRoles(String userCode, Integer[] preRemoveRoleId);

    Pager<RoleUserRef> queryRoleInUser(int start, int limit, String userCode, RoleUserRef roleUserRef, Boolean isAssign,
                                    Integer assignFlag,OrderBy... orderArgs);



}
