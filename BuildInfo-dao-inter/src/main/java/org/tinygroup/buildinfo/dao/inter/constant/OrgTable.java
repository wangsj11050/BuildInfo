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
 * 机构表
 * 
 * <!-- end-user-doc -->
 */
public class OrgTable extends Table {

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public static final OrgTable ORG_TABLE = new OrgTable();

	/** 
	 * <!-- begin-user-doc -->
	 * ORG_ID
	 * 
	 * <!-- end-user-doc -->
	 */
	public final Column ORG_ID = new Column(this, "org_id");

	/** 
	 * <!-- begin-user-doc -->
	 * ORG_NAME
	 * 
	 * <!-- end-user-doc -->
	 */
	public final Column ORG_NAME = new Column(this, "org_name");

	/** 
	 * <!-- begin-user-doc -->
	 * PARENT_ID
	 * 
	 * <!-- end-user-doc -->
	 */
	public final Column PARENT_ID = new Column(this, "parent_id");

	/** 
	 * <!-- begin-user-doc -->
	 * SORT_NUM
	 * 
	 * <!-- end-user-doc -->
	 */
	public final Column SORT_NUM = new Column(this, "sort_num");


	public OrgTable() {
		super("org");
	}

}
