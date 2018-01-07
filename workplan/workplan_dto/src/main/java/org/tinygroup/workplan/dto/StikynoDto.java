package org.tinygroup.workplan.dto;

import java.io.Serializable;
import java.util.Date;

public class StikynoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1307342748067272938L;

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 创建人员 * <!-- end-user-doc -->
	 */
	private String createUser;

	/**
	 * <!-- begin-user-doc --> 创建时间 * <!-- end-user-doc -->
	 */
	private String createTime;

	/**
	 * <!-- begin-user-doc --> 标题 * <!-- end-user-doc -->
	 */
	private String tilte;

	/**
	 * <!-- begin-user-doc --> 内容 * <!-- end-user-doc -->
	 */
	private String content;

	/**
	 * <!-- begin-user-doc --> TYPE * <!-- end-user-doc -->
	 */
	private Integer type;

	/**
	 * <!-- begin-user-doc --> 拟处理时间 * <!-- end-user-doc -->
	 */
	private String handleTime;

	/**
	 * <!-- begin-user-doc --> 拟解决时间 * <!-- end-user-doc -->
	 */
	private String solveTime;

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
	 * <!-- begin-user-doc --> 标题 * <!-- end-user-doc -->
	 */
	public void setTilte(String tilte) {
		this.tilte = tilte;
	}

	public String getTilte() {
		return tilte;
	}

	/**
	 * <!-- begin-user-doc --> 内容 * <!-- end-user-doc -->
	 */
	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	/**
	 * <!-- begin-user-doc --> TYPE * <!-- end-user-doc -->
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> 拟处理时间 * <!-- end-user-doc -->
	 */
	public void setHandleTime(String handleTime) {
		this.handleTime = handleTime;
	}

	public String getHandleTime() {
		return handleTime;
	}

	/**
	 * <!-- begin-user-doc --> 拟解决时间 * <!-- end-user-doc -->
	 */
	public void setSolveTime(String solveTime) {
		this.solveTime = solveTime;
	}

	public String getSolveTime() {
		return solveTime;
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
