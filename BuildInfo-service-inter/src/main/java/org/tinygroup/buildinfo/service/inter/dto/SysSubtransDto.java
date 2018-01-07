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
 *
 * <!-- end-user-doc -->
 */
public class SysSubtransDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8834391275688295230L;

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;


	/**
	 * <!-- begin-user-doc --> 映射服务 * <!-- end-user-doc -->
	 */
	private String relServ;

	/**
	 * <!-- begin-user-doc --> 映射URL * <!-- end-user-doc -->
	 */
	private String relUrl;

	/**
	 * <!-- begin-user-doc --> 控制标志 * <!-- end-user-doc -->
	 */
	private String ctrlFlag;

	/**
	 * <!-- begin-user-doc --> 登录标志 * <!-- end-user-doc -->
	 */
	private String loginFlag;

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
	 * <!-- begin-user-doc --> 是否走工作流 * <!-- end-user-doc -->
	 */
	private String isFlow;

	/**
	 * <!-- begin-user-doc --> 是否校验权限 * <!-- end-user-doc -->
	 */
	private String isCheck;

	/**
	 * <!-- begin-user-doc --> 是否写入日志 * <!-- end-user-doc -->
	 */
	private String isLogs;

	/**
	 * <!-- begin-user-doc --> 是否校验权限 * <!-- end-user-doc -->
	 */
	private String isPublic;

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
	 * <!-- begin-user-doc --> 映射服务 * <!-- end-user-doc -->
	 */
	public void setRelServ(String relServ) {
		this.relServ = relServ;
	}

	public String getRelServ() {
		return relServ;
	}

	/**
	 * <!-- begin-user-doc --> 映射URL * <!-- end-user-doc -->
	 */
	public void setRelUrl(String relUrl) {
		this.relUrl = relUrl;
	}

	public String getRelUrl() {
		return relUrl;
	}

	/**
	 * <!-- begin-user-doc --> 控制标志 * <!-- end-user-doc -->
	 */
	public void setCtrlFlag(String ctrlFlag) {
		this.ctrlFlag = ctrlFlag;
	}

	public String getCtrlFlag() {
		return ctrlFlag;
	}

	/**
	 * <!-- begin-user-doc --> 登录标志 * <!-- end-user-doc -->
	 */
	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

	public String getLoginFlag() {
		return loginFlag;
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

	/**
	 * <!-- begin-user-doc --> 是否走工作流 * <!-- end-user-doc -->
	 */
	public void setIsFlow(String isFlow) {
		this.isFlow = isFlow;
	}

	public String getIsFlow() {
		return isFlow;
	}

	/**
	 * <!-- begin-user-doc --> 是否校验权限 * <!-- end-user-doc -->
	 */
	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}

	public String getIsCheck() {
		return isCheck;
	}

	/**
	 * <!-- begin-user-doc --> 是否写入日志 * <!-- end-user-doc -->
	 */
	public void setIsLogs(String isLogs) {
		this.isLogs = isLogs;
	}

	public String getIsLogs() {
		return isLogs;
	}

	/**
	 * <!-- begin-user-doc --> 是否校验权限 * <!-- end-user-doc -->
	 */
	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}

	public String getIsPublic() {
		return isPublic;
	}

}
