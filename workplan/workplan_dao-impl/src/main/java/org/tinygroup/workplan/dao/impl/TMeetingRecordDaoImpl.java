
package org.tinygroup.workplan.dao.impl;

import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;
import static org.tinygroup.workplan.dao.inter.constant.TMeetingRecordTable.T_MEETING_RECORD_TABLE;

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
import org.tinygroup.workplan.dao.inter.TMeetingRecordDao;
import org.tinygroup.workplan.dao.inter.pojo.TMeetingRecord;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public class TMeetingRecordDaoImpl extends TinyDslDaoSupport implements TMeetingRecordDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TMeetingRecord add(TMeetingRecord tMeetingRecord) {
		return getDslTemplate().insertAndReturnKey(tMeetingRecord, new InsertGenerateCallback<TMeetingRecord>() {
			public Insert generate(TMeetingRecord t) {
				Insert insert = insertInto(T_MEETING_RECORD_TABLE).values(T_MEETING_RECORD_TABLE.ID.value(t.getId()),
						T_MEETING_RECORD_TABLE.MEETING_SUBJECT.value(t.getMeetingSubject()),
						T_MEETING_RECORD_TABLE.MEETING_TIME.value(t.getMeetingTime()),
						T_MEETING_RECORD_TABLE.MEETING_ADDRESS.value(t.getMeetingAddress()),
						T_MEETING_RECORD_TABLE.MEETING_PRESENTER.value(t.getMeetingPresenter()),
						T_MEETING_RECORD_TABLE.MEETING_RECORDER.value(t.getMeetingRecorder()),
						T_MEETING_RECORD_TABLE.CREATE_USER.value(t.getCreateUser()),
						T_MEETING_RECORD_TABLE.MEETING_CONTENT.value(t.getMeetingContent()),
						T_MEETING_RECORD_TABLE.MEETING_RESULT.value(t.getMeetingResult()),
						T_MEETING_RECORD_TABLE.JOIN_MEETING_USER.value(t.getJoinMeetingUser()),
						T_MEETING_RECORD_TABLE.EXT_FIELD_1.value(t.getExtField1()),
						T_MEETING_RECORD_TABLE.EXT_FIELD_2.value(t.getExtField2()),
						T_MEETING_RECORD_TABLE.EXT_FIELD_3.value(t.getExtField3()),
						T_MEETING_RECORD_TABLE.EXT_FIELD_4.value(t.getExtField4()),
						T_MEETING_RECORD_TABLE.EXT_FIELD_5.value(t.getExtField5())

				);
				return insert;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TMeetingRecord tMeetingRecord) {
		if (tMeetingRecord == null || tMeetingRecord.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tMeetingRecord, new UpdateGenerateCallback<TMeetingRecord>() {
			public Update generate(TMeetingRecord t) {
				Update update = update(T_MEETING_RECORD_TABLE)
						.set(T_MEETING_RECORD_TABLE.MEETING_SUBJECT.value(t.getMeetingSubject()),
								T_MEETING_RECORD_TABLE.MEETING_TIME.value(t.getMeetingTime()),
								T_MEETING_RECORD_TABLE.MEETING_ADDRESS.value(t.getMeetingAddress()),
								T_MEETING_RECORD_TABLE.MEETING_PRESENTER.value(t.getMeetingPresenter()),
								T_MEETING_RECORD_TABLE.MEETING_RECORDER.value(t.getMeetingRecorder()),
								T_MEETING_RECORD_TABLE.CREATE_USER.value(t.getCreateUser()),
								T_MEETING_RECORD_TABLE.MEETING_CONTENT.value(t.getMeetingContent()),
								T_MEETING_RECORD_TABLE.MEETING_RESULT.value(t.getMeetingResult()),
								T_MEETING_RECORD_TABLE.JOIN_MEETING_USER.value(t.getJoinMeetingUser()),
								T_MEETING_RECORD_TABLE.EXT_FIELD_1.value(t.getExtField1()),
								T_MEETING_RECORD_TABLE.EXT_FIELD_2.value(t.getExtField2()),
								T_MEETING_RECORD_TABLE.EXT_FIELD_3.value(t.getExtField3()),
								T_MEETING_RECORD_TABLE.EXT_FIELD_4.value(t.getExtField4()),
								T_MEETING_RECORD_TABLE.EXT_FIELD_5.value(t.getExtField5()))
						.where(T_MEETING_RECORD_TABLE.ID.eq(t.getId()));
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
				return delete(T_MEETING_RECORD_TABLE).where(T_MEETING_RECORD_TABLE.ID.eq(pk));
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
				return delete(T_MEETING_RECORD_TABLE).where(T_MEETING_RECORD_TABLE.ID.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TMeetingRecord getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, TMeetingRecord.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(T_MEETING_RECORD_TABLE).where(T_MEETING_RECORD_TABLE.ID.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TMeetingRecord> query(TMeetingRecord tMeetingRecord, final OrderBy... orderArgs) {
		if (tMeetingRecord == null) {
			tMeetingRecord = new TMeetingRecord();
		}
		return getDslTemplate().query(tMeetingRecord, new SelectGenerateCallback<TMeetingRecord>() {
			@SuppressWarnings("rawtypes")
			public Select generate(TMeetingRecord t) {
				Select select = selectFrom(T_MEETING_RECORD_TABLE).where(and(T_MEETING_RECORD_TABLE.ID.eq(t.getId()),
						T_MEETING_RECORD_TABLE.MEETING_SUBJECT.eq(t.getMeetingSubject()),
						T_MEETING_RECORD_TABLE.MEETING_TIME.eq(t.getMeetingTime()),
						T_MEETING_RECORD_TABLE.MEETING_ADDRESS.eq(t.getMeetingAddress()),
						T_MEETING_RECORD_TABLE.MEETING_PRESENTER.eq(t.getMeetingPresenter()),
						T_MEETING_RECORD_TABLE.MEETING_RECORDER.eq(t.getMeetingRecorder()),
						T_MEETING_RECORD_TABLE.CREATE_USER.eq(t.getCreateUser()),
						T_MEETING_RECORD_TABLE.MEETING_CONTENT.eq(t.getMeetingContent()),
						T_MEETING_RECORD_TABLE.MEETING_RESULT.eq(t.getMeetingResult()),
						T_MEETING_RECORD_TABLE.JOIN_MEETING_USER.eq(t.getJoinMeetingUser()),
						T_MEETING_RECORD_TABLE.EXT_FIELD_1.eq(t.getExtField1()),
						T_MEETING_RECORD_TABLE.EXT_FIELD_2.eq(t.getExtField2()),
						T_MEETING_RECORD_TABLE.EXT_FIELD_3.eq(t.getExtField3()),
						T_MEETING_RECORD_TABLE.EXT_FIELD_4.eq(t.getExtField4()),
						T_MEETING_RECORD_TABLE.EXT_FIELD_5.eq(t.getExtField5())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TMeetingRecord> queryPager(int start, int limit, TMeetingRecord tMeetingRecord,
			final OrderBy... orderArgs) {
		if (tMeetingRecord == null) {
			tMeetingRecord = new TMeetingRecord();
		}
		return getDslTemplate().queryPager(start, limit, tMeetingRecord, false,
				new SelectGenerateCallback<TMeetingRecord>() {
					public Select generate(TMeetingRecord t) {
						Select select = Select.selectFrom(T_MEETING_RECORD_TABLE)
								.where(and(T_MEETING_RECORD_TABLE.ID.eq(t.getId()),
										T_MEETING_RECORD_TABLE.MEETING_SUBJECT.eq(t.getMeetingSubject()),
										T_MEETING_RECORD_TABLE.MEETING_TIME.eq(t.getMeetingTime()),
										T_MEETING_RECORD_TABLE.MEETING_ADDRESS.eq(t.getMeetingAddress()),
										T_MEETING_RECORD_TABLE.MEETING_PRESENTER.eq(t.getMeetingPresenter()),
										T_MEETING_RECORD_TABLE.MEETING_RECORDER.eq(t.getMeetingRecorder()),
										T_MEETING_RECORD_TABLE.CREATE_USER.eq(t.getCreateUser()),
										T_MEETING_RECORD_TABLE.MEETING_CONTENT.eq(t.getMeetingContent()),
										T_MEETING_RECORD_TABLE.MEETING_RESULT.eq(t.getMeetingResult()),
										T_MEETING_RECORD_TABLE.JOIN_MEETING_USER.eq(t.getJoinMeetingUser()),
										T_MEETING_RECORD_TABLE.EXT_FIELD_1.eq(t.getExtField1()),
										T_MEETING_RECORD_TABLE.EXT_FIELD_2.eq(t.getExtField2()),
										T_MEETING_RECORD_TABLE.EXT_FIELD_3.eq(t.getExtField3()),
										T_MEETING_RECORD_TABLE.EXT_FIELD_4.eq(t.getExtField4()),
										T_MEETING_RECORD_TABLE.EXT_FIELD_5.eq(t.getExtField5())

				));
						return TinyDSLUtil.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<TMeetingRecord> tMeetingRecord) {
		if (CollectionUtil.isEmpty(tMeetingRecord)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tMeetingRecord,
				new InsertGenerateCallback<TMeetingRecord>() {

					public Insert generate(TMeetingRecord t) {
						return insertInto(T_MEETING_RECORD_TABLE).values(T_MEETING_RECORD_TABLE.ID.value(t.getId()),
								T_MEETING_RECORD_TABLE.MEETING_SUBJECT.value(t.getMeetingSubject()),
								T_MEETING_RECORD_TABLE.MEETING_TIME.value(t.getMeetingTime()),
								T_MEETING_RECORD_TABLE.MEETING_ADDRESS.value(t.getMeetingAddress()),
								T_MEETING_RECORD_TABLE.MEETING_PRESENTER.value(t.getMeetingPresenter()),
								T_MEETING_RECORD_TABLE.MEETING_RECORDER.value(t.getMeetingRecorder()),
								T_MEETING_RECORD_TABLE.CREATE_USER.value(t.getCreateUser()),
								T_MEETING_RECORD_TABLE.MEETING_CONTENT.value(t.getMeetingContent()),
								T_MEETING_RECORD_TABLE.MEETING_RESULT.value(t.getMeetingResult()),
								T_MEETING_RECORD_TABLE.JOIN_MEETING_USER.value(t.getJoinMeetingUser()),
								T_MEETING_RECORD_TABLE.EXT_FIELD_1.value(t.getExtField1()),
								T_MEETING_RECORD_TABLE.EXT_FIELD_2.value(t.getExtField2()),
								T_MEETING_RECORD_TABLE.EXT_FIELD_3.value(t.getExtField3()),
								T_MEETING_RECORD_TABLE.EXT_FIELD_4.value(t.getExtField4()),
								T_MEETING_RECORD_TABLE.EXT_FIELD_5.value(t.getExtField5())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TMeetingRecord> tMeetingRecords) {
		return batchInsert(false, tMeetingRecords);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TMeetingRecord> tMeetingRecord) {
		if (CollectionUtil.isEmpty(tMeetingRecord)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tMeetingRecord, new UpdateGenerateCallback<TMeetingRecord>() {
			public Update generate(TMeetingRecord t) {
				return update(T_MEETING_RECORD_TABLE)
						.set(T_MEETING_RECORD_TABLE.MEETING_SUBJECT.value(t.getMeetingSubject()),
								T_MEETING_RECORD_TABLE.MEETING_TIME.value(t.getMeetingTime()),
								T_MEETING_RECORD_TABLE.MEETING_ADDRESS.value(t.getMeetingAddress()),
								T_MEETING_RECORD_TABLE.MEETING_PRESENTER.value(t.getMeetingPresenter()),
								T_MEETING_RECORD_TABLE.MEETING_RECORDER.value(t.getMeetingRecorder()),
								T_MEETING_RECORD_TABLE.CREATE_USER.value(t.getCreateUser()),
								T_MEETING_RECORD_TABLE.MEETING_CONTENT.value(t.getMeetingContent()),
								T_MEETING_RECORD_TABLE.MEETING_RESULT.value(t.getMeetingResult()),
								T_MEETING_RECORD_TABLE.JOIN_MEETING_USER.value(t.getJoinMeetingUser()),
								T_MEETING_RECORD_TABLE.EXT_FIELD_1.value(t.getExtField1()),
								T_MEETING_RECORD_TABLE.EXT_FIELD_2.value(t.getExtField2()),
								T_MEETING_RECORD_TABLE.EXT_FIELD_3.value(t.getExtField3()),
								T_MEETING_RECORD_TABLE.EXT_FIELD_4.value(t.getExtField4()),
								T_MEETING_RECORD_TABLE.EXT_FIELD_5.value(t.getExtField5())

						).where(T_MEETING_RECORD_TABLE.ID.eq(t.getId()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TMeetingRecord> tMeetingRecord) {
		if (CollectionUtil.isEmpty(tMeetingRecord)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tMeetingRecord, new DeleteGenerateCallback<TMeetingRecord>() {
			public Delete generate(TMeetingRecord t) {
				return delete(T_MEETING_RECORD_TABLE).where(and(T_MEETING_RECORD_TABLE.ID.eq(t.getId()),
						T_MEETING_RECORD_TABLE.MEETING_SUBJECT.eq(t.getMeetingSubject()),
						T_MEETING_RECORD_TABLE.MEETING_TIME.eq(t.getMeetingTime()),
						T_MEETING_RECORD_TABLE.MEETING_ADDRESS.eq(t.getMeetingAddress()),
						T_MEETING_RECORD_TABLE.MEETING_PRESENTER.eq(t.getMeetingPresenter()),
						T_MEETING_RECORD_TABLE.MEETING_RECORDER.eq(t.getMeetingRecorder()),
						T_MEETING_RECORD_TABLE.CREATE_USER.eq(t.getCreateUser()),
						T_MEETING_RECORD_TABLE.MEETING_CONTENT.eq(t.getMeetingContent()),
						T_MEETING_RECORD_TABLE.MEETING_RESULT.eq(t.getMeetingResult()),
						T_MEETING_RECORD_TABLE.JOIN_MEETING_USER.eq(t.getJoinMeetingUser()),
						T_MEETING_RECORD_TABLE.EXT_FIELD_1.eq(t.getExtField1()),
						T_MEETING_RECORD_TABLE.EXT_FIELD_2.eq(t.getExtField2()),
						T_MEETING_RECORD_TABLE.EXT_FIELD_3.eq(t.getExtField3()),
						T_MEETING_RECORD_TABLE.EXT_FIELD_4.eq(t.getExtField4()),
						T_MEETING_RECORD_TABLE.EXT_FIELD_5.eq(t.getExtField5())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<TMeetingRecord> tMeetingRecord) {
		if (CollectionUtil.isEmpty(tMeetingRecord)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tMeetingRecord, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(T_MEETING_RECORD_TABLE).values(
						T_MEETING_RECORD_TABLE.MEETING_SUBJECT.value(new JdbcNamedParameter("meetingSubject")),
						T_MEETING_RECORD_TABLE.MEETING_TIME.value(new JdbcNamedParameter("meetingTime")),
						T_MEETING_RECORD_TABLE.MEETING_ADDRESS.value(new JdbcNamedParameter("meetingAddress")),
						T_MEETING_RECORD_TABLE.MEETING_PRESENTER.value(new JdbcNamedParameter("meetingPresenter")),
						T_MEETING_RECORD_TABLE.MEETING_RECORDER.value(new JdbcNamedParameter("meetingRecorder")),
						T_MEETING_RECORD_TABLE.CREATE_USER.value(new JdbcNamedParameter("createUser")),
						T_MEETING_RECORD_TABLE.MEETING_CONTENT.value(new JdbcNamedParameter("meetingContent")),
						T_MEETING_RECORD_TABLE.MEETING_RESULT.value(new JdbcNamedParameter("meetingResult")),
						T_MEETING_RECORD_TABLE.JOIN_MEETING_USER.value(new JdbcNamedParameter("joinMeetingUser")),
						T_MEETING_RECORD_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
						T_MEETING_RECORD_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
						T_MEETING_RECORD_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
						T_MEETING_RECORD_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
						T_MEETING_RECORD_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TMeetingRecord> tMeetingRecord) {
		if (CollectionUtil.isEmpty(tMeetingRecord)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tMeetingRecord, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(T_MEETING_RECORD_TABLE).set(
						T_MEETING_RECORD_TABLE.MEETING_SUBJECT.value(new JdbcNamedParameter("meetingSubject")),
						T_MEETING_RECORD_TABLE.MEETING_TIME.value(new JdbcNamedParameter("meetingTime")),
						T_MEETING_RECORD_TABLE.MEETING_ADDRESS.value(new JdbcNamedParameter("meetingAddress")),
						T_MEETING_RECORD_TABLE.MEETING_PRESENTER.value(new JdbcNamedParameter("meetingPresenter")),
						T_MEETING_RECORD_TABLE.MEETING_RECORDER.value(new JdbcNamedParameter("meetingRecorder")),
						T_MEETING_RECORD_TABLE.CREATE_USER.value(new JdbcNamedParameter("createUser")),
						T_MEETING_RECORD_TABLE.MEETING_CONTENT.value(new JdbcNamedParameter("meetingContent")),
						T_MEETING_RECORD_TABLE.MEETING_RESULT.value(new JdbcNamedParameter("meetingResult")),
						T_MEETING_RECORD_TABLE.JOIN_MEETING_USER.value(new JdbcNamedParameter("joinMeetingUser")),
						T_MEETING_RECORD_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
						T_MEETING_RECORD_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
						T_MEETING_RECORD_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
						T_MEETING_RECORD_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
						T_MEETING_RECORD_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				).where(T_MEETING_RECORD_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TMeetingRecord> tMeetingRecord) {
		if (CollectionUtil.isEmpty(tMeetingRecord)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tMeetingRecord, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(T_MEETING_RECORD_TABLE)
						.where(and(T_MEETING_RECORD_TABLE.MEETING_SUBJECT.eq(new JdbcNamedParameter("meetingSubject")),
								T_MEETING_RECORD_TABLE.MEETING_TIME.eq(new JdbcNamedParameter("meetingTime")),
								T_MEETING_RECORD_TABLE.MEETING_ADDRESS.eq(new JdbcNamedParameter("meetingAddress")),
								T_MEETING_RECORD_TABLE.MEETING_PRESENTER.eq(new JdbcNamedParameter("meetingPresenter")),
								T_MEETING_RECORD_TABLE.MEETING_RECORDER.eq(new JdbcNamedParameter("meetingRecorder")),
								T_MEETING_RECORD_TABLE.CREATE_USER.eq(new JdbcNamedParameter("createUser")),
								T_MEETING_RECORD_TABLE.MEETING_CONTENT.eq(new JdbcNamedParameter("meetingContent")),
								T_MEETING_RECORD_TABLE.MEETING_RESULT.eq(new JdbcNamedParameter("meetingResult")),
								T_MEETING_RECORD_TABLE.JOIN_MEETING_USER.eq(new JdbcNamedParameter("joinMeetingUser")),
								T_MEETING_RECORD_TABLE.EXT_FIELD_1.eq(new JdbcNamedParameter("extField1")),
								T_MEETING_RECORD_TABLE.EXT_FIELD_2.eq(new JdbcNamedParameter("extField2")),
								T_MEETING_RECORD_TABLE.EXT_FIELD_3.eq(new JdbcNamedParameter("extField3")),
								T_MEETING_RECORD_TABLE.EXT_FIELD_4.eq(new JdbcNamedParameter("extField4")),
								T_MEETING_RECORD_TABLE.EXT_FIELD_5.eq(new JdbcNamedParameter("extField5"))

				));
			}
		});
	}

	public int[] preparedBatchInsert(List<TMeetingRecord> tMeetingRecord) {
		return preparedBatchInsert(false, tMeetingRecord);
	}

}
