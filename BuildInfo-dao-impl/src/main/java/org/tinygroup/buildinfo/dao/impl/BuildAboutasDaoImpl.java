
package org.tinygroup.buildinfo.dao.impl;

import static org.tinygroup.buildinfo.dao.inter.constant.BuildAboutasTable.BUILD_ABOUTAS_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;

import java.io.Serializable;
import java.util.List;

import org.tinygroup.buildinfo.dao.inter.BuildAboutasDao;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildAboutas;
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
public class BuildAboutasDaoImpl extends TinyDslDaoSupport implements BuildAboutasDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public BuildAboutas add(BuildAboutas buildAboutas) {
		return getDslTemplate().insertAndReturnKey(buildAboutas, new InsertGenerateCallback<BuildAboutas>() {
			public Insert generate(BuildAboutas t) {
				Insert insert = insertInto(BUILD_ABOUTAS_TABLE).values(BUILD_ABOUTAS_TABLE.ID.value(t.getId()),
						BUILD_ABOUTAS_TABLE.ABOUTAS_CONTENT.value(t.getAboutasContent()),
						BUILD_ABOUTAS_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						BUILD_ABOUTAS_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						BUILD_ABOUTAS_TABLE.EXT_FIELD_3.value(t.getExtField_3())

				);
				return insert;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(BuildAboutas buildAboutas) {
		if (buildAboutas == null || buildAboutas.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(buildAboutas, new UpdateGenerateCallback<BuildAboutas>() {
			public Update generate(BuildAboutas t) {
				Update update = update(BUILD_ABOUTAS_TABLE)
						.set(BUILD_ABOUTAS_TABLE.ABOUTAS_CONTENT.value(t.getAboutasContent()),
								BUILD_ABOUTAS_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_ABOUTAS_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_ABOUTAS_TABLE.EXT_FIELD_3.value(t.getExtField_3()))
						.where(BUILD_ABOUTAS_TABLE.ID.eq(t.getId()));
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
				return delete(BUILD_ABOUTAS_TABLE).where(BUILD_ABOUTAS_TABLE.ID.eq(pk));
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
				return delete(BUILD_ABOUTAS_TABLE).where(BUILD_ABOUTAS_TABLE.ID.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public BuildAboutas getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, BuildAboutas.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(BUILD_ABOUTAS_TABLE).where(BUILD_ABOUTAS_TABLE.ID.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<BuildAboutas> query(BuildAboutas buildAboutas, final OrderBy... orderArgs) {
		if (buildAboutas == null) {
			buildAboutas = new BuildAboutas();
		}
		return getDslTemplate().query(buildAboutas, new SelectGenerateCallback<BuildAboutas>() {
			@SuppressWarnings("rawtypes")
			public Select generate(BuildAboutas t) {
				Select select = selectFrom(BUILD_ABOUTAS_TABLE).where(and(BUILD_ABOUTAS_TABLE.ID.eq(t.getId()),
						BUILD_ABOUTAS_TABLE.ABOUTAS_CONTENT.eq(t.getAboutasContent()),
						BUILD_ABOUTAS_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						BUILD_ABOUTAS_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						BUILD_ABOUTAS_TABLE.EXT_FIELD_3.eq(t.getExtField_3())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<BuildAboutas> queryPager(int start, int limit, BuildAboutas buildAboutas, final OrderBy... orderArgs) {
		if (buildAboutas == null) {
			buildAboutas = new BuildAboutas();
		}
		return getDslTemplate().queryPager(start, limit, buildAboutas, false,
				new SelectGenerateCallback<BuildAboutas>() {
					public Select generate(BuildAboutas t) {
						Select select = Select.selectFrom(BUILD_ABOUTAS_TABLE)
								.where(and(BUILD_ABOUTAS_TABLE.ID.eq(t.getId()),
										BUILD_ABOUTAS_TABLE.ABOUTAS_CONTENT.eq(t.getAboutasContent()),
										BUILD_ABOUTAS_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
										BUILD_ABOUTAS_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
										BUILD_ABOUTAS_TABLE.EXT_FIELD_3.eq(t.getExtField_3())

				));
						return TinyDSLUtil.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<BuildAboutas> buildAboutas) {
		if (CollectionUtil.isEmpty(buildAboutas)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, buildAboutas,
				new InsertGenerateCallback<BuildAboutas>() {

					public Insert generate(BuildAboutas t) {
						return insertInto(BUILD_ABOUTAS_TABLE).values(BUILD_ABOUTAS_TABLE.ID.value(t.getId()),
								BUILD_ABOUTAS_TABLE.ABOUTAS_CONTENT.value(t.getAboutasContent()),
								BUILD_ABOUTAS_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_ABOUTAS_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_ABOUTAS_TABLE.EXT_FIELD_3.value(t.getExtField_3())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<BuildAboutas> buildAboutass) {
		return batchInsert(true, buildAboutass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<BuildAboutas> buildAboutas) {
		if (CollectionUtil.isEmpty(buildAboutas)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(buildAboutas, new UpdateGenerateCallback<BuildAboutas>() {
			public Update generate(BuildAboutas t) {
				return update(BUILD_ABOUTAS_TABLE).set(BUILD_ABOUTAS_TABLE.ABOUTAS_CONTENT.value(t.getAboutasContent()),
						BUILD_ABOUTAS_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						BUILD_ABOUTAS_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						BUILD_ABOUTAS_TABLE.EXT_FIELD_3.value(t.getExtField_3())

				).where(BUILD_ABOUTAS_TABLE.ID.eq(t.getId()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<BuildAboutas> buildAboutas) {
		if (CollectionUtil.isEmpty(buildAboutas)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(buildAboutas, new DeleteGenerateCallback<BuildAboutas>() {
			public Delete generate(BuildAboutas t) {
				return delete(BUILD_ABOUTAS_TABLE).where(and(BUILD_ABOUTAS_TABLE.ID.eq(t.getId()),
						BUILD_ABOUTAS_TABLE.ABOUTAS_CONTENT.eq(t.getAboutasContent()),
						BUILD_ABOUTAS_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						BUILD_ABOUTAS_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						BUILD_ABOUTAS_TABLE.EXT_FIELD_3.eq(t.getExtField_3())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<BuildAboutas> buildAboutas) {
		if (CollectionUtil.isEmpty(buildAboutas)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, buildAboutas, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(BUILD_ABOUTAS_TABLE).values(
						BUILD_ABOUTAS_TABLE.ABOUTAS_CONTENT.value(new JdbcNamedParameter("aboutasContent")),
						BUILD_ABOUTAS_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
						BUILD_ABOUTAS_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
						BUILD_ABOUTAS_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<BuildAboutas> buildAboutas) {
		if (CollectionUtil.isEmpty(buildAboutas)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(buildAboutas, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(BUILD_ABOUTAS_TABLE)
						.set(BUILD_ABOUTAS_TABLE.ABOUTAS_CONTENT.value(new JdbcNamedParameter("aboutasContent")),
								BUILD_ABOUTAS_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
								BUILD_ABOUTAS_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
								BUILD_ABOUTAS_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3"))

						).where(BUILD_ABOUTAS_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<BuildAboutas> buildAboutas) {
		if (CollectionUtil.isEmpty(buildAboutas)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(buildAboutas, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(BUILD_ABOUTAS_TABLE)
						.where(and(BUILD_ABOUTAS_TABLE.ABOUTAS_CONTENT.eq(new JdbcNamedParameter("aboutasContent")),
								BUILD_ABOUTAS_TABLE.EXT_FIELD_1.eq(new JdbcNamedParameter("extField1")),
								BUILD_ABOUTAS_TABLE.EXT_FIELD_2.eq(new JdbcNamedParameter("extField2")),
								BUILD_ABOUTAS_TABLE.EXT_FIELD_3.eq(new JdbcNamedParameter("extField3"))

				));
			}
		});
	}

	public int[] preparedBatchInsert(List<BuildAboutas> buildAboutas) {
		return preparedBatchInsert(true, buildAboutas);
	}

}
