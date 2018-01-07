package org.tinygroup.buildinfo.business.inter;

import org.tinygroup.buildinfo.dao.inter.pojo.TsysRole;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

import java.util.List;

/**
 * Created by Mr.wang on 2016/7/7.
 */
public interface SysRoleBusiness {
    TsysRole getById(Integer id);

    Pager<TsysRole> getPager(int start, int limit, TsysRole role, final OrderBy... orderBies);

    TsysRole add(TsysRole role);

    int update(TsysRole role);

    int deleteByKeys(Integer... pks);

    boolean checkExists(TsysRole role);

    List<TsysRole> getList(TsysRole role, final OrderBy... orderBies);
}
