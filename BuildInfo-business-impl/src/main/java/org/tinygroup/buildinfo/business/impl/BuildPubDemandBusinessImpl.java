package org.tinygroup.buildinfo.business.impl;

import java.util.List;

import org.tinygroup.buildinfo.business.inter.BuildPubDemandBusiness;
import org.tinygroup.buildinfo.dao.inter.BuildPubdemandDao;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildPubdemand;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public class BuildPubDemandBusinessImpl implements BuildPubDemandBusiness {

	private BuildPubdemandDao buildPubdemandDao;
	
	public BuildPubdemandDao getBuildPubdemandDao() {
		return buildPubdemandDao;
	}

	public void setBuildPubdemandDao(BuildPubdemandDao buildPubdemandDao) {
		this.buildPubdemandDao = buildPubdemandDao;
	}

	@Override
	public BuildPubdemand getPubdemandById(Integer id) {
		// TODO Auto-generated method stub
		return buildPubdemandDao.getByKey(id);
	}

	@Override
	public BuildPubdemand addPubdemand(BuildPubdemand buildPubdemand) {
		// TODO Auto-generated method stub
		return buildPubdemandDao.add(buildPubdemand);
	}

	@Override
	public Pager<BuildPubdemand> getPager(int start, int limit, BuildPubdemand buildPubdemand, OrderBy... orderBies) {
		// TODO Auto-generated method stub
		return buildPubdemandDao.queryPager(start, limit, buildPubdemand, orderBies);
	}

	@Override
	public int updatePubdemand(BuildPubdemand buildPubdemand) {
		// TODO Auto-generated method stub
		return buildPubdemandDao.edit(buildPubdemand);
	}

	@Override
	public int deletePubdemand(Integer[] ids) {
		// TODO Auto-generated method stub
		return buildPubdemandDao.deleteByKeys(ids);
	}

	@Override
	public List<BuildPubdemand> getPubdemandList(BuildPubdemand buildPubdemand) {
		// TODO Auto-generated method stub
		return buildPubdemandDao.query(buildPubdemand, null);
	}

}
