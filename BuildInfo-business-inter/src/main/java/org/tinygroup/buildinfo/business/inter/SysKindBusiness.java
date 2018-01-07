package org.tinygroup.buildinfo.business.inter;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysKind;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang10692 on 2016/7/14.
 */
public interface SysKindBusiness {
	TsysKind getById(String kindCode);

    Pager<TsysKind> getPager(int start, int limit, TsysKind sysKind, final OrderBy... orderBies);

    TsysKind add(TsysKind sysKind);

    int update(TsysKind sysKind);

    int deleteByKeys(String... pks);

    boolean checkExists(TsysKind sysKind);
    
    List getKindTree(TreeData tree);
    
    List getKindsList(TsysKind sysKind);
}
