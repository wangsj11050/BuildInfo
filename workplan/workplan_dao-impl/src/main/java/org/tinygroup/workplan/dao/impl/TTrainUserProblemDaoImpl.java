
package org.tinygroup.workplan.dao.impl;

import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;
import static org.tinygroup.workplan.dao.inter.constant.TTrainUserProblemTable.T_TRAIN_USER_PROBLEM_TABLE;

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
import org.tinygroup.workplan.dao.inter.TTrainUserProblemDao;
import org.tinygroup.workplan.dao.inter.pojo.TTrainUserProblem;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public class TTrainUserProblemDaoImpl extends TinyDslDaoSupport implements TTrainUserProblemDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TTrainUserProblem add(TTrainUserProblem tTrainUserProblem) {
		return getDslTemplate().insertAndReturnKey(tTrainUserProblem, new InsertGenerateCallback<TTrainUserProblem>() {
			public Insert generate(TTrainUserProblem t) {
				Insert insert = insertInto(T_TRAIN_USER_PROBLEM_TABLE).values(
						T_TRAIN_USER_PROBLEM_TABLE.ID.value(t.getId()),
						T_TRAIN_USER_PROBLEM_TABLE.EXAMPLE_ID.value(t.getExampleId()),
						T_TRAIN_USER_PROBLEM_TABLE.TRAIN_USER.value(t.getTrainUser()),
						T_TRAIN_USER_PROBLEM_TABLE.CREATE_TIME.value(t.getCreateTime()),
						T_TRAIN_USER_PROBLEM_TABLE.PROBLEM_ANSWER.value(t.getProblemAnswer()),
						T_TRAIN_USER_PROBLEM_TABLE.ANSWER_TIME.value(t.getAnswerTime()),
						T_TRAIN_USER_PROBLEM_TABLE.REPLY_EVEALUATE.value(t.getReplyEvealuate()),
						T_TRAIN_USER_PROBLEM_TABLE.REPLY_TIME.value(t.getReplyTime()),
						T_TRAIN_USER_PROBLEM_TABLE.REPLY_USER.value(t.getReplyUser()),
						T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
				return insert;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TTrainUserProblem tTrainUserProblem) {
		if (tTrainUserProblem == null || tTrainUserProblem.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tTrainUserProblem, new UpdateGenerateCallback<TTrainUserProblem>() {
			public Update generate(TTrainUserProblem t) {
				Update update = update(T_TRAIN_USER_PROBLEM_TABLE)
						.set(T_TRAIN_USER_PROBLEM_TABLE.EXAMPLE_ID.value(t.getExampleId()),
								T_TRAIN_USER_PROBLEM_TABLE.TRAIN_USER.value(t.getTrainUser()),
								T_TRAIN_USER_PROBLEM_TABLE.CREATE_TIME.value(t.getCreateTime()),
								T_TRAIN_USER_PROBLEM_TABLE.PROBLEM_ANSWER.value(t.getProblemAnswer()),
								T_TRAIN_USER_PROBLEM_TABLE.ANSWER_TIME.value(t.getAnswerTime()),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_EVEALUATE.value(t.getReplyEvealuate()),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_TIME.value(t.getReplyTime()),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_USER.value(t.getReplyUser()),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_5.value(t.getExtField_5()))
						.where(T_TRAIN_USER_PROBLEM_TABLE.ID.eq(t.getId()));
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
				return delete(T_TRAIN_USER_PROBLEM_TABLE).where(T_TRAIN_USER_PROBLEM_TABLE.ID.eq(pk));
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
				return delete(T_TRAIN_USER_PROBLEM_TABLE).where(T_TRAIN_USER_PROBLEM_TABLE.ID.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TTrainUserProblem getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, TTrainUserProblem.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(T_TRAIN_USER_PROBLEM_TABLE).where(T_TRAIN_USER_PROBLEM_TABLE.ID.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TTrainUserProblem> query(TTrainUserProblem tTrainUserProblem, final OrderBy... orderArgs) {
		if (tTrainUserProblem == null) {
			tTrainUserProblem = new TTrainUserProblem();
		}
		return getDslTemplate().query(tTrainUserProblem, new SelectGenerateCallback<TTrainUserProblem>() {
			@SuppressWarnings("rawtypes")
			public Select generate(TTrainUserProblem t) {
				Select select = selectFrom(T_TRAIN_USER_PROBLEM_TABLE)
						.where(and(T_TRAIN_USER_PROBLEM_TABLE.ID.eq(t.getId()),
								T_TRAIN_USER_PROBLEM_TABLE.EXAMPLE_ID.eq(t.getExampleId()),
								T_TRAIN_USER_PROBLEM_TABLE.TRAIN_USER.eq(t.getTrainUser()),
								T_TRAIN_USER_PROBLEM_TABLE.CREATE_TIME.eq(t.getCreateTime()),
								T_TRAIN_USER_PROBLEM_TABLE.PROBLEM_ANSWER.eq(t.getProblemAnswer()),
								T_TRAIN_USER_PROBLEM_TABLE.ANSWER_TIME.eq(t.getAnswerTime()),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_EVEALUATE.eq(t.getReplyEvealuate()),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_TIME.eq(t.getReplyTime()),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_USER.eq(t.getReplyUser()),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TTrainUserProblem> queryPager(int start, int limit, TTrainUserProblem tTrainUserProblem,
			final OrderBy... orderArgs) {
		if (tTrainUserProblem == null) {
			tTrainUserProblem = new TTrainUserProblem();
		}
		return getDslTemplate().queryPager(start, limit, tTrainUserProblem, false,
				new SelectGenerateCallback<TTrainUserProblem>() {
					public Select generate(TTrainUserProblem t) {
						Select select = Select.selectFrom(T_TRAIN_USER_PROBLEM_TABLE)
								.where(and(T_TRAIN_USER_PROBLEM_TABLE.ID.eq(t.getId()),
										T_TRAIN_USER_PROBLEM_TABLE.EXAMPLE_ID.eq(t.getExampleId()),
										T_TRAIN_USER_PROBLEM_TABLE.TRAIN_USER.eq(t.getTrainUser()),
										T_TRAIN_USER_PROBLEM_TABLE.CREATE_TIME.eq(t.getCreateTime()),
										T_TRAIN_USER_PROBLEM_TABLE.PROBLEM_ANSWER.eq(t.getProblemAnswer()),
										T_TRAIN_USER_PROBLEM_TABLE.ANSWER_TIME.eq(t.getAnswerTime()),
										T_TRAIN_USER_PROBLEM_TABLE.REPLY_EVEALUATE.eq(t.getReplyEvealuate()),
										T_TRAIN_USER_PROBLEM_TABLE.REPLY_TIME.eq(t.getReplyTime()),
										T_TRAIN_USER_PROBLEM_TABLE.REPLY_USER.eq(t.getReplyUser()),
										T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
										T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
										T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
										T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
										T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
						return TinyDSLUtil.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<TTrainUserProblem> tTrainUserProblem) {
		if (CollectionUtil.isEmpty(tTrainUserProblem)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tTrainUserProblem,
				new InsertGenerateCallback<TTrainUserProblem>() {

					public Insert generate(TTrainUserProblem t) {
						return insertInto(T_TRAIN_USER_PROBLEM_TABLE).values(
								T_TRAIN_USER_PROBLEM_TABLE.ID.value(t.getId()),
								T_TRAIN_USER_PROBLEM_TABLE.EXAMPLE_ID.value(t.getExampleId()),
								T_TRAIN_USER_PROBLEM_TABLE.TRAIN_USER.value(t.getTrainUser()),
								T_TRAIN_USER_PROBLEM_TABLE.CREATE_TIME.value(t.getCreateTime()),
								T_TRAIN_USER_PROBLEM_TABLE.PROBLEM_ANSWER.value(t.getProblemAnswer()),
								T_TRAIN_USER_PROBLEM_TABLE.ANSWER_TIME.value(t.getAnswerTime()),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_EVEALUATE.value(t.getReplyEvealuate()),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_TIME.value(t.getReplyTime()),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_USER.value(t.getReplyUser()),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TTrainUserProblem> tTrainUserProblems) {
		return batchInsert(false, tTrainUserProblems);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TTrainUserProblem> tTrainUserProblem) {
		if (CollectionUtil.isEmpty(tTrainUserProblem)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tTrainUserProblem, new UpdateGenerateCallback<TTrainUserProblem>() {
			public Update generate(TTrainUserProblem t) {
				return update(T_TRAIN_USER_PROBLEM_TABLE)
						.set(T_TRAIN_USER_PROBLEM_TABLE.EXAMPLE_ID.value(t.getExampleId()),
								T_TRAIN_USER_PROBLEM_TABLE.TRAIN_USER.value(t.getTrainUser()),
								T_TRAIN_USER_PROBLEM_TABLE.CREATE_TIME.value(t.getCreateTime()),
								T_TRAIN_USER_PROBLEM_TABLE.PROBLEM_ANSWER.value(t.getProblemAnswer()),
								T_TRAIN_USER_PROBLEM_TABLE.ANSWER_TIME.value(t.getAnswerTime()),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_EVEALUATE.value(t.getReplyEvealuate()),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_TIME.value(t.getReplyTime()),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_USER.value(t.getReplyUser()),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_5.value(t.getExtField_5())

						).where(T_TRAIN_USER_PROBLEM_TABLE.ID.eq(t.getId()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TTrainUserProblem> tTrainUserProblem) {
		if (CollectionUtil.isEmpty(tTrainUserProblem)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tTrainUserProblem, new DeleteGenerateCallback<TTrainUserProblem>() {
			public Delete generate(TTrainUserProblem t) {
				return delete(T_TRAIN_USER_PROBLEM_TABLE).where(and(T_TRAIN_USER_PROBLEM_TABLE.ID.eq(t.getId()),
						T_TRAIN_USER_PROBLEM_TABLE.EXAMPLE_ID.eq(t.getExampleId()),
						T_TRAIN_USER_PROBLEM_TABLE.TRAIN_USER.eq(t.getTrainUser()),
						T_TRAIN_USER_PROBLEM_TABLE.CREATE_TIME.eq(t.getCreateTime()),
						T_TRAIN_USER_PROBLEM_TABLE.PROBLEM_ANSWER.eq(t.getProblemAnswer()),
						T_TRAIN_USER_PROBLEM_TABLE.ANSWER_TIME.eq(t.getAnswerTime()),
						T_TRAIN_USER_PROBLEM_TABLE.REPLY_EVEALUATE.eq(t.getReplyEvealuate()),
						T_TRAIN_USER_PROBLEM_TABLE.REPLY_TIME.eq(t.getReplyTime()),
						T_TRAIN_USER_PROBLEM_TABLE.REPLY_USER.eq(t.getReplyUser()),
						T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<TTrainUserProblem> tTrainUserProblem) {
		if (CollectionUtil.isEmpty(tTrainUserProblem)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tTrainUserProblem, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(T_TRAIN_USER_PROBLEM_TABLE)
						.values(T_TRAIN_USER_PROBLEM_TABLE.EXAMPLE_ID.value(new JdbcNamedParameter("exampleId")),
								T_TRAIN_USER_PROBLEM_TABLE.TRAIN_USER.value(new JdbcNamedParameter("trainUser")),
								T_TRAIN_USER_PROBLEM_TABLE.CREATE_TIME.value(new JdbcNamedParameter("createTime")),
								T_TRAIN_USER_PROBLEM_TABLE.PROBLEM_ANSWER
										.value(new JdbcNamedParameter("problemAnswer")),
								T_TRAIN_USER_PROBLEM_TABLE.ANSWER_TIME.value(new JdbcNamedParameter("answerTime")),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_EVEALUATE
										.value(new JdbcNamedParameter("replyEvealuate")),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_TIME.value(new JdbcNamedParameter("replyTime")),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_USER.value(new JdbcNamedParameter("replyUser")),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TTrainUserProblem> tTrainUserProblem) {
		if (CollectionUtil.isEmpty(tTrainUserProblem)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tTrainUserProblem, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(T_TRAIN_USER_PROBLEM_TABLE)
						.set(T_TRAIN_USER_PROBLEM_TABLE.EXAMPLE_ID.value(new JdbcNamedParameter("exampleId")),
								T_TRAIN_USER_PROBLEM_TABLE.TRAIN_USER.value(new JdbcNamedParameter("trainUser")),
								T_TRAIN_USER_PROBLEM_TABLE.CREATE_TIME.value(new JdbcNamedParameter("createTime")),
								T_TRAIN_USER_PROBLEM_TABLE.PROBLEM_ANSWER
										.value(new JdbcNamedParameter("problemAnswer")),
								T_TRAIN_USER_PROBLEM_TABLE.ANSWER_TIME.value(new JdbcNamedParameter("answerTime")),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_EVEALUATE
										.value(new JdbcNamedParameter("replyEvealuate")),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_TIME.value(new JdbcNamedParameter("replyTime")),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_USER.value(new JdbcNamedParameter("replyUser")),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

						).where(T_TRAIN_USER_PROBLEM_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TTrainUserProblem> tTrainUserProblem) {
		if (CollectionUtil.isEmpty(tTrainUserProblem)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tTrainUserProblem, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(T_TRAIN_USER_PROBLEM_TABLE)
						.where(and(T_TRAIN_USER_PROBLEM_TABLE.EXAMPLE_ID.eq(new JdbcNamedParameter("exampleId")),
								T_TRAIN_USER_PROBLEM_TABLE.TRAIN_USER.eq(new JdbcNamedParameter("trainUser")),
								T_TRAIN_USER_PROBLEM_TABLE.CREATE_TIME.eq(new JdbcNamedParameter("createTime")),
								T_TRAIN_USER_PROBLEM_TABLE.PROBLEM_ANSWER.eq(new JdbcNamedParameter("problemAnswer")),
								T_TRAIN_USER_PROBLEM_TABLE.ANSWER_TIME.eq(new JdbcNamedParameter("answerTime")),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_EVEALUATE.eq(new JdbcNamedParameter("replyEvealuate")),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_TIME.eq(new JdbcNamedParameter("replyTime")),
								T_TRAIN_USER_PROBLEM_TABLE.REPLY_USER.eq(new JdbcNamedParameter("replyUser")),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_1.eq(new JdbcNamedParameter("extField1")),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_2.eq(new JdbcNamedParameter("extField2")),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_3.eq(new JdbcNamedParameter("extField3")),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_4.eq(new JdbcNamedParameter("extField4")),
								T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_5.eq(new JdbcNamedParameter("extField5"))

				));
			}
		});
	}

	public int[] preparedBatchInsert(List<TTrainUserProblem> tTrainUserProblem) {
		return preparedBatchInsert(false, tTrainUserProblem);
	}

	@Override
	public List<TTrainUserProblem> getTrainUserProblemList(TTrainUserProblem trainUserProblem) {
		if(trainUserProblem == null){
			trainUserProblem = new TTrainUserProblem();
		}
		return getDslTemplate().query(trainUserProblem, new SelectGenerateCallback<TTrainUserProblem>() {

			@Override
			public Select generate(TTrainUserProblem t) {
				// TODO Auto-generated method stub
				return Select.selectFrom(T_TRAIN_USER_PROBLEM_TABLE)
						.where(T_TRAIN_USER_PROBLEM_TABLE.TRAIN_USER.eq(t.getTrainUser()));
			}
		});
	}

	@Override
	public List<TTrainUserProblem> getFinishTrainUserProblemList(TTrainUserProblem trainUserProblem) {
		if(trainUserProblem == null){
			trainUserProblem = new TTrainUserProblem();
		}
		return getDslTemplate().query(trainUserProblem, new SelectGenerateCallback<TTrainUserProblem>() {

			@Override
			public Select generate(TTrainUserProblem t) {
				// TODO Auto-generated method stub
				return Select.selectFrom(T_TRAIN_USER_PROBLEM_TABLE)
						.where(and(T_TRAIN_USER_PROBLEM_TABLE.TRAIN_USER.eq(t.getTrainUser())
						,T_TRAIN_USER_PROBLEM_TABLE.EXT_FIELD_1.eq(t.getExtField_1())));
			}
		});
	}

}
