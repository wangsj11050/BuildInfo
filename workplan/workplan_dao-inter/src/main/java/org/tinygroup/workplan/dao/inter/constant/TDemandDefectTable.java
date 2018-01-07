
package org.tinygroup.workplan.dao.inter.constant;

import org.tinygroup.tinysqldsl.base.Column;
import org.tinygroup.tinysqldsl.base.Table;
import org.tinygroup.workplan.dao.inter.pojo.TDemandDefect;

/**
 * <!-- begin-user-doc --> 需求缺陷跟踪表 * <!-- end-user-doc -->
 */
public class TDemandDefectTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public static final TDemandDefectTable T_DEMAND_DEFECT_TABLE = new TDemandDefectTable();

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
	 * <!-- begin-user-doc --> 发生时间 * <!-- end-user-doc -->
	 */
	public final Column HAPPEN_DATE = new Column(this, "happen_date");
	/**
	 * <!-- begin-user-doc --> 问题现象 * <!-- end-user-doc -->
	 */
	public final Column PROBLEM_PHENOMENON = new Column(this, "problem_phenomenon");
	/**
	 * <!-- begin-user-doc --> 问题描述 * <!-- end-user-doc -->
	 */
	public final Column PROBLEM_DESCRIBE = new Column(this, "problem_describe");
	/**
	 * <!-- begin-user-doc --> 解决方案 * <!-- end-user-doc -->
	 */
	public final Column PROBLEM_SOLUTION = new Column(this, "problem_solution");
	/**
	 * <!-- begin-user-doc --> 创建时间 * <!-- end-user-doc -->
	 */
	public final Column WORKPLAN_CREATE_DATE = new Column(this, "workplan_create_date");
	/**
	 * <!-- begin-user-doc --> 创建人员 * <!-- end-user-doc -->
	 */
	public final Column CREATE_USER = new Column(this, "create_user");
	/**
	 * <!-- begin-user-doc --> 维护时间 * <!-- end-user-doc -->
	 */
	public final Column UPDATE_DATE = new Column(this, "update_date");
	/**
	 * <!-- begin-user-doc --> 维护人员 * <!-- end-user-doc -->
	 */
	public final Column UPDATE_USER = new Column(this, "update_user");
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

	public TDemandDefectTable() {
		super("t_demand_defect");
	}

	public TDemandDefectTable(String schemaName) {
		super(schemaName, "t_demand_defect");
	}

	public TDemandDefectTable(String schemaName, String alias) {
		super(schemaName, "t_demand_defect", alias);
	}

	public TDemandDefectTable(String schemaName, String alias, boolean withAs) {
		super(schemaName, "t_demand_defect", alias, withAs);
	}

	public Class<TDemandDefect> getPojoType() {
		return TDemandDefect.class;
	}

}
