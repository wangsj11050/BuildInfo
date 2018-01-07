package org.tinygroup.buildinfo.service.inter.dto;

import java.io.Serializable;

public class BuildRecruitDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5265754562820089978L;

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 职位名称 * <!-- end-user-doc -->
	 */
	private String recruitName;

	/**
	 * <!-- begin-user-doc --> 招聘状态 * <!-- end-user-doc -->
	 */
	private String recruitState;

	/**
	 * <!-- begin-user-doc --> 发布时间 * <!-- end-user-doc -->
	 */
	private String pubTime;

	/**
	 * <!-- begin-user-doc --> 发布人 * <!-- end-user-doc -->
	 */
	private String pubUser;

	/**
	 * <!-- begin-user-doc --> 修改时间 * <!-- end-user-doc -->
	 */
	private String updateTime;

	/**
	 * <!-- begin-user-doc --> 更新人 * <!-- end-user-doc -->
	 */
	private String updateUser;

	/**
	 * <!-- begin-user-doc --> 职位描述 * <!-- end-user-doc -->
	 */
	private String recruitDesc;

	/**
	 * <!-- begin-user-doc --> 任职职责 * <!-- end-user-doc -->
	 */
	private String recruitSeniority;

	/**
	 * <!-- begin-user-doc --> 扩展字段 * <!-- end-user-doc -->
	 */
	private String extField;

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
	 * <!-- begin-user-doc --> 职位名称 * <!-- end-user-doc -->
	 */
	public void setRecruitName(String recruitName) {
		this.recruitName = recruitName;
	}

	public String getRecruitName() {
		return recruitName;
	}

	/**
	 * <!-- begin-user-doc --> 招聘状态 * <!-- end-user-doc -->
	 */
	public void setRecruitState(String recruitState) {
		this.recruitState = recruitState;
	}

	public String getRecruitState() {
		return recruitState;
	}

	/**
	 * <!-- begin-user-doc --> 发布时间 * <!-- end-user-doc -->
	 */
	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}

	public String getPubTime() {
		return pubTime;
	}

	/**
	 * <!-- begin-user-doc --> 发布人 * <!-- end-user-doc -->
	 */
	public void setPubUser(String pubUser) {
		this.pubUser = pubUser;
	}

	public String getPubUser() {
		return pubUser;
	}

	/**
	 * <!-- begin-user-doc --> 修改时间 * <!-- end-user-doc -->
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * <!-- begin-user-doc --> 更新人 * <!-- end-user-doc -->
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * <!-- begin-user-doc --> 职位描述 * <!-- end-user-doc -->
	 */
	public void setRecruitDesc(String recruitDesc) {
		this.recruitDesc = recruitDesc;
	}

	public String getRecruitDesc() {
		return recruitDesc;
	}

	/**
	 * <!-- begin-user-doc --> 任职职责 * <!-- end-user-doc -->
	 */
	public void setRecruitSeniority(String recruitSeniority) {
		this.recruitSeniority = recruitSeniority;
	}

	public String getRecruitSeniority() {
		return recruitSeniority;
	}

	/**
	 * <!-- begin-user-doc --> 扩展字段 * <!-- end-user-doc -->
	 */
	public void setExtField(String extField) {
		this.extField = extField;
	}

	public String getExtField() {
		return extField;
	}
}
