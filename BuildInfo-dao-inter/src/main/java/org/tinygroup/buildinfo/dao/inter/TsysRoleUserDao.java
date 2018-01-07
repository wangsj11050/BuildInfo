/**
 *  Copyright (c) 1997-2013, www.tinygroup.org (luo_guo@icloud.com).
 *
 *  Licensed under the GPL, Version 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.gnu.org/licenses/gpl.html
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.tinygroup.buildinfo.dao.inter;

import org.tinygroup.buildinfo.dao.inter.pojo.TsysRightRef;
import org.tinygroup.buildinfo.dao.inter.pojo.complex.RoleUserRef;
import org.tinygroup.jdbctemplatedslsession.daosupport.BaseDao;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

/**
 * <!-- begin-user-doc --> 濡傛灉涓嶅笇鏈涙煇鏂规硶鎴栬�鍙橀噺琚鐩栵紝鍙互鍦ㄦ柟娉曟垨鑰呭彉閲忔敞閲婁腑澧炲姞@unmodifiable
 * <!-- end-user-doc -->
 */
public interface TsysRoleUserDao extends BaseDao<TsysRightRef, Integer> {

	int[] grantRoles(String userCode, Integer[] preAddRoleId);

	int revokeRoles(String userCode, Integer[] preRemoveRoleIds);

	Pager<RoleUserRef> queryRolesInUser(int start, int limit, final String userCode, RoleUserRef roleUserRef, Boolean isAssign,
									 final Integer assignFlag, final OrderBy... orderArgs);


	}
