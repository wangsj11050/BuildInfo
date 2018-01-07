
package org.tinygroup.buildinfo.dao.inter.pojo;

/**
 * <!-- begin-user-doc --> 发布需求 * <!-- end-user-doc -->
 */
public class BuildPubdemand {

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> NAME * <!-- end-user-doc -->
	 */
	private String name;

	/**
	 * <!-- begin-user-doc --> 客户电话 * <!-- end-user-doc -->
	 */
	private String phone;

	/**
	 * <!-- begin-user-doc --> 客户需求 * <!-- end-user-doc -->
	 */
	private String demand;

	private String demandState;

	/**
	 * <!-- begin-user-doc --> 需求描述 * <!-- end-user-doc -->
	 */
	private String demandDesc;

	/**
	 * <!-- begin-user-doc --> 顾问编号 * <!-- end-user-doc -->
	 */
	private Integer adisverId;

	/**
	 * <!-- begin-user-doc --> 顾问姓名 * <!-- end-user-doc -->
	 */
	private String adisverName;
	
	private String pubTime;
	
	private String updateTime;

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
	 * <!-- begin-user-doc --> NAME * <!-- end-user-doc -->
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> 客户电话 * <!-- end-user-doc -->
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	/**
	 * <!-- begin-user-doc --> 客户需求 * <!-- end-user-doc -->
	 */
	public void setDemand(String demand) {
		this.demand = demand;
	}

	public String getDemand() {
		return demand;
	}

	public String getDemandState() {
		return demandState;
	}

	public void setDemandState(String demandState) {
		this.demandState = demandState;
	}
	/**
	 * <!-- begin-user-doc --> 需求描述 * <!-- end-user-doc -->
	 */
	public void setDemandDesc(String demandDesc) {
		this.demandDesc = demandDesc;
	}

	public String getDemandDesc() {
		return demandDesc;
	}

	/**
	 * <!-- begin-user-doc --> 顾问编号 * <!-- end-user-doc -->
	 */
	public void setAdisverId(Integer adisverId) {
		this.adisverId = adisverId;
	}

	public Integer getAdisverId() {
		return adisverId;
	}

	/**
	 * <!-- begin-user-doc --> 顾问姓名 * <!-- end-user-doc -->
	 */
	public void setAdisverName(String adisverName) {
		this.adisverName = adisverName;
	}

	public String getAdisverName() {
		return adisverName;
	}

	public String getPubTime() {
		return pubTime;
	}

	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
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
