package org.tinygroup.buildinfo.business.impl;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.TberrormsgDao;
import org.tinygroup.buildinfo.dao.inter.pojo.Tberrormsg;
import org.tinygroup.buildinfo.business.inter.ErrormsgBusiness;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;


/**
 * Created by Mr.wang on 2016/8/3
 */
public class ErrormsgBusinessImpl implements ErrormsgBusiness{
    private TberrormsgDao errormsgDao;

	public TberrormsgDao getErrormsgDao() {
		return errormsgDao;
	}

	public void setErrormsgDao(TberrormsgDao errormsgDao) {
		this.errormsgDao = errormsgDao;
	}

	public Tberrormsg getById(Integer id) {
        return errormsgDao.getByKey(id);
    }

    public int deleteByKeys(Integer... pks) {
        return errormsgDao.deleteByKeys(pks);
    }

    public Pager<Tberrormsg> searchPager(int start, int limit, Tberrormsg errormsg, OrderBy... orderBies) {
        return errormsgDao.queryPagerForSearch(start, limit, errormsg, orderBies);
    }

    public Tberrormsg add(Tberrormsg tberrormsg) {
        return errormsgDao.add(tberrormsg);
    }

    public int update(Tberrormsg tberrormsg) {
        return errormsgDao.edit(tberrormsg);
    }

    public boolean checkExists(Tberrormsg tberrormsg) {
        return errormsgDao.checkExist(tberrormsg).size()>0?true:false;
    }

    public List getList(Tberrormsg tberrormsg) {
        return errormsgDao.query(tberrormsg);
    }

}
