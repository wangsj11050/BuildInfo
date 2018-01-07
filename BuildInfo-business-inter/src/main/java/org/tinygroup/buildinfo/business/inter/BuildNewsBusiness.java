package org.tinygroup.buildinfo.business.inter;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.BuildNews;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public interface BuildNewsBusiness {

	BuildNews getNewsById(Integer id);
	
	BuildNews addNews(BuildNews buildNews);
	
	Pager<BuildNews> getPager(int start, int limit, BuildNews buildNews, final OrderBy... orderBies);
	
	int updateNews(BuildNews buildNews);
	
	int deleteNews(Integer[] ids);
	
	List<BuildNews> getNewsList(BuildNews buildNews);
}
