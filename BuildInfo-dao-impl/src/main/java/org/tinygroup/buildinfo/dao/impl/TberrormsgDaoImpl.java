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

import static org.tinygroup.buildinfo.dao.inter.constant.TberrormsgTable.TBERRORMSG_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;

import java.io.Serializable;
import java.util.List;

import org.tinygroup.buildinfo.dao.inter.TberrormsgDao;
import org.tinygroup.buildinfo.dao.inter.pojo.Tberrormsg;
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
public class TberrormsgDaoImpl extends TinyDslDaoSupport implements
		TberrormsgDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Tberrormsg add(Tberrormsg tberrormsg) {
		return getDslTemplate().insertAndReturnKey(tberrormsg,
				new InsertGenerateCallback<Tberrormsg>() {
					public Insert generate(Tberrormsg t) {
						Insert insert = insertInto(TBERRORMSG_TABLE)
								.values(TBERRORMSG_TABLE.ID.value(t.getId()),
										TBERRORMSG_TABLE.ERR_CODE.value(t
												.getErrCode()),
										TBERRORMSG_TABLE.ERR_MSG.value(t
												.getErrMsg())

								);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(Tberrormsg tberrormsg) {
		if (tberrormsg == null || tberrormsg.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tberrormsg,
				new UpdateGenerateCallback<Tberrormsg>() {
					public Update generate(Tberrormsg t) {
						Update update = update(TBERRORMSG_TABLE)
								.set(TBERRORMSG_TABLE.ERR_CODE.value(t
										.getErrCode()),
										TBERRORMSG_TABLE.ERR_MSG.value(t
												.getErrMsg())).where(
										TBERRORMSG_TABLE.ID.eq(t.getId()));
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
						return delete(TBERRORMSG_TABLE).where(
								TBERRORMSG_TABLE.ID.eq(pk));
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
						return delete(TBERRORMSG_TABLE).where(
								TBERRORMSG_TABLE.ID.in(t));
					}
				}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Tberrormsg getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, Tberrormsg.class,
				new SelectGenerateCallback<Serializable>() {

					@SuppressWarnings("rawtypes")
					public Select generate(Serializable t) {
						return selectFrom(TBERRORMSG_TABLE).where(
								TBERRORMSG_TABLE.ID.eq(t));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<Tberrormsg> query(Tberrormsg tberrormsg,
			final OrderBy... orderArgs) {
		if (tberrormsg == null) {
			tberrormsg = new Tberrormsg();
		}
		return getDslTemplate().query(tberrormsg,
				new SelectGenerateCallback<Tberrormsg>() {
					@SuppressWarnings("rawtypes")
					public Select generate(Tberrormsg t) {
						Select select = selectFrom(TBERRORMSG_TABLE).where(
								and(TBERRORMSG_TABLE.ID.eq(t.getId()),
										TBERRORMSG_TABLE.ERR_CODE.eq(t
												.getErrCode()),
										TBERRORMSG_TABLE.ERR_MSG.eq(t
												.getErrMsg())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<Tberrormsg> queryPager(int start, int limit,
			Tberrormsg tberrormsg, final OrderBy... orderArgs) {
		if (tberrormsg == null) {
			tberrormsg = new Tberrormsg();
		}
		return getDslTemplate().queryPager(start, limit, tberrormsg, false,
				new SelectGenerateCallback<Tberrormsg>() {
					public Select generate(Tberrormsg t) {
						Select select = Select.selectFrom(TBERRORMSG_TABLE)
								.where(and(TBERRORMSG_TABLE.ID.eq(t.getId()),
										TBERRORMSG_TABLE.ERR_CODE.eq(t
												.getErrCode()),
										TBERRORMSG_TABLE.ERR_MSG.eq(t
												.getErrMsg())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<Tberrormsg> queryPagerForSearch(int start, int limit,
			Tberrormsg tberrormsg, final OrderBy... orderArgs) {
		if (tberrormsg == null) {
			tberrormsg = new Tberrormsg();
		}
		return getDslTemplate().queryPager(start, limit, tberrormsg, false,
				new SelectGenerateCallback<Tberrormsg>() {
			public Select generate(Tberrormsg t) {
				Select select = Select.selectFrom(TBERRORMSG_TABLE)
						.where(and(TBERRORMSG_TABLE.ID.eq(t.getId()),
								TBERRORMSG_TABLE.ERR_CODE.like(t
										.getErrCode()),
										TBERRORMSG_TABLE.ERR_MSG.like(t
												.getErrMsg())
												
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
			List<Tberrormsg> tberrormsg) {
		if (CollectionUtil.isEmpty(tberrormsg)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tberrormsg,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TBERRORMSG_TABLE)
								.values(TBERRORMSG_TABLE.ERR_CODE
										.value(new JdbcNamedParameter("errCode")),
										TBERRORMSG_TABLE.ERR_MSG
												.value(new JdbcNamedParameter(
														"errMsg"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<Tberrormsg> tberrormsgs) {
		return batchInsert(true, tberrormsgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<Tberrormsg> tberrormsg) {
		if (CollectionUtil.isEmpty(tberrormsg)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tberrormsg,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TBERRORMSG_TABLE)
								.set(TBERRORMSG_TABLE.ERR_CODE
										.value(new JdbcNamedParameter("errCode")),
										TBERRORMSG_TABLE.ERR_MSG
												.value(new JdbcNamedParameter(
														"errMsg"))

								).where(TBERRORMSG_TABLE.ID
										.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<Tberrormsg> tberrormsg) {
		if (CollectionUtil.isEmpty(tberrormsg)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tberrormsg,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TBERRORMSG_TABLE).where(
								and(TBERRORMSG_TABLE.ERR_CODE
										.eq(new JdbcNamedParameter("errCode")),
										TBERRORMSG_TABLE.ERR_MSG
												.eq(new JdbcNamedParameter(
														"errMsg"))

								));
					}
				});
	}

	/**
	 * 根据错误码获取信息
	 *
	 * @param 
	 * @return
	 */
	public List checkExist(Tberrormsg tberrormsg) {
		if (tberrormsg == null) {
			tberrormsg = new Tberrormsg();
		}
		return getDslTemplate().query(tberrormsg,
				new SelectGenerateCallback<Tberrormsg>() {
					@SuppressWarnings("rawtypes")
					public Select generate(Tberrormsg t) {
						Select select = selectFrom(TBERRORMSG_TABLE).where(
								and(TBERRORMSG_TABLE.ID.eq(t.getId()),
										TBERRORMSG_TABLE.ERR_CODE.eq(t
												.getErrCode())

								));
						return select;
					}
				});
	}
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys,
									 List<Tberrormsg> tberrormsg) {
		if (CollectionUtil.isEmpty(tberrormsg)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tberrormsg,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TBERRORMSG_TABLE)
								.values(TBERRORMSG_TABLE.ERR_CODE
												.value(new JdbcNamedParameter("errCode")),
										TBERRORMSG_TABLE.ERR_MSG
												.value(new JdbcNamedParameter(
														"errMsg"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<Tberrormsg> tberrormsg) {
		if (CollectionUtil.isEmpty(tberrormsg)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tberrormsg,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TBERRORMSG_TABLE)
								.set(TBERRORMSG_TABLE.ERR_CODE
												.value(new JdbcNamedParameter("errCode")),
										TBERRORMSG_TABLE.ERR_MSG
												.value(new JdbcNamedParameter(
														"errMsg"))

								).where(TBERRORMSG_TABLE.ID
										.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<Tberrormsg> tberrormsg) {
		if (CollectionUtil.isEmpty(tberrormsg)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tberrormsg,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TBERRORMSG_TABLE).where(
								and(TBERRORMSG_TABLE.ERR_CODE
												.eq(new JdbcNamedParameter("errCode")),
										TBERRORMSG_TABLE.ERR_MSG
												.eq(new JdbcNamedParameter(
														"errMsg"))

								));
					}
				});
	}

	public int[] preparedBatchInsert(List<Tberrormsg> tberrormsg) {
		return preparedBatchInsert(true, tberrormsg);
	}

}
