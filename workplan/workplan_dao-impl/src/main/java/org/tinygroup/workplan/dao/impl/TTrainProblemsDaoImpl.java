
package org.tinygroup.workplan.dao.impl;

import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;
import static org.tinygroup.workplan.dao.inter.constant.TTrainProblemsTable.T_TRAIN_PROBLEMS_TABLE;

import java.io.Serializable;
import java.util.List;

import org.tinygroup.commons.tools.CollectionUtil;
import org.tinygroup.jdbctemplatedslsession.callback.DeleteGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.InsertGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.NoParamDeleteGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.NoParamInsertGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.NoParamUpdateGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.SelectGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.UpdateGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.jdbctemplatedslsession.daosupport.TinyDslDaoSupport;
import org.tinygroup.jdbctemplatedslsession.util.TinyDSLUtil;
import org.tinygroup.tinysqldsl.Delete;
import org.tinygroup.tinysqldsl.Insert;
import org.tinygroup.tinysqldsl.Pager;
import org.tinygroup.tinysqldsl.Select;
import org.tinygroup.tinysqldsl.Update;
import org.tinygroup.tinysqldsl.expression.JdbcNamedParameter;
import org.tinygroup.workplan.dao.inter.TTrainProblemsDao;
import org.tinygroup.workplan.dao.inter.pojo.TTrainProblems;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public class TTrainProblemsDaoImpl extends TinyDslDaoSupport implements TTrainProblemsDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TTrainProblems add(TTrainProblems tTrainProblems) {
		return getDslTemplate().insertAndReturnKey(tTrainProblems, new InsertGenerateCallback<TTrainProblems>() {
			public Insert generate(TTrainProblems t) {
				Insert insert = insertInto(T_TRAIN_PROBLEMS_TABLE).values(T_TRAIN_PROBLEMS_TABLE.ID.value(t.getId()),
						T_TRAIN_PROBLEMS_TABLE.TRAIN_ID.value(t.getTrainId()),
						T_TRAIN_PROBLEMS_TABLE.CREATE_TIME.value(t.getCreateTime()),
						T_TRAIN_PROBLEMS_TABLE.CREATE_USER.value(t.getCreateUser()),
						T_TRAIN_PROBLEMS_TABLE.PROBLEM_TITLE.value(t.getProblemTitle()),
						T_TRAIN_PROBLEMS_TABLE.PROBLEM_DESCRIBE.value(t.getProblemDescribe()),
						T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_1.value(t.getExtField1()),
						T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_2.value(t.getExtField2()),
						T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_3.value(t.getExtField3()),
						T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_4.value(t.getExtField4()),
						T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_5.value(t.getExtField5())

				);
				return insert;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TTrainProblems tTrainProblems) {
		if (tTrainProblems == null || tTrainProblems.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tTrainProblems, new UpdateGenerateCallback<TTrainProblems>() {
			public Update generate(TTrainProblems t) {
				Update update = update(T_TRAIN_PROBLEMS_TABLE)
						.set(T_TRAIN_PROBLEMS_TABLE.TRAIN_ID.value(t.getTrainId()),
								T_TRAIN_PROBLEMS_TABLE.CREATE_TIME.value(t.getCreateTime()),
								T_TRAIN_PROBLEMS_TABLE.CREATE_USER.value(t.getCreateUser()),
								T_TRAIN_PROBLEMS_TABLE.PROBLEM_TITLE.value(t.getProblemTitle()),
								T_TRAIN_PROBLEMS_TABLE.PROBLEM_DESCRIBE.value(t.getProblemDescribe()),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_1.value(t.getExtField1()),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_2.value(t.getExtField2()),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_3.value(t.getExtField3()),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_4.value(t.getExtField4()),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_5.value(t.getExtField5()))
						.where(T_TRAIN_PROBLEMS_TABLE.ID.eq(t.getId()));
				return update;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int deleteByKey(Integer pk) {
		if (pk == null) {
			return 0;
		}
		return getDslTemplate().deleteByKey(pk, new DeleteGenerateCallback<Serializable>() {
			public Delete generate(Serializable pk) {
				return delete(T_TRAIN_PROBLEMS_TABLE).where(T_TRAIN_PROBLEMS_TABLE.ID.eq(pk));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int deleteByKeys(Integer... pks) {
		if (pks == null || pks.length == 0) {
			return 0;
		}
		return getDslTemplate().deleteByKeys(new DeleteGenerateCallback<Serializable[]>() {
			public Delete generate(Serializable[] t) {
				return delete(T_TRAIN_PROBLEMS_TABLE).where(T_TRAIN_PROBLEMS_TABLE.ID.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TTrainProblems getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, TTrainProblems.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(T_TRAIN_PROBLEMS_TABLE).where(T_TRAIN_PROBLEMS_TABLE.ID.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TTrainProblems> query(TTrainProblems tTrainProblems, final OrderBy... orderArgs) {
		if (tTrainProblems == null) {
			tTrainProblems = new TTrainProblems();
		}
		return getDslTemplate().query(tTrainProblems, new SelectGenerateCallback<TTrainProblems>() {
			@SuppressWarnings("rawtypes")
			public Select generate(TTrainProblems t) {
				Select select = selectFrom(T_TRAIN_PROBLEMS_TABLE).where(
						and(T_TRAIN_PROBLEMS_TABLE.ID.eq(t.getId()), T_TRAIN_PROBLEMS_TABLE.TRAIN_ID.eq(t.getTrainId()),
								T_TRAIN_PROBLEMS_TABLE.CREATE_TIME.eq(t.getCreateTime()),
								T_TRAIN_PROBLEMS_TABLE.CREATE_USER.eq(t.getCreateUser()),
								T_TRAIN_PROBLEMS_TABLE.PROBLEM_TITLE.eq(t.getProblemTitle()),
								T_TRAIN_PROBLEMS_TABLE.PROBLEM_DESCRIBE.eq(t.getProblemDescribe()),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_1.eq(t.getExtField1()),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_2.eq(t.getExtField2()),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_3.eq(t.getExtField3()),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_4.eq(t.getExtField4()),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_5.eq(t.getExtField5())

						));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TTrainProblems> queryPager(int start, int limit, TTrainProblems tTrainProblems,
			final OrderBy... orderArgs) {
		if (tTrainProblems == null) {
			tTrainProblems = new TTrainProblems();
		}
		return getDslTemplate().queryPager(start, limit, tTrainProblems, false,
				new SelectGenerateCallback<TTrainProblems>() {
					public Select generate(TTrainProblems t) {
						Select select = Select.selectFrom(T_TRAIN_PROBLEMS_TABLE)
								.where(and(T_TRAIN_PROBLEMS_TABLE.ID.eq(t.getId()),
										T_TRAIN_PROBLEMS_TABLE.TRAIN_ID.eq(t.getTrainId()),
										T_TRAIN_PROBLEMS_TABLE.CREATE_TIME.eq(t.getCreateTime()),
										T_TRAIN_PROBLEMS_TABLE.CREATE_USER.eq(t.getCreateUser()),
										T_TRAIN_PROBLEMS_TABLE.PROBLEM_TITLE.eq(t.getProblemTitle()),
										T_TRAIN_PROBLEMS_TABLE.PROBLEM_DESCRIBE.eq(t.getProblemDescribe()),
										T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_1.eq(t.getExtField1()),
										T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_2.eq(t.getExtField2()),
										T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_3.eq(t.getExtField3()),
										T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_4.eq(t.getExtField4()),
										T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_5.eq(t.getExtField5())

				));
						return TinyDSLUtil.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<TTrainProblems> tTrainProblems) {
		if (CollectionUtil.isEmpty(tTrainProblems)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tTrainProblems,
				new InsertGenerateCallback<TTrainProblems>() {

					public Insert generate(TTrainProblems t) {
						return insertInto(T_TRAIN_PROBLEMS_TABLE).values(T_TRAIN_PROBLEMS_TABLE.ID.value(t.getId()),
								T_TRAIN_PROBLEMS_TABLE.TRAIN_ID.value(t.getTrainId()),
								T_TRAIN_PROBLEMS_TABLE.CREATE_TIME.value(t.getCreateTime()),
								T_TRAIN_PROBLEMS_TABLE.CREATE_USER.value(t.getCreateUser()),
								T_TRAIN_PROBLEMS_TABLE.PROBLEM_TITLE.value(t.getProblemTitle()),
								T_TRAIN_PROBLEMS_TABLE.PROBLEM_DESCRIBE.value(t.getProblemDescribe()),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_1.value(t.getExtField1()),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_2.value(t.getExtField2()),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_3.value(t.getExtField3()),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_4.value(t.getExtField4()),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_5.value(t.getExtField5())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TTrainProblems> tTrainProblemss) {
		return batchInsert(false, tTrainProblemss);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TTrainProblems> tTrainProblems) {
		if (CollectionUtil.isEmpty(tTrainProblems)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tTrainProblems, new UpdateGenerateCallback<TTrainProblems>() {
			public Update generate(TTrainProblems t) {
				return update(T_TRAIN_PROBLEMS_TABLE).set(T_TRAIN_PROBLEMS_TABLE.TRAIN_ID.value(t.getTrainId()),
						T_TRAIN_PROBLEMS_TABLE.CREATE_TIME.value(t.getCreateTime()),
						T_TRAIN_PROBLEMS_TABLE.CREATE_USER.value(t.getCreateUser()),
						T_TRAIN_PROBLEMS_TABLE.PROBLEM_TITLE.value(t.getProblemTitle()),
						T_TRAIN_PROBLEMS_TABLE.PROBLEM_DESCRIBE.value(t.getProblemDescribe()),
						T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_1.value(t.getExtField1()),
						T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_2.value(t.getExtField2()),
						T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_3.value(t.getExtField3()),
						T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_4.value(t.getExtField4()),
						T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_5.value(t.getExtField5())

				).where(T_TRAIN_PROBLEMS_TABLE.ID.eq(t.getId()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TTrainProblems> tTrainProblems) {
		if (CollectionUtil.isEmpty(tTrainProblems)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tTrainProblems, new DeleteGenerateCallback<TTrainProblems>() {
			public Delete generate(TTrainProblems t) {
				return delete(T_TRAIN_PROBLEMS_TABLE).where(
						and(T_TRAIN_PROBLEMS_TABLE.ID.eq(t.getId()), T_TRAIN_PROBLEMS_TABLE.TRAIN_ID.eq(t.getTrainId()),
								T_TRAIN_PROBLEMS_TABLE.CREATE_TIME.eq(t.getCreateTime()),
								T_TRAIN_PROBLEMS_TABLE.CREATE_USER.eq(t.getCreateUser()),
								T_TRAIN_PROBLEMS_TABLE.PROBLEM_TITLE.eq(t.getProblemTitle()),
								T_TRAIN_PROBLEMS_TABLE.PROBLEM_DESCRIBE.eq(t.getProblemDescribe()),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_1.eq(t.getExtField1()),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_2.eq(t.getExtField2()),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_3.eq(t.getExtField3()),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_4.eq(t.getExtField4()),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_5.eq(t.getExtField5())

						));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<TTrainProblems> tTrainProblems) {
		if (CollectionUtil.isEmpty(tTrainProblems)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tTrainProblems, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(T_TRAIN_PROBLEMS_TABLE)
						.values(T_TRAIN_PROBLEMS_TABLE.TRAIN_ID.value(new JdbcNamedParameter("trainId")),
								T_TRAIN_PROBLEMS_TABLE.CREATE_TIME.value(new JdbcNamedParameter("createTime")),
								T_TRAIN_PROBLEMS_TABLE.CREATE_USER.value(new JdbcNamedParameter("createUser")),
								T_TRAIN_PROBLEMS_TABLE.PROBLEM_TITLE.value(new JdbcNamedParameter("problemTitle")),
								T_TRAIN_PROBLEMS_TABLE.PROBLEM_DESCRIBE
										.value(new JdbcNamedParameter("problemDescribe")),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TTrainProblems> tTrainProblems) {
		if (CollectionUtil.isEmpty(tTrainProblems)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tTrainProblems, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(T_TRAIN_PROBLEMS_TABLE)
						.set(T_TRAIN_PROBLEMS_TABLE.TRAIN_ID.value(new JdbcNamedParameter("trainId")),
								T_TRAIN_PROBLEMS_TABLE.CREATE_TIME.value(new JdbcNamedParameter("createTime")),
								T_TRAIN_PROBLEMS_TABLE.CREATE_USER.value(new JdbcNamedParameter("createUser")),
								T_TRAIN_PROBLEMS_TABLE.PROBLEM_TITLE.value(new JdbcNamedParameter("problemTitle")),
								T_TRAIN_PROBLEMS_TABLE.PROBLEM_DESCRIBE
										.value(new JdbcNamedParameter("problemDescribe")),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

						).where(T_TRAIN_PROBLEMS_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TTrainProblems> tTrainProblems) {
		if (CollectionUtil.isEmpty(tTrainProblems)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tTrainProblems, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(T_TRAIN_PROBLEMS_TABLE)
						.where(and(T_TRAIN_PROBLEMS_TABLE.TRAIN_ID.eq(new JdbcNamedParameter("trainId")),
								T_TRAIN_PROBLEMS_TABLE.CREATE_TIME.eq(new JdbcNamedParameter("createTime")),
								T_TRAIN_PROBLEMS_TABLE.CREATE_USER.eq(new JdbcNamedParameter("createUser")),
								T_TRAIN_PROBLEMS_TABLE.PROBLEM_TITLE.eq(new JdbcNamedParameter("problemTitle")),
								T_TRAIN_PROBLEMS_TABLE.PROBLEM_DESCRIBE.eq(new JdbcNamedParameter("problemDescribe")),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_1.eq(new JdbcNamedParameter("extField1")),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_2.eq(new JdbcNamedParameter("extField2")),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_3.eq(new JdbcNamedParameter("extField3")),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_4.eq(new JdbcNamedParameter("extField4")),
								T_TRAIN_PROBLEMS_TABLE.EXT_FIELD_5.eq(new JdbcNamedParameter("extField5"))

				));
			}
		});
	}

	public int[] preparedBatchInsert(List<TTrainProblems> tTrainProblems) {
		return preparedBatchInsert(false, tTrainProblems);
	}

}
