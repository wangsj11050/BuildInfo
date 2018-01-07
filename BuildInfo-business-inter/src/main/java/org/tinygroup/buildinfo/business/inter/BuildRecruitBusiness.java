package org.tinygroup.buildinfo.business.inter;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.BuildRecruit;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public interface BuildRecruitBusiness {

	BuildRecruit getRecruitById(Integer id);
	
	BuildRecruit addRecruit(BuildRecruit buildRecruit);
	
	Pager<BuildRecruit> getPager(int start, int limit, BuildRecruit buildRecruit, final OrderBy... orderBies);
	
	int updateRecruit(BuildRecruit buildRecruit);
	
	int deleteRecruit(Integer[] ids);
	
	List<BuildRecruit> getRecruitList(BuildRecruit buildRecruit);
}
