
package org.tinygroup.buildinfo.dao.impl;

import static org.tinygroup.buildinfo.dao.inter.constant.BuildServicecontentTable.BUILD_SERVICECONTENT_TABLE;
import static org.tinygroup.buildinfo.dao.inter.constant.BuildServicetypeTable.BUILD_SERVICETYPE_TABLE;
import static org.tinygroup.buildinfo.dao.inter.constant.TsysDepTable.TSYS_DEP_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.select;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;
import static org.tinygroup.tinysqldsl.formitem.SubSelect.subSelect;

import java.io.Serializable;
import java.util.List;

import org.tinygroup.buildinfo.dao.inter.BuildServicetypeDao;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildServicecontent;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildServicetype;
import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
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
public class BuildServicetypeDaoImpl extends TinyDslDaoSupport implements BuildServicetypeDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public BuildServicetype add(BuildServicetype buildServicetype) {
		return getDslTemplate().insertAndReturnKey(buildServicetype, new InsertGenerateCallback<BuildServicetype>() {
			public Insert generate(BuildServicetype t) {
				Insert insert = insertInto(BUILD_SERVICETYPE_TABLE).values(BUILD_SERVICETYPE_TABLE.ID.value(t.getId()),
						BUILD_SERVICETYPE_TABLE.SERVICE_CODE.value(t.getServiceCode()),
						BUILD_SERVICETYPE_TABLE.SERVICE_NAME.value(t.getServiceName()),
						BUILD_SERVICETYPE_TABLE.PARENT_SERVICE.value(t.getParentService()),
						BUILD_SERVICETYPE_TABLE.REMARK.value(t.getRemark()),
						BUILD_SERVICETYPE_TABLE.SERVICE_ICON.value(t.getServiceIcon()),
						BUILD_SERVICETYPE_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						BUILD_SERVICETYPE_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						BUILD_SERVICETYPE_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						BUILD_SERVICETYPE_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						BUILD_SERVICETYPE_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
				return insert;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(BuildServicetype buildServicetype) {
		if (buildServicetype == null || buildServicetype.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(buildServicetype, new UpdateGenerateCallback<BuildServicetype>() {
			public Update generate(BuildServicetype t) {
				Update update = update(BUILD_SERVICETYPE_TABLE)
						.set(BUILD_SERVICETYPE_TABLE.SERVICE_NAME.value(t.getServiceName()),
								BUILD_SERVICETYPE_TABLE.SERVICE_CODE.value(t.getServiceCode()),
								BUILD_SERVICETYPE_TABLE.PARENT_SERVICE.value(t.getParentService()),
								BUILD_SERVICETYPE_TABLE.SERVICE_ICON.value(t.getServiceIcon()),
								BUILD_SERVICETYPE_TABLE.REMARK.value(t.getRemark()),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_5.value(t.getExtField_5()))
						.where(BUILD_SERVICETYPE_TABLE.ID.eq(t.getId()));
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
				return delete(BUILD_SERVICETYPE_TABLE).where(BUILD_SERVICETYPE_TABLE.ID.eq(pk));
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
				return delete(BUILD_SERVICETYPE_TABLE).where(BUILD_SERVICETYPE_TABLE.ID.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public BuildServicetype getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, BuildServicetype.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(BUILD_SERVICETYPE_TABLE).where(BUILD_SERVICETYPE_TABLE.ID.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<BuildServicetype> query(BuildServicetype buildServicetype, final OrderBy... orderArgs) {
		if (buildServicetype == null) {
			buildServicetype = new BuildServicetype();
		}
		return getDslTemplate().query(buildServicetype, new SelectGenerateCallback<BuildServicetype>() {
			@SuppressWarnings("rawtypes")
			public Select generate(BuildServicetype t) {
				Select select = selectFrom(BUILD_SERVICETYPE_TABLE).where(and(BUILD_SERVICETYPE_TABLE.ID.eq(t.getId()),
						BUILD_SERVICETYPE_TABLE.SERVICE_CODE.eq(t.getServiceCode()),
						BUILD_SERVICETYPE_TABLE.SERVICE_NAME.eq(t.getServiceName()),
						BUILD_SERVICETYPE_TABLE.PARENT_SERVICE.eq(t.getParentService()),
						BUILD_SERVICETYPE_TABLE.SERVICE_ICON.eq(t.getServiceIcon()),
						BUILD_SERVICETYPE_TABLE.REMARK.eq(t.getRemark()),
						BUILD_SERVICETYPE_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						BUILD_SERVICETYPE_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						BUILD_SERVICETYPE_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						BUILD_SERVICETYPE_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						BUILD_SERVICETYPE_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<BuildServicetype> queryPager(int start, int limit, BuildServicetype buildServicetype,
			final OrderBy... orderArgs) {
		if (buildServicetype == null) {
			buildServicetype = new BuildServicetype();
		}
		return getDslTemplate().queryPager(start, limit, buildServicetype, false,
				new SelectGenerateCallback<BuildServicetype>() {
					public Select generate(BuildServicetype t) {
						Select select = Select.selectFrom(BUILD_SERVICETYPE_TABLE)
								.where(and(BUILD_SERVICETYPE_TABLE.ID.eq(t.getId()),
										BUILD_SERVICETYPE_TABLE.SERVICE_CODE.eq(t.getServiceCode()),
										BUILD_SERVICETYPE_TABLE.SERVICE_NAME.eq(t.getServiceName()),
										BUILD_SERVICETYPE_TABLE.PARENT_SERVICE.eq(t.getParentService()),
										BUILD_SERVICETYPE_TABLE.SERVICE_ICON.eq(t.getServiceIcon()),
										BUILD_SERVICETYPE_TABLE.REMARK.eq(t.getRemark()),
										BUILD_SERVICETYPE_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
										BUILD_SERVICETYPE_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
										BUILD_SERVICETYPE_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
										BUILD_SERVICETYPE_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
										BUILD_SERVICETYPE_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
						return TinyDSLUtil.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<BuildServicetype> buildServicetype) {
		if (CollectionUtil.isEmpty(buildServicetype)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, buildServicetype,
				new InsertGenerateCallback<BuildServicetype>() {

					public Insert generate(BuildServicetype t) {
						return insertInto(BUILD_SERVICETYPE_TABLE).values(BUILD_SERVICETYPE_TABLE.ID.value(t.getId()),
								BUILD_SERVICETYPE_TABLE.SERVICE_CODE.value(t.getServiceCode()),
								BUILD_SERVICETYPE_TABLE.SERVICE_NAME.value(t.getServiceName()),
								BUILD_SERVICETYPE_TABLE.PARENT_SERVICE.value(t.getParentService()),
								BUILD_SERVICETYPE_TABLE.SERVICE_ICON.value(t.getServiceIcon()),
								BUILD_SERVICETYPE_TABLE.REMARK.value(t.getRemark()),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<BuildServicetype> buildServicetypes) {
		return batchInsert(true, buildServicetypes);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<BuildServicetype> buildServicetype) {
		if (CollectionUtil.isEmpty(buildServicetype)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(buildServicetype, new UpdateGenerateCallback<BuildServicetype>() {
			public Update generate(BuildServicetype t) {
				return update(BUILD_SERVICETYPE_TABLE)
						.set(BUILD_SERVICETYPE_TABLE.SERVICE_NAME.value(t.getServiceName()),
								BUILD_SERVICETYPE_TABLE.SERVICE_CODE.value(t.getServiceCode()),
								BUILD_SERVICETYPE_TABLE.PARENT_SERVICE.value(t.getParentService()),
								BUILD_SERVICETYPE_TABLE.SERVICE_ICON.value(t.getServiceIcon()),
								BUILD_SERVICETYPE_TABLE.REMARK.value(t.getRemark()),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_5.value(t.getExtField_5())

						).where(BUILD_SERVICETYPE_TABLE.ID.eq(t.getId()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<BuildServicetype> buildServicetype) {
		if (CollectionUtil.isEmpty(buildServicetype)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(buildServicetype, new DeleteGenerateCallback<BuildServicetype>() {
			public Delete generate(BuildServicetype t) {
				return delete(BUILD_SERVICETYPE_TABLE).where(and(BUILD_SERVICETYPE_TABLE.ID.eq(t.getId()),
						BUILD_SERVICETYPE_TABLE.SERVICE_CODE.eq(t.getServiceCode()),
						BUILD_SERVICETYPE_TABLE.SERVICE_NAME.eq(t.getServiceName()),
						BUILD_SERVICETYPE_TABLE.PARENT_SERVICE.eq(t.getParentService()),
						BUILD_SERVICETYPE_TABLE.SERVICE_ICON.eq(t.getServiceIcon()),
						BUILD_SERVICETYPE_TABLE.REMARK.eq(t.getRemark()),
						BUILD_SERVICETYPE_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						BUILD_SERVICETYPE_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						BUILD_SERVICETYPE_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						BUILD_SERVICETYPE_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						BUILD_SERVICETYPE_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<BuildServicetype> buildServicetype) {
		if (CollectionUtil.isEmpty(buildServicetype)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, buildServicetype, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(BUILD_SERVICETYPE_TABLE).values(
						BUILD_SERVICETYPE_TABLE.SERVICE_CODE.value(new JdbcNamedParameter("serviceCode")),
						BUILD_SERVICETYPE_TABLE.SERVICE_NAME.value(new JdbcNamedParameter("serviceName")),
						BUILD_SERVICETYPE_TABLE.PARENT_SERVICE.value(new JdbcNamedParameter("parentService")),
						BUILD_SERVICETYPE_TABLE.SERVICE_ICON.value(new JdbcNamedParameter("serviceIcon")),
						BUILD_SERVICETYPE_TABLE.REMARK.value(new JdbcNamedParameter("remark")),
						BUILD_SERVICETYPE_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField_1")),
						BUILD_SERVICETYPE_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField_2")),
						BUILD_SERVICETYPE_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField_3")),
						BUILD_SERVICETYPE_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField_4")),
						BUILD_SERVICETYPE_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField_5"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<BuildServicetype> buildServicetype) {
		if (CollectionUtil.isEmpty(buildServicetype)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(buildServicetype, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(BUILD_SERVICETYPE_TABLE)
						.set(BUILD_SERVICETYPE_TABLE.SERVICE_NAME.value(new JdbcNamedParameter("serviceName")),
								BUILD_SERVICETYPE_TABLE.SERVICE_CODE.value(new JdbcNamedParameter("serviceCode")),
								BUILD_SERVICETYPE_TABLE.PARENT_SERVICE.value(new JdbcNamedParameter("parentService")),
								BUILD_SERVICETYPE_TABLE.SERVICE_ICON.value(new JdbcNamedParameter("serviceIcon")),
								BUILD_SERVICETYPE_TABLE.REMARK.value(new JdbcNamedParameter("remark")),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField_1")),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField_2")),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField_3")),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField_4")),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField_5"))

						).where(BUILD_SERVICETYPE_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<BuildServicetype> buildServicetype) {
		if (CollectionUtil.isEmpty(buildServicetype)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(buildServicetype, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(BUILD_SERVICETYPE_TABLE)
						.where(and(BUILD_SERVICETYPE_TABLE.SERVICE_CODE.eq(new JdbcNamedParameter("serviceCode")),
								BUILD_SERVICETYPE_TABLE.SERVICE_NAME.eq(new JdbcNamedParameter("serviceName")),
								BUILD_SERVICETYPE_TABLE.PARENT_SERVICE.eq(new JdbcNamedParameter("parentService")),
								BUILD_SERVICETYPE_TABLE.SERVICE_ICON.eq(new JdbcNamedParameter("serviceIcon")),
								BUILD_SERVICETYPE_TABLE.REMARK.eq(new JdbcNamedParameter("remark")),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_1.eq(new JdbcNamedParameter("extField_1")),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_2.eq(new JdbcNamedParameter("extField_2")),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_3.eq(new JdbcNamedParameter("extField_3")),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_4.eq(new JdbcNamedParameter("extField_4")),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_5.eq(new JdbcNamedParameter("extField_5"))

				));
			}
		});
	}

	public int[] preparedBatchInsert(List<BuildServicetype> buildServicetype) {
		return preparedBatchInsert(true, buildServicetype);
	}

	@Override
	public List<BuildServicetype> getServicetypeByCode(String serviceCode) {
		BuildServicetype buildServicetype = new BuildServicetype();
		buildServicetype.setServiceCode(serviceCode);
		return getDslTemplate().query(buildServicetype, new SelectGenerateCallback<BuildServicetype>(){

			@Override
			public Select generate(BuildServicetype t) {
				return Select.selectFrom(BUILD_SERVICETYPE_TABLE).where(BUILD_SERVICETYPE_TABLE.SERVICE_CODE.eq(t.getServiceCode()));
			}});
	}

	@Override
	public List<BuildServicetype> checkServicetypeExists(BuildServicetype buildServicetype) {
		if(buildServicetype == null){
			buildServicetype = new BuildServicetype();
		}
		return getDslTemplate().query(buildServicetype, new SelectGenerateCallback<BuildServicetype>(){

			@Override
			public Select generate(BuildServicetype t) {
				// TODO Auto-generated method stub
				return Select.selectFrom(BUILD_SERVICETYPE_TABLE).where(
						BUILD_SERVICETYPE_TABLE.SERVICE_CODE.eq(t.getServiceCode())
						);
			}});
	}

	@Override
	public List getServicetypeTreeData(TreeData treeData) {
		// TODO Auto-generated method stub
		return getDslTemplate().query(treeData,new SelectGenerateCallback<TreeData>(){

			@Override
			public Select generate(TreeData t) {
				Select select = select(BUILD_SERVICETYPE_TABLE.SERVICE_CODE.as("id"),
						BUILD_SERVICETYPE_TABLE.PARENT_SERVICE.as("pid"),
						BUILD_SERVICETYPE_TABLE.SERVICE_NAME.as("name")).from(BUILD_SERVICETYPE_TABLE)
						.where(and(
								BUILD_SERVICETYPE_TABLE.SERVICE_CODE.eq(t.getId()),
								BUILD_SERVICETYPE_TABLE.PARENT_SERVICE.eq(t.getpId()),
								BUILD_SERVICETYPE_TABLE.SERVICE_NAME.eq(t.getName())));
				return select;
			}});
	}

	@Override
	public int[] batchDeleteByServiceCode(List<BuildServicetype> buildServicetype) {
		if (CollectionUtil.isEmpty(buildServicetype)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(buildServicetype, new DeleteGenerateCallback<BuildServicetype>() {
			public Delete generate(BuildServicetype t) {
				return delete(BUILD_SERVICETYPE_TABLE).where(
						BUILD_SERVICETYPE_TABLE.SERVICE_CODE.eq(t.getServiceCode()
				));
			}
		});
	}

	@Override
	public int editByCode(BuildServicetype buildServicetype) {
		if (buildServicetype == null || buildServicetype.getServiceCode() == null) {
			return 0;
		}
		return getDslTemplate().update(buildServicetype, new UpdateGenerateCallback<BuildServicetype>() {
			public Update generate(BuildServicetype t) {
				Update update = update(BUILD_SERVICETYPE_TABLE)
						.set(BUILD_SERVICETYPE_TABLE.SERVICE_NAME.value(t.getServiceName()),
								BUILD_SERVICETYPE_TABLE.PARENT_SERVICE.value(t.getParentService()),
								BUILD_SERVICETYPE_TABLE.SERVICE_ICON.value(t.getServiceIcon()),
								BUILD_SERVICETYPE_TABLE.REMARK.value(t.getRemark()),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								BUILD_SERVICETYPE_TABLE.EXT_FIELD_5.value(t.getExtField_5()))
						.where(BUILD_SERVICETYPE_TABLE.SERVICE_CODE.eq(t.getServiceCode()));
				return update;
			}
		});
	}

	@Override
	public List<BuildServicetype> getServiceTypeLikeName(final String serviceName) {
		BuildServicetype buildServiceType = new BuildServicetype();
		return getDslTemplate().query(buildServiceType, new SelectGenerateCallback<BuildServicetype>(){

			@Override
			public Select generate(BuildServicetype t) {
				return selectFrom(BUILD_SERVICETYPE_TABLE).where(BUILD_SERVICETYPE_TABLE.SERVICE_NAME.like(serviceName));
			}});
	}

}
