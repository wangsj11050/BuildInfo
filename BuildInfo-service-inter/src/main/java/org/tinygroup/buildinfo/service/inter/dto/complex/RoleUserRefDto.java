
package org.tinygroup.buildinfo.service.inter.dto.complex;

import java.io.Serializable;

public class RoleUserRefDto implements Serializable{

	/**
	 * long
	 */
	private static final long serialVersionUID = 6764889073227060409L;
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
	 * <!-- begin-user-doc --> 授权标志 * <!-- end-user-doc -->
	 */
	private String rightFlag;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRightFlag() {
		return rightFlag;
	}

	public void setRightFlag(String rightFlag) {
		this.rightFlag = rightFlag;
	}
	
}
