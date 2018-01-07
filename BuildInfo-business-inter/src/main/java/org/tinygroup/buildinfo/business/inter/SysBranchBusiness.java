package org.tinygroup.buildinfo.business.inter;

import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysBranch;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

import java.util.List;


/**
 * Created by Mr.wang on 2016/7/14.
 */
public interface SysBranchBusiness {
    TsysBranch getById(String branchCode);

    int deleteByKeys(String... pks);

    Pager<TsysBranch> getPager(int start, int limit, TsysBranch tsysBranch, final OrderBy... orderBies);

    TsysBranch add(TsysBranch tsysBranch);

    int update(TsysBranch tsysBranch);

    boolean checkExists(TsysBranch tsysBranch);

    List<TsysBranch> getList(TsysBranch tsysBranch);
    
    List getTreeData(TreeData tree);
    
//    boolean checkSubBranchExist(TsysBranch sysBranch);
}
