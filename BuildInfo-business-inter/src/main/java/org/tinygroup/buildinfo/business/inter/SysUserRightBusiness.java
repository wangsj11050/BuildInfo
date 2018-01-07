package org.tinygroup.buildinfo.business.inter;

import org.tinygroup.buildinfo.dao.inter.pojo.complex.TRightRef;
import org.tinygroup.buildinfo.ext.dao.inter.pojo.TsysUserRight;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang10692 on 2016/7/14.
 */
public interface SysUserRightBusiness {
	TsysUserRight getById(Integer id);

    Pager<TsysUserRight> getPager(int start, int limit, TsysUserRight sysUserRight, final OrderBy... orderBies);

    TsysUserRight add(TsysUserRight sysUserRight);

    int update(TsysUserRight sysUserRight);

    int deleteByKeys(Integer... pks);

    boolean checkExists(TsysUserRight sysUserRight);

    int[] grantRights(String userId,Integer[] menuIds, String createBy);

    int revokeRights(String userCode,Integer[] subTransIds);

    Pager<TRightRef> queryRightsInUser(int start, int pageSize, String roleCode, TRightRef tRightRef, Boolean isAssigned);



}
