package org.tinygroup.buildinfo.business.inter;

import org.tinygroup.buildinfo.dao.inter.pojo.Org;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

import java.util.List;

/**
 * Created by Mr.wang on 2016/7/11.
 */
public interface OrgBusiness {
    Org getById(Integer id);

    int deleteByKeys(Integer... pks);

    Pager<Org> getPager(int start, int limit, Org org, final OrderBy... orderBies);

    Org add(Org org);

    int update(Org org);

    List<Org> getList(Org org,OrderBy... orderBies);
}
