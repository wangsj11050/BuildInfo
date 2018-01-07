package org.tinygroup.buildinfo.business.inter;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.BuildAdisver;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public interface BuildAdisverBusiness {

	BuildAdisver getAdisverById(Integer id);
	
	List<BuildAdisver> getAdisverByName(String name);
	
	BuildAdisver addAdisver(BuildAdisver buildAdisver);
	
	Pager<BuildAdisver> getAdisverPager(int start, int limit, BuildAdisver buildAdisver, final OrderBy... orderBies);
	
	int updateAdisver(BuildAdisver buildAdisver);
	
	int deleteAdisver(Integer[] ids);
	
	List<BuildAdisver> getAdisverList(BuildAdisver buildAdisver);
}
