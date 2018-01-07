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
 * <!-- begin-user-doc -->
 * 机构表
 * 
 * <!-- end-user-doc -->
 */
public class Org {

	/** 
	 * <!-- begin-user-doc -->
	 * ORG_ID
	 * 
	 * <!-- end-user-doc -->
	 */
	private Integer orgId;

	/** 
	 * <!-- begin-user-doc -->
	 * ORG_NAME
	 * 
	 * <!-- end-user-doc -->
	 */
	private String orgName;

	/** 
	 * <!-- begin-user-doc -->
	 * PARENT_ID
	 * 
	 * <!-- end-user-doc -->
	 */
	private Integer parentId;

	/** 
	 * <!-- begin-user-doc -->
	 * SORT_NUM
	 * 
	 * <!-- end-user-doc -->
	 */
	private Integer sortNum;


	public void setOrgId(Integer orgId){
		this. orgId = orgId;
	}

	public Integer getOrgId(){
		return orgId;
	}

	public void setOrgName(String orgName){
		this. orgName = orgName;
	}

	public String getOrgName(){
		return orgName;
	}

	public void setParentId(Integer parentId){
		this. parentId = parentId;
	}

	public Integer getParentId(){
		return parentId;
	}

	public void setSortNum(Integer sortNum){
		this. sortNum = sortNum;
	}

	public Integer getSortNum(){
		return sortNum;
	}

}
