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

import static org.tinygroup.buildinfo.dao.inter.constant.TsysDictItemTable.TSYS_DICT_ITEM_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;

import java.io.Serializable;
import java.util.List;

import org.tinygroup.buildinfo.dao.inter.TsysDictItemDao;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysDictItem;
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
public class TsysDictItemDaoImpl extends TinyDslDaoSupport implements
		TsysDictItemDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysDictItem add(TsysDictItem tsysDictItem) {
		return getDslTemplate().insertAndReturnKey(tsysDictItem,
				new InsertGenerateCallback<TsysDictItem>() {
					public Insert generate(TsysDictItem t) {
						Insert insert = insertInto(TSYS_DICT_ITEM_TABLE)
								.values(TSYS_DICT_ITEM_TABLE.ID
										.value(t.getId()),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_CODE
												.value(t.getDictItemCode()),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_CODE
												.value(t.getDictEntryCode()),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_NAME
												.value(t.getDictItemName()),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_ORDER
												.value(t.getDictItemOrder()),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_ID
												.value(t.getDictEntryId())

								);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TsysDictItem tsysDictItem) {
		if (tsysDictItem == null || tsysDictItem.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tsysDictItem,
				new UpdateGenerateCallback<TsysDictItem>() {
					public Update generate(TsysDictItem t) {
						Update update = update(TSYS_DICT_ITEM_TABLE).set(
								TSYS_DICT_ITEM_TABLE.DICT_ITEM_CODE.value(t
										.getDictItemCode()),
								TSYS_DICT_ITEM_TABLE.DICT_ENTRY_CODE.value(t
										.getDictEntryCode()),
								TSYS_DICT_ITEM_TABLE.DICT_ITEM_NAME.value(t
										.getDictItemName()),
								TSYS_DICT_ITEM_TABLE.DICT_ITEM_ORDER.value(t
										.getDictItemOrder()),
								TSYS_DICT_ITEM_TABLE.DICT_ENTRY_ID.value(t
										.getDictEntryId())).where(
								TSYS_DICT_ITEM_TABLE.ID.eq(t.getId()));
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
						return delete(TSYS_DICT_ITEM_TABLE).where(
								TSYS_DICT_ITEM_TABLE.ID.eq(pk));
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
						return delete(TSYS_DICT_ITEM_TABLE).where(
								TSYS_DICT_ITEM_TABLE.ID.in(t));
					}
				}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysDictItem getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, TsysDictItem.class,
				new SelectGenerateCallback<Serializable>() {

					@SuppressWarnings("rawtypes")
					public Select generate(Serializable t) {
						return selectFrom(TSYS_DICT_ITEM_TABLE).where(
								TSYS_DICT_ITEM_TABLE.ID.eq(t));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TsysDictItem> query(TsysDictItem tsysDictItem,
			final OrderBy... orderArgs) {
		if (tsysDictItem == null) {
			tsysDictItem = new TsysDictItem();
		}
		return getDslTemplate().query(tsysDictItem,
				new SelectGenerateCallback<TsysDictItem>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysDictItem t) {
						Select select = selectFrom(TSYS_DICT_ITEM_TABLE).where(
								and(TSYS_DICT_ITEM_TABLE.DICT_ITEM_CODE.eq(t
										.getDictItemCode()),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_CODE
												.eq(t.getDictEntryCode()),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_NAME
												.eq(t.getDictItemName()),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_ORDER
												.eq(t.getDictItemOrder()),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_ID.eq(t
												.getDictEntryId())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TsysDictItem> queryPager(int start, int limit,
			TsysDictItem tsysDictItem, final OrderBy... orderArgs) {
		if (tsysDictItem == null) {
			tsysDictItem = new TsysDictItem();
		}
		return getDslTemplate().queryPager(start, limit, tsysDictItem, false,
				new SelectGenerateCallback<TsysDictItem>() {
					public Select generate(TsysDictItem t) {
						Select select = Select.selectFrom(TSYS_DICT_ITEM_TABLE)
								.where(and(TSYS_DICT_ITEM_TABLE.DICT_ITEM_CODE
										.eq(t.getDictItemCode()),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_CODE
												.eq(t.getDictEntryCode()),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_NAME
												.eq(t.getDictItemName()),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_ORDER
												.eq(t.getDictItemOrder()),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_ID.eq(t
												.getDictEntryId())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}
	
	/**
	 * 用like搜索
	 */
	public Pager<TsysDictItem> queryPagerForSearch(int start, int limit,
			TsysDictItem tsysDictItem, final OrderBy... orderArgs) {
		if (tsysDictItem == null) {
			tsysDictItem = new TsysDictItem();
		}
		return getDslTemplate().queryPager(start, limit, tsysDictItem, false,
				new SelectGenerateCallback<TsysDictItem>() {
					public Select generate(TsysDictItem t) {
						Select select = Select.selectFrom(TSYS_DICT_ITEM_TABLE)
								.where(and(TSYS_DICT_ITEM_TABLE.DICT_ITEM_CODE
										.like(t.getDictItemCode()),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_CODE
												.like(t.getDictEntryCode()),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_NAME
												.like(t.getDictItemName()),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_ORDER
												.eq(t.getDictItemOrder()),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_ID.eq(t
												.getDictEntryId())

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
			List<TsysDictItem> tsysDictItem) {
		if (CollectionUtil.isEmpty(tsysDictItem)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysDictItem,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_DICT_ITEM_TABLE)
								.values(TSYS_DICT_ITEM_TABLE.DICT_ITEM_CODE
										.value(new JdbcNamedParameter(
												"dictItemCode")),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_CODE
												.value(new JdbcNamedParameter(
														"dictEntryCode")),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_NAME
												.value(new JdbcNamedParameter(
														"dictItemName")),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_ORDER
												.value(new JdbcNamedParameter(
														"dictItemOrder")),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_ID
												.value(new JdbcNamedParameter(
														"dictEntryId"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TsysDictItem> tsysDictItems) {
		return batchInsert(true, tsysDictItems);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TsysDictItem> tsysDictItem) {
		if (CollectionUtil.isEmpty(tsysDictItem)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysDictItem,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_DICT_ITEM_TABLE)
								.set(TSYS_DICT_ITEM_TABLE.DICT_ITEM_CODE
										.value(new JdbcNamedParameter(
												"dictItemCode")),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_CODE
												.value(new JdbcNamedParameter(
														"dictEntryCode")),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_NAME
												.value(new JdbcNamedParameter(
														"dictItemName")),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_ORDER
												.value(new JdbcNamedParameter(
														"dictItemOrder")),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_ID
												.value(new JdbcNamedParameter(
														"dictEntryId"))

								).where(TSYS_DICT_ITEM_TABLE.ID
										.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TsysDictItem> tsysDictItem) {
		if (CollectionUtil.isEmpty(tsysDictItem)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysDictItem,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_DICT_ITEM_TABLE).where(
								and(TSYS_DICT_ITEM_TABLE.DICT_ITEM_CODE
										.eq(new JdbcNamedParameter(
												"dictItemCode")),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_CODE
												.eq(new JdbcNamedParameter(
														"dictEntryCode")),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_NAME
												.eq(new JdbcNamedParameter(
														"dictItemName")),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_ORDER
												.eq(new JdbcNamedParameter(
														"dictItemOrder")),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_ID
												.eq(new JdbcNamedParameter(
														"dictEntryId"))

								));
					}
				});
	}

	/**
	 * 根据dict_item_code dict_entry_id获取信息
	 *
	 * @param tsysDictItem
	 * @return
	 */
	public List checkExist(TsysDictItem tsysDictItem) {
		if (tsysDictItem == null) {
			tsysDictItem = new TsysDictItem();
		}
		return getDslTemplate().query(tsysDictItem,
				new SelectGenerateCallback<TsysDictItem>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysDictItem t) {
						Select select = selectFrom(TSYS_DICT_ITEM_TABLE).where(
								and(TSYS_DICT_ITEM_TABLE.DICT_ITEM_CODE.eq(t
										.getDictItemCode()),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_ID.eq(t
												.getDictEntryId())

								));
						return select;
					}
				});
	}
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys,
									 List<TsysDictItem> tsysDictItem) {
		if (CollectionUtil.isEmpty(tsysDictItem)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysDictItem,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_DICT_ITEM_TABLE)
								.values(TSYS_DICT_ITEM_TABLE.DICT_ITEM_CODE
												.value(new JdbcNamedParameter(
														"dictItemCode")),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_CODE
												.value(new JdbcNamedParameter(
														"dictEntryCode")),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_NAME
												.value(new JdbcNamedParameter(
														"dictItemName")),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_ORDER
												.value(new JdbcNamedParameter(
														"dictItemOrder")),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_ID
												.value(new JdbcNamedParameter(
														"dictEntryId"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TsysDictItem> tsysDictItem) {
		if (CollectionUtil.isEmpty(tsysDictItem)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysDictItem,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_DICT_ITEM_TABLE)
								.set(TSYS_DICT_ITEM_TABLE.DICT_ITEM_CODE
												.value(new JdbcNamedParameter(
														"dictItemCode")),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_CODE
												.value(new JdbcNamedParameter(
														"dictEntryCode")),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_NAME
												.value(new JdbcNamedParameter(
														"dictItemName")),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_ORDER
												.value(new JdbcNamedParameter(
														"dictItemOrder")),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_ID
												.value(new JdbcNamedParameter(
														"dictEntryId"))

								).where(TSYS_DICT_ITEM_TABLE.ID
										.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TsysDictItem> tsysDictItem) {
		if (CollectionUtil.isEmpty(tsysDictItem)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysDictItem,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_DICT_ITEM_TABLE).where(
								and(TSYS_DICT_ITEM_TABLE.DICT_ITEM_CODE
												.eq(new JdbcNamedParameter(
														"dictItemCode")),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_CODE
												.eq(new JdbcNamedParameter(
														"dictEntryCode")),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_NAME
												.eq(new JdbcNamedParameter(
														"dictItemName")),
										TSYS_DICT_ITEM_TABLE.DICT_ITEM_ORDER
												.eq(new JdbcNamedParameter(
														"dictItemOrder")),
										TSYS_DICT_ITEM_TABLE.DICT_ENTRY_ID
												.eq(new JdbcNamedParameter(
														"dictEntryId"))

								));
					}
				});
	}

	public int[] preparedBatchInsert(List<TsysDictItem> tsysDictItem) {
		return preparedBatchInsert(true, tsysDictItem);
	}

}

