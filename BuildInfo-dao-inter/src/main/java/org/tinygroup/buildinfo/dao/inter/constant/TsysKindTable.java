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
 * <!-- begin-user-doc --> 系统分类表 * <!-- end-user-doc -->
 */
public class TsysKindTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public static final TsysKindTable TSYS_KIND_TABLE = new TsysKindTable();

	/**
	 * <!-- begin-user-doc --> 分类编号 * <!-- end-user-doc -->
	 */
	public final Column KIND_CODE = new Column(this, "kind_code");
	/**
	 * <!-- begin-user-doc --> 分类类型 * <!-- end-user-doc -->
	 */
	public final Column KIND_TYPE = new Column(this, "kind_type");
	/**
	 * <!-- begin-user-doc --> 分类名称 * <!-- end-user-doc -->
	 */
	public final Column KIND_NAME = new Column(this, "kind_name");
	/**
	 * <!-- begin-user-doc --> 上级 * <!-- end-user-doc -->
	 */
	public final Column PARENT_CODE = new Column(this, "parent_code");
	/**
	 * <!-- begin-user-doc --> 助记符 * <!-- end-user-doc -->
	 */
	public final Column MNEMONIC = new Column(this, "mnemonic");
	/**
	 * <!-- begin-user-doc --> 树索引码 * <!-- end-user-doc -->
	 */
	public final Column TREE_IDX = new Column(this, "tree_idx");
	/**
	 * <!-- begin-user-doc --> 备注 * <!-- end-user-doc -->
	 */
	public final Column REMARK = new Column(this, "remark");

	public TsysKindTable() {
		super("tsys_kind");
	}
}
