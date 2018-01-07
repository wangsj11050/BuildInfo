/**
 *  Copyright (c) 2012-2016, www.tinygroup.org (luo_guo@icloud.com).
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

package org.tinygroup.buildinfo.ext.dao.impl;

import static org.tinygroup.buildinfo.ext.dao.inter.constant.TsysUserRightTable.TSYS_USER_RIGHT_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;

import java.io.Serializable;
import java.util.List;

import org.tinygroup.buildinfo.ext.dao.inter.TsysUserRightDao;
import org.tinygroup.buildinfo.ext.dao.inter.pojo.TsysUserRight;
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
public class TsysUserRightDaoImpl extends TinyDslDaoSupport implements
		TsysUserRightDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysUserRight add(TsysUserRight tsysUserRight) {
		return getDslTemplate().insertAndReturnKey(tsysUserRight,
				new InsertGenerateCallback<TsysUserRight>() {
					public Insert generate(TsysUserRight t) {
						Insert insert = insertInto(TSYS_USER_RIGHT_TABLE)
								.values(TSYS_USER_RIGHT_TABLE.ID.value(t
										.getId()),
										TSYS_USER_RIGHT_TABLE.USER_ID.value(t
												.getUserId()),
										TSYS_USER_RIGHT_TABLE.MENU_ID.value(t
												.getMenuId()),
										TSYS_USER_RIGHT_TABLE.CREATE_BY.value(t
												.getCreateBy()),
										TSYS_USER_RIGHT_TABLE.CREATE_DATE
												.value(t.getCreateDate()),
										TSYS_USER_RIGHT_TABLE.BEGIN_DATE
												.value(t.getBeginDate()),
										TSYS_USER_RIGHT_TABLE.END_DATE.value(t
												.getEndDate()),
										TSYS_USER_RIGHT_TABLE.RIGHT_FLAG
												.value(t.getRightFlag())

								);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TsysUserRight tsysUserRight) {
		if (tsysUserRight == null || tsysUserRight.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tsysUserRight,
				new UpdateGenerateCallback<TsysUserRight>() {
					public Update generate(TsysUserRight t) {
						Update update = update(TSYS_USER_RIGHT_TABLE).set(
								TSYS_USER_RIGHT_TABLE.USER_ID.value(t
										.getUserId()),
								TSYS_USER_RIGHT_TABLE.MENU_ID.value(t
										.getMenuId()),
								TSYS_USER_RIGHT_TABLE.CREATE_BY.value(t
										.getCreateBy()),
								TSYS_USER_RIGHT_TABLE.CREATE_DATE.value(t
										.getCreateDate()),
								TSYS_USER_RIGHT_TABLE.BEGIN_DATE.value(t
										.getBeginDate()),
								TSYS_USER_RIGHT_TABLE.END_DATE.value(t
										.getEndDate()),
								TSYS_USER_RIGHT_TABLE.RIGHT_FLAG.value(t
										.getRightFlag())).where(
								TSYS_USER_RIGHT_TABLE.ID.eq(t.getId()));
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
						return delete(TSYS_USER_RIGHT_TABLE).where(
								TSYS_USER_RIGHT_TABLE.ID.eq(pk));
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
						return delete(TSYS_USER_RIGHT_TABLE).where(
								TSYS_USER_RIGHT_TABLE.ID.in(t));
					}
				}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysUserRight getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, TsysUserRight.class,
				new SelectGenerateCallback<Serializable>() {

					@SuppressWarnings("rawtypes")
					public Select generate(Serializable t) {
						return selectFrom(TSYS_USER_RIGHT_TABLE).where(
								TSYS_USER_RIGHT_TABLE.ID.eq(t));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TsysUserRight> query(TsysUserRight tsysUserRight,
			final OrderBy... orderArgs) {
		if (tsysUserRight == null) {
			tsysUserRight = new TsysUserRight();
		}
		return getDslTemplate().query(tsysUserRight,
				new SelectGenerateCallback<TsysUserRight>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysUserRight t) {
						Select select = selectFrom(TSYS_USER_RIGHT_TABLE)
								.where(and(TSYS_USER_RIGHT_TABLE.ID.eq(t
										.getId()),
										TSYS_USER_RIGHT_TABLE.USER_ID.eq(t
												.getUserId()),
										TSYS_USER_RIGHT_TABLE.MENU_ID.eq(t
												.getMenuId()),
										TSYS_USER_RIGHT_TABLE.CREATE_BY.eq(t
												.getCreateBy()),
										TSYS_USER_RIGHT_TABLE.CREATE_DATE.eq(t
												.getCreateDate()),
										TSYS_USER_RIGHT_TABLE.BEGIN_DATE.eq(t
												.getBeginDate()),
										TSYS_USER_RIGHT_TABLE.END_DATE.eq(t
												.getEndDate()),
										TSYS_USER_RIGHT_TABLE.RIGHT_FLAG.eq(t
												.getRightFlag())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TsysUserRight> queryPager(int start, int limit,
			TsysUserRight tsysUserRight, final OrderBy... orderArgs) {
		if (tsysUserRight == null) {
			tsysUserRight = new TsysUserRight();
		}
		return getDslTemplate().queryPager(start, limit, tsysUserRight, false,
				new SelectGenerateCallback<TsysUserRight>() {
					public Select generate(TsysUserRight t) {
						Select select = Select
								.selectFrom(TSYS_USER_RIGHT_TABLE)
								.where(and(TSYS_USER_RIGHT_TABLE.ID.eq(t
										.getId()),
										TSYS_USER_RIGHT_TABLE.USER_ID.eq(t
												.getUserId()),
										TSYS_USER_RIGHT_TABLE.MENU_ID.eq(t
												.getMenuId()),
										TSYS_USER_RIGHT_TABLE.CREATE_BY.eq(t
												.getCreateBy()),
										TSYS_USER_RIGHT_TABLE.CREATE_DATE.eq(t
												.getCreateDate()),
										TSYS_USER_RIGHT_TABLE.BEGIN_DATE.eq(t
												.getBeginDate()),
										TSYS_USER_RIGHT_TABLE.END_DATE.eq(t
												.getEndDate()),
										TSYS_USER_RIGHT_TABLE.RIGHT_FLAG.eq(t
												.getRightFlag())

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
			List<TsysUserRight> tsysUserRight) {
		if (CollectionUtil.isEmpty(tsysUserRight)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysUserRight,
				new InsertGenerateCallback<TsysUserRight>() {

					public Insert generate(TsysUserRight t) {
						return insertInto(TSYS_USER_RIGHT_TABLE).values(
								TSYS_USER_RIGHT_TABLE.ID.value(t.getId()),
								TSYS_USER_RIGHT_TABLE.USER_ID.value(t
										.getUserId()),
								TSYS_USER_RIGHT_TABLE.MENU_ID.value(t
										.getMenuId()),
								TSYS_USER_RIGHT_TABLE.CREATE_BY.value(t
										.getCreateBy()),
								TSYS_USER_RIGHT_TABLE.CREATE_DATE.value(t
										.getCreateDate()),
								TSYS_USER_RIGHT_TABLE.BEGIN_DATE.value(t
										.getBeginDate()),
								TSYS_USER_RIGHT_TABLE.END_DATE.value(t
										.getEndDate()),
								TSYS_USER_RIGHT_TABLE.RIGHT_FLAG.value(t
										.getRightFlag())

						);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TsysUserRight> tsysUserRights) {
		return batchInsert(true, tsysUserRights);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TsysUserRight> tsysUserRight) {
		if (CollectionUtil.isEmpty(tsysUserRight)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysUserRight,
				new UpdateGenerateCallback<TsysUserRight>() {
					public Update generate(TsysUserRight t) {
						return update(TSYS_USER_RIGHT_TABLE).set(
								TSYS_USER_RIGHT_TABLE.USER_ID.value(t
										.getUserId()),
								TSYS_USER_RIGHT_TABLE.MENU_ID.value(t
										.getMenuId()),
								TSYS_USER_RIGHT_TABLE.CREATE_BY.value(t
										.getCreateBy()),
								TSYS_USER_RIGHT_TABLE.CREATE_DATE.value(t
										.getCreateDate()),
								TSYS_USER_RIGHT_TABLE.BEGIN_DATE.value(t
										.getBeginDate()),
								TSYS_USER_RIGHT_TABLE.END_DATE.value(t
										.getEndDate()),
								TSYS_USER_RIGHT_TABLE.RIGHT_FLAG.value(t
										.getRightFlag())

						).where(TSYS_USER_RIGHT_TABLE.ID.eq(t.getId()));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TsysUserRight> tsysUserRight) {
		if (CollectionUtil.isEmpty(tsysUserRight)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysUserRight,
				new DeleteGenerateCallback<TsysUserRight>() {
					public Delete generate(TsysUserRight t) {
						return delete(TSYS_USER_RIGHT_TABLE).where(
								and(TSYS_USER_RIGHT_TABLE.ID.eq(t.getId()),
										TSYS_USER_RIGHT_TABLE.USER_ID.eq(t
												.getUserId()),
										TSYS_USER_RIGHT_TABLE.MENU_ID.eq(t
												.getMenuId()),
										TSYS_USER_RIGHT_TABLE.CREATE_BY.eq(t
												.getCreateBy()),
										TSYS_USER_RIGHT_TABLE.CREATE_DATE.eq(t
												.getCreateDate()),
										TSYS_USER_RIGHT_TABLE.BEGIN_DATE.eq(t
												.getBeginDate()),
										TSYS_USER_RIGHT_TABLE.END_DATE.eq(t
												.getEndDate()),
										TSYS_USER_RIGHT_TABLE.RIGHT_FLAG.eq(t
												.getRightFlag())

								));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys,
			List<TsysUserRight> tsysUserRight) {
		if (CollectionUtil.isEmpty(tsysUserRight)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysUserRight,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_USER_RIGHT_TABLE)
								.values(TSYS_USER_RIGHT_TABLE.USER_ID
										.value(new JdbcNamedParameter("userId")),
										TSYS_USER_RIGHT_TABLE.MENU_ID
												.value(new JdbcNamedParameter(
														"menuId")),
										TSYS_USER_RIGHT_TABLE.CREATE_BY
												.value(new JdbcNamedParameter(
														"createBy")),
										TSYS_USER_RIGHT_TABLE.CREATE_DATE
												.value(new JdbcNamedParameter(
														"createDate")),
										TSYS_USER_RIGHT_TABLE.BEGIN_DATE
												.value(new JdbcNamedParameter(
														"beginDate")),
										TSYS_USER_RIGHT_TABLE.END_DATE
												.value(new JdbcNamedParameter(
														"endDate")),
										TSYS_USER_RIGHT_TABLE.RIGHT_FLAG
												.value(new JdbcNamedParameter(
														"rightFlag"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TsysUserRight> tsysUserRight) {
		if (CollectionUtil.isEmpty(tsysUserRight)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysUserRight,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_USER_RIGHT_TABLE)
								.set(TSYS_USER_RIGHT_TABLE.USER_ID
										.value(new JdbcNamedParameter("userId")),
										TSYS_USER_RIGHT_TABLE.MENU_ID
												.value(new JdbcNamedParameter(
														"menuId")),
										TSYS_USER_RIGHT_TABLE.CREATE_BY
												.value(new JdbcNamedParameter(
														"createBy")),
										TSYS_USER_RIGHT_TABLE.CREATE_DATE
												.value(new JdbcNamedParameter(
														"createDate")),
										TSYS_USER_RIGHT_TABLE.BEGIN_DATE
												.value(new JdbcNamedParameter(
														"beginDate")),
										TSYS_USER_RIGHT_TABLE.END_DATE
												.value(new JdbcNamedParameter(
														"endDate")),
										TSYS_USER_RIGHT_TABLE.RIGHT_FLAG
												.value(new JdbcNamedParameter(
														"rightFlag"))

								).where(TSYS_USER_RIGHT_TABLE.ID
										.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TsysUserRight> tsysUserRight) {
		if (CollectionUtil.isEmpty(tsysUserRight)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysUserRight,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_USER_RIGHT_TABLE).where(
								and(TSYS_USER_RIGHT_TABLE.USER_ID
										.eq(new JdbcNamedParameter("userId")),
										TSYS_USER_RIGHT_TABLE.MENU_ID
												.eq(new JdbcNamedParameter(
														"menuId")),
										TSYS_USER_RIGHT_TABLE.CREATE_BY
												.eq(new JdbcNamedParameter(
														"createBy")),
										TSYS_USER_RIGHT_TABLE.CREATE_DATE
												.eq(new JdbcNamedParameter(
														"createDate")),
										TSYS_USER_RIGHT_TABLE.BEGIN_DATE
												.eq(new JdbcNamedParameter(
														"beginDate")),
										TSYS_USER_RIGHT_TABLE.END_DATE
												.eq(new JdbcNamedParameter(
														"endDate")),
										TSYS_USER_RIGHT_TABLE.RIGHT_FLAG
												.eq(new JdbcNamedParameter(
														"rightFlag"))

								));
					}
				});
	}

	public int[] preparedBatchInsert(List<TsysUserRight> tsysUserRight) {
		return preparedBatchInsert(true, tsysUserRight);
	}

}
