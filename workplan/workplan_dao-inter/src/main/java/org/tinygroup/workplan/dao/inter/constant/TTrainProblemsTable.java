
package org.tinygroup.workplan.dao.inter.constant;

import org.tinygroup.tinysqldsl.base.Column;
import org.tinygroup.tinysqldsl.base.Table;
import org.tinygroup.workplan.dao.inter.pojo.TTrainProblems;

/**
 * <!-- begin-user-doc --> 培训相关习题集 * <!-- end-user-doc -->
 */
public class TTrainProblemsTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public static final TTrainProblemsTable T_TRAIN_PROBLEMS_TABLE = new TTrainProblemsTable();

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	public final Column ID = new Column(this, "id");
	/**
	 * <!-- begin-user-doc --> 培训编号 * <!-- end-user-doc -->
	 */
	public final Column TRAIN_ID = new Column(this, "train_id");
	/**
	 * <!-- begin-user-doc --> 创建时间 * <!-- end-user-doc -->
	 */
	public final Column CREATE_TIME = new Column(this, "create_time");
	/**
	 * <!-- begin-user-doc --> 创建人员 * <!-- end-user-doc -->
	 */
	public final Column CREATE_USER = new Column(this, "create_user");
	/**
	 * <!-- begin-user-doc --> 培训问题名称 * <!-- end-user-doc -->
	 */
	public final Column PROBLEM_TITLE = new Column(this, "problem_title");
	/**
	 * <!-- begin-user-doc --> 问题描述 * <!-- end-user-doc -->
	 */
	public final Column PROBLEM_DESCRIBE = new Column(this, "problem_describe");
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

	public TTrainProblemsTable() {
		super("t_train_problems");
	}

	public TTrainProblemsTable(String schemaName) {
		super(schemaName, "t_train_problems");
	}

	public TTrainProblemsTable(String schemaName, String alias) {
		super(schemaName, "t_train_problems", alias);
	}

	public TTrainProblemsTable(String schemaName, String alias, boolean withAs) {
		super(schemaName, "t_train_problems", alias, withAs);
	}

	public Class<TTrainProblems> getPojoType() {
		return TTrainProblems.class;
	}

}
