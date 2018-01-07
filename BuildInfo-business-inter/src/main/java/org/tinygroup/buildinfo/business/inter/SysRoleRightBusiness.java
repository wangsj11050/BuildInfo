package org.tinygroup.buildinfo.business.inter;

import org.tinygroup.buildinfo.ext.dao.inter.pojo.TsysRoleRight;
import org.tinygroup.buildinfo.dao.inter.pojo.complex.TRightRef;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang10692 on 2016/7/14.
 */
public interface SysRoleRightBusiness {
	TsysRoleRight getById(Integer id);

    Pager<TsysRoleRight> getPager(int start, int limit, TsysRoleRight sysRoleRight, final OrderBy... orderBies);

    TsysRoleRight add(TsysRoleRight sysRoleRight);

    int update(TsysRoleRight sysRoleRight);

    int deleteByKeys(Integer... pks);

    boolean checkExists(TsysRoleRight sysRoleRight);

    Pager queryRightsInRole(int start, int pageSize, Integer roleId, TRightRef tRightRef, Boolean isAssigned);

    boolean grantRights(Integer roleId,Integer[] menuIds, String createBy);

    boolean revokeRights(Integer roleId,Integer[] roleRightIds);
}
