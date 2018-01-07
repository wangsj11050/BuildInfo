package org.tinygroup.buildinfo.ext.dao.inter;

import org.tinygroup.buildinfo.dao.inter.pojo.complex.TRightRef;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Administrator on 2016/10/26.
 */
public interface TRoleRightRefDealDao {
    Pager queryRightsInRole(int start, int pageSize, Integer roleId, TRightRef tRightRef, Boolean isAssigned);

    int[] grantRights(Integer roleId,Integer[] menuIds, String createBy);

    int revokeRights(Integer roleId,Integer[] menuIds);
}
