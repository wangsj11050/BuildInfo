package org.tinygroup.buildinfo.business.inter;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.BuildCustomercase;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public interface BuildCustomerCaseBusiness {

	BuildCustomercase getCustomerCaseById(Integer id);
	
	BuildCustomercase addCustomerCase(BuildCustomercase buildCustomercase);
	
	Pager<BuildCustomercase> getPager(int start, int limit, BuildCustomercase buildCustomercase, final OrderBy... orderBies);
	
	int updateCustomerCase(BuildCustomercase buildCustomercase);
	
	int deleteCustomerCase(Integer[] ids);
	
	List<BuildCustomercase> getCustomerCaseList(BuildCustomercase buildCustomercase);
}
