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
 * <!-- begin-user-doc --> 系统用户表 * <!-- end-user-doc -->
 */
public class TsysUserTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public static final TsysUserTable TSYS_USER_TABLE = new TsysUserTable();

	/**
	 * <!-- begin-user-doc --> 用户代码 * <!-- end-user-doc -->
	 */
	public final Column USER_ID = new Column(this, "user_id");
	/**
	 * <!-- begin-user-doc --> 机构编号 * <!-- end-user-doc -->
	 */
	public final Column BRANCH_CODE = new Column(this, "branch_code");
	/**
	 * <!-- begin-user-doc --> 部门编号 * <!-- end-user-doc -->
	 */
	public final Column DEP_CODE = new Column(this, "dep_code");
	/**
	 * <!-- begin-user-doc --> 用户名称 * <!-- end-user-doc -->
	 */
	public final Column USER_NAME = new Column(this, "user_name");
	/**
	 * <!-- begin-user-doc --> 用户密码 * <!-- end-user-doc -->
	 */
	public final Column USER_PWD = new Column(this, "user_pwd");
	/**
	 * <!-- begin-user-doc --> 用户分类 * <!-- end-user-doc -->
	 */
	public final Column USER_TYPE = new Column(this, "user_type");
	/**
	 * <!-- begin-user-doc --> 用户组别 * <!-- end-user-doc -->
	 */
	public final Column USER_LEVEL = new Column(this, "user_level");
	/**
	 * <!-- begin-user-doc --> 用户状态 * <!-- end-user-doc -->
	 */
	public final Column USER_STATUS = new Column(this, "user_status");
	/**
	 * <!-- begin-user-doc --> 锁定状态 * <!-- end-user-doc -->
	 */
	public final Column LOCK_STATUS = new Column(this, "lock_status");
	/**
	 * <!-- begin-user-doc --> 创建者 * <!-- end-user-doc -->
	 */
	public final Column CREATOR = new Column(this, "creator");
	/**
	 * <!-- begin-user-doc --> 创建时间 * <!-- end-user-doc -->
	 */
	public final Column CREATE_DATE = new Column(this, "create_date");
	/**
	 * <!-- begin-user-doc --> 最后修改时间 * <!-- end-user-doc -->
	 */
	public final Column MODIFY_DATE = new Column(this, "modify_date");
	/**
	 * <!-- begin-user-doc --> 密码修改时间 * <!-- end-user-doc -->
	 */
	public final Column PASS_MODIFY_DATE = new Column(this, "pass_modify_date");
	/**
	 * <!-- begin-user-doc --> 授权级别 * <!-- end-user-doc -->
	 */
	public final Column AUTH_LEVEL = new Column(this, "auth_level");
	/**
	 * <!-- begin-user-doc --> 个性化主页 * <!-- end-user-doc -->
	 */
	public final Column HOME_PAGE = new Column(this, "home_page");
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
	 * <!-- begin-user-doc --> 扩展字段4 * <!-- end-user-doc -->
	 */
	public final Column EXT_FIELD_4 = new Column(this, "ext_field_4");
	/**
	 * <!-- begin-user-doc --> 扩展字段5 * <!-- end-user-doc -->
	 */
	public final Column EXT_FIELD_5 = new Column(this, "ext_field_5");
	/**
	 * <!-- begin-user-doc --> 扩展字段3 * <!-- end-user-doc -->
	 */
	public final Column EXT_FIELD_3 = new Column(this, "ext_field_3");

	public TsysUserTable() {
		super("tsys_user");
	}
}
