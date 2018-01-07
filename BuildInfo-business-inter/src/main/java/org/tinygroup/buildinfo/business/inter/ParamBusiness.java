package org.tinygroup.buildinfo.business.inter;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.Tbparam;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang on 2016/8/3.
 */
public interface ParamBusiness {
	
    Tbparam getById(Integer id);

    int deleteByKeys(Integer... pks);

    Pager<Tbparam> searchPager(int start, int limit, Tbparam param, OrderBy... orderBies);

    Tbparam add(Tbparam param);

    int update(Tbparam param);

    boolean checkExists(Tbparam param);

    List getList(Tbparam param);
    
}
