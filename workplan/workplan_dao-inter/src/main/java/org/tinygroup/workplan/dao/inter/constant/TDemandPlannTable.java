
package org.tinygroup.workplan.dao.inter.constant;

import org.tinygroup.tinysqldsl.base.Column;
import org.tinygroup.tinysqldsl.base.Table;
import org.tinygroup.workplan.dao.inter.pojo.TDemandPlann;

/**
 * <!-- begin-user-doc --> 日常需求跟踪计划表 * <!-- end-user-doc -->
 */
public class TDemandPlannTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public static final TDemandPlannTable T_DEMAND_PLANN_TABLE = new TDemandPlannTable();

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	public final Column ID = new Column(this, "id");
	/**
	 * <!-- begin-user-doc --> 平台类别 * <!-- end-user-doc -->
	 */
	public final Column PLATFORM_TYPE = new Column(this, "platform_type");
	/**
	 * <!-- begin-user-doc --> 需求编号 * <!-- end-user-doc -->
	 */
	public final Column PLANN_NUMBER = new Column(this, "plann_number");
	/**
	 * <!-- begin-user-doc --> 需求名称 * <!-- end-user-doc -->
	 */
	public final Column PLANN_NAME = new Column(this, "plann_name");
	/**
	 * <!-- begin-user-doc --> 关联系统 * <!-- end-user-doc -->
	 */
	public final Column RELEVANCE_SYSTEM = new Column(this, "relevance_system");
	/**
	 * <!-- begin-user-doc --> 实施模型 * <!-- end-user-doc -->
	 */
	public final Column IMPLEMENT_MODEL = new Column(this, "implement_model");
	/**
	 * <!-- begin-user-doc --> 项目技术经理 * <!-- end-user-doc -->
	 */
	public final Column TECHNICAL_MANAGER = new Column(this, "technical_manager");
	/**
	 * <!-- begin-user-doc --> 开发人员 * <!-- end-user-doc -->
	 */
	public final Column DEVELOPERS = new Column(this, "developers");
	/**
	 * <!-- begin-user-doc --> 功能点描述 * <!-- end-user-doc -->
	 */
	public final Column PLANN_POINT = new Column(this, "plann_point");
	/**
	 * <!-- begin-user-doc --> 计划上线日期 * <!-- end-user-doc -->
	 */
	public final Column PLANN_DATE = new Column(this, "plann_date");
	/**
	 * <!-- begin-user-doc --> 实际上线日期 * <!-- end-user-doc -->
	 */
	public final Column ACTUAL_DATE = new Column(this, "actual_date");
	/**
	 * <!-- begin-user-doc --> CQ状态 * <!-- end-user-doc -->
	 */
	public final Column CQ_STATE = new Column(this, "cq_state");
	/**
	 * <!-- begin-user-doc --> 创建人员 * <!-- end-user-doc -->
	 */
	public final Column CREATE_USER = new Column(this, "create_user");
	/**
	 * <!-- begin-user-doc --> 创建时间 * <!-- end-user-doc -->
	 */
	public final Column CREATE_TIME = new Column(this, "create_time");
	/**
	 * <!-- begin-user-doc --> 最后更新人员 * <!-- end-user-doc -->
	 */
	public final Column LAST_UPDATE_USER = new Column(this, "last_update_user");
	/**
	 * <!-- begin-user-doc --> 最后更新时间 * <!-- end-user-doc -->
	 */
	public final Column LAST_UPDATE_TIME = new Column(this, "last_update_time");
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

	public TDemandPlannTable() {
		super("t_demand_plann");
	}

	public TDemandPlannTable(String schemaName) {
		super(schemaName, "t_demand_plann");
	}

	public TDemandPlannTable(String schemaName, String alias) {
		super(schemaName, "t_demand_plann", alias);
	}

	public TDemandPlannTable(String schemaName, String alias, boolean withAs) {
		super(schemaName, "t_demand_plann", alias, withAs);
	}

	public Class<TDemandPlann> getPojoType() {
		return TDemandPlann.class;
	}

}
