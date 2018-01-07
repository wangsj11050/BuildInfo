
package org.tinygroup.buildinfo.dao.impl;

import static org.tinygroup.buildinfo.dao.inter.constant.BuildAdisverTable.BUILD_ADISVER_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;

import java.io.Serializable;
import java.util.List;

import org.tinygroup.buildinfo.dao.inter.BuildAdisverDao;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildAdisver;
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
public class BuildAdisverDaoImpl extends TinyDslDaoSupport implements BuildAdisverDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public BuildAdisver add(BuildAdisver buildAdisver) {
		return getDslTemplate().insertAndReturnKey(buildAdisver, new InsertGenerateCallback<BuildAdisver>() {
			public Insert generate(BuildAdisver t) {
				Insert insert = insertInto(BUILD_ADISVER_TABLE).values(BUILD_ADISVER_TABLE.ID.value(t.getId()),
						BUILD_ADISVER_TABLE.NAME.value(t.getName()), BUILD_ADISVER_TABLE.STARS.value(t.getStars()),
						BUILD_ADISVER_TABLE.JOB_NUMBER.value(t.getJobNumber()),
						BUILD_ADISVER_TABLE.WORK_YEARS.value(t.getWorkYears()),
						BUILD_ADISVER_TABLE.ADISVER_PHONE.value(t.getAdisverPhone()),
						BUILD_ADISVER_TABLE.ADISVER_RESUME.value(t.getAdisverResume()),
						BUILD_ADISVER_TABLE.ADISVER_IMG.value(t.getAdisverImg()),
						BUILD_ADISVER_TABLE.SERVICE_EXPERIENCE.value(t.getServiceExperience()),
						BUILD_ADISVER_TABLE.SERVICE_TYPE.value(t.getServiceType()),
						BUILD_ADISVER_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						BUILD_ADISVER_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						BUILD_ADISVER_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						BUILD_ADISVER_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						BUILD_ADISVER_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
				return insert;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(BuildAdisver buildAdisver) {
		if (buildAdisver == null || buildAdisver.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(buildAdisver, new UpdateGenerateCallback<BuildAdisver>() {
			public Update generate(BuildAdisver t) {
				Update update = update(BUILD_ADISVER_TABLE)
						.set(BUILD_ADISVER_TABLE.NAME.value(t.getName()), BUILD_ADISVER_TABLE.STARS.value(t.getStars()),
								BUILD_ADISVER_TABLE.JOB_NUMBER.value(t.getJobNumber()),
								BUILD_ADISVER_TABLE.WORK_YEARS.value(t.getWorkYears()),
								BUILD_ADISVER_TABLE.ADISVER_PHONE.value(t.getAdisverPhone()),
								BUILD_ADISVER_TABLE.ADISVER_RESUME.value(t.getAdisverResume()),
								BUILD_ADISVER_TABLE.ADISVER_IMG.value(t.getAdisverImg()),
								BUILD_ADISVER_TABLE.SERVICE_EXPERIENCE.value(t.getServiceExperience()),
								BUILD_ADISVER_TABLE.SERVICE_TYPE.value(t.getServiceType()),
								BUILD_ADISVER_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_ADISVER_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_ADISVER_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								BUILD_ADISVER_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								BUILD_ADISVER_TABLE.EXT_FIELD_5.value(t.getExtField_5()))
						.where(BUILD_ADISVER_TABLE.ID.eq(t.getId()));
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
				return delete(BUILD_ADISVER_TABLE).where(BUILD_ADISVER_TABLE.ID.eq(pk));
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
				return delete(BUILD_ADISVER_TABLE).where(BUILD_ADISVER_TABLE.ID.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public BuildAdisver getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, BuildAdisver.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(BUILD_ADISVER_TABLE).where(BUILD_ADISVER_TABLE.ID.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<BuildAdisver> query(BuildAdisver buildAdisver, final OrderBy... orderArgs) {
		if (buildAdisver == null) {
			buildAdisver = new BuildAdisver();
		}
		return getDslTemplate().query(buildAdisver, new SelectGenerateCallback<BuildAdisver>() {
			@SuppressWarnings("rawtypes")
			public Select generate(BuildAdisver t) {
				Select select = selectFrom(BUILD_ADISVER_TABLE).where(and(BUILD_ADISVER_TABLE.ID.eq(t.getId()),
						BUILD_ADISVER_TABLE.NAME.eq(t.getName()), BUILD_ADISVER_TABLE.STARS.eq(t.getStars()),
						BUILD_ADISVER_TABLE.JOB_NUMBER.eq(t.getJobNumber()),
						BUILD_ADISVER_TABLE.WORK_YEARS.eq(t.getWorkYears()),
						BUILD_ADISVER_TABLE.ADISVER_PHONE.eq(t.getAdisverPhone()),
						BUILD_ADISVER_TABLE.ADISVER_RESUME.eq(t.getAdisverResume()),
						BUILD_ADISVER_TABLE.ADISVER_IMG.eq(t.getAdisverImg()),
						BUILD_ADISVER_TABLE.SERVICE_EXPERIENCE.eq(t.getServiceExperience()),
						BUILD_ADISVER_TABLE.SERVICE_TYPE.eq(t.getServiceType()),
						BUILD_ADISVER_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						BUILD_ADISVER_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						BUILD_ADISVER_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						BUILD_ADISVER_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						BUILD_ADISVER_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<BuildAdisver> queryPager(int start, int limit, BuildAdisver buildAdisver, final OrderBy... orderArgs) {
		if (buildAdisver == null) {
			buildAdisver = new BuildAdisver();
		}
		return getDslTemplate().queryPager(start, limit, buildAdisver, false,
				new SelectGenerateCallback<BuildAdisver>() {
					public Select generate(BuildAdisver t) {
						Select select = Select.selectFrom(BUILD_ADISVER_TABLE)
								.where(and(BUILD_ADISVER_TABLE.ID.eq(t.getId()),
										BUILD_ADISVER_TABLE.NAME.eq(t.getName()),
										BUILD_ADISVER_TABLE.STARS.eq(t.getStars()),
										BUILD_ADISVER_TABLE.JOB_NUMBER.eq(t.getJobNumber()),
										BUILD_ADISVER_TABLE.WORK_YEARS.eq(t.getWorkYears()),
										BUILD_ADISVER_TABLE.ADISVER_PHONE.eq(t.getAdisverPhone()),
										BUILD_ADISVER_TABLE.ADISVER_RESUME.eq(t.getAdisverResume()),
										BUILD_ADISVER_TABLE.ADISVER_IMG.eq(t.getAdisverImg()),
										BUILD_ADISVER_TABLE.SERVICE_EXPERIENCE.eq(t.getServiceExperience()),
										BUILD_ADISVER_TABLE.SERVICE_TYPE.eq(t.getServiceType()),
										BUILD_ADISVER_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
										BUILD_ADISVER_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
										BUILD_ADISVER_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
										BUILD_ADISVER_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
										BUILD_ADISVER_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
						return TinyDSLUtil.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<BuildAdisver> buildAdisver) {
		if (CollectionUtil.isEmpty(buildAdisver)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, buildAdisver,
				new InsertGenerateCallback<BuildAdisver>() {

					public Insert generate(BuildAdisver t) {
						return insertInto(BUILD_ADISVER_TABLE).values(BUILD_ADISVER_TABLE.ID.value(t.getId()),
								BUILD_ADISVER_TABLE.NAME.value(t.getName()),
								BUILD_ADISVER_TABLE.STARS.value(t.getStars()),
								BUILD_ADISVER_TABLE.JOB_NUMBER.value(t.getJobNumber()),
								BUILD_ADISVER_TABLE.WORK_YEARS.value(t.getWorkYears()),
								BUILD_ADISVER_TABLE.ADISVER_PHONE.value(t.getAdisverPhone()),
								BUILD_ADISVER_TABLE.ADISVER_RESUME.value(t.getAdisverResume()),
								BUILD_ADISVER_TABLE.ADISVER_IMG.value(t.getAdisverImg()),
								BUILD_ADISVER_TABLE.SERVICE_EXPERIENCE.value(t.getServiceExperience()),
								BUILD_ADISVER_TABLE.SERVICE_TYPE.value(t.getServiceType()),
								BUILD_ADISVER_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_ADISVER_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_ADISVER_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								BUILD_ADISVER_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								BUILD_ADISVER_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<BuildAdisver> buildAdisvers) {
		return batchInsert(true, buildAdisvers);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<BuildAdisver> buildAdisver) {
		if (CollectionUtil.isEmpty(buildAdisver)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(buildAdisver, new UpdateGenerateCallback<BuildAdisver>() {
			public Update generate(BuildAdisver t) {
				return update(BUILD_ADISVER_TABLE)
						.set(BUILD_ADISVER_TABLE.NAME.value(t.getName()), BUILD_ADISVER_TABLE.STARS.value(t.getStars()),
								BUILD_ADISVER_TABLE.JOB_NUMBER.value(t.getJobNumber()),
								BUILD_ADISVER_TABLE.WORK_YEARS.value(t.getWorkYears()),
								BUILD_ADISVER_TABLE.ADISVER_PHONE.value(t.getAdisverPhone()),
								BUILD_ADISVER_TABLE.ADISVER_RESUME.value(t.getAdisverResume()),
								BUILD_ADISVER_TABLE.ADISVER_IMG.value(t.getAdisverImg()),
								BUILD_ADISVER_TABLE.SERVICE_EXPERIENCE.value(t.getServiceExperience()),
								BUILD_ADISVER_TABLE.SERVICE_TYPE.value(t.getServiceType()),
								BUILD_ADISVER_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_ADISVER_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_ADISVER_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								BUILD_ADISVER_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								BUILD_ADISVER_TABLE.EXT_FIELD_5.value(t.getExtField_5())

						).where(BUILD_ADISVER_TABLE.ID.eq(t.getId()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<BuildAdisver> buildAdisver) {
		if (CollectionUtil.isEmpty(buildAdisver)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(buildAdisver, new DeleteGenerateCallback<BuildAdisver>() {
			public Delete generate(BuildAdisver t) {
				return delete(BUILD_ADISVER_TABLE).where(and(BUILD_ADISVER_TABLE.ID.eq(t.getId()),
						BUILD_ADISVER_TABLE.NAME.eq(t.getName()), BUILD_ADISVER_TABLE.STARS.eq(t.getStars()),
						BUILD_ADISVER_TABLE.JOB_NUMBER.eq(t.getJobNumber()),
						BUILD_ADISVER_TABLE.WORK_YEARS.eq(t.getWorkYears()),
						BUILD_ADISVER_TABLE.ADISVER_PHONE.eq(t.getAdisverPhone()),
						BUILD_ADISVER_TABLE.ADISVER_RESUME.eq(t.getAdisverResume()),
						BUILD_ADISVER_TABLE.ADISVER_IMG.eq(t.getAdisverImg()),
						BUILD_ADISVER_TABLE.SERVICE_EXPERIENCE.eq(t.getServiceExperience()),
						BUILD_ADISVER_TABLE.SERVICE_TYPE.eq(t.getServiceType()),
						BUILD_ADISVER_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						BUILD_ADISVER_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						BUILD_ADISVER_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						BUILD_ADISVER_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						BUILD_ADISVER_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<BuildAdisver> buildAdisver) {
		if (CollectionUtil.isEmpty(buildAdisver)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, buildAdisver, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(BUILD_ADISVER_TABLE)
						.values(BUILD_ADISVER_TABLE.NAME.value(new JdbcNamedParameter("name")),
								BUILD_ADISVER_TABLE.STARS.value(new JdbcNamedParameter("stars")),
								BUILD_ADISVER_TABLE.JOB_NUMBER.value(new JdbcNamedParameter("jobNumber")),
								BUILD_ADISVER_TABLE.WORK_YEARS.value(new JdbcNamedParameter("workYears")),
								BUILD_ADISVER_TABLE.ADISVER_PHONE.value(new JdbcNamedParameter("adisverPhone")),
								BUILD_ADISVER_TABLE.ADISVER_RESUME.value(new JdbcNamedParameter("adisverResume")),
								BUILD_ADISVER_TABLE.ADISVER_IMG.value(new JdbcNamedParameter("adisverImg")),
								BUILD_ADISVER_TABLE.SERVICE_EXPERIENCE
										.value(new JdbcNamedParameter("serviceExperience")),
								BUILD_ADISVER_TABLE.SERVICE_TYPE.value(new JdbcNamedParameter("serviceType")),
								BUILD_ADISVER_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
								BUILD_ADISVER_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
								BUILD_ADISVER_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
								BUILD_ADISVER_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
								BUILD_ADISVER_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<BuildAdisver> buildAdisver) {
		if (CollectionUtil.isEmpty(buildAdisver)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(buildAdisver, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(BUILD_ADISVER_TABLE).set(BUILD_ADISVER_TABLE.NAME.value(new JdbcNamedParameter("name")),
						BUILD_ADISVER_TABLE.STARS.value(new JdbcNamedParameter("stars")),
						BUILD_ADISVER_TABLE.JOB_NUMBER.value(new JdbcNamedParameter("jobNumber")),
						BUILD_ADISVER_TABLE.WORK_YEARS.value(new JdbcNamedParameter("workYears")),
						BUILD_ADISVER_TABLE.ADISVER_PHONE.value(new JdbcNamedParameter("adisverPhone")),
						BUILD_ADISVER_TABLE.ADISVER_RESUME.value(new JdbcNamedParameter("adisverResume")),
						BUILD_ADISVER_TABLE.ADISVER_IMG.value(new JdbcNamedParameter("adisverImg")),
						BUILD_ADISVER_TABLE.SERVICE_EXPERIENCE.value(new JdbcNamedParameter("serviceExperience")),
						BUILD_ADISVER_TABLE.SERVICE_TYPE.value(new JdbcNamedParameter("serviceType")),
						BUILD_ADISVER_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
						BUILD_ADISVER_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
						BUILD_ADISVER_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
						BUILD_ADISVER_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
						BUILD_ADISVER_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				).where(BUILD_ADISVER_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<BuildAdisver> buildAdisver) {
		if (CollectionUtil.isEmpty(buildAdisver)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(buildAdisver, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(BUILD_ADISVER_TABLE)
						.where(and(BUILD_ADISVER_TABLE.NAME.eq(new JdbcNamedParameter("name")),
								BUILD_ADISVER_TABLE.STARS.eq(new JdbcNamedParameter("stars")),
								BUILD_ADISVER_TABLE.JOB_NUMBER.eq(new JdbcNamedParameter("jobNumber")),
								BUILD_ADISVER_TABLE.WORK_YEARS.eq(new JdbcNamedParameter("workYears")),
								BUILD_ADISVER_TABLE.ADISVER_PHONE.eq(new JdbcNamedParameter("adisverPhone")),
								BUILD_ADISVER_TABLE.ADISVER_RESUME.eq(new JdbcNamedParameter("adisverResume")),
								BUILD_ADISVER_TABLE.ADISVER_IMG.eq(new JdbcNamedParameter("adisverImg")),
								BUILD_ADISVER_TABLE.SERVICE_EXPERIENCE.eq(new JdbcNamedParameter("serviceExperience")),
								BUILD_ADISVER_TABLE.SERVICE_TYPE.eq(new JdbcNamedParameter("serviceType")),
								BUILD_ADISVER_TABLE.EXT_FIELD_1.eq(new JdbcNamedParameter("extField1")),
								BUILD_ADISVER_TABLE.EXT_FIELD_2.eq(new JdbcNamedParameter("extField2")),
								BUILD_ADISVER_TABLE.EXT_FIELD_3.eq(new JdbcNamedParameter("extField3")),
								BUILD_ADISVER_TABLE.EXT_FIELD_4.eq(new JdbcNamedParameter("extField4")),
								BUILD_ADISVER_TABLE.EXT_FIELD_5.eq(new JdbcNamedParameter("extField5"))

				));
			}
		});
	}

	public int[] preparedBatchInsert(List<BuildAdisver> buildAdisver) {
		return preparedBatchInsert(true, buildAdisver);
	}

	@Override
	public List<BuildAdisver> getAdisverByName(final String name) {
		BuildAdisver buildAdisver = new BuildAdisver();
		return getDslTemplate().query(buildAdisver, new SelectGenerateCallback<BuildAdisver>(){

			@Override
			public Select generate(BuildAdisver t) {
				return Select.selectFrom(BUILD_ADISVER_TABLE).where(BUILD_ADISVER_TABLE.NAME.like(name));
			}});
	}

}
