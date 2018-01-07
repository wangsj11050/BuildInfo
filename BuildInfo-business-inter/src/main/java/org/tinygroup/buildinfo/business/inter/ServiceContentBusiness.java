package org.tinygroup.buildinfo.business.inter;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.BuildServicecontent;

public interface ServiceContentBusiness {

	List<BuildServicecontent> getServiceContentByCode(String serviceCode);
	
	List<BuildServicecontent> getServiceContentLikeName(String serviceName);
	
	BuildServicecontent addServiceContent(BuildServicecontent buildServiceContent);
	
	int updateServiceContent(BuildServicecontent buildServiceContent);
	
	int[] deleteServiceContent(String[] serviceCode);
	
	List getServicecontentList(BuildServicecontent buildServiceContent);
}
