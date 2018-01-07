/**
 *  Copyright (c) 1997-2013, www.tinygroup.org (luo_guo@icloud.com).
 *
 *  Licensed under the GPL, Version 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.gnu.org/licenses/gpl.html
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.tinygroup.buildinfo.dao.impl;

import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;
import static org.tinygroup.buildinfo.dao.inter.constant.TsysDepTable.*;
import static org.tinygroup.tinysqldsl.Select.*;
import static org.tinygroup.tinysqldsl.Insert.*;
import static org.tinygroup.tinysqldsl.Delete.*;
import static org.tinygroup.tinysqldsl.Update.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.tinygroup.tinysqldsl.Delete;
import org.tinygroup.tinysqldsl.Insert;
import org.tinygroup.tinysqldsl.Select;
import org.tinygroup.tinysqldsl.Update;
import org.tinygroup.tinysqldsl.Pager;

import org.tinygroup.commons.tools.CollectionUtil;
import org.tinygroup.tinysqldsl.expression.JdbcNamedParameter;
import org.tinygroup.tinysqldsl.select.OrderByElement;

import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysDep;
import org.tinygroup.buildinfo.dao.inter.TsysDepDao;

import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.jdbctemplatedslsession.daosupport.TinyDslDaoSupport;
import org.tinygroup.jdbctemplatedslsession.callback.DeleteGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.InsertGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.NoParamDeleteGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.NoParamInsertGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.NoParamUpdateGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.SelectGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.UpdateGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.util.TinyDSLUtil;

/**
 * <!-- begin-user-doc --> 
 * <!-- end-user-doc -->
 */
