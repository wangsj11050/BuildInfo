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
import static org.tinygroup.buildinfo.dao.inter.constant.TsysUserLoginTable.*;
import static org.tinygroup.tinysqldsl.Select.*;
import static org.tinygroup.tinysqldsl.Insert.*;
import static org.tinygroup.tinysqldsl.Delete.*;
import static org.tinygroup.tinysqldsl.Update.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.TsysUser;
import org.tinygroup.tinysqldsl.Delete;
import org.tinygroup.tinysqldsl.Insert;
import org.tinygroup.tinysqldsl.Select;
import org.tinygroup.tinysqldsl.Update;
import org.tinygroup.tinysqldsl.Pager;

import org.tinygroup.commons.tools.CollectionUtil;
import org.tinygroup.tinysqldsl.expression.JdbcNamedParameter;
import org.tinygroup.tinysqldsl.select.OrderByElement;

import org.tinygroup.buildinfo.dao.inter.pojo.TsysUserLogin;
import org.tinygroup.buildinfo.dao.inter.TsysUserLoginDao;

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
public class TsysUserLoginDaoImpl extends TinyDslDaoSupport implements
		TsysUserLoginDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysUserLogin add(TsysUserLogin tsysUserLogin) {
		return getDslTemplate().insertAndReturnKey(tsysUserLogin,
				new InsertGenerateCallback<TsysUserLogin>() {
					public Insert generate(TsysUserLogin t) {
						Insert insert = insertInto(TSYS_USER_LOGIN_TABLE)
								.values(TSYS_USER_LOGIN_TABLE.USER_ID.value(t
										.getUserId()),
										TSYS_USER_LOGIN_TABLE.LAST_LOGIN_DATE
												.value(t.getLastLoginDate()),
										TSYS_USER_LOGIN_TABLE.LAST_LOGIN_TIME
												.value(t.getLastLoginTime()),
										TSYS_USER_LOGIN_TABLE.LAST_LOGIN_IP
												.value(t.getLastLoginIp()),
										TSYS_USER_LOGIN_TABLE.LOGIN_FAIL_TIMES
												.value(t.getLoginFailTimes()),
										TSYS_USER_LOGIN_TABLE.LAST_FAIL_DATE
												.value(t.getLastFailDate()),
										TSYS_USER_LOGIN_TABLE.EXT_FIELD.value(t
												.getExtField())

								);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TsysUserLogin tsysUserLogin) {
		if (tsysUserLogin == null || tsysUserLogin.getUserId() == null) {
			return 0;
		}
		return getDslTemplate().update(tsysUserLogin,
				new UpdateGenerateCallback<TsysUserLogin>() {
					public Update generate(TsysUserLogin t) {
						Update update = update(TSYS_USER_LOGIN_TABLE).set(
								TSYS_USER_LOGIN_TABLE.LAST_LOGIN_DATE.value(t
										.getLastLoginDate()),
								TSYS_USER_LOGIN_TABLE.LAST_LOGIN_TIME.value(t
										.getLastLoginTime()),
								TSYS_USER_LOGIN_TABLE.LAST_LOGIN_IP.value(t
										.getLastLoginIp()),
								TSYS_USER_LOGIN_TABLE.LOGIN_FAIL_TIMES.value(t
										.getLoginFailTimes()),
								TSYS_USER_LOGIN_TABLE.LAST_FAIL_DATE.value(t
										.getLastFailDate()),
								TSYS_USER_LOGIN_TABLE.EXT_FIELD.value(t
										.getExtField()))
								.where(TSYS_USER_LOGIN_TABLE.USER_ID.eq(t
										.getUserId()));
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
						return delete(TSYS_USER_LOGIN_TABLE).where(
								TSYS_USER_LOGIN_TABLE.USER_ID.eq(pk));
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
						return delete(TSYS_USER_LOGIN_TABLE).where(
								TSYS_USER_LOGIN_TABLE.USER_ID.in(t));
					}
				}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysUserLogin getByKey(String pk) {
		return getDslTemplate().getByKey(pk, TsysUserLogin.class,
				new SelectGenerateCallback<Serializable>() {

					@SuppressWarnings("rawtypes")
					public Select generate(Serializable t) {
						return selectFrom(TSYS_USER_LOGIN_TABLE).where(
								TSYS_USER_LOGIN_TABLE.USER_ID.eq(t));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TsysUserLogin> query(TsysUserLogin tsysUserLogin,
			final OrderBy... orderArgs) {
		if (tsysUserLogin == null) {
			tsysUserLogin = new TsysUserLogin();
		}
		return getDslTemplate().query(tsysUserLogin,
				new SelectGenerateCallback<TsysUserLogin>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysUserLogin t) {
						Select select = selectFrom(TSYS_USER_LOGIN_TABLE)
								.where(and(
										TSYS_USER_LOGIN_TABLE.LAST_LOGIN_DATE
												.eq(t.getLastLoginDate()),
										TSYS_USER_LOGIN_TABLE.LAST_LOGIN_TIME
												.eq(t.getLastLoginTime()),
										TSYS_USER_LOGIN_TABLE.LAST_LOGIN_IP
												.eq(t.getLastLoginIp()),
										TSYS_USER_LOGIN_TABLE.LOGIN_FAIL_TIMES
												.eq(t.getLoginFailTimes()),
										TSYS_USER_LOGIN_TABLE.LAST_FAIL_DATE
												.eq(t.getLastFailDate()),
										TSYS_USER_LOGIN_TABLE.EXT_FIELD.eq(t
												.getExtField())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TsysUserLogin> queryPager(int start, int limit,
			TsysUserLogin tsysUserLogin, final OrderBy... orderArgs) {
		if (tsysUserLogin == null) {
			tsysUserLogin = new TsysUserLogin();
		}
		return getDslTemplate().queryPager(start, limit, tsysUserLogin, false,
				new SelectGenerateCallback<TsysUserLogin>() {
					public Select generate(TsysUserLogin t) {
						Select select = Select
								.selectFrom(TSYS_USER_LOGIN_TABLE)
								.where(and(
										TSYS_USER_LOGIN_TABLE.LAST_LOGIN_DATE
												.eq(t.getLastLoginDate()),
										TSYS_USER_LOGIN_TABLE.LAST_LOGIN_TIME
												.eq(t.getLastLoginTime()),
										TSYS_USER_LOGIN_TABLE.LAST_LOGIN_IP
												.eq(t.getLastLoginIp()),
										TSYS_USER_LOGIN_TABLE.LOGIN_FAIL_TIMES
												.eq(t.getLoginFailTimes()),
										TSYS_USER_LOGIN_TABLE.LAST_FAIL_DATE
												.eq(t.getLastFailDate()),
										TSYS_USER_LOGIN_TABLE.EXT_FIELD.eq(t
												.getExtField())

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
			List<TsysUserLogin> tsysUserLogin) {
		if (CollectionUtil.isEmpty(tsysUserLogin)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysUserLogin,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_USER_LOGIN_TABLE).values(
								TSYS_USER_LOGIN_TABLE.LAST_LOGIN_DATE
										.value(new JdbcNamedParameter(
												"lastLoginDate")),
								TSYS_USER_LOGIN_TABLE.LAST_LOGIN_TIME
										.value(new JdbcNamedParameter(
												"lastLoginTime")),
								TSYS_USER_LOGIN_TABLE.LAST_LOGIN_IP
										.value(new JdbcNamedParameter(
												"lastLoginIp")),
								TSYS_USER_LOGIN_TABLE.LOGIN_FAIL_TIMES
										.value(new JdbcNamedParameter(
												"loginFailTimes")),
								TSYS_USER_LOGIN_TABLE.LAST_FAIL_DATE
										.value(new JdbcNamedParameter(
												"lastFailDate")),
								TSYS_USER_LOGIN_TABLE.EXT_FIELD
										.value(new JdbcNamedParameter(
												"extField"))

						);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TsysUserLogin> tsysUserLogins) {
		return batchInsert(true, tsysUserLogins);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TsysUserLogin> tsysUserLogin) {
		if (CollectionUtil.isEmpty(tsysUserLogin)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysUserLogin,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_USER_LOGIN_TABLE).set(
								TSYS_USER_LOGIN_TABLE.LAST_LOGIN_DATE
										.value(new JdbcNamedParameter(
												"lastLoginDate")),
								TSYS_USER_LOGIN_TABLE.LAST_LOGIN_TIME
										.value(new JdbcNamedParameter(
												"lastLoginTime")),
								TSYS_USER_LOGIN_TABLE.LAST_LOGIN_IP
										.value(new JdbcNamedParameter(
												"lastLoginIp")),
								TSYS_USER_LOGIN_TABLE.LOGIN_FAIL_TIMES
										.value(new JdbcNamedParameter(
												"loginFailTimes")),
								TSYS_USER_LOGIN_TABLE.LAST_FAIL_DATE
										.value(new JdbcNamedParameter(
												"lastFailDate")),
								TSYS_USER_LOGIN_TABLE.EXT_FIELD
										.value(new JdbcNamedParameter(
												"extField"))

						).where(TSYS_USER_LOGIN_TABLE.USER_ID
								.eq(new JdbcNamedParameter("userId")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TsysUserLogin> tsysUserLogin) {
		if (CollectionUtil.isEmpty(tsysUserLogin)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysUserLogin,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_USER_LOGIN_TABLE).where(
								and(TSYS_USER_LOGIN_TABLE.LAST_LOGIN_DATE
										.eq(new JdbcNamedParameter(
												"lastLoginDate")),
										TSYS_USER_LOGIN_TABLE.LAST_LOGIN_TIME
												.eq(new JdbcNamedParameter(
														"lastLoginTime")),
										TSYS_USER_LOGIN_TABLE.LAST_LOGIN_IP
												.eq(new JdbcNamedParameter(
														"lastLoginIp")),
										TSYS_USER_LOGIN_TABLE.LOGIN_FAIL_TIMES
												.eq(new JdbcNamedParameter(
														"loginFailTimes")),
										TSYS_USER_LOGIN_TABLE.LAST_FAIL_DATE
												.eq(new JdbcNamedParameter(
														"lastFailDate")),
										TSYS_USER_LOGIN_TABLE.EXT_FIELD
												.eq(new JdbcNamedParameter(
														"extField"))

								));
					}
				});
	}

	/**
	 * 根据user对象获取用户登录信息
	 * @param tsysUser
	 * @return
     */
	public TsysUserLogin queryByUser(final TsysUser tsysUser) {
		TsysUserLogin tsysUserLogin = new TsysUserLogin();
		List<TsysUserLogin> tsysUserLoginList = getDslTemplate().query(tsysUserLogin,
				new SelectGenerateCallback<TsysUserLogin>() {
					public Select generate(TsysUserLogin t) {
						Select select = Select
								.selectFrom(TSYS_USER_LOGIN_TABLE)
								.where(TSYS_USER_LOGIN_TABLE.USER_ID
												.eq(tsysUser.getUserId())

								);
						return TinyDSLUtil
								.addOrderByElements(select);
					}
				});
		if(tsysUserLoginList.size()>0){
			return tsysUserLoginList.get(0);
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys,
									 List<TsysUserLogin> tsysUserLogin) {
		if (CollectionUtil.isEmpty(tsysUserLogin)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysUserLogin,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_USER_LOGIN_TABLE).values(
								TSYS_USER_LOGIN_TABLE.LAST_LOGIN_DATE
										.value(new JdbcNamedParameter(
												"lastLoginDate")),
								TSYS_USER_LOGIN_TABLE.LAST_LOGIN_TIME
										.value(new JdbcNamedParameter(
												"lastLoginTime")),
								TSYS_USER_LOGIN_TABLE.LAST_LOGIN_IP
										.value(new JdbcNamedParameter(
												"lastLoginIp")),
								TSYS_USER_LOGIN_TABLE.LOGIN_FAIL_TIMES
										.value(new JdbcNamedParameter(
												"loginFailTimes")),
								TSYS_USER_LOGIN_TABLE.LAST_FAIL_DATE
										.value(new JdbcNamedParameter(
												"lastFailDate")),
								TSYS_USER_LOGIN_TABLE.EXT_FIELD
										.value(new JdbcNamedParameter(
												"extField"))

						);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TsysUserLogin> tsysUserLogin) {
		if (CollectionUtil.isEmpty(tsysUserLogin)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysUserLogin,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_USER_LOGIN_TABLE).set(
								TSYS_USER_LOGIN_TABLE.LAST_LOGIN_DATE
										.value(new JdbcNamedParameter(
												"lastLoginDate")),
								TSYS_USER_LOGIN_TABLE.LAST_LOGIN_TIME
										.value(new JdbcNamedParameter(
												"lastLoginTime")),
								TSYS_USER_LOGIN_TABLE.LAST_LOGIN_IP
										.value(new JdbcNamedParameter(
												"lastLoginIp")),
								TSYS_USER_LOGIN_TABLE.LOGIN_FAIL_TIMES
										.value(new JdbcNamedParameter(
												"loginFailTimes")),
								TSYS_USER_LOGIN_TABLE.LAST_FAIL_DATE
										.value(new JdbcNamedParameter(
												"lastFailDate")),
								TSYS_USER_LOGIN_TABLE.EXT_FIELD
										.value(new JdbcNamedParameter(
												"extField"))

						).where(TSYS_USER_LOGIN_TABLE.USER_ID
								.eq(new JdbcNamedParameter("userId")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TsysUserLogin> tsysUserLogin) {
		if (CollectionUtil.isEmpty(tsysUserLogin)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysUserLogin,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_USER_LOGIN_TABLE).where(
								and(TSYS_USER_LOGIN_TABLE.LAST_LOGIN_DATE
												.eq(new JdbcNamedParameter(
														"lastLoginDate")),
										TSYS_USER_LOGIN_TABLE.LAST_LOGIN_TIME
												.eq(new JdbcNamedParameter(
														"lastLoginTime")),
										TSYS_USER_LOGIN_TABLE.LAST_LOGIN_IP
												.eq(new JdbcNamedParameter(
														"lastLoginIp")),
										TSYS_USER_LOGIN_TABLE.LOGIN_FAIL_TIMES
												.eq(new JdbcNamedParameter(
														"loginFailTimes")),
										TSYS_USER_LOGIN_TABLE.LAST_FAIL_DATE
												.eq(new JdbcNamedParameter(
														"lastFailDate")),
										TSYS_USER_LOGIN_TABLE.EXT_FIELD
												.eq(new JdbcNamedParameter(
														"extField"))

								));
					}
				});
	}

	public int[] preparedBatchInsert(List<TsysUserLogin> tsysUserLogin) {
		return preparedBatchInsert(false, tsysUserLogin);
	}

}
