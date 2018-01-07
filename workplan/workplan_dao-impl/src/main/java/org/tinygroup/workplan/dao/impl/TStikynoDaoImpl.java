
package org.tinygroup.workplan.dao.impl;

import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;
import static org.tinygroup.workplan.dao.inter.constant.TStikynoTable.T_STIKYNO_TABLE;

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
import org.tinygroup.workplan.dao.inter.TStikynoDao;
import org.tinygroup.workplan.dao.inter.pojo.TStikyno;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public class TStikynoDaoImpl extends TinyDslDaoSupport implements TStikynoDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TStikyno add(TStikyno tStikyno) {
		return getDslTemplate().insertAndReturnKey(tStikyno, new InsertGenerateCallback<TStikyno>() {
			public Insert generate(TStikyno t) {
				Insert insert = insertInto(T_STIKYNO_TABLE).values(T_STIKYNO_TABLE.ID.value(t.getId()),
						T_STIKYNO_TABLE.CREATE_USER.value(t.getCreateUser()),
						T_STIKYNO_TABLE.CREATE_TIME.value(t.getCreateTime()), T_STIKYNO_TABLE.TILTE.value(t.getTilte()),
						T_STIKYNO_TABLE.CONTENT.value(t.getContent()), T_STIKYNO_TABLE.TYPE.value(t.getType()),
						T_STIKYNO_TABLE.HANDLE_TIME.value(t.getHandleTime()),
						T_STIKYNO_TABLE.SOLVE_TIME.value(t.getSolveTime()),
						T_STIKYNO_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						T_STIKYNO_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						T_STIKYNO_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						T_STIKYNO_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						T_STIKYNO_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
				return insert;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TStikyno tStikyno) {
		if (tStikyno == null || tStikyno.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tStikyno, new UpdateGenerateCallback<TStikyno>() {
			public Update generate(TStikyno t) {
				Update update = update(T_STIKYNO_TABLE).set(T_STIKYNO_TABLE.CREATE_USER.value(t.getCreateUser()),
						T_STIKYNO_TABLE.CREATE_TIME.value(t.getCreateTime()), T_STIKYNO_TABLE.TILTE.value(t.getTilte()),
						T_STIKYNO_TABLE.CONTENT.value(t.getContent()), T_STIKYNO_TABLE.TYPE.value(t.getType()),
						T_STIKYNO_TABLE.HANDLE_TIME.value(t.getHandleTime()),
						T_STIKYNO_TABLE.SOLVE_TIME.value(t.getSolveTime()),
						T_STIKYNO_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						T_STIKYNO_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						T_STIKYNO_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						T_STIKYNO_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						T_STIKYNO_TABLE.EXT_FIELD_5.value(t.getExtField_5())).where(T_STIKYNO_TABLE.ID.eq(t.getId()));
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
				return delete(T_STIKYNO_TABLE).where(T_STIKYNO_TABLE.ID.eq(pk));
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
				return delete(T_STIKYNO_TABLE).where(T_STIKYNO_TABLE.ID.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TStikyno getByKey(Integer pk) {
		TStikyno stikyno = getDslTemplate().getByKey(pk, TStikyno.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				Select select =selectFrom(T_STIKYNO_TABLE).where(T_STIKYNO_TABLE.ID.eq(t));
				return select;
			}
		});
		return stikyno;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TStikyno> query(TStikyno tStikyno, final OrderBy... orderArgs) {
		if (tStikyno == null) {
			tStikyno = new TStikyno();
		}
		return getDslTemplate().query(tStikyno, new SelectGenerateCallback<TStikyno>() {
			@SuppressWarnings("rawtypes")
			public Select generate(TStikyno t) {
				Select select = selectFrom(T_STIKYNO_TABLE)
						.where(and(T_STIKYNO_TABLE.ID.eq(t.getId()), T_STIKYNO_TABLE.CREATE_USER.eq(t.getCreateUser()),
								T_STIKYNO_TABLE.CREATE_TIME.eq(t.getCreateTime()),
								T_STIKYNO_TABLE.TILTE.eq(t.getTilte()), T_STIKYNO_TABLE.CONTENT.eq(t.getContent()),
								T_STIKYNO_TABLE.TYPE.eq(t.getType()), T_STIKYNO_TABLE.HANDLE_TIME.eq(t.getHandleTime()),
								T_STIKYNO_TABLE.SOLVE_TIME.eq(t.getSolveTime()),
								T_STIKYNO_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
								T_STIKYNO_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
								T_STIKYNO_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
								T_STIKYNO_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
								T_STIKYNO_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TStikyno> queryPager(int start, int limit, TStikyno tStikyno, final OrderBy... orderArgs) {
		if (tStikyno == null) {
			tStikyno = new TStikyno();
		}
		return getDslTemplate().queryPager(start, limit, tStikyno, false, new SelectGenerateCallback<TStikyno>() {
			public Select generate(TStikyno t) {
				Select select = Select.selectFrom(T_STIKYNO_TABLE)
						.where(and(T_STIKYNO_TABLE.ID.eq(t.getId()), T_STIKYNO_TABLE.CREATE_USER.eq(t.getCreateUser()),
								T_STIKYNO_TABLE.CREATE_TIME.eq(t.getCreateTime()),
								T_STIKYNO_TABLE.TILTE.eq(t.getTilte()), T_STIKYNO_TABLE.CONTENT.eq(t.getContent()),
								T_STIKYNO_TABLE.TYPE.eq(t.getType()), T_STIKYNO_TABLE.HANDLE_TIME.eq(t.getHandleTime()),
								T_STIKYNO_TABLE.SOLVE_TIME.eq(t.getSolveTime()),
								T_STIKYNO_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
								T_STIKYNO_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
								T_STIKYNO_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
								T_STIKYNO_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
								T_STIKYNO_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<TStikyno> tStikyno) {
		if (CollectionUtil.isEmpty(tStikyno)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tStikyno, new InsertGenerateCallback<TStikyno>() {

			public Insert generate(TStikyno t) {
				return insertInto(T_STIKYNO_TABLE).values(T_STIKYNO_TABLE.ID.value(t.getId()),
						T_STIKYNO_TABLE.CREATE_USER.value(t.getCreateUser()),
						T_STIKYNO_TABLE.CREATE_TIME.value(t.getCreateTime()), T_STIKYNO_TABLE.TILTE.value(t.getTilte()),
						T_STIKYNO_TABLE.CONTENT.value(t.getContent()), T_STIKYNO_TABLE.TYPE.value(t.getType()),
						T_STIKYNO_TABLE.HANDLE_TIME.value(t.getHandleTime()),
						T_STIKYNO_TABLE.SOLVE_TIME.value(t.getSolveTime()),
						T_STIKYNO_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						T_STIKYNO_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						T_STIKYNO_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						T_STIKYNO_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						T_STIKYNO_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TStikyno> tStikynos) {
		return batchInsert(false, tStikynos);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TStikyno> tStikyno) {
		if (CollectionUtil.isEmpty(tStikyno)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tStikyno, new UpdateGenerateCallback<TStikyno>() {
			public Update generate(TStikyno t) {
				return update(T_STIKYNO_TABLE).set(T_STIKYNO_TABLE.CREATE_USER.value(t.getCreateUser()),
						T_STIKYNO_TABLE.CREATE_TIME.value(t.getCreateTime()), T_STIKYNO_TABLE.TILTE.value(t.getTilte()),
						T_STIKYNO_TABLE.CONTENT.value(t.getContent()), T_STIKYNO_TABLE.TYPE.value(t.getType()),
						T_STIKYNO_TABLE.HANDLE_TIME.value(t.getHandleTime()),
						T_STIKYNO_TABLE.SOLVE_TIME.value(t.getSolveTime()),
						T_STIKYNO_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						T_STIKYNO_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						T_STIKYNO_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						T_STIKYNO_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						T_STIKYNO_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				).where(T_STIKYNO_TABLE.ID.eq(t.getId()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TStikyno> tStikyno) {
		if (CollectionUtil.isEmpty(tStikyno)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tStikyno, new DeleteGenerateCallback<TStikyno>() {
			public Delete generate(TStikyno t) {
				return delete(T_STIKYNO_TABLE)
						.where(and(T_STIKYNO_TABLE.ID.eq(t.getId()), T_STIKYNO_TABLE.CREATE_USER.eq(t.getCreateUser()),
								T_STIKYNO_TABLE.CREATE_TIME.eq(t.getCreateTime()),
								T_STIKYNO_TABLE.TILTE.eq(t.getTilte()), T_STIKYNO_TABLE.CONTENT.eq(t.getContent()),
								T_STIKYNO_TABLE.TYPE.eq(t.getType()), T_STIKYNO_TABLE.HANDLE_TIME.eq(t.getHandleTime()),
								T_STIKYNO_TABLE.SOLVE_TIME.eq(t.getSolveTime()),
								T_STIKYNO_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
								T_STIKYNO_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
								T_STIKYNO_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
								T_STIKYNO_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
								T_STIKYNO_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<TStikyno> tStikyno) {
		if (CollectionUtil.isEmpty(tStikyno)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tStikyno, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(T_STIKYNO_TABLE).values(
						T_STIKYNO_TABLE.CREATE_USER.value(new JdbcNamedParameter("createUser")),
						T_STIKYNO_TABLE.CREATE_TIME.value(new JdbcNamedParameter("createTime")),
						T_STIKYNO_TABLE.TILTE.value(new JdbcNamedParameter("tilte")),
						T_STIKYNO_TABLE.CONTENT.value(new JdbcNamedParameter("content")),
						T_STIKYNO_TABLE.TYPE.value(new JdbcNamedParameter("type")),
						T_STIKYNO_TABLE.HANDLE_TIME.value(new JdbcNamedParameter("handleTime")),
						T_STIKYNO_TABLE.SOLVE_TIME.value(new JdbcNamedParameter("solveTime")),
						T_STIKYNO_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
						T_STIKYNO_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
						T_STIKYNO_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
						T_STIKYNO_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
						T_STIKYNO_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TStikyno> tStikyno) {
		if (CollectionUtil.isEmpty(tStikyno)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tStikyno, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(T_STIKYNO_TABLE)
						.set(T_STIKYNO_TABLE.CREATE_USER.value(new JdbcNamedParameter("createUser")),
								T_STIKYNO_TABLE.CREATE_TIME.value(new JdbcNamedParameter("createTime")),
								T_STIKYNO_TABLE.TILTE.value(new JdbcNamedParameter("tilte")),
								T_STIKYNO_TABLE.CONTENT.value(new JdbcNamedParameter("content")),
								T_STIKYNO_TABLE.TYPE.value(new JdbcNamedParameter("type")),
								T_STIKYNO_TABLE.HANDLE_TIME.value(new JdbcNamedParameter("handleTime")),
								T_STIKYNO_TABLE.SOLVE_TIME.value(new JdbcNamedParameter("solveTime")),
								T_STIKYNO_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
								T_STIKYNO_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
								T_STIKYNO_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
								T_STIKYNO_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
								T_STIKYNO_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

						).where(T_STIKYNO_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TStikyno> tStikyno) {
		if (CollectionUtil.isEmpty(tStikyno)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tStikyno, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(T_STIKYNO_TABLE)
						.where(and(T_STIKYNO_TABLE.CREATE_USER.eq(new JdbcNamedParameter("createUser")),
								T_STIKYNO_TABLE.CREATE_TIME.eq(new JdbcNamedParameter("createTime")),
								T_STIKYNO_TABLE.TILTE.eq(new JdbcNamedParameter("tilte")),
								T_STIKYNO_TABLE.CONTENT.eq(new JdbcNamedParameter("content")),
								T_STIKYNO_TABLE.TYPE.eq(new JdbcNamedParameter("type")),
								T_STIKYNO_TABLE.HANDLE_TIME.eq(new JdbcNamedParameter("handleTime")),
								T_STIKYNO_TABLE.SOLVE_TIME.eq(new JdbcNamedParameter("solveTime")),
								T_STIKYNO_TABLE.EXT_FIELD_1.eq(new JdbcNamedParameter("extField1")),
								T_STIKYNO_TABLE.EXT_FIELD_2.eq(new JdbcNamedParameter("extField2")),
								T_STIKYNO_TABLE.EXT_FIELD_3.eq(new JdbcNamedParameter("extField3")),
								T_STIKYNO_TABLE.EXT_FIELD_4.eq(new JdbcNamedParameter("extField4")),
								T_STIKYNO_TABLE.EXT_FIELD_5.eq(new JdbcNamedParameter("extField5"))

				));
			}
		});
	}

	public int[] preparedBatchInsert(List<TStikyno> tStikyno) {
		return preparedBatchInsert(false, tStikyno);
	}

	@Override
	public List<TStikyno> getStikynoList(TStikyno stikyno) {
		if (stikyno == null) {
			stikyno = new TStikyno();
		}
		return getDslTemplate().query(stikyno, new SelectGenerateCallback<TStikyno>() {
			@SuppressWarnings("rawtypes")
			public Select generate(TStikyno t) {
				Select select = selectFrom(T_STIKYNO_TABLE)
						.where(and(T_STIKYNO_TABLE.HANDLE_TIME.gte(t.getHandleTime()),
								T_STIKYNO_TABLE.SOLVE_TIME.lte(t.getSolveTime()),
								T_STIKYNO_TABLE.CREATE_USER.eq(t.getCreateUser()),
								T_STIKYNO_TABLE.EXT_FIELD_1.neq(t.getExtField_1())

				));
				return select;
			}
		});
	}

	@Override
	public List<TStikyno> getIndexStikynoList(TStikyno stikyno,final OrderBy... orderArgs) {
		if (stikyno == null) {
			stikyno = new TStikyno();
		}
		return getDslTemplate().query(stikyno, new SelectGenerateCallback<TStikyno>() {
			@SuppressWarnings("rawtypes")
			public Select generate(TStikyno t) {
				Select select = selectFrom(T_STIKYNO_TABLE)
						.where(T_STIKYNO_TABLE.CREATE_USER.eq(t.getCreateUser()));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

}
