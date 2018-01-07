
package org.tinygroup.workplan.dao.impl;

import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;
import static org.tinygroup.workplan.dao.inter.constant.TUserDemandPlannTable.T_USER_DEMAND_PLANN_TABLE;

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
import org.tinygroup.workplan.dao.inter.TUserDemandPlannDao;
import org.tinygroup.workplan.dao.inter.pojo.TUserDemandPlann;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public class TUserDemandPlannDaoImpl extends TinyDslDaoSupport implements TUserDemandPlannDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TUserDemandPlann add(TUserDemandPlann tUserDemandPlann) {
		return getDslTemplate().insertAndReturnKey(tUserDemandPlann, new InsertGenerateCallback<TUserDemandPlann>() {
			public Insert generate(TUserDemandPlann t) {
				Insert insert = insertInto(T_USER_DEMAND_PLANN_TABLE).values(
						T_USER_DEMAND_PLANN_TABLE.ID.value(t.getId()),
						T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_ID.value(t.getSubPlannId()),
						T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_NAME.value(t.getSubPlannName()),
						T_USER_DEMAND_PLANN_TABLE.PLATFORM_TYPE.value(t.getPlatformType()),
						T_USER_DEMAND_PLANN_TABLE.PLANN_NUMBER.value(t.getPlannNumber()),
						T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_USER.value(t.getDevelopmentUser()),
						T_USER_DEMAND_PLANN_TABLE.PLANN_DATE.value(t.getPlannDate()),
						T_USER_DEMAND_PLANN_TABLE.ACTUAL_DATE.value(t.getActualDate()),
						T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_PROCESS.value(t.getDevelopmentProcess()),
						T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_PROBLEM.value(t.getSubPlannProblem()),
						T_USER_DEMAND_PLANN_TABLE.PLANN_STATE.value(t.getPlannState()),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
				return insert;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TUserDemandPlann tUserDemandPlann) {
		if (tUserDemandPlann == null || tUserDemandPlann.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tUserDemandPlann, new UpdateGenerateCallback<TUserDemandPlann>() {
			public Update generate(TUserDemandPlann t) {
				Update update = update(T_USER_DEMAND_PLANN_TABLE)
						.set(T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_ID.value(t.getSubPlannId()),
								T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_NAME.value(t.getSubPlannName()),
								T_USER_DEMAND_PLANN_TABLE.PLATFORM_TYPE.value(t.getPlatformType()),
								T_USER_DEMAND_PLANN_TABLE.PLANN_NUMBER.value(t.getPlannNumber()),
								T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_USER.value(t.getDevelopmentUser()),
								T_USER_DEMAND_PLANN_TABLE.PLANN_DATE.value(t.getPlannDate()),
								T_USER_DEMAND_PLANN_TABLE.ACTUAL_DATE.value(t.getActualDate()),
								T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_PROCESS.value(t.getDevelopmentProcess()),
								T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_PROBLEM.value(t.getSubPlannProblem()),
								T_USER_DEMAND_PLANN_TABLE.PLANN_STATE.value(t.getPlannState()),
								T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_5.value(t.getExtField_5()))
						.where(T_USER_DEMAND_PLANN_TABLE.ID.eq(t.getId()));
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
				return delete(T_USER_DEMAND_PLANN_TABLE).where(T_USER_DEMAND_PLANN_TABLE.ID.eq(pk));
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
				return delete(T_USER_DEMAND_PLANN_TABLE).where(T_USER_DEMAND_PLANN_TABLE.ID.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TUserDemandPlann getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, TUserDemandPlann.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(T_USER_DEMAND_PLANN_TABLE).where(T_USER_DEMAND_PLANN_TABLE.ID.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TUserDemandPlann> query(TUserDemandPlann tUserDemandPlann, final OrderBy... orderArgs) {
		if (tUserDemandPlann == null) {
			tUserDemandPlann = new TUserDemandPlann();
		}
		return getDslTemplate().query(tUserDemandPlann, new SelectGenerateCallback<TUserDemandPlann>() {
			@SuppressWarnings("rawtypes")
			public Select generate(TUserDemandPlann t) {
				Select select = selectFrom(T_USER_DEMAND_PLANN_TABLE)
						.where(and(T_USER_DEMAND_PLANN_TABLE.ID.eq(t.getId()),
								T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_ID.eq(t.getSubPlannId()),
								T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_NAME.eq(t.getSubPlannName()),
								T_USER_DEMAND_PLANN_TABLE.PLATFORM_TYPE.eq(t.getPlatformType()),
								T_USER_DEMAND_PLANN_TABLE.PLANN_NUMBER.eq(t.getPlannNumber()),
								T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_USER.eq(t.getDevelopmentUser()),
								T_USER_DEMAND_PLANN_TABLE.PLANN_DATE.eq(t.getPlannDate()),
								T_USER_DEMAND_PLANN_TABLE.ACTUAL_DATE.eq(t.getActualDate()),
								T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_PROCESS.eq(t.getDevelopmentProcess()),
								T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_PROBLEM.eq(t.getSubPlannProblem()),
								T_USER_DEMAND_PLANN_TABLE.PLANN_STATE.eq(t.getPlannState()),
								T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
								T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
								T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
								T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
								T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TUserDemandPlann> queryPager(int start, int limit, TUserDemandPlann tUserDemandPlann,
			final OrderBy... orderArgs) {
		if (tUserDemandPlann == null) {
			tUserDemandPlann = new TUserDemandPlann();
		}
		return getDslTemplate().queryPager(start, limit, tUserDemandPlann, false,
				new SelectGenerateCallback<TUserDemandPlann>() {
					public Select generate(TUserDemandPlann t) {
						Select select = Select.selectFrom(T_USER_DEMAND_PLANN_TABLE)
								.where(and(T_USER_DEMAND_PLANN_TABLE.ID.eq(t.getId()),
										T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_ID.eq(t.getSubPlannId()),
										T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_NAME.eq(t.getSubPlannName()),
										T_USER_DEMAND_PLANN_TABLE.PLATFORM_TYPE.eq(t.getPlatformType()),
										T_USER_DEMAND_PLANN_TABLE.PLANN_NUMBER.eq(t.getPlannNumber()),
										T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_USER.eq(t.getDevelopmentUser()),
										T_USER_DEMAND_PLANN_TABLE.PLANN_DATE.eq(t.getPlannDate()),
										T_USER_DEMAND_PLANN_TABLE.ACTUAL_DATE.eq(t.getActualDate()),
										T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_PROCESS.eq(t.getDevelopmentProcess()),
										T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_PROBLEM.eq(t.getSubPlannProblem()),
										T_USER_DEMAND_PLANN_TABLE.PLANN_STATE.eq(t.getPlannState()),
										T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
										T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
										T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
										T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
										T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
						return TinyDSLUtil.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<TUserDemandPlann> tUserDemandPlann) {
		if (CollectionUtil.isEmpty(tUserDemandPlann)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tUserDemandPlann,
				new InsertGenerateCallback<TUserDemandPlann>() {

					public Insert generate(TUserDemandPlann t) {
						return insertInto(T_USER_DEMAND_PLANN_TABLE).values(
								T_USER_DEMAND_PLANN_TABLE.ID.value(t.getId()),
								T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_ID.value(t.getSubPlannId()),
								T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_NAME.value(t.getSubPlannName()),
								T_USER_DEMAND_PLANN_TABLE.PLATFORM_TYPE.value(t.getPlatformType()),
								T_USER_DEMAND_PLANN_TABLE.PLANN_NUMBER.value(t.getPlannNumber()),
								T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_USER.value(t.getDevelopmentUser()),
								T_USER_DEMAND_PLANN_TABLE.PLANN_DATE.value(t.getPlannDate()),
								T_USER_DEMAND_PLANN_TABLE.ACTUAL_DATE.value(t.getActualDate()),
								T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_PROCESS.value(t.getDevelopmentProcess()),
								T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_PROBLEM.value(t.getSubPlannProblem()),
								T_USER_DEMAND_PLANN_TABLE.PLANN_STATE.value(t.getPlannState()),
								T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TUserDemandPlann> tUserDemandPlanns) {
		return batchInsert(false, tUserDemandPlanns);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TUserDemandPlann> tUserDemandPlann) {
		if (CollectionUtil.isEmpty(tUserDemandPlann)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tUserDemandPlann, new UpdateGenerateCallback<TUserDemandPlann>() {
			public Update generate(TUserDemandPlann t) {
				return update(T_USER_DEMAND_PLANN_TABLE)
						.set(T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_ID.value(t.getSubPlannId()),
								T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_NAME.value(t.getSubPlannName()),
								T_USER_DEMAND_PLANN_TABLE.PLATFORM_TYPE.value(t.getPlatformType()),
								T_USER_DEMAND_PLANN_TABLE.PLANN_NUMBER.value(t.getPlannNumber()),
								T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_USER.value(t.getDevelopmentUser()),
								T_USER_DEMAND_PLANN_TABLE.PLANN_DATE.value(t.getPlannDate()),
								T_USER_DEMAND_PLANN_TABLE.ACTUAL_DATE.value(t.getActualDate()),
								T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_PROCESS.value(t.getDevelopmentProcess()),
								T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_PROBLEM.value(t.getSubPlannProblem()),
								T_USER_DEMAND_PLANN_TABLE.PLANN_STATE.value(t.getPlannState()),
								T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_5.value(t.getExtField_5())

						).where(T_USER_DEMAND_PLANN_TABLE.ID.eq(t.getId()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TUserDemandPlann> tUserDemandPlann) {
		if (CollectionUtil.isEmpty(tUserDemandPlann)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tUserDemandPlann, new DeleteGenerateCallback<TUserDemandPlann>() {
			public Delete generate(TUserDemandPlann t) {
				return delete(T_USER_DEMAND_PLANN_TABLE).where(and(T_USER_DEMAND_PLANN_TABLE.ID.eq(t.getId()),
						T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_ID.eq(t.getSubPlannId()),
						T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_NAME.eq(t.getSubPlannName()),
						T_USER_DEMAND_PLANN_TABLE.PLATFORM_TYPE.eq(t.getPlatformType()),
						T_USER_DEMAND_PLANN_TABLE.PLANN_NUMBER.eq(t.getPlannNumber()),
						T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_USER.eq(t.getDevelopmentUser()),
						T_USER_DEMAND_PLANN_TABLE.PLANN_DATE.eq(t.getPlannDate()),
						T_USER_DEMAND_PLANN_TABLE.ACTUAL_DATE.eq(t.getActualDate()),
						T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_PROCESS.eq(t.getDevelopmentProcess()),
						T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_PROBLEM.eq(t.getSubPlannProblem()),
						T_USER_DEMAND_PLANN_TABLE.PLANN_STATE.eq(t.getPlannState()),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<TUserDemandPlann> tUserDemandPlann) {
		if (CollectionUtil.isEmpty(tUserDemandPlann)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tUserDemandPlann, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(T_USER_DEMAND_PLANN_TABLE).values(
						T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_ID.value(new JdbcNamedParameter("subPlannId")),
						T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_NAME.value(new JdbcNamedParameter("subPlannName")),
						T_USER_DEMAND_PLANN_TABLE.PLATFORM_TYPE.value(new JdbcNamedParameter("platformType")),
						T_USER_DEMAND_PLANN_TABLE.PLANN_NUMBER.value(new JdbcNamedParameter("plannNumber")),
						T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_USER.value(new JdbcNamedParameter("developmentUser")),
						T_USER_DEMAND_PLANN_TABLE.PLANN_DATE.value(new JdbcNamedParameter("plannDate")),
						T_USER_DEMAND_PLANN_TABLE.ACTUAL_DATE.value(new JdbcNamedParameter("actualDate")),
						T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_PROCESS
								.value(new JdbcNamedParameter("developmentProcess")),
						T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_PROBLEM.value(new JdbcNamedParameter("subPlannProblem")),
						T_USER_DEMAND_PLANN_TABLE.PLANN_STATE.value(new JdbcNamedParameter("plannState")),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TUserDemandPlann> tUserDemandPlann) {
		if (CollectionUtil.isEmpty(tUserDemandPlann)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tUserDemandPlann, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(T_USER_DEMAND_PLANN_TABLE).set(
						T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_ID.value(new JdbcNamedParameter("subPlannId")),
						T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_NAME.value(new JdbcNamedParameter("subPlannName")),
						T_USER_DEMAND_PLANN_TABLE.PLATFORM_TYPE.value(new JdbcNamedParameter("platformType")),
						T_USER_DEMAND_PLANN_TABLE.PLANN_NUMBER.value(new JdbcNamedParameter("plannNumber")),
						T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_USER.value(new JdbcNamedParameter("developmentUser")),
						T_USER_DEMAND_PLANN_TABLE.PLANN_DATE.value(new JdbcNamedParameter("plannDate")),
						T_USER_DEMAND_PLANN_TABLE.ACTUAL_DATE.value(new JdbcNamedParameter("actualDate")),
						T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_PROCESS
								.value(new JdbcNamedParameter("developmentProcess")),
						T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_PROBLEM.value(new JdbcNamedParameter("subPlannProblem")),
						T_USER_DEMAND_PLANN_TABLE.PLANN_STATE.value(new JdbcNamedParameter("plannState")),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				).where(T_USER_DEMAND_PLANN_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TUserDemandPlann> tUserDemandPlann) {
		if (CollectionUtil.isEmpty(tUserDemandPlann)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tUserDemandPlann, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(T_USER_DEMAND_PLANN_TABLE).where(and(
						T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_ID.eq(new JdbcNamedParameter("subPlannId")),
						T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_NAME.eq(new JdbcNamedParameter("subPlannName")),
						T_USER_DEMAND_PLANN_TABLE.PLATFORM_TYPE.eq(new JdbcNamedParameter("platformType")),
						T_USER_DEMAND_PLANN_TABLE.PLANN_NUMBER.eq(new JdbcNamedParameter("plannNumber")),
						T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_USER.eq(new JdbcNamedParameter("developmentUser")),
						T_USER_DEMAND_PLANN_TABLE.PLANN_DATE.eq(new JdbcNamedParameter("plannDate")),
						T_USER_DEMAND_PLANN_TABLE.ACTUAL_DATE.eq(new JdbcNamedParameter("actualDate")),
						T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_PROCESS.eq(new JdbcNamedParameter("developmentProcess")),
						T_USER_DEMAND_PLANN_TABLE.SUB_PLANN_PROBLEM.eq(new JdbcNamedParameter("subPlannProblem")),
						T_USER_DEMAND_PLANN_TABLE.PLANN_STATE.eq(new JdbcNamedParameter("plannState")),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_1.eq(new JdbcNamedParameter("extField1")),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_2.eq(new JdbcNamedParameter("extField2")),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_3.eq(new JdbcNamedParameter("extField3")),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_4.eq(new JdbcNamedParameter("extField4")),
						T_USER_DEMAND_PLANN_TABLE.EXT_FIELD_5.eq(new JdbcNamedParameter("extField5"))

				));
			}
		});
	}

	public int[] preparedBatchInsert(List<TUserDemandPlann> tUserDemandPlann) {
		return preparedBatchInsert(false, tUserDemandPlann);
	}

	@Override
	public List<TUserDemandPlann> getUserDemandChart(TUserDemandPlann userDemandPlann, final OrderBy... orderArgs) {
		if(userDemandPlann == null){
			userDemandPlann = new TUserDemandPlann();
		}
		return getDslTemplate().query(userDemandPlann, new SelectGenerateCallback<TUserDemandPlann>(){
			@Override
			public Select generate(TUserDemandPlann t) {
				Select select = Select.select(T_USER_DEMAND_PLANN_TABLE.PLANN_STATE.count().as("plannNum")
						,T_USER_DEMAND_PLANN_TABLE.PLANN_STATE).from(T_USER_DEMAND_PLANN_TABLE)
						.where(T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_USER.eq(t.getDevelopmentUser()))
						.groupBy(T_USER_DEMAND_PLANN_TABLE.PLANN_STATE);
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}});
	}

	@Override
	public List<TUserDemandPlann> getUserDemanndPlannList(TUserDemandPlann userDemandPlann) {
		if(userDemandPlann == null){
			userDemandPlann = new TUserDemandPlann();
		}
		return getDslTemplate().query(userDemandPlann, new SelectGenerateCallback<TUserDemandPlann>(){
			@Override
			public Select generate(TUserDemandPlann t) {
				return Select.selectFrom(T_USER_DEMAND_PLANN_TABLE)
						.where(T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_USER.eq(t.getDevelopmentUser()));
			}});
	}

	@Override
	public List<TUserDemandPlann> getFinishUserDemandPlannList(TUserDemandPlann userDemandPlann) {
		if(userDemandPlann == null){
			userDemandPlann = new TUserDemandPlann();
		}
		return getDslTemplate().query(userDemandPlann, new SelectGenerateCallback<TUserDemandPlann>(){
			@Override
			public Select generate(TUserDemandPlann t) {
				return Select.selectFrom(T_USER_DEMAND_PLANN_TABLE)
						.where(and(T_USER_DEMAND_PLANN_TABLE.DEVELOPMENT_USER.eq(t.getDevelopmentUser()),
						T_USER_DEMAND_PLANN_TABLE.PLANN_STATE.eq(t.getPlannState())));
			}});
	}

}
