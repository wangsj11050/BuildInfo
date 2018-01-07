package org.tinygroup.buildinfo.business.inter;

import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysDep;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

import java.util.List;

/**
 * Created by Mr.wang on 2016/7/14.
 */
public interface SysDepBusiness {
    TsysDep getById(String id);

    int deleteByKeys(String... pks);

    Pager<TsysDep> getPager(int start, int limit, TsysDep tsysDep, final OrderBy... orderBies);

    TsysDep add(TsysDep tsysDep);

    int update(TsysDep tsysDep);

    boolean checkExists(TsysDep tsysDep);

    List getList(TsysDep tsysDep);
    
    List getTreeData(TreeData tree);
    
    List getDepTreeByBranch(TreeData tree);
    
}
