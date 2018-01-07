package org.tinygroup.buildinfo.business.inter;

import org.tinygroup.buildinfo.dao.inter.pojo.TsysDictItem;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;


/**
 * Created by Mr.wang on 2016/7/21.
 */
public interface SysDictItemBusiness {
    TsysDictItem getById(Integer id);

    int deleteByKeys(Integer... pks);

    Pager<TsysDictItem> getPager(int start, int limit, TsysDictItem tsysDictItem, final OrderBy... orderBies);

    TsysDictItem add(TsysDictItem tsysDictItem);

    int update(TsysDictItem tsysDictItem);

    boolean checkExists(TsysDictItem tsysDictItem);
}
