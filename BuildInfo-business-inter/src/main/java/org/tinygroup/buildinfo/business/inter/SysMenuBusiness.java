package org.tinygroup.buildinfo.business.inter;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysMenu;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang10692 on 2016/7/14.
 */
public interface SysMenuBusiness {
	TsysMenu getById(Integer id);

    Pager<TsysMenu> getPager(int start, int limit, TsysMenu sysMenu, final OrderBy... orderBies);

    TsysMenu add(TsysMenu sysMenu);

    int update(TsysMenu sysMenu);

    int deleteByKeys(Integer... pks);

    boolean checkExists(TsysMenu sysMenu);
    
    List<TsysMenu> getMenuInfos(TsysMenu sysMenu);

	List getMenuTree(TreeData tree);

    List<Integer> getSubTransIds(String userCode);

    List getSysMenuList(TsysMenu tsysMenu);

    List<Integer> findMenuIdsByUser(String userCode, OrderBy... orderArgs);
    
    List<Integer> findAppMenuIds(TsysMenu sysMenu);

}
