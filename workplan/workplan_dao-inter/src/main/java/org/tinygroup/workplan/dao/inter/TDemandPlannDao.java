
package org.tinygroup.workplan.dao.inter;

import java.util.List;

import org.tinygroup.jdbctemplatedslsession.daosupport.BaseDao;
import org.tinygroup.workplan.dao.inter.pojo.TDemandPlann;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public interface TDemandPlannDao extends BaseDao<TDemandPlann, Integer> {

	List<TDemandPlann> checkExist(TDemandPlann tdemandPlann);
}
