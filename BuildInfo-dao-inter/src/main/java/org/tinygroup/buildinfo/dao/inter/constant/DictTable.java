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
 * <!-- begin-user-doc --> 字典表 * <!-- end-user-doc -->
 */
public class DictTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public static final DictTable DICT_TABLE = new DictTable();

	/**
	 * <!-- begin-user-doc --> DICT_ID * <!-- end-user-doc -->
	 */
	public final Column DICT_ID = new Column(this, "dict_id");
	/**
	 * <!-- begin-user-doc --> DICT_VALUE * <!-- end-user-doc -->
	 */
	public final Column DICT_VALUE = new Column(this, "dict_value");
	/**
	 * <!-- begin-user-doc --> DICT_NAME * <!-- end-user-doc -->
	 */
	public final Column DICT_NAME = new Column(this, "dict_name");
	/**
	 * <!-- begin-user-doc --> DICT_TYPE * <!-- end-user-doc -->
	 */
	public final Column DICT_TYPE = new Column(this, "dict_type");
	/** 
	 * <!-- begin-user-doc -->
	 * SORT_NUM
	 * 
	 * <!-- end-user-doc -->
	 */
	public final Column SORT_NUM = new Column(this, "sort_num");

	/**
	 * <!-- begin-user-doc --> 机构内码 * <!-- end-user-doc -->
	 */
	public final Column BRANCH_PATH = new Column(this, "branch_path");

	public DictTable() {
		super("dict");
	}
}
