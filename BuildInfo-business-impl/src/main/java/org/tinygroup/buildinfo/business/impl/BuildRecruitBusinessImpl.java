package org.tinygroup.buildinfo.business.impl;

import java.util.List;

import org.tinygroup.buildinfo.business.inter.BuildRecruitBusiness;
import org.tinygroup.buildinfo.dao.inter.BuildRecruitDao;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildRecruit;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public class BuildRecruitBusinessImpl implements BuildRecruitBusiness {

	private BuildRecruitDao buildRecruitDao;
	
	public BuildRecruitDao getBuildRecruitDao() {
		return buildRecruitDao;
	}

	public void setBuildRecruitDao(BuildRecruitDao buildRecruitDao) {
		this.buildRecruitDao = buildRecruitDao;
	}

	@Override
	public BuildRecruit getRecruitById(Integer id) {
		// TODO Auto-generated method stub
		return buildRecruitDao.getByKey(id);
	}

	@Override
	public BuildRecruit addRecruit(BuildRecruit buildRecruit) {
		// TODO Auto-generated method stub
		return buildRecruitDao.add(buildRecruit);
	}

	@Override
	public Pager<BuildRecruit> getPager(int start, int limit, BuildRecruit buildRecruit, OrderBy... orderBies) {
		// TODO Auto-generated method stub
		return buildRecruitDao.queryPager(start, limit, buildRecruit, orderBies);
	}

	@Override
	public int updateRecruit(BuildRecruit buildRecruit) {
		// TODO Auto-generated method stub
		return buildRecruitDao.edit(buildRecruit);
	}

	@Override
	public int deleteRecruit(Integer[] ids) {
		// TODO Auto-generated method stub
		return buildRecruitDao.deleteByKeys(ids);
	}

	@Override
	public List<BuildRecruit> getRecruitList(BuildRecruit buildRecruit) {
		// TODO Auto-generated method stub
		return buildRecruitDao.query(buildRecruit, null);
	}

}
