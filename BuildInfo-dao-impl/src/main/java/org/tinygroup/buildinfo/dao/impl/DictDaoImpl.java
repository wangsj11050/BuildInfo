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
import static org.tinygroup.buildinfo.dao.inter.constant.DictTable.*;
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

import org.tinygroup.buildinfo.dao.inter.pojo.Dict;
import org.tinygroup.buildinfo.dao.inter.DictDao;

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
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * <!-- end-user-doc -->
 */
public class DictDaoImpl extends TinyDslDaoSupport implements DictDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Dict add(Dict dict) {
		return getDslTemplate().insertAndReturnKey(dict,
				new InsertGenerateCallback<Dict>() {
					public Insert generate(Dict t) {
						Insert insert = insertInto(DICT_TABLE).values(
								DICT_TABLE.DICT_ID.value(t.getDictId()),
								DICT_TABLE.DICT_VALUE.value(t.getDictValue()),
								DICT_TABLE.DICT_NAME.value(t.getDictName()),
								DICT_TABLE.DICT_TYPE.value(t.getDictType()),
								DICT_TABLE.BRANCH_PATH.value(t.getBranchPath())

						);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(Dict dict) {
		if (dict == null || dict.getDictId() == null) {
			return 0;
		}
		return getDslTemplate().update(dict,
				new UpdateGenerateCallback<Dict>() {
					public Update generate(Dict t) {
						Update update = update(DICT_TABLE)
								.set(DICT_TABLE.DICT_VALUE.value(t
										.getDictValue()),
										DICT_TABLE.DICT_NAME.value(t
												.getDictName()),
										DICT_TABLE.DICT_TYPE.value(t
												.getDictType()),
										DICT_TABLE.BRANCH_PATH.value(t
												.getBranchPath())).where(
										DICT_TABLE.DICT_ID.eq(t.getDictId()));
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
		return getDslTemplate().deleteByKey(pk,
				new DeleteGenerateCallback<Serializable>() {
					public Delete generate(Serializable pk) {
						return delete(DICT_TABLE).where(
								DICT_TABLE.DICT_ID.eq(pk));
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
		return getDslTemplate().deleteByKeys(
				new DeleteGenerateCallback<Serializable[]>() {
					public Delete generate(Serializable[] t) {
						return delete(DICT_TABLE).where(
								DICT_TABLE.DICT_ID.in(t));
					}
				}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Dict getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, Dict.class,
				new SelectGenerateCallback<Serializable>() {

					@SuppressWarnings("rawtypes")
					public Select generate(Serializable t) {
						return selectFrom(DICT_TABLE).where(
								DICT_TABLE.DICT_ID.eq(t));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<Dict> query(Dict dict, final OrderBy... orderArgs) {
		if (dict == null) {
			dict = new Dict();
		}
		return getDslTemplate().query(dict, new SelectGenerateCallback<Dict>() {
			@SuppressWarnings("rawtypes")
			public Select generate(Dict t) {
				Select select = selectFrom(DICT_TABLE).where(
						and(DICT_TABLE.DICT_VALUE.eq(t.getDictValue()),
								DICT_TABLE.DICT_NAME.eq(t.getDictName()),
								DICT_TABLE.DICT_TYPE.eq(t.getDictType()),
								DICT_TABLE.BRANCH_PATH.eq(t.getBranchPath())

						));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<Dict> queryPager(int start, int limit, Dict dict,
			final OrderBy... orderArgs) {
		if (dict == null) {
			dict = new Dict();
		}
		return getDslTemplate().queryPager(start, limit, dict, false,
				new SelectGenerateCallback<Dict>() {
					public Select generate(Dict t) {
						Select select = Select
								.selectFrom(DICT_TABLE)
								.where(and(
										DICT_TABLE.DICT_VALUE.eq(t
												.getDictValue()),
										DICT_TABLE.DICT_NAME.eq(t.getDictName()),
										DICT_TABLE.DICT_TYPE.eq(t.getDictType()),
										DICT_TABLE.BRANCH_PATH.eq(t
												.getBranchPath())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<Dict> dict) {
		if (CollectionUtil.isEmpty(dict)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, dict,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(DICT_TABLE).values(
								DICT_TABLE.DICT_VALUE
										.value(new JdbcNamedParameter(
												"dictValue")),
								DICT_TABLE.DICT_NAME
										.value(new JdbcNamedParameter(
												"dictName")),
								DICT_TABLE.DICT_TYPE
										.value(new JdbcNamedParameter(
												"dictType")),
								DICT_TABLE.BRANCH_PATH
										.value(new JdbcNamedParameter(
												"branchPath"))

						);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<Dict> dicts) {
		return batchInsert(true, dicts);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<Dict> dict) {
		if (CollectionUtil.isEmpty(dict)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(dict,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(DICT_TABLE).set(
								DICT_TABLE.DICT_VALUE
										.value(new JdbcNamedParameter(
												"dictValue")),
								DICT_TABLE.DICT_NAME
										.value(new JdbcNamedParameter(
												"dictName")),
								DICT_TABLE.DICT_TYPE
										.value(new JdbcNamedParameter(
												"dictType")),
								DICT_TABLE.BRANCH_PATH
										.value(new JdbcNamedParameter(
												"branchPath"))

						).where(DICT_TABLE.DICT_ID.eq(new JdbcNamedParameter(
								"dictId")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<Dict> dict) {
		if (CollectionUtil.isEmpty(dict)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(dict,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(DICT_TABLE)
								.where(and(
										DICT_TABLE.DICT_VALUE
												.eq(new JdbcNamedParameter(
														"dictValue")),
										DICT_TABLE.DICT_NAME
												.eq(new JdbcNamedParameter(
														"dictName")),
										DICT_TABLE.DICT_TYPE
												.eq(new JdbcNamedParameter(
														"dictType")),
										DICT_TABLE.BRANCH_PATH
												.eq(new JdbcNamedParameter(
														"branchPath"))

								));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<Dict> dict) {
		if (CollectionUtil.isEmpty(dict)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, dict,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(DICT_TABLE).values(
								DICT_TABLE.DICT_VALUE
										.value(new JdbcNamedParameter(
												"dictValue")),
								DICT_TABLE.DICT_NAME
										.value(new JdbcNamedParameter(
												"dictName")),
								DICT_TABLE.DICT_TYPE
										.value(new JdbcNamedParameter(
												"dictType")),
								DICT_TABLE.BRANCH_PATH
										.value(new JdbcNamedParameter(
												"branchPath"))

						);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<Dict> dict) {
		if (CollectionUtil.isEmpty(dict)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(dict,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(DICT_TABLE).set(
								DICT_TABLE.DICT_VALUE
										.value(new JdbcNamedParameter(
												"dictValue")),
								DICT_TABLE.DICT_NAME
										.value(new JdbcNamedParameter(
												"dictName")),
								DICT_TABLE.DICT_TYPE
										.value(new JdbcNamedParameter(
												"dictType")),
								DICT_TABLE.BRANCH_PATH
										.value(new JdbcNamedParameter(
												"branchPath"))

						).where(DICT_TABLE.DICT_ID.eq(new JdbcNamedParameter(
								"dictId")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<Dict> dict) {
		if (CollectionUtil.isEmpty(dict)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(dict,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(DICT_TABLE)
								.where(and(
										DICT_TABLE.DICT_VALUE
												.eq(new JdbcNamedParameter(
														"dictValue")),
										DICT_TABLE.DICT_NAME
												.eq(new JdbcNamedParameter(
														"dictName")),
										DICT_TABLE.DICT_TYPE
												.eq(new JdbcNamedParameter(
														"dictType")),
										DICT_TABLE.BRANCH_PATH
												.eq(new JdbcNamedParameter(
														"branchPath"))

								));
					}
				});
	}

	public int[] preparedBatchInsert(List<Dict> dict) {
		return preparedBatchInsert(false, dict);
	}
}
