package org.tinygroup.buildinfo.business.inter;

import org.tinygroup.buildinfo.dao.inter.pojo.Tbtrans;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

import java.util.List;

/**
 * Created by Mr.wang on 2016/8/3.
 */
public interface TransBusiness {
	
    Tbtrans getById(Integer id);

    int deleteByKeys(Integer... pks);

    Pager<Tbtrans> searchPager(int start, int limit, Tbtrans trans, OrderBy... orderBies);

    Tbtrans add(Tbtrans trans);

    int update(Tbtrans trans);

    boolean checkExists(Tbtrans trans);

    List getList(Tbtrans trans);
    
}
