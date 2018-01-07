package org.tinygroup.buildinfo.business.inter;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.BuildServicetype;
import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public interface BuildServiceBusiness {
	
	List<BuildServicetype> getServicetypeByCode(String serviceCode);
	
	List<BuildServicetype> getServiceTypeLikeName(String serviceName);
	
	BuildServicetype addServicetype(BuildServicetype buildServicetype);
	
	int updateServicetype(BuildServicetype buildServicetype);
	
	Pager<BuildServicetype> getPager(int start, int limit, BuildServicetype buildServicetype, final OrderBy... orderBies);
	
	List<BuildServicetype> checkServicetypeExists(BuildServicetype buildServicetype);
	
	List getServicetypeTreeData(TreeData treeData);
	
	int[] batchDelete(List<BuildServicetype> buildServicetype);
	
	List getServicetypeList(BuildServicetype buildServicetype);
}
