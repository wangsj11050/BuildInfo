
package org.tinygroup.workplan.dao.inter.constant;

import org.tinygroup.tinysqldsl.base.Column;
import org.tinygroup.tinysqldsl.base.Table;
import org.tinygroup.workplan.dao.inter.pojo.TUserDemandPlann;

/**
 * <!-- begin-user-doc --> 人员需求计划表 * <!-- end-user-doc -->
 */
public class TUserDemandPlannTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public static final TUserDemandPlannTable T_USER_DEMAND_PLANN_TABLE = new TUserDemandPlannTable();

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	public final Column ID = new Column(this, "id");
	/**
	 * <!-- begin-user-doc --> 子需求编号 * <!-- end-user-doc -->
	 */
	public final Column SUB_PLANN_ID = new Column(this, "sub_plann_id");
	/**
	 * <!-- begin-user-doc --> 子需求名称 * <!-- end-user-doc -->
	 */
	public final Column SUB_PLANN_NAME = new Column(this, "sub_plann_name");
	/**
	 * <!-- begin-user-doc --> 平台类别 * <!-- end-user-doc -->
	 */
	public final Column PLATFORM_TYPE = new Column(this, "platform_type");
	/**
	 * <!-- begin-user-doc --> 需求编号 * <!-- end-user-doc -->
	 */
	public final Column PLANN_NUMBER = new Column(this, "plann_number");
	/**
	 * <!-- begin-user-doc --> 具体开发人员 * <!-- end-user-doc -->
	 */
	public final Column DEVELOPMENT_USER = new Column(this, "development_user");
	/**
	 * <!-- begin-user-doc --> 计划上线日期 * <!-- end-user-doc -->
	 */
	public final Column PLANN_DATE = new Column(this, "plann_date");
	/**
	 * <!-- begin-user-doc --> 实际上线日期 * <!-- end-user-doc -->
	 */
	public final Column ACTUAL_DATE = new Column(this, "actual_date");
	/**
	 * <!-- begin-user-doc --> 开发过程描述 * <!-- end-user-doc -->
	 */
	public final Column DEVELOPMENT_PROCESS = new Column(this, "development_process");
	/**
	 * <!-- begin-user-doc --> 子需求问题描述 * <!-- end-user-doc -->
	 */
	public final Column SUB_PLANN_PROBLEM = new Column(this, "sub_plann_problem");
	/**
	 * <!-- begin-user-doc --> 需求状态 * <!-- end-user-doc -->
	 */
	public final Column PLANN_STATE = new Column(this, "plann_state");
	/**
	 * <!-- begin-user-doc --> 扩展字段1 * <!-- end-user-doc -->
	 */
	public final Column EXT_FIELD_1 = new Column(this, "ext_field_1");
	/**
	 * <!-- begin-user-doc --> 扩展字段2 * <!-- end-user-doc -->
	 */
	public final Column EXT_FIELD_2 = new Column(this, "ext_field_2");
	/**
	 * <!-- begin-user-doc --> 扩展字段3 * <!-- end-user-doc -->
	 */
	public final Column EXT_FIELD_3 = new Column(this, "ext_field_3");
	/**
	 * <!-- begin-user-doc --> 扩展字段4 * <!-- end-user-doc -->
	 */
	public final Column EXT_FIELD_4 = new Column(this, "ext_field_4");
	/**
	 * <!-- begin-user-doc --> 扩展字段5 * <!-- end-user-doc -->
	 */
	public final Column EXT_FIELD_5 = new Column(this, "ext_field_5");

	public TUserDemandPlannTable() {
		super("t_user_demand_plann");
	}

	public TUserDemandPlannTable(String schemaName) {
		super(schemaName, "t_user_demand_plann");
	}

	public TUserDemandPlannTable(String schemaName, String alias) {
		super(schemaName, "t_user_demand_plann", alias);
	}

	public TUserDemandPlannTable(String schemaName, String alias, boolean withAs) {
		super(schemaName, "t_user_demand_plann", alias, withAs);
	}

	public Class<TUserDemandPlann> getPojoType() {
		return TUserDemandPlann.class;
	}

}
