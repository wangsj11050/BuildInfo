
package org.tinygroup.workplan.dao.inter.constant;

import org.tinygroup.tinysqldsl.base.Column;
import org.tinygroup.tinysqldsl.base.Table;
import org.tinygroup.workplan.dao.inter.pojo.TMeetingProblem;

/**
 * <!-- begin-user-doc --> 会议问题明细表 * <!-- end-user-doc -->
 */
public class TMeetingProblemTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public static final TMeetingProblemTable T_MEETING_PROBLEM_TABLE = new TMeetingProblemTable();

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	public final Column ID = new Column(this, "id");
	/**
	 * <!-- begin-user-doc --> 会议编号 * <!-- end-user-doc -->
	 */
	public final Column MEETIMG_ID = new Column(this, "meetimg_id");
	/**
	 * <!-- begin-user-doc --> 问题描述 * <!-- end-user-doc -->
	 */
	public final Column PROBLEM_CONTENT = new Column(this, "problem_content");
	/**
	 * <!-- begin-user-doc --> 责任人 * <!-- end-user-doc -->
	 */
	public final Column DUTY_USER = new Column(this, "duty_user");
	/**
	 * <!-- begin-user-doc --> 解决日期 * <!-- end-user-doc -->
	 */
	public final Column SOLVE_DATE = new Column(this, "solve_date");
	/**
	 * <!-- begin-user-doc --> 跟踪人 * <!-- end-user-doc -->
	 */
	public final Column TRACK_USER = new Column(this, "track_user");
	/**
	 * <!-- begin-user-doc --> 状态 * <!-- end-user-doc -->
	 */
	public final Column STATUS = new Column(this, "status");
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

	public TMeetingProblemTable() {
		super("t_meeting_problem");
	}

	public TMeetingProblemTable(String schemaName) {
		super(schemaName, "t_meeting_problem");
	}

	public TMeetingProblemTable(String schemaName, String alias) {
		super(schemaName, "t_meeting_problem", alias);
	}

	public TMeetingProblemTable(String schemaName, String alias, boolean withAs) {
		super(schemaName, "t_meeting_problem", alias, withAs);
	}

	public Class<TMeetingProblem> getPojoType() {
		return TMeetingProblem.class;
	}

}
