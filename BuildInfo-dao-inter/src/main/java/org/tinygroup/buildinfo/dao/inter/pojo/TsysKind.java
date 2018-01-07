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
 * <!-- begin-user-doc --> 系统分类表 * <!-- end-user-doc -->
 */
public class TsysKind {

	/**
	 * <!-- begin-user-doc --> 分类编号 * <!-- end-user-doc -->
	 */
	private String kindCode;

	/**
	 * <!-- begin-user-doc --> 分类类型 * <!-- end-user-doc -->
	 */
	private String kindType;

	/**
	 * <!-- begin-user-doc --> 分类名称 * <!-- end-user-doc -->
	 */
	private String kindName;

	/**
	 * <!-- begin-user-doc --> 上级 * <!-- end-user-doc -->
	 */
	private String parentCode;

	/**
	 * <!-- begin-user-doc --> 助记符 * <!-- end-user-doc -->
	 */
	private String mnemonic;

	/**
	 * <!-- begin-user-doc --> 树索引码 * <!-- end-user-doc -->
	 */
	private String treeIdx;

	/**
	 * <!-- begin-user-doc --> 备注 * <!-- end-user-doc -->
	 */
	private String remark;

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
	 * <!-- begin-user-doc --> 分类类型 * <!-- end-user-doc -->
	 */
	public void setKindType(String kindType) {
		this.kindType = kindType;
	}

	public String getKindType() {
		return kindType;
	}

	/**
	 * <!-- begin-user-doc --> 分类名称 * <!-- end-user-doc -->
	 */
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public String getKindName() {
		return kindName;
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
	 * <!-- begin-user-doc --> 助记符 * <!-- end-user-doc -->
	 */
	public void setMnemonic(String mnemonic) {
		this.mnemonic = mnemonic;
	}

	public String getMnemonic() {
		return mnemonic;
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

}
