package org.tinygroup.buildinfo.business.impl;

import java.util.List;

import org.tinygroup.buildinfo.business.inter.BuildAdisverBusiness;
import org.tinygroup.buildinfo.dao.inter.BuildAdisverDao;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildAdisver;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public class BuildAdisverBusinessImpl implements BuildAdisverBusiness {

	private BuildAdisverDao buildAdisverDao;
	
	public BuildAdisverDao getBuildAdisverDao() {
		return buildAdisverDao;
	}

	public void setBuildAdisverDao(BuildAdisverDao buildAdisverDao) {
		this.buildAdisverDao = buildAdisverDao;
	}

	@Override
	public BuildAdisver getAdisverById(Integer id) {
		// TODO Auto-generated method stub
		return buildAdisverDao.getByKey(id);
	}

	@Override
	public BuildAdisver addAdisver(BuildAdisver buildAdisver) {
		// TODO Auto-generated method stub
		return buildAdisverDao.add(buildAdisver);
	}

	@Override
	public Pager<BuildAdisver> getAdisverPager(int start, int limit, BuildAdisver buildAdisver, OrderBy... orderBies) {
		// TODO Auto-generated method stub
		return buildAdisverDao.queryPager(start, limit, buildAdisver, orderBies);
	}

	@Override
	public int updateAdisver(BuildAdisver buildAdisver) {
		// TODO Auto-generated method stub
		return buildAdisverDao.edit(buildAdisver);
	}

	@Override
	public int deleteAdisver(Integer[] ids) {
		// TODO Auto-generated method stub
		return buildAdisverDao.deleteByKeys(ids);
	}

	@Override
	public List<BuildAdisver> getAdisverList(BuildAdisver buildAdisver) {
		// TODO Auto-generated method stub
		return buildAdisverDao.query(buildAdisver, null);
	}

	@Override
	public List<BuildAdisver> getAdisverByName(String name) {
		// TODO Auto-generated method stub
		return buildAdisverDao.getAdisverByName(name);
	}

}
