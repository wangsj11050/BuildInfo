package org.tinygroup.buildinfo.business.impl;

import java.util.List;

import org.tinygroup.buildinfo.business.inter.BuildServiceCenterBusiness;
import org.tinygroup.buildinfo.dao.inter.BuildServicecenterDao;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildServicecenter;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public class BuildServiceCenterBusinessImpl implements BuildServiceCenterBusiness {

	private BuildServicecenterDao buildServicecenterDao;
	
	public BuildServicecenterDao getBuildServicecenterDao() {
		return buildServicecenterDao;
	}

	public void setBuildServicecenterDao(BuildServicecenterDao buildServicecenterDao) {
		this.buildServicecenterDao = buildServicecenterDao;
	}

	@Override
	public List<BuildServicecenter> getServicecenterByCode(String serviceCode) {
		// TODO Auto-generated method stub
		return buildServicecenterDao.getServicecenterByCode(serviceCode);
	}

	@Override
	public BuildServicecenter addServicecenter(BuildServicecenter buildServicecenter) {
		// TODO Auto-generated method stub
		return buildServicecenterDao.add(buildServicecenter);
	}

	@Override
	public int updateServicecenter(BuildServicecenter buildServicecenter) {
		// TODO Auto-generated method stub
		return buildServicecenterDao.editByCode(buildServicecenter);
	}

	@Override
	public Pager<BuildServicecenter> getPager(int start, int limit, BuildServicecenter buildServicecenter,
			OrderBy... orderBies) {
		// TODO Auto-generated method stub
		return buildServicecenterDao.queryPager(start, limit, buildServicecenter, orderBies);
	}

	@Override
	public List<BuildServicecenter> checkServicecenterExists(BuildServicecenter buildServicecenter) {
		// TODO Auto-generated method stub
		return buildServicecenterDao.checkServicecenterExists(buildServicecenter);
	}

	@Override
	public int[] batchDelete(List<BuildServicecenter> buildServicecenter) {
		// TODO Auto-generated method stub
		return buildServicecenterDao.batchDeleteByCode(buildServicecenter);
	}

	@Override
	public List getServicecenterList(BuildServicecenter buildServicecenter) {
		// TODO Auto-generated method stub
		return buildServicecenterDao.query(buildServicecenter, null);
	}

	@Override
	public List<BuildServicecenter> getServicecenters(String[] codes) {
		// TODO Auto-generated method stub
		return buildServicecenterDao.getServicecenters(codes);
	}

}