public class TsysDepDaoImpl extends TinyDslDaoSupport implements TsysDepDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysDep add(TsysDep tsysDep) {
		return getDslTemplate().insertAndReturnKey(tsysDep,
				new InsertGenerateCallback<TsysDep>() {
					public Insert generate(TsysDep t) {
						Insert insert = insertInto(TSYS_DEP_TABLE).values(
								TSYS_DEP_TABLE.DEP_CODE.value(t.getDepCode()),
								TSYS_DEP_TABLE.DEP_NAME.value(t.getDepName()),
								TSYS_DEP_TABLE.SHORT_NAME.value(t
										.getShortName()),
								TSYS_DEP_TABLE.PARENT_CODE.value(t
										.getParentCode()),
								TSYS_DEP_TABLE.BRANCH_CODE.value(t
										.getBranchCode()),
								TSYS_DEP_TABLE.DEP_PATH.value(t.getDepPath()),
								TSYS_DEP_TABLE.REMARK.value(t.getRemark()),
								TSYS_DEP_TABLE.EXT_FIELD_1.value(t
										.getExtField1()),
								TSYS_DEP_TABLE.EXT_FIELD_2.value(t
										.getExtField2()),
								TSYS_DEP_TABLE.EXT_FIELD_3.value(t
										.getExtField3())

						);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TsysDep tsysDep) {
		if (tsysDep == null || tsysDep.getDepCode() == null) {
			return 0;
		}
		return getDslTemplate().update(tsysDep,
				new UpdateGenerateCallback<TsysDep>() {
					public Update generate(TsysDep t) {
						Update update = update(TSYS_DEP_TABLE).set(
								TSYS_DEP_TABLE.DEP_NAME.value(t.getDepName()),
								TSYS_DEP_TABLE.SHORT_NAME.value(t
										.getShortName()),
								TSYS_DEP_TABLE.PARENT_CODE.value(t
										.getParentCode()),
								TSYS_DEP_TABLE.BRANCH_CODE.value(t
										.getBranchCode()),
								TSYS_DEP_TABLE.DEP_PATH.value(t.getDepPath()),
								TSYS_DEP_TABLE.REMARK.value(t.getRemark()),
								TSYS_DEP_TABLE.EXT_FIELD_1.value(t
										.getExtField1()),
								TSYS_DEP_TABLE.EXT_FIELD_2.value(t
										.getExtField2()),
								TSYS_DEP_TABLE.EXT_FIELD_3.value(t
										.getExtField3())).where(
								TSYS_DEP_TABLE.DEP_CODE.eq(t.getDepCode()));
						return update;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int deleteByKey(String pk) {
		if (pk == null) {
			return 0;
		}
		return getDslTemplate().deleteByKey(pk,
				new DeleteGenerateCallback<Serializable>() {
					public Delete generate(Serializable pk) {
						return delete(TSYS_DEP_TABLE).where(
								TSYS_DEP_TABLE.DEP_CODE.eq(pk));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int deleteByKeys(String... pks) {
		if (pks == null || pks.length == 0) {
			return 0;
		}
		return getDslTemplate().deleteByKeys(
				new DeleteGenerateCallback<Serializable[]>() {
					public Delete generate(Serializable[] t) {
						return delete(TSYS_DEP_TABLE).where(
								TSYS_DEP_TABLE.DEP_CODE.in(t));
					}
				}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysDep getByKey(String pk) {
		return getDslTemplate().getByKey(pk, TsysDep.class,
				new SelectGenerateCallback<Serializable>() {

					@SuppressWarnings("rawtypes")
					public Select generate(Serializable t) {
						return selectFrom(TSYS_DEP_TABLE).where(
								TSYS_DEP_TABLE.DEP_CODE.eq(t));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TsysDep> query(TsysDep tsysDep, final OrderBy... orderArgs) {
		if (tsysDep == null) {
			tsysDep = new TsysDep();
		}
		return getDslTemplate().query(tsysDep,
				new SelectGenerateCallback<TsysDep>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysDep t) {
						Select select = selectFrom(TSYS_DEP_TABLE)
								.where(and(
										TSYS_DEP_TABLE.DEP_CODE.eq(t
												.getDepCode()),
										TSYS_DEP_TABLE.DEP_NAME.eq(t
												.getDepName()),
										TSYS_DEP_TABLE.SHORT_NAME.eq(t
												.getShortName()),
										TSYS_DEP_TABLE.PARENT_CODE.eq(t
												.getParentCode()),
										TSYS_DEP_TABLE.BRANCH_CODE.eq(t
												.getBranchCode()),
										TSYS_DEP_TABLE.DEP_PATH.eq(t
												.getDepPath()),
										TSYS_DEP_TABLE.REMARK.eq(t.getRemark()),
										TSYS_DEP_TABLE.EXT_FIELD_1.eq(t
												.getExtField1()),
										TSYS_DEP_TABLE.EXT_FIELD_2.eq(t
												.getExtField2()),
										TSYS_DEP_TABLE.EXT_FIELD_3.eq(t
												.getExtField3())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TsysDep> queryPager(int start, int limit, TsysDep tsysDep,
			final OrderBy... orderArgs) {
		if (tsysDep == null) {
			tsysDep = new TsysDep();
		}
		return getDslTemplate().queryPager(start, limit, tsysDep, false,
				new SelectGenerateCallback<TsysDep>() {
					public Select generate(TsysDep t) {
						Select select = Select
								.selectFrom(TSYS_DEP_TABLE)
								.where(and(
										TSYS_DEP_TABLE.DEP_CODE.eq(t
												.getDepCode()),
										TSYS_DEP_TABLE.DEP_NAME.eq(t
												.getDepName()),
										TSYS_DEP_TABLE.SHORT_NAME.eq(t
												.getShortName()),
										TSYS_DEP_TABLE.PARENT_CODE.eq(t
												.getParentCode()),
										TSYS_DEP_TABLE.BRANCH_CODE.eq(t
												.getBranchCode()),
										TSYS_DEP_TABLE.DEP_PATH.eq(t
												.getDepPath()),
										TSYS_DEP_TABLE.REMARK.eq(t.getRemark()),
										TSYS_DEP_TABLE.EXT_FIELD_1.eq(t
												.getExtField1()),
										TSYS_DEP_TABLE.EXT_FIELD_2.eq(t
												.getExtField2()),
										TSYS_DEP_TABLE.EXT_FIELD_3.eq(t
												.getExtField3())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<TsysDep> tsysDep) {
		if (CollectionUtil.isEmpty(tsysDep)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysDep,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_DEP_TABLE)
								.values(TSYS_DEP_TABLE.DEP_NAME
										.value(new JdbcNamedParameter("depName")),
										TSYS_DEP_TABLE.SHORT_NAME
												.value(new JdbcNamedParameter(
														"shortName")),
										TSYS_DEP_TABLE.PARENT_CODE
												.value(new JdbcNamedParameter(
														"parentCode")),
										TSYS_DEP_TABLE.BRANCH_CODE
												.value(new JdbcNamedParameter(
														"branchCode")),
										TSYS_DEP_TABLE.DEP_PATH
												.value(new JdbcNamedParameter(
														"depPath")),
										TSYS_DEP_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark")),
										TSYS_DEP_TABLE.EXT_FIELD_1
												.value(new JdbcNamedParameter(
														"extField1")),
										TSYS_DEP_TABLE.EXT_FIELD_2
												.value(new JdbcNamedParameter(
														"extField2")),
										TSYS_DEP_TABLE.EXT_FIELD_3
												.value(new JdbcNamedParameter(
														"extField3"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TsysDep> tsysDeps) {
		return batchInsert(true, tsysDeps);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TsysDep> tsysDep) {
		if (CollectionUtil.isEmpty(tsysDep)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysDep,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_DEP_TABLE)
								.set(TSYS_DEP_TABLE.DEP_NAME
										.value(new JdbcNamedParameter("depName")),
										TSYS_DEP_TABLE.SHORT_NAME
												.value(new JdbcNamedParameter(
														"shortName")),
										TSYS_DEP_TABLE.PARENT_CODE
												.value(new JdbcNamedParameter(
														"parentCode")),
										TSYS_DEP_TABLE.BRANCH_CODE
												.value(new JdbcNamedParameter(
														"branchCode")),
										TSYS_DEP_TABLE.DEP_PATH
												.value(new JdbcNamedParameter(
														"depPath")),
										TSYS_DEP_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark")),
										TSYS_DEP_TABLE.EXT_FIELD_1
												.value(new JdbcNamedParameter(
														"extField1")),
										TSYS_DEP_TABLE.EXT_FIELD_2
												.value(new JdbcNamedParameter(
														"extField2")),
										TSYS_DEP_TABLE.EXT_FIELD_3
												.value(new JdbcNamedParameter(
														"extField3"))

								).where(TSYS_DEP_TABLE.DEP_CODE
										.eq(new JdbcNamedParameter("depCode")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TsysDep> tsysDep) {
		if (CollectionUtil.isEmpty(tsysDep)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysDep,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_DEP_TABLE).where(
								and(TSYS_DEP_TABLE.DEP_NAME
										.eq(new JdbcNamedParameter("depName")),
										TSYS_DEP_TABLE.SHORT_NAME
												.eq(new JdbcNamedParameter(
														"shortName")),
										TSYS_DEP_TABLE.PARENT_CODE
												.eq(new JdbcNamedParameter(
														"parentCode")),
										TSYS_DEP_TABLE.BRANCH_CODE
												.eq(new JdbcNamedParameter(
														"branchCode")),
										TSYS_DEP_TABLE.DEP_PATH
												.eq(new JdbcNamedParameter(
														"depPath")),
										TSYS_DEP_TABLE.REMARK
												.eq(new JdbcNamedParameter(
														"remark")),
										TSYS_DEP_TABLE.EXT_FIELD_1
												.eq(new JdbcNamedParameter(
														"extField1")),
										TSYS_DEP_TABLE.EXT_FIELD_2
												.eq(new JdbcNamedParameter(
														"extField2")),
										TSYS_DEP_TABLE.EXT_FIELD_3
												.eq(new JdbcNamedParameter(
														"extField3"))

								));
					}
				});
	}

	public List<TreeData> getTreeData(TreeData t, final OrderBy... orderArgs) {
		if(t==null){
			t=new TreeData();
		}
		return getDslTemplate().query(t, new SelectGenerateCallback<TreeData>() {

			@SuppressWarnings("rawtypes")
			public Select generate(TreeData t) {
				Select select = select(TSYS_DEP_TABLE.DEP_CODE.as("id"),
						TSYS_DEP_TABLE.PARENT_CODE.as("pid"),
						TSYS_DEP_TABLE.DEP_NAME.as("name")).from(TSYS_DEP_TABLE)
						.where(and(
								TSYS_DEP_TABLE.DEP_NAME.eq(t.getName()),
								TSYS_DEP_TABLE.PARENT_CODE.eq(t.getpId()),
								TSYS_DEP_TABLE.DEP_CODE.eq(t.getId())));
				
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 *根据机构获取部门树
	 */
	public List<TreeData> getDepTreeByBranch(TreeData t) {
		if(t==null){
			t=new TreeData();
		}
		return getDslTemplate().query(t, new SelectGenerateCallback<TreeData>() {

			@SuppressWarnings("rawtypes")
			public Select generate(TreeData t) {
				Select select = select(TSYS_DEP_TABLE.DEP_CODE.as("id"),
						TSYS_DEP_TABLE.PARENT_CODE.as("pid"),
						TSYS_DEP_TABLE.DEP_NAME.as("name")).from(TSYS_DEP_TABLE)
						.where(and(
								TSYS_DEP_TABLE.DEP_NAME.eq(t.getName()),
								TSYS_DEP_TABLE.BRANCH_CODE.eq(t.getpId()),
								TSYS_DEP_TABLE.DEP_CODE.eq(t.getId())));
				return select;
			}
		});
	}

	/**
	 * @unmodifiable
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TsysDep> searchPager(int start, int limit, TsysDep tsysDep,
									 final OrderBy... orderArgs) {
		if (tsysDep == null) {
			tsysDep = new TsysDep();
		}
		return getDslTemplate().queryPager(start, limit, tsysDep, false,
				new SelectGenerateCallback<TsysDep>() {
					public Select generate(TsysDep t) {
						Select select = Select
								.selectFrom(TSYS_DEP_TABLE)
								.where(and(
										TSYS_DEP_TABLE.DEP_CODE.like(t
												.getDepCode()),
										TSYS_DEP_TABLE.DEP_NAME.like(t
												.getDepName()),
										TSYS_DEP_TABLE.SHORT_NAME.like(t
												.getShortName()),
										TSYS_DEP_TABLE.PARENT_CODE.like(t
												.getParentCode()),
										TSYS_DEP_TABLE.BRANCH_CODE.like(t
												.getBranchCode()),
										TSYS_DEP_TABLE.DEP_PATH.like(t
												.getDepPath()),
										TSYS_DEP_TABLE.REMARK.like(t.getRemark()),
										TSYS_DEP_TABLE.EXT_FIELD_1.like(t
												.getExtField1()),
										TSYS_DEP_TABLE.EXT_FIELD_2.like(t
												.getExtField2()),
										TSYS_DEP_TABLE.EXT_FIELD_3.like(t
												.getExtField3())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * 根据dep_code获取信息
	 *
	 * @param tsysDep
	 * @return
	 */
	public List checkExist(TsysDep tsysDep) {
		if (tsysDep == null) {
			tsysDep = new TsysDep();
		}
		return getDslTemplate().query(tsysDep,
				new SelectGenerateCallback<TsysDep>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysDep t) {
						Select select = selectFrom(TSYS_DEP_TABLE)
								.where(and(
										TSYS_DEP_TABLE.DEP_CODE.eq(t
												.getDepCode())
								));
						return select;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys,
									 List<TsysDep> tsysDep) {
		if (CollectionUtil.isEmpty(tsysDep)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysDep,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_DEP_TABLE)
								.values(TSYS_DEP_TABLE.DEP_NAME
												.value(new JdbcNamedParameter("depName")),
										TSYS_DEP_TABLE.SHORT_NAME
												.value(new JdbcNamedParameter(
														"shortName")),
										TSYS_DEP_TABLE.PARENT_CODE
												.value(new JdbcNamedParameter(
														"parentCode")),
										TSYS_DEP_TABLE.BRANCH_CODE
												.value(new JdbcNamedParameter(
														"branchCode")),
										TSYS_DEP_TABLE.DEP_PATH
												.value(new JdbcNamedParameter(
														"depPath")),
										TSYS_DEP_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark")),
										TSYS_DEP_TABLE.EXT_FIELD_1
												.value(new JdbcNamedParameter(
														"extField1")),
										TSYS_DEP_TABLE.EXT_FIELD_2
												.value(new JdbcNamedParameter(
														"extField2")),
										TSYS_DEP_TABLE.EXT_FIELD_3
												.value(new JdbcNamedParameter(
														"extField3"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TsysDep> tsysDep) {
		if (CollectionUtil.isEmpty(tsysDep)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysDep,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_DEP_TABLE)
								.set(TSYS_DEP_TABLE.DEP_NAME
												.value(new JdbcNamedParameter("depName")),
										TSYS_DEP_TABLE.SHORT_NAME
												.value(new JdbcNamedParameter(
														"shortName")),
										TSYS_DEP_TABLE.PARENT_CODE
												.value(new JdbcNamedParameter(
														"parentCode")),
										TSYS_DEP_TABLE.BRANCH_CODE
												.value(new JdbcNamedParameter(
														"branchCode")),
										TSYS_DEP_TABLE.DEP_PATH
												.value(new JdbcNamedParameter(
														"depPath")),
										TSYS_DEP_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark")),
										TSYS_DEP_TABLE.EXT_FIELD_1
												.value(new JdbcNamedParameter(
														"extField1")),
										TSYS_DEP_TABLE.EXT_FIELD_2
												.value(new JdbcNamedParameter(
														"extField2")),
										TSYS_DEP_TABLE.EXT_FIELD_3
												.value(new JdbcNamedParameter(
														"extField3"))

								).where(TSYS_DEP_TABLE.DEP_CODE
										.eq(new JdbcNamedParameter("depCode")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TsysDep> tsysDep) {
		if (CollectionUtil.isEmpty(tsysDep)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysDep,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_DEP_TABLE).where(
								and(TSYS_DEP_TABLE.DEP_NAME
												.eq(new JdbcNamedParameter("depName")),
										TSYS_DEP_TABLE.SHORT_NAME
												.eq(new JdbcNamedParameter(
														"shortName")),
										TSYS_DEP_TABLE.PARENT_CODE
												.eq(new JdbcNamedParameter(
														"parentCode")),
										TSYS_DEP_TABLE.BRANCH_CODE
												.eq(new JdbcNamedParameter(
														"branchCode")),
										TSYS_DEP_TABLE.DEP_PATH
												.eq(new JdbcNamedParameter(
														"depPath")),
										TSYS_DEP_TABLE.REMARK
												.eq(new JdbcNamedParameter(
														"remark")),
										TSYS_DEP_TABLE.EXT_FIELD_1
												.eq(new JdbcNamedParameter(
														"extField1")),
										TSYS_DEP_TABLE.EXT_FIELD_2
												.eq(new JdbcNamedParameter(
														"extField2")),
										TSYS_DEP_TABLE.EXT_FIELD_3
												.eq(new JdbcNamedParameter(
														"extField3"))

								));
					}
				});
	}

	public int[] preparedBatchInsert(List<TsysDep> tsysDep) {
		return preparedBatchInsert(false, tsysDep);
	}
}
