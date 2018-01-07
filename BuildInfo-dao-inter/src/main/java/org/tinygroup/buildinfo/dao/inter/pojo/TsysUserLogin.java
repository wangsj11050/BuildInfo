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

package org.tinygroup.buildinfo.dao.inter.pojo;

import java.util.Date;

/**
 * <!-- begin-user-doc --> 用户登录状态表 * <!-- end-user-doc -->
 */
public class TsysUserLogin {

	/**
	 * <!-- begin-user-doc --> 用户代码 * <!-- end-user-doc -->
	 */
	private String userId;

	/**
	 * <!-- begin-user-doc --> 上次成功登录日 * <!-- end-user-doc -->
	 */
	private Date lastLoginDate;

	/**
	 * <!-- begin-user-doc --> 上次成功登录时 * <!-- end-user-doc -->
	 */
	private Date lastLoginTime;

	/**
	 * <!-- begin-user-doc --> 最近登录操作IP * <!-- end-user-doc -->
	 */
	private String lastLoginIp;

	/**
	 * <!-- begin-user-doc --> 登录累计失败次数 * <!-- end-user-doc -->
	 */
	private Date loginFailTimes;

	/**
	 * <!-- begin-user-doc --> 最后登录失败日 * <!-- end-user-doc -->
	 */
	private Date lastFailDate;

	/**
	 * <!-- begin-user-doc --> 扩展字段 * <!-- end-user-doc -->
	 */
	private String extField;

	/**
	 * <!-- begin-user-doc --> 用户代码 * <!-- end-user-doc -->
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	/**
	 * <!-- begin-user-doc --> 上次成功登录日 * <!-- end-user-doc -->
	 */
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	/**
	 * <!-- begin-user-doc --> 上次成功登录时 * <!-- end-user-doc -->
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * <!-- begin-user-doc --> 最近登录操作IP * <!-- end-user-doc -->
	 */
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	/**
	 * <!-- begin-user-doc --> 登录累计失败次数 * <!-- end-user-doc -->
	 */
	public void setLoginFailTimes(Date loginFailTimes) {
		this.loginFailTimes = loginFailTimes;
	}

	public Date getLoginFailTimes() {
		return loginFailTimes;
	}

	/**
	 * <!-- begin-user-doc --> 最后登录失败日 * <!-- end-user-doc -->
	 */
	public void setLastFailDate(Date lastFailDate) {
		this.lastFailDate = lastFailDate;
	}

	public Date getLastFailDate() {
		return lastFailDate;
	}

	/**
	 * <!-- begin-user-doc --> 扩展字段 * <!-- end-user-doc -->
	 */
	public void setExtField(String extField) {
		this.extField = extField;
	}

	public String getExtField() {
		return extField;
	}

}
