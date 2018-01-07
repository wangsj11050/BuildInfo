
package org.tinygroup.workplan.dao.impl;

import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;
import static org.tinygroup.workplan.dao.inter.constant.TDemandPlannTable.T_DEMAND_PLANN_TABLE;

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
import org.tinygroup.workplan.dao.inter.TDemandPlannDao;
import org.tinygroup.workplan.dao.inter.pojo.TDemandPlann;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public class TDemandPlannDaoImpl extends TinyDslDaoSupport implements TDemandPlannDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TDemandPlann add(TDemandPlann tDemandPlann) {
		return getDslTemplate().insertAndReturnKey(tDemandPlann, new InsertGenerateCallback<TDemandPlann>() {
			public Insert generate(TDemandPlann t) {
				Insert insert = insertInto(T_DEMAND_PLANN_TABLE).values(T_DEMAND_PLANN_TABLE.ID.value(t.getId()),
						T_DEMAND_PLANN_TABLE.PLATFORM_TYPE.value(t.getPlatformType()),
						T_DEMAND_PLANN_TABLE.PLANN_NUMBER.value(t.getPlannNumber()),
						T_DEMAND_PLANN_TABLE.PLANN_NAME.value(t.getPlannName()),
						T_DEMAND_PLANN_TABLE.RELEVANCE_SYSTEM.value(t.getRelevanceSystem()),
						T_DEMAND_PLANN_TABLE.IMPLEMENT_MODEL.value(t.getImplementModel()),
						T_DEMAND_PLANN_TABLE.TECHNICAL_MANAGER.value(t.getTechnicalManager()),
						T_DEMAND_PLANN_TABLE.DEVELOPERS.value(t.getDevelopers()),
						T_DEMAND_PLANN_TABLE.PLANN_POINT.value(t.getPlannPoint()),
						T_DEMAND_PLANN_TABLE.PLANN_DATE.value(t.getPlannDate()),
						T_DEMAND_PLANN_TABLE.ACTUAL_DATE.value(t.getActualDate()),
						T_DEMAND_PLANN_TABLE.CQ_STATE.value(t.getCqState()),
						T_DEMAND_PLANN_TABLE.CREATE_USER.value(t.getCreateUser()),
						T_DEMAND_PLANN_TABLE.CREATE_TIME.value(t.getCreateTime()),
						T_DEMAND_PLANN_TABLE.LAST_UPDATE_USER.value(t.getLastUpdateUser()),
						T_DEMAND_PLANN_TABLE.LAST_UPDATE_TIME.value(t.getLastUpdateTime()),
						T_DEMAND_PLANN_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						T_DEMAND_PLANN_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						T_DEMAND_PLANN_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						T_DEMAND_PLANN_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						T_DEMAND_PLANN_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
				return insert;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TDemandPlann tDemandPlann) {
		if (tDemandPlann == null || tDemandPlann.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tDemandPlann, new UpdateGenerateCallback<TDemandPlann>() {
			public Update generate(TDemandPlann t) {
				Update update = update(T_DEMAND_PLANN_TABLE)
						.set(T_DEMAND_PLANN_TABLE.PLATFORM_TYPE.value(t.getPlatformType()),
								T_DEMAND_PLANN_TABLE.PLANN_NUMBER.value(t.getPlannNumber()),
								T_DEMAND_PLANN_TABLE.PLANN_NAME.value(t.getPlannName()),
								T_DEMAND_PLANN_TABLE.RELEVANCE_SYSTEM.value(t.getRelevanceSystem()),
								T_DEMAND_PLANN_TABLE.IMPLEMENT_MODEL.value(t.getImplementModel()),
								T_DEMAND_PLANN_TABLE.TECHNICAL_MANAGER.value(t.getTechnicalManager()),
								T_DEMAND_PLANN_TABLE.DEVELOPERS.value(t.getDevelopers()),
								T_DEMAND_PLANN_TABLE.PLANN_POINT.value(t.getPlannPoint()),
								T_DEMAND_PLANN_TABLE.PLANN_DATE.value(t.getPlannDate()),
								T_DEMAND_PLANN_TABLE.ACTUAL_DATE.value(t.getActualDate()),
								T_DEMAND_PLANN_TABLE.CQ_STATE.value(t.getCqState()),
								T_DEMAND_PLANN_TABLE.CREATE_USER.value(t.getCreateUser()),
								T_DEMAND_PLANN_TABLE.CREATE_TIME.value(t.getCreateTime()),
								T_DEMAND_PLANN_TABLE.LAST_UPDATE_USER.value(t.getLastUpdateUser()),
								T_DEMAND_PLANN_TABLE.LAST_UPDATE_TIME.value(t.getLastUpdateTime()),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_5.value(t.getExtField_5()))
						.where(T_DEMAND_PLANN_TABLE.ID.eq(t.getId()));
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
				return delete(T_DEMAND_PLANN_TABLE).where(T_DEMAND_PLANN_TABLE.ID.eq(pk));
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
				return delete(T_DEMAND_PLANN_TABLE).where(T_DEMAND_PLANN_TABLE.ID.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TDemandPlann getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, TDemandPlann.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(T_DEMAND_PLANN_TABLE).where(T_DEMAND_PLANN_TABLE.ID.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TDemandPlann> query(TDemandPlann tDemandPlann, final OrderBy... orderArgs) {
		if (tDemandPlann == null) {
			tDemandPlann = new TDemandPlann();
		}
		return getDslTemplate().query(tDemandPlann, new SelectGenerateCallback<TDemandPlann>() {
			@SuppressWarnings("rawtypes")
			public Select generate(TDemandPlann t) {
				Select select = selectFrom(T_DEMAND_PLANN_TABLE).where(and(T_DEMAND_PLANN_TABLE.ID.eq(t.getId()),
						T_DEMAND_PLANN_TABLE.PLATFORM_TYPE.eq(t.getPlatformType()),
						T_DEMAND_PLANN_TABLE.PLANN_NUMBER.eq(t.getPlannNumber()),
						T_DEMAND_PLANN_TABLE.PLANN_NAME.eq(t.getPlannName()),
						T_DEMAND_PLANN_TABLE.RELEVANCE_SYSTEM.eq(t.getRelevanceSystem()),
						T_DEMAND_PLANN_TABLE.IMPLEMENT_MODEL.eq(t.getImplementModel()),
						T_DEMAND_PLANN_TABLE.TECHNICAL_MANAGER.eq(t.getTechnicalManager()),
						T_DEMAND_PLANN_TABLE.DEVELOPERS.eq(t.getDevelopers()),
						T_DEMAND_PLANN_TABLE.PLANN_POINT.eq(t.getPlannPoint()),
						T_DEMAND_PLANN_TABLE.PLANN_DATE.eq(t.getPlannDate()),
						T_DEMAND_PLANN_TABLE.ACTUAL_DATE.eq(t.getActualDate()),
						T_DEMAND_PLANN_TABLE.CQ_STATE.eq(t.getCqState()),
						T_DEMAND_PLANN_TABLE.CREATE_USER.eq(t.getCreateUser()),
						T_DEMAND_PLANN_TABLE.CREATE_TIME.eq(t.getCreateTime()),
						T_DEMAND_PLANN_TABLE.LAST_UPDATE_USER.eq(t.getLastUpdateUser()),
						T_DEMAND_PLANN_TABLE.LAST_UPDATE_TIME.eq(t.getLastUpdateTime()),
						T_DEMAND_PLANN_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						T_DEMAND_PLANN_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						T_DEMAND_PLANN_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						T_DEMAND_PLANN_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						T_DEMAND_PLANN_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TDemandPlann> queryPager(int start, int limit, TDemandPlann tDemandPlann, final OrderBy... orderArgs) {
		if (tDemandPlann == null) {
			tDemandPlann = new TDemandPlann();
		}
		return getDslTemplate().queryPager(start, limit, tDemandPlann, false,
				new SelectGenerateCallback<TDemandPlann>() {
					public Select generate(TDemandPlann t) {
						Select select = Select.selectFrom(T_DEMAND_PLANN_TABLE)
								.where(and(T_DEMAND_PLANN_TABLE.ID.eq(t.getId()),
										T_DEMAND_PLANN_TABLE.PLATFORM_TYPE.eq(t.getPlatformType()),
										T_DEMAND_PLANN_TABLE.PLANN_NUMBER.eq(t.getPlannNumber()),
										T_DEMAND_PLANN_TABLE.PLANN_NAME.eq(t.getPlannName()),
										T_DEMAND_PLANN_TABLE.RELEVANCE_SYSTEM.eq(t.getRelevanceSystem()),
										T_DEMAND_PLANN_TABLE.IMPLEMENT_MODEL.eq(t.getImplementModel()),
										T_DEMAND_PLANN_TABLE.TECHNICAL_MANAGER.eq(t.getTechnicalManager()),
										T_DEMAND_PLANN_TABLE.DEVELOPERS.eq(t.getDevelopers()),
										T_DEMAND_PLANN_TABLE.PLANN_POINT.eq(t.getPlannPoint()),
										T_DEMAND_PLANN_TABLE.PLANN_DATE.eq(t.getPlannDate()),
										T_DEMAND_PLANN_TABLE.ACTUAL_DATE.eq(t.getActualDate()),
										T_DEMAND_PLANN_TABLE.CQ_STATE.eq(t.getCqState()),
										T_DEMAND_PLANN_TABLE.CREATE_USER.eq(t.getCreateUser()),
										T_DEMAND_PLANN_TABLE.CREATE_TIME.eq(t.getCreateTime()),
										T_DEMAND_PLANN_TABLE.LAST_UPDATE_USER.eq(t.getLastUpdateUser()),
										T_DEMAND_PLANN_TABLE.LAST_UPDATE_TIME.eq(t.getLastUpdateTime()),
										T_DEMAND_PLANN_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
										T_DEMAND_PLANN_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
										T_DEMAND_PLANN_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
										T_DEMAND_PLANN_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
										T_DEMAND_PLANN_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
						return TinyDSLUtil.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<TDemandPlann> tDemandPlann) {
		if (CollectionUtil.isEmpty(tDemandPlann)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tDemandPlann,
				new InsertGenerateCallback<TDemandPlann>() {

					public Insert generate(TDemandPlann t) {
						return insertInto(T_DEMAND_PLANN_TABLE).values(T_DEMAND_PLANN_TABLE.ID.value(t.getId()),
								T_DEMAND_PLANN_TABLE.PLATFORM_TYPE.value(t.getPlatformType()),
								T_DEMAND_PLANN_TABLE.PLANN_NUMBER.value(t.getPlannNumber()),
								T_DEMAND_PLANN_TABLE.PLANN_NAME.value(t.getPlannName()),
								T_DEMAND_PLANN_TABLE.RELEVANCE_SYSTEM.value(t.getRelevanceSystem()),
								T_DEMAND_PLANN_TABLE.IMPLEMENT_MODEL.value(t.getImplementModel()),
								T_DEMAND_PLANN_TABLE.TECHNICAL_MANAGER.value(t.getTechnicalManager()),
								T_DEMAND_PLANN_TABLE.DEVELOPERS.value(t.getDevelopers()),
								T_DEMAND_PLANN_TABLE.PLANN_POINT.value(t.getPlannPoint()),
								T_DEMAND_PLANN_TABLE.PLANN_DATE.value(t.getPlannDate()),
								T_DEMAND_PLANN_TABLE.ACTUAL_DATE.value(t.getActualDate()),
								T_DEMAND_PLANN_TABLE.CQ_STATE.value(t.getCqState()),
								T_DEMAND_PLANN_TABLE.CREATE_USER.value(t.getCreateUser()),
								T_DEMAND_PLANN_TABLE.CREATE_TIME.value(t.getCreateTime()),
								T_DEMAND_PLANN_TABLE.LAST_UPDATE_USER.value(t.getLastUpdateUser()),
								T_DEMAND_PLANN_TABLE.LAST_UPDATE_TIME.value(t.getLastUpdateTime()),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TDemandPlann> tDemandPlanns) {
		return batchInsert(false, tDemandPlanns);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TDemandPlann> tDemandPlann) {
		if (CollectionUtil.isEmpty(tDemandPlann)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tDemandPlann, new UpdateGenerateCallback<TDemandPlann>() {
			public Update generate(TDemandPlann t) {
				return update(T_DEMAND_PLANN_TABLE).set(T_DEMAND_PLANN_TABLE.PLATFORM_TYPE.value(t.getPlatformType()),
						T_DEMAND_PLANN_TABLE.PLANN_NUMBER.value(t.getPlannNumber()),
						T_DEMAND_PLANN_TABLE.PLANN_NAME.value(t.getPlannName()),
						T_DEMAND_PLANN_TABLE.RELEVANCE_SYSTEM.value(t.getRelevanceSystem()),
						T_DEMAND_PLANN_TABLE.IMPLEMENT_MODEL.value(t.getImplementModel()),
						T_DEMAND_PLANN_TABLE.TECHNICAL_MANAGER.value(t.getTechnicalManager()),
						T_DEMAND_PLANN_TABLE.DEVELOPERS.value(t.getDevelopers()),
						T_DEMAND_PLANN_TABLE.PLANN_POINT.value(t.getPlannPoint()),
						T_DEMAND_PLANN_TABLE.PLANN_DATE.value(t.getPlannDate()),
						T_DEMAND_PLANN_TABLE.ACTUAL_DATE.value(t.getActualDate()),
						T_DEMAND_PLANN_TABLE.CQ_STATE.value(t.getCqState()),
						T_DEMAND_PLANN_TABLE.CREATE_USER.value(t.getCreateUser()),
						T_DEMAND_PLANN_TABLE.CREATE_TIME.value(t.getCreateTime()),
						T_DEMAND_PLANN_TABLE.LAST_UPDATE_USER.value(t.getLastUpdateUser()),
						T_DEMAND_PLANN_TABLE.LAST_UPDATE_TIME.value(t.getLastUpdateTime()),
						T_DEMAND_PLANN_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						T_DEMAND_PLANN_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						T_DEMAND_PLANN_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						T_DEMAND_PLANN_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						T_DEMAND_PLANN_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				).where(T_DEMAND_PLANN_TABLE.ID.eq(t.getId()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TDemandPlann> tDemandPlann) {
		if (CollectionUtil.isEmpty(tDemandPlann)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tDemandPlann, new DeleteGenerateCallback<TDemandPlann>() {
			public Delete generate(TDemandPlann t) {
				return delete(T_DEMAND_PLANN_TABLE).where(and(T_DEMAND_PLANN_TABLE.ID.eq(t.getId()),
						T_DEMAND_PLANN_TABLE.PLATFORM_TYPE.eq(t.getPlatformType()),
						T_DEMAND_PLANN_TABLE.PLANN_NUMBER.eq(t.getPlannNumber()),
						T_DEMAND_PLANN_TABLE.PLANN_NAME.eq(t.getPlannName()),
						T_DEMAND_PLANN_TABLE.RELEVANCE_SYSTEM.eq(t.getRelevanceSystem()),
						T_DEMAND_PLANN_TABLE.IMPLEMENT_MODEL.eq(t.getImplementModel()),
						T_DEMAND_PLANN_TABLE.TECHNICAL_MANAGER.eq(t.getTechnicalManager()),
						T_DEMAND_PLANN_TABLE.DEVELOPERS.eq(t.getDevelopers()),
						T_DEMAND_PLANN_TABLE.PLANN_POINT.eq(t.getPlannPoint()),
						T_DEMAND_PLANN_TABLE.PLANN_DATE.eq(t.getPlannDate()),
						T_DEMAND_PLANN_TABLE.ACTUAL_DATE.eq(t.getActualDate()),
						T_DEMAND_PLANN_TABLE.CQ_STATE.eq(t.getCqState()),
						T_DEMAND_PLANN_TABLE.CREATE_USER.eq(t.getCreateUser()),
						T_DEMAND_PLANN_TABLE.CREATE_TIME.eq(t.getCreateTime()),
						T_DEMAND_PLANN_TABLE.LAST_UPDATE_USER.eq(t.getLastUpdateUser()),
						T_DEMAND_PLANN_TABLE.LAST_UPDATE_TIME.eq(t.getLastUpdateTime()),
						T_DEMAND_PLANN_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						T_DEMAND_PLANN_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						T_DEMAND_PLANN_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						T_DEMAND_PLANN_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						T_DEMAND_PLANN_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<TDemandPlann> tDemandPlann) {
		if (CollectionUtil.isEmpty(tDemandPlann)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tDemandPlann, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(T_DEMAND_PLANN_TABLE)
						.values(T_DEMAND_PLANN_TABLE.PLATFORM_TYPE.value(new JdbcNamedParameter("platformType")),
								T_DEMAND_PLANN_TABLE.PLANN_NUMBER.value(new JdbcNamedParameter("plannNumber")),
								T_DEMAND_PLANN_TABLE.PLANN_NAME.value(new JdbcNamedParameter("plannName")),
								T_DEMAND_PLANN_TABLE.RELEVANCE_SYSTEM.value(new JdbcNamedParameter("relevanceSystem")),
								T_DEMAND_PLANN_TABLE.IMPLEMENT_MODEL.value(new JdbcNamedParameter("implementModel")),
								T_DEMAND_PLANN_TABLE.TECHNICAL_MANAGER
										.value(new JdbcNamedParameter("technicalManager")),
								T_DEMAND_PLANN_TABLE.DEVELOPERS.value(new JdbcNamedParameter("developers")),
								T_DEMAND_PLANN_TABLE.PLANN_POINT.value(new JdbcNamedParameter("plannPoint")),
								T_DEMAND_PLANN_TABLE.PLANN_DATE.value(new JdbcNamedParameter("plannDate")),
								T_DEMAND_PLANN_TABLE.ACTUAL_DATE.value(new JdbcNamedParameter("actualDate")),
								T_DEMAND_PLANN_TABLE.CQ_STATE.value(new JdbcNamedParameter("cqState")),
								T_DEMAND_PLANN_TABLE.CREATE_USER.value(new JdbcNamedParameter("createUser")),
								T_DEMAND_PLANN_TABLE.CREATE_TIME.value(new JdbcNamedParameter("createTime")),
								T_DEMAND_PLANN_TABLE.LAST_UPDATE_USER.value(new JdbcNamedParameter("lastUpdateUser")),
								T_DEMAND_PLANN_TABLE.LAST_UPDATE_TIME.value(new JdbcNamedParameter("lastUpdateTime")),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TDemandPlann> tDemandPlann) {
		if (CollectionUtil.isEmpty(tDemandPlann)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tDemandPlann, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(T_DEMAND_PLANN_TABLE)
						.set(T_DEMAND_PLANN_TABLE.PLATFORM_TYPE.value(new JdbcNamedParameter("platformType")),
								T_DEMAND_PLANN_TABLE.PLANN_NUMBER.value(new JdbcNamedParameter("plannNumber")),
								T_DEMAND_PLANN_TABLE.PLANN_NAME.value(new JdbcNamedParameter("plannName")),
								T_DEMAND_PLANN_TABLE.RELEVANCE_SYSTEM.value(new JdbcNamedParameter("relevanceSystem")),
								T_DEMAND_PLANN_TABLE.IMPLEMENT_MODEL.value(new JdbcNamedParameter("implementModel")),
								T_DEMAND_PLANN_TABLE.TECHNICAL_MANAGER
										.value(new JdbcNamedParameter("technicalManager")),
								T_DEMAND_PLANN_TABLE.DEVELOPERS.value(new JdbcNamedParameter("developers")),
								T_DEMAND_PLANN_TABLE.PLANN_POINT.value(new JdbcNamedParameter("plannPoint")),
								T_DEMAND_PLANN_TABLE.PLANN_DATE.value(new JdbcNamedParameter("plannDate")),
								T_DEMAND_PLANN_TABLE.ACTUAL_DATE.value(new JdbcNamedParameter("actualDate")),
								T_DEMAND_PLANN_TABLE.CQ_STATE.value(new JdbcNamedParameter("cqState")),
								T_DEMAND_PLANN_TABLE.CREATE_USER.value(new JdbcNamedParameter("createUser")),
								T_DEMAND_PLANN_TABLE.CREATE_TIME.value(new JdbcNamedParameter("createTime")),
								T_DEMAND_PLANN_TABLE.LAST_UPDATE_USER.value(new JdbcNamedParameter("lastUpdateUser")),
								T_DEMAND_PLANN_TABLE.LAST_UPDATE_TIME.value(new JdbcNamedParameter("lastUpdateTime")),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

						).where(T_DEMAND_PLANN_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TDemandPlann> tDemandPlann) {
		if (CollectionUtil.isEmpty(tDemandPlann)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tDemandPlann, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(T_DEMAND_PLANN_TABLE)
						.where(and(T_DEMAND_PLANN_TABLE.PLATFORM_TYPE.eq(new JdbcNamedParameter("platformType")),
								T_DEMAND_PLANN_TABLE.PLANN_NUMBER.eq(new JdbcNamedParameter("plannNumber")),
								T_DEMAND_PLANN_TABLE.PLANN_NAME.eq(new JdbcNamedParameter("plannName")),
								T_DEMAND_PLANN_TABLE.RELEVANCE_SYSTEM.eq(new JdbcNamedParameter("relevanceSystem")),
								T_DEMAND_PLANN_TABLE.IMPLEMENT_MODEL.eq(new JdbcNamedParameter("implementModel")),
								T_DEMAND_PLANN_TABLE.TECHNICAL_MANAGER.eq(new JdbcNamedParameter("technicalManager")),
								T_DEMAND_PLANN_TABLE.DEVELOPERS.eq(new JdbcNamedParameter("developers")),
								T_DEMAND_PLANN_TABLE.PLANN_POINT.eq(new JdbcNamedParameter("plannPoint")),
								T_DEMAND_PLANN_TABLE.PLANN_DATE.eq(new JdbcNamedParameter("plannDate")),
								T_DEMAND_PLANN_TABLE.ACTUAL_DATE.eq(new JdbcNamedParameter("actualDate")),
								T_DEMAND_PLANN_TABLE.CQ_STATE.eq(new JdbcNamedParameter("cqState")),
								T_DEMAND_PLANN_TABLE.CREATE_USER.eq(new JdbcNamedParameter("createUser")),
								T_DEMAND_PLANN_TABLE.CREATE_TIME.eq(new JdbcNamedParameter("createTime")),
								T_DEMAND_PLANN_TABLE.LAST_UPDATE_USER.eq(new JdbcNamedParameter("lastUpdateUser")),
								T_DEMAND_PLANN_TABLE.LAST_UPDATE_TIME.eq(new JdbcNamedParameter("lastUpdateTime")),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_1.eq(new JdbcNamedParameter("extField1")),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_2.eq(new JdbcNamedParameter("extField2")),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_3.eq(new JdbcNamedParameter("extField3")),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_4.eq(new JdbcNamedParameter("extField4")),
								T_DEMAND_PLANN_TABLE.EXT_FIELD_5.eq(new JdbcNamedParameter("extField5"))

				));
			}
		});
	}

	public int[] preparedBatchInsert(List<TDemandPlann> tDemandPlann) {
		return preparedBatchInsert(false, tDemandPlann);
	}

	@Override
	public List<TDemandPlann> checkExist(TDemandPlann tdemandPlann) {
		if (tdemandPlann == null) {
			tdemandPlann = new TDemandPlann();
		}
		return getDslTemplate().query(tdemandPlann,
				new SelectGenerateCallback<TDemandPlann>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TDemandPlann t) {
						Select select = selectFrom(T_DEMAND_PLANN_TABLE)
								.where(and(
										T_DEMAND_PLANN_TABLE.PLANN_NUMBER.eq(t.getPlannNumber())
								));
						return select;
					}
				});
	}

}
