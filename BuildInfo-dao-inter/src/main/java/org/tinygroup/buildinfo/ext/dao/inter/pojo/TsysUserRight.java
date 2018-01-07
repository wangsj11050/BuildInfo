/**
 *  Copyright (c) 2012-2016, www.tinygroup.org (luo_guo@icloud.com).
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

package org.tinygroup.buildinfo.ext.dao.inter.pojo;

import java.util.Date;

/**
 * <!-- begin-user-doc --> 用户权限授权表 * <!-- end-user-doc -->
 */
public class TsysUserRight {

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 用户代码 * <!-- end-user-doc -->
	 */
	private String userId;

	/**
	 * <!-- begin-user-doc --> 菜单id * <!-- end-user-doc -->
	 */
	private Integer menuId;

	/**
	 * <!-- begin-user-doc --> 分配人 * <!-- end-user-doc -->
	 */
	private String createBy;

	/**
	 * <!-- begin-user-doc --> 创建时间 * <!-- end-user-doc -->
	 */
	private Date createDate;

	/**
	 * <!-- begin-user-doc --> 开始时间 * <!-- end-user-doc -->
	 */
	private Integer beginDate;

	/**
	 * <!-- begin-user-doc --> 截止时间 * <!-- end-user-doc -->
	 */
	private Integer endDate;

	/**
	 * <!-- begin-user-doc --> 授权标志 * <!-- end-user-doc -->
	 */
	private String rightFlag;

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
	 * <!-- begin-user-doc --> 菜单id * <!-- end-user-doc -->
	 */
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	/**
	 * <!-- begin-user-doc --> 分配人 * <!-- end-user-doc -->
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateBy() {
		return createBy;
	}

	/**
	 * <!-- begin-user-doc --> 创建时间 * <!-- end-user-doc -->
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * <!-- begin-user-doc --> 开始时间 * <!-- end-user-doc -->
	 */
	public void setBeginDate(Integer beginDate) {
		this.beginDate = beginDate;
	}

	public Integer getBeginDate() {
		return beginDate;
	}

	/**
	 * <!-- begin-user-doc --> 截止时间 * <!-- end-user-doc -->
	 */
	public void setEndDate(Integer endDate) {
		this.endDate = endDate;
	}

	public Integer getEndDate() {
		return endDate;
	}

	/**
	 * <!-- begin-user-doc --> 授权标志 * <!-- end-user-doc -->
	 */
	public void setRightFlag(String rightFlag) {
		this.rightFlag = rightFlag;
	}

	public String getRightFlag() {
		return rightFlag;
	}

}
