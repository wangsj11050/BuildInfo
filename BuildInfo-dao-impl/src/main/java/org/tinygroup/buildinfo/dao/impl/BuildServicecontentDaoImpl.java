
package org.tinygroup.buildinfo.dao.impl;

import static org.tinygroup.buildinfo.dao.inter.constant.BuildServicecontentTable.BUILD_SERVICECONTENT_TABLE;
import static org.tinygroup.buildinfo.dao.inter.constant.BuildServicetypeTable.BUILD_SERVICETYPE_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.select;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;
import static org.tinygroup.tinysqldsl.formitem.SubSelect.subSelect;

import java.io.Serializable;
import java.util.List;

import org.tinygroup.buildinfo.dao.inter.BuildServicecontentDao;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildServicecontent;
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
public class BuildServicecontentDaoImpl extends TinyDslDaoSupport implements BuildServicecontentDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public BuildServicecontent add(BuildServicecontent buildServicecontent) {
		return getDslTemplate().insertAndReturnKey(buildServicecontent,
				new InsertGenerateCallback<BuildServicecontent>() {
					public Insert generate(BuildServicecontent t) {
						Insert insert = insertInto(BUILD_SERVICECONTENT_TABLE).values(
								BUILD_SERVICECONTENT_TABLE.ID.value(t.getId()),
								BUILD_SERVICECONTENT_TABLE.SERVICE_CODE.value(t.getServiceCode()),
								BUILD_SERVICECONTENT_TABLE.SERVICE_DES.value(t.getServiceDes()),
								BUILD_SERVICECONTENT_TABLE.SERVICE_FLOW.value(t.getServiceFlow()),
								BUILD_SERVICECONTENT_TABLE.SERVICE_DATA.value(t.getServiceData()),
								BUILD_SERVICECONTENT_TABLE.SERVICE_TERM.value(t.getServiceTerm()),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(BuildServicecontent buildServicecontent) {
		if (buildServicecontent == null || buildServicecontent.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(buildServicecontent, new UpdateGenerateCallback<BuildServicecontent>() {
			public Update generate(BuildServicecontent t) {
				Update update = update(BUILD_SERVICECONTENT_TABLE)
						.set(BUILD_SERVICECONTENT_TABLE.SERVICE_CODE.value(t.getServiceCode()),
								BUILD_SERVICECONTENT_TABLE.SERVICE_DES.value(t.getServiceDes()),
								BUILD_SERVICECONTENT_TABLE.SERVICE_FLOW.value(t.getServiceFlow()),
								BUILD_SERVICECONTENT_TABLE.SERVICE_DATA.value(t.getServiceData()),
								BUILD_SERVICECONTENT_TABLE.SERVICE_TERM.value(t.getServiceTerm()),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_5.value(t.getExtField_5()))
						.where(BUILD_SERVICECONTENT_TABLE.ID.eq(t.getId()));
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
				return delete(BUILD_SERVICECONTENT_TABLE).where(BUILD_SERVICECONTENT_TABLE.ID.eq(pk));
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
				return delete(BUILD_SERVICECONTENT_TABLE).where(BUILD_SERVICECONTENT_TABLE.ID.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public BuildServicecontent getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, BuildServicecontent.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(BUILD_SERVICECONTENT_TABLE).where(BUILD_SERVICECONTENT_TABLE.ID.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<BuildServicecontent> query(BuildServicecontent buildServicecontent, final OrderBy... orderArgs) {
		if (buildServicecontent == null) {
			buildServicecontent = new BuildServicecontent();
		}
		return getDslTemplate().query(buildServicecontent, new SelectGenerateCallback<BuildServicecontent>() {
			@SuppressWarnings("rawtypes")
			public Select generate(BuildServicecontent t) {
				Select select = selectFrom(BUILD_SERVICECONTENT_TABLE).where(and(
						BUILD_SERVICECONTENT_TABLE.ID.eq(t.getId()), BUILD_SERVICECONTENT_TABLE.SERVICE_CODE.eq(t.getServiceCode()),
						BUILD_SERVICECONTENT_TABLE.SERVICE_DES.eq(t.getServiceDes()),
						BUILD_SERVICECONTENT_TABLE.SERVICE_FLOW.eq(t.getServiceFlow()),
						BUILD_SERVICECONTENT_TABLE.SERVICE_DATA.eq(t.getServiceData()),
						BUILD_SERVICECONTENT_TABLE.SERVICE_TERM.eq(t.getServiceTerm()),
						BUILD_SERVICECONTENT_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						BUILD_SERVICECONTENT_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						BUILD_SERVICECONTENT_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						BUILD_SERVICECONTENT_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						BUILD_SERVICECONTENT_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<BuildServicecontent> queryPager(int start, int limit, BuildServicecontent buildServicecontent,
			final OrderBy... orderArgs) {
		if (buildServicecontent == null) {
			buildServicecontent = new BuildServicecontent();
		}
		return getDslTemplate().queryPager(start, limit, buildServicecontent, false,
				new SelectGenerateCallback<BuildServicecontent>() {
					public Select generate(BuildServicecontent t) {
						Select select = Select.selectFrom(BUILD_SERVICECONTENT_TABLE)
								.where(and(BUILD_SERVICECONTENT_TABLE.ID.eq(t.getId()),
										BUILD_SERVICECONTENT_TABLE.SERVICE_CODE.eq(t.getServiceCode()),
										BUILD_SERVICECONTENT_TABLE.SERVICE_DES.eq(t.getServiceDes()),
										BUILD_SERVICECONTENT_TABLE.SERVICE_FLOW.eq(t.getServiceFlow()),
										BUILD_SERVICECONTENT_TABLE.SERVICE_DATA.eq(t.getServiceData()),
										BUILD_SERVICECONTENT_TABLE.SERVICE_TERM.eq(t.getServiceTerm()),
										BUILD_SERVICECONTENT_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
										BUILD_SERVICECONTENT_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
										BUILD_SERVICECONTENT_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
										BUILD_SERVICECONTENT_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
										BUILD_SERVICECONTENT_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
						return TinyDSLUtil.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<BuildServicecontent> buildServicecontent) {
		if (CollectionUtil.isEmpty(buildServicecontent)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, buildServicecontent,
				new InsertGenerateCallback<BuildServicecontent>() {

					public Insert generate(BuildServicecontent t) {
						return insertInto(BUILD_SERVICECONTENT_TABLE).values(
								BUILD_SERVICECONTENT_TABLE.ID.value(t.getId()),
								BUILD_SERVICECONTENT_TABLE.SERVICE_CODE.value(t.getServiceCode()),
								BUILD_SERVICECONTENT_TABLE.SERVICE_DES.value(t.getServiceDes()),
								BUILD_SERVICECONTENT_TABLE.SERVICE_FLOW.value(t.getServiceFlow()),
								BUILD_SERVICECONTENT_TABLE.SERVICE_DATA.value(t.getServiceData()),
								BUILD_SERVICECONTENT_TABLE.SERVICE_TERM.value(t.getServiceTerm()),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<BuildServicecontent> buildServicecontents) {
		return batchInsert(true, buildServicecontents);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<BuildServicecontent> buildServicecontent) {
		if (CollectionUtil.isEmpty(buildServicecontent)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(buildServicecontent, new UpdateGenerateCallback<BuildServicecontent>() {
			public Update generate(BuildServicecontent t) {
				return update(BUILD_SERVICECONTENT_TABLE).set(BUILD_SERVICECONTENT_TABLE.SERVICE_CODE.value(t.getServiceCode()),
						BUILD_SERVICECONTENT_TABLE.SERVICE_DES.value(t.getServiceDes()),
						BUILD_SERVICECONTENT_TABLE.SERVICE_FLOW.value(t.getServiceFlow()),
						BUILD_SERVICECONTENT_TABLE.SERVICE_DATA.value(t.getServiceData()),
						BUILD_SERVICECONTENT_TABLE.SERVICE_TERM.value(t.getServiceTerm()),
						BUILD_SERVICECONTENT_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						BUILD_SERVICECONTENT_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						BUILD_SERVICECONTENT_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						BUILD_SERVICECONTENT_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						BUILD_SERVICECONTENT_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				).where(BUILD_SERVICECONTENT_TABLE.ID.eq(t.getId()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<BuildServicecontent> buildServicecontent) {
		if (CollectionUtil.isEmpty(buildServicecontent)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(buildServicecontent, new DeleteGenerateCallback<BuildServicecontent>() {
			public Delete generate(BuildServicecontent t) {
				return delete(BUILD_SERVICECONTENT_TABLE).where(and(BUILD_SERVICECONTENT_TABLE.ID.eq(t.getId()),
						BUILD_SERVICECONTENT_TABLE.SERVICE_CODE.eq(t.getServiceCode()),
						BUILD_SERVICECONTENT_TABLE.SERVICE_DES.eq(t.getServiceDes()),
						BUILD_SERVICECONTENT_TABLE.SERVICE_FLOW.eq(t.getServiceFlow()),
						BUILD_SERVICECONTENT_TABLE.SERVICE_DATA.eq(t.getServiceData()),
						BUILD_SERVICECONTENT_TABLE.SERVICE_TERM.eq(t.getServiceTerm()),
						BUILD_SERVICECONTENT_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						BUILD_SERVICECONTENT_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						BUILD_SERVICECONTENT_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						BUILD_SERVICECONTENT_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						BUILD_SERVICECONTENT_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<BuildServicecontent> buildServicecontent) {
		if (CollectionUtil.isEmpty(buildServicecontent)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, buildServicecontent,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(BUILD_SERVICECONTENT_TABLE).values(
								BUILD_SERVICECONTENT_TABLE.SERVICE_CODE.value(new JdbcNamedParameter("serviceCode")),
								BUILD_SERVICECONTENT_TABLE.SERVICE_DES.value(new JdbcNamedParameter("serviceDes")),
								BUILD_SERVICECONTENT_TABLE.SERVICE_FLOW.value(new JdbcNamedParameter("serviceFlow")),
								BUILD_SERVICECONTENT_TABLE.SERVICE_DATA.value(new JdbcNamedParameter("serviceData")),
								BUILD_SERVICECONTENT_TABLE.SERVICE_TERM.value(new JdbcNamedParameter("serviceTerm")),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<BuildServicecontent> buildServicecontent) {
		if (CollectionUtil.isEmpty(buildServicecontent)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(buildServicecontent, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(BUILD_SERVICECONTENT_TABLE)
						.set(BUILD_SERVICECONTENT_TABLE.SERVICE_CODE.value(new JdbcNamedParameter("serviceCode")),
								BUILD_SERVICECONTENT_TABLE.SERVICE_DES.value(new JdbcNamedParameter("serviceDes")),
								BUILD_SERVICECONTENT_TABLE.SERVICE_FLOW.value(new JdbcNamedParameter("serviceFlow")),
								BUILD_SERVICECONTENT_TABLE.SERVICE_DATA.value(new JdbcNamedParameter("serviceData")),
								BUILD_SERVICECONTENT_TABLE.SERVICE_TERM.value(new JdbcNamedParameter("serviceTerm")),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

						).where(BUILD_SERVICECONTENT_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<BuildServicecontent> buildServicecontent) {
		if (CollectionUtil.isEmpty(buildServicecontent)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(buildServicecontent, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(BUILD_SERVICECONTENT_TABLE)
						.where(and(BUILD_SERVICECONTENT_TABLE.SERVICE_CODE.eq(new JdbcNamedParameter("serviceCode")),
								BUILD_SERVICECONTENT_TABLE.SERVICE_DES.eq(new JdbcNamedParameter("serviceDes")),
								BUILD_SERVICECONTENT_TABLE.SERVICE_FLOW.eq(new JdbcNamedParameter("serviceFlow")),
								BUILD_SERVICECONTENT_TABLE.SERVICE_DATA.eq(new JdbcNamedParameter("serviceData")),
								BUILD_SERVICECONTENT_TABLE.SERVICE_TERM.eq(new JdbcNamedParameter("serviceTerm")),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_1.eq(new JdbcNamedParameter("extField1")),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_2.eq(new JdbcNamedParameter("extField2")),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_3.eq(new JdbcNamedParameter("extField3")),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_4.eq(new JdbcNamedParameter("extField4")),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_5.eq(new JdbcNamedParameter("extField5"))

				));
			}
		});
	}

	public int[] preparedBatchInsert(List<BuildServicecontent> buildServicecontent) {
		return preparedBatchInsert(true, buildServicecontent);
	}

	@Override
	public List<BuildServicecontent> getServiceContentByCode(String serviceCode) {
		BuildServicecontent buildServiceContent = new BuildServicecontent();
		buildServiceContent.setServiceCode(serviceCode);
		return getDslTemplate().query(buildServiceContent, new SelectGenerateCallback<BuildServicecontent>(){

			@Override
			public Select generate(BuildServicecontent t) {
				return Select.selectFrom(BUILD_SERVICECONTENT_TABLE).where(BUILD_SERVICECONTENT_TABLE.SERVICE_CODE.eq(t.getServiceCode()));
			}});
	}

	@Override
	public int editByCode(BuildServicecontent buildServicecontent) {
		if (buildServicecontent == null || buildServicecontent.getServiceCode() == null) {
			return 0;
		}
		return getDslTemplate().update(buildServicecontent, new UpdateGenerateCallback<BuildServicecontent>() {
			public Update generate(BuildServicecontent t) {
				Update update = update(BUILD_SERVICECONTENT_TABLE)
						.set(BUILD_SERVICECONTENT_TABLE.SERVICE_DES.value(t.getServiceDes()),
								BUILD_SERVICECONTENT_TABLE.SERVICE_FLOW.value(t.getServiceFlow()),
								BUILD_SERVICECONTENT_TABLE.SERVICE_DATA.value(t.getServiceData()),
								BUILD_SERVICECONTENT_TABLE.SERVICE_TERM.value(t.getServiceTerm()),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								BUILD_SERVICECONTENT_TABLE.EXT_FIELD_5.value(t.getExtField_5()))
						.where(BUILD_SERVICECONTENT_TABLE.SERVICE_CODE.eq(t.getServiceCode()));
				return update;
			}
		});
	}

	@Override
	public List<BuildServicecontent> getServiceContentLikeName(String serviceName) {
		BuildServicecontent buildServiceContent = new BuildServicecontent();
		final Condition subCondition;
		subCondition = BUILD_SERVICECONTENT_TABLE.SERVICE_CODE.inExpression(
				subSelect(select(BUILD_SERVICETYPE_TABLE.SERVICE_CODE)
						.from(BUILD_SERVICETYPE_TABLE).where(BUILD_SERVICETYPE_TABLE.SERVICE_NAME.like(serviceName))));
		return getDslTemplate().query(buildServiceContent, new SelectGenerateCallback<BuildServicecontent>(){

			@Override
			public Select generate(BuildServicecontent t) {
				return Select.selectFrom(BUILD_SERVICECONTENT_TABLE).where(subCondition);
			}});
	}

}
