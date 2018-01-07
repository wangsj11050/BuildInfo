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

package org.tinygroup.buildinfo.service.inter.dto;

import java.io.Serializable;


/** 
 * <!-- begin-user-doc -->
 * 系统部门表
 * 
 * <!-- end-user-doc -->
 */
public class SysDepDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7531480216792045587L;

	/**
	 * <!-- begin-user-doc --> 部门编号 * <!-- end-user-doc -->
	 */
	private String depCode;

	/**
	 * <!-- begin-user-doc --> 部门名称 * <!-- end-user-doc -->
	 */
	private String depName;

	/**
	 * <!-- begin-user-doc --> 简称 * <!-- end-user-doc -->
	 */
	private String shortName;

	/**
	 * <!-- begin-user-doc --> 上级 * <!-- end-user-doc -->
	 */
	private String parentCode;

	/**
	 * <!-- begin-user-doc --> 机构编号 * <!-- end-user-doc -->
	 */
	private String branchCode;

	/**
	 * <!-- begin-user-doc --> 部门内码 * <!-- end-user-doc -->
	 */
	private String depPath;

	/**
	 * <!-- begin-user-doc --> 备注 * <!-- end-user-doc -->
	 */
	private String remark;

	/**
	 * <!-- begin-user-doc --> 扩展字段1 * <!-- end-user-doc -->
	 */
	private String extField1;

	/**
	 * <!-- begin-user-doc --> 扩展字段2 * <!-- end-user-doc -->
	 */
	private String extField2;

	/**
	 * <!-- begin-user-doc --> 扩展字段3 * <!-- end-user-doc -->
	 */
	private String extField3;

	/**
	 * <!-- begin-user-doc --> 部门编号 * <!-- end-user-doc -->
	 */
	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}

	public String getDepCode() {
		return depCode;
	}

	/**
	 * <!-- begin-user-doc --> 部门名称 * <!-- end-user-doc -->
	 */
	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getDepName() {
		return depName;
	}

	/**
	 * <!-- begin-user-doc --> 简称 * <!-- end-user-doc -->
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getShortName() {
		return shortName;
	}

	/**
	 * <!-- begin-user-doc --> 上级 * <!-- end-user-doc -->
	 */
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getParentCode() {
		return parentCode;
	}

	/**
	 * <!-- begin-user-doc --> 机构编号 * <!-- end-user-doc -->
	 */
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchCode() {
		return branchCode;
	}

	/**
	 * <!-- begin-user-doc --> 部门内码 * <!-- end-user-doc -->
	 */
	public void setDepPath(String depPath) {
		this.depPath = depPath;
	}

	public String getDepPath() {
		return depPath;
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

	/**
	 * <!-- begin-user-doc --> 扩展字段1 * <!-- end-user-doc -->
	 */
	public void setExtField1(String extField1) {
		this.extField1 = extField1;
	}

	public String getExtField1() {
		return extField1;
	}

	/**
	 * <!-- begin-user-doc --> 扩展字段2 * <!-- end-user-doc -->
	 */
	public void setExtField2(String extField2) {
		this.extField2 = extField2;
	}

	public String getExtField2() {
		return extField2;
	}

	/**
	 * <!-- begin-user-doc --> 扩展字段3 * <!-- end-user-doc -->
	 */
	public void setExtField3(String extField3) {
		this.extField3 = extField3;
	}

	public String getExtField3() {
		return extField3;
	}

}
