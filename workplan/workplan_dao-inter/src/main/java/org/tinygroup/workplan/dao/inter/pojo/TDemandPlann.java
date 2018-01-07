
package org.tinygroup.workplan.dao.inter.pojo;

/**
 * <!-- begin-user-doc --> 日常需求跟踪计划表 * <!-- end-user-doc -->
 */
public class TDemandPlann {

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 平台类别 * <!-- end-user-doc -->
	 */
	private String platformType;

	/**
	 * <!-- begin-user-doc --> 需求编号 * <!-- end-user-doc -->
	 */
	private String plannNumber;

	/**
	 * <!-- begin-user-doc --> 需求名称 * <!-- end-user-doc -->
	 */
	private String plannName;

	/**
	 * <!-- begin-user-doc --> 关联系统 * <!-- end-user-doc -->
	 */
	private String relevanceSystem;

	/**
	 * <!-- begin-user-doc --> 实施模型 * <!-- end-user-doc -->
	 */
	private String implementModel;

	/**
	 * <!-- begin-user-doc --> 项目技术经理 * <!-- end-user-doc -->
	 */
	private String technicalManager;

	/**
	 * <!-- begin-user-doc --> 开发人员 * <!-- end-user-doc -->
	 */
	private String developers;

	/**
	 * <!-- begin-user-doc --> 功能点描述 * <!-- end-user-doc -->
	 */
	private String plannPoint;

	/**
	 * <!-- begin-user-doc --> 计划上线日期 * <!-- end-user-doc -->
	 */
	private String plannDate;

	/**
	 * <!-- begin-user-doc --> 实际上线日期 * <!-- end-user-doc -->
	 */
	private String actualDate;

	/**
	 * <!-- begin-user-doc --> CQ状态 * <!-- end-user-doc -->
	 */
	private String cqState;

	/**
	 * <!-- begin-user-doc --> 创建人员 * <!-- end-user-doc -->
	 */
	private String createUser;

	/**
	 * <!-- begin-user-doc --> 创建时间 * <!-- end-user-doc -->
	 */
	private String createTime;

	/**
	 * <!-- begin-user-doc --> 最后更新人员 * <!-- end-user-doc -->
	 */
	private String lastUpdateUser;

	/**
	 * <!-- begin-user-doc --> 最后更新时间 * <!-- end-user-doc -->
	 */
	private String lastUpdateTime;

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
	 * <!-- begin-user-doc --> 需求名称 * <!-- end-user-doc -->
	 */
	public void setPlannName(String plannName) {
		this.plannName = plannName;
	}

	public String getPlannName() {
		return plannName;
	}

	/**
	 * <!-- begin-user-doc --> 关联系统 * <!-- end-user-doc -->
	 */
	public void setRelevanceSystem(String relevanceSystem) {
		this.relevanceSystem = relevanceSystem;
	}

	public String getRelevanceSystem() {
		return relevanceSystem;
	}

	/**
	 * <!-- begin-user-doc --> 实施模型 * <!-- end-user-doc -->
	 */
	public void setImplementModel(String implementModel) {
		this.implementModel = implementModel;
	}

	public String getImplementModel() {
		return implementModel;
	}

	/**
	 * <!-- begin-user-doc --> 项目技术经理 * <!-- end-user-doc -->
	 */
	public void setTechnicalManager(String technicalManager) {
		this.technicalManager = technicalManager;
	}

	public String getTechnicalManager() {
		return technicalManager;
	}

	/**
	 * <!-- begin-user-doc --> 开发人员 * <!-- end-user-doc -->
	 */
	public void setDevelopers(String developers) {
		this.developers = developers;
	}

	public String getDevelopers() {
		return developers;
	}

	/**
	 * <!-- begin-user-doc --> 功能点描述 * <!-- end-user-doc -->
	 */
	public void setPlannPoint(String plannPoint) {
		this.plannPoint = plannPoint;
	}

	public String getPlannPoint() {
		return plannPoint;
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
	 * <!-- begin-user-doc --> CQ状态 * <!-- end-user-doc -->
	 */
	public void setCqState(String cqState) {
		this.cqState = cqState;
	}

	public String getCqState() {
		return cqState;
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
	 * <!-- begin-user-doc --> 最后更新人员 * <!-- end-user-doc -->
	 */
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	/**
	 * <!-- begin-user-doc --> 最后更新时间 * <!-- end-user-doc -->
	 */
	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
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
