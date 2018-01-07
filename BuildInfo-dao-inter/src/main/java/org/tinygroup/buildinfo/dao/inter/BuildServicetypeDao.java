
package org.tinygroup.buildinfo.dao.inter;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.BuildServicetype;
import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.jdbctemplatedslsession.daosupport.BaseDao;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public interface BuildServicetypeDao extends BaseDao<BuildServicetype, Integer> {

	public List<BuildServicetype> getServicetypeByCode(String serviceCode);
	
	public List<BuildServicetype> getServiceTypeLikeName(String serviceName);
	
	public List<BuildServicetype> checkServicetypeExists(BuildServicetype buildServicetype);
	
	public List getServicetypeTreeData(TreeData treeData);
	
	public int[] batchDeleteByServiceCode(List<BuildServicetype> buildServicetype);
	
	public int editByCode(BuildServicetype buildServicetype);
}
