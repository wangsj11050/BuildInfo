package org.tinygroup.buildinfo.ext.dao.inter;


import org.tinygroup.buildinfo.dao.inter.pojo.complex.TRightRef;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Administrator on 2016/10/26.
 */
public interface TUserRightRefDealDao {

    int[] grantRights(String userId,Integer[] menuIds, String createBy);

    int revokeRights(String userCode,Integer... menuIds);

    Pager<TRightRef> queryRightsInUser(int start, int pageSize,
                                       String userId, TRightRef tRightRef, final Boolean isAssigned);

}
