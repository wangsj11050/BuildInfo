package org.tinygroup.buildinfo.service.inter.dto;

import java.io.Serializable;

public class BuildServicecenterDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7657250544137005152L;
	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 服务中心编码 * <!-- end-user-doc -->
	 */
	private String servicecenterCode;

	/**
	 * <!-- begin-user-doc --> 服务中心名称 * <!-- end-user-doc -->
	 */
	private String servicecenterName;

	/**
	 * <!-- begin-user-doc --> 服务中心描述 * <!-- end-user-doc -->
	 */
	private String servicecenterDesc;

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
	 * <!-- begin-user-doc --> 服务中心编码 * <!-- end-user-doc -->
	 */
	public void setServicecenterCode(String servicecenterCode) {
		this.servicecenterCode = servicecenterCode;
	}

	public String getServicecenterCode() {
		return servicecenterCode;
	}

	/**
	 * <!-- begin-user-doc --> 服务中心名称 * <!-- end-user-doc -->
	 */
	public void setServicecenterName(String servicecenterName) {
		this.servicecenterName = servicecenterName;
	}

	public String getServicecenterName() {
		return servicecenterName;
	}

	/**
	 * <!-- begin-user-doc --> 服务中心描述 * <!-- end-user-doc -->
	 */
	public void setServicecenterDesc(String servicecenterDesc) {
		this.servicecenterDesc = servicecenterDesc;
	}

	public String getServicecenterDesc() {
		return servicecenterDesc;
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
