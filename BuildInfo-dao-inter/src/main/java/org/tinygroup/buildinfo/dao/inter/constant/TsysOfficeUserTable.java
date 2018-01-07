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

package org.tinygroup.buildinfo.dao.inter.constant;

import org.tinygroup.tinysqldsl.base.Column;
import org.tinygroup.tinysqldsl.base.Table;

/**
 * <!-- begin-user-doc --> 岗位用户关系表 * <!-- end-user-doc -->
 */
public class TsysOfficeUserTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public static final TsysOfficeUserTable TSYS_OFFICE_USER_TABLE = new TsysOfficeUserTable();

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	public final Column ID = new Column(this, "id");
	/**
	 * <!-- begin-user-doc --> 用户代码 * <!-- end-user-doc -->
	 */
	public final Column USER_ID = new Column(this, "user_id");
	/**
	 * <!-- begin-user-doc --> 岗位编号 * <!-- end-user-doc -->
	 */
	public final Column OFFICE_CODE = new Column(this, "office_code");

	public TsysOfficeUserTable() {
		super("tsys_office_user");
	}

	public boolean isAutoGeneratedKeys() {
		return true;
	}
}