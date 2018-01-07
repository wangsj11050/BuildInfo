package org.tinygroup.buildinfo.business.impl;

import java.util.List;

import org.tinygroup.buildinfo.business.inter.BuildServiceBusiness;
import org.tinygroup.buildinfo.dao.inter.BuildServicetypeDao;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildServicetype;
import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public class BuildServiceBusinessImpl implements BuildServiceBusiness {

	private BuildServicetypeDao buildServicetypeDao;
	
	
	public BuildServicetypeDao getBuildServicetypeDao() {
		return buildServicetypeDao;
	}

	public void setBuildServicetypeDao(BuildServicetypeDao buildServicetypeDao) {
		this.buildServicetypeDao = buildServicetypeDao;
	}

	@Override
	public List<BuildServicetype> getServicetypeByCode(String serviceCode) {
		// TODO Auto-generated method stub
		return buildServicetypeDao.getServicetypeByCode(serviceCode);
	}

	@Override
	public BuildServicetype addServicetype(BuildServicetype buildServicetype) {
		// TODO Auto-generated method stub
		return buildServicetypeDao.add(buildServicetype);
	}

	@Override
	public int updateServicetype(BuildServicetype buildServicetype) {
		// TODO Auto-generated method stub
		return buildServicetypeDao.editByCode(buildServicetype);
	}

	@Override
	public Pager<BuildServicetype> getPager(int start, int limit, BuildServicetype buildServicetype,
			OrderBy... orderBies) {
		// TODO Auto-generated method stub
		return buildServicetypeDao.queryPager(start, limit, buildServicetype, orderBies);
	}

	@Override
	public List<BuildServicetype> checkServicetypeExists(BuildServicetype buildServicetype) {
		// TODO Auto-generated method stub
		return buildServicetypeDao.checkServicetypeExists(buildServicetype);
	}

	@Override
	public List getServicetypeTreeData(TreeData treeData) {
		// TODO Auto-generated method stub
		return buildServicetypeDao.getServicetypeTreeData(treeData);
	}

	@Override
	public int[] batchDelete(List<BuildServicetype> buildServicetype) {
		// TODO Auto-generated method stub
		return buildServicetypeDao.batchDeleteByServiceCode(buildServicetype);
	}

	@Override
	public List getServicetypeList(BuildServicetype buildServicetype) {
		// TODO Auto-generated method stub
		return buildServicetypeDao.query(buildServicetype, null);
	}

	@Override
	public List<BuildServicetype> getServiceTypeLikeName(String serviceName) {
		// TODO Auto-generated method stub
		return buildServicetypeDao.getServiceTypeLikeName(serviceName);
	}

}
