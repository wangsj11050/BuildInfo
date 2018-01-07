
package org.tinygroup.buildinfo.dao.inter;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.BuildServicecenter;
import org.tinygroup.jdbctemplatedslsession.daosupport.BaseDao;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public interface BuildServicecenterDao extends BaseDao<BuildServicecenter, Integer> {

	public List<BuildServicecenter> getServicecenterByCode(String serviceCode);
	
	public List<BuildServicecenter> checkServicecenterExists(BuildServicecenter buildServicecenter);
	
	public int[] batchDeleteByCode(List<BuildServicecenter> buildServicecenter);
	
	public int editByCode(BuildServicecenter buildServicecenter);
	
	public List<BuildServicecenter> getServicecenters(String[] codes);
}
