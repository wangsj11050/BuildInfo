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
 * <!-- begin-user-doc --> 字典表 * <!-- end-user-doc -->
 */
public class Dict {

	/**
	 * <!-- begin-user-doc --> DICT_ID * <!-- end-user-doc -->
	 */
	private Integer dictId;

	/**
	 * <!-- begin-user-doc --> DICT_VALUE * <!-- end-user-doc -->
	 */
	private String dictValue;

	/**
	 * <!-- begin-user-doc --> DICT_NAME * <!-- end-user-doc -->
	 */
	private String dictName;

	/**
	 * <!-- begin-user-doc --> DICT_TYPE * <!-- end-user-doc -->
	 */
	private String dictType;

	/** 
	 * <!-- begin-user-doc -->
	 * SORT_NUM
	 * 
	 * <!-- end-user-doc -->
	 */
	private Integer sortNum;

	/**
	 * <!-- begin-user-doc --> 机构内码 * <!-- end-user-doc -->
	 */
	private String branchPath;

	/**
	 * <!-- begin-user-doc --> DICT_ID * <!-- end-user-doc -->
	 */
	public void setDictId(Integer dictId) {
		this.dictId = dictId;
	}

	public Integer getDictId() {
		return dictId;
	}

	/**
	 * <!-- begin-user-doc --> DICT_VALUE * <!-- end-user-doc -->
	 */
	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	public String getDictValue() {
		return dictValue;
	}

	/**
	 * <!-- begin-user-doc --> DICT_NAME * <!-- end-user-doc -->
	 */
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public String getDictName() {
		return dictName;
	}

	/**
	 * <!-- begin-user-doc --> DICT_TYPE * <!-- end-user-doc -->
	 */
	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getDictType() {
		return dictType;
	}

	public void setSortNum(Integer sortNum){
		this. sortNum = sortNum;
	}

	public Integer getSortNum(){
		return sortNum;
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

}
