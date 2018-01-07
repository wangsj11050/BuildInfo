
package org.tinygroup.workplan.dao.inter.pojo;

/**
 * <!-- begin-user-doc --> 会议问题明细表 * <!-- end-user-doc -->
 */
public class TMeetingProblem {

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 会议编号 * <!-- end-user-doc -->
	 */
	private Integer meetimgId;

	/**
	 * <!-- begin-user-doc --> 问题描述 * <!-- end-user-doc -->
	 */
	private String problemContent;

	/**
	 * <!-- begin-user-doc --> 责任人 * <!-- end-user-doc -->
	 */
	private String dutyUser;

	/**
	 * <!-- begin-user-doc --> 解决日期 * <!-- end-user-doc -->
	 */
	private String solveDate;

	/**
	 * <!-- begin-user-doc --> 跟踪人 * <!-- end-user-doc -->
	 */
	private String trackUser;

	/**
	 * <!-- begin-user-doc --> 状态 * <!-- end-user-doc -->
	 */
	private String status;

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
	 * <!-- begin-user-doc --> 会议编号 * <!-- end-user-doc -->
	 */
	public void setMeetimgId(Integer meetimgId) {
		this.meetimgId = meetimgId;
	}

	public Integer getMeetimgId() {
		return meetimgId;
	}

	/**
	 * <!-- begin-user-doc --> 问题描述 * <!-- end-user-doc -->
	 */
	public void setProblemContent(String problemContent) {
		this.problemContent = problemContent;
	}

	public String getProblemContent() {
		return problemContent;
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

	/**
	 * <!-- begin-user-doc --> 解决日期 * <!-- end-user-doc -->
	 */
	public void setSolveDate(String solveDate) {
		this.solveDate = solveDate;
	}

	public String getSolveDate() {
		return solveDate;
	}

	/**
	 * <!-- begin-user-doc --> 跟踪人 * <!-- end-user-doc -->
	 */
	public void setTrackUser(String trackUser) {
		this.trackUser = trackUser;
	}

	public String getTrackUser() {
		return trackUser;
	}

	/**
	 * <!-- begin-user-doc --> 状态 * <!-- end-user-doc -->
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
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
