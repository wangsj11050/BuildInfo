package org.tinygroup.buildinfo.ext.dao.impl;

import org.tinygroup.buildinfo.ext.dao.inter.pojo.TsysUserRight;
import org.tinygroup.buildinfo.dao.inter.pojo.complex.TRightRef;
import org.tinygroup.buildinfo.ext.dao.inter.TUserRightRefDealDao;
import org.tinygroup.jdbctemplatedslsession.callback.DeleteGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.SelectGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.util.TinyDSLUtil;
import org.tinygroup.tinysqldsl.Delete;
import org.tinygroup.tinysqldsl.Pager;
import org.tinygroup.tinysqldsl.Select;
import org.tinygroup.tinysqldsl.formitem.SubSelect;
import org.tinygroup.tinysqldsl.selectitem.Distinct;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.tinygroup.buildinfo.ext.dao.inter.constant.TsysUserRightTable.TSYS_USER_RIGHT_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Select.select;
import static org.tinygroup.tinysqldsl.formitem.SubSelect.subSelect;
import static org.tinygroup.buildinfo.dao.inter.constant.TsysMenuTable.TSYS_MENU_TABLE;

/**
 * Created by Administrator on 2016/10/26.
 */
public class TUserRightRefDealDaoImpl extends TsysUserRightDaoImpl implements TUserRightRefDealDao{

    public int[] grantRightsgrantRights(String userId,Integer[] menuIds, String createBy) {
        return null;
    }

    /**
     * 获取用户权限
     * @param start
     * @param pageSize
     * @param userId
     * @param tRightRef
     * @param isAssigned
     * @return
     */
    public Pager queryRightsInUser(int start, int pageSize, String userId, TRightRef tRightRef, final Boolean isAssigned) {
        if (tRightRef == null) {
            tRightRef = new TRightRef();
        }
        SubSelect condition = subSelect(select(Distinct.distinct(TSYS_USER_RIGHT_TABLE.MENU_ID))
                .from(TSYS_USER_RIGHT_TABLE).where(TSYS_USER_RIGHT_TABLE.USER_ID.eq(userId)));
        final SubSelect finalCondition = condition;
        return getDslTemplate().queryPager(start, pageSize, tRightRef, false,
                new SelectGenerateCallback<TRightRef>() {
                    public Select generate(TRightRef t) {
                        Select select = select(
                                TSYS_MENU_TABLE.MENU_NAME,
                                TSYS_MENU_TABLE.KIND_CODE,
                                TSYS_MENU_TABLE.ID
                        ).from(TSYS_MENU_TABLE).where(
                                isAssigned?TSYS_MENU_TABLE.ID.inExpression(finalCondition)
                                        :TSYS_MENU_TABLE.ID.notInExpression(finalCondition)
                                        .and(TSYS_MENU_TABLE.MENU_NAME.like(t.getMenuName()))
                                        .and(TSYS_MENU_TABLE.KIND_CODE.like(t.getKindCode()))
                        );
                        return TinyDSLUtil
                                .addOrderByElements(select);
                    }

                });
    }

    public int[] grantRights(String userId,Integer[] menuIds, String createBy) {
        List<TsysUserRight> list = new ArrayList<TsysUserRight>();
        for (int i = 0;i < menuIds.length;i++) {
            TsysUserRight tsysUserRight = new TsysUserRight();
            tsysUserRight.setUserId(userId);
            tsysUserRight.setCreateBy(createBy);
            tsysUserRight.setMenuId(menuIds[i]);
            tsysUserRight.setRightFlag("1");//权限表示,1:操作,2:授权
            list.add(tsysUserRight);
        }
        return batchInsert(list);
    }

    /**
     * 取消用户的权限
     * @param userCode
     * @param menuIds
     * @return
     */
    public int revokeRights(String userCode,Integer... menuIds) {

        return deleteRightsByKeys(userCode,menuIds);
    }
    /**
     * 取消权限
     * @param menuIds 菜单编号
     * @param userId  用户编号
     */
    private int deleteRightsByKeys(final String userId, final Integer... menuIds) {
        if(menuIds == null || menuIds.length == 0 || userId ==null || userId.trim().length()==0){
            return 0;
        }
        return getDslTemplate().deleteByKeys(new DeleteGenerateCallback<Serializable[]>() {
            public Delete generate(Serializable[] t) {
                return delete(TSYS_USER_RIGHT_TABLE).where(TSYS_USER_RIGHT_TABLE.USER_ID.eq(userId)
                        .and(TSYS_USER_RIGHT_TABLE.MENU_ID.in(menuIds)));
            }
        },menuIds);
    }
}
