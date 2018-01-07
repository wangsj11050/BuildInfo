package org.tinygroup.buildinfo.business.inter;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.BuildServicecenter;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public interface BuildServiceCenterBusiness {

	List<BuildServicecenter> getServicecenterByCode(String serviceCode);
	
	BuildServicecenter addServicecenter(BuildServicecenter buildServicecenter);
	
	int updateServicecenter(BuildServicecenter buildServicecenter);
	
	Pager<BuildServicecenter> getPager(int start, int limit, BuildServicecenter buildServicecenter, final OrderBy... orderBies);
	
	List<BuildServicecenter> checkServicecenterExists(BuildServicecenter buildServicecenter);
	
	int[] batchDelete(List<BuildServicecenter> buildServicecenter);
	
	List getServicecenterList(BuildServicecenter buildServicecenter);
	
	List<BuildServicecenter> getServicecenters(String[] codes);
}
