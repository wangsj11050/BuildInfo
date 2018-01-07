
package org.tinygroup.buildinfo.dao.impl;

import static org.tinygroup.buildinfo.dao.inter.constant.BuildCustomercaseTable.BUILD_CUSTOMERCASE_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;

import java.io.Serializable;
import java.util.List;

import org.tinygroup.buildinfo.dao.inter.BuildCustomercaseDao;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildCustomercase;
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
public class BuildCustomercaseDaoImpl extends TinyDslDaoSupport implements BuildCustomercaseDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public BuildCustomercase add(BuildCustomercase buildCustomercase) {
		return getDslTemplate().insertAndReturnKey(buildCustomercase, new InsertGenerateCallback<BuildCustomercase>() {
			public Insert generate(BuildCustomercase t) {
				Insert insert = insertInto(BUILD_CUSTOMERCASE_TABLE).values(
						BUILD_CUSTOMERCASE_TABLE.ID.value(t.getId()),
						BUILD_CUSTOMERCASE_TABLE.CASE_NAME.value(t.getCaseName()),
						BUILD_CUSTOMERCASE_TABLE.PUB_DATE.value(t.getPubDate()),
						BUILD_CUSTOMERCASE_TABLE.CASE_INFORMATION.value(t.getCaseInformation()),
						BUILD_CUSTOMERCASE_TABLE.CASE_IMG.value(t.getCaseImg()),
						BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
				return insert;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(BuildCustomercase buildCustomercase) {
		if (buildCustomercase == null || buildCustomercase.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(buildCustomercase, new UpdateGenerateCallback<BuildCustomercase>() {
			public Update generate(BuildCustomercase t) {
				Update update = update(BUILD_CUSTOMERCASE_TABLE)
						.set(BUILD_CUSTOMERCASE_TABLE.CASE_NAME.value(t.getCaseName()),
								BUILD_CUSTOMERCASE_TABLE.PUB_DATE.value(t.getPubDate()),
								BUILD_CUSTOMERCASE_TABLE.CASE_INFORMATION.value(t.getCaseInformation()),
								BUILD_CUSTOMERCASE_TABLE.CASE_IMG.value(t.getCaseImg()),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_5.value(t.getExtField_5()))
						.where(BUILD_CUSTOMERCASE_TABLE.ID.eq(t.getId()));
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
				return delete(BUILD_CUSTOMERCASE_TABLE).where(BUILD_CUSTOMERCASE_TABLE.ID.eq(pk));
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
				return delete(BUILD_CUSTOMERCASE_TABLE).where(BUILD_CUSTOMERCASE_TABLE.ID.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public BuildCustomercase getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, BuildCustomercase.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(BUILD_CUSTOMERCASE_TABLE).where(BUILD_CUSTOMERCASE_TABLE.ID.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<BuildCustomercase> query(BuildCustomercase buildCustomercase, final OrderBy... orderArgs) {
		if (buildCustomercase == null) {
			buildCustomercase = new BuildCustomercase();
		}
		return getDslTemplate().query(buildCustomercase, new SelectGenerateCallback<BuildCustomercase>() {
			@SuppressWarnings("rawtypes")
			public Select generate(BuildCustomercase t) {
				Select select = selectFrom(BUILD_CUSTOMERCASE_TABLE)
						.where(and(BUILD_CUSTOMERCASE_TABLE.ID.eq(t.getId()),
								BUILD_CUSTOMERCASE_TABLE.CASE_NAME.eq(t.getCaseName()),
								BUILD_CUSTOMERCASE_TABLE.PUB_DATE.eq(t.getPubDate()),
								BUILD_CUSTOMERCASE_TABLE.CASE_INFORMATION.eq(t.getCaseInformation()),
								BUILD_CUSTOMERCASE_TABLE.CASE_IMG.eq(t.getCaseImg()),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<BuildCustomercase> queryPager(int start, int limit, BuildCustomercase buildCustomercase,
			final OrderBy... orderArgs) {
		if (buildCustomercase == null) {
			buildCustomercase = new BuildCustomercase();
		}
		return getDslTemplate().queryPager(start, limit, buildCustomercase, false,
				new SelectGenerateCallback<BuildCustomercase>() {
					public Select generate(BuildCustomercase t) {
						Select select = Select.selectFrom(BUILD_CUSTOMERCASE_TABLE)
								.where(and(BUILD_CUSTOMERCASE_TABLE.ID.eq(t.getId()),
										BUILD_CUSTOMERCASE_TABLE.CASE_NAME.eq(t.getCaseName()),
										BUILD_CUSTOMERCASE_TABLE.PUB_DATE.eq(t.getPubDate()),
										BUILD_CUSTOMERCASE_TABLE.CASE_INFORMATION.eq(t.getCaseInformation()),
										BUILD_CUSTOMERCASE_TABLE.CASE_IMG.eq(t.getCaseImg()),
										BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
										BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
										BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
										BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
										BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
						return TinyDSLUtil.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<BuildCustomercase> buildCustomercase) {
		if (CollectionUtil.isEmpty(buildCustomercase)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, buildCustomercase,
				new InsertGenerateCallback<BuildCustomercase>() {

					public Insert generate(BuildCustomercase t) {
						return insertInto(BUILD_CUSTOMERCASE_TABLE).values(BUILD_CUSTOMERCASE_TABLE.ID.value(t.getId()),
								BUILD_CUSTOMERCASE_TABLE.CASE_NAME.value(t.getCaseName()),
								BUILD_CUSTOMERCASE_TABLE.PUB_DATE.value(t.getPubDate()),
								BUILD_CUSTOMERCASE_TABLE.CASE_INFORMATION.value(t.getCaseInformation()),
								BUILD_CUSTOMERCASE_TABLE.CASE_IMG.value(t.getCaseImg()),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<BuildCustomercase> buildCustomercases) {
		return batchInsert(true, buildCustomercases);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<BuildCustomercase> buildCustomercase) {
		if (CollectionUtil.isEmpty(buildCustomercase)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(buildCustomercase, new UpdateGenerateCallback<BuildCustomercase>() {
			public Update generate(BuildCustomercase t) {
				return update(BUILD_CUSTOMERCASE_TABLE).set(BUILD_CUSTOMERCASE_TABLE.CASE_NAME.value(t.getCaseName()),
						BUILD_CUSTOMERCASE_TABLE.PUB_DATE.value(t.getPubDate()),
						BUILD_CUSTOMERCASE_TABLE.CASE_INFORMATION.value(t.getCaseInformation()),
						BUILD_CUSTOMERCASE_TABLE.CASE_IMG.value(t.getCaseImg()),
						BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				).where(BUILD_CUSTOMERCASE_TABLE.ID.eq(t.getId()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<BuildCustomercase> buildCustomercase) {
		if (CollectionUtil.isEmpty(buildCustomercase)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(buildCustomercase, new DeleteGenerateCallback<BuildCustomercase>() {
			public Delete generate(BuildCustomercase t) {
				return delete(BUILD_CUSTOMERCASE_TABLE).where(and(BUILD_CUSTOMERCASE_TABLE.ID.eq(t.getId()),
						BUILD_CUSTOMERCASE_TABLE.CASE_NAME.eq(t.getCaseName()),
						BUILD_CUSTOMERCASE_TABLE.PUB_DATE.eq(t.getPubDate()),
						BUILD_CUSTOMERCASE_TABLE.CASE_INFORMATION.eq(t.getCaseInformation()),
						BUILD_CUSTOMERCASE_TABLE.CASE_IMG.eq(t.getCaseImg()),
						BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<BuildCustomercase> buildCustomercase) {
		if (CollectionUtil.isEmpty(buildCustomercase)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, buildCustomercase, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(BUILD_CUSTOMERCASE_TABLE)
						.values(BUILD_CUSTOMERCASE_TABLE.CASE_NAME.value(new JdbcNamedParameter("caseName")),
								BUILD_CUSTOMERCASE_TABLE.PUB_DATE.value(new JdbcNamedParameter("pubDate")),
								BUILD_CUSTOMERCASE_TABLE.CASE_INFORMATION
										.value(new JdbcNamedParameter("caseInformation")),
								BUILD_CUSTOMERCASE_TABLE.CASE_IMG.value(new JdbcNamedParameter("caseImg")),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<BuildCustomercase> buildCustomercase) {
		if (CollectionUtil.isEmpty(buildCustomercase)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(buildCustomercase, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(BUILD_CUSTOMERCASE_TABLE)
						.set(BUILD_CUSTOMERCASE_TABLE.CASE_NAME.value(new JdbcNamedParameter("caseName")),
								BUILD_CUSTOMERCASE_TABLE.PUB_DATE.value(new JdbcNamedParameter("pubDate")),
								BUILD_CUSTOMERCASE_TABLE.CASE_INFORMATION
										.value(new JdbcNamedParameter("caseInformation")),
								BUILD_CUSTOMERCASE_TABLE.CASE_IMG.value(new JdbcNamedParameter("caseImg")),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

						).where(BUILD_CUSTOMERCASE_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<BuildCustomercase> buildCustomercase) {
		if (CollectionUtil.isEmpty(buildCustomercase)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(buildCustomercase, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(BUILD_CUSTOMERCASE_TABLE)
						.where(and(BUILD_CUSTOMERCASE_TABLE.CASE_NAME.eq(new JdbcNamedParameter("caseName")),
								BUILD_CUSTOMERCASE_TABLE.PUB_DATE.eq(new JdbcNamedParameter("pubDate")),
								BUILD_CUSTOMERCASE_TABLE.CASE_INFORMATION.eq(new JdbcNamedParameter("caseInformation")),
								BUILD_CUSTOMERCASE_TABLE.CASE_IMG.eq(new JdbcNamedParameter("caseImg")),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_1.eq(new JdbcNamedParameter("extField1")),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_2.eq(new JdbcNamedParameter("extField2")),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_3.eq(new JdbcNamedParameter("extField3")),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_4.eq(new JdbcNamedParameter("extField4")),
								BUILD_CUSTOMERCASE_TABLE.EXT_FIELD_5.eq(new JdbcNamedParameter("extField5"))

				));
			}
		});
	}

	public int[] preparedBatchInsert(List<BuildCustomercase> buildCustomercase) {
		return preparedBatchInsert(true, buildCustomercase);
	}

}
