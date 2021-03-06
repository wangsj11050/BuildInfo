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
 * <!-- begin-user-doc --> 角色用户关系表 * <!-- end-user-doc -->
 */
public class TsysRightRef {

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 用户代码 * <!-- end-user-doc -->
	 */
	private String userCode;

	/**
	 * <!-- begin-user-doc --> 角色编号 * <!-- end-user-doc -->
	 */
	private String roleCode;
	
	private String menuId;

	/**
	 * <!-- begin-user-doc --> 授权标志 * <!-- end-user-doc -->
	 */
	private String rightFlag;

	private Integer roleId;

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> 用户代码 * <!-- end-user-doc -->
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserCode() {
		return userCode;
	}

	/**
	 * <!-- begin-user-doc --> 角色编号 * <!-- end-user-doc -->
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	/**
	 * <!-- begin-user-doc --> 授权标志 * <!-- end-user-doc -->
	 */
	public void setRightFlag(String rightFlag) {
		this.rightFlag = rightFlag;
	}

	public String getRightFlag() {
		return rightFlag;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
