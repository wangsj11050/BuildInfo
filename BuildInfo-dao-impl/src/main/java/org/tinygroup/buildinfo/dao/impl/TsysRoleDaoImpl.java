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
import static org.tinygroup.buildinfo.dao.inter.constant.TsysRoleTable.*;
import static org.tinygroup.tinysqldsl.Select.*;
import static org.tinygroup.tinysqldsl.Insert.*;
import static org.tinygroup.tinysqldsl.Delete.*;
import static org.tinygroup.tinysqldsl.Update.*;

import java.io.Serializable;
import java.util.List;

import org.tinygroup.tinysqldsl.Delete;
import org.tinygroup.tinysqldsl.Insert;
import org.tinygroup.tinysqldsl.Select;
import org.tinygroup.tinysqldsl.Update;
import org.tinygroup.tinysqldsl.Pager;

import org.tinygroup.commons.tools.CollectionUtil;
import org.tinygroup.tinysqldsl.expression.JdbcNamedParameter;

import org.tinygroup.buildinfo.dao.inter.pojo.TsysRole;
import org.tinygroup.buildinfo.dao.inter.TsysRoleDao;

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
public class TsysRoleDaoImpl extends TinyDslDaoSupport implements TsysRoleDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysRole add(TsysRole tsysRole) {
		return getDslTemplate().insertAndReturnKey(tsysRole,
				new InsertGenerateCallback<TsysRole>() {
					public Insert generate(TsysRole t) {
						Insert insert = insertInto(TSYS_ROLE_TABLE)
								.values(TSYS_ROLE_TABLE.ROLE_CODE.value(t
										.getRoleCode()),
										TSYS_ROLE_TABLE.ROLE_NAME.value(t
												.getRoleName()),
										TSYS_ROLE_TABLE.CREATOR.value(t
												.getCreator()),
										TSYS_ROLE_TABLE.REMARK.value(t
												.getRemark())

								);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TsysRole tsysRole) {
		if (tsysRole == null || tsysRole.getRoleId() == null) {
			return 0;
		}
		return getDslTemplate().update(tsysRole,
				new UpdateGenerateCallback<TsysRole>() {
					public Update generate(TsysRole t) {
						Update update = update(TSYS_ROLE_TABLE)
								.set(TSYS_ROLE_TABLE.ROLE_NAME.value(t
										.getRoleName()),
										TSYS_ROLE_TABLE.CREATOR.value(t
												.getCreator()),
										TSYS_ROLE_TABLE.REMARK.value(t
												.getRemark())).where(
										TSYS_ROLE_TABLE.ROLE_ID.eq(t
												.getRoleId()));
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
						return delete(TSYS_ROLE_TABLE).where(
								TSYS_ROLE_TABLE.ROLE_ID.eq(pk));
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
						return delete(TSYS_ROLE_TABLE).where(
								TSYS_ROLE_TABLE.ROLE_ID.in(t));
					}
				}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysRole getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, TsysRole.class,
				new SelectGenerateCallback<Serializable>() {

					@SuppressWarnings("rawtypes")
					public Select generate(Serializable t) {
						return selectFrom(TSYS_ROLE_TABLE).where(
								TSYS_ROLE_TABLE.ROLE_ID.eq(t));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TsysRole> query(TsysRole tsysRole, final OrderBy... orderArgs) {
		if (tsysRole == null) {
			tsysRole = new TsysRole();
		}
		return getDslTemplate().query(tsysRole,
				new SelectGenerateCallback<TsysRole>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysRole t) {
						Select select = selectFrom(TSYS_ROLE_TABLE)
								.where(and(
										TSYS_ROLE_TABLE.ROLE_CODE.eq(t
												.getRoleCode()),
												TSYS_ROLE_TABLE.ROLE_NAME.eq(t
														.getRoleName()),
										TSYS_ROLE_TABLE.CREATOR.eq(t
												.getCreator()),
										TSYS_ROLE_TABLE.REMARK.eq(t.getRemark())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TsysRole> queryPager(int start, int limit, TsysRole tsysRole,
			final OrderBy... orderArgs) {
		if (tsysRole == null) {
			tsysRole = new TsysRole();
		}
		return getDslTemplate().queryPager(start, limit, tsysRole, false,
				new SelectGenerateCallback<TsysRole>() {
					public Select generate(TsysRole t) {
						Select select = Select
								.selectFrom(TSYS_ROLE_TABLE)
								.where(and(
										TSYS_ROLE_TABLE.ROLE_NAME.eq(t
												.getRoleName()),
										TSYS_ROLE_TABLE.CREATOR.eq(t
												.getCreator()),
										TSYS_ROLE_TABLE.REMARK.eq(t.getRemark())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}
	
	/**
	 * like 搜索
	 */
	public Pager<TsysRole> queryPagerForSearch(int start, int limit, TsysRole tsysRole,
			final OrderBy... orderArgs) {
		if (tsysRole == null) {
			tsysRole = new TsysRole();
		}
		return getDslTemplate().queryPager(start, limit, tsysRole, false,
				new SelectGenerateCallback<TsysRole>() {
					public Select generate(TsysRole t) {
						Select select = Select
								.selectFrom(TSYS_ROLE_TABLE)
								.where(and(
										TSYS_ROLE_TABLE.ROLE_NAME.like(t
												.getRoleName()),
										TSYS_ROLE_TABLE.CREATOR.like(t
												.getCreator()),
										TSYS_ROLE_TABLE.REMARK.like(t.getRemark())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<TsysRole> tsysRole) {
		if (CollectionUtil.isEmpty(tsysRole)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysRole,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_ROLE_TABLE)
								.values(TSYS_ROLE_TABLE.ROLE_NAME
										.value(new JdbcNamedParameter(
												"roleName")),
										TSYS_ROLE_TABLE.CREATOR
												.value(new JdbcNamedParameter(
														"creator")),
										TSYS_ROLE_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TsysRole> tsysRoles) {
		return batchInsert(true, tsysRoles);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TsysRole> tsysRole) {
		if (CollectionUtil.isEmpty(tsysRole)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysRole,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_ROLE_TABLE)
								.set(TSYS_ROLE_TABLE.ROLE_NAME
										.value(new JdbcNamedParameter(
												"roleName")),
										TSYS_ROLE_TABLE.CREATOR
												.value(new JdbcNamedParameter(
														"creator")),
										TSYS_ROLE_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark"))

								)
								.where(TSYS_ROLE_TABLE.ROLE_CODE
										.eq(new JdbcNamedParameter("roleCode")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TsysRole> tsysRole) {
		if (CollectionUtil.isEmpty(tsysRole)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysRole,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_ROLE_TABLE)
								.where(and(
										TSYS_ROLE_TABLE.ROLE_NAME
												.eq(new JdbcNamedParameter(
														"roleName")),
										TSYS_ROLE_TABLE.CREATOR
												.eq(new JdbcNamedParameter(
														"creator")),
										TSYS_ROLE_TABLE.REMARK
												.eq(new JdbcNamedParameter(
														"remark"))

								));
					}
				});
	}

	/**
	 * 根据role_code 获取信息
	 *
	 * @param tsysRole
	 * @return
	 */
	public List checkExist(TsysRole tsysRole) {
		if (tsysRole == null) {
			tsysRole = new TsysRole();
		}
		return getDslTemplate().query(tsysRole,
				new SelectGenerateCallback<TsysRole>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysRole t) {
						Select select = selectFrom(TSYS_ROLE_TABLE)
								.where(and(
										TSYS_ROLE_TABLE.ROLE_CODE.eq(t
												.getRoleCode())

								));
						return select;
					}
				});
	}
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys,
									 List<TsysRole> tsysRole) {
		if (CollectionUtil.isEmpty(tsysRole)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysRole,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_ROLE_TABLE)
								.values(TSYS_ROLE_TABLE.ROLE_NAME
												.value(new JdbcNamedParameter(
														"roleName")),
										TSYS_ROLE_TABLE.CREATOR
												.value(new JdbcNamedParameter(
														"creator")),
										TSYS_ROLE_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TsysRole> tsysRole) {
		if (CollectionUtil.isEmpty(tsysRole)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysRole,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_ROLE_TABLE)
								.set(TSYS_ROLE_TABLE.ROLE_NAME
												.value(new JdbcNamedParameter(
														"roleName")),
										TSYS_ROLE_TABLE.CREATOR
												.value(new JdbcNamedParameter(
														"creator")),
										TSYS_ROLE_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark"))

								)
								.where(TSYS_ROLE_TABLE.ROLE_CODE
										.eq(new JdbcNamedParameter("roleCode")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TsysRole> tsysRole) {
		if (CollectionUtil.isEmpty(tsysRole)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysRole,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_ROLE_TABLE)
								.where(and(
										TSYS_ROLE_TABLE.ROLE_NAME
												.eq(new JdbcNamedParameter(
														"roleName")),
										TSYS_ROLE_TABLE.CREATOR
												.eq(new JdbcNamedParameter(
														"creator")),
										TSYS_ROLE_TABLE.REMARK
												.eq(new JdbcNamedParameter(
														"remark"))

								));
					}
				});
	}

	public int[] preparedBatchInsert(List<TsysRole> tsysRole) {
		return preparedBatchInsert(false, tsysRole);
	}
}
