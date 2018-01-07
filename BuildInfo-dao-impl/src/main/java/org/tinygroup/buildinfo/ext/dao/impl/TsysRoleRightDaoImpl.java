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

import static org.tinygroup.buildinfo.ext.dao.inter.constant.TsysRoleRightTable.TSYS_ROLE_RIGHT_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;

import java.io.Serializable;
import java.util.List;

import org.tinygroup.buildinfo.ext.dao.inter.TsysRoleRightDao;
import org.tinygroup.buildinfo.ext.dao.inter.pojo.TsysRoleRight;
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
public class TsysRoleRightDaoImpl extends TinyDslDaoSupport implements
		TsysRoleRightDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysRoleRight add(TsysRoleRight tsysRoleRight) {
		return getDslTemplate().insertAndReturnKey(tsysRoleRight,
				new InsertGenerateCallback<TsysRoleRight>() {
					public Insert generate(TsysRoleRight t) {
						Insert insert = insertInto(TSYS_ROLE_RIGHT_TABLE)
								.values(TSYS_ROLE_RIGHT_TABLE.ID.value(t
										.getId()),
										TSYS_ROLE_RIGHT_TABLE.ROLE_ID.value(t
												.getRoleId()),
										TSYS_ROLE_RIGHT_TABLE.MENU_ID.value(t
												.getMenuId()),
										TSYS_ROLE_RIGHT_TABLE.CREATE_BY.value(t
												.getCreateBy()),
										TSYS_ROLE_RIGHT_TABLE.CREATE_DATE
												.value(t.getCreateDate()),
										TSYS_ROLE_RIGHT_TABLE.BEGIN_DATE
												.value(t.getBeginDate()),
										TSYS_ROLE_RIGHT_TABLE.END_DATE.value(t
												.getEndDate()),
										TSYS_ROLE_RIGHT_TABLE.RIGHT_FLAG
												.value(t.getRightFlag())

								);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TsysRoleRight tsysRoleRight) {
		if (tsysRoleRight == null || tsysRoleRight.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tsysRoleRight,
				new UpdateGenerateCallback<TsysRoleRight>() {
					public Update generate(TsysRoleRight t) {
						Update update = update(TSYS_ROLE_RIGHT_TABLE).set(
								TSYS_ROLE_RIGHT_TABLE.ROLE_ID.value(t
										.getRoleId()),
								TSYS_ROLE_RIGHT_TABLE.MENU_ID.value(t
										.getMenuId()),
								TSYS_ROLE_RIGHT_TABLE.CREATE_BY.value(t
										.getCreateBy()),
								TSYS_ROLE_RIGHT_TABLE.CREATE_DATE.value(t
										.getCreateDate()),
								TSYS_ROLE_RIGHT_TABLE.BEGIN_DATE.value(t
										.getBeginDate()),
								TSYS_ROLE_RIGHT_TABLE.END_DATE.value(t
										.getEndDate()),
								TSYS_ROLE_RIGHT_TABLE.RIGHT_FLAG.value(t
										.getRightFlag())).where(
								TSYS_ROLE_RIGHT_TABLE.ID.eq(t.getId()));
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
						return delete(TSYS_ROLE_RIGHT_TABLE).where(
								TSYS_ROLE_RIGHT_TABLE.ID.eq(pk));
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
						return delete(TSYS_ROLE_RIGHT_TABLE).where(
								TSYS_ROLE_RIGHT_TABLE.ID.in(t));
					}
				}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysRoleRight getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, TsysRoleRight.class,
				new SelectGenerateCallback<Serializable>() {

					@SuppressWarnings("rawtypes")
					public Select generate(Serializable t) {
						return selectFrom(TSYS_ROLE_RIGHT_TABLE).where(
								TSYS_ROLE_RIGHT_TABLE.ID.eq(t));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TsysRoleRight> query(TsysRoleRight tsysRoleRight,
			final OrderBy... orderArgs) {
		if (tsysRoleRight == null) {
			tsysRoleRight = new TsysRoleRight();
		}
		return getDslTemplate().query(tsysRoleRight,
				new SelectGenerateCallback<TsysRoleRight>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysRoleRight t) {
						Select select = selectFrom(TSYS_ROLE_RIGHT_TABLE)
								.where(and(TSYS_ROLE_RIGHT_TABLE.ID.eq(t
										.getId()),
										TSYS_ROLE_RIGHT_TABLE.ROLE_ID.eq(t
												.getRoleId()),
										TSYS_ROLE_RIGHT_TABLE.MENU_ID.eq(t
												.getMenuId()),
										TSYS_ROLE_RIGHT_TABLE.CREATE_BY.eq(t
												.getCreateBy()),
										TSYS_ROLE_RIGHT_TABLE.CREATE_DATE.eq(t
												.getCreateDate()),
										TSYS_ROLE_RIGHT_TABLE.BEGIN_DATE.eq(t
												.getBeginDate()),
										TSYS_ROLE_RIGHT_TABLE.END_DATE.eq(t
												.getEndDate()),
										TSYS_ROLE_RIGHT_TABLE.RIGHT_FLAG.eq(t
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
	public Pager<TsysRoleRight> queryPager(int start, int limit,
			TsysRoleRight tsysRoleRight, final OrderBy... orderArgs) {
		if (tsysRoleRight == null) {
			tsysRoleRight = new TsysRoleRight();
		}
		return getDslTemplate().queryPager(start, limit, tsysRoleRight, false,
				new SelectGenerateCallback<TsysRoleRight>() {
					public Select generate(TsysRoleRight t) {
						Select select = Select
								.selectFrom(TSYS_ROLE_RIGHT_TABLE)
								.where(and(TSYS_ROLE_RIGHT_TABLE.ID.eq(t
										.getId()),
										TSYS_ROLE_RIGHT_TABLE.ROLE_ID.eq(t
												.getRoleId()),
										TSYS_ROLE_RIGHT_TABLE.MENU_ID.eq(t
												.getMenuId()),
										TSYS_ROLE_RIGHT_TABLE.CREATE_BY.eq(t
												.getCreateBy()),
										TSYS_ROLE_RIGHT_TABLE.CREATE_DATE.eq(t
												.getCreateDate()),
										TSYS_ROLE_RIGHT_TABLE.BEGIN_DATE.eq(t
												.getBeginDate()),
										TSYS_ROLE_RIGHT_TABLE.END_DATE.eq(t
												.getEndDate()),
										TSYS_ROLE_RIGHT_TABLE.RIGHT_FLAG.eq(t
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
			List<TsysRoleRight> tsysRoleRight) {
		if (CollectionUtil.isEmpty(tsysRoleRight)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysRoleRight,
				new InsertGenerateCallback<TsysRoleRight>() {

					public Insert generate(TsysRoleRight t) {
						return insertInto(TSYS_ROLE_RIGHT_TABLE).values(
								TSYS_ROLE_RIGHT_TABLE.ID.value(t.getId()),
								TSYS_ROLE_RIGHT_TABLE.ROLE_ID.value(t
										.getRoleId()),
								TSYS_ROLE_RIGHT_TABLE.MENU_ID.value(t
										.getMenuId()),
								TSYS_ROLE_RIGHT_TABLE.CREATE_BY.value(t
										.getCreateBy()),
								TSYS_ROLE_RIGHT_TABLE.CREATE_DATE.value(t
										.getCreateDate()),
								TSYS_ROLE_RIGHT_TABLE.BEGIN_DATE.value(t
										.getBeginDate()),
								TSYS_ROLE_RIGHT_TABLE.END_DATE.value(t
										.getEndDate()),
								TSYS_ROLE_RIGHT_TABLE.RIGHT_FLAG.value(t
										.getRightFlag())

						);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TsysRoleRight> tsysRoleRights) {
		return batchInsert(true, tsysRoleRights);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TsysRoleRight> tsysRoleRight) {
		if (CollectionUtil.isEmpty(tsysRoleRight)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysRoleRight,
				new UpdateGenerateCallback<TsysRoleRight>() {
					public Update generate(TsysRoleRight t) {
						return update(TSYS_ROLE_RIGHT_TABLE).set(
								TSYS_ROLE_RIGHT_TABLE.ROLE_ID.value(t
										.getRoleId()),
								TSYS_ROLE_RIGHT_TABLE.MENU_ID.value(t
										.getMenuId()),
								TSYS_ROLE_RIGHT_TABLE.CREATE_BY.value(t
										.getCreateBy()),
								TSYS_ROLE_RIGHT_TABLE.CREATE_DATE.value(t
										.getCreateDate()),
								TSYS_ROLE_RIGHT_TABLE.BEGIN_DATE.value(t
										.getBeginDate()),
								TSYS_ROLE_RIGHT_TABLE.END_DATE.value(t
										.getEndDate()),
								TSYS_ROLE_RIGHT_TABLE.RIGHT_FLAG.value(t
										.getRightFlag())

						).where(TSYS_ROLE_RIGHT_TABLE.ID.eq(t.getId()));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TsysRoleRight> tsysRoleRight) {
		if (CollectionUtil.isEmpty(tsysRoleRight)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysRoleRight,
				new DeleteGenerateCallback<TsysRoleRight>() {
					public Delete generate(TsysRoleRight t) {
						return delete(TSYS_ROLE_RIGHT_TABLE).where(
								and(TSYS_ROLE_RIGHT_TABLE.ID.eq(t.getId()),
										TSYS_ROLE_RIGHT_TABLE.ROLE_ID.eq(t
												.getRoleId()),
										TSYS_ROLE_RIGHT_TABLE.MENU_ID.eq(t
												.getMenuId()),
										TSYS_ROLE_RIGHT_TABLE.CREATE_BY.eq(t
												.getCreateBy()),
										TSYS_ROLE_RIGHT_TABLE.CREATE_DATE.eq(t
												.getCreateDate()),
										TSYS_ROLE_RIGHT_TABLE.BEGIN_DATE.eq(t
												.getBeginDate()),
										TSYS_ROLE_RIGHT_TABLE.END_DATE.eq(t
												.getEndDate()),
										TSYS_ROLE_RIGHT_TABLE.RIGHT_FLAG.eq(t
												.getRightFlag())

								));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys,
			List<TsysRoleRight> tsysRoleRight) {
		if (CollectionUtil.isEmpty(tsysRoleRight)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysRoleRight,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_ROLE_RIGHT_TABLE)
								.values(TSYS_ROLE_RIGHT_TABLE.ROLE_ID
										.value(new JdbcNamedParameter("roleId")),
										TSYS_ROLE_RIGHT_TABLE.MENU_ID
												.value(new JdbcNamedParameter(
														"menuId")),
										TSYS_ROLE_RIGHT_TABLE.CREATE_BY
												.value(new JdbcNamedParameter(
														"createBy")),
										TSYS_ROLE_RIGHT_TABLE.CREATE_DATE
												.value(new JdbcNamedParameter(
														"createDate")),
										TSYS_ROLE_RIGHT_TABLE.BEGIN_DATE
												.value(new JdbcNamedParameter(
														"beginDate")),
										TSYS_ROLE_RIGHT_TABLE.END_DATE
												.value(new JdbcNamedParameter(
														"endDate")),
										TSYS_ROLE_RIGHT_TABLE.RIGHT_FLAG
												.value(new JdbcNamedParameter(
														"rightFlag"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TsysRoleRight> tsysRoleRight) {
		if (CollectionUtil.isEmpty(tsysRoleRight)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysRoleRight,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_ROLE_RIGHT_TABLE)
								.set(TSYS_ROLE_RIGHT_TABLE.ROLE_ID
										.value(new JdbcNamedParameter("roleId")),
										TSYS_ROLE_RIGHT_TABLE.MENU_ID
												.value(new JdbcNamedParameter(
														"menuId")),
										TSYS_ROLE_RIGHT_TABLE.CREATE_BY
												.value(new JdbcNamedParameter(
														"createBy")),
										TSYS_ROLE_RIGHT_TABLE.CREATE_DATE
												.value(new JdbcNamedParameter(
														"createDate")),
										TSYS_ROLE_RIGHT_TABLE.BEGIN_DATE
												.value(new JdbcNamedParameter(
														"beginDate")),
										TSYS_ROLE_RIGHT_TABLE.END_DATE
												.value(new JdbcNamedParameter(
														"endDate")),
										TSYS_ROLE_RIGHT_TABLE.RIGHT_FLAG
												.value(new JdbcNamedParameter(
														"rightFlag"))

								).where(TSYS_ROLE_RIGHT_TABLE.ID
										.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TsysRoleRight> tsysRoleRight) {
		if (CollectionUtil.isEmpty(tsysRoleRight)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysRoleRight,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_ROLE_RIGHT_TABLE).where(
								and(TSYS_ROLE_RIGHT_TABLE.ROLE_ID
										.eq(new JdbcNamedParameter("roleId")),
										TSYS_ROLE_RIGHT_TABLE.MENU_ID
												.eq(new JdbcNamedParameter(
														"menuId")),
										TSYS_ROLE_RIGHT_TABLE.CREATE_BY
												.eq(new JdbcNamedParameter(
														"createBy")),
										TSYS_ROLE_RIGHT_TABLE.CREATE_DATE
												.eq(new JdbcNamedParameter(
														"createDate")),
										TSYS_ROLE_RIGHT_TABLE.BEGIN_DATE
												.eq(new JdbcNamedParameter(
														"beginDate")),
										TSYS_ROLE_RIGHT_TABLE.END_DATE
												.eq(new JdbcNamedParameter(
														"endDate")),
										TSYS_ROLE_RIGHT_TABLE.RIGHT_FLAG
												.eq(new JdbcNamedParameter(
														"rightFlag"))

								));
					}
				});
	}

	public int[] preparedBatchInsert(List<TsysRoleRight> tsysRoleRight) {
		return preparedBatchInsert(true, tsysRoleRight);
	}

}
