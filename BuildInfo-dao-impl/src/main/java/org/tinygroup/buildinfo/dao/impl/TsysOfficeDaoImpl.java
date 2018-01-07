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
import static org.tinygroup.buildinfo.dao.inter.constant.TsysBranchTable.TSYS_BRANCH_TABLE;
import static org.tinygroup.buildinfo.dao.inter.constant.TsysOfficeTable.*;
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
import org.tinygroup.buildinfo.dao.inter.pojo.TsysOffice;
import org.tinygroup.buildinfo.dao.inter.TsysOfficeDao;

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
public class TsysOfficeDaoImpl extends TinyDslDaoSupport implements
		TsysOfficeDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysOffice add(TsysOffice tsysOffice) {
		return getDslTemplate().insertAndReturnKey(tsysOffice,
				new InsertGenerateCallback<TsysOffice>() {
					public Insert generate(TsysOffice t) {
						Insert insert = insertInto(TSYS_OFFICE_TABLE)
								.values(TSYS_OFFICE_TABLE.OFFICE_CODE.value(t
										.getOfficeCode()),
										TSYS_OFFICE_TABLE.OFFICE_NAME.value(t
												.getOfficeName()),
										TSYS_OFFICE_TABLE.SHORT_NAME.value(t
												.getShortName()),
										TSYS_OFFICE_TABLE.PARENT_CODE.value(t
												.getParentCode()),
										TSYS_OFFICE_TABLE.BRANCH_CODE.value(t
												.getBranchCode()),
										TSYS_OFFICE_TABLE.DEP_CODE.value(t
												.getDepCode()),
										TSYS_OFFICE_TABLE.OFFICE_PATH.value(t
												.getOfficePath()),
										TSYS_OFFICE_TABLE.BRANCH_LEVEL.value(t
												.getBranchLevel()),
										TSYS_OFFICE_TABLE.REMARK.value(t
												.getRemark()),
										TSYS_OFFICE_TABLE.EXT_FIELD_1.value(t
												.getExtField1()),
										TSYS_OFFICE_TABLE.EXT_FIELD_2.value(t
												.getExtField2()),
										TSYS_OFFICE_TABLE.EXT_FIELD_3.value(t
												.getExtField3())

								);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TsysOffice tsysOffice) {
		if (tsysOffice == null || tsysOffice.getOfficeCode() == null) {
			return 0;
		}
		return getDslTemplate().update(tsysOffice,
				new UpdateGenerateCallback<TsysOffice>() {
					public Update generate(TsysOffice t) {
						Update update = update(TSYS_OFFICE_TABLE)
								.set(TSYS_OFFICE_TABLE.OFFICE_NAME.value(t
										.getOfficeName()),
										TSYS_OFFICE_TABLE.SHORT_NAME.value(t
												.getShortName()),
										TSYS_OFFICE_TABLE.PARENT_CODE.value(t
												.getParentCode()),
										TSYS_OFFICE_TABLE.BRANCH_CODE.value(t
												.getBranchCode()),
										TSYS_OFFICE_TABLE.DEP_CODE.value(t
												.getDepCode()),
										TSYS_OFFICE_TABLE.OFFICE_PATH.value(t
												.getOfficePath()),
										TSYS_OFFICE_TABLE.BRANCH_LEVEL.value(t
												.getBranchLevel()),
										TSYS_OFFICE_TABLE.REMARK.value(t
												.getRemark()),
										TSYS_OFFICE_TABLE.EXT_FIELD_1.value(t
												.getExtField1()),
										TSYS_OFFICE_TABLE.EXT_FIELD_2.value(t
												.getExtField2()),
										TSYS_OFFICE_TABLE.EXT_FIELD_3.value(t
												.getExtField3())).where(
										TSYS_OFFICE_TABLE.OFFICE_CODE.eq(t
												.getOfficeCode()));
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
						return delete(TSYS_OFFICE_TABLE).where(
								TSYS_OFFICE_TABLE.OFFICE_CODE.eq(pk));
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
						return delete(TSYS_OFFICE_TABLE).where(
								TSYS_OFFICE_TABLE.OFFICE_CODE.in(t));
					}
				}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysOffice getByKey(String pk) {
		return getDslTemplate().getByKey(pk, TsysOffice.class,
				new SelectGenerateCallback<Serializable>() {

					@SuppressWarnings("rawtypes")
					public Select generate(Serializable t) {
						return selectFrom(TSYS_OFFICE_TABLE).where(
								TSYS_OFFICE_TABLE.OFFICE_CODE.eq(t));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TsysOffice> query(TsysOffice tsysOffice,
			final OrderBy... orderArgs) {
		if (tsysOffice == null) {
			tsysOffice = new TsysOffice();
		}
		return getDslTemplate().query(tsysOffice,
				new SelectGenerateCallback<TsysOffice>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysOffice t) {
						Select select = selectFrom(TSYS_OFFICE_TABLE).where(
								and(TSYS_OFFICE_TABLE.OFFICE_CODE.eq(t
										.getOfficeCode()),
										TSYS_OFFICE_TABLE.OFFICE_NAME.eq(t
										.getOfficeName()),
										TSYS_OFFICE_TABLE.SHORT_NAME.eq(t
												.getShortName()),
										TSYS_OFFICE_TABLE.PARENT_CODE.eq(t
												.getParentCode()),
										TSYS_OFFICE_TABLE.BRANCH_CODE.eq(t
												.getBranchCode()),
										TSYS_OFFICE_TABLE.DEP_CODE.eq(t
												.getDepCode()),
										TSYS_OFFICE_TABLE.OFFICE_PATH.eq(t
												.getOfficePath()),
										TSYS_OFFICE_TABLE.BRANCH_LEVEL.eq(t
												.getBranchLevel()),
										TSYS_OFFICE_TABLE.REMARK.eq(t
												.getRemark()),
										TSYS_OFFICE_TABLE.EXT_FIELD_1.eq(t
												.getExtField1()),
										TSYS_OFFICE_TABLE.EXT_FIELD_2.eq(t
												.getExtField2()),
										TSYS_OFFICE_TABLE.EXT_FIELD_3.eq(t
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
	public Pager<TsysOffice> queryPager(int start, int limit,
			TsysOffice tsysOffice, final OrderBy... orderArgs) {
		if (tsysOffice == null) {
			tsysOffice = new TsysOffice();
		}
		return getDslTemplate().queryPager(start, limit, tsysOffice, false,
				new SelectGenerateCallback<TsysOffice>() {
					public Select generate(TsysOffice t) {
						Select select = Select.selectFrom(TSYS_OFFICE_TABLE)
								.where(and(
										TSYS_OFFICE_TABLE.OFFICE_CODE.eq(t
												.getOfficeCode()),
										TSYS_OFFICE_TABLE.OFFICE_NAME.eq(t
										.getOfficeName()),
										TSYS_OFFICE_TABLE.SHORT_NAME.eq(t
												.getShortName()),
										TSYS_OFFICE_TABLE.PARENT_CODE.eq(t
												.getParentCode()),
										TSYS_OFFICE_TABLE.BRANCH_CODE.eq(t
												.getBranchCode()),
										TSYS_OFFICE_TABLE.DEP_CODE.eq(t
												.getDepCode()),
										TSYS_OFFICE_TABLE.OFFICE_PATH.eq(t
												.getOfficePath()),
										TSYS_OFFICE_TABLE.BRANCH_LEVEL.eq(t
												.getBranchLevel()),
										TSYS_OFFICE_TABLE.REMARK.eq(t
												.getRemark()),
										TSYS_OFFICE_TABLE.EXT_FIELD_1.eq(t
												.getExtField1()),
										TSYS_OFFICE_TABLE.EXT_FIELD_2.eq(t
												.getExtField2()),
										TSYS_OFFICE_TABLE.EXT_FIELD_3.eq(t
												.getExtField3())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * like 搜索
	 */
	public Pager<TsysOffice> queryPagerForSearch(int start, int limit,
			TsysOffice tsysOffice, final OrderBy... orderArgs) {
		if (tsysOffice == null) {
			tsysOffice = new TsysOffice();
		}
		return getDslTemplate().queryPager(start, limit, tsysOffice, false,
				new SelectGenerateCallback<TsysOffice>() {
					public Select generate(TsysOffice t) {
						Select select = Select.selectFrom(TSYS_OFFICE_TABLE)
								.where(and(
										TSYS_OFFICE_TABLE.OFFICE_CODE.like(t
												.getOfficeCode()),
										TSYS_OFFICE_TABLE.OFFICE_NAME.like(t
										.getOfficeName()),
										TSYS_OFFICE_TABLE.SHORT_NAME.like(t
												.getShortName()),
										TSYS_OFFICE_TABLE.PARENT_CODE.like(t
												.getParentCode()),
										TSYS_OFFICE_TABLE.BRANCH_CODE.like(t
												.getBranchCode()),
										TSYS_OFFICE_TABLE.DEP_CODE.like(t
												.getDepCode()),
										TSYS_OFFICE_TABLE.OFFICE_PATH.like(t
												.getOfficePath()),
										TSYS_OFFICE_TABLE.BRANCH_LEVEL.like(t
												.getBranchLevel()),
										TSYS_OFFICE_TABLE.REMARK.like(t
												.getRemark()),
										TSYS_OFFICE_TABLE.EXT_FIELD_1.like(t
												.getExtField1()),
										TSYS_OFFICE_TABLE.EXT_FIELD_2.like(t
												.getExtField2()),
										TSYS_OFFICE_TABLE.EXT_FIELD_3.like(t
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
			List<TsysOffice> tsysOffice) {
		if (CollectionUtil.isEmpty(tsysOffice)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysOffice,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_OFFICE_TABLE)
								.values(TSYS_OFFICE_TABLE.OFFICE_NAME
										.value(new JdbcNamedParameter(
												"officeName")),
										TSYS_OFFICE_TABLE.SHORT_NAME
												.value(new JdbcNamedParameter(
														"shortName")),
										TSYS_OFFICE_TABLE.PARENT_CODE
												.value(new JdbcNamedParameter(
														"parentCode")),
										TSYS_OFFICE_TABLE.BRANCH_CODE
												.value(new JdbcNamedParameter(
														"branchCode")),
										TSYS_OFFICE_TABLE.DEP_CODE
												.value(new JdbcNamedParameter(
														"depCode")),
										TSYS_OFFICE_TABLE.OFFICE_PATH
												.value(new JdbcNamedParameter(
														"officePath")),
										TSYS_OFFICE_TABLE.BRANCH_LEVEL
												.value(new JdbcNamedParameter(
														"branchLevel")),
										TSYS_OFFICE_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark")),
										TSYS_OFFICE_TABLE.EXT_FIELD_1
												.value(new JdbcNamedParameter(
														"extField1")),
										TSYS_OFFICE_TABLE.EXT_FIELD_2
												.value(new JdbcNamedParameter(
														"extField2")),
										TSYS_OFFICE_TABLE.EXT_FIELD_3
												.value(new JdbcNamedParameter(
														"extField3"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TsysOffice> tsysOffices) {
		return batchInsert(true, tsysOffices);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TsysOffice> tsysOffice) {
		if (CollectionUtil.isEmpty(tsysOffice)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysOffice,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_OFFICE_TABLE)
								.set(TSYS_OFFICE_TABLE.OFFICE_NAME
										.value(new JdbcNamedParameter(
												"officeName")),
										TSYS_OFFICE_TABLE.SHORT_NAME
												.value(new JdbcNamedParameter(
														"shortName")),
										TSYS_OFFICE_TABLE.PARENT_CODE
												.value(new JdbcNamedParameter(
														"parentCode")),
										TSYS_OFFICE_TABLE.BRANCH_CODE
												.value(new JdbcNamedParameter(
														"branchCode")),
										TSYS_OFFICE_TABLE.DEP_CODE
												.value(new JdbcNamedParameter(
														"depCode")),
										TSYS_OFFICE_TABLE.OFFICE_PATH
												.value(new JdbcNamedParameter(
														"officePath")),
										TSYS_OFFICE_TABLE.BRANCH_LEVEL
												.value(new JdbcNamedParameter(
														"branchLevel")),
										TSYS_OFFICE_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark")),
										TSYS_OFFICE_TABLE.EXT_FIELD_1
												.value(new JdbcNamedParameter(
														"extField1")),
										TSYS_OFFICE_TABLE.EXT_FIELD_2
												.value(new JdbcNamedParameter(
														"extField2")),
										TSYS_OFFICE_TABLE.EXT_FIELD_3
												.value(new JdbcNamedParameter(
														"extField3"))

								)
								.where(TSYS_OFFICE_TABLE.OFFICE_CODE
										.eq(new JdbcNamedParameter("officeCode")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TsysOffice> tsysOffice) {
		if (CollectionUtil.isEmpty(tsysOffice)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysOffice,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_OFFICE_TABLE)
								.where(and(
										TSYS_OFFICE_TABLE.OFFICE_NAME
												.eq(new JdbcNamedParameter(
														"officeName")),
										TSYS_OFFICE_TABLE.SHORT_NAME
												.eq(new JdbcNamedParameter(
														"shortName")),
										TSYS_OFFICE_TABLE.PARENT_CODE
												.eq(new JdbcNamedParameter(
														"parentCode")),
										TSYS_OFFICE_TABLE.BRANCH_CODE
												.eq(new JdbcNamedParameter(
														"branchCode")),
										TSYS_OFFICE_TABLE.DEP_CODE
												.eq(new JdbcNamedParameter(
														"depCode")),
										TSYS_OFFICE_TABLE.OFFICE_PATH
												.eq(new JdbcNamedParameter(
														"officePath")),
										TSYS_OFFICE_TABLE.BRANCH_LEVEL
												.eq(new JdbcNamedParameter(
														"branchLevel")),
										TSYS_OFFICE_TABLE.REMARK
												.eq(new JdbcNamedParameter(
														"remark")),
										TSYS_OFFICE_TABLE.EXT_FIELD_1
												.eq(new JdbcNamedParameter(
														"extField1")),
										TSYS_OFFICE_TABLE.EXT_FIELD_2
												.eq(new JdbcNamedParameter(
														"extField2")),
										TSYS_OFFICE_TABLE.EXT_FIELD_3
												.eq(new JdbcNamedParameter(
														"extField3"))

								));
					}
				});
	}

	public List<TreeData> getOfficeTree(TreeData tree) {
		if(tree == null){
			tree = new TreeData();
		}
		return getDslTemplate().query(tree,new SelectGenerateCallback<TreeData>() {

			@SuppressWarnings("rawtypes")
			public Select generate(TreeData t) {
				Select select = 
						select(
							TSYS_OFFICE_TABLE.PARENT_CODE.as("pid"),
							TSYS_OFFICE_TABLE.OFFICE_CODE.as("id"),
							TSYS_OFFICE_TABLE.OFFICE_NAME.as("name")).from(TSYS_OFFICE_TABLE).where(and(
								TSYS_OFFICE_TABLE.PARENT_CODE.eq(t.getpId()),
								TSYS_OFFICE_TABLE.OFFICE_CODE.eq(t.getId()),
								TSYS_OFFICE_TABLE.OFFICE_NAME.eq(t.getName())
							));
				return select;
			}
			
		} );
	}

	public List<TreeData> getOfficeTreeByDep(TreeData tree) {
		if(tree == null){
			tree = new TreeData();
		}
		return getDslTemplate().query(tree,new SelectGenerateCallback<TreeData>() {

			@SuppressWarnings("rawtypes")
			public Select generate(TreeData t) {
				Select select = 
						select(
							TSYS_OFFICE_TABLE.PARENT_CODE.as("pid"),
							TSYS_OFFICE_TABLE.OFFICE_CODE.as("id"),
							TSYS_OFFICE_TABLE.OFFICE_NAME.as("name")).from(TSYS_OFFICE_TABLE).where(and(
								TSYS_OFFICE_TABLE.DEP_CODE.eq(t.getpId()),
								TSYS_OFFICE_TABLE.OFFICE_CODE.eq(t.getId()),
								TSYS_OFFICE_TABLE.OFFICE_NAME.eq(t.getName())
							));
				return select;
			}
			
		} );
	}

	public List<TreeData> getOfficeTree(final TsysOffice tsysOffice) {
		TreeData tree =  new TreeData();
		return getDslTemplate().query(tree,new SelectGenerateCallback<TreeData>() {

			@SuppressWarnings("rawtypes")
			public Select generate(TreeData t) {
				Select select =
						select(
								TSYS_OFFICE_TABLE.PARENT_CODE.as("pid"),
								TSYS_OFFICE_TABLE.OFFICE_CODE.as("id"),
								TSYS_OFFICE_TABLE.OFFICE_NAME.as("name")).from(TSYS_OFFICE_TABLE).where(and(
								TSYS_OFFICE_TABLE.DEP_CODE.eq(tsysOffice.getDepCode()),
								TSYS_OFFICE_TABLE.PARENT_CODE.eq(tsysOffice.getParentCode())));
				return select;
			}

		} );
	}

	/**
	 * 根据office_code 获取信息
	 *
	 * @param tsysOffice
	 * @return
	 */
	public List checkExist(TsysOffice tsysOffice) {
		if (tsysOffice == null) {
			tsysOffice = new TsysOffice();
		}
		return getDslTemplate().query(tsysOffice,
				new SelectGenerateCallback<TsysOffice>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysOffice t) {
						Select select = selectFrom(TSYS_OFFICE_TABLE).where(
								and(
									TSYS_OFFICE_TABLE.OFFICE_CODE.eq(t.getOfficeCode()),
									TSYS_OFFICE_TABLE.DEP_CODE.eq(t.getDepCode()),
									TSYS_OFFICE_TABLE.BRANCH_CODE.eq(t.getBranchCode())
								));
						return select;
					}
				});
	}
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys,
									 List<TsysOffice> tsysOffice) {
		if (CollectionUtil.isEmpty(tsysOffice)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysOffice,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_OFFICE_TABLE)
								.values(TSYS_OFFICE_TABLE.OFFICE_NAME
												.value(new JdbcNamedParameter(
														"officeName")),
										TSYS_OFFICE_TABLE.SHORT_NAME
												.value(new JdbcNamedParameter(
														"shortName")),
										TSYS_OFFICE_TABLE.PARENT_CODE
												.value(new JdbcNamedParameter(
														"parentCode")),
										TSYS_OFFICE_TABLE.BRANCH_CODE
												.value(new JdbcNamedParameter(
														"branchCode")),
										TSYS_OFFICE_TABLE.DEP_CODE
												.value(new JdbcNamedParameter(
														"depCode")),
										TSYS_OFFICE_TABLE.OFFICE_PATH
												.value(new JdbcNamedParameter(
														"officePath")),
										TSYS_OFFICE_TABLE.BRANCH_LEVEL
												.value(new JdbcNamedParameter(
														"branchLevel")),
										TSYS_OFFICE_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark")),
										TSYS_OFFICE_TABLE.EXT_FIELD_1
												.value(new JdbcNamedParameter(
														"extField1")),
										TSYS_OFFICE_TABLE.EXT_FIELD_2
												.value(new JdbcNamedParameter(
														"extField2")),
										TSYS_OFFICE_TABLE.EXT_FIELD_3
												.value(new JdbcNamedParameter(
														"extField3"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TsysOffice> tsysOffice) {
		if (CollectionUtil.isEmpty(tsysOffice)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysOffice,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_OFFICE_TABLE)
								.set(TSYS_OFFICE_TABLE.OFFICE_NAME
												.value(new JdbcNamedParameter(
														"officeName")),
										TSYS_OFFICE_TABLE.SHORT_NAME
												.value(new JdbcNamedParameter(
														"shortName")),
										TSYS_OFFICE_TABLE.PARENT_CODE
												.value(new JdbcNamedParameter(
														"parentCode")),
										TSYS_OFFICE_TABLE.BRANCH_CODE
												.value(new JdbcNamedParameter(
														"branchCode")),
										TSYS_OFFICE_TABLE.DEP_CODE
												.value(new JdbcNamedParameter(
														"depCode")),
										TSYS_OFFICE_TABLE.OFFICE_PATH
												.value(new JdbcNamedParameter(
														"officePath")),
										TSYS_OFFICE_TABLE.BRANCH_LEVEL
												.value(new JdbcNamedParameter(
														"branchLevel")),
										TSYS_OFFICE_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark")),
										TSYS_OFFICE_TABLE.EXT_FIELD_1
												.value(new JdbcNamedParameter(
														"extField1")),
										TSYS_OFFICE_TABLE.EXT_FIELD_2
												.value(new JdbcNamedParameter(
														"extField2")),
										TSYS_OFFICE_TABLE.EXT_FIELD_3
												.value(new JdbcNamedParameter(
														"extField3"))

								)
								.where(TSYS_OFFICE_TABLE.OFFICE_CODE
										.eq(new JdbcNamedParameter("officeCode")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TsysOffice> tsysOffice) {
		if (CollectionUtil.isEmpty(tsysOffice)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysOffice,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_OFFICE_TABLE)
								.where(and(
										TSYS_OFFICE_TABLE.OFFICE_NAME
												.eq(new JdbcNamedParameter(
														"officeName")),
										TSYS_OFFICE_TABLE.SHORT_NAME
												.eq(new JdbcNamedParameter(
														"shortName")),
										TSYS_OFFICE_TABLE.PARENT_CODE
												.eq(new JdbcNamedParameter(
														"parentCode")),
										TSYS_OFFICE_TABLE.BRANCH_CODE
												.eq(new JdbcNamedParameter(
														"branchCode")),
										TSYS_OFFICE_TABLE.DEP_CODE
												.eq(new JdbcNamedParameter(
														"depCode")),
										TSYS_OFFICE_TABLE.OFFICE_PATH
												.eq(new JdbcNamedParameter(
														"officePath")),
										TSYS_OFFICE_TABLE.BRANCH_LEVEL
												.eq(new JdbcNamedParameter(
														"branchLevel")),
										TSYS_OFFICE_TABLE.REMARK
												.eq(new JdbcNamedParameter(
														"remark")),
										TSYS_OFFICE_TABLE.EXT_FIELD_1
												.eq(new JdbcNamedParameter(
														"extField1")),
										TSYS_OFFICE_TABLE.EXT_FIELD_2
												.eq(new JdbcNamedParameter(
														"extField2")),
										TSYS_OFFICE_TABLE.EXT_FIELD_3
												.eq(new JdbcNamedParameter(
														"extField3"))

								));
					}
				});
	}

	public int[] preparedBatchInsert(List<TsysOffice> tsysOffice) {
		return preparedBatchInsert(false, tsysOffice);
	}

}
