
package org.tinygroup.buildinfo.dao.inter.pojo;

/**
 * <!-- begin-user-doc --> 服务种类表 * <!-- end-user-doc -->
 */
public class BuildServicetype {

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	private String serviceCode;
	/**
	 * <!-- begin-user-doc --> 服务名称 * <!-- end-user-doc -->
	 */
	private String serviceName;

	/**
	 * <!-- begin-user-doc --> 服务大类 * <!-- end-user-doc -->
	 */
	private String parentService;

	/**
	 * <!-- begin-user-doc --> 服务图标 * <!-- end-user-doc -->
	 */
	private String serviceIcon;
	/**
	 * <!-- begin-user-doc --> 备注 * <!-- end-user-doc -->
	 */
	private String remark;

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

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	/**
	 * <!-- begin-user-doc --> 服务名称 * <!-- end-user-doc -->
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceName() {
		return serviceName;
	}

	/**
	 * <!-- begin-user-doc --> 服务大类 * <!-- end-user-doc -->
	 */
	public void setParentService(String parentService) {
		this.parentService = parentService;
	}

	public String getParentService() {
		return parentService;
	}

	public String getServiceIcon() {
		return serviceIcon;
	}

	public void setServiceIcon(String serviceIcon) {
		this.serviceIcon = serviceIcon;
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
