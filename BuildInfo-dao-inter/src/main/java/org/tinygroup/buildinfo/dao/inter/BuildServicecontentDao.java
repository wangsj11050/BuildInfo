
package org.tinygroup.buildinfo.dao.inter;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.BuildServicecontent;
import org.tinygroup.jdbctemplatedslsession.daosupport.BaseDao;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public interface BuildServicecontentDao extends BaseDao<BuildServicecontent, Integer> {

	public List<BuildServicecontent> getServiceContentByCode(String serviceCode);
	
	public List<BuildServicecontent> getServiceContentLikeName(String serviceName);
	
	public int editByCode(BuildServicecontent buildServicecontent);
}
