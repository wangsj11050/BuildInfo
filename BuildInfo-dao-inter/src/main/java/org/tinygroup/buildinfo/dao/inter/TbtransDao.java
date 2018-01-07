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

import org.tinygroup.buildinfo.dao.inter.pojo.Tbtrans;
import org.tinygroup.jdbctemplatedslsession.daosupport.BaseDao;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

/**
 * <!-- begin-user-doc --> 
 * <!-- end-user-doc -->
 */
public interface TbtransDao extends BaseDao<Tbtrans, Integer> {

	Pager<Tbtrans> queryPagerForSearch(int start, int limit, Tbtrans t, OrderBy... orderArgs);
	
	List checkExist(Tbtrans t);
}
