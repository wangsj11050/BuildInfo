package org.tinygroup.buildinfo.business.impl;

import org.tinygroup.buildinfo.dao.inter.TbtransDao;
import org.tinygroup.buildinfo.dao.inter.pojo.Tbtrans;
import org.tinygroup.buildinfo.business.inter.TransBusiness;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

import java.util.List;


/**
 * Created by Mr.wang on 2016/8/3
 */
public class TransBusinessImpl implements TransBusiness{
    private TbtransDao transDao;

	public TbtransDao getTransDao() {
		return transDao;
	}

	public void setTransDao(TbtransDao transDao) {
		this.transDao = transDao;
	}

	public Tbtrans getById(Integer id) {
        return transDao.getByKey(id);
    }

    public int deleteByKeys(Integer... pks) {
        return transDao.deleteByKeys(pks);
    }

    public Pager<Tbtrans> searchPager(int start, int limit, Tbtrans trans, OrderBy... orderBies) {
        return transDao.queryPagerForSearch(start, limit, trans, orderBies);
    }

    public Tbtrans add(Tbtrans tbtrans) {
        return transDao.add(tbtrans);
    }

    public int update(Tbtrans tbtrans) {
        return transDao.edit(tbtrans);
    }

    public boolean checkExists(Tbtrans tbtrans) {
        return transDao.checkExist(tbtrans).size()>0?true:false;
    }

    public List getList(Tbtrans tbtrans) {
        return transDao.query(tbtrans);
    }

}
