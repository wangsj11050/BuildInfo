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

import static org.tinygroup.buildinfo.dao.inter.constant.TsysDictEntryTable.TSYS_DICT_ENTRY_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;

import java.io.Serializable;
import java.util.List;

import org.tinygroup.buildinfo.dao.inter.TsysDictEntryDao;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysDictEntry;
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
public class TsysDictEntryDaoImpl extends TinyDslDaoSupport implements
		TsysDictEntryDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysDictEntry add(TsysDictEntry tsysDictEntry) {
		return getDslTemplate().insertAndReturnKey(tsysDictEntry,
				new InsertGenerateCallback<TsysDictEntry>() {
					public Insert generate(TsysDictEntry t) {
						Insert insert = insertInto(TSYS_DICT_ENTRY_TABLE)
								.values(TSYS_DICT_ENTRY_TABLE.ID.value(t
										.getId()),
										TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_CODE
												.value(t.getDictEntryCode()),
										TSYS_DICT_ENTRY_TABLE.KIND_CODE.value(t
												.getKindCode()),
										TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_NAME
												.value(t.getDictEntryName()),
										TSYS_DICT_ENTRY_TABLE.CTRL_FLAG.value(t
												.getCtrlFlag()),
										TSYS_DICT_ENTRY_TABLE.REMARK.value(t
												.getRemark())

								);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TsysDictEntry tsysDictEntry) {
		if (tsysDictEntry == null || tsysDictEntry.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tsysDictEntry,
				new UpdateGenerateCallback<TsysDictEntry>() {
					public Update generate(TsysDictEntry t) {
						Update update = update(TSYS_DICT_ENTRY_TABLE).set(
								TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_CODE.value(t
										.getDictEntryCode()),
								TSYS_DICT_ENTRY_TABLE.KIND_CODE.value(t
										.getKindCode()),
								TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_NAME.value(t
										.getDictEntryName()),
								TSYS_DICT_ENTRY_TABLE.CTRL_FLAG.value(t
										.getCtrlFlag()),
								TSYS_DICT_ENTRY_TABLE.REMARK.value(t
										.getRemark())).where(
								TSYS_DICT_ENTRY_TABLE.ID.eq(t.getId()));
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
						return delete(TSYS_DICT_ENTRY_TABLE).where(
								TSYS_DICT_ENTRY_TABLE.ID.eq(pk));
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
						return delete(TSYS_DICT_ENTRY_TABLE).where(
								TSYS_DICT_ENTRY_TABLE.ID.in(t));
					}
				}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysDictEntry getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, TsysDictEntry.class,
				new SelectGenerateCallback<Serializable>() {

					@SuppressWarnings("rawtypes")
					public Select generate(Serializable t) {
						return selectFrom(TSYS_DICT_ENTRY_TABLE).where(
								TSYS_DICT_ENTRY_TABLE.ID.eq(t));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TsysDictEntry> query(TsysDictEntry tsysDictEntry,
			final OrderBy... orderArgs) {
		if (tsysDictEntry == null) {
			tsysDictEntry = new TsysDictEntry();
		}
		return getDslTemplate().query(tsysDictEntry,
				new SelectGenerateCallback<TsysDictEntry>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysDictEntry t) {
						Select select = selectFrom(TSYS_DICT_ENTRY_TABLE)
								.where(and(
										TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_CODE
												.eq(t.getDictEntryCode()),
										TSYS_DICT_ENTRY_TABLE.KIND_CODE.eq(t
												.getKindCode()),
										TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_NAME
												.eq(t.getDictEntryName()),
										TSYS_DICT_ENTRY_TABLE.CTRL_FLAG.eq(t
												.getCtrlFlag()),
										TSYS_DICT_ENTRY_TABLE.REMARK.eq(t
												.getRemark())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TsysDictEntry> queryPager(int start, int limit,
			TsysDictEntry tsysDictEntry, final OrderBy... orderArgs) {
		if (tsysDictEntry == null) {
			tsysDictEntry = new TsysDictEntry();
		}
		return getDslTemplate().queryPager(start, limit, tsysDictEntry, false,
				new SelectGenerateCallback<TsysDictEntry>() {
					public Select generate(TsysDictEntry t) {
						Select select = Select
								.selectFrom(TSYS_DICT_ENTRY_TABLE)
								.where(and(
										TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_CODE
												.eq(t.getDictEntryCode()),
										TSYS_DICT_ENTRY_TABLE.KIND_CODE.eq(t
												.getKindCode()),
										TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_NAME
												.eq(t.getDictEntryName()),
										TSYS_DICT_ENTRY_TABLE.CTRL_FLAG.eq(t
												.getCtrlFlag()),
										TSYS_DICT_ENTRY_TABLE.REMARK.eq(t
												.getRemark())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}
	/**
	 * 搜索用like查询
	 */
	public Pager<TsysDictEntry> queryPagerForSearch(int start, int limit,
			TsysDictEntry tsysDictEntry, final OrderBy... orderArgs) {
		if (tsysDictEntry == null) {
			tsysDictEntry = new TsysDictEntry();
		}
		return getDslTemplate().queryPager(start, limit, tsysDictEntry, false,
				new SelectGenerateCallback<TsysDictEntry>() {
					public Select generate(TsysDictEntry t) {
						Select select = Select
								.selectFrom(TSYS_DICT_ENTRY_TABLE)
								.where(and(
										TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_CODE
												.like(t.getDictEntryCode()),
										TSYS_DICT_ENTRY_TABLE.KIND_CODE.like(t
												.getKindCode()),
										TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_NAME
												.like(t.getDictEntryName()),
										TSYS_DICT_ENTRY_TABLE.CTRL_FLAG.like(t
												.getCtrlFlag()),
										TSYS_DICT_ENTRY_TABLE.REMARK.like(t
												.getRemark())

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
			List<TsysDictEntry> tsysDictEntry) {
		if (CollectionUtil.isEmpty(tsysDictEntry)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysDictEntry,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_DICT_ENTRY_TABLE)
								.values(TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_CODE
										.value(new JdbcNamedParameter(
												"dictEntryCode")),
										TSYS_DICT_ENTRY_TABLE.KIND_CODE
												.value(new JdbcNamedParameter(
														"kindCode")),
										TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_NAME
												.value(new JdbcNamedParameter(
														"dictEntryName")),
										TSYS_DICT_ENTRY_TABLE.CTRL_FLAG
												.value(new JdbcNamedParameter(
														"ctrlFlag")),
										TSYS_DICT_ENTRY_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TsysDictEntry> tsysDictEntrys) {
		return batchInsert(true, tsysDictEntrys);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TsysDictEntry> tsysDictEntry) {
		if (CollectionUtil.isEmpty(tsysDictEntry)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysDictEntry,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_DICT_ENTRY_TABLE)
								.set(TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_CODE
										.value(new JdbcNamedParameter(
												"dictEntryCode")),
										TSYS_DICT_ENTRY_TABLE.KIND_CODE
												.value(new JdbcNamedParameter(
														"kindCode")),
										TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_NAME
												.value(new JdbcNamedParameter(
														"dictEntryName")),
										TSYS_DICT_ENTRY_TABLE.CTRL_FLAG
												.value(new JdbcNamedParameter(
														"ctrlFlag")),
										TSYS_DICT_ENTRY_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark"))

								).where(TSYS_DICT_ENTRY_TABLE.ID
										.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TsysDictEntry> tsysDictEntry) {
		if (CollectionUtil.isEmpty(tsysDictEntry)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysDictEntry,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_DICT_ENTRY_TABLE).where(
								and(TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_CODE
										.eq(new JdbcNamedParameter(
												"dictEntryCode")),
										TSYS_DICT_ENTRY_TABLE.KIND_CODE
												.eq(new JdbcNamedParameter(
														"kindCode")),
										TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_NAME
												.eq(new JdbcNamedParameter(
														"dictEntryName")),
										TSYS_DICT_ENTRY_TABLE.CTRL_FLAG
												.eq(new JdbcNamedParameter(
														"ctrlFlag")),
										TSYS_DICT_ENTRY_TABLE.REMARK
												.eq(new JdbcNamedParameter(
														"remark"))

								));
					}
				});
	}

	/**
	 * 根据dict_entry_code获取信息
	 *
	 * @param t
	 * @return
	 */
	public List checkExist(TsysDictEntry tsysDictEntry) {
		if (tsysDictEntry == null) {
			tsysDictEntry = new TsysDictEntry();
		}
		return getDslTemplate().query(tsysDictEntry,
				new SelectGenerateCallback<TsysDictEntry>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysDictEntry t) {
						Select select = selectFrom(TSYS_DICT_ENTRY_TABLE)
								.where(and(
										TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_CODE
												.eq(t.getDictEntryCode())
								));
						return select;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys,
									 List<TsysDictEntry> tsysDictEntry) {
		if (CollectionUtil.isEmpty(tsysDictEntry)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysDictEntry,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_DICT_ENTRY_TABLE)
								.values(TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_CODE
												.value(new JdbcNamedParameter(
														"dictEntryCode")),
										TSYS_DICT_ENTRY_TABLE.KIND_CODE
												.value(new JdbcNamedParameter(
														"kindCode")),
										TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_NAME
												.value(new JdbcNamedParameter(
														"dictEntryName")),
										TSYS_DICT_ENTRY_TABLE.CTRL_FLAG
												.value(new JdbcNamedParameter(
														"ctrlFlag")),
										TSYS_DICT_ENTRY_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TsysDictEntry> tsysDictEntry) {
		if (CollectionUtil.isEmpty(tsysDictEntry)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysDictEntry,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_DICT_ENTRY_TABLE)
								.set(TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_CODE
												.value(new JdbcNamedParameter(
														"dictEntryCode")),
										TSYS_DICT_ENTRY_TABLE.KIND_CODE
												.value(new JdbcNamedParameter(
														"kindCode")),
										TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_NAME
												.value(new JdbcNamedParameter(
														"dictEntryName")),
										TSYS_DICT_ENTRY_TABLE.CTRL_FLAG
												.value(new JdbcNamedParameter(
														"ctrlFlag")),
										TSYS_DICT_ENTRY_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark"))

								).where(TSYS_DICT_ENTRY_TABLE.ID
										.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TsysDictEntry> tsysDictEntry) {
		if (CollectionUtil.isEmpty(tsysDictEntry)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysDictEntry,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_DICT_ENTRY_TABLE).where(
								and(TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_CODE
												.eq(new JdbcNamedParameter(
														"dictEntryCode")),
										TSYS_DICT_ENTRY_TABLE.KIND_CODE
												.eq(new JdbcNamedParameter(
														"kindCode")),
										TSYS_DICT_ENTRY_TABLE.DICT_ENTRY_NAME
												.eq(new JdbcNamedParameter(
														"dictEntryName")),
										TSYS_DICT_ENTRY_TABLE.CTRL_FLAG
												.eq(new JdbcNamedParameter(
														"ctrlFlag")),
										TSYS_DICT_ENTRY_TABLE.REMARK
												.eq(new JdbcNamedParameter(
														"remark"))

								));
					}
				});
	}

	public int[] preparedBatchInsert(List<TsysDictEntry> tsysDictEntry) {
		return preparedBatchInsert(true, tsysDictEntry);
	}
}
