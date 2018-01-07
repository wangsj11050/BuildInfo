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
import static org.tinygroup.buildinfo.dao.inter.constant.TbhisuerpwdTable.*;
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

import org.tinygroup.buildinfo.dao.inter.pojo.Tbhisuerpwd;
import org.tinygroup.buildinfo.dao.inter.TbhisuerpwdDao;

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
public class TbhisuerpwdDaoImpl extends TinyDslDaoSupport implements
		TbhisuerpwdDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Tbhisuerpwd add(Tbhisuerpwd tbhisuerpwd) {
		return getDslTemplate().insertAndReturnKey(tbhisuerpwd,
				new InsertGenerateCallback<Tbhisuerpwd>() {
					public Insert generate(Tbhisuerpwd t) {
						Insert insert = insertInto(TBHISUERPWD_TABLE)
								.values(TBHISUERPWD_TABLE.SERIAL_NO.value(t
										.getSerialNo()),
										TBHISUERPWD_TABLE.USER_ID.value(t
												.getUserId()),
										TBHISUERPWD_TABLE.USER_PWD.value(t
												.getUserPwd()),
										TBHISUERPWD_TABLE.RESERVE1.value(t
												.getReserve1()),
										TBHISUERPWD_TABLE.ID.value(t.getId())

								);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(Tbhisuerpwd tbhisuerpwd) {
		if (tbhisuerpwd == null || tbhisuerpwd.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tbhisuerpwd,
				new UpdateGenerateCallback<Tbhisuerpwd>() {
					public Update generate(Tbhisuerpwd t) {
						Update update = update(TBHISUERPWD_TABLE)
								.set(TBHISUERPWD_TABLE.SERIAL_NO.value(t
										.getSerialNo()),
										TBHISUERPWD_TABLE.USER_ID.value(t
												.getUserId()),
										TBHISUERPWD_TABLE.USER_PWD.value(t
												.getUserPwd()),
										TBHISUERPWD_TABLE.RESERVE1.value(t
												.getReserve1())).where(
										TBHISUERPWD_TABLE.ID.eq(t.getId()));
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
						return delete(TBHISUERPWD_TABLE).where(
								TBHISUERPWD_TABLE.ID.eq(pk));
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
						return delete(TBHISUERPWD_TABLE).where(
								TBHISUERPWD_TABLE.ID.in(t));
					}
				}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Tbhisuerpwd getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, Tbhisuerpwd.class,
				new SelectGenerateCallback<Serializable>() {

					@SuppressWarnings("rawtypes")
					public Select generate(Serializable t) {
						return selectFrom(TBHISUERPWD_TABLE).where(
								TBHISUERPWD_TABLE.ID.eq(t));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<Tbhisuerpwd> query(Tbhisuerpwd tbhisuerpwd,
			final OrderBy... orderArgs) {
		if (tbhisuerpwd == null) {
			tbhisuerpwd = new Tbhisuerpwd();
		}
		return getDslTemplate().query(tbhisuerpwd,
				new SelectGenerateCallback<Tbhisuerpwd>() {
					@SuppressWarnings("rawtypes")
					public Select generate(Tbhisuerpwd t) {
						Select select = selectFrom(TBHISUERPWD_TABLE).where(
								and(TBHISUERPWD_TABLE.SERIAL_NO.eq(t
										.getSerialNo()),
										TBHISUERPWD_TABLE.USER_ID.eq(t
												.getUserId()),
										TBHISUERPWD_TABLE.USER_PWD.eq(t
												.getUserPwd()),
										TBHISUERPWD_TABLE.RESERVE1.eq(t
												.getReserve1())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<Tbhisuerpwd> queryPager(int start, int limit,
			Tbhisuerpwd tbhisuerpwd, final OrderBy... orderArgs) {
		if (tbhisuerpwd == null) {
			tbhisuerpwd = new Tbhisuerpwd();
		}
		return getDslTemplate().queryPager(start, limit, tbhisuerpwd, false,
				new SelectGenerateCallback<Tbhisuerpwd>() {
					public Select generate(Tbhisuerpwd t) {
						Select select = Select.selectFrom(TBHISUERPWD_TABLE)
								.where(and(TBHISUERPWD_TABLE.SERIAL_NO.eq(t
										.getSerialNo()),
										TBHISUERPWD_TABLE.USER_ID.eq(t
												.getUserId()),
										TBHISUERPWD_TABLE.USER_PWD.eq(t
												.getUserPwd()),
										TBHISUERPWD_TABLE.RESERVE1.eq(t
												.getReserve1())

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
			List<Tbhisuerpwd> tbhisuerpwd) {
		if (CollectionUtil.isEmpty(tbhisuerpwd)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tbhisuerpwd,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TBHISUERPWD_TABLE)
								.values(TBHISUERPWD_TABLE.SERIAL_NO
										.value(new JdbcNamedParameter(
												"serialNo")),
										TBHISUERPWD_TABLE.USER_ID
												.value(new JdbcNamedParameter(
														"userId")),
										TBHISUERPWD_TABLE.USER_PWD
												.value(new JdbcNamedParameter(
														"userPwd")),
										TBHISUERPWD_TABLE.RESERVE1
												.value(new JdbcNamedParameter(
														"reserve1"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<Tbhisuerpwd> tbhisuerpwds) {
		return batchInsert(true, tbhisuerpwds);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<Tbhisuerpwd> tbhisuerpwd) {
		if (CollectionUtil.isEmpty(tbhisuerpwd)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tbhisuerpwd,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TBHISUERPWD_TABLE)
								.set(TBHISUERPWD_TABLE.SERIAL_NO
										.value(new JdbcNamedParameter(
												"serialNo")),
										TBHISUERPWD_TABLE.USER_ID
												.value(new JdbcNamedParameter(
														"userId")),
										TBHISUERPWD_TABLE.USER_PWD
												.value(new JdbcNamedParameter(
														"userPwd")),
										TBHISUERPWD_TABLE.RESERVE1
												.value(new JdbcNamedParameter(
														"reserve1"))

								).where(TBHISUERPWD_TABLE.ID
										.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<Tbhisuerpwd> tbhisuerpwd) {
		if (CollectionUtil.isEmpty(tbhisuerpwd)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tbhisuerpwd,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TBHISUERPWD_TABLE)
								.where(and(
										TBHISUERPWD_TABLE.SERIAL_NO
												.eq(new JdbcNamedParameter(
														"serialNo")),
										TBHISUERPWD_TABLE.USER_ID
												.eq(new JdbcNamedParameter(
														"userId")),
										TBHISUERPWD_TABLE.USER_PWD
												.eq(new JdbcNamedParameter(
														"userPwd")),
										TBHISUERPWD_TABLE.RESERVE1
												.eq(new JdbcNamedParameter(
														"reserve1"))

								));
					}
				});
	}


	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys,
									 List<Tbhisuerpwd> tbhisuerpwd) {
		if (CollectionUtil.isEmpty(tbhisuerpwd)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tbhisuerpwd,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TBHISUERPWD_TABLE)
								.values(TBHISUERPWD_TABLE.SERIAL_NO
												.value(new JdbcNamedParameter(
														"serialNo")),
										TBHISUERPWD_TABLE.USER_ID
												.value(new JdbcNamedParameter(
														"userId")),
										TBHISUERPWD_TABLE.USER_PWD
												.value(new JdbcNamedParameter(
														"userPwd")),
										TBHISUERPWD_TABLE.RESERVE1
												.value(new JdbcNamedParameter(
														"reserve1"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<Tbhisuerpwd> tbhisuerpwd) {
		if (CollectionUtil.isEmpty(tbhisuerpwd)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tbhisuerpwd,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TBHISUERPWD_TABLE)
								.set(TBHISUERPWD_TABLE.SERIAL_NO
												.value(new JdbcNamedParameter(
														"serialNo")),
										TBHISUERPWD_TABLE.USER_ID
												.value(new JdbcNamedParameter(
														"userId")),
										TBHISUERPWD_TABLE.USER_PWD
												.value(new JdbcNamedParameter(
														"userPwd")),
										TBHISUERPWD_TABLE.RESERVE1
												.value(new JdbcNamedParameter(
														"reserve1"))

								).where(TBHISUERPWD_TABLE.ID
										.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<Tbhisuerpwd> tbhisuerpwd) {
		if (CollectionUtil.isEmpty(tbhisuerpwd)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tbhisuerpwd,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TBHISUERPWD_TABLE)
								.where(and(
										TBHISUERPWD_TABLE.SERIAL_NO
												.eq(new JdbcNamedParameter(
														"serialNo")),
										TBHISUERPWD_TABLE.USER_ID
												.eq(new JdbcNamedParameter(
														"userId")),
										TBHISUERPWD_TABLE.USER_PWD
												.eq(new JdbcNamedParameter(
														"userPwd")),
										TBHISUERPWD_TABLE.RESERVE1
												.eq(new JdbcNamedParameter(
														"reserve1"))

								));
					}
				});
	}

	public int[] preparedBatchInsert(List<Tbhisuerpwd> tbhisuerpwd) {
		return preparedBatchInsert(true, tbhisuerpwd);
	}
}
