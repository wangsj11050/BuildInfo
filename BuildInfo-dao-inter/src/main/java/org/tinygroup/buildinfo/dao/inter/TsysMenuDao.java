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

import org.tinygroup.buildinfo.common.dto.biz.SysMenuExt;
import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysMenu;
import org.tinygroup.jdbctemplatedslsession.daosupport.BaseDao;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

/**
 * <!-- begin-user-doc --> 
 * <!-- end-user-doc -->
 */
public interface TsysMenuDao extends BaseDao<TsysMenu, Integer> {

	List getMenuTree(TreeData tree);

	Pager<TsysMenu> queryPagerForSearch(int start, int limit, TsysMenu t, OrderBy... orderArgs);


	List<SysMenuExt> findMenusBySubTrans(List<Integer> subTransId, OrderBy... orderArgs);

	List<Integer> findSubTransIdByUser(String userCode, OrderBy... orderArgs);

	List<SysMenuExt> findMenusBySubTrans(final Integer[] subTransId, final OrderBy... orderArgs);

	/**
	 * 查询所有菜单信息(联表)
	 * @param sysMenuExt
	 * @param orderArgs
     * @return
     */
	List<SysMenuExt> querySysMenuExt(SysMenuExt sysMenuExt, final OrderBy... orderArgs);

	List checkExist(TsysMenu t);

	List<Integer> findMenuIdsByUser(String userCode, OrderBy... orderArgs);

	List<Integer> findAppMenuIds(TsysMenu sysMenu);
}
