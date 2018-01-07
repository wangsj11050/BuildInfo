
package org.tinygroup.workplan.dao.impl;

import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;
import static org.tinygroup.workplan.dao.inter.constant.TUserTaskTable.T_USER_TASK_TABLE;

import java.io.Serializable;
import java.rmi.server.UID;
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
import org.tinygroup.workplan.dao.inter.TUserTaskDao;
import org.tinygroup.workplan.dao.inter.pojo.TUserTask;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public class TUserTaskDaoImpl extends TinyDslDaoSupport implements TUserTaskDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TUserTask add(TUserTask tUserTask) {
		return getDslTemplate().insertAndReturnKey(tUserTask, new InsertGenerateCallback<TUserTask>() {
			public Insert generate(TUserTask t) {
				Insert insert = insertInto(T_USER_TASK_TABLE).values(T_USER_TASK_TABLE.ID.value(t.getId()),
						T_USER_TASK_TABLE.LINE_ID.value(t.getLineId()),
						T_USER_TASK_TABLE.TASK_TYPE.value(t.getTaskType()),
						T_USER_TASK_TABLE.CREATE_USER.value(t.getCreateUser()),
						T_USER_TASK_TABLE.DUTY_USER.value(t.getDutyUser()),
						T_USER_TASK_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						T_USER_TASK_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						T_USER_TASK_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						T_USER_TASK_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						T_USER_TASK_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
				return insert;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TUserTask tUserTask) {
		if (tUserTask == null || tUserTask.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tUserTask, new UpdateGenerateCallback<TUserTask>() {
			public Update generate(TUserTask t) {
				Update update = update(T_USER_TASK_TABLE)
						.set(T_USER_TASK_TABLE.LINE_ID.value(t.getLineId()),
								T_USER_TASK_TABLE.TASK_TYPE.value(t.getTaskType()),
								T_USER_TASK_TABLE.CREATE_USER.value(t.getCreateUser()),
								T_USER_TASK_TABLE.DUTY_USER.value(t.getDutyUser()),
								T_USER_TASK_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								T_USER_TASK_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								T_USER_TASK_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								T_USER_TASK_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								T_USER_TASK_TABLE.EXT_FIELD_5.value(t.getExtField_5()))
						.where(T_USER_TASK_TABLE.ID.eq(t.getId()));
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
				return delete(T_USER_TASK_TABLE).where(T_USER_TASK_TABLE.ID.eq(pk));
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
				return delete(T_USER_TASK_TABLE).where(T_USER_TASK_TABLE.ID.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TUserTask getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, TUserTask.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(T_USER_TASK_TABLE).where(T_USER_TASK_TABLE.ID.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TUserTask> query(TUserTask tUserTask, final OrderBy... orderArgs) {
		if (tUserTask == null) {
			tUserTask = new TUserTask();
		}
		return getDslTemplate().query(tUserTask, new SelectGenerateCallback<TUserTask>() {
			@SuppressWarnings("rawtypes")
			public Select generate(TUserTask t) {
				Select select = selectFrom(T_USER_TASK_TABLE).where(and(T_USER_TASK_TABLE.ID.eq(t.getId()),
						T_USER_TASK_TABLE.LINE_ID.eq(t.getLineId()), T_USER_TASK_TABLE.TASK_TYPE.eq(t.getTaskType()),
						T_USER_TASK_TABLE.CREATE_USER.eq(t.getCreateUser()),
						T_USER_TASK_TABLE.DUTY_USER.eq(t.getDutyUser()),
						T_USER_TASK_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						T_USER_TASK_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						T_USER_TASK_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						T_USER_TASK_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						T_USER_TASK_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TUserTask> queryPager(int start, int limit, TUserTask tUserTask, final OrderBy... orderArgs) {
		if (tUserTask == null) {
			tUserTask = new TUserTask();
		}
		return getDslTemplate().queryPager(start, limit, tUserTask, false, new SelectGenerateCallback<TUserTask>() {
			public Select generate(TUserTask t) {
				Select select = Select.selectFrom(T_USER_TASK_TABLE)
						.where(and(T_USER_TASK_TABLE.ID.eq(t.getId()), T_USER_TASK_TABLE.LINE_ID.eq(t.getLineId()),
								T_USER_TASK_TABLE.TASK_TYPE.eq(t.getTaskType()),
								T_USER_TASK_TABLE.CREATE_USER.eq(t.getCreateUser()),
								T_USER_TASK_TABLE.DUTY_USER.eq(t.getDutyUser()),
								T_USER_TASK_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
								T_USER_TASK_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
								T_USER_TASK_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
								T_USER_TASK_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
								T_USER_TASK_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<TUserTask> tUserTask) {
		if (CollectionUtil.isEmpty(tUserTask)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tUserTask, new InsertGenerateCallback<TUserTask>() {

			public Insert generate(TUserTask t) {
				return insertInto(T_USER_TASK_TABLE).values(T_USER_TASK_TABLE.ID.value(t.getId()),
						T_USER_TASK_TABLE.LINE_ID.value(t.getLineId()),
						T_USER_TASK_TABLE.TASK_TYPE.value(t.getTaskType()),
						T_USER_TASK_TABLE.CREATE_USER.value(t.getCreateUser()),
						T_USER_TASK_TABLE.DUTY_USER.value(t.getDutyUser()),
						T_USER_TASK_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						T_USER_TASK_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						T_USER_TASK_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						T_USER_TASK_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						T_USER_TASK_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TUserTask> tUserTasks) {
		return batchInsert(true, tUserTasks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TUserTask> tUserTask) {
		if (CollectionUtil.isEmpty(tUserTask)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tUserTask, new UpdateGenerateCallback<TUserTask>() {
			public Update generate(TUserTask t) {
				return update(T_USER_TASK_TABLE).set(T_USER_TASK_TABLE.LINE_ID.value(t.getLineId()),
						T_USER_TASK_TABLE.TASK_TYPE.value(t.getTaskType()),
						T_USER_TASK_TABLE.CREATE_USER.value(t.getCreateUser()),
						T_USER_TASK_TABLE.DUTY_USER.value(t.getDutyUser()),
						T_USER_TASK_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						T_USER_TASK_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						T_USER_TASK_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						T_USER_TASK_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						T_USER_TASK_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				).where(T_USER_TASK_TABLE.ID.eq(t.getId()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TUserTask> tUserTask) {
		if (CollectionUtil.isEmpty(tUserTask)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tUserTask, new DeleteGenerateCallback<TUserTask>() {
			public Delete generate(TUserTask t) {
				return delete(T_USER_TASK_TABLE).where(and(T_USER_TASK_TABLE.ID.eq(t.getId()),
						T_USER_TASK_TABLE.LINE_ID.eq(t.getLineId()), T_USER_TASK_TABLE.TASK_TYPE.eq(t.getTaskType()),
						T_USER_TASK_TABLE.CREATE_USER.eq(t.getCreateUser()),
						T_USER_TASK_TABLE.DUTY_USER.eq(t.getDutyUser()),
						T_USER_TASK_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						T_USER_TASK_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						T_USER_TASK_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						T_USER_TASK_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						T_USER_TASK_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<TUserTask> tUserTask) {
		if (CollectionUtil.isEmpty(tUserTask)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tUserTask, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(T_USER_TASK_TABLE).values(
						T_USER_TASK_TABLE.LINE_ID.value(new JdbcNamedParameter("lineId")),
						T_USER_TASK_TABLE.TASK_TYPE.value(new JdbcNamedParameter("taskType")),
						T_USER_TASK_TABLE.CREATE_USER.value(new JdbcNamedParameter("createUser")),
						T_USER_TASK_TABLE.DUTY_USER.value(new JdbcNamedParameter("dutyUser")),
						T_USER_TASK_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
						T_USER_TASK_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
						T_USER_TASK_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
						T_USER_TASK_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
						T_USER_TASK_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TUserTask> tUserTask) {
		if (CollectionUtil.isEmpty(tUserTask)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tUserTask, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(T_USER_TASK_TABLE).set(T_USER_TASK_TABLE.LINE_ID.value(new JdbcNamedParameter("lineId")),
						T_USER_TASK_TABLE.TASK_TYPE.value(new JdbcNamedParameter("taskType")),
						T_USER_TASK_TABLE.CREATE_USER.value(new JdbcNamedParameter("createUser")),
						T_USER_TASK_TABLE.DUTY_USER.value(new JdbcNamedParameter("dutyUser")),
						T_USER_TASK_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
						T_USER_TASK_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
						T_USER_TASK_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
						T_USER_TASK_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
						T_USER_TASK_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				).where(T_USER_TASK_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TUserTask> tUserTask) {
		if (CollectionUtil.isEmpty(tUserTask)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tUserTask, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(T_USER_TASK_TABLE)
						.where(and(T_USER_TASK_TABLE.LINE_ID.eq(new JdbcNamedParameter("lineId")),
								T_USER_TASK_TABLE.TASK_TYPE.eq(new JdbcNamedParameter("taskType")),
								T_USER_TASK_TABLE.CREATE_USER.eq(new JdbcNamedParameter("createUser")),
								T_USER_TASK_TABLE.DUTY_USER.eq(new JdbcNamedParameter("dutyUser")),
								T_USER_TASK_TABLE.EXT_FIELD_1.eq(new JdbcNamedParameter("extField1")),
								T_USER_TASK_TABLE.EXT_FIELD_2.eq(new JdbcNamedParameter("extField2")),
								T_USER_TASK_TABLE.EXT_FIELD_3.eq(new JdbcNamedParameter("extField3")),
								T_USER_TASK_TABLE.EXT_FIELD_4.eq(new JdbcNamedParameter("extField4")),
								T_USER_TASK_TABLE.EXT_FIELD_5.eq(new JdbcNamedParameter("extField5"))

				));
			}
		});
	}

	public int[] preparedBatchInsert(List<TUserTask> tUserTask) {
		return preparedBatchInsert(true, tUserTask);
	}

	@Override
	public List<TUserTask> getUserTaskList(TUserTask userTask,final OrderBy... orderArgs) {
		if(userTask == null){
			userTask = new TUserTask();
		}
		
		return getDslTemplate().query(userTask, new SelectGenerateCallback<TUserTask>(){
			@Override
			public Select generate(TUserTask t) {
				Select select = Select.select(T_USER_TASK_TABLE.TASK_TYPE.count().as("taskNum")
						,T_USER_TASK_TABLE.TASK_TYPE).from(T_USER_TASK_TABLE)
						.where(T_USER_TASK_TABLE.DUTY_USER.eq(t.getDutyUser())
								.and(T_USER_TASK_TABLE.EXT_FIELD_1.eq(t.getExtField_1())))
						.groupBy(T_USER_TASK_TABLE.TASK_TYPE);
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}});
	}

}
