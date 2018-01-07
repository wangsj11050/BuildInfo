package org.tinygroup.buildinfo.business.impl;

import org.tinygroup.buildinfo.dao.inter.OrgDao;
import org.tinygroup.buildinfo.dao.inter.pojo.Org;
import org.tinygroup.buildinfo.business.inter.OrgBusiness;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

import java.util.List;

/**
 * Created by Mr.wang on 2016/7/11.
 */
public class OrgBusinessImpl implements OrgBusiness{
    private OrgDao orgDao;

    public OrgDao getOrgDao() {
        return orgDao;
    }

    public void setOrgDao(OrgDao orgDao) {
        this.orgDao = orgDao;
    }

    public Org getById(Integer id) {
        return orgDao.getByKey(id);
    }

    public int deleteByKeys(Integer... pks) {
        return orgDao.deleteByKeys(pks);
    }

    public Pager<Org> getPager(int start, int limit, Org org, OrderBy... orderBies) {
        return orgDao.queryPager(start,limit,org,orderBies);
    }

    public Org add(Org org) {
        return orgDao.add(org);
    }

    public int update(Org org) {
        return orgDao.edit(org);
    }

    public List<Org> getList(Org org,OrderBy... orderBies) {
        return orgDao.query(org,orderBies);
    }
}
