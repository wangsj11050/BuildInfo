package org.tinygroup.buildinfo.business.inter;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.BuildPubdemand;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public interface BuildPubDemandBusiness {

	BuildPubdemand getPubdemandById(Integer id);
	
	BuildPubdemand addPubdemand(BuildPubdemand buildPubdemand);
	
	Pager<BuildPubdemand> getPager(int start, int limit, BuildPubdemand buildPubdemand, final OrderBy... orderBies);
	
	int updatePubdemand(BuildPubdemand buildPubdemand);
	
	int deletePubdemand(Integer[] ids);
	
	List<BuildPubdemand> getPubdemandList(BuildPubdemand buildPubdemand);
}
