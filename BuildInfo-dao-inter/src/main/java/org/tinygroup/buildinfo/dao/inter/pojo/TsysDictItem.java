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
 * <!-- begin-user-doc --> 字典项表 * <!-- end-user-doc -->
 */
public class TsysDictItem {

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 字典项编号 * <!-- end-user-doc -->
	 */
	private String dictItemCode;

	/**
	 * <!-- begin-user-doc --> 字典条目编号 * <!-- end-user-doc -->
	 */
	private String dictEntryCode;

	/**
	 * <!-- begin-user-doc --> 字典项名称 * <!-- end-user-doc -->
	 */
	private String dictItemName;

	/**
	 * <!-- begin-user-doc --> 字典项排序 * <!-- end-user-doc -->
	 */
	private Integer dictItemOrder;

	/**
	 * <!-- begin-user-doc --> 字典条目ID * <!-- end-user-doc -->
	 */
	private Integer dictEntryId;

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
	 * <!-- begin-user-doc --> 字典项编号 * <!-- end-user-doc -->
	 */
	public void setDictItemCode(String dictItemCode) {
		this.dictItemCode = dictItemCode;
	}

	public String getDictItemCode() {
		return dictItemCode;
	}

	/**
	 * <!-- begin-user-doc --> 字典条目编号 * <!-- end-user-doc -->
	 */
	public void setDictEntryCode(String dictEntryCode) {
		this.dictEntryCode = dictEntryCode;
	}

	public String getDictEntryCode() {
		return dictEntryCode;
	}

	/**
	 * <!-- begin-user-doc --> 字典项名称 * <!-- end-user-doc -->
	 */
	public void setDictItemName(String dictItemName) {
		this.dictItemName = dictItemName;
	}

	public String getDictItemName() {
		return dictItemName;
	}

	/**
	 * <!-- begin-user-doc --> 字典项排序 * <!-- end-user-doc -->
	 */
	public void setDictItemOrder(Integer dictItemOrder) {
		this.dictItemOrder = dictItemOrder;
	}

	public Integer getDictItemOrder() {
		return dictItemOrder;
	}

	/**
	 * <!-- begin-user-doc --> 字典条目ID * <!-- end-user-doc -->
	 */
	public void setDictEntryId(Integer dictEntryId) {
		this.dictEntryId = dictEntryId;
	}

	public Integer getDictEntryId() {
		return dictEntryId;
	}

}
