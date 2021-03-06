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
 * 岗位用户关系表
 * 
 * <!-- end-user-doc -->
 */
public class SysOfficeUserDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8871764027401117094L;

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 用户代码 * <!-- end-user-doc -->
	 */
	private String userId;

	/**
	 * <!-- begin-user-doc --> 岗位编号 * <!-- end-user-doc -->
	 */
	private String officeCode;

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
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	/**
	 * <!-- begin-user-doc --> 岗位编号 * <!-- end-user-doc -->
	 */
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public String getOfficeCode() {
		return officeCode;
	}

}
