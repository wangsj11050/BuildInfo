
package org.tinygroup.workplan.dao.inter;

import java.util.List;

import org.tinygroup.jdbctemplatedslsession.daosupport.BaseDao;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.workplan.dao.inter.pojo.TUserDemandPlann;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public interface TUserDemandPlannDao extends BaseDao<TUserDemandPlann, Integer> {
	public List<TUserDemandPlann> getUserDemandChart(TUserDemandPlann userDemandPlann,final OrderBy... orderArgs);
	
	public List<TUserDemandPlann> getUserDemanndPlannList(TUserDemandPlann userDemandPlann);
	
	public List<TUserDemandPlann> getFinishUserDemandPlannList(TUserDemandPlann userDemandPlann);
}
