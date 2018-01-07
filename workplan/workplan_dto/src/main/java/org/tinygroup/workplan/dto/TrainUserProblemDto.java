package org.tinygroup.workplan.dto;

import java.io.Serializable;
import java.util.Date;

public class TrainUserProblemDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6500704607461414749L;

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 问题集编号 * <!-- end-user-doc -->
	 */
	private Integer exampleId;

	/**
	 * <!-- begin-user-doc --> 培训人员 * <!-- end-user-doc -->
	 */
	private String trainUser;

	/**
	 * <!-- begin-user-doc --> 创建时间 * <!-- end-user-doc -->
	 */
	private String createTime;

	/**
	 * <!-- begin-user-doc --> 问题答案详解 * <!-- end-user-doc -->
	 */
	private String problemAnswer;

	/**
	 * <!-- begin-user-doc --> 答题时间 * <!-- end-user-doc -->
	 */
	private String answerTime;

	/**
	 * <!-- begin-user-doc --> 答复评价 * <!-- end-user-doc -->
	 */
	private String replyEvealuate;

	/**
	 * <!-- begin-user-doc --> 答复时间 * <!-- end-user-doc -->
	 */
	private String replyTime;

	/**
	 * <!-- begin-user-doc --> 答复人员 * <!-- end-user-doc -->
	 */
	private String replyUser;

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
	 * <!-- begin-user-doc --> 问题集编号 * <!-- end-user-doc -->
	 */
	public void setExampleId(Integer exampleId) {
		this.exampleId = exampleId;
	}

	public Integer getExampleId() {
		return exampleId;
	}

	/**
	 * <!-- begin-user-doc --> 培训人员 * <!-- end-user-doc -->
	 */
	public void setTrainUser(String trainUser) {
		this.trainUser = trainUser;
	}

	public String getTrainUser() {
		return trainUser;
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
	 * <!-- begin-user-doc --> 问题答案详解 * <!-- end-user-doc -->
	 */
	public void setProblemAnswer(String problemAnswer) {
		this.problemAnswer = problemAnswer;
	}

	public String getProblemAnswer() {
		return problemAnswer;
	}

	/**
	 * <!-- begin-user-doc --> 答题时间 * <!-- end-user-doc -->
	 */
	public void setAnswerTime(String answerTime) {
		this.answerTime = answerTime;
	}

	public String getAnswerTime() {
		return answerTime;
	}

	/**
	 * <!-- begin-user-doc --> 答复评价 * <!-- end-user-doc -->
	 */
	public void setReplyEvealuate(String replyEvealuate) {
		this.replyEvealuate = replyEvealuate;
	}

	public String getReplyEvealuate() {
		return replyEvealuate;
	}

	/**
	 * <!-- begin-user-doc --> 答复时间 * <!-- end-user-doc -->
	 */
	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}

	public String getReplyTime() {
		return replyTime;
	}

	/**
	 * <!-- begin-user-doc --> 答复人员 * <!-- end-user-doc -->
	 */
	public void setReplyUser(String replyUser) {
		this.replyUser = replyUser;
	}

	public String getReplyUser() {
		return replyUser;
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
