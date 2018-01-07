
package org.tinygroup.buildinfo.dao.impl;

import static org.tinygroup.buildinfo.dao.inter.constant.BuildPubdemandTable.BUILD_PUBDEMAND_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;

import java.io.Serializable;
import java.util.List;

import org.tinygroup.buildinfo.dao.inter.BuildPubdemandDao;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildPubdemand;
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

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public class BuildPubdemandDaoImpl extends TinyDslDaoSupport implements BuildPubdemandDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public BuildPubdemand add(BuildPubdemand buildPubdemand) {
		return getDslTemplate().insertAndReturnKey(buildPubdemand, new InsertGenerateCallback<BuildPubdemand>() {
			public Insert generate(BuildPubdemand t) {
				Insert insert = insertInto(BUILD_PUBDEMAND_TABLE).values(BUILD_PUBDEMAND_TABLE.ID.value(t.getId()),
						BUILD_PUBDEMAND_TABLE.NAME.value(t.getName()), BUILD_PUBDEMAND_TABLE.PHONE.value(t.getPhone()),
						BUILD_PUBDEMAND_TABLE.DEMAND.value(t.getDemand()),
						BUILD_PUBDEMAND_TABLE.DEMAND_STATE.value(t.getDemandState()),
						BUILD_PUBDEMAND_TABLE.DEMAND_DESC.value(t.getDemandDesc()),
						BUILD_PUBDEMAND_TABLE.ADISVER_ID.value(t.getAdisverId()),
						BUILD_PUBDEMAND_TABLE.ADISVER_NAME.value(t.getAdisverName()),
						BUILD_PUBDEMAND_TABLE.PUB_TIME.value(t.getPubTime()),
						BUILD_PUBDEMAND_TABLE.UPDATE_TIME.value(t.getUpdateTime()),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
				return insert;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(BuildPubdemand buildPubdemand) {
		if (buildPubdemand == null || buildPubdemand.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(buildPubdemand, new UpdateGenerateCallback<BuildPubdemand>() {
			public Update generate(BuildPubdemand t) {
				Update update = update(BUILD_PUBDEMAND_TABLE)
						.set(BUILD_PUBDEMAND_TABLE.NAME.value(t.getName()),
								BUILD_PUBDEMAND_TABLE.PHONE.value(t.getPhone()),
								BUILD_PUBDEMAND_TABLE.DEMAND.value(t.getDemand()),
								BUILD_PUBDEMAND_TABLE.DEMAND_STATE.value(t.getDemandState()),
								BUILD_PUBDEMAND_TABLE.DEMAND_DESC.value(t.getDemandDesc()),
								BUILD_PUBDEMAND_TABLE.ADISVER_ID.value(t.getAdisverId()),
								BUILD_PUBDEMAND_TABLE.ADISVER_NAME.value(t.getAdisverName()),
								BUILD_PUBDEMAND_TABLE.PUB_TIME.value(t.getPubTime()),
								BUILD_PUBDEMAND_TABLE.UPDATE_TIME.value(t.getUpdateTime()),
								BUILD_PUBDEMAND_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_PUBDEMAND_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_PUBDEMAND_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								BUILD_PUBDEMAND_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								BUILD_PUBDEMAND_TABLE.EXT_FIELD_5.value(t.getExtField_5()))
						.where(BUILD_PUBDEMAND_TABLE.ID.eq(t.getId()));
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
				return delete(BUILD_PUBDEMAND_TABLE).where(BUILD_PUBDEMAND_TABLE.ID.eq(pk));
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
				return delete(BUILD_PUBDEMAND_TABLE).where(BUILD_PUBDEMAND_TABLE.ID.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public BuildPubdemand getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, BuildPubdemand.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(BUILD_PUBDEMAND_TABLE).where(BUILD_PUBDEMAND_TABLE.ID.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<BuildPubdemand> query(BuildPubdemand buildPubdemand, final OrderBy... orderArgs) {
		if (buildPubdemand == null) {
			buildPubdemand = new BuildPubdemand();
		}
		return getDslTemplate().query(buildPubdemand, new SelectGenerateCallback<BuildPubdemand>() {
			@SuppressWarnings("rawtypes")
			public Select generate(BuildPubdemand t) {
				Select select = selectFrom(BUILD_PUBDEMAND_TABLE).where(and(BUILD_PUBDEMAND_TABLE.ID.eq(t.getId()),
						BUILD_PUBDEMAND_TABLE.NAME.eq(t.getName()), BUILD_PUBDEMAND_TABLE.PHONE.eq(t.getPhone()),
						BUILD_PUBDEMAND_TABLE.DEMAND.eq(t.getDemand()),
						BUILD_PUBDEMAND_TABLE.DEMAND_STATE.eq(t.getDemandState()),
						BUILD_PUBDEMAND_TABLE.DEMAND_DESC.eq(t.getDemandDesc()),
						BUILD_PUBDEMAND_TABLE.ADISVER_ID.eq(t.getAdisverId()),
						BUILD_PUBDEMAND_TABLE.ADISVER_NAME.eq(t.getAdisverName()),
						BUILD_PUBDEMAND_TABLE.PUB_TIME.eq(t.getPubTime()),
						BUILD_PUBDEMAND_TABLE.UPDATE_TIME.eq(t.getUpdateTime()),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<BuildPubdemand> queryPager(int start, int limit, BuildPubdemand buildPubdemand,
			final OrderBy... orderArgs) {
		if (buildPubdemand == null) {
			buildPubdemand = new BuildPubdemand();
		}
		return getDslTemplate().queryPager(start, limit, buildPubdemand, false,
				new SelectGenerateCallback<BuildPubdemand>() {
					public Select generate(BuildPubdemand t) {
						Select select = Select.selectFrom(BUILD_PUBDEMAND_TABLE)
								.where(and(BUILD_PUBDEMAND_TABLE.ID.eq(t.getId()),
										BUILD_PUBDEMAND_TABLE.NAME.eq(t.getName()),
										BUILD_PUBDEMAND_TABLE.PHONE.eq(t.getPhone()),
										BUILD_PUBDEMAND_TABLE.DEMAND.eq(t.getDemand()),
										BUILD_PUBDEMAND_TABLE.DEMAND_STATE.eq(t.getDemandState()),
										BUILD_PUBDEMAND_TABLE.DEMAND_DESC.eq(t.getDemandDesc()),
										BUILD_PUBDEMAND_TABLE.ADISVER_ID.eq(t.getAdisverId()),
										BUILD_PUBDEMAND_TABLE.ADISVER_NAME.eq(t.getAdisverName()),
										BUILD_PUBDEMAND_TABLE.PUB_TIME.eq(t.getPubTime()),
										BUILD_PUBDEMAND_TABLE.UPDATE_TIME.eq(t.getUpdateTime()),
										BUILD_PUBDEMAND_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
										BUILD_PUBDEMAND_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
										BUILD_PUBDEMAND_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
										BUILD_PUBDEMAND_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
										BUILD_PUBDEMAND_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
						return TinyDSLUtil.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<BuildPubdemand> buildPubdemand) {
		if (CollectionUtil.isEmpty(buildPubdemand)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, buildPubdemand,
				new InsertGenerateCallback<BuildPubdemand>() {

					public Insert generate(BuildPubdemand t) {
						return insertInto(BUILD_PUBDEMAND_TABLE).values(BUILD_PUBDEMAND_TABLE.ID.value(t.getId()),
								BUILD_PUBDEMAND_TABLE.NAME.value(t.getName()),
								BUILD_PUBDEMAND_TABLE.PHONE.value(t.getPhone()),
								BUILD_PUBDEMAND_TABLE.DEMAND.value(t.getDemand()),
								BUILD_PUBDEMAND_TABLE.DEMAND_STATE.value(t.getDemandState()),
								BUILD_PUBDEMAND_TABLE.DEMAND_DESC.value(t.getDemandDesc()),
								BUILD_PUBDEMAND_TABLE.ADISVER_ID.value(t.getAdisverId()),
								BUILD_PUBDEMAND_TABLE.ADISVER_NAME.value(t.getAdisverName()),
								BUILD_PUBDEMAND_TABLE.PUB_TIME.value(t.getPubTime()),
								BUILD_PUBDEMAND_TABLE.UPDATE_TIME.value(t.getUpdateTime()),
								BUILD_PUBDEMAND_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_PUBDEMAND_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_PUBDEMAND_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								BUILD_PUBDEMAND_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								BUILD_PUBDEMAND_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<BuildPubdemand> buildPubdemands) {
		return batchInsert(true, buildPubdemands);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<BuildPubdemand> buildPubdemand) {
		if (CollectionUtil.isEmpty(buildPubdemand)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(buildPubdemand, new UpdateGenerateCallback<BuildPubdemand>() {
			public Update generate(BuildPubdemand t) {
				return update(BUILD_PUBDEMAND_TABLE).set(BUILD_PUBDEMAND_TABLE.NAME.value(t.getName()),
						BUILD_PUBDEMAND_TABLE.PHONE.value(t.getPhone()),
						BUILD_PUBDEMAND_TABLE.DEMAND.value(t.getDemand()),
						BUILD_PUBDEMAND_TABLE.DEMAND_STATE.value(t.getDemandState()),
						BUILD_PUBDEMAND_TABLE.DEMAND_DESC.value(t.getDemandDesc()),
						BUILD_PUBDEMAND_TABLE.ADISVER_ID.value(t.getAdisverId()),
						BUILD_PUBDEMAND_TABLE.ADISVER_NAME.value(t.getAdisverName()),
						BUILD_PUBDEMAND_TABLE.PUB_TIME.value(t.getPubTime()),
						BUILD_PUBDEMAND_TABLE.UPDATE_TIME.value(t.getUpdateTime()),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				).where(BUILD_PUBDEMAND_TABLE.ID.eq(t.getId()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<BuildPubdemand> buildPubdemand) {
		if (CollectionUtil.isEmpty(buildPubdemand)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(buildPubdemand, new DeleteGenerateCallback<BuildPubdemand>() {
			public Delete generate(BuildPubdemand t) {
				return delete(BUILD_PUBDEMAND_TABLE).where(and(BUILD_PUBDEMAND_TABLE.ID.eq(t.getId()),
						BUILD_PUBDEMAND_TABLE.NAME.eq(t.getName()), BUILD_PUBDEMAND_TABLE.PHONE.eq(t.getPhone()),
						BUILD_PUBDEMAND_TABLE.DEMAND.eq(t.getDemand()),
						BUILD_PUBDEMAND_TABLE.DEMAND_STATE.eq(t.getDemandState()),
						BUILD_PUBDEMAND_TABLE.DEMAND_DESC.eq(t.getDemandDesc()),
						BUILD_PUBDEMAND_TABLE.ADISVER_ID.eq(t.getAdisverId()),
						BUILD_PUBDEMAND_TABLE.ADISVER_NAME.eq(t.getAdisverName()),
						BUILD_PUBDEMAND_TABLE.PUB_TIME.eq(t.getPubTime()),
						BUILD_PUBDEMAND_TABLE.UPDATE_TIME.eq(t.getUpdateTime()),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<BuildPubdemand> buildPubdemand) {
		if (CollectionUtil.isEmpty(buildPubdemand)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, buildPubdemand, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(BUILD_PUBDEMAND_TABLE).values(
						BUILD_PUBDEMAND_TABLE.NAME.value(new JdbcNamedParameter("name")),
						BUILD_PUBDEMAND_TABLE.PHONE.value(new JdbcNamedParameter("phone")),
						BUILD_PUBDEMAND_TABLE.DEMAND.value(new JdbcNamedParameter("demand")),
						BUILD_PUBDEMAND_TABLE.DEMAND_STATE.value(new JdbcNamedParameter("demandState")),
						BUILD_PUBDEMAND_TABLE.DEMAND_DESC.value(new JdbcNamedParameter("demandDesc")),
						BUILD_PUBDEMAND_TABLE.ADISVER_ID.value(new JdbcNamedParameter("adisverId")),
						BUILD_PUBDEMAND_TABLE.ADISVER_NAME.value(new JdbcNamedParameter("adisverName")),
						BUILD_PUBDEMAND_TABLE.PUB_TIME.value(new JdbcNamedParameter("pubTime")),
						BUILD_PUBDEMAND_TABLE.UPDATE_TIME.value(new JdbcNamedParameter("updateTime")),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
						BUILD_PUBDEMAND_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<BuildPubdemand> buildPubdemand) {
		if (CollectionUtil.isEmpty(buildPubdemand)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(buildPubdemand, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(BUILD_PUBDEMAND_TABLE)
						.set(BUILD_PUBDEMAND_TABLE.NAME.value(new JdbcNamedParameter("name")),
								BUILD_PUBDEMAND_TABLE.PHONE.value(new JdbcNamedParameter("phone")),
								BUILD_PUBDEMAND_TABLE.DEMAND.value(new JdbcNamedParameter("demand")),
								BUILD_PUBDEMAND_TABLE.DEMAND_STATE.value(new JdbcNamedParameter("demandState")),
								BUILD_PUBDEMAND_TABLE.DEMAND_DESC.value(new JdbcNamedParameter("demandDesc")),
								BUILD_PUBDEMAND_TABLE.ADISVER_ID.value(new JdbcNamedParameter("adisverId")),
								BUILD_PUBDEMAND_TABLE.ADISVER_NAME.value(new JdbcNamedParameter("adisverName")),
								BUILD_PUBDEMAND_TABLE.PUB_TIME.value(new JdbcNamedParameter("pubTime")),
								BUILD_PUBDEMAND_TABLE.UPDATE_TIME.value(new JdbcNamedParameter("updateTime")),
								BUILD_PUBDEMAND_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
								BUILD_PUBDEMAND_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
								BUILD_PUBDEMAND_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
								BUILD_PUBDEMAND_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
								BUILD_PUBDEMAND_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

						).where(BUILD_PUBDEMAND_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<BuildPubdemand> buildPubdemand) {
		if (CollectionUtil.isEmpty(buildPubdemand)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(buildPubdemand, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(BUILD_PUBDEMAND_TABLE)
						.where(and(BUILD_PUBDEMAND_TABLE.NAME.eq(new JdbcNamedParameter("name")),
								BUILD_PUBDEMAND_TABLE.PHONE.eq(new JdbcNamedParameter("phone")),
								BUILD_PUBDEMAND_TABLE.DEMAND.eq(new JdbcNamedParameter("demand")),
								BUILD_PUBDEMAND_TABLE.DEMAND_STATE.eq(new JdbcNamedParameter("demandState")),
								BUILD_PUBDEMAND_TABLE.DEMAND_DESC.eq(new JdbcNamedParameter("demandDesc")),
								BUILD_PUBDEMAND_TABLE.ADISVER_ID.eq(new JdbcNamedParameter("adisverId")),
								BUILD_PUBDEMAND_TABLE.ADISVER_NAME.eq(new JdbcNamedParameter("adisverName")),
								BUILD_PUBDEMAND_TABLE.PUB_TIME.eq(new JdbcNamedParameter("pubTime")),
								BUILD_PUBDEMAND_TABLE.UPDATE_TIME.eq(new JdbcNamedParameter("updateTime")),
								BUILD_PUBDEMAND_TABLE.EXT_FIELD_1.eq(new JdbcNamedParameter("extField1")),
								BUILD_PUBDEMAND_TABLE.EXT_FIELD_2.eq(new JdbcNamedParameter("extField2")),
								BUILD_PUBDEMAND_TABLE.EXT_FIELD_3.eq(new JdbcNamedParameter("extField3")),
								BUILD_PUBDEMAND_TABLE.EXT_FIELD_4.eq(new JdbcNamedParameter("extField4")),
								BUILD_PUBDEMAND_TABLE.EXT_FIELD_5.eq(new JdbcNamedParameter("extField5"))

				));
			}
		});
	}

	public int[] preparedBatchInsert(List<BuildPubdemand> buildPubdemand) {
		return preparedBatchInsert(true, buildPubdemand);
	}

}
