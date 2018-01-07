
package org.tinygroup.workplan.dao.impl;

import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;
import static org.tinygroup.workplan.dao.inter.constant.TUserNotepadTable.T_USER_NOTEPAD_TABLE;

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
import org.tinygroup.workplan.dao.inter.TUserNotepadDao;
import org.tinygroup.workplan.dao.inter.pojo.TUserNotepad;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public class TUserNotepadDaoImpl extends TinyDslDaoSupport implements TUserNotepadDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TUserNotepad add(TUserNotepad tUserNotepad) {
		return getDslTemplate().insertAndReturnKey(tUserNotepad, new InsertGenerateCallback<TUserNotepad>() {
			public Insert generate(TUserNotepad t) {
				Insert insert = insertInto(T_USER_NOTEPAD_TABLE).values(T_USER_NOTEPAD_TABLE.ID.value(t.getId()),
						T_USER_NOTEPAD_TABLE.NOTEPAD_NAME.value(t.getNotepadName()),
						T_USER_NOTEPAD_TABLE.KNOWLEDGE_TYPE.value(t.getKnowledgeType()),
						T_USER_NOTEPAD_TABLE.CREATE_USER.value(t.getCreateUser()),
						T_USER_NOTEPAD_TABLE.CREATE_TIME.value(t.getCreateTime()),
						T_USER_NOTEPAD_TABLE.NOTEPAD_CONTENT.value(t.getNotepadContent()),
						T_USER_NOTEPAD_TABLE.TRANSFER_USER.value(t.getTransferUser()),
						T_USER_NOTEPAD_TABLE.TRANSFER_TIME.value(t.getTransferTime()),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_1.value(t.getExtField1()),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_2.value(t.getExtField2()),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_3.value(t.getExtField3()),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_4.value(t.getExtField4()),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_5.value(t.getExtField5())

				);
				return insert;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TUserNotepad tUserNotepad) {
		if (tUserNotepad == null || tUserNotepad.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tUserNotepad, new UpdateGenerateCallback<TUserNotepad>() {
			public Update generate(TUserNotepad t) {
				Update update = update(T_USER_NOTEPAD_TABLE)
						.set(T_USER_NOTEPAD_TABLE.NOTEPAD_NAME.value(t.getNotepadName()),
								T_USER_NOTEPAD_TABLE.KNOWLEDGE_TYPE.value(t.getKnowledgeType()),
								T_USER_NOTEPAD_TABLE.CREATE_USER.value(t.getCreateUser()),
								T_USER_NOTEPAD_TABLE.CREATE_TIME.value(t.getCreateTime()),
								T_USER_NOTEPAD_TABLE.NOTEPAD_CONTENT.value(t.getNotepadContent()),
								T_USER_NOTEPAD_TABLE.TRANSFER_USER.value(t.getTransferUser()),
								T_USER_NOTEPAD_TABLE.TRANSFER_TIME.value(t.getTransferTime()),
								T_USER_NOTEPAD_TABLE.EXT_FIELD_1.value(t.getExtField1()),
								T_USER_NOTEPAD_TABLE.EXT_FIELD_2.value(t.getExtField2()),
								T_USER_NOTEPAD_TABLE.EXT_FIELD_3.value(t.getExtField3()),
								T_USER_NOTEPAD_TABLE.EXT_FIELD_4.value(t.getExtField4()),
								T_USER_NOTEPAD_TABLE.EXT_FIELD_5.value(t.getExtField5()))
						.where(T_USER_NOTEPAD_TABLE.ID.eq(t.getId()));
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
				return delete(T_USER_NOTEPAD_TABLE).where(T_USER_NOTEPAD_TABLE.ID.eq(pk));
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
				return delete(T_USER_NOTEPAD_TABLE).where(T_USER_NOTEPAD_TABLE.ID.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TUserNotepad getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, TUserNotepad.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(T_USER_NOTEPAD_TABLE).where(T_USER_NOTEPAD_TABLE.ID.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TUserNotepad> query(TUserNotepad tUserNotepad, final OrderBy... orderArgs) {
		if (tUserNotepad == null) {
			tUserNotepad = new TUserNotepad();
		}
		return getDslTemplate().query(tUserNotepad, new SelectGenerateCallback<TUserNotepad>() {
			@SuppressWarnings("rawtypes")
			public Select generate(TUserNotepad t) {
				Select select = selectFrom(T_USER_NOTEPAD_TABLE).where(and(T_USER_NOTEPAD_TABLE.ID.eq(t.getId()),
						T_USER_NOTEPAD_TABLE.NOTEPAD_NAME.eq(t.getNotepadName()),
						T_USER_NOTEPAD_TABLE.KNOWLEDGE_TYPE.eq(t.getKnowledgeType()),
						T_USER_NOTEPAD_TABLE.CREATE_USER.eq(t.getCreateUser()),
						T_USER_NOTEPAD_TABLE.CREATE_TIME.eq(t.getCreateTime()),
						T_USER_NOTEPAD_TABLE.NOTEPAD_CONTENT.eq(t.getNotepadContent()),
						T_USER_NOTEPAD_TABLE.TRANSFER_USER.eq(t.getTransferUser()),
						T_USER_NOTEPAD_TABLE.TRANSFER_TIME.eq(t.getTransferTime()),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_1.eq(t.getExtField1()),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_2.eq(t.getExtField2()),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_3.eq(t.getExtField3()),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_4.eq(t.getExtField4()),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_5.eq(t.getExtField5())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TUserNotepad> queryPager(int start, int limit, TUserNotepad tUserNotepad, final OrderBy... orderArgs) {
		if (tUserNotepad == null) {
			tUserNotepad = new TUserNotepad();
		}
		return getDslTemplate().queryPager(start, limit, tUserNotepad, false,
				new SelectGenerateCallback<TUserNotepad>() {
					public Select generate(TUserNotepad t) {
						Select select = Select.selectFrom(T_USER_NOTEPAD_TABLE)
								.where(and(T_USER_NOTEPAD_TABLE.ID.eq(t.getId()),
										T_USER_NOTEPAD_TABLE.NOTEPAD_NAME.eq(t.getNotepadName()),
										T_USER_NOTEPAD_TABLE.KNOWLEDGE_TYPE.eq(t.getKnowledgeType()),
										T_USER_NOTEPAD_TABLE.CREATE_USER.eq(t.getCreateUser()),
										T_USER_NOTEPAD_TABLE.CREATE_TIME.eq(t.getCreateTime()),
										T_USER_NOTEPAD_TABLE.NOTEPAD_CONTENT.eq(t.getNotepadContent()),
										T_USER_NOTEPAD_TABLE.TRANSFER_USER.eq(t.getTransferUser()),
										T_USER_NOTEPAD_TABLE.TRANSFER_TIME.eq(t.getTransferTime()),
										T_USER_NOTEPAD_TABLE.EXT_FIELD_1.eq(t.getExtField1()),
										T_USER_NOTEPAD_TABLE.EXT_FIELD_2.eq(t.getExtField2()),
										T_USER_NOTEPAD_TABLE.EXT_FIELD_3.eq(t.getExtField3()),
										T_USER_NOTEPAD_TABLE.EXT_FIELD_4.eq(t.getExtField4()),
										T_USER_NOTEPAD_TABLE.EXT_FIELD_5.eq(t.getExtField5())

				));
						return TinyDSLUtil.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<TUserNotepad> tUserNotepad) {
		if (CollectionUtil.isEmpty(tUserNotepad)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tUserNotepad,
				new InsertGenerateCallback<TUserNotepad>() {

					public Insert generate(TUserNotepad t) {
						return insertInto(T_USER_NOTEPAD_TABLE).values(T_USER_NOTEPAD_TABLE.ID.value(t.getId()),
								T_USER_NOTEPAD_TABLE.NOTEPAD_NAME.value(t.getNotepadName()),
								T_USER_NOTEPAD_TABLE.KNOWLEDGE_TYPE.value(t.getKnowledgeType()),
								T_USER_NOTEPAD_TABLE.CREATE_USER.value(t.getCreateUser()),
								T_USER_NOTEPAD_TABLE.CREATE_TIME.value(t.getCreateTime()),
								T_USER_NOTEPAD_TABLE.NOTEPAD_CONTENT.value(t.getNotepadContent()),
								T_USER_NOTEPAD_TABLE.TRANSFER_USER.value(t.getTransferUser()),
								T_USER_NOTEPAD_TABLE.TRANSFER_TIME.value(t.getTransferTime()),
								T_USER_NOTEPAD_TABLE.EXT_FIELD_1.value(t.getExtField1()),
								T_USER_NOTEPAD_TABLE.EXT_FIELD_2.value(t.getExtField2()),
								T_USER_NOTEPAD_TABLE.EXT_FIELD_3.value(t.getExtField3()),
								T_USER_NOTEPAD_TABLE.EXT_FIELD_4.value(t.getExtField4()),
								T_USER_NOTEPAD_TABLE.EXT_FIELD_5.value(t.getExtField5())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TUserNotepad> tUserNotepads) {
		return batchInsert(false, tUserNotepads);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TUserNotepad> tUserNotepad) {
		if (CollectionUtil.isEmpty(tUserNotepad)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tUserNotepad, new UpdateGenerateCallback<TUserNotepad>() {
			public Update generate(TUserNotepad t) {
				return update(T_USER_NOTEPAD_TABLE).set(T_USER_NOTEPAD_TABLE.NOTEPAD_NAME.value(t.getNotepadName()),
						T_USER_NOTEPAD_TABLE.KNOWLEDGE_TYPE.value(t.getKnowledgeType()),
						T_USER_NOTEPAD_TABLE.CREATE_USER.value(t.getCreateUser()),
						T_USER_NOTEPAD_TABLE.CREATE_TIME.value(t.getCreateTime()),
						T_USER_NOTEPAD_TABLE.NOTEPAD_CONTENT.value(t.getNotepadContent()),
						T_USER_NOTEPAD_TABLE.TRANSFER_USER.value(t.getTransferUser()),
						T_USER_NOTEPAD_TABLE.TRANSFER_TIME.value(t.getTransferTime()),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_1.value(t.getExtField1()),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_2.value(t.getExtField2()),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_3.value(t.getExtField3()),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_4.value(t.getExtField4()),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_5.value(t.getExtField5())

				).where(T_USER_NOTEPAD_TABLE.ID.eq(t.getId()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TUserNotepad> tUserNotepad) {
		if (CollectionUtil.isEmpty(tUserNotepad)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tUserNotepad, new DeleteGenerateCallback<TUserNotepad>() {
			public Delete generate(TUserNotepad t) {
				return delete(T_USER_NOTEPAD_TABLE).where(and(T_USER_NOTEPAD_TABLE.ID.eq(t.getId()),
						T_USER_NOTEPAD_TABLE.NOTEPAD_NAME.eq(t.getNotepadName()),
						T_USER_NOTEPAD_TABLE.KNOWLEDGE_TYPE.eq(t.getKnowledgeType()),
						T_USER_NOTEPAD_TABLE.CREATE_USER.eq(t.getCreateUser()),
						T_USER_NOTEPAD_TABLE.CREATE_TIME.eq(t.getCreateTime()),
						T_USER_NOTEPAD_TABLE.NOTEPAD_CONTENT.eq(t.getNotepadContent()),
						T_USER_NOTEPAD_TABLE.TRANSFER_USER.eq(t.getTransferUser()),
						T_USER_NOTEPAD_TABLE.TRANSFER_TIME.eq(t.getTransferTime()),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_1.eq(t.getExtField1()),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_2.eq(t.getExtField2()),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_3.eq(t.getExtField3()),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_4.eq(t.getExtField4()),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_5.eq(t.getExtField5())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<TUserNotepad> tUserNotepad) {
		if (CollectionUtil.isEmpty(tUserNotepad)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tUserNotepad, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(T_USER_NOTEPAD_TABLE).values(
						T_USER_NOTEPAD_TABLE.NOTEPAD_NAME.value(new JdbcNamedParameter("notepadName")),
						T_USER_NOTEPAD_TABLE.KNOWLEDGE_TYPE.value(new JdbcNamedParameter("knowledgeType")),
						T_USER_NOTEPAD_TABLE.CREATE_USER.value(new JdbcNamedParameter("createUser")),
						T_USER_NOTEPAD_TABLE.CREATE_TIME.value(new JdbcNamedParameter("createTime")),
						T_USER_NOTEPAD_TABLE.NOTEPAD_CONTENT.value(new JdbcNamedParameter("notepadContent")),
						T_USER_NOTEPAD_TABLE.TRANSFER_USER.value(new JdbcNamedParameter("transferUser")),
						T_USER_NOTEPAD_TABLE.TRANSFER_TIME.value(new JdbcNamedParameter("transferTime")),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
						T_USER_NOTEPAD_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TUserNotepad> tUserNotepad) {
		if (CollectionUtil.isEmpty(tUserNotepad)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tUserNotepad, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(T_USER_NOTEPAD_TABLE)
						.set(T_USER_NOTEPAD_TABLE.NOTEPAD_NAME.value(new JdbcNamedParameter("notepadName")),
								T_USER_NOTEPAD_TABLE.KNOWLEDGE_TYPE.value(new JdbcNamedParameter("knowledgeType")),
								T_USER_NOTEPAD_TABLE.CREATE_USER.value(new JdbcNamedParameter("createUser")),
								T_USER_NOTEPAD_TABLE.CREATE_TIME.value(new JdbcNamedParameter("createTime")),
								T_USER_NOTEPAD_TABLE.NOTEPAD_CONTENT.value(new JdbcNamedParameter("notepadContent")),
								T_USER_NOTEPAD_TABLE.TRANSFER_USER.value(new JdbcNamedParameter("transferUser")),
								T_USER_NOTEPAD_TABLE.TRANSFER_TIME.value(new JdbcNamedParameter("transferTime")),
								T_USER_NOTEPAD_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
								T_USER_NOTEPAD_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
								T_USER_NOTEPAD_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
								T_USER_NOTEPAD_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
								T_USER_NOTEPAD_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

						).where(T_USER_NOTEPAD_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TUserNotepad> tUserNotepad) {
		if (CollectionUtil.isEmpty(tUserNotepad)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tUserNotepad, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(T_USER_NOTEPAD_TABLE)
						.where(and(T_USER_NOTEPAD_TABLE.NOTEPAD_NAME.eq(new JdbcNamedParameter("notepadName")),
								T_USER_NOTEPAD_TABLE.KNOWLEDGE_TYPE.eq(new JdbcNamedParameter("knowledgeType")),
								T_USER_NOTEPAD_TABLE.CREATE_USER.eq(new JdbcNamedParameter("createUser")),
								T_USER_NOTEPAD_TABLE.CREATE_TIME.eq(new JdbcNamedParameter("createTime")),
								T_USER_NOTEPAD_TABLE.NOTEPAD_CONTENT.eq(new JdbcNamedParameter("notepadContent")),
								T_USER_NOTEPAD_TABLE.TRANSFER_USER.eq(new JdbcNamedParameter("transferUser")),
								T_USER_NOTEPAD_TABLE.TRANSFER_TIME.eq(new JdbcNamedParameter("transferTime")),
								T_USER_NOTEPAD_TABLE.EXT_FIELD_1.eq(new JdbcNamedParameter("extField1")),
								T_USER_NOTEPAD_TABLE.EXT_FIELD_2.eq(new JdbcNamedParameter("extField2")),
								T_USER_NOTEPAD_TABLE.EXT_FIELD_3.eq(new JdbcNamedParameter("extField3")),
								T_USER_NOTEPAD_TABLE.EXT_FIELD_4.eq(new JdbcNamedParameter("extField4")),
								T_USER_NOTEPAD_TABLE.EXT_FIELD_5.eq(new JdbcNamedParameter("extField5"))

				));
			}
		});
	}

	public int[] preparedBatchInsert(List<TUserNotepad> tUserNotepad) {
		return preparedBatchInsert(false, tUserNotepad);
	}

}
