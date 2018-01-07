
package org.tinygroup.workplan.dao.impl;

import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;
import static org.tinygroup.workplan.dao.inter.constant.TMeetingProblemTable.T_MEETING_PROBLEM_TABLE;

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
import org.tinygroup.workplan.dao.inter.TMeetingProblemDao;
import org.tinygroup.workplan.dao.inter.pojo.TMeetingProblem;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public class TMeetingProblemDaoImpl extends TinyDslDaoSupport implements TMeetingProblemDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TMeetingProblem add(TMeetingProblem tMeetingProblem) {
		return getDslTemplate().insertAndReturnKey(tMeetingProblem, new InsertGenerateCallback<TMeetingProblem>() {
			public Insert generate(TMeetingProblem t) {
				Insert insert = insertInto(T_MEETING_PROBLEM_TABLE).values(T_MEETING_PROBLEM_TABLE.ID.value(t.getId()),
						T_MEETING_PROBLEM_TABLE.MEETIMG_ID.value(t.getMeetimgId()),
						T_MEETING_PROBLEM_TABLE.PROBLEM_CONTENT.value(t.getProblemContent()),
						T_MEETING_PROBLEM_TABLE.DUTY_USER.value(t.getDutyUser()),
						T_MEETING_PROBLEM_TABLE.SOLVE_DATE.value(t.getSolveDate()),
						T_MEETING_PROBLEM_TABLE.TRACK_USER.value(t.getTrackUser()),
						T_MEETING_PROBLEM_TABLE.STATUS.value(t.getStatus()),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_1.value(t.getExtField1()),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_2.value(t.getExtField2()),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_3.value(t.getExtField3()),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_4.value(t.getExtField4()),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_5.value(t.getExtField5())

				);
				return insert;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TMeetingProblem tMeetingProblem) {
		if (tMeetingProblem == null || tMeetingProblem.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tMeetingProblem, new UpdateGenerateCallback<TMeetingProblem>() {
			public Update generate(TMeetingProblem t) {
				Update update = update(T_MEETING_PROBLEM_TABLE)
						.set(T_MEETING_PROBLEM_TABLE.MEETIMG_ID.value(t.getMeetimgId()),
								T_MEETING_PROBLEM_TABLE.PROBLEM_CONTENT.value(t.getProblemContent()),
								T_MEETING_PROBLEM_TABLE.DUTY_USER.value(t.getDutyUser()),
								T_MEETING_PROBLEM_TABLE.SOLVE_DATE.value(t.getSolveDate()),
								T_MEETING_PROBLEM_TABLE.TRACK_USER.value(t.getTrackUser()),
								T_MEETING_PROBLEM_TABLE.STATUS.value(t.getStatus()),
								T_MEETING_PROBLEM_TABLE.EXT_FIELD_1.value(t.getExtField1()),
								T_MEETING_PROBLEM_TABLE.EXT_FIELD_2.value(t.getExtField2()),
								T_MEETING_PROBLEM_TABLE.EXT_FIELD_3.value(t.getExtField3()),
								T_MEETING_PROBLEM_TABLE.EXT_FIELD_4.value(t.getExtField4()),
								T_MEETING_PROBLEM_TABLE.EXT_FIELD_5.value(t.getExtField5()))
						.where(T_MEETING_PROBLEM_TABLE.ID.eq(t.getId()));
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
				return delete(T_MEETING_PROBLEM_TABLE).where(T_MEETING_PROBLEM_TABLE.ID.eq(pk));
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
				return delete(T_MEETING_PROBLEM_TABLE).where(T_MEETING_PROBLEM_TABLE.ID.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TMeetingProblem getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, TMeetingProblem.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(T_MEETING_PROBLEM_TABLE).where(T_MEETING_PROBLEM_TABLE.ID.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TMeetingProblem> query(TMeetingProblem tMeetingProblem, final OrderBy... orderArgs) {
		if (tMeetingProblem == null) {
			tMeetingProblem = new TMeetingProblem();
		}
		return getDslTemplate().query(tMeetingProblem, new SelectGenerateCallback<TMeetingProblem>() {
			@SuppressWarnings("rawtypes")
			public Select generate(TMeetingProblem t) {
				Select select = selectFrom(T_MEETING_PROBLEM_TABLE).where(and(T_MEETING_PROBLEM_TABLE.ID.eq(t.getId()),
						T_MEETING_PROBLEM_TABLE.MEETIMG_ID.eq(t.getMeetimgId()),
						T_MEETING_PROBLEM_TABLE.PROBLEM_CONTENT.eq(t.getProblemContent()),
						T_MEETING_PROBLEM_TABLE.DUTY_USER.eq(t.getDutyUser()),
						T_MEETING_PROBLEM_TABLE.SOLVE_DATE.eq(t.getSolveDate()),
						T_MEETING_PROBLEM_TABLE.TRACK_USER.eq(t.getTrackUser()),
						T_MEETING_PROBLEM_TABLE.STATUS.eq(t.getStatus()),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_1.eq(t.getExtField1()),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_2.eq(t.getExtField2()),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_3.eq(t.getExtField3()),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_4.eq(t.getExtField4()),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_5.eq(t.getExtField5())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TMeetingProblem> queryPager(int start, int limit, TMeetingProblem tMeetingProblem,
			final OrderBy... orderArgs) {
		if (tMeetingProblem == null) {
			tMeetingProblem = new TMeetingProblem();
		}
		return getDslTemplate().queryPager(start, limit, tMeetingProblem, false,
				new SelectGenerateCallback<TMeetingProblem>() {
					public Select generate(TMeetingProblem t) {
						Select select = Select.selectFrom(T_MEETING_PROBLEM_TABLE)
								.where(and(T_MEETING_PROBLEM_TABLE.ID.eq(t.getId()),
										T_MEETING_PROBLEM_TABLE.MEETIMG_ID.eq(t.getMeetimgId()),
										T_MEETING_PROBLEM_TABLE.PROBLEM_CONTENT.eq(t.getProblemContent()),
										T_MEETING_PROBLEM_TABLE.DUTY_USER.eq(t.getDutyUser()),
										T_MEETING_PROBLEM_TABLE.SOLVE_DATE.eq(t.getSolveDate()),
										T_MEETING_PROBLEM_TABLE.TRACK_USER.eq(t.getTrackUser()),
										T_MEETING_PROBLEM_TABLE.STATUS.eq(t.getStatus()),
										T_MEETING_PROBLEM_TABLE.EXT_FIELD_1.eq(t.getExtField1()),
										T_MEETING_PROBLEM_TABLE.EXT_FIELD_2.eq(t.getExtField2()),
										T_MEETING_PROBLEM_TABLE.EXT_FIELD_3.eq(t.getExtField3()),
										T_MEETING_PROBLEM_TABLE.EXT_FIELD_4.eq(t.getExtField4()),
										T_MEETING_PROBLEM_TABLE.EXT_FIELD_5.eq(t.getExtField5())

				));
						return TinyDSLUtil.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<TMeetingProblem> tMeetingProblem) {
		if (CollectionUtil.isEmpty(tMeetingProblem)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tMeetingProblem,
				new InsertGenerateCallback<TMeetingProblem>() {

					public Insert generate(TMeetingProblem t) {
						return insertInto(T_MEETING_PROBLEM_TABLE).values(T_MEETING_PROBLEM_TABLE.ID.value(t.getId()),
								T_MEETING_PROBLEM_TABLE.MEETIMG_ID.value(t.getMeetimgId()),
								T_MEETING_PROBLEM_TABLE.PROBLEM_CONTENT.value(t.getProblemContent()),
								T_MEETING_PROBLEM_TABLE.DUTY_USER.value(t.getDutyUser()),
								T_MEETING_PROBLEM_TABLE.SOLVE_DATE.value(t.getSolveDate()),
								T_MEETING_PROBLEM_TABLE.TRACK_USER.value(t.getTrackUser()),
								T_MEETING_PROBLEM_TABLE.STATUS.value(t.getStatus()),
								T_MEETING_PROBLEM_TABLE.EXT_FIELD_1.value(t.getExtField1()),
								T_MEETING_PROBLEM_TABLE.EXT_FIELD_2.value(t.getExtField2()),
								T_MEETING_PROBLEM_TABLE.EXT_FIELD_3.value(t.getExtField3()),
								T_MEETING_PROBLEM_TABLE.EXT_FIELD_4.value(t.getExtField4()),
								T_MEETING_PROBLEM_TABLE.EXT_FIELD_5.value(t.getExtField5())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TMeetingProblem> tMeetingProblems) {
		return batchInsert(false, tMeetingProblems);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TMeetingProblem> tMeetingProblem) {
		if (CollectionUtil.isEmpty(tMeetingProblem)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tMeetingProblem, new UpdateGenerateCallback<TMeetingProblem>() {
			public Update generate(TMeetingProblem t) {
				return update(T_MEETING_PROBLEM_TABLE).set(T_MEETING_PROBLEM_TABLE.MEETIMG_ID.value(t.getMeetimgId()),
						T_MEETING_PROBLEM_TABLE.PROBLEM_CONTENT.value(t.getProblemContent()),
						T_MEETING_PROBLEM_TABLE.DUTY_USER.value(t.getDutyUser()),
						T_MEETING_PROBLEM_TABLE.SOLVE_DATE.value(t.getSolveDate()),
						T_MEETING_PROBLEM_TABLE.TRACK_USER.value(t.getTrackUser()),
						T_MEETING_PROBLEM_TABLE.STATUS.value(t.getStatus()),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_1.value(t.getExtField1()),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_2.value(t.getExtField2()),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_3.value(t.getExtField3()),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_4.value(t.getExtField4()),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_5.value(t.getExtField5())

				).where(T_MEETING_PROBLEM_TABLE.ID.eq(t.getId()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TMeetingProblem> tMeetingProblem) {
		if (CollectionUtil.isEmpty(tMeetingProblem)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tMeetingProblem, new DeleteGenerateCallback<TMeetingProblem>() {
			public Delete generate(TMeetingProblem t) {
				return delete(T_MEETING_PROBLEM_TABLE).where(and(T_MEETING_PROBLEM_TABLE.ID.eq(t.getId()),
						T_MEETING_PROBLEM_TABLE.MEETIMG_ID.eq(t.getMeetimgId()),
						T_MEETING_PROBLEM_TABLE.PROBLEM_CONTENT.eq(t.getProblemContent()),
						T_MEETING_PROBLEM_TABLE.DUTY_USER.eq(t.getDutyUser()),
						T_MEETING_PROBLEM_TABLE.SOLVE_DATE.eq(t.getSolveDate()),
						T_MEETING_PROBLEM_TABLE.TRACK_USER.eq(t.getTrackUser()),
						T_MEETING_PROBLEM_TABLE.STATUS.eq(t.getStatus()),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_1.eq(t.getExtField1()),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_2.eq(t.getExtField2()),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_3.eq(t.getExtField3()),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_4.eq(t.getExtField4()),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_5.eq(t.getExtField5())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<TMeetingProblem> tMeetingProblem) {
		if (CollectionUtil.isEmpty(tMeetingProblem)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tMeetingProblem, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(T_MEETING_PROBLEM_TABLE).values(
						T_MEETING_PROBLEM_TABLE.MEETIMG_ID.value(new JdbcNamedParameter("meetimgId")),
						T_MEETING_PROBLEM_TABLE.PROBLEM_CONTENT.value(new JdbcNamedParameter("problemContent")),
						T_MEETING_PROBLEM_TABLE.DUTY_USER.value(new JdbcNamedParameter("dutyUser")),
						T_MEETING_PROBLEM_TABLE.SOLVE_DATE.value(new JdbcNamedParameter("solveDate")),
						T_MEETING_PROBLEM_TABLE.TRACK_USER.value(new JdbcNamedParameter("trackUser")),
						T_MEETING_PROBLEM_TABLE.STATUS.value(new JdbcNamedParameter("status")),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
						T_MEETING_PROBLEM_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TMeetingProblem> tMeetingProblem) {
		if (CollectionUtil.isEmpty(tMeetingProblem)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tMeetingProblem, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(T_MEETING_PROBLEM_TABLE)
						.set(T_MEETING_PROBLEM_TABLE.MEETIMG_ID.value(new JdbcNamedParameter("meetimgId")),
								T_MEETING_PROBLEM_TABLE.PROBLEM_CONTENT.value(new JdbcNamedParameter("problemContent")),
								T_MEETING_PROBLEM_TABLE.DUTY_USER.value(new JdbcNamedParameter("dutyUser")),
								T_MEETING_PROBLEM_TABLE.SOLVE_DATE.value(new JdbcNamedParameter("solveDate")),
								T_MEETING_PROBLEM_TABLE.TRACK_USER.value(new JdbcNamedParameter("trackUser")),
								T_MEETING_PROBLEM_TABLE.STATUS.value(new JdbcNamedParameter("status")),
								T_MEETING_PROBLEM_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
								T_MEETING_PROBLEM_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
								T_MEETING_PROBLEM_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
								T_MEETING_PROBLEM_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
								T_MEETING_PROBLEM_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

						).where(T_MEETING_PROBLEM_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TMeetingProblem> tMeetingProblem) {
		if (CollectionUtil.isEmpty(tMeetingProblem)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tMeetingProblem, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(T_MEETING_PROBLEM_TABLE)
						.where(and(T_MEETING_PROBLEM_TABLE.MEETIMG_ID.eq(new JdbcNamedParameter("meetimgId")),
								T_MEETING_PROBLEM_TABLE.PROBLEM_CONTENT.eq(new JdbcNamedParameter("problemContent")),
								T_MEETING_PROBLEM_TABLE.DUTY_USER.eq(new JdbcNamedParameter("dutyUser")),
								T_MEETING_PROBLEM_TABLE.SOLVE_DATE.eq(new JdbcNamedParameter("solveDate")),
								T_MEETING_PROBLEM_TABLE.TRACK_USER.eq(new JdbcNamedParameter("trackUser")),
								T_MEETING_PROBLEM_TABLE.STATUS.eq(new JdbcNamedParameter("status")),
								T_MEETING_PROBLEM_TABLE.EXT_FIELD_1.eq(new JdbcNamedParameter("extField1")),
								T_MEETING_PROBLEM_TABLE.EXT_FIELD_2.eq(new JdbcNamedParameter("extField2")),
								T_MEETING_PROBLEM_TABLE.EXT_FIELD_3.eq(new JdbcNamedParameter("extField3")),
								T_MEETING_PROBLEM_TABLE.EXT_FIELD_4.eq(new JdbcNamedParameter("extField4")),
								T_MEETING_PROBLEM_TABLE.EXT_FIELD_5.eq(new JdbcNamedParameter("extField5"))

				));
			}
		});
	}

	public int[] preparedBatchInsert(List<TMeetingProblem> tMeetingProblem) {
		return preparedBatchInsert(false, tMeetingProblem);
	}

	@Override
	public List<TMeetingProblem> getUserMeetingProblemList(TMeetingProblem meetingProblem) {
		// TODO Auto-generated method stub
		if(meetingProblem == null){
			meetingProblem = new TMeetingProblem();
		}
		return getDslTemplate().query(meetingProblem, new SelectGenerateCallback<TMeetingProblem>() {

			@Override
			public Select generate(TMeetingProblem t) {
				// TODO Auto-generated method stub
				return Select.selectFrom(T_MEETING_PROBLEM_TABLE)
						.where(T_MEETING_PROBLEM_TABLE.DUTY_USER.eq(t.getDutyUser()));
			}
		});
	}

	@Override
	public List<TMeetingProblem> getFinishUserMeetingProblemList(TMeetingProblem meetingProblem) {
		if(meetingProblem == null){
			meetingProblem = new TMeetingProblem();
		}
		return getDslTemplate().query(meetingProblem, new SelectGenerateCallback<TMeetingProblem>() {

			@Override
			public Select generate(TMeetingProblem t) {
				// TODO Auto-generated method stub
				Select select = Select.selectFrom(T_MEETING_PROBLEM_TABLE)
						.where(and(T_MEETING_PROBLEM_TABLE.DUTY_USER.eq(t.getDutyUser())
						,T_MEETING_PROBLEM_TABLE.STATUS.eq(t.getStatus())));
				return select;
			}
		});
	}

}
