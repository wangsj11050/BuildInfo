package org.tinygroup.buildinfo.service.inter.dto;

import java.io.Serializable;

public class SysDictEntryDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7693883026489265456L;

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 字典条目编号 * <!-- end-user-doc -->
	 */
	private String dictEntryCode;

	/**
	 * <!-- begin-user-doc --> 分类编号 * <!-- end-user-doc -->
	 */
	private String kindCode;

	/**
	 * <!-- begin-user-doc --> 字典条目名称 * <!-- end-user-doc -->
	 */
	private String dictEntryName;

	/**
	 * <!-- begin-user-doc --> 控制标志 * <!-- end-user-doc -->
	 */
	private String ctrlFlag;

	/**
	 * <!-- begin-user-doc --> 备注 * <!-- end-user-doc -->
	 */
	private String remark;

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
	 * <!-- begin-user-doc --> 字典条目编号 * <!-- end-user-doc -->
	 */
	public void setDictEntryCode(String dictEntryCode) {
		this.dictEntryCode = dictEntryCode;
	}

	public String getDictEntryCode() {
		return dictEntryCode;
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
	 * <!-- begin-user-doc --> 字典条目名称 * <!-- end-user-doc -->
	 */
	public void setDictEntryName(String dictEntryName) {
		this.dictEntryName = dictEntryName;
	}

	public String getDictEntryName() {
		return dictEntryName;
	}

	/**
	 * <!-- begin-user-doc --> 控制标志 * <!-- end-user-doc -->
	 */
	public void setCtrlFlag(String ctrlFlag) {
		this.ctrlFlag = ctrlFlag;
	}

	public String getCtrlFlag() {
		return ctrlFlag;
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

