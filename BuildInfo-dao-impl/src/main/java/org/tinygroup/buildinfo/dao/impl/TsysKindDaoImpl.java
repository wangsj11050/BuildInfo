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

import static org.tinygroup.buildinfo.dao.inter.constant.TsysKindTable.TSYS_KIND_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.select;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;

import java.io.Serializable;
import java.util.List;

import org.tinygroup.buildinfo.dao.inter.TsysKindDao;
import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysKind;
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
 * <!-- begin-user-doc --> 
 * <!-- end-user-doc -->
 */
public class TsysKindDaoImpl extends TinyDslDaoSupport implements TsysKindDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysKind add(TsysKind tsysKind) {
		return getDslTemplate().insertAndReturnKey(tsysKind,
				new InsertGenerateCallback<TsysKind>() {
					public Insert generate(TsysKind t) {
						Insert insert = insertInto(TSYS_KIND_TABLE)
								.values(TSYS_KIND_TABLE.KIND_CODE.value(t
										.getKindCode()),
										TSYS_KIND_TABLE.KIND_TYPE.value(t
												.getKindType()),
										TSYS_KIND_TABLE.KIND_NAME.value(t
												.getKindName()),
										TSYS_KIND_TABLE.PARENT_CODE.value(t
												.getParentCode()),
										TSYS_KIND_TABLE.MNEMONIC.value(t
												.getMnemonic()),
										TSYS_KIND_TABLE.TREE_IDX.value(t
												.getTreeIdx()),
										TSYS_KIND_TABLE.REMARK.value(t
												.getRemark())

								);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TsysKind tsysKind) {
		if (tsysKind == null || tsysKind.getKindCode() == null) {
			return 0;
		}
		return getDslTemplate().update(tsysKind,
				new UpdateGenerateCallback<TsysKind>() {
					public Update generate(TsysKind t) {
						Update update = update(TSYS_KIND_TABLE)
								.set(TSYS_KIND_TABLE.KIND_TYPE.value(t
										.getKindType()),
										TSYS_KIND_TABLE.KIND_NAME.value(t
												.getKindName()),
										TSYS_KIND_TABLE.PARENT_CODE.value(t
												.getParentCode()),
										TSYS_KIND_TABLE.MNEMONIC.value(t
												.getMnemonic()),
										TSYS_KIND_TABLE.TREE_IDX.value(t
												.getTreeIdx()),
										TSYS_KIND_TABLE.REMARK.value(t
												.getRemark())).where(
										TSYS_KIND_TABLE.KIND_CODE.eq(t
												.getKindCode()));
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
						return delete(TSYS_KIND_TABLE).where(
								TSYS_KIND_TABLE.KIND_CODE.eq(pk));
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
						return delete(TSYS_KIND_TABLE).where(
								TSYS_KIND_TABLE.KIND_CODE.in(t));
					}
				}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysKind getByKey(String pk) {
		return getDslTemplate().getByKey(pk, TsysKind.class,
				new SelectGenerateCallback<Serializable>() {

					@SuppressWarnings("rawtypes")
					public Select generate(Serializable t) {
						return selectFrom(TSYS_KIND_TABLE).where(
								TSYS_KIND_TABLE.KIND_CODE.eq(t));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TsysKind> query(TsysKind tsysKind, final OrderBy... orderArgs) {
		if (tsysKind == null) {
			tsysKind = new TsysKind();
		}
		return getDslTemplate().query(tsysKind,
				new SelectGenerateCallback<TsysKind>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysKind t) {
						Select select = selectFrom(TSYS_KIND_TABLE)
								.where(and(
										TSYS_KIND_TABLE.KIND_CODE.eq(t
												.getKindCode()),
										TSYS_KIND_TABLE.KIND_TYPE.eq(t
												.getKindType()),
										TSYS_KIND_TABLE.KIND_NAME.eq(t
												.getKindName()),
										TSYS_KIND_TABLE.PARENT_CODE.eq(t
												.getParentCode()),
										TSYS_KIND_TABLE.MNEMONIC.eq(t
												.getMnemonic()),
										TSYS_KIND_TABLE.TREE_IDX.eq(t
												.getTreeIdx()),
										TSYS_KIND_TABLE.REMARK.eq(t.getRemark())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TsysKind> queryPager(int start, int limit, TsysKind tsysKind,
			final OrderBy... orderArgs) {
		if (tsysKind == null) {
			tsysKind = new TsysKind();
		}
		return getDslTemplate().queryPager(start, limit, tsysKind, false,
				new SelectGenerateCallback<TsysKind>() {
					public Select generate(TsysKind t) {
						Select select = Select
								.selectFrom(TSYS_KIND_TABLE)
								.where(and(
										TSYS_KIND_TABLE.KIND_CODE.eq(t
												.getKindCode()),
										TSYS_KIND_TABLE.KIND_TYPE.eq(t
												.getKindType()),
										TSYS_KIND_TABLE.KIND_NAME.eq(t
												.getKindName()),
										TSYS_KIND_TABLE.PARENT_CODE.eq(t
												.getParentCode()),
										TSYS_KIND_TABLE.MNEMONIC.eq(t
												.getMnemonic()),
										TSYS_KIND_TABLE.TREE_IDX.eq(t
												.getTreeIdx()),
										TSYS_KIND_TABLE.REMARK.eq(t.getRemark())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}
	
	/**
	 * like 搜索
	 */
	public Pager<TsysKind> queryPagerForSearch(int start, int limit, TsysKind tsysKind,
			final OrderBy... orderArgs) {
		if (tsysKind == null) {
			tsysKind = new TsysKind();
		}
		return getDslTemplate().queryPager(start, limit, tsysKind, false,
				new SelectGenerateCallback<TsysKind>() {
					public Select generate(TsysKind t) {
						Select select = Select
								.selectFrom(TSYS_KIND_TABLE)
								.where(and(
										TSYS_KIND_TABLE.KIND_CODE.like(t
												.getKindCode()),
										TSYS_KIND_TABLE.KIND_TYPE.like(t
												.getKindType()),
										TSYS_KIND_TABLE.KIND_NAME.like(t
												.getKindName()),
										TSYS_KIND_TABLE.PARENT_CODE.like(t
												.getParentCode()),
										TSYS_KIND_TABLE.MNEMONIC.like(t
												.getMnemonic()),
										TSYS_KIND_TABLE.TREE_IDX.like(t
												.getTreeIdx()),
										TSYS_KIND_TABLE.REMARK.like(t.getRemark())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<TsysKind> tsysKind) {
		if (CollectionUtil.isEmpty(tsysKind)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysKind,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_KIND_TABLE)
								.values(TSYS_KIND_TABLE.KIND_TYPE
										.value(new JdbcNamedParameter(
												"kindType")),
										TSYS_KIND_TABLE.KIND_NAME
												.value(new JdbcNamedParameter(
														"kindName")),
										TSYS_KIND_TABLE.PARENT_CODE
												.value(new JdbcNamedParameter(
														"parentCode")),
										TSYS_KIND_TABLE.MNEMONIC
												.value(new JdbcNamedParameter(
														"mnemonic")),
										TSYS_KIND_TABLE.TREE_IDX
												.value(new JdbcNamedParameter(
														"treeIdx")),
										TSYS_KIND_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TsysKind> tsysKinds) {
		return batchInsert(true, tsysKinds);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TsysKind> tsysKind) {
		if (CollectionUtil.isEmpty(tsysKind)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysKind,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_KIND_TABLE)
								.set(TSYS_KIND_TABLE.KIND_TYPE
										.value(new JdbcNamedParameter(
												"kindType")),
										TSYS_KIND_TABLE.KIND_NAME
												.value(new JdbcNamedParameter(
														"kindName")),
										TSYS_KIND_TABLE.PARENT_CODE
												.value(new JdbcNamedParameter(
														"parentCode")),
										TSYS_KIND_TABLE.MNEMONIC
												.value(new JdbcNamedParameter(
														"mnemonic")),
										TSYS_KIND_TABLE.TREE_IDX
												.value(new JdbcNamedParameter(
														"treeIdx")),
										TSYS_KIND_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark"))

								)
								.where(TSYS_KIND_TABLE.KIND_CODE
										.eq(new JdbcNamedParameter("kindCode")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TsysKind> tsysKind) {
		if (CollectionUtil.isEmpty(tsysKind)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysKind,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_KIND_TABLE)
								.where(and(
										TSYS_KIND_TABLE.KIND_TYPE
												.eq(new JdbcNamedParameter(
														"kindType")),
										TSYS_KIND_TABLE.KIND_NAME
												.eq(new JdbcNamedParameter(
														"kindName")),
										TSYS_KIND_TABLE.PARENT_CODE
												.eq(new JdbcNamedParameter(
														"parentCode")),
										TSYS_KIND_TABLE.MNEMONIC
												.eq(new JdbcNamedParameter(
														"mnemonic")),
										TSYS_KIND_TABLE.TREE_IDX
												.eq(new JdbcNamedParameter(
														"treeIdx")),
										TSYS_KIND_TABLE.REMARK
												.eq(new JdbcNamedParameter(
														"remark"))

								));
					}
				});
	}

	public List getKindTree(TreeData tree) {
		if(tree == null){
			tree = new TreeData();
		}
		return getDslTemplate().query(tree,new SelectGenerateCallback<TreeData>() {

			@SuppressWarnings("rawtypes")
			public Select generate(TreeData t) {
				Select select = 
						select(
							TSYS_KIND_TABLE.PARENT_CODE.as("pid"),
							TSYS_KIND_TABLE.KIND_CODE.as("id"),
							TSYS_KIND_TABLE.KIND_NAME.as("name")).from(TSYS_KIND_TABLE).where(and(
									TSYS_KIND_TABLE.PARENT_CODE.eq(t.getpId()),
									TSYS_KIND_TABLE.KIND_CODE.eq(t.getId()),
									TSYS_KIND_TABLE.KIND_NAME.eq(t.getName())
							));
				return select;
			}
			
		} );
	}

	/**
	 * 根据kind_code 获取信息
	 *
	 * @param t
	 * @return
	 */
	public List checkExist(TsysKind tsysKind) {
		if (tsysKind == null) {
			tsysKind = new TsysKind();
		}
		return getDslTemplate().query(tsysKind,
				new SelectGenerateCallback<TsysKind>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysKind t) {
						Select select = selectFrom(TSYS_KIND_TABLE)
								.where(and(
										TSYS_KIND_TABLE.KIND_CODE.eq(t
												.getKindCode())
								));
						return select;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys,
									 List<TsysKind> tsysKind) {
		if (CollectionUtil.isEmpty(tsysKind)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysKind,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_KIND_TABLE)
								.values(TSYS_KIND_TABLE.KIND_TYPE
												.value(new JdbcNamedParameter(
														"kindType")),
										TSYS_KIND_TABLE.KIND_NAME
												.value(new JdbcNamedParameter(
														"kindName")),
										TSYS_KIND_TABLE.PARENT_CODE
												.value(new JdbcNamedParameter(
														"parentCode")),
										TSYS_KIND_TABLE.MNEMONIC
												.value(new JdbcNamedParameter(
														"mnemonic")),
										TSYS_KIND_TABLE.TREE_IDX
												.value(new JdbcNamedParameter(
														"treeIdx")),
										TSYS_KIND_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TsysKind> tsysKind) {
		if (CollectionUtil.isEmpty(tsysKind)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysKind,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_KIND_TABLE)
								.set(TSYS_KIND_TABLE.KIND_TYPE
												.value(new JdbcNamedParameter(
														"kindType")),
										TSYS_KIND_TABLE.KIND_NAME
												.value(new JdbcNamedParameter(
														"kindName")),
										TSYS_KIND_TABLE.PARENT_CODE
												.value(new JdbcNamedParameter(
														"parentCode")),
										TSYS_KIND_TABLE.MNEMONIC
												.value(new JdbcNamedParameter(
														"mnemonic")),
										TSYS_KIND_TABLE.TREE_IDX
												.value(new JdbcNamedParameter(
														"treeIdx")),
										TSYS_KIND_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark"))

								)
								.where(TSYS_KIND_TABLE.KIND_CODE
										.eq(new JdbcNamedParameter("kindCode")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TsysKind> tsysKind) {
		if (CollectionUtil.isEmpty(tsysKind)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysKind,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_KIND_TABLE)
								.where(and(
										TSYS_KIND_TABLE.KIND_TYPE
												.eq(new JdbcNamedParameter(
														"kindType")),
										TSYS_KIND_TABLE.KIND_NAME
												.eq(new JdbcNamedParameter(
														"kindName")),
										TSYS_KIND_TABLE.PARENT_CODE
												.eq(new JdbcNamedParameter(
														"parentCode")),
										TSYS_KIND_TABLE.MNEMONIC
												.eq(new JdbcNamedParameter(
														"mnemonic")),
										TSYS_KIND_TABLE.TREE_IDX
												.eq(new JdbcNamedParameter(
														"treeIdx")),
										TSYS_KIND_TABLE.REMARK
												.eq(new JdbcNamedParameter(
														"remark"))

								));
					}
				});
	}

	public int[] preparedBatchInsert(List<TsysKind> tsysKind) {
		return preparedBatchInsert(false, tsysKind);
	}
}
