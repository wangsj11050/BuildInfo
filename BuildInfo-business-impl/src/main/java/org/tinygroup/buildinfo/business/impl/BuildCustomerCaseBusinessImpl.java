package org.tinygroup.buildinfo.business.impl;

import java.util.List;

import org.tinygroup.buildinfo.business.inter.BuildCustomerCaseBusiness;
import org.tinygroup.buildinfo.dao.inter.BuildCustomercaseDao;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildCustomercase;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public class BuildCustomerCaseBusinessImpl implements BuildCustomerCaseBusiness {

	private BuildCustomercaseDao buildCustomercaseDao;
	
	
	public BuildCustomercaseDao getBuildCustomercaseDao() {
		return buildCustomercaseDao;
	}

	public void setBuildCustomercaseDao(BuildCustomercaseDao buildCustomercaseDao) {
		this.buildCustomercaseDao = buildCustomercaseDao;
	}

	@Override
	public BuildCustomercase getCustomerCaseById(Integer id) {
		// TODO Auto-generated method stub
		return buildCustomercaseDao.getByKey(id);
	}

	@Override
	public BuildCustomercase addCustomerCase(BuildCustomercase buildCustomercase) {
		// TODO Auto-generated method stub
		return buildCustomercaseDao.add(buildCustomercase);
	}

	@Override
	public int updateCustomerCase(BuildCustomercase buildCustomercase) {
		// TODO Auto-generated method stub
		return buildCustomercaseDao.edit(buildCustomercase);
	}

	@Override
	public int deleteCustomerCase(Integer[] ids) {
		// TODO Auto-generated method stub
		return buildCustomercaseDao.deleteByKeys(ids);
	}

	@Override
	public List<BuildCustomercase> getCustomerCaseList(BuildCustomercase buildCustomercase) {
		// TODO Auto-generated method stub
		return buildCustomercaseDao.query(buildCustomercase, null);
	}

	@Override
	public Pager<BuildCustomercase> getPager(int start, int limit, BuildCustomercase buildCustomercase,
			OrderBy... orderBies) {
		// TODO Auto-generated method stub
		return buildCustomercaseDao.queryPager(start, limit, buildCustomercase, orderBies);
	}

}
