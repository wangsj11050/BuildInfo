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
 * <!-- begin-user-doc --> 系统机构表 * <!-- end-user-doc -->
 */
public class TsysBranchTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public static final TsysBranchTable TSYS_BRANCH_TABLE = new TsysBranchTable();

	/**
	 * <!-- begin-user-doc --> 机构编号 * <!-- end-user-doc -->
	 */
	public final Column BRANCH_CODE = new Column(this, "branch_code");
	/**
	 * <!-- begin-user-doc --> 机构级别 * <!-- end-user-doc -->
	 */
	public final Column BRANCH_LEVEL = new Column(this, "branch_level");
	/**
	 * <!-- begin-user-doc --> 机构名称 * <!-- end-user-doc -->
	 */
	public final Column BRANCH_NAME = new Column(this, "branch_name");
	/**
	 * <!-- begin-user-doc --> 机构类别 * <!-- end-user-doc -->
	 */
	public final Column BRANCH_TYPE = new Column(this, "branch_type");
	/**
	 * <!-- begin-user-doc --> 简称 * <!-- end-user-doc -->
	 */
	public final Column SHORT_NAME = new Column(this, "short_name");
	/**
	 * <!-- begin-user-doc --> 上级 * <!-- end-user-doc -->
	 */
	public final Column PARENT_CODE = new Column(this, "parent_code");
	/**
	 * <!-- begin-user-doc --> 机构内码 * <!-- end-user-doc -->
	 */
	public final Column BRANCH_PATH = new Column(this, "branch_path");
	/**
	 * <!-- begin-user-doc --> 备注 * <!-- end-user-doc -->
	 */
	public final Column REMARK = new Column(this, "remark");
	/**
	 * <!-- begin-user-doc --> 扩展字段1 * <!-- end-user-doc -->
	 */
	public final Column EXT_FIELD_1 = new Column(this, "ext_field_1");
	/**
	 * <!-- begin-user-doc --> 扩展字段2 * <!-- end-user-doc -->
	 */
	public final Column EXT_FIELD_2 = new Column(this, "ext_field_2");
	/**
	 * <!-- begin-user-doc --> 扩展字段3 * <!-- end-user-doc -->
	 */
	public final Column EXT_FIELD_3 = new Column(this, "ext_field_3");

	public TsysBranchTable() {
		super("tsys_branch");
	}
}
