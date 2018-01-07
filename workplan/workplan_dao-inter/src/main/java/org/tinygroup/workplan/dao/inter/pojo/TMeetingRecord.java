
package org.tinygroup.workplan.dao.inter.pojo;

/**
 * <!-- begin-user-doc --> 会议记录表 * <!-- end-user-doc -->
 */
public class TMeetingRecord {

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 会议主题 * <!-- end-user-doc -->
	 */
	private String meetingSubject;

	/**
	 * <!-- begin-user-doc --> 会议时间 * <!-- end-user-doc -->
	 */
	private String meetingTime;

	/**
	 * <!-- begin-user-doc --> 地点 * <!-- end-user-doc -->
	 */
	private String meetingAddress;

	/**
	 * <!-- begin-user-doc --> 主持人 * <!-- end-user-doc -->
	 */
	private String meetingPresenter;

	/**
	 * <!-- begin-user-doc --> 记录人 * <!-- end-user-doc -->
	 */
	private String meetingRecorder;

	/**
	 * <!-- begin-user-doc --> 创建人员 * <!-- end-user-doc -->
	 */
	private String createUser;

	/**
	 * <!-- begin-user-doc --> 会议内容 * <!-- end-user-doc -->
	 */
	private String meetingContent;

	/**
	 * <!-- begin-user-doc --> 会议决议 * <!-- end-user-doc -->
	 */
	private String meetingResult;

	/**
	 * <!-- begin-user-doc --> 参会人员 * <!-- end-user-doc -->
	 */
	private String joinMeetingUser;

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
	 * <!-- begin-user-doc --> 会议主题 * <!-- end-user-doc -->
	 */
	public void setMeetingSubject(String meetingSubject) {
		this.meetingSubject = meetingSubject;
	}

	public String getMeetingSubject() {
		return meetingSubject;
	}

	/**
	 * <!-- begin-user-doc --> 会议时间 * <!-- end-user-doc -->
	 */
	public void setMeetingTime(String meetingTime) {
		this.meetingTime = meetingTime;
	}

	public String getMeetingTime() {
		return meetingTime;
	}

	/**
	 * <!-- begin-user-doc --> 地点 * <!-- end-user-doc -->
	 */
	public void setMeetingAddress(String meetingAddress) {
		this.meetingAddress = meetingAddress;
	}

	public String getMeetingAddress() {
		return meetingAddress;
	}

	/**
	 * <!-- begin-user-doc --> 主持人 * <!-- end-user-doc -->
	 */
	public void setMeetingPresenter(String meetingPresenter) {
		this.meetingPresenter = meetingPresenter;
	}

	public String getMeetingPresenter() {
		return meetingPresenter;
	}

	/**
	 * <!-- begin-user-doc --> 记录人 * <!-- end-user-doc -->
	 */
	public void setMeetingRecorder(String meetingRecorder) {
		this.meetingRecorder = meetingRecorder;
	}

	public String getMeetingRecorder() {
		return meetingRecorder;
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
	 * <!-- begin-user-doc --> 会议内容 * <!-- end-user-doc -->
	 */
	public void setMeetingContent(String meetingContent) {
		this.meetingContent = meetingContent;
	}

	public String getMeetingContent() {
		return meetingContent;
	}

	/**
	 * <!-- begin-user-doc --> 会议决议 * <!-- end-user-doc -->
	 */
	public void setMeetingResult(String meetingResult) {
		this.meetingResult = meetingResult;
	}

	public String getMeetingResult() {
		return meetingResult;
	}

	/**
	 * <!-- begin-user-doc --> 参会人员 * <!-- end-user-doc -->
	 */
	public void setJoinMeetingUser(String joinMeetingUser) {
		this.joinMeetingUser = joinMeetingUser;
	}

	public String getJoinMeetingUser() {
		return joinMeetingUser;
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
