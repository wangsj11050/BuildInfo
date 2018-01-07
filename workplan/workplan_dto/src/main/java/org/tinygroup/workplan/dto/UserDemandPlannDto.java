package org.tinygroup.workplan.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDemandPlannDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7050428314290244251L;

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 子需求编号 * <!-- end-user-doc -->
	 */
	private String subPlannId;

	/**
	 * <!-- begin-user-doc --> 子需求名称 * <!-- end-user-doc -->
	 */
	private String subPlannName;

	/**
	 * <!-- begin-user-doc --> 平台类别 * <!-- end-user-doc -->
	 */
	private String platformType;

	/**
	 * <!-- begin-user-doc --> 需求编号 * <!-- end-user-doc -->
	 */
	private String plannNumber;

	/**
	 * <!-- begin-user-doc --> 具体开发人员 * <!-- end-user-doc -->
	 */
	private String developmentUser;

	/**
	 * <!-- begin-user-doc --> 计划上线日期 * <!-- end-user-doc -->
	 */
	private String plannDate;

	/**
	 * <!-- begin-user-doc --> 实际上线日期 * <!-- end-user-doc -->
	 */
	private String actualDate;

	/**
	 * <!-- begin-user-doc --> 开发过程描述 * <!-- end-user-doc -->
	 */
	private String developmentProcess;

	/**
	 * <!-- begin-user-doc --> 子需求问题描述 * <!-- end-user-doc -->
	 */
	private String subPlannProblem;

	/**
	 * <!-- begin-user-doc --> 需求状态 * <!-- end-user-doc -->
	 */
	private String plannState;

	/**
	 * <!-- begin-user-doc --> 扩展字段1 * <!-- end-user-doc -->
	 */
	private String extField_1;

	/**
	 * <!-- begin-user-doc --> 扩展字段2 * <!-- end-user-doc -->
	 */
	private String extField_2;

	/**
	 * <!-- begin-user-doc --> 扩展字段3 * <!-- end-user-doc -->
	 */
	private String extField_3;

	/**
	 * <!-- begin-user-doc --> 扩展字段4 * <!-- end-user-doc -->
	 */
	private String extField_4;

	/**
	 * <!-- begin-user-doc --> 扩展字段5 * <!-- end-user-doc -->
	 */
	private String extField_5;

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
	 * <!-- begin-user-doc --> 子需求编号 * <!-- end-user-doc -->
	 */
	public void setSubPlannId(String subPlannId) {
		this.subPlannId = subPlannId;
	}

	public String getSubPlannId() {
		return subPlannId;
	}

	/**
	 * <!-- begin-user-doc --> 子需求名称 * <!-- end-user-doc -->
	 */
	public void setSubPlannName(String subPlannName) {
		this.subPlannName = subPlannName;
	}

	public String getSubPlannName() {
		return subPlannName;
	}

	/**
	 * <!-- begin-user-doc --> 平台类别 * <!-- end-user-doc -->
	 */
	public void setPlatformType(String platformType) {
		this.platformType = platformType;
	}

	public String getPlatformType() {
		return platformType;
	}

	/**
	 * <!-- begin-user-doc --> 需求编号 * <!-- end-user-doc -->
	 */
	public void setPlannNumber(String plannNumber) {
		this.plannNumber = plannNumber;
	}

	public String getPlannNumber() {
		return plannNumber;
	}

	/**
	 * <!-- begin-user-doc --> 具体开发人员 * <!-- end-user-doc -->
	 */
	public void setDevelopmentUser(String developmentUser) {
		this.developmentUser = developmentUser;
	}

	public String getDevelopmentUser() {
		return developmentUser;
	}

	/**
	 * <!-- begin-user-doc --> 计划上线日期 * <!-- end-user-doc -->
	 */
	public void setPlannDate(String plannDate) {
		this.plannDate = plannDate;
	}

	public String getPlannDate() {
		return plannDate;
	}

	/**
	 * <!-- begin-user-doc --> 实际上线日期 * <!-- end-user-doc -->
	 */
	public void setActualDate(String actualDate) {
		this.actualDate = actualDate;
	}

	public String getActualDate() {
		return actualDate;
	}

	/**
	 * <!-- begin-user-doc --> 开发过程描述 * <!-- end-user-doc -->
	 */
	public void setDevelopmentProcess(String developmentProcess) {
		this.developmentProcess = developmentProcess;
	}

	public String getDevelopmentProcess() {
		return developmentProcess;
	}

	/**
	 * <!-- begin-user-doc --> 子需求问题描述 * <!-- end-user-doc -->
	 */
	public void setSubPlannProblem(String subPlannProblem) {
		this.subPlannProblem = subPlannProblem;
	}

	public String getSubPlannProblem() {
		return subPlannProblem;
	}

	/**
	 * <!-- begin-user-doc --> 需求状态 * <!-- end-user-doc -->
	 */
	public void setPlannState(String plannState) {
		this.plannState = plannState;
	}

	public String getPlannState() {
		return plannState;
	}

	public String getExtField_1() {
		return extField_1;
	}

	public void setExtField_1(String extField_1) {
		this.extField_1 = extField_1;
	}

	public String getExtField_2() {
		return extField_2;
	}

	public void setExtField_2(String extField_2) {
		this.extField_2 = extField_2;
	}

	public String getExtField_3() {
		return extField_3;
	}

	public void setExtField_3(String extField_3) {
		this.extField_3 = extField_3;
	}

	public String getExtField_4() {
		return extField_4;
	}

	public void setExtField_4(String extField_4) {
		this.extField_4 = extField_4;
	}

	public String getExtField_5() {
		return extField_5;
	}

	public void setExtField_5(String extField_5) {
		this.extField_5 = extField_5;
	}

}
