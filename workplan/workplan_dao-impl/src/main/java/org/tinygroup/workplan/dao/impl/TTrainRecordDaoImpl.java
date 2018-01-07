
package org.tinygroup.workplan.dao.impl;

import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;
import static org.tinygroup.workplan.dao.inter.constant.TTrainRecordTable.T_TRAIN_RECORD_TABLE;

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
import org.tinygroup.workplan.dao.inter.TTrainRecordDao;
import org.tinygroup.workplan.dao.inter.pojo.TTrainRecord;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public class TTrainRecordDaoImpl extends TinyDslDaoSupport implements TTrainRecordDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TTrainRecord add(TTrainRecord tTrainRecord) {
		return getDslTemplate().insertAndReturnKey(tTrainRecord, new InsertGenerateCallback<TTrainRecord>() {
			public Insert generate(TTrainRecord t) {
				Insert insert = insertInto(T_TRAIN_RECORD_TABLE).values(T_TRAIN_RECORD_TABLE.ID.value(t.getId()),
						T_TRAIN_RECORD_TABLE.TRAIN_THEME.value(t.getTrainTheme()),
						T_TRAIN_RECORD_TABLE.SPEEKER.value(t.getSpeeker()),
						T_TRAIN_RECORD_TABLE.MEETING_RECORDER.value(t.getMeetingRecorder()),
						T_TRAIN_RECORD_TABLE.CREATE_USER.value(t.getCreateUser()),
						T_TRAIN_RECORD_TABLE.KNOWLEDGE_TYPE.value(t.getKnowledgeType()),
						T_TRAIN_RECORD_TABLE.TRAIN_CONTENT.value(t.getTrainContent()),
						T_TRAIN_RECORD_TABLE.TRAIN_TIME.value(t.getTrainTime()),
						T_TRAIN_RECORD_TABLE.JOIN_MEETING_USER.value(t.getJoinMeetingUser()),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_1.value(t.getExtField1()),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_2.value(t.getExtField2()),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_3.value(t.getExtField3()),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_4.value(t.getExtField4()),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_5.value(t.getExtField5())

				);
				return insert;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TTrainRecord tTrainRecord) {
		if (tTrainRecord == null || tTrainRecord.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tTrainRecord, new UpdateGenerateCallback<TTrainRecord>() {
			public Update generate(TTrainRecord t) {
				Update update = update(T_TRAIN_RECORD_TABLE)
						.set(T_TRAIN_RECORD_TABLE.TRAIN_THEME.value(t.getTrainTheme()),
								T_TRAIN_RECORD_TABLE.SPEEKER.value(t.getSpeeker()),
								T_TRAIN_RECORD_TABLE.MEETING_RECORDER.value(t.getMeetingRecorder()),
								T_TRAIN_RECORD_TABLE.CREATE_USER.value(t.getCreateUser()),
								T_TRAIN_RECORD_TABLE.KNOWLEDGE_TYPE.value(t.getKnowledgeType()),
								T_TRAIN_RECORD_TABLE.TRAIN_CONTENT.value(t.getTrainContent()),
								T_TRAIN_RECORD_TABLE.TRAIN_TIME.value(t.getTrainTime()),
								T_TRAIN_RECORD_TABLE.JOIN_MEETING_USER.value(t.getJoinMeetingUser()),
								T_TRAIN_RECORD_TABLE.EXT_FIELD_1.value(t.getExtField1()),
								T_TRAIN_RECORD_TABLE.EXT_FIELD_2.value(t.getExtField2()),
								T_TRAIN_RECORD_TABLE.EXT_FIELD_3.value(t.getExtField3()),
								T_TRAIN_RECORD_TABLE.EXT_FIELD_4.value(t.getExtField4()),
								T_TRAIN_RECORD_TABLE.EXT_FIELD_5.value(t.getExtField5()))
						.where(T_TRAIN_RECORD_TABLE.ID.eq(t.getId()));
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
				return delete(T_TRAIN_RECORD_TABLE).where(T_TRAIN_RECORD_TABLE.ID.eq(pk));
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
				return delete(T_TRAIN_RECORD_TABLE).where(T_TRAIN_RECORD_TABLE.ID.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TTrainRecord getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, TTrainRecord.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(T_TRAIN_RECORD_TABLE).where(T_TRAIN_RECORD_TABLE.ID.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TTrainRecord> query(TTrainRecord tTrainRecord, final OrderBy... orderArgs) {
		if (tTrainRecord == null) {
			tTrainRecord = new TTrainRecord();
		}
		return getDslTemplate().query(tTrainRecord, new SelectGenerateCallback<TTrainRecord>() {
			@SuppressWarnings("rawtypes")
			public Select generate(TTrainRecord t) {
				Select select = selectFrom(T_TRAIN_RECORD_TABLE).where(and(T_TRAIN_RECORD_TABLE.ID.eq(t.getId()),
						T_TRAIN_RECORD_TABLE.TRAIN_THEME.eq(t.getTrainTheme()),
						T_TRAIN_RECORD_TABLE.SPEEKER.eq(t.getSpeeker()),
						T_TRAIN_RECORD_TABLE.MEETING_RECORDER.eq(t.getMeetingRecorder()),
						T_TRAIN_RECORD_TABLE.CREATE_USER.eq(t.getCreateUser()),
						T_TRAIN_RECORD_TABLE.KNOWLEDGE_TYPE.eq(t.getKnowledgeType()),
						T_TRAIN_RECORD_TABLE.TRAIN_CONTENT.eq(t.getTrainContent()),
						T_TRAIN_RECORD_TABLE.TRAIN_TIME.eq(t.getTrainTime()),
						T_TRAIN_RECORD_TABLE.JOIN_MEETING_USER.eq(t.getJoinMeetingUser()),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_1.eq(t.getExtField1()),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_2.eq(t.getExtField2()),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_3.eq(t.getExtField3()),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_4.eq(t.getExtField4()),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_5.eq(t.getExtField5())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TTrainRecord> queryPager(int start, int limit, TTrainRecord tTrainRecord, final OrderBy... orderArgs) {
		if (tTrainRecord == null) {
			tTrainRecord = new TTrainRecord();
		}
		return getDslTemplate().queryPager(start, limit, tTrainRecord, false,
				new SelectGenerateCallback<TTrainRecord>() {
					public Select generate(TTrainRecord t) {
						Select select = Select.selectFrom(T_TRAIN_RECORD_TABLE)
								.where(and(T_TRAIN_RECORD_TABLE.ID.eq(t.getId()),
										T_TRAIN_RECORD_TABLE.TRAIN_THEME.eq(t.getTrainTheme()),
										T_TRAIN_RECORD_TABLE.SPEEKER.eq(t.getSpeeker()),
										T_TRAIN_RECORD_TABLE.MEETING_RECORDER.eq(t.getMeetingRecorder()),
										T_TRAIN_RECORD_TABLE.CREATE_USER.eq(t.getCreateUser()),
										T_TRAIN_RECORD_TABLE.KNOWLEDGE_TYPE.eq(t.getKnowledgeType()),
										T_TRAIN_RECORD_TABLE.TRAIN_CONTENT.eq(t.getTrainContent()),
										T_TRAIN_RECORD_TABLE.TRAIN_TIME.eq(t.getTrainTime()),
										T_TRAIN_RECORD_TABLE.JOIN_MEETING_USER.eq(t.getJoinMeetingUser()),
										T_TRAIN_RECORD_TABLE.EXT_FIELD_1.eq(t.getExtField1()),
										T_TRAIN_RECORD_TABLE.EXT_FIELD_2.eq(t.getExtField2()),
										T_TRAIN_RECORD_TABLE.EXT_FIELD_3.eq(t.getExtField3()),
										T_TRAIN_RECORD_TABLE.EXT_FIELD_4.eq(t.getExtField4()),
										T_TRAIN_RECORD_TABLE.EXT_FIELD_5.eq(t.getExtField5())

				));
						return TinyDSLUtil.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<TTrainRecord> tTrainRecord) {
		if (CollectionUtil.isEmpty(tTrainRecord)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tTrainRecord,
				new InsertGenerateCallback<TTrainRecord>() {

					public Insert generate(TTrainRecord t) {
						return insertInto(T_TRAIN_RECORD_TABLE).values(T_TRAIN_RECORD_TABLE.ID.value(t.getId()),
								T_TRAIN_RECORD_TABLE.TRAIN_THEME.value(t.getTrainTheme()),
								T_TRAIN_RECORD_TABLE.SPEEKER.value(t.getSpeeker()),
								T_TRAIN_RECORD_TABLE.MEETING_RECORDER.value(t.getMeetingRecorder()),
								T_TRAIN_RECORD_TABLE.CREATE_USER.value(t.getCreateUser()),
								T_TRAIN_RECORD_TABLE.KNOWLEDGE_TYPE.value(t.getKnowledgeType()),
								T_TRAIN_RECORD_TABLE.TRAIN_CONTENT.value(t.getTrainContent()),
								T_TRAIN_RECORD_TABLE.TRAIN_TIME.value(t.getTrainTime()),
								T_TRAIN_RECORD_TABLE.JOIN_MEETING_USER.value(t.getJoinMeetingUser()),
								T_TRAIN_RECORD_TABLE.EXT_FIELD_1.value(t.getExtField1()),
								T_TRAIN_RECORD_TABLE.EXT_FIELD_2.value(t.getExtField2()),
								T_TRAIN_RECORD_TABLE.EXT_FIELD_3.value(t.getExtField3()),
								T_TRAIN_RECORD_TABLE.EXT_FIELD_4.value(t.getExtField4()),
								T_TRAIN_RECORD_TABLE.EXT_FIELD_5.value(t.getExtField5())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TTrainRecord> tTrainRecords) {
		return batchInsert(false, tTrainRecords);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TTrainRecord> tTrainRecord) {
		if (CollectionUtil.isEmpty(tTrainRecord)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tTrainRecord, new UpdateGenerateCallback<TTrainRecord>() {
			public Update generate(TTrainRecord t) {
				return update(T_TRAIN_RECORD_TABLE).set(T_TRAIN_RECORD_TABLE.TRAIN_THEME.value(t.getTrainTheme()),
						T_TRAIN_RECORD_TABLE.SPEEKER.value(t.getSpeeker()),
						T_TRAIN_RECORD_TABLE.MEETING_RECORDER.value(t.getMeetingRecorder()),
						T_TRAIN_RECORD_TABLE.CREATE_USER.value(t.getCreateUser()),
						T_TRAIN_RECORD_TABLE.KNOWLEDGE_TYPE.value(t.getKnowledgeType()),
						T_TRAIN_RECORD_TABLE.TRAIN_CONTENT.value(t.getTrainContent()),
						T_TRAIN_RECORD_TABLE.TRAIN_TIME.value(t.getTrainTime()),
						T_TRAIN_RECORD_TABLE.JOIN_MEETING_USER.value(t.getJoinMeetingUser()),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_1.value(t.getExtField1()),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_2.value(t.getExtField2()),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_3.value(t.getExtField3()),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_4.value(t.getExtField4()),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_5.value(t.getExtField5())

				).where(T_TRAIN_RECORD_TABLE.ID.eq(t.getId()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TTrainRecord> tTrainRecord) {
		if (CollectionUtil.isEmpty(tTrainRecord)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tTrainRecord, new DeleteGenerateCallback<TTrainRecord>() {
			public Delete generate(TTrainRecord t) {
				return delete(T_TRAIN_RECORD_TABLE).where(and(T_TRAIN_RECORD_TABLE.ID.eq(t.getId()),
						T_TRAIN_RECORD_TABLE.TRAIN_THEME.eq(t.getTrainTheme()),
						T_TRAIN_RECORD_TABLE.SPEEKER.eq(t.getSpeeker()),
						T_TRAIN_RECORD_TABLE.MEETING_RECORDER.eq(t.getMeetingRecorder()),
						T_TRAIN_RECORD_TABLE.CREATE_USER.eq(t.getCreateUser()),
						T_TRAIN_RECORD_TABLE.KNOWLEDGE_TYPE.eq(t.getKnowledgeType()),
						T_TRAIN_RECORD_TABLE.TRAIN_CONTENT.eq(t.getTrainContent()),
						T_TRAIN_RECORD_TABLE.TRAIN_TIME.eq(t.getTrainTime()),
						T_TRAIN_RECORD_TABLE.JOIN_MEETING_USER.eq(t.getJoinMeetingUser()),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_1.eq(t.getExtField1()),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_2.eq(t.getExtField2()),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_3.eq(t.getExtField3()),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_4.eq(t.getExtField4()),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_5.eq(t.getExtField5())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<TTrainRecord> tTrainRecord) {
		if (CollectionUtil.isEmpty(tTrainRecord)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tTrainRecord, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(T_TRAIN_RECORD_TABLE).values(
						T_TRAIN_RECORD_TABLE.TRAIN_THEME.value(new JdbcNamedParameter("trainTheme")),
						T_TRAIN_RECORD_TABLE.SPEEKER.value(new JdbcNamedParameter("speeker")),
						T_TRAIN_RECORD_TABLE.MEETING_RECORDER.value(new JdbcNamedParameter("meetingRecorder")),
						T_TRAIN_RECORD_TABLE.CREATE_USER.value(new JdbcNamedParameter("createUser")),
						T_TRAIN_RECORD_TABLE.KNOWLEDGE_TYPE.value(new JdbcNamedParameter("knowledgeType")),
						T_TRAIN_RECORD_TABLE.TRAIN_CONTENT.value(new JdbcNamedParameter("trainContent")),
						T_TRAIN_RECORD_TABLE.TRAIN_TIME.value(new JdbcNamedParameter("trainTime")),
						T_TRAIN_RECORD_TABLE.JOIN_MEETING_USER.value(new JdbcNamedParameter("joinMeetingUser")),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
						T_TRAIN_RECORD_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TTrainRecord> tTrainRecord) {
		if (CollectionUtil.isEmpty(tTrainRecord)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tTrainRecord, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(T_TRAIN_RECORD_TABLE)
						.set(T_TRAIN_RECORD_TABLE.TRAIN_THEME.value(new JdbcNamedParameter("trainTheme")),
								T_TRAIN_RECORD_TABLE.SPEEKER.value(new JdbcNamedParameter("speeker")),
								T_TRAIN_RECORD_TABLE.MEETING_RECORDER.value(new JdbcNamedParameter("meetingRecorder")),
								T_TRAIN_RECORD_TABLE.CREATE_USER.value(new JdbcNamedParameter("createUser")),
								T_TRAIN_RECORD_TABLE.KNOWLEDGE_TYPE.value(new JdbcNamedParameter("knowledgeType")),
								T_TRAIN_RECORD_TABLE.TRAIN_CONTENT.value(new JdbcNamedParameter("trainContent")),
								T_TRAIN_RECORD_TABLE.TRAIN_TIME.value(new JdbcNamedParameter("trainTime")),
								T_TRAIN_RECORD_TABLE.JOIN_MEETING_USER.value(new JdbcNamedParameter("joinMeetingUser")),
								T_TRAIN_RECORD_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
								T_TRAIN_RECORD_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
								T_TRAIN_RECORD_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
								T_TRAIN_RECORD_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
								T_TRAIN_RECORD_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

						).where(T_TRAIN_RECORD_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TTrainRecord> tTrainRecord) {
		if (CollectionUtil.isEmpty(tTrainRecord)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tTrainRecord, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(T_TRAIN_RECORD_TABLE)
						.where(and(T_TRAIN_RECORD_TABLE.TRAIN_THEME.eq(new JdbcNamedParameter("trainTheme")),
								T_TRAIN_RECORD_TABLE.SPEEKER.eq(new JdbcNamedParameter("speeker")),
								T_TRAIN_RECORD_TABLE.MEETING_RECORDER.eq(new JdbcNamedParameter("meetingRecorder")),
								T_TRAIN_RECORD_TABLE.CREATE_USER.eq(new JdbcNamedParameter("createUser")),
								T_TRAIN_RECORD_TABLE.KNOWLEDGE_TYPE.eq(new JdbcNamedParameter("knowledgeType")),
								T_TRAIN_RECORD_TABLE.TRAIN_CONTENT.eq(new JdbcNamedParameter("trainContent")),
								T_TRAIN_RECORD_TABLE.TRAIN_TIME.eq(new JdbcNamedParameter("trainTime")),
								T_TRAIN_RECORD_TABLE.JOIN_MEETING_USER.eq(new JdbcNamedParameter("joinMeetingUser")),
								T_TRAIN_RECORD_TABLE.EXT_FIELD_1.eq(new JdbcNamedParameter("extField1")),
								T_TRAIN_RECORD_TABLE.EXT_FIELD_2.eq(new JdbcNamedParameter("extField2")),
								T_TRAIN_RECORD_TABLE.EXT_FIELD_3.eq(new JdbcNamedParameter("extField3")),
								T_TRAIN_RECORD_TABLE.EXT_FIELD_4.eq(new JdbcNamedParameter("extField4")),
								T_TRAIN_RECORD_TABLE.EXT_FIELD_5.eq(new JdbcNamedParameter("extField5"))

				));
			}
		});
	}

	public int[] preparedBatchInsert(List<TTrainRecord> tTrainRecord) {
		return preparedBatchInsert(false, tTrainRecord);
	}

}
