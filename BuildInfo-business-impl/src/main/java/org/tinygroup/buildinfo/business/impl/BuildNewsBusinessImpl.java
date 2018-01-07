package org.tinygroup.buildinfo.business.impl;

import java.util.List;

import org.tinygroup.buildinfo.business.inter.BuildNewsBusiness;
import org.tinygroup.buildinfo.dao.inter.BuildNewsDao;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildNews;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public class BuildNewsBusinessImpl implements BuildNewsBusiness {

	private BuildNewsDao buildNewsDao;
	
	
	public BuildNewsDao getBuildNewsDao() {
		return buildNewsDao;
	}

	public void setBuildNewsDao(BuildNewsDao buildNewsDao) {
		this.buildNewsDao = buildNewsDao;
	}

	@Override
	public BuildNews getNewsById(Integer id) {
		// TODO Auto-generated method stub
		return buildNewsDao.getByKey(id);
	}

	@Override
	public BuildNews addNews(BuildNews buildNews) {
		// TODO Auto-generated method stub
		return buildNewsDao.add(buildNews);
	}

	@Override
	public Pager<BuildNews> getPager(int start, int limit, BuildNews buildNews, OrderBy... orderBies) {
		// TODO Auto-generated method stub
		return buildNewsDao.queryPager(start, limit, buildNews, orderBies);
	}

	@Override
	public int updateNews(BuildNews buildNews) {
		// TODO Auto-generated method stub
		return buildNewsDao.edit(buildNews);
	}

	@Override
	public int deleteNews(Integer[] ids) {
		// TODO Auto-generated method stub
		return buildNewsDao.deleteByKeys(ids);
	}

	@Override
	public List<BuildNews> getNewsList(BuildNews buildNews) {
		// TODO Auto-generated method stub
		return buildNewsDao.query(buildNews, null);
	}

}
