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
 * <!-- begin-user-doc --> 参数配置表 * <!-- end-user-doc -->
 */
public class Tbparam {

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 分类标识代码 * <!-- end-user-doc -->
	 */
	private String taCode;

	/**
	 * <!-- begin-user-doc --> PARAM_ID * <!-- end-user-doc -->
	 */
	private String paramId;

	/**
	 * <!-- begin-user-doc --> 参数标识名称 * <!-- end-user-doc -->
	 */
	private String paramName;

	/**
	 * <!-- begin-user-doc --> 参数值 * <!-- end-user-doc -->
	 */
	private String paramValue;

	/**
	 * <!-- begin-user-doc --> 参数名称 * <!-- end-user-doc -->
	 */
	private String valueName;

	/**
	 * <!-- begin-user-doc --> 归属系统 * <!-- end-user-doc -->
	 */
	private String belongType;

	/**
	 * <!-- begin-user-doc --> 允许修改标志 * <!-- end-user-doc -->
	 */
	private String modiFlag;

	/**
	 * <!-- begin-user-doc --> 备用1 * <!-- end-user-doc -->
	 */
	private String reserve1;

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
	 * <!-- begin-user-doc --> 分类标识代码 * <!-- end-user-doc -->
	 */
	public void setTaCode(String taCode) {
		this.taCode = taCode;
	}

	public String getTaCode() {
		return taCode;
	}

	/**
	 * <!-- begin-user-doc --> PARAM_ID * <!-- end-user-doc -->
	 */
	public void setParamId(String paramId) {
		this.paramId = paramId;
	}

	public String getParamId() {
		return paramId;
	}

	/**
	 * <!-- begin-user-doc --> 参数标识名称 * <!-- end-user-doc -->
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamName() {
		return paramName;
	}

	/**
	 * <!-- begin-user-doc --> 参数值 * <!-- end-user-doc -->
	 */
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	public String getParamValue() {
		return paramValue;
	}

	/**
	 * <!-- begin-user-doc --> 参数名称 * <!-- end-user-doc -->
	 */
	public void setValueName(String valueName) {
		this.valueName = valueName;
	}

	public String getValueName() {
		return valueName;
	}

	/**
	 * <!-- begin-user-doc --> 归属系统 * <!-- end-user-doc -->
	 */
	public void setBelongType(String belongType) {
		this.belongType = belongType;
	}

	public String getBelongType() {
		return belongType;
	}

	/**
	 * <!-- begin-user-doc --> 允许修改标志 * <!-- end-user-doc -->
	 */
	public void setModiFlag(String modiFlag) {
		this.modiFlag = modiFlag;
	}

	public String getModiFlag() {
		return modiFlag;
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

}
