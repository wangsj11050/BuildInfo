
package org.tinygroup.buildinfo.dao.inter;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.BuildAdisver;
import org.tinygroup.jdbctemplatedslsession.daosupport.BaseDao;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public interface BuildAdisverDao extends BaseDao<BuildAdisver, Integer> {

	List<BuildAdisver> getAdisverByName(String name);
}
