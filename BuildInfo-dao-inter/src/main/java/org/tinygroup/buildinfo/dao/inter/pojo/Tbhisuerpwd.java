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


/**
 * <!-- begin-user-doc --> 用户历史密码表 * <!-- end-user-doc -->
 */
public class Tbhisuerpwd {

	/**
	 * <!-- begin-user-doc --> 流水号 * <!-- end-user-doc -->
	 */
	private String serialNo;

	/**
	 * <!-- begin-user-doc --> 用户代码 * <!-- end-user-doc -->
	 */
	private String userId;

	/**
	 * <!-- begin-user-doc --> 用户密码 * <!-- end-user-doc -->
	 */
	private String userPwd;

	/**
	 * <!-- begin-user-doc --> 备用1 * <!-- end-user-doc -->
	 */
	private String reserve1;

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 流水号 * <!-- end-user-doc -->
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getSerialNo() {
		return serialNo;
	}

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
	 * <!-- begin-user-doc --> 用户密码 * <!-- end-user-doc -->
	 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserPwd() {
		return userPwd;
	}

	/**
	 * <!-- begin-user-doc --> 备用1 * <!-- end-user-doc -->
	 */
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	public String getReserve1() {
		return reserve1;
	}

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

}
