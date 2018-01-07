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
 * <!-- begin-user-doc --> 系统角色表 * <!-- end-user-doc -->
 */
public class TsysRole {

	/**
	 * <!-- begin-user-doc --> 角色id * <!-- end-user-doc -->
	 */
	private Integer roleId;

	/**
	 * <!-- begin-user-doc --> 角色编号 * <!-- end-user-doc -->
	 */
	private String roleCode;

	/**
	 * <!-- begin-user-doc --> 角色名称 * <!-- end-user-doc -->
	 */
	private String roleName;

	/**
	 * <!-- begin-user-doc --> 创建者 * <!-- end-user-doc -->
	 */
	private String creator;

	/**
	 * <!-- begin-user-doc --> 备注 * <!-- end-user-doc -->
	 */
	private String remark;

	/**
	 * <!-- begin-user-doc --> 角色编号 * <!-- end-user-doc -->
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleCode() {
		return roleCode;
	}

	/**
	 * <!-- begin-user-doc --> 角色名称 * <!-- end-user-doc -->
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	/**
	 * <!-- begin-user-doc --> 创建者 * <!-- end-user-doc -->
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreator() {
		return creator;
	}

	/**
	 * <!-- begin-user-doc --> 备注 * <!-- end-user-doc -->
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
