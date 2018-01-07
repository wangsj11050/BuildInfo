package org.tinygroup.workplan.dto;

import java.io.Serializable;

public class UserTaskDto implements Serializable {

	private static final long serialVersionUID = -8342858124083087424L;

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 关联编号 * <!-- end-user-doc -->
	 */
	private Integer lineId;

	/**
	 * <!-- begin-user-doc --> 任务类别 * <!-- end-user-doc -->
	 */
	private Character taskType;

	/**
	 * <!-- begin-user-doc --> 创建人员 * <!-- end-user-doc -->
	 */
	private String createUser;

	/**
	 * <!-- begin-user-doc --> 责任人 * <!-- end-user-doc -->
	 */
	private String dutyUser;

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
	 * <!-- begin-user-doc --> 关联编号 * <!-- end-user-doc -->
	 */
	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

	public Integer getLineId() {
		return lineId;
	}

	/**
	 * <!-- begin-user-doc --> 任务类别 * <!-- end-user-doc -->
	 */
	public void setTaskType(Character taskType) {
		this.taskType = taskType;
	}

	public Character getTaskType() {
		return taskType;
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
	 * <!-- begin-user-doc --> 责任人 * <!-- end-user-doc -->
	 */
	public void setDutyUser(String dutyUser) {
		this.dutyUser = dutyUser;
	}

	public String getDutyUser() {
		return dutyUser;
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
