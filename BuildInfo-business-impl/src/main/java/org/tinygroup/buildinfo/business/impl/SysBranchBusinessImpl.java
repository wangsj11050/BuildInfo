package org.tinygroup.buildinfo.business.impl;

import org.tinygroup.buildinfo.dao.inter.TsysBranchDao;
import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysBranch;
import org.tinygroup.buildinfo.business.inter.SysBranchBusiness;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

import java.util.List;

/**
 * Created by Mr.wang on 2016/7/14.
 */
public class SysBranchBusinessImpl implements SysBranchBusiness{
    private TsysBranchDao tsysBranchDao;

    public TsysBranchDao getTsysBranchDao() {
        return tsysBranchDao;
    }

    public void setTsysBranchDao(TsysBranchDao tsysBranchDao) {
        this.tsysBranchDao = tsysBranchDao;
    }


    public TsysBranch getById(String branchCode) {
        return tsysBranchDao.getByKey(branchCode);
    }

    public int deleteByKeys(String... pks) {
        return tsysBranchDao.deleteByKeys(pks);
    }

    public Pager<TsysBranch> getPager(int start, int limit, TsysBranch tsysBranch, OrderBy... orderBies) {
        return tsysBranchDao.queryFuzzyPager(start, limit, tsysBranch, orderBies);
    }

    public TsysBranch add(TsysBranch tsysBranch) {
        return tsysBranchDao.add(tsysBranch);
    }

    public int update(TsysBranch tsysBranch) {
        return tsysBranchDao.edit(tsysBranch);
    }

    public boolean checkExists(TsysBranch tsysBranch) {
        return tsysBranchDao.checkExist(tsysBranch).size()>0?true:false;
    }

    public List<TsysBranch> getList(TsysBranch tsysBranch) {
        return tsysBranchDao.query(tsysBranch);
    }

	public List getTreeData(TreeData tree) {
		return tsysBranchDao.getTreeData(tree);
	}

	/*public boolean checkSubBranchExist(TsysBranch sysBranch) {
		return tsysBranchDao.getSubBranchs(sysBranch).size()>0? true:false;
	}*/
}
