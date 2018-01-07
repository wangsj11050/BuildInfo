package org.tinygroup.workplan.dto;

import java.io.Serializable;
import java.util.Date;

public class UserNotepadDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5547790999384659293L;

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 记事本名称 * <!-- end-user-doc -->
	 */
	private String notepadName;

	/**
	 * <!-- begin-user-doc --> 知识类别 * <!-- end-user-doc -->
	 */
	private String knowledgeType;

	/**
	 * <!-- begin-user-doc --> 创建人员 * <!-- end-user-doc -->
	 */
	private String createUser;

	/**
	 * <!-- begin-user-doc --> 创建时间 * <!-- end-user-doc -->
	 */
	private String createTime;

	/**
	 * <!-- begin-user-doc --> 记事本内容 * <!-- end-user-doc -->
	 */
	private String notepadContent;

	/**
	 * <!-- begin-user-doc --> 移交人员 * <!-- end-user-doc -->
	 */
	private String transferUser;

	/**
	 * <!-- begin-user-doc --> 移交时间 * <!-- end-user-doc -->
	 */
	private String transferTime;

	/**
	 * <!-- begin-user-doc --> 扩展字段1 * <!-- end-user-doc -->
	 */
	private String extField1;

	/**
	 * <!-- begin-user-doc --> 扩展字段2 * <!-- end-user-doc -->
	 */
	private String extField2;

	/**
	 * <!-- begin-user-doc --> 扩展字段3 * <!-- end-user-doc -->
	 */
	private String extField3;

	/**
	 * <!-- begin-user-doc --> 扩展字段4 * <!-- end-user-doc -->
	 */
	private String extField4;

	/**
	 * <!-- begin-user-doc --> 扩展字段5 * <!-- end-user-doc -->
	 */
	private String extField5;

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
	 * <!-- begin-user-doc --> 记事本名称 * <!-- end-user-doc -->
	 */
	public void setNotepadName(String notepadName) {
		this.notepadName = notepadName;
	}

	public String getNotepadName() {
		return notepadName;
	}

	/**
	 * <!-- begin-user-doc --> 知识类别 * <!-- end-user-doc -->
	 */
	public void setKnowledgeType(String knowledgeType) {
		this.knowledgeType = knowledgeType;
	}

	public String getKnowledgeType() {
		return knowledgeType;
	}

	/**
	 * <!-- begin-user-doc --> 创建人员 * <!-- end-user-doc -->
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateUser() {
		return createUser;
	}

	/**
	 * <!-- begin-user-doc --> 创建时间 * <!-- end-user-doc -->
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	/**
	 * <!-- begin-user-doc --> 记事本内容 * <!-- end-user-doc -->
	 */
	public void setNotepadContent(String notepadContent) {
		this.notepadContent = notepadContent;
	}

	public String getNotepadContent() {
		return notepadContent;
	}

	/**
	 * <!-- begin-user-doc --> 移交人员 * <!-- end-user-doc -->
	 */
	public void setTransferUser(String transferUser) {
		this.transferUser = transferUser;
	}

	public String getTransferUser() {
		return transferUser;
	}

	/**
	 * <!-- begin-user-doc --> 移交时间 * <!-- end-user-doc -->
	 */
	public void setTransferTime(String transferTime) {
		this.transferTime = transferTime;
	}

	public String getTransferTime() {
		return transferTime;
	}

	/**
	 * <!-- begin-user-doc --> 扩展字段1 * <!-- end-user-doc -->
	 */
	public void setExtField1(String extField1) {
		this.extField1 = extField1;
	}

	public String getExtField1() {
		return extField1;
	}

	/**
	 * <!-- begin-user-doc --> 扩展字段2 * <!-- end-user-doc -->
	 */
	public void setExtField2(String extField2) {
		this.extField2 = extField2;
	}

	public String getExtField2() {
		return extField2;
	}

	/**
	 * <!-- begin-user-doc --> 扩展字段3 * <!-- end-user-doc -->
	 */
	public void setExtField3(String extField3) {
		this.extField3 = extField3;
	}

	public String getExtField3() {
		return extField3;
	}

	/**
	 * <!-- begin-user-doc --> 扩展字段4 * <!-- end-user-doc -->
	 */
	public void setExtField4(String extField4) {
		this.extField4 = extField4;
	}

	public String getExtField4() {
		return extField4;
	}

	/**
	 * <!-- begin-user-doc --> 扩展字段5 * <!-- end-user-doc -->
	 */
	public void setExtField5(String extField5) {
		this.extField5 = extField5;
	}

	public String getExtField5() {
		return extField5;
	}
}
