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
import static org.tinygroup.buildinfo.dao.inter.constant.TsysBranchTable.*;
import static org.tinygroup.buildinfo.dao.inter.constant.TsysDepTable.TSYS_DEP_TABLE;
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
import org.tinygroup.buildinfo.dao.inter.pojo.TsysBranch;
import org.tinygroup.buildinfo.dao.inter.TsysBranchDao;

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
 * <!-- begin-user-doc --> 濡傛灉涓嶅笇鏈涙煇鏂规硶鎴栬�鍙橀噺琚鐩栵紝鍙互鍦ㄦ柟娉曟垨鑰呭彉閲忔敞閲婁腑澧炲姞@unmodifiable
 * <!-- end-user-doc -->
 */
public class TsysBranchDaoImpl extends TinyDslDaoSupport implements
		TsysBranchDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysBranch add(TsysBranch tsysBranch) {
		return getDslTemplate().insertAndReturnKey(tsysBranch,
				new InsertGenerateCallback<TsysBranch>() {
					public Insert generate(TsysBranch t) {
						Insert insert = insertInto(TSYS_BRANCH_TABLE).values(
								TSYS_BRANCH_TABLE.BRANCH_CODE.value(t
										.getBranchCode()),
								TSYS_BRANCH_TABLE.BRANCH_LEVEL.value(t
										.getBranchLevel()),
								TSYS_BRANCH_TABLE.BRANCH_NAME.value(t
										.getBranchName()),
								TSYS_BRANCH_TABLE.BRANCH_TYPE.value(t
										.getBranchType()),
								TSYS_BRANCH_TABLE.SHORT_NAME.value(t
										.getShortName()),
								TSYS_BRANCH_TABLE.PARENT_CODE.value(t
										.getParentCode()),
								TSYS_BRANCH_TABLE.BRANCH_PATH.value(t
										.getBranchPath()),
								TSYS_BRANCH_TABLE.REMARK.value(t.getRemark()),
								TSYS_BRANCH_TABLE.EXT_FIELD_1.value(t
										.getExtField1()),
								TSYS_BRANCH_TABLE.EXT_FIELD_2.value(t
										.getExtField2()),
								TSYS_BRANCH_TABLE.EXT_FIELD_3.value(t
										.getExtField3())

						);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TsysBranch tsysBranch) {
		if (tsysBranch == null || tsysBranch.getBranchCode() == null) {
			return 0;
		}
		return getDslTemplate().update(tsysBranch,
				new UpdateGenerateCallback<TsysBranch>() {
					public Update generate(TsysBranch t) {
						Update update = update(TSYS_BRANCH_TABLE).set(
								TSYS_BRANCH_TABLE.BRANCH_LEVEL.value(t
										.getBranchLevel()),
								TSYS_BRANCH_TABLE.BRANCH_NAME.value(t
										.getBranchName()),
								TSYS_BRANCH_TABLE.BRANCH_TYPE.value(t
										.getBranchType()),
								TSYS_BRANCH_TABLE.SHORT_NAME.value(t
										.getShortName()),
								TSYS_BRANCH_TABLE.PARENT_CODE.value(t
										.getParentCode()),
								TSYS_BRANCH_TABLE.BRANCH_PATH.value(t
										.getBranchPath()),
								TSYS_BRANCH_TABLE.REMARK.value(t.getRemark()),
								TSYS_BRANCH_TABLE.EXT_FIELD_1.value(t
										.getExtField1()),
								TSYS_BRANCH_TABLE.EXT_FIELD_2.value(t
										.getExtField2()),
								TSYS_BRANCH_TABLE.EXT_FIELD_3.value(t
										.getExtField3())).where(
								TSYS_BRANCH_TABLE.BRANCH_CODE.eq(t
										.getBranchCode()));
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
						return delete(TSYS_BRANCH_TABLE).where(
								TSYS_BRANCH_TABLE.BRANCH_CODE.eq(pk));
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
						return delete(TSYS_BRANCH_TABLE).where(
								TSYS_BRANCH_TABLE.BRANCH_CODE.in(t));
					}
				}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysBranch getByKey(String pk) {
		return getDslTemplate().getByKey(pk, TsysBranch.class,
				new SelectGenerateCallback<Serializable>() {

					@SuppressWarnings("rawtypes")
					public Select generate(Serializable t) {
						return selectFrom(TSYS_BRANCH_TABLE).where(
								TSYS_BRANCH_TABLE.BRANCH_CODE.eq(t));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TsysBranch> query(TsysBranch tsysBranch,
			final OrderBy... orderArgs) {
		if (tsysBranch == null) {
			tsysBranch = new TsysBranch();
		}
		return getDslTemplate().query(tsysBranch,
				new SelectGenerateCallback<TsysBranch>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysBranch t) {
						Select select = selectFrom(TSYS_BRANCH_TABLE).where(
								and(TSYS_BRANCH_TABLE.BRANCH_CODE.eq(t
										.getBranchCode()),
										TSYS_BRANCH_TABLE.BRANCH_LEVEL.eq(t
										.getBranchLevel()),
										TSYS_BRANCH_TABLE.BRANCH_NAME.eq(t
												.getBranchName()),
										TSYS_BRANCH_TABLE.BRANCH_TYPE.eq(t
												.getBranchType()),
										TSYS_BRANCH_TABLE.SHORT_NAME.eq(t
												.getShortName()),
										TSYS_BRANCH_TABLE.PARENT_CODE.eq(t
												.getParentCode()),
										TSYS_BRANCH_TABLE.BRANCH_PATH.eq(t
												.getBranchPath()),
										TSYS_BRANCH_TABLE.REMARK.eq(t
												.getRemark()),
										TSYS_BRANCH_TABLE.EXT_FIELD_1.eq(t
												.getExtField1()),
										TSYS_BRANCH_TABLE.EXT_FIELD_2.eq(t
												.getExtField2()),
										TSYS_BRANCH_TABLE.EXT_FIELD_3.eq(t
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
	public Pager<TsysBranch> queryPager(int start, int limit,
			TsysBranch tsysBranch, final OrderBy... orderArgs) {
		if (tsysBranch == null) {
			tsysBranch = new TsysBranch();
		}
		return getDslTemplate().queryPager(start, limit, tsysBranch, false,
				new SelectGenerateCallback<TsysBranch>() {
					public Select generate(TsysBranch t) {
						Select select = Select.selectFrom(TSYS_BRANCH_TABLE)
								.where(and(
										TSYS_BRANCH_TABLE.BRANCH_CODE.eq(t
												.getBranchCode()),
										TSYS_BRANCH_TABLE.BRANCH_LEVEL.eq(t
										.getBranchLevel()),
										TSYS_BRANCH_TABLE.BRANCH_NAME.eq(t
												.getBranchName()),
										TSYS_BRANCH_TABLE.BRANCH_TYPE.eq(t
												.getBranchType()),
										TSYS_BRANCH_TABLE.SHORT_NAME.eq(t
												.getShortName()),
										TSYS_BRANCH_TABLE.PARENT_CODE.eq(t
												.getParentCode()),
										TSYS_BRANCH_TABLE.BRANCH_PATH.eq(t
												.getBranchPath()),
										TSYS_BRANCH_TABLE.REMARK.eq(t
												.getRemark()),
										TSYS_BRANCH_TABLE.EXT_FIELD_1.eq(t
												.getExtField1()),
										TSYS_BRANCH_TABLE.EXT_FIELD_2.eq(t
												.getExtField2()),
										TSYS_BRANCH_TABLE.EXT_FIELD_3.eq(t
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
	public int[] batchInsert(boolean autoGeneratedKeys,
			List<TsysBranch> tsysBranch) {
		if (CollectionUtil.isEmpty(tsysBranch)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysBranch,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_BRANCH_TABLE)
								.values(TSYS_BRANCH_TABLE.BRANCH_LEVEL
										.value(new JdbcNamedParameter(
												"branchLevel")),
										TSYS_BRANCH_TABLE.BRANCH_NAME
												.value(new JdbcNamedParameter(
														"branchName")),
										TSYS_BRANCH_TABLE.BRANCH_TYPE
												.value(new JdbcNamedParameter(
														"branchType")),
										TSYS_BRANCH_TABLE.SHORT_NAME
												.value(new JdbcNamedParameter(
														"shortName")),
										TSYS_BRANCH_TABLE.PARENT_CODE
												.value(new JdbcNamedParameter(
														"parentCode")),
										TSYS_BRANCH_TABLE.BRANCH_PATH
												.value(new JdbcNamedParameter(
														"branchPath")),
										TSYS_BRANCH_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark")),
										TSYS_BRANCH_TABLE.EXT_FIELD_1
												.value(new JdbcNamedParameter(
														"extField1")),
										TSYS_BRANCH_TABLE.EXT_FIELD_2
												.value(new JdbcNamedParameter(
														"extField2")),
										TSYS_BRANCH_TABLE.EXT_FIELD_3
												.value(new JdbcNamedParameter(
														"extField3"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TsysBranch> tsysBranchs) {
		return batchInsert(true, tsysBranchs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TsysBranch> tsysBranch) {
		if (CollectionUtil.isEmpty(tsysBranch)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysBranch,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_BRANCH_TABLE)
								.set(TSYS_BRANCH_TABLE.BRANCH_LEVEL
										.value(new JdbcNamedParameter(
												"branchLevel")),
										TSYS_BRANCH_TABLE.BRANCH_NAME
												.value(new JdbcNamedParameter(
														"branchName")),
										TSYS_BRANCH_TABLE.BRANCH_TYPE
												.value(new JdbcNamedParameter(
														"branchType")),
										TSYS_BRANCH_TABLE.SHORT_NAME
												.value(new JdbcNamedParameter(
														"shortName")),
										TSYS_BRANCH_TABLE.PARENT_CODE
												.value(new JdbcNamedParameter(
														"parentCode")),
										TSYS_BRANCH_TABLE.BRANCH_PATH
												.value(new JdbcNamedParameter(
														"branchPath")),
										TSYS_BRANCH_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark")),
										TSYS_BRANCH_TABLE.EXT_FIELD_1
												.value(new JdbcNamedParameter(
														"extField1")),
										TSYS_BRANCH_TABLE.EXT_FIELD_2
												.value(new JdbcNamedParameter(
														"extField2")),
										TSYS_BRANCH_TABLE.EXT_FIELD_3
												.value(new JdbcNamedParameter(
														"extField3"))

								)
								.where(TSYS_BRANCH_TABLE.BRANCH_CODE
										.eq(new JdbcNamedParameter("branchCode")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TsysBranch> tsysBranch) {
		if (CollectionUtil.isEmpty(tsysBranch)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysBranch,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_BRANCH_TABLE).where(
								and(TSYS_BRANCH_TABLE.BRANCH_LEVEL
										.eq(new JdbcNamedParameter(
												"branchLevel")),
										TSYS_BRANCH_TABLE.BRANCH_NAME
												.eq(new JdbcNamedParameter(
														"branchName")),
										TSYS_BRANCH_TABLE.BRANCH_TYPE
												.eq(new JdbcNamedParameter(
														"branchType")),
										TSYS_BRANCH_TABLE.SHORT_NAME
												.eq(new JdbcNamedParameter(
														"shortName")),
										TSYS_BRANCH_TABLE.PARENT_CODE
												.eq(new JdbcNamedParameter(
														"parentCode")),
										TSYS_BRANCH_TABLE.BRANCH_PATH
												.eq(new JdbcNamedParameter(
														"branchPath")),
										TSYS_BRANCH_TABLE.REMARK
												.eq(new JdbcNamedParameter(
														"remark")),
										TSYS_BRANCH_TABLE.EXT_FIELD_1
												.eq(new JdbcNamedParameter(
														"extField1")),
										TSYS_BRANCH_TABLE.EXT_FIELD_2
												.eq(new JdbcNamedParameter(
														"extField2")),
										TSYS_BRANCH_TABLE.EXT_FIELD_3
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
				Select select = select(TSYS_BRANCH_TABLE.BRANCH_CODE.as("id"),
						TSYS_BRANCH_TABLE.PARENT_CODE.as("pid"),
						TSYS_BRANCH_TABLE.BRANCH_NAME.as("name")).from(TSYS_BRANCH_TABLE)
						.where(and(
								TSYS_BRANCH_TABLE.BRANCH_NAME.eq(t.getName()),
								TSYS_BRANCH_TABLE.PARENT_CODE.eq(t.getpId()),
								TSYS_BRANCH_TABLE.BRANCH_CODE.eq(t.getId())));
				
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});

	}

	/**
	 * 模糊搜索
	 * @param start
	 * @param limit
	 * @param tsysBranch
	 * @param orderArgs
     * @return
     */
	public Pager<TsysBranch> queryFuzzyPager(int start, int limit,
										TsysBranch tsysBranch, final OrderBy... orderArgs) {
		if (tsysBranch == null) {
			tsysBranch = new TsysBranch();
		}
		return getDslTemplate().queryPager(start, limit, tsysBranch, false,
				new SelectGenerateCallback<TsysBranch>() {
					public Select generate(TsysBranch t) {
						Select select = Select.selectFrom(TSYS_BRANCH_TABLE)
								.where(and(
										TSYS_BRANCH_TABLE.BRANCH_CODE.like(t
												.getBranchCode()),
										TSYS_BRANCH_TABLE.BRANCH_LEVEL.like(t
												.getBranchLevel()),
										TSYS_BRANCH_TABLE.BRANCH_NAME.like(t
												.getBranchName()),
										TSYS_BRANCH_TABLE.BRANCH_TYPE.like(t
												.getBranchType()),
										TSYS_BRANCH_TABLE.SHORT_NAME.like(t
												.getShortName()),
										TSYS_BRANCH_TABLE.PARENT_CODE.like(t
												.getParentCode()),
										TSYS_BRANCH_TABLE.BRANCH_PATH.like(t
												.getBranchPath()),
										TSYS_BRANCH_TABLE.REMARK.like(t
												.getRemark()),
										TSYS_BRANCH_TABLE.EXT_FIELD_1.like(t
												.getExtField1()),
										TSYS_BRANCH_TABLE.EXT_FIELD_2.like(t
												.getExtField2()),
										TSYS_BRANCH_TABLE.EXT_FIELD_3.like(t
												.getExtField3())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * 根据branch_code 获取信息
	 *
	 * @param tsysBranch
	 * @return
	 */
	public List checkExist(TsysBranch tsysBranch) {
		if (tsysBranch == null) {
			tsysBranch = new TsysBranch();
		}
		return getDslTemplate().query(tsysBranch,
				new SelectGenerateCallback<TsysBranch>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysBranch t) {
						Select select = selectFrom(TSYS_BRANCH_TABLE).where(
								and(TSYS_BRANCH_TABLE.BRANCH_CODE.eq(t
										.getBranchLevel())
								));
						return select;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys,
									 List<TsysBranch> tsysBranch) {
		if (CollectionUtil.isEmpty(tsysBranch)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysBranch,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_BRANCH_TABLE)
								.values(TSYS_BRANCH_TABLE.BRANCH_LEVEL
												.value(new JdbcNamedParameter(
														"branchLevel")),
										TSYS_BRANCH_TABLE.BRANCH_NAME
												.value(new JdbcNamedParameter(
														"branchName")),
										TSYS_BRANCH_TABLE.BRANCH_TYPE
												.value(new JdbcNamedParameter(
														"branchType")),
										TSYS_BRANCH_TABLE.SHORT_NAME
												.value(new JdbcNamedParameter(
														"shortName")),
										TSYS_BRANCH_TABLE.PARENT_CODE
												.value(new JdbcNamedParameter(
														"parentCode")),
										TSYS_BRANCH_TABLE.BRANCH_PATH
												.value(new JdbcNamedParameter(
														"branchPath")),
										TSYS_BRANCH_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark")),
										TSYS_BRANCH_TABLE.EXT_FIELD_1
												.value(new JdbcNamedParameter(
														"extField1")),
										TSYS_BRANCH_TABLE.EXT_FIELD_2
												.value(new JdbcNamedParameter(
														"extField2")),
										TSYS_BRANCH_TABLE.EXT_FIELD_3
												.value(new JdbcNamedParameter(
														"extField3"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TsysBranch> tsysBranch) {
		if (CollectionUtil.isEmpty(tsysBranch)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysBranch,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_BRANCH_TABLE)
								.set(TSYS_BRANCH_TABLE.BRANCH_LEVEL
												.value(new JdbcNamedParameter(
														"branchLevel")),
										TSYS_BRANCH_TABLE.BRANCH_NAME
												.value(new JdbcNamedParameter(
														"branchName")),
										TSYS_BRANCH_TABLE.BRANCH_TYPE
												.value(new JdbcNamedParameter(
														"branchType")),
										TSYS_BRANCH_TABLE.SHORT_NAME
												.value(new JdbcNamedParameter(
														"shortName")),
										TSYS_BRANCH_TABLE.PARENT_CODE
												.value(new JdbcNamedParameter(
														"parentCode")),
										TSYS_BRANCH_TABLE.BRANCH_PATH
												.value(new JdbcNamedParameter(
														"branchPath")),
										TSYS_BRANCH_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark")),
										TSYS_BRANCH_TABLE.EXT_FIELD_1
												.value(new JdbcNamedParameter(
														"extField1")),
										TSYS_BRANCH_TABLE.EXT_FIELD_2
												.value(new JdbcNamedParameter(
														"extField2")),
										TSYS_BRANCH_TABLE.EXT_FIELD_3
												.value(new JdbcNamedParameter(
														"extField3"))

								)
								.where(TSYS_BRANCH_TABLE.BRANCH_CODE
										.eq(new JdbcNamedParameter("branchCode")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TsysBranch> tsysBranch) {
		if (CollectionUtil.isEmpty(tsysBranch)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysBranch,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_BRANCH_TABLE).where(
								and(TSYS_BRANCH_TABLE.BRANCH_LEVEL
												.eq(new JdbcNamedParameter(
														"branchLevel")),
										TSYS_BRANCH_TABLE.BRANCH_NAME
												.eq(new JdbcNamedParameter(
														"branchName")),
										TSYS_BRANCH_TABLE.BRANCH_TYPE
												.eq(new JdbcNamedParameter(
														"branchType")),
										TSYS_BRANCH_TABLE.SHORT_NAME
												.eq(new JdbcNamedParameter(
														"shortName")),
										TSYS_BRANCH_TABLE.PARENT_CODE
												.eq(new JdbcNamedParameter(
														"parentCode")),
										TSYS_BRANCH_TABLE.BRANCH_PATH
												.eq(new JdbcNamedParameter(
														"branchPath")),
										TSYS_BRANCH_TABLE.REMARK
												.eq(new JdbcNamedParameter(
														"remark")),
										TSYS_BRANCH_TABLE.EXT_FIELD_1
												.eq(new JdbcNamedParameter(
														"extField1")),
										TSYS_BRANCH_TABLE.EXT_FIELD_2
												.eq(new JdbcNamedParameter(
														"extField2")),
										TSYS_BRANCH_TABLE.EXT_FIELD_3
												.eq(new JdbcNamedParameter(
														"extField3"))

								));
					}
				});
	}

	public int[] preparedBatchInsert(List<TsysBranch> tsysBranch) {
		return preparedBatchInsert(false, tsysBranch);
	}
}
