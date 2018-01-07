
package org.tinygroup.workplan.dao.inter;

import java.util.List;

import org.tinygroup.jdbctemplatedslsession.daosupport.BaseDao;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.workplan.dao.inter.pojo.TStikyno;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public interface TStikynoDao extends BaseDao<TStikyno, Integer> {

	List<TStikyno> getStikynoList(TStikyno stikyno);
	
	List<TStikyno> getIndexStikynoList(TStikyno stikyno,final OrderBy... orderArgs);
}
