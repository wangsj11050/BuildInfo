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
 * <!-- begin-user-doc --> 系统角色表 * <!-- end-user-doc -->
 */
public class TsysRoleTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public static final TsysRoleTable TSYS_ROLE_TABLE = new TsysRoleTable();

	/**
	 * <!-- begin-user-doc --> 角色id * <!-- end-user-doc -->
	 */
	public final Column ROLE_ID = new Column(this, "role_id");

	/**
	 * <!-- begin-user-doc --> 角色编号 * <!-- end-user-doc -->
	 */
	public final Column ROLE_CODE = new Column(this, "role_code");
	/**
	 * <!-- begin-user-doc --> 角色名称 * <!-- end-user-doc -->
	 */
	public final Column ROLE_NAME = new Column(this, "role_name");
	/**
	 * <!-- begin-user-doc --> 创建者 * <!-- end-user-doc -->
	 */
	public final Column CREATOR = new Column(this, "creator");
	/**
	 * <!-- begin-user-doc --> 备注 * <!-- end-user-doc -->
	 */
	public final Column REMARK = new Column(this, "remark");

	public TsysRoleTable() {
		super("tsys_role");
	}
}
