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

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysDep;
import org.tinygroup.jdbctemplatedslsession.daosupport.BaseDao;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

/**
 * <!-- begin-user-doc --> 
 * <!-- end-user-doc -->
 */
public interface TsysDepDao extends BaseDao<TsysDep, String> {

	List<TreeData> getTreeData(TreeData t, OrderBy... orderArgs);

	/**
	 * 根据机构获取部门树
	 * @param t
	 * @return
	 */
	List<TreeData> getDepTreeByBranch(TreeData t);

	Pager<TsysDep> searchPager(int start, int limit, TsysDep tsysDep,
									  final OrderBy... orderArgs);
	List checkExist(TsysDep t);
}
