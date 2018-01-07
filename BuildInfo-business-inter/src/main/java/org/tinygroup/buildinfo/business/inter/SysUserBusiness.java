package org.tinygroup.buildinfo.business.inter;

import org.tinygroup.buildinfo.dao.inter.pojo.TsysOfficeUser;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysUser;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

import java.util.List;

/**
 * Created by Mr.wang on 2016/7/14.
 */
public interface SysUserBusiness {
    TsysUser getById(String id);

    List<TsysUser> getUserByIds(String[] ids);
    
    int deleteByKeys(String... pks);

    Pager<TsysUser> getPager(int start, int limit, TsysUser tsysUser, final OrderBy... orderBies);

    TsysUser add(TsysUser tsysUser);

    int update(TsysUser tsysUser);

    boolean checkExists(TsysUser tsysUser);

    List<TsysOfficeUser> getTsysOfficeUserList(TsysOfficeUser tsysOfficeUser);

    Pager getAllInfoPager(int start, int pageSize, TsysUser sysUser);
    
    int updateLockStatusByKeys(String[] pks,String lockStatus);

    int resetPwd(String defaultPwd, String... userIds);

    public List<String> findPermissions(String userId);
    
    boolean validate(String userName, String password);
}
