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
 * <!-- begin-user-doc --> 错误代码表 * <!-- end-user-doc -->
 */
public class ErrormsgDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4869549274703810318L;

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 执行结果 * <!-- end-user-doc -->
	 */
	private String errCode;

	/**
	 * <!-- begin-user-doc --> 执行结果信息 * <!-- end-user-doc -->
	 */
	private String errMsg;

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
	 * <!-- begin-user-doc --> 执行结果 * <!-- end-user-doc -->
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrCode() {
		return errCode;
	}

	/**
	 * <!-- begin-user-doc --> 执行结果信息 * <!-- end-user-doc -->
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrMsg() {
		return errMsg;
	}

}
