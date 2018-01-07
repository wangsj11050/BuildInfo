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
import static org.tinygroup.buildinfo.dao.inter.constant.TsysBranchUserTable.*;
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

import org.tinygroup.buildinfo.dao.inter.pojo.TsysBranchUser;
import org.tinygroup.buildinfo.dao.inter.TsysBranchUserDao;

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
public class TsysBranchUserDaoImpl extends TinyDslDaoSupport implements
		TsysBranchUserDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysBranchUser add(TsysBranchUser tsysBranchUser) {
		return getDslTemplate().insertAndReturnKey(tsysBranchUser,
				new InsertGenerateCallback<TsysBranchUser>() {
					public Insert generate(TsysBranchUser t) {
						Insert insert = insertInto(TSYS_BRANCH_USER_TABLE)
								.values(TSYS_BRANCH_USER_TABLE.ID.value(t
										.getId()),
										TSYS_BRANCH_USER_TABLE.USER_ID.value(t
												.getUserId()),
										TSYS_BRANCH_USER_TABLE.BRANCH_CODE
												.value(t.getBranchCode())

								);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TsysBranchUser tsysBranchUser) {
		if (tsysBranchUser == null || tsysBranchUser.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tsysBranchUser,
				new UpdateGenerateCallback<TsysBranchUser>() {
					public Update generate(TsysBranchUser t) {
						Update update = update(TSYS_BRANCH_USER_TABLE).set(
								TSYS_BRANCH_USER_TABLE.USER_ID.value(t
										.getUserId()),
								TSYS_BRANCH_USER_TABLE.BRANCH_CODE.value(t
										.getBranchCode())).where(
								TSYS_BRANCH_USER_TABLE.ID.eq(t.getId()));
						return update;
					}
				});
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public int deleteByKey(String pk){
		if(pk == null){
			return 0;
		}
		return getDslTemplate().deleteByKey(pk, new DeleteGenerateCallback<Serializable>() {
			public Delete generate(Serializable pk) {
				return delete(TSYS_BRANCH_USER_TABLE).where(TSYS_BRANCH_USER_TABLE.USER_ID.eq(pk));
			}
		});
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public int deleteByKeys(String... pks) {
		if(pks == null || pks.length == 0){
			return 0;
		}
		return getDslTemplate().deleteByKeys(new DeleteGenerateCallback<Serializable[]>() {
			public Delete generate(Serializable[] t) {
				return delete(TSYS_BRANCH_USER_TABLE).where(TSYS_BRANCH_USER_TABLE.USER_ID.in(t));
		}
		},pks);
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public TsysBranchUser getByKey(String pk) {
		return getDslTemplate().getByKey(pk, TsysBranchUser.class, new SelectGenerateCallback<Serializable>() {
		@SuppressWarnings("rawtypes")
		public Select generate(Serializable t) {
			return selectFrom(TSYS_BRANCH_USER_TABLE).where(TSYS_BRANCH_USER_TABLE.USER_ID.eq(t));
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
						return delete(TSYS_BRANCH_USER_TABLE).where(
								TSYS_BRANCH_USER_TABLE.ID.eq(pk));
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
						return delete(TSYS_BRANCH_USER_TABLE).where(
								TSYS_BRANCH_USER_TABLE.ID.in(t));
					}
				}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysBranchUser getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, TsysBranchUser.class,
				new SelectGenerateCallback<Serializable>() {

					@SuppressWarnings("rawtypes")
					public Select generate(Serializable t) {
						return selectFrom(TSYS_BRANCH_USER_TABLE).where(
								TSYS_BRANCH_USER_TABLE.ID.eq(t));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TsysBranchUser> query(TsysBranchUser tsysBranchUser,
			final OrderBy... orderArgs) {
		if (tsysBranchUser == null) {
			tsysBranchUser = new TsysBranchUser();
		}
		return getDslTemplate().query(tsysBranchUser,
				new SelectGenerateCallback<TsysBranchUser>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysBranchUser t) {
						Select select = selectFrom(TSYS_BRANCH_USER_TABLE)
								.where(and(TSYS_BRANCH_USER_TABLE.USER_ID.eq(t
										.getUserId()),
										TSYS_BRANCH_USER_TABLE.BRANCH_CODE.eq(t
												.getBranchCode())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TsysBranchUser> queryPager(int start, int limit,
			TsysBranchUser tsysBranchUser, final OrderBy... orderArgs) {
		if (tsysBranchUser == null) {
			tsysBranchUser = new TsysBranchUser();
		}
		return getDslTemplate().queryPager(start, limit, tsysBranchUser, false,
				new SelectGenerateCallback<TsysBranchUser>() {
					public Select generate(TsysBranchUser t) {
						Select select = Select.selectFrom(
								TSYS_BRANCH_USER_TABLE).where(
								and(TSYS_BRANCH_USER_TABLE.USER_ID.eq(t
										.getUserId()),
										TSYS_BRANCH_USER_TABLE.BRANCH_CODE.eq(t
												.getBranchCode())

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
			List<TsysBranchUser> tsysBranchUser) {
		if (CollectionUtil.isEmpty(tsysBranchUser)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysBranchUser,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_BRANCH_USER_TABLE)
								.values(TSYS_BRANCH_USER_TABLE.USER_ID
										.value(new JdbcNamedParameter("userId")),
										TSYS_BRANCH_USER_TABLE.BRANCH_CODE
												.value(new JdbcNamedParameter(
														"branchCode"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TsysBranchUser> tsysBranchUsers) {
		return batchInsert(true, tsysBranchUsers);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TsysBranchUser> tsysBranchUser) {
		if (CollectionUtil.isEmpty(tsysBranchUser)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysBranchUser,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_BRANCH_USER_TABLE)
								.set(TSYS_BRANCH_USER_TABLE.USER_ID
										.value(new JdbcNamedParameter("userId")),
										TSYS_BRANCH_USER_TABLE.BRANCH_CODE
												.value(new JdbcNamedParameter(
														"branchCode"))

								).where(TSYS_BRANCH_USER_TABLE.ID
										.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TsysBranchUser> tsysBranchUser) {
		if (CollectionUtil.isEmpty(tsysBranchUser)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysBranchUser,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_BRANCH_USER_TABLE).where(
								and(TSYS_BRANCH_USER_TABLE.USER_ID
										.eq(new JdbcNamedParameter("userId")),
										TSYS_BRANCH_USER_TABLE.BRANCH_CODE
												.eq(new JdbcNamedParameter(
														"branchCode"))

								));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys,
									 List<TsysBranchUser> tsysBranchUser) {
		if (CollectionUtil.isEmpty(tsysBranchUser)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysBranchUser,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_BRANCH_USER_TABLE)
								.values(TSYS_BRANCH_USER_TABLE.USER_ID
												.value(new JdbcNamedParameter("userId")),
										TSYS_BRANCH_USER_TABLE.BRANCH_CODE
												.value(new JdbcNamedParameter(
														"branchCode"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TsysBranchUser> tsysBranchUser) {
		if (CollectionUtil.isEmpty(tsysBranchUser)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysBranchUser,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_BRANCH_USER_TABLE)
								.set(TSYS_BRANCH_USER_TABLE.USER_ID
												.value(new JdbcNamedParameter("userId")),
										TSYS_BRANCH_USER_TABLE.BRANCH_CODE
												.value(new JdbcNamedParameter(
														"branchCode"))

								).where(TSYS_BRANCH_USER_TABLE.ID
										.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TsysBranchUser> tsysBranchUser) {
		if (CollectionUtil.isEmpty(tsysBranchUser)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysBranchUser,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_BRANCH_USER_TABLE).where(
								and(TSYS_BRANCH_USER_TABLE.USER_ID
												.eq(new JdbcNamedParameter("userId")),
										TSYS_BRANCH_USER_TABLE.BRANCH_CODE
												.eq(new JdbcNamedParameter(
														"branchCode"))

								));
					}
				});
	}

	public int[] preparedBatchInsert(List<TsysBranchUser> tsysBranchUser) {
		return preparedBatchInsert(true, tsysBranchUser);
	}
}
