
package org.tinygroup.buildinfo.dao.impl;

import static org.tinygroup.buildinfo.dao.inter.constant.BuildServicecenterTable.BUILD_SERVICECENTER_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;

import java.io.Serializable;
import java.util.List;

import org.tinygroup.buildinfo.dao.inter.BuildServicecenterDao;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildServicecenter;
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
import org.tinygroup.tinysqldsl.base.Condition;
import org.tinygroup.tinysqldsl.expression.JdbcNamedParameter;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public class BuildServicecenterDaoImpl extends TinyDslDaoSupport implements BuildServicecenterDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public BuildServicecenter add(BuildServicecenter buildServicecenter) {
		return getDslTemplate().insertAndReturnKey(buildServicecenter,
				new InsertGenerateCallback<BuildServicecenter>() {
					public Insert generate(BuildServicecenter t) {
						Insert insert = insertInto(BUILD_SERVICECENTER_TABLE).values(
								BUILD_SERVICECENTER_TABLE.ID.value(t.getId()),
								BUILD_SERVICECENTER_TABLE.SERVICECENTER_CODE.value(t.getServicecenterCode()),
								BUILD_SERVICECENTER_TABLE.SERVICECENTER_NAME.value(t.getServicecenterName()),
								BUILD_SERVICECENTER_TABLE.SERVICECENTER_DESC.value(t.getServicecenterDesc()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(BuildServicecenter buildServicecenter) {
		if (buildServicecenter == null || buildServicecenter.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(buildServicecenter, new UpdateGenerateCallback<BuildServicecenter>() {
			public Update generate(BuildServicecenter t) {
				Update update = update(BUILD_SERVICECENTER_TABLE)
						.set(BUILD_SERVICECENTER_TABLE.SERVICECENTER_CODE.value(t.getServicecenterCode()),
								BUILD_SERVICECENTER_TABLE.SERVICECENTER_NAME.value(t.getServicecenterName()),
								BUILD_SERVICECENTER_TABLE.SERVICECENTER_DESC.value(t.getServicecenterDesc()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_5.value(t.getExtField_5()))
						.where(BUILD_SERVICECENTER_TABLE.ID.eq(t.getId()));
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
				return delete(BUILD_SERVICECENTER_TABLE).where(BUILD_SERVICECENTER_TABLE.ID.eq(pk));
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
				return delete(BUILD_SERVICECENTER_TABLE).where(BUILD_SERVICECENTER_TABLE.ID.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public BuildServicecenter getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, BuildServicecenter.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(BUILD_SERVICECENTER_TABLE).where(BUILD_SERVICECENTER_TABLE.ID.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<BuildServicecenter> query(BuildServicecenter buildServicecenter, final OrderBy... orderArgs) {
		if (buildServicecenter == null) {
			buildServicecenter = new BuildServicecenter();
		}
		return getDslTemplate().query(buildServicecenter, new SelectGenerateCallback<BuildServicecenter>() {
			@SuppressWarnings("rawtypes")
			public Select generate(BuildServicecenter t) {
				Select select = selectFrom(BUILD_SERVICECENTER_TABLE)
						.where(and(BUILD_SERVICECENTER_TABLE.ID.eq(t.getId()),
								BUILD_SERVICECENTER_TABLE.SERVICECENTER_CODE.eq(t.getServicecenterCode()),
								BUILD_SERVICECENTER_TABLE.SERVICECENTER_NAME.eq(t.getServicecenterName()),
								BUILD_SERVICECENTER_TABLE.SERVICECENTER_DESC.eq(t.getServicecenterDesc()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<BuildServicecenter> queryPager(int start, int limit, BuildServicecenter buildServicecenter,
			final OrderBy... orderArgs) {
		if (buildServicecenter == null) {
			buildServicecenter = new BuildServicecenter();
		}
		return getDslTemplate().queryPager(start, limit, buildServicecenter, false,
				new SelectGenerateCallback<BuildServicecenter>() {
					public Select generate(BuildServicecenter t) {
						Select select = Select.selectFrom(BUILD_SERVICECENTER_TABLE)
								.where(and(BUILD_SERVICECENTER_TABLE.ID.eq(t.getId()),
										BUILD_SERVICECENTER_TABLE.SERVICECENTER_CODE.eq(t.getServicecenterCode()),
										BUILD_SERVICECENTER_TABLE.SERVICECENTER_NAME.eq(t.getServicecenterName()),
										BUILD_SERVICECENTER_TABLE.SERVICECENTER_DESC.eq(t.getServicecenterDesc()),
										BUILD_SERVICECENTER_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
										BUILD_SERVICECENTER_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
										BUILD_SERVICECENTER_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
										BUILD_SERVICECENTER_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
										BUILD_SERVICECENTER_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
						return TinyDSLUtil.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<BuildServicecenter> buildServicecenter) {
		if (CollectionUtil.isEmpty(buildServicecenter)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, buildServicecenter,
				new InsertGenerateCallback<BuildServicecenter>() {

					public Insert generate(BuildServicecenter t) {
						return insertInto(BUILD_SERVICECENTER_TABLE).values(
								BUILD_SERVICECENTER_TABLE.ID.value(t.getId()),
								BUILD_SERVICECENTER_TABLE.SERVICECENTER_CODE.value(t.getServicecenterCode()),
								BUILD_SERVICECENTER_TABLE.SERVICECENTER_NAME.value(t.getServicecenterName()),
								BUILD_SERVICECENTER_TABLE.SERVICECENTER_DESC.value(t.getServicecenterDesc()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<BuildServicecenter> buildServicecenters) {
		return batchInsert(true, buildServicecenters);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<BuildServicecenter> buildServicecenter) {
		if (CollectionUtil.isEmpty(buildServicecenter)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(buildServicecenter, new UpdateGenerateCallback<BuildServicecenter>() {
			public Update generate(BuildServicecenter t) {
				return update(BUILD_SERVICECENTER_TABLE)
						.set(BUILD_SERVICECENTER_TABLE.SERVICECENTER_CODE.value(t.getServicecenterCode()),
								BUILD_SERVICECENTER_TABLE.SERVICECENTER_NAME.value(t.getServicecenterName()),
								BUILD_SERVICECENTER_TABLE.SERVICECENTER_DESC.value(t.getServicecenterDesc()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_5.value(t.getExtField_5())

						).where(BUILD_SERVICECENTER_TABLE.ID.eq(t.getId()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<BuildServicecenter> buildServicecenter) {
		if (CollectionUtil.isEmpty(buildServicecenter)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(buildServicecenter, new DeleteGenerateCallback<BuildServicecenter>() {
			public Delete generate(BuildServicecenter t) {
				return delete(BUILD_SERVICECENTER_TABLE).where(and(BUILD_SERVICECENTER_TABLE.ID.eq(t.getId()),
						BUILD_SERVICECENTER_TABLE.SERVICECENTER_CODE.eq(t.getServicecenterCode()),
						BUILD_SERVICECENTER_TABLE.SERVICECENTER_NAME.eq(t.getServicecenterName()),
						BUILD_SERVICECENTER_TABLE.SERVICECENTER_DESC.eq(t.getServicecenterDesc()),
						BUILD_SERVICECENTER_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						BUILD_SERVICECENTER_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						BUILD_SERVICECENTER_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						BUILD_SERVICECENTER_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						BUILD_SERVICECENTER_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<BuildServicecenter> buildServicecenter) {
		if (CollectionUtil.isEmpty(buildServicecenter)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, buildServicecenter, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(BUILD_SERVICECENTER_TABLE).values(
						BUILD_SERVICECENTER_TABLE.SERVICECENTER_CODE.value(new JdbcNamedParameter("servicecenterCode")),
						BUILD_SERVICECENTER_TABLE.SERVICECENTER_NAME.value(new JdbcNamedParameter("servicecenterName")),
						BUILD_SERVICECENTER_TABLE.SERVICECENTER_DESC.value(new JdbcNamedParameter("servicecenterDesc")),
						BUILD_SERVICECENTER_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
						BUILD_SERVICECENTER_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
						BUILD_SERVICECENTER_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
						BUILD_SERVICECENTER_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
						BUILD_SERVICECENTER_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<BuildServicecenter> buildServicecenter) {
		if (CollectionUtil.isEmpty(buildServicecenter)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(buildServicecenter, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(BUILD_SERVICECENTER_TABLE).set(
						BUILD_SERVICECENTER_TABLE.SERVICECENTER_CODE.value(new JdbcNamedParameter("servicecenterCode")),
						BUILD_SERVICECENTER_TABLE.SERVICECENTER_NAME.value(new JdbcNamedParameter("servicecenterName")),
						BUILD_SERVICECENTER_TABLE.SERVICECENTER_DESC.value(new JdbcNamedParameter("servicecenterDesc")),
						BUILD_SERVICECENTER_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
						BUILD_SERVICECENTER_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
						BUILD_SERVICECENTER_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
						BUILD_SERVICECENTER_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
						BUILD_SERVICECENTER_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				).where(BUILD_SERVICECENTER_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<BuildServicecenter> buildServicecenter) {
		if (CollectionUtil.isEmpty(buildServicecenter)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(buildServicecenter, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(BUILD_SERVICECENTER_TABLE).where(and(
						BUILD_SERVICECENTER_TABLE.SERVICECENTER_CODE.eq(new JdbcNamedParameter("servicecenterCode")),
						BUILD_SERVICECENTER_TABLE.SERVICECENTER_NAME.eq(new JdbcNamedParameter("servicecenterName")),
						BUILD_SERVICECENTER_TABLE.SERVICECENTER_DESC.eq(new JdbcNamedParameter("servicecenterDesc")),
						BUILD_SERVICECENTER_TABLE.EXT_FIELD_1.eq(new JdbcNamedParameter("extField1")),
						BUILD_SERVICECENTER_TABLE.EXT_FIELD_2.eq(new JdbcNamedParameter("extField2")),
						BUILD_SERVICECENTER_TABLE.EXT_FIELD_3.eq(new JdbcNamedParameter("extField3")),
						BUILD_SERVICECENTER_TABLE.EXT_FIELD_4.eq(new JdbcNamedParameter("extField4")),
						BUILD_SERVICECENTER_TABLE.EXT_FIELD_5.eq(new JdbcNamedParameter("extField5"))

				));
			}
		});
	}

	public int[] preparedBatchInsert(List<BuildServicecenter> buildServicecenter) {
		return preparedBatchInsert(true, buildServicecenter);
	}

	@Override
	public List<BuildServicecenter> getServicecenterByCode(String serviceCode) {
		BuildServicecenter buildServicecenter = new BuildServicecenter();
		buildServicecenter.setServicecenterCode(serviceCode);
		return getDslTemplate().query(buildServicecenter, new SelectGenerateCallback<BuildServicecenter>(){

			@Override
			public Select generate(BuildServicecenter t) {
				return Select.selectFrom(BUILD_SERVICECENTER_TABLE).where(BUILD_SERVICECENTER_TABLE.SERVICECENTER_CODE.eq(t.getServicecenterCode()));
			}});
	}

	@Override
	public List<BuildServicecenter> checkServicecenterExists(BuildServicecenter buildServicecenter) {
		if(buildServicecenter == null){
			buildServicecenter = new BuildServicecenter();
		}
		return getDslTemplate().query(buildServicecenter, new SelectGenerateCallback<BuildServicecenter>(){

			@Override
			public Select generate(BuildServicecenter t) {
				// TODO Auto-generated method stub
				return Select.selectFrom(BUILD_SERVICECENTER_TABLE).where(
						BUILD_SERVICECENTER_TABLE.SERVICECENTER_CODE.eq(t.getServicecenterCode())
						);
			}});
	}

	@Override
	public int[] batchDeleteByCode(List<BuildServicecenter> buildServicecenter) {
		if (CollectionUtil.isEmpty(buildServicecenter)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(buildServicecenter, new DeleteGenerateCallback<BuildServicecenter>() {
			public Delete generate(BuildServicecenter t) {
				return delete(BUILD_SERVICECENTER_TABLE).where(
						BUILD_SERVICECENTER_TABLE.SERVICECENTER_CODE.eq(t.getServicecenterCode()
				));
			}
		});
	}

	@Override
	public int editByCode(BuildServicecenter buildServicecenter) {
		if (buildServicecenter == null || buildServicecenter.getServicecenterCode() == null) {
			return 0;
		}
		return getDslTemplate().update(buildServicecenter, new UpdateGenerateCallback<BuildServicecenter>() {
			public Update generate(BuildServicecenter t) {
				Update update = update(BUILD_SERVICECENTER_TABLE)
						.set(BUILD_SERVICECENTER_TABLE.SERVICECENTER_NAME.value(t.getServicecenterName()),
								BUILD_SERVICECENTER_TABLE.SERVICECENTER_DESC.value(t.getServicecenterDesc()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								BUILD_SERVICECENTER_TABLE.EXT_FIELD_5.value(t.getExtField_5()))
						.where(BUILD_SERVICECENTER_TABLE.SERVICECENTER_CODE.eq(t.getServicecenterCode()));
				return update;
			}
		});
	}

	@Override
	public List<BuildServicecenter> getServicecenters(String[] codes) {
		Condition con = null;
        if (codes != null) {
            String[] sCode = codes.length == 0 ? new String[]{"0"} : codes;
            con = BUILD_SERVICECENTER_TABLE.SERVICECENTER_CODE.in(sCode);
        }
        Select select = selectFrom(BUILD_SERVICECENTER_TABLE).where(con);
        return getDslSession().fetchList(select, BuildServicecenter.class);
	}

}
