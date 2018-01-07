package org.tinygroup.buildinfo.business.inter;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.Tberrormsg;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang on 2016/8/3.
 */
public interface ErrormsgBusiness {
	
    Tberrormsg getById(Integer id);

    int deleteByKeys(Integer... pks);

    Pager<Tberrormsg> searchPager(int start, int limit, Tberrormsg errormsg, OrderBy... orderBies);

    Tberrormsg add(Tberrormsg errormsg);

    int update(Tberrormsg errormsg);

    boolean checkExists(Tberrormsg errormsg);

    List getList(Tberrormsg errormsg);
    
}
