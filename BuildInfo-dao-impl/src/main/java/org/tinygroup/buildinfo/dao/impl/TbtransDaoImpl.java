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

import static org.tinygroup.buildinfo.dao.inter.constant.TbtransTable.TBTRANS_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;

import java.io.Serializable;
import java.util.List;

import org.tinygroup.buildinfo.dao.inter.TbtransDao;
import org.tinygroup.buildinfo.dao.inter.pojo.Tbtrans;
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
public class TbtransDaoImpl extends TinyDslDaoSupport implements TbtransDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Tbtrans add(Tbtrans tbtrans) {
		return getDslTemplate().insertAndReturnKey(tbtrans,
				new InsertGenerateCallback<Tbtrans>() {
					public Insert generate(Tbtrans t) {
						Insert insert = insertInto(TBTRANS_TABLE)
								.values(TBTRANS_TABLE.ID.value(t.getId()),
										TBTRANS_TABLE.TRANS_CODE.value(t
												.getTransCode()),
										TBTRANS_TABLE.TRANS_NAME.value(t
												.getTransName()),
										TBTRANS_TABLE.ENABLE_FLAG.value(t
												.getEnableFlag()),
										TBTRANS_TABLE.CHANNELS.value(t
												.getChannels()),
										TBTRANS_TABLE.HOST_ONLINE.value(t
												.getHostOnline()),
										TBTRANS_TABLE.TRANS_TYPE.value(t
												.getTransType()),
										TBTRANS_TABLE.MONITOR_STATUS.value(t
												.getMonitorStatus()),
										TBTRANS_TABLE.LOG_LEVEL.value(t
												.getLogLevel()),
										TBTRANS_TABLE.MON_TRANS_TYPE.value(t
												.getMonTransType()),
										TBTRANS_TABLE.RESERVE1.value(t
												.getReserve1()),
										TBTRANS_TABLE.RESERVE2.value(t
												.getReserve2()),
										TBTRANS_TABLE.RESERVE3.value(t
												.getReserve3())

								);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(Tbtrans tbtrans) {
		if (tbtrans == null || tbtrans.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tbtrans,
				new UpdateGenerateCallback<Tbtrans>() {
					public Update generate(Tbtrans t) {
						Update update = update(TBTRANS_TABLE)
								.set(TBTRANS_TABLE.TRANS_CODE.value(t
										.getTransCode()),
										TBTRANS_TABLE.TRANS_NAME.value(t
												.getTransName()),
										TBTRANS_TABLE.ENABLE_FLAG.value(t
												.getEnableFlag()),
										TBTRANS_TABLE.CHANNELS.value(t
												.getChannels()),
										TBTRANS_TABLE.HOST_ONLINE.value(t
												.getHostOnline()),
										TBTRANS_TABLE.TRANS_TYPE.value(t
												.getTransType()),
										TBTRANS_TABLE.MONITOR_STATUS.value(t
												.getMonitorStatus()),
										TBTRANS_TABLE.LOG_LEVEL.value(t
												.getLogLevel()),
										TBTRANS_TABLE.MON_TRANS_TYPE.value(t
												.getMonTransType()),
										TBTRANS_TABLE.RESERVE1.value(t
												.getReserve1()),
										TBTRANS_TABLE.RESERVE2.value(t
												.getReserve2()),
										TBTRANS_TABLE.RESERVE3.value(t
												.getReserve3())).where(
										TBTRANS_TABLE.ID.eq(t.getId()));
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
						return delete(TBTRANS_TABLE).where(
								TBTRANS_TABLE.ID.eq(pk));
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
						return delete(TBTRANS_TABLE).where(
								TBTRANS_TABLE.ID.in(t));
					}
				}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Tbtrans getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, Tbtrans.class,
				new SelectGenerateCallback<Serializable>() {

					@SuppressWarnings("rawtypes")
					public Select generate(Serializable t) {
						return selectFrom(TBTRANS_TABLE).where(
								TBTRANS_TABLE.ID.eq(t));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<Tbtrans> query(Tbtrans tbtrans, final OrderBy... orderArgs) {
		if (tbtrans == null) {
			tbtrans = new Tbtrans();
		}
		return getDslTemplate().query(tbtrans,
				new SelectGenerateCallback<Tbtrans>() {
					@SuppressWarnings("rawtypes")
					public Select generate(Tbtrans t) {
						Select select = selectFrom(TBTRANS_TABLE).where(
								and(TBTRANS_TABLE.ID.eq(t.getId()),
										TBTRANS_TABLE.TRANS_CODE.eq(t
												.getTransCode()),
										TBTRANS_TABLE.TRANS_NAME.eq(t
												.getTransName()),
										TBTRANS_TABLE.ENABLE_FLAG.eq(t
												.getEnableFlag()),
										TBTRANS_TABLE.CHANNELS.eq(t
												.getChannels()),
										TBTRANS_TABLE.HOST_ONLINE.eq(t
												.getHostOnline()),
										TBTRANS_TABLE.TRANS_TYPE.eq(t
												.getTransType()),
										TBTRANS_TABLE.MONITOR_STATUS.eq(t
												.getMonitorStatus()),
										TBTRANS_TABLE.LOG_LEVEL.eq(t
												.getLogLevel()),
										TBTRANS_TABLE.MON_TRANS_TYPE.eq(t
												.getMonTransType()),
										TBTRANS_TABLE.RESERVE1.eq(t
												.getReserve1()),
										TBTRANS_TABLE.RESERVE2.eq(t
												.getReserve2()),
										TBTRANS_TABLE.RESERVE3.eq(t
												.getReserve3())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<Tbtrans> queryPager(int start, int limit, Tbtrans tbtrans,
			final OrderBy... orderArgs) {
		if (tbtrans == null) {
			tbtrans = new Tbtrans();
		}
		return getDslTemplate().queryPager(start, limit, tbtrans, false,
				new SelectGenerateCallback<Tbtrans>() {
					public Select generate(Tbtrans t) {
						Select select = Select.selectFrom(TBTRANS_TABLE).where(
								and(TBTRANS_TABLE.ID.eq(t.getId()),
										TBTRANS_TABLE.TRANS_CODE.eq(t
												.getTransCode()),
										TBTRANS_TABLE.TRANS_NAME.eq(t
												.getTransName()),
										TBTRANS_TABLE.ENABLE_FLAG.eq(t
												.getEnableFlag()),
										TBTRANS_TABLE.CHANNELS.eq(t
												.getChannels()),
										TBTRANS_TABLE.HOST_ONLINE.eq(t
												.getHostOnline()),
										TBTRANS_TABLE.TRANS_TYPE.eq(t
												.getTransType()),
										TBTRANS_TABLE.MONITOR_STATUS.eq(t
												.getMonitorStatus()),
										TBTRANS_TABLE.LOG_LEVEL.eq(t
												.getLogLevel()),
										TBTRANS_TABLE.MON_TRANS_TYPE.eq(t
												.getMonTransType()),
										TBTRANS_TABLE.RESERVE1.eq(t
												.getReserve1()),
										TBTRANS_TABLE.RESERVE2.eq(t
												.getReserve2()),
										TBTRANS_TABLE.RESERVE3.eq(t
												.getReserve3())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<Tbtrans> queryPagerForSearch(int start, int limit, Tbtrans tbtrans,
			final OrderBy... orderArgs) {
		if (tbtrans == null) {
			tbtrans = new Tbtrans();
		}
		return getDslTemplate().queryPager(start, limit, tbtrans, false,
				new SelectGenerateCallback<Tbtrans>() {
					public Select generate(Tbtrans t) {
						Select select = Select.selectFrom(TBTRANS_TABLE).where(
								and(TBTRANS_TABLE.ID.eq(t.getId()),
										TBTRANS_TABLE.TRANS_CODE.like(t
												.getTransCode()),
										TBTRANS_TABLE.TRANS_NAME.like(t
												.getTransName()),
										TBTRANS_TABLE.ENABLE_FLAG.like(t
												.getEnableFlag()),
										TBTRANS_TABLE.CHANNELS.like(t
												.getChannels()),
										TBTRANS_TABLE.HOST_ONLINE.like(t
												.getHostOnline()),
										TBTRANS_TABLE.TRANS_TYPE.like(t
												.getTransType()),
										TBTRANS_TABLE.MONITOR_STATUS.like(t
												.getMonitorStatus()),
										TBTRANS_TABLE.LOG_LEVEL.like(t
												.getLogLevel()),
										TBTRANS_TABLE.MON_TRANS_TYPE.like(t
												.getMonTransType()),
										TBTRANS_TABLE.RESERVE1.like(t
												.getReserve1()),
										TBTRANS_TABLE.RESERVE2.like(t
												.getReserve2()),
										TBTRANS_TABLE.RESERVE3.like(t
												.getReserve3())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<Tbtrans> tbtrans) {
		if (CollectionUtil.isEmpty(tbtrans)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tbtrans,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TBTRANS_TABLE).values(
								TBTRANS_TABLE.TRANS_CODE
										.value(new JdbcNamedParameter(
												"transCode")),
								TBTRANS_TABLE.TRANS_NAME
										.value(new JdbcNamedParameter(
												"transName")),
								TBTRANS_TABLE.ENABLE_FLAG
										.value(new JdbcNamedParameter(
												"enableFlag")),
								TBTRANS_TABLE.CHANNELS
										.value(new JdbcNamedParameter(
												"channels")),
								TBTRANS_TABLE.HOST_ONLINE
										.value(new JdbcNamedParameter(
												"hostOnline")),
								TBTRANS_TABLE.TRANS_TYPE
										.value(new JdbcNamedParameter(
												"transType")),
								TBTRANS_TABLE.MONITOR_STATUS
										.value(new JdbcNamedParameter(
												"monitorStatus")),
								TBTRANS_TABLE.LOG_LEVEL
										.value(new JdbcNamedParameter(
												"logLevel")),
								TBTRANS_TABLE.MON_TRANS_TYPE
										.value(new JdbcNamedParameter(
												"monTransType")),
								TBTRANS_TABLE.RESERVE1
										.value(new JdbcNamedParameter(
												"reserve1")),
								TBTRANS_TABLE.RESERVE2
										.value(new JdbcNamedParameter(
												"reserve2")),
								TBTRANS_TABLE.RESERVE3
										.value(new JdbcNamedParameter(
												"reserve3"))

						);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<Tbtrans> tbtranss) {
		return batchInsert(true, tbtranss);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<Tbtrans> tbtrans) {
		if (CollectionUtil.isEmpty(tbtrans)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tbtrans,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TBTRANS_TABLE).set(
								TBTRANS_TABLE.TRANS_CODE
										.value(new JdbcNamedParameter(
												"transCode")),
								TBTRANS_TABLE.TRANS_NAME
										.value(new JdbcNamedParameter(
												"transName")),
								TBTRANS_TABLE.ENABLE_FLAG
										.value(new JdbcNamedParameter(
												"enableFlag")),
								TBTRANS_TABLE.CHANNELS
										.value(new JdbcNamedParameter(
												"channels")),
								TBTRANS_TABLE.HOST_ONLINE
										.value(new JdbcNamedParameter(
												"hostOnline")),
								TBTRANS_TABLE.TRANS_TYPE
										.value(new JdbcNamedParameter(
												"transType")),
								TBTRANS_TABLE.MONITOR_STATUS
										.value(new JdbcNamedParameter(
												"monitorStatus")),
								TBTRANS_TABLE.LOG_LEVEL
										.value(new JdbcNamedParameter(
												"logLevel")),
								TBTRANS_TABLE.MON_TRANS_TYPE
										.value(new JdbcNamedParameter(
												"monTransType")),
								TBTRANS_TABLE.RESERVE1
										.value(new JdbcNamedParameter(
												"reserve1")),
								TBTRANS_TABLE.RESERVE2
										.value(new JdbcNamedParameter(
												"reserve2")),
								TBTRANS_TABLE.RESERVE3
										.value(new JdbcNamedParameter(
												"reserve3"))

						).where(TBTRANS_TABLE.ID
								.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<Tbtrans> tbtrans) {
		if (CollectionUtil.isEmpty(tbtrans)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tbtrans,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TBTRANS_TABLE)
								.where(and(
										TBTRANS_TABLE.TRANS_CODE
												.eq(new JdbcNamedParameter(
														"transCode")),
										TBTRANS_TABLE.TRANS_NAME
												.eq(new JdbcNamedParameter(
														"transName")),
										TBTRANS_TABLE.ENABLE_FLAG
												.eq(new JdbcNamedParameter(
														"enableFlag")),
										TBTRANS_TABLE.CHANNELS
												.eq(new JdbcNamedParameter(
														"channels")),
										TBTRANS_TABLE.HOST_ONLINE
												.eq(new JdbcNamedParameter(
														"hostOnline")),
										TBTRANS_TABLE.TRANS_TYPE
												.eq(new JdbcNamedParameter(
														"transType")),
										TBTRANS_TABLE.MONITOR_STATUS
												.eq(new JdbcNamedParameter(
														"monitorStatus")),
										TBTRANS_TABLE.LOG_LEVEL
												.eq(new JdbcNamedParameter(
														"logLevel")),
										TBTRANS_TABLE.MON_TRANS_TYPE
												.eq(new JdbcNamedParameter(
														"monTransType")),
										TBTRANS_TABLE.RESERVE1
												.eq(new JdbcNamedParameter(
														"reserve1")),
										TBTRANS_TABLE.RESERVE2
												.eq(new JdbcNamedParameter(
														"reserve2")),
										TBTRANS_TABLE.RESERVE3
												.eq(new JdbcNamedParameter(
														"reserve3"))

								));
					}
				});
	}

	/**
	 * 根据trans_code 获取信息
	 *
	 * @param tbtrans
	 * @return
	 */
	public List checkExist(Tbtrans tbtrans) {
		if (tbtrans == null) {
			tbtrans = new Tbtrans();
		}
		return getDslTemplate().query(tbtrans,
				new SelectGenerateCallback<Tbtrans>() {
					@SuppressWarnings("rawtypes")
					public Select generate(Tbtrans t) {
						Select select = selectFrom(TBTRANS_TABLE).where(
								and(TBTRANS_TABLE.TRANS_CODE.eq(t
												.getTransCode())

								));
						return select;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys,
									 List<Tbtrans> tbtrans) {
		if (CollectionUtil.isEmpty(tbtrans)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tbtrans,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TBTRANS_TABLE)
								.values(TBTRANS_TABLE.TRANS_CODE
												.value(new JdbcNamedParameter(
														"transCode")),
										TBTRANS_TABLE.TRANS_NAME
												.value(new JdbcNamedParameter(
														"transName")),
										TBTRANS_TABLE.ENABLE_FLAG
												.value(new JdbcNamedParameter(
														"enableFlag")),
										TBTRANS_TABLE.CHANNELS
												.value(new JdbcNamedParameter(
														"channels")),
										TBTRANS_TABLE.HOST_ONLINE
												.value(new JdbcNamedParameter(
														"hostOnline")),
										TBTRANS_TABLE.TRANS_TYPE
												.value(new JdbcNamedParameter(
														"transType")),
										TBTRANS_TABLE.MONITOR_STATUS
												.value(new JdbcNamedParameter(
														"monitorStatus")),
										TBTRANS_TABLE.LOG_LEVEL
												.value(new JdbcNamedParameter(
														"logLevel")),
										TBTRANS_TABLE.MON_TRANS_TYPE
												.value(new JdbcNamedParameter(
														"monTransType")),
										TBTRANS_TABLE.RESERVE1
												.value(new JdbcNamedParameter(
														"reserve1")),
										TBTRANS_TABLE.RESERVE2
												.value(new JdbcNamedParameter(
														"reserve2")),
										TBTRANS_TABLE.RESERVE3
												.value(new JdbcNamedParameter(
														"reserve3"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<Tbtrans> tbtrans) {
		if (CollectionUtil.isEmpty(tbtrans)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tbtrans,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TBTRANS_TABLE)
								.set(TBTRANS_TABLE.TRANS_CODE
												.value(new JdbcNamedParameter(
														"transCode")),
										TBTRANS_TABLE.TRANS_NAME
												.value(new JdbcNamedParameter(
														"transName")),
										TBTRANS_TABLE.ENABLE_FLAG
												.value(new JdbcNamedParameter(
														"enableFlag")),
										TBTRANS_TABLE.CHANNELS
												.value(new JdbcNamedParameter(
														"channels")),
										TBTRANS_TABLE.HOST_ONLINE
												.value(new JdbcNamedParameter(
														"hostOnline")),
										TBTRANS_TABLE.TRANS_TYPE
												.value(new JdbcNamedParameter(
														"transType")),
										TBTRANS_TABLE.MONITOR_STATUS
												.value(new JdbcNamedParameter(
														"monitorStatus")),
										TBTRANS_TABLE.LOG_LEVEL
												.value(new JdbcNamedParameter(
														"logLevel")),
										TBTRANS_TABLE.MON_TRANS_TYPE
												.value(new JdbcNamedParameter(
														"monTransType")),
										TBTRANS_TABLE.RESERVE1
												.value(new JdbcNamedParameter(
														"reserve1")),
										TBTRANS_TABLE.RESERVE2
												.value(new JdbcNamedParameter(
														"reserve2")),
										TBTRANS_TABLE.RESERVE3
												.value(new JdbcNamedParameter(
														"reserve3"))

								).where(TBTRANS_TABLE.ID
										.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<Tbtrans> tbtrans) {
		if (CollectionUtil.isEmpty(tbtrans)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tbtrans,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TBTRANS_TABLE).where(
								and(TBTRANS_TABLE.TRANS_CODE
												.eq(new JdbcNamedParameter(
														"transCode")),
										TBTRANS_TABLE.TRANS_NAME
												.eq(new JdbcNamedParameter(
														"transName")),
										TBTRANS_TABLE.ENABLE_FLAG
												.eq(new JdbcNamedParameter(
														"enableFlag")),
										TBTRANS_TABLE.CHANNELS
												.eq(new JdbcNamedParameter(
														"channels")),
										TBTRANS_TABLE.HOST_ONLINE
												.eq(new JdbcNamedParameter(
														"hostOnline")),
										TBTRANS_TABLE.TRANS_TYPE
												.eq(new JdbcNamedParameter(
														"transType")),
										TBTRANS_TABLE.MONITOR_STATUS
												.eq(new JdbcNamedParameter(
														"monitorStatus")),
										TBTRANS_TABLE.LOG_LEVEL
												.eq(new JdbcNamedParameter(
														"logLevel")),
										TBTRANS_TABLE.MON_TRANS_TYPE
												.eq(new JdbcNamedParameter(
														"monTransType")),
										TBTRANS_TABLE.RESERVE1
												.eq(new JdbcNamedParameter(
														"reserve1")),
										TBTRANS_TABLE.RESERVE2
												.eq(new JdbcNamedParameter(
														"reserve2")),
										TBTRANS_TABLE.RESERVE3
												.eq(new JdbcNamedParameter(
														"reserve3"))

								));
					}
				});
	}

	public int[] preparedBatchInsert(List<Tbtrans> tbtrans) {
		return preparedBatchInsert(true, tbtrans);
	}
}
