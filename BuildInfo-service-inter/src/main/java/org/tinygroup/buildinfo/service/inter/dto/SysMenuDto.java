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
 * 系统菜单表
 * 
 * <!-- end-user-doc -->
 */
public class SysMenuDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5300628342668280077L;

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer menuId;

	/**
	 * <!-- begin-user-doc --> 菜单编号 * <!-- end-user-doc -->
	 */
	private String menuCode;

	/**
	 * <!-- begin-user-doc --> 分类编号 * <!-- end-user-doc -->
	 */
	private String kindCode;


	/**
	 * <!-- begin-user-doc --> 菜单名称 * <!-- end-user-doc -->
	 */
	private String menuName;

	/**
	 * <!-- begin-user-doc --> 菜单参数 * <!-- end-user-doc -->
	 */
	private String menuArg;

	/**
	 * <!-- begin-user-doc --> 菜单图标 * <!-- end-user-doc -->
	 */
	private String menuIcon;

	/**
	 * <!-- begin-user-doc --> 窗口类型 * <!-- end-user-doc -->
	 */
	private String windowType;

	/**
	 * <!-- begin-user-doc --> 提示信息 * <!-- end-user-doc -->
	 */
	private String tip;

	/**
	 * <!-- begin-user-doc --> 快捷键 * <!-- end-user-doc -->
	 */
	private String hotKey;
	/**
	 * <!-- begin-user-doc --> 上级 * <!-- end-user-doc -->
	 */
	private Integer parentId;

	/**
	 * <!-- begin-user-doc --> 序号 * <!-- end-user-doc -->
	 */
	private Integer orderNo;

	/**
	 * <!-- begin-user-doc --> 展开标志 * <!-- end-user-doc -->
	 */
	private String openFlag;

	/**
	 * <!-- begin-user-doc --> 树索引码 * <!-- end-user-doc -->
	 */
	private String treeIdx;

	/**
	 * <!-- begin-user-doc --> 备注 * <!-- end-user-doc -->
	 */
	private String remark;

	/**
	 * <!-- begin-user-doc --> 窗口模式 * <!-- end-user-doc -->
	 */
	private String windowModel;

	/**
	 * <!-- begin-user-doc --> 菜单URL * <!-- end-user-doc -->
	 */
	private String menuUrl;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	/**
	 * <!-- begin-user-doc --> 菜单编号 * <!-- end-user-doc -->
	 */
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuCode() {
		return menuCode;
	}

	/**
	 * <!-- begin-user-doc --> 分类编号 * <!-- end-user-doc -->
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}

	public String getKindCode() {
		return kindCode;
	}


	/**
	 * <!-- begin-user-doc --> 菜单名称 * <!-- end-user-doc -->
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuName() {
		return menuName;
	}

	/**
	 * <!-- begin-user-doc --> 菜单参数 * <!-- end-user-doc -->
	 */
	public void setMenuArg(String menuArg) {
		this.menuArg = menuArg;
	}

	public String getMenuArg() {
		return menuArg;
	}

	/**
	 * <!-- begin-user-doc --> 菜单图标 * <!-- end-user-doc -->
	 */
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	/**
	 * <!-- begin-user-doc --> 窗口类型 * <!-- end-user-doc -->
	 */
	public void setWindowType(String windowType) {
		this.windowType = windowType;
	}

	public String getWindowType() {
		return windowType;
	}

	/**
	 * <!-- begin-user-doc --> 提示信息 * <!-- end-user-doc -->
	 */
	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getTip() {
		return tip;
	}

	/**
	 * <!-- begin-user-doc --> 快捷键 * <!-- end-user-doc -->
	 */
	public void setHotKey(String hotKey) {
		this.hotKey = hotKey;
	}

	public String getHotKey() {
		return hotKey;
	}

	/**
	 * <!-- begin-user-doc --> 上级 * <!-- end-user-doc -->
	 */
	
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * <!-- begin-user-doc --> 序号 * <!-- end-user-doc -->
	 */
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	/**
	 * <!-- begin-user-doc --> 展开标志 * <!-- end-user-doc -->
	 */
	public void setOpenFlag(String openFlag) {
		this.openFlag = openFlag;
	}

	public String getOpenFlag() {
		return openFlag;
	}

	/**
	 * <!-- begin-user-doc --> 树索引码 * <!-- end-user-doc -->
	 */
	public void setTreeIdx(String treeIdx) {
		this.treeIdx = treeIdx;
	}

	public String getTreeIdx() {
		return treeIdx;
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
	 * <!-- begin-user-doc --> 窗口模式 * <!-- end-user-doc -->
	 */
	public void setWindowModel(String windowModel) {
		this.windowModel = windowModel;
	}

	public String getWindowModel() {
		return windowModel;
	}

	/**
	 * <!-- begin-user-doc --> 菜单URL * <!-- end-user-doc -->
	 */
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

}
