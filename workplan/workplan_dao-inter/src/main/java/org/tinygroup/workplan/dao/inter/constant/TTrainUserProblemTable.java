
package org.tinygroup.workplan.dao.inter.constant;

import org.tinygroup.tinysqldsl.base.Column;
import org.tinygroup.tinysqldsl.base.Table;
import org.tinygroup.workplan.dao.inter.pojo.TTrainUserProblem;

/**
 * <!-- begin-user-doc --> 培训人员答题明细表 * <!-- end-user-doc -->
 */
public class TTrainUserProblemTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public static final TTrainUserProblemTable T_TRAIN_USER_PROBLEM_TABLE = new TTrainUserProblemTable();

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	public final Column ID = new Column(this, "id");
	/**
	 * <!-- begin-user-doc --> 问题集编号 * <!-- end-user-doc -->
	 */
	public final Column EXAMPLE_ID = new Column(this, "example_id");
	/**
	 * <!-- begin-user-doc --> 培训人员 * <!-- end-user-doc -->
	 */
	public final Column TRAIN_USER = new Column(this, "train_user");
	/**
	 * <!-- begin-user-doc --> 创建时间 * <!-- end-user-doc -->
	 */
	public final Column CREATE_TIME = new Column(this, "create_time");
	/**
	 * <!-- begin-user-doc --> 问题答案详解 * <!-- end-user-doc -->
	 */
	public final Column PROBLEM_ANSWER = new Column(this, "problem_answer");
	/**
	 * <!-- begin-user-doc --> 答题时间 * <!-- end-user-doc -->
	 */
	public final Column ANSWER_TIME = new Column(this, "answer_time");
	/**
	 * <!-- begin-user-doc --> 答复评价 * <!-- end-user-doc -->
	 */
	public final Column REPLY_EVEALUATE = new Column(this, "reply_evealuate");
	/**
	 * <!-- begin-user-doc --> 答复时间 * <!-- end-user-doc -->
	 */
	public final Column REPLY_TIME = new Column(this, "reply_time");
	/**
	 * <!-- begin-user-doc --> 答复人员 * <!-- end-user-doc -->
	 */
	public final Column REPLY_USER = new Column(this, "reply_user");
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

	public TTrainUserProblemTable() {
		super("t_train_user_problem");
	}

	public TTrainUserProblemTable(String schemaName) {
		super(schemaName, "t_train_user_problem");
	}

	public TTrainUserProblemTable(String schemaName, String alias) {
		super(schemaName, "t_train_user_problem", alias);
	}

	public TTrainUserProblemTable(String schemaName, String alias, boolean withAs) {
		super(schemaName, "t_train_user_problem", alias, withAs);
	}

	public Class<TTrainUserProblem> getPojoType() {
		return TTrainUserProblem.class;
	}

}
