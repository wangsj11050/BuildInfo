package org.tinygroup.buildinfo.business.inter;

import org.tinygroup.buildinfo.dao.inter.pojo.TsysOffice;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysOfficeUser;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Mr.wang on 2016/7/21.
 */
public interface SysOfficeUserBusiness {
    TsysOfficeUser getById(Integer id);

    TsysOfficeUser add(TsysOfficeUser tsysOfficeUser);

    int update(TsysOfficeUser tsysOfficeUser);

    int deleteByKeys(Integer... pks);

    List<TsysOfficeUser> getSysOfficeList(TsysOfficeUser tsysOfficeUser);

    boolean updateUserOffices(String userCode, String[] officeId, String[] removeOfficeId);

    Pager<TsysOffice> queryOfficeInUser(int start, int limit, String userCode, TsysOffice tsysOffice, Boolean isAssign, OrderBy... orderArgs);

    boolean grantUserOffices(String userCode, String[] preAddOfficeId);

    boolean revokeUserOffices(String userCode, String[] preRemoveOfficeId);


}
