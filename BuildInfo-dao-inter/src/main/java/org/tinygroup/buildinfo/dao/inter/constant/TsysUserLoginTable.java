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
 * <!-- begin-user-doc --> 用户登录状态表 * <!-- end-user-doc -->
 */
public class TsysUserLoginTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public static final TsysUserLoginTable TSYS_USER_LOGIN_TABLE = new TsysUserLoginTable();

	/**
	 * <!-- begin-user-doc --> 用户代码 * <!-- end-user-doc -->
	 */
	public final Column USER_ID = new Column(this, "user_id");
	/**
	 * <!-- begin-user-doc --> 上次成功登录日 * <!-- end-user-doc -->
	 */
	public final Column LAST_LOGIN_DATE = new Column(this, "last_login_date");
	/**
	 * <!-- begin-user-doc --> 上次成功登录时 * <!-- end-user-doc -->
	 */
	public final Column LAST_LOGIN_TIME = new Column(this, "last_login_time");
	/**
	 * <!-- begin-user-doc --> 最近登录操作IP * <!-- end-user-doc -->
	 */
	public final Column LAST_LOGIN_IP = new Column(this, "last_login_ip");
	/**
	 * <!-- begin-user-doc --> 登录累计失败次数 * <!-- end-user-doc -->
	 */
	public final Column LOGIN_FAIL_TIMES = new Column(this, "login_fail_times");
	/**
	 * <!-- begin-user-doc --> 最后登录失败日 * <!-- end-user-doc -->
	 */
	public final Column LAST_FAIL_DATE = new Column(this, "last_fail_date");
	/**
	 * <!-- begin-user-doc --> 扩展字段 * <!-- end-user-doc -->
	 */
	public final Column EXT_FIELD = new Column(this, "ext_field");

	public TsysUserLoginTable() {
		super("tsys_user_login");
	}
}
