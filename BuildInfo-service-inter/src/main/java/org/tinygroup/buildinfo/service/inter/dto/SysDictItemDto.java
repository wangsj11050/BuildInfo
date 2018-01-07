package org.tinygroup.buildinfo.service.inter.dto;

import java.io.Serializable;

public class SysDictItemDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7693883026489265456L;

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
