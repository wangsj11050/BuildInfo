package org.tinygroup.buildinfo.business.inter;

import org.tinygroup.buildinfo.dao.inter.pojo.TsysDictEntry;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;


/**
 * Created by Mr.wang on 2016/7/21.
 */
public interface SysDictEntryBusiness {
    TsysDictEntry getById(Integer id);

    int deleteByKeys(Integer... pks);

    Pager<TsysDictEntry> getPager(int start, int limit, TsysDictEntry tsysDictEntry, final OrderBy... orderBies);

    TsysDictEntry add(TsysDictEntry tsysDictEntry);

    int update(TsysDictEntry tsysDictEntry);

    boolean checkExists(TsysDictEntry tsysDictEntry);
}
