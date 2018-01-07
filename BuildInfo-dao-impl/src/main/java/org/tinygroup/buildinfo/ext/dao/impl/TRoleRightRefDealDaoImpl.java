package org.tinygroup.buildinfo.ext.dao.impl;

import org.tinygroup.buildinfo.dao.inter.pojo.complex.TRightRef;
import org.tinygroup.buildinfo.ext.dao.inter.TRoleRightRefDealDao;
import org.tinygroup.buildinfo.ext.dao.inter.pojo.TsysRoleRight;
import org.tinygroup.jdbctemplatedslsession.callback.DeleteGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.NoParamDeleteGenerateCallback;
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

import static org.tinygroup.buildinfo.dao.inter.constant.TsysMenuTable.TSYS_MENU_TABLE;
import static org.tinygroup.buildinfo.ext.dao.inter.constant.TsysRoleRightTable.TSYS_ROLE_RIGHT_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Select.select;
import static org.tinygroup.tinysqldsl.formitem.SubSelect.subSelect;

/**
 * Created by Administrator on 2016/10/26.
 */
public class TRoleRightRefDealDaoImpl extends TsysRoleRightDaoImpl implements TRoleRightRefDealDao{
    public int[] revokeRoleRights(String roleCode, List<String> preRemoveRights) {
        final List<String> removeOfficeCpId = preRemoveRights;
        final String roleCodeCp = roleCode;
        return getDslTemplate().batchDelete(removeOfficeCpId,new NoParamDeleteGenerateCallback(){
            public Delete generate() {
                return null;
            }
        });
    }

    public int[] revokeRoleRights(Integer roleId, String[] preAddOfficeIds) {
        List<TsysRoleRight> list = new ArrayList<TsysRoleRight>();
        for(String officeId: preAddOfficeIds){
            TsysRoleRight tsysRoleRight = new TsysRoleRight();
            tsysRoleRight.setRoleId(roleId);
        }
        return batchInsert(list);
    }


    public Pager queryRightsInRole(int start, int pageSize, Integer roleId, TRightRef tRightRef,final Boolean isAssigned) {
        if (tRightRef == null) {
            tRightRef = new TRightRef();
        }
        SubSelect condition = subSelect(select(Distinct.distinct(TSYS_ROLE_RIGHT_TABLE.MENU_ID))
                .from(TSYS_ROLE_RIGHT_TABLE)
                .where(TSYS_ROLE_RIGHT_TABLE.ROLE_ID.eq(roleId)));
        final SubSelect finalCondition = condition;
        return getDslTemplate().queryPager(start, pageSize, tRightRef, false,
                new SelectGenerateCallback<TRightRef>() {
                    public Select generate(TRightRef t) {
                        Select select = select(
                                TSYS_MENU_TABLE.MENU_NAME,
                                TSYS_MENU_TABLE.KIND_CODE,
                                TSYS_MENU_TABLE.ID)
                                .from(TSYS_MENU_TABLE)
                                .where(
                                        isAssigned?TSYS_MENU_TABLE.ID.inExpression(finalCondition)
                                                :TSYS_MENU_TABLE.ID.notInExpression(finalCondition)
                                        .and(TSYS_MENU_TABLE.MENU_NAME.eq(t.getMenuName()))
                                        .and(TSYS_MENU_TABLE.KIND_CODE.eq(t.getKindCode()))
                                );
                        return TinyDSLUtil.addOrderByElements(select);
                    }

                });
    }
    public int[] grantRights(Integer roleId,Integer[] menuIds, String createBy) {
        List<TsysRoleRight> list = new ArrayList<TsysRoleRight>();
        for (int i = 0;i < menuIds.length;i++) {
            TsysRoleRight tsysRoleRight = new TsysRoleRight();
            tsysRoleRight.setMenuId(menuIds[i]);
            tsysRoleRight.setRoleId(roleId);
            tsysRoleRight.setCreateBy(createBy);
            tsysRoleRight.setRightFlag("1");//权限表示,1:操作,2:授权
            list.add(tsysRoleRight);
        }
        return batchInsert(list);
    }
    /**
     * 取消角色的权限
     */
    public int revokeRights(Integer roleId,Integer[] menuIds) {
        return deleteRightsByKeys(roleId,menuIds);
    }
    /**
     * 取消权限
     * @param menuIds 菜单编号
     * @param roleId  角色编号
     */
    private int deleteRightsByKeys(final Integer roleId, final Integer... menuIds) {
        if(menuIds == null || menuIds.length == 0 || roleId ==null){
            return 0;
        }
        return getDslTemplate().deleteByKeys(new DeleteGenerateCallback<Serializable[]>() {
            public Delete generate(Serializable[] t) {
                return delete(TSYS_ROLE_RIGHT_TABLE).where(TSYS_ROLE_RIGHT_TABLE.ROLE_ID.eq(roleId)
                        .and(TSYS_ROLE_RIGHT_TABLE.MENU_ID.in(menuIds)));
            }
        },menuIds);
    }
}
