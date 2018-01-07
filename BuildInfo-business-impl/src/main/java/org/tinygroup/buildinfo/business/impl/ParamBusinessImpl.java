package org.tinygroup.buildinfo.business.impl;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.TbparamDao;
import org.tinygroup.buildinfo.dao.inter.pojo.Tbparam;
import org.tinygroup.buildinfo.business.inter.ParamBusiness;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;


/**
 * Created by Mr.wang on 2016/8/3
 */
public class ParamBusinessImpl implements ParamBusiness{
    private TbparamDao paramDao;

	public TbparamDao getParamDao() {
		return paramDao;
	}

	public void setParamDao(TbparamDao paramDao) {
		this.paramDao = paramDao;
	}

	public Tbparam getById(Integer id) {
        return paramDao.getByKey(id);
    }

    public int deleteByKeys(Integer... pks) {
        return paramDao.deleteByKeys(pks);
    }

    public Pager<Tbparam> searchPager(int start, int limit, Tbparam param, OrderBy... orderBies) {
        return paramDao.queryPagerForSearch(start, limit, param, orderBies);
    }

    public Tbparam add(Tbparam tbparam) {
        return paramDao.add(tbparam);
    }

    public int update(Tbparam tbparam) {
        return paramDao.edit(tbparam);
    }

    public boolean checkExists(Tbparam tbparam) {
        return paramDao.checkExist(tbparam).size()>0?true:false;
    }

    public List getList(Tbparam tbparam) {
        return paramDao.query(tbparam);
    }

}
