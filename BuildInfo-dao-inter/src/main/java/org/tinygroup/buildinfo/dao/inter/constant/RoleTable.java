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
 * <!-- begin-user-doc -->
 * 角色表
 * 
 * <!-- end-user-doc -->
 */
public class RoleTable extends Table {

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public static final RoleTable ROLE_TABLE = new RoleTable();

	/** 
	 * <!-- begin-user-doc -->
	 * ID
	 * 
	 * <!-- end-user-doc -->
	 */
	public final Column ID = new Column(this, "id");

	/** 
	 * <!-- begin-user-doc -->
	 * NAME
	 * 
	 * <!-- end-user-doc -->
	 */
	public final Column NAME = new Column(this, "name");

	/** 
	 * <!-- begin-user-doc -->
	 * TYPE
	 * 
	 * <!-- end-user-doc -->
	 */
	public final Column TYPE = new Column(this, "type");


	public RoleTable() {
		super("role");
	}

}
