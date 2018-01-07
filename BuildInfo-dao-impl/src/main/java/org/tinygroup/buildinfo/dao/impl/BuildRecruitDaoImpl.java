
package org.tinygroup.buildinfo.dao.impl;

import static org.tinygroup.buildinfo.dao.inter.constant.BuildRecruitTable.BUILD_RECRUIT_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;

import java.io.Serializable;
import java.util.List;

import org.tinygroup.buildinfo.dao.inter.BuildRecruitDao;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildRecruit;
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
public class BuildRecruitDaoImpl extends TinyDslDaoSupport implements BuildRecruitDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public BuildRecruit add(BuildRecruit buildRecruit) {
		return getDslTemplate().insertAndReturnKey(buildRecruit, new InsertGenerateCallback<BuildRecruit>() {
			public Insert generate(BuildRecruit t) {
				Insert insert = insertInto(BUILD_RECRUIT_TABLE).values(BUILD_RECRUIT_TABLE.ID.value(t.getId()),
						BUILD_RECRUIT_TABLE.RECRUIT_NAME.value(t.getRecruitName()),
						BUILD_RECRUIT_TABLE.RECRUIT_STATE.value(t.getRecruitState()),
						BUILD_RECRUIT_TABLE.PUB_TIME.value(t.getPubTime()),
						BUILD_RECRUIT_TABLE.PUB_USER.value(t.getPubUser()),
						BUILD_RECRUIT_TABLE.UPDATE_TIME.value(t.getUpdateTime()),
						BUILD_RECRUIT_TABLE.UPDATE_USER.value(t.getUpdateUser()),
						BUILD_RECRUIT_TABLE.RECRUIT_DESC.value(t.getRecruitDesc()),
						BUILD_RECRUIT_TABLE.RECRUIT_SENIORITY.value(t.getRecruitSeniority()),
						BUILD_RECRUIT_TABLE.EXT_FIELD.value(t.getExtField())

				);
				return insert;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(BuildRecruit buildRecruit) {
		if (buildRecruit == null || buildRecruit.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(buildRecruit, new UpdateGenerateCallback<BuildRecruit>() {
			public Update generate(BuildRecruit t) {
				Update update = update(BUILD_RECRUIT_TABLE)
						.set(BUILD_RECRUIT_TABLE.RECRUIT_NAME.value(t.getRecruitName()),
								BUILD_RECRUIT_TABLE.RECRUIT_STATE.value(t.getRecruitState()),
								BUILD_RECRUIT_TABLE.PUB_TIME.value(t.getPubTime()),
								BUILD_RECRUIT_TABLE.PUB_USER.value(t.getPubUser()),
								BUILD_RECRUIT_TABLE.UPDATE_TIME.value(t.getUpdateTime()),
								BUILD_RECRUIT_TABLE.UPDATE_USER.value(t.getUpdateUser()),
								BUILD_RECRUIT_TABLE.RECRUIT_DESC.value(t.getRecruitDesc()),
								BUILD_RECRUIT_TABLE.RECRUIT_SENIORITY.value(t.getRecruitSeniority()),
								BUILD_RECRUIT_TABLE.EXT_FIELD.value(t.getExtField()))
						.where(BUILD_RECRUIT_TABLE.ID.eq(t.getId()));
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
				return delete(BUILD_RECRUIT_TABLE).where(BUILD_RECRUIT_TABLE.ID.eq(pk));
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
				return delete(BUILD_RECRUIT_TABLE).where(BUILD_RECRUIT_TABLE.ID.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public BuildRecruit getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, BuildRecruit.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(BUILD_RECRUIT_TABLE).where(BUILD_RECRUIT_TABLE.ID.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<BuildRecruit> query(BuildRecruit buildRecruit, final OrderBy... orderArgs) {
		if (buildRecruit == null) {
			buildRecruit = new BuildRecruit();
		}
		return getDslTemplate().query(buildRecruit, new SelectGenerateCallback<BuildRecruit>() {
			@SuppressWarnings("rawtypes")
			public Select generate(BuildRecruit t) {
				Select select = selectFrom(BUILD_RECRUIT_TABLE).where(and(BUILD_RECRUIT_TABLE.ID.eq(t.getId()),
						BUILD_RECRUIT_TABLE.RECRUIT_NAME.eq(t.getRecruitName()),
						BUILD_RECRUIT_TABLE.RECRUIT_STATE.eq(t.getRecruitState()),
						BUILD_RECRUIT_TABLE.PUB_TIME.eq(t.getPubTime()),
						BUILD_RECRUIT_TABLE.PUB_USER.eq(t.getPubUser()),
						BUILD_RECRUIT_TABLE.UPDATE_TIME.eq(t.getUpdateTime()),
						BUILD_RECRUIT_TABLE.UPDATE_USER.eq(t.getUpdateUser()),
						BUILD_RECRUIT_TABLE.RECRUIT_DESC.eq(t.getRecruitDesc()),
						BUILD_RECRUIT_TABLE.RECRUIT_SENIORITY.eq(t.getRecruitSeniority()),
						BUILD_RECRUIT_TABLE.EXT_FIELD.eq(t.getExtField())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<BuildRecruit> queryPager(int start, int limit, BuildRecruit buildRecruit, final OrderBy... orderArgs) {
		if (buildRecruit == null) {
			buildRecruit = new BuildRecruit();
		}
		return getDslTemplate().queryPager(start, limit, buildRecruit, false,
				new SelectGenerateCallback<BuildRecruit>() {
					public Select generate(BuildRecruit t) {
						Select select = Select.selectFrom(BUILD_RECRUIT_TABLE)
								.where(and(BUILD_RECRUIT_TABLE.ID.eq(t.getId()),
										BUILD_RECRUIT_TABLE.RECRUIT_NAME.eq(t.getRecruitName()),
										BUILD_RECRUIT_TABLE.RECRUIT_STATE.eq(t.getRecruitState()),
										BUILD_RECRUIT_TABLE.PUB_TIME.eq(t.getPubTime()),
										BUILD_RECRUIT_TABLE.PUB_USER.eq(t.getPubUser()),
										BUILD_RECRUIT_TABLE.UPDATE_TIME.eq(t.getUpdateTime()),
										BUILD_RECRUIT_TABLE.UPDATE_USER.eq(t.getUpdateUser()),
										BUILD_RECRUIT_TABLE.RECRUIT_DESC.eq(t.getRecruitDesc()),
										BUILD_RECRUIT_TABLE.RECRUIT_SENIORITY.eq(t.getRecruitSeniority()),
										BUILD_RECRUIT_TABLE.EXT_FIELD.eq(t.getExtField())

				));
						return TinyDSLUtil.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<BuildRecruit> buildRecruit) {
		if (CollectionUtil.isEmpty(buildRecruit)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, buildRecruit,
				new InsertGenerateCallback<BuildRecruit>() {

					public Insert generate(BuildRecruit t) {
						return insertInto(BUILD_RECRUIT_TABLE).values(BUILD_RECRUIT_TABLE.ID.value(t.getId()),
								BUILD_RECRUIT_TABLE.RECRUIT_NAME.value(t.getRecruitName()),
								BUILD_RECRUIT_TABLE.RECRUIT_STATE.value(t.getRecruitState()),
								BUILD_RECRUIT_TABLE.PUB_TIME.value(t.getPubTime()),
								BUILD_RECRUIT_TABLE.PUB_USER.value(t.getPubUser()),
								BUILD_RECRUIT_TABLE.UPDATE_TIME.value(t.getUpdateTime()),
								BUILD_RECRUIT_TABLE.UPDATE_USER.value(t.getUpdateUser()),
								BUILD_RECRUIT_TABLE.RECRUIT_DESC.value(t.getRecruitDesc()),
								BUILD_RECRUIT_TABLE.RECRUIT_SENIORITY.value(t.getRecruitSeniority()),
								BUILD_RECRUIT_TABLE.EXT_FIELD.value(t.getExtField())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<BuildRecruit> buildRecruits) {
		return batchInsert(true, buildRecruits);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<BuildRecruit> buildRecruit) {
		if (CollectionUtil.isEmpty(buildRecruit)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(buildRecruit, new UpdateGenerateCallback<BuildRecruit>() {
			public Update generate(BuildRecruit t) {
				return update(BUILD_RECRUIT_TABLE).set(BUILD_RECRUIT_TABLE.RECRUIT_NAME.value(t.getRecruitName()),
						BUILD_RECRUIT_TABLE.RECRUIT_STATE.value(t.getRecruitState()),
						BUILD_RECRUIT_TABLE.PUB_TIME.value(t.getPubTime()),
						BUILD_RECRUIT_TABLE.PUB_USER.value(t.getPubUser()),
						BUILD_RECRUIT_TABLE.UPDATE_TIME.value(t.getUpdateTime()),
						BUILD_RECRUIT_TABLE.UPDATE_USER.value(t.getUpdateUser()),
						BUILD_RECRUIT_TABLE.RECRUIT_DESC.value(t.getRecruitDesc()),
						BUILD_RECRUIT_TABLE.RECRUIT_SENIORITY.value(t.getRecruitSeniority()),
						BUILD_RECRUIT_TABLE.EXT_FIELD.value(t.getExtField())

				).where(BUILD_RECRUIT_TABLE.ID.eq(t.getId()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<BuildRecruit> buildRecruit) {
		if (CollectionUtil.isEmpty(buildRecruit)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(buildRecruit, new DeleteGenerateCallback<BuildRecruit>() {
			public Delete generate(BuildRecruit t) {
				return delete(BUILD_RECRUIT_TABLE).where(and(BUILD_RECRUIT_TABLE.ID.eq(t.getId()),
						BUILD_RECRUIT_TABLE.RECRUIT_NAME.eq(t.getRecruitName()),
						BUILD_RECRUIT_TABLE.RECRUIT_STATE.eq(t.getRecruitState()),
						BUILD_RECRUIT_TABLE.PUB_TIME.eq(t.getPubTime()),
						BUILD_RECRUIT_TABLE.PUB_USER.eq(t.getPubUser()),
						BUILD_RECRUIT_TABLE.UPDATE_TIME.eq(t.getUpdateTime()),
						BUILD_RECRUIT_TABLE.UPDATE_USER.eq(t.getUpdateUser()),
						BUILD_RECRUIT_TABLE.RECRUIT_DESC.eq(t.getRecruitDesc()),
						BUILD_RECRUIT_TABLE.RECRUIT_SENIORITY.eq(t.getRecruitSeniority()),
						BUILD_RECRUIT_TABLE.EXT_FIELD.eq(t.getExtField())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<BuildRecruit> buildRecruit) {
		if (CollectionUtil.isEmpty(buildRecruit)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, buildRecruit, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(BUILD_RECRUIT_TABLE).values(
						BUILD_RECRUIT_TABLE.RECRUIT_NAME.value(new JdbcNamedParameter("recruitName")),
						BUILD_RECRUIT_TABLE.RECRUIT_STATE.value(new JdbcNamedParameter("recruitState")),
						BUILD_RECRUIT_TABLE.PUB_TIME.value(new JdbcNamedParameter("pubTime")),
						BUILD_RECRUIT_TABLE.PUB_USER.value(new JdbcNamedParameter("pubUser")),
						BUILD_RECRUIT_TABLE.UPDATE_TIME.value(new JdbcNamedParameter("updateTime")),
						BUILD_RECRUIT_TABLE.UPDATE_USER.value(new JdbcNamedParameter("updateUser")),
						BUILD_RECRUIT_TABLE.RECRUIT_DESC.value(new JdbcNamedParameter("recruitDesc")),
						BUILD_RECRUIT_TABLE.RECRUIT_SENIORITY.value(new JdbcNamedParameter("recruitSeniority")),
						BUILD_RECRUIT_TABLE.EXT_FIELD.value(new JdbcNamedParameter("extField"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<BuildRecruit> buildRecruit) {
		if (CollectionUtil.isEmpty(buildRecruit)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(buildRecruit, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(BUILD_RECRUIT_TABLE)
						.set(BUILD_RECRUIT_TABLE.RECRUIT_NAME.value(new JdbcNamedParameter("recruitName")),
								BUILD_RECRUIT_TABLE.RECRUIT_STATE.value(new JdbcNamedParameter("recruitState")),
								BUILD_RECRUIT_TABLE.PUB_TIME.value(new JdbcNamedParameter("pubTime")),
								BUILD_RECRUIT_TABLE.PUB_USER.value(new JdbcNamedParameter("pubUser")),
								BUILD_RECRUIT_TABLE.UPDATE_TIME.value(new JdbcNamedParameter("updateTime")),
								BUILD_RECRUIT_TABLE.UPDATE_USER.value(new JdbcNamedParameter("updateUser")),
								BUILD_RECRUIT_TABLE.RECRUIT_DESC.value(new JdbcNamedParameter("recruitDesc")),
								BUILD_RECRUIT_TABLE.RECRUIT_SENIORITY.value(new JdbcNamedParameter("recruitSeniority")),
								BUILD_RECRUIT_TABLE.EXT_FIELD.value(new JdbcNamedParameter("extField"))

						).where(BUILD_RECRUIT_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<BuildRecruit> buildRecruit) {
		if (CollectionUtil.isEmpty(buildRecruit)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(buildRecruit, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(BUILD_RECRUIT_TABLE)
						.where(and(BUILD_RECRUIT_TABLE.RECRUIT_NAME.eq(new JdbcNamedParameter("recruitName")),
								BUILD_RECRUIT_TABLE.RECRUIT_STATE.eq(new JdbcNamedParameter("recruitState")),
								BUILD_RECRUIT_TABLE.PUB_TIME.eq(new JdbcNamedParameter("pubTime")),
								BUILD_RECRUIT_TABLE.PUB_USER.eq(new JdbcNamedParameter("pubUser")),
								BUILD_RECRUIT_TABLE.UPDATE_TIME.eq(new JdbcNamedParameter("updateTime")),
								BUILD_RECRUIT_TABLE.UPDATE_USER.eq(new JdbcNamedParameter("updateUser")),
								BUILD_RECRUIT_TABLE.RECRUIT_DESC.eq(new JdbcNamedParameter("recruitDesc")),
								BUILD_RECRUIT_TABLE.RECRUIT_SENIORITY.eq(new JdbcNamedParameter("recruitSeniority")),
								BUILD_RECRUIT_TABLE.EXT_FIELD.eq(new JdbcNamedParameter("extField"))

				));
			}
		});
	}

	public int[] preparedBatchInsert(List<BuildRecruit> buildRecruit) {
		return preparedBatchInsert(true, buildRecruit);
	}

}
