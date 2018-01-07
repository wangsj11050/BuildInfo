package org.tinygroup.buildinfo.business.inter;

import org.tinygroup.buildinfo.dao.inter.pojo.TsysUser;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysUserLogin;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;


/**
 * Created by Mr.wang on 2016/7/14.
 */
public interface SysUserLoginBusiness {
    TsysUserLogin getById(String id);

    int deleteByKeys(String... pks);

    Pager<TsysUserLogin> getPager(int start, int limit, TsysUserLogin tsysUserLogin, final OrderBy... orderBies);

    TsysUserLogin add(TsysUserLogin tsysUserLogin);

    int update(TsysUserLogin tsysUserLogin);

    boolean checkExists(TsysUserLogin tsysUserLogin);

    TsysUserLogin getByUser(TsysUser sysUser);
}
