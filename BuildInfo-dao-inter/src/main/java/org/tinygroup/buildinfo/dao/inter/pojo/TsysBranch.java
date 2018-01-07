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
 * <!-- begin-user-doc --> 系统机构表 * <!-- end-user-doc -->
 */
public class TsysBranch {

	/**
	 * <!-- begin-user-doc --> 机构编号 * <!-- end-user-doc -->
	 */
	private String branchCode;

	/**
	 * <!-- begin-user-doc --> 机构级别 * <!-- end-user-doc -->
	 */
	private String branchLevel;

	/**
	 * <!-- begin-user-doc --> 机构名称 * <!-- end-user-doc -->
	 */
	private String branchName;

	/**
	 * <!-- begin-user-doc --> 机构类别 * <!-- end-user-doc -->
	 */
	private String branchType;

	/**
	 * <!-- begin-user-doc --> 简称 * <!-- end-user-doc -->
	 */
	private String shortName;

	/**
	 * <!-- begin-user-doc --> 上级 * <!-- end-user-doc -->
	 */
	private String parentCode;

	/**
	 * <!-- begin-user-doc --> 机构内码 * <!-- end-user-doc -->
	 */
	private String branchPath;

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
	 * <!-- begin-user-doc --> 机构编号 * <!-- end-user-doc -->
	 */
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchCode() {
		return branchCode;
	}

	/**
	 * <!-- begin-user-doc --> 机构级别 * <!-- end-user-doc -->
	 */
	public void setBranchLevel(String branchLevel) {
		this.branchLevel = branchLevel;
	}

	public String getBranchLevel() {
		return branchLevel;
	}

	/**
	 * <!-- begin-user-doc --> 机构名称 * <!-- end-user-doc -->
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchName() {
		return branchName;
	}

	/**
	 * <!-- begin-user-doc --> 机构类别 * <!-- end-user-doc -->
	 */
	public void setBranchType(String branchType) {
		this.branchType = branchType;
	}

	public String getBranchType() {
		return branchType;
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
	 * <!-- begin-user-doc --> 机构内码 * <!-- end-user-doc -->
	 */
	public void setBranchPath(String branchPath) {
		this.branchPath = branchPath;
	}

	public String getBranchPath() {
		return branchPath;
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
