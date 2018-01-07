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
import static org.tinygroup.buildinfo.dao.inter.constant.TberrormsgTable.TBERRORMSG_TABLE;
import static org.tinygroup.buildinfo.dao.inter.constant.TbparamTable.*;
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
import org.tinygroup.buildinfo.dao.inter.pojo.Tberrormsg;
import org.tinygroup.buildinfo.dao.inter.pojo.Tbparam;
import org.tinygroup.buildinfo.dao.inter.TbparamDao;
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
public class TbparamDaoImpl extends TinyDslDaoSupport implements TbparamDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Tbparam add(Tbparam tbparam) {
		return getDslTemplate().insertAndReturnKey(tbparam,
				new InsertGenerateCallback<Tbparam>() {
					public Insert generate(Tbparam t) {
						Insert insert = insertInto(TBPARAM_TABLE)
								.values(TBPARAM_TABLE.ID.value(t.getId()),
										TBPARAM_TABLE.TA_CODE.value(t
												.getTaCode()),
										TBPARAM_TABLE.PARAM_ID.value(t
												.getParamId()),
										TBPARAM_TABLE.PARAM_NAME.value(t
												.getParamName()),
										TBPARAM_TABLE.PARAM_VALUE.value(t
												.getParamValue()),
										TBPARAM_TABLE.VALUE_NAME.value(t
												.getValueName()),
										TBPARAM_TABLE.BELONG_TYPE.value(t
												.getBelongType()),
										TBPARAM_TABLE.MODI_FLAG.value(t
												.getModiFlag()),
										TBPARAM_TABLE.RESERVE1.value(t
												.getReserve1())

								);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(Tbparam tbparam) {
		if (tbparam == null || tbparam.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tbparam,
				new UpdateGenerateCallback<Tbparam>() {
					public Update generate(Tbparam t) {
						Update update = update(TBPARAM_TABLE)
								.set(TBPARAM_TABLE.TA_CODE.value(t.getTaCode()),
										TBPARAM_TABLE.PARAM_ID.value(t
												.getParamId()),
										TBPARAM_TABLE.PARAM_NAME.value(t
												.getParamName()),
										TBPARAM_TABLE.PARAM_VALUE.value(t
												.getParamValue()),
										TBPARAM_TABLE.VALUE_NAME.value(t
												.getValueName()),
										TBPARAM_TABLE.BELONG_TYPE.value(t
												.getBelongType()),
										TBPARAM_TABLE.MODI_FLAG.value(t
												.getModiFlag()),
										TBPARAM_TABLE.RESERVE1.value(t
												.getReserve1())).where(
										TBPARAM_TABLE.ID.eq(t.getId()));
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
						return delete(TBPARAM_TABLE).where(
								TBPARAM_TABLE.ID.eq(pk));
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
						return delete(TBPARAM_TABLE).where(
								TBPARAM_TABLE.ID.in(t));
					}
				}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Tbparam getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, Tbparam.class,
				new SelectGenerateCallback<Serializable>() {

					@SuppressWarnings("rawtypes")
					public Select generate(Serializable t) {
						return selectFrom(TBPARAM_TABLE).where(
								TBPARAM_TABLE.ID.eq(t));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<Tbparam> query(Tbparam tbparam, final OrderBy... orderArgs) {
		if (tbparam == null) {
			tbparam = new Tbparam();
		}
		return getDslTemplate().query(tbparam,
				new SelectGenerateCallback<Tbparam>() {
					@SuppressWarnings("rawtypes")
					public Select generate(Tbparam t) {
						Select select = selectFrom(TBPARAM_TABLE)
								.where(and(
										TBPARAM_TABLE.ID.eq(t.getId()),
										TBPARAM_TABLE.TA_CODE.eq(t.getTaCode()),
										TBPARAM_TABLE.PARAM_ID.eq(t
												.getParamId()),
										TBPARAM_TABLE.PARAM_NAME.eq(t
												.getParamName()),
										TBPARAM_TABLE.PARAM_VALUE.eq(t
												.getParamValue()),
										TBPARAM_TABLE.VALUE_NAME.eq(t
												.getValueName()),
										TBPARAM_TABLE.BELONG_TYPE.eq(t
												.getBelongType()),
										TBPARAM_TABLE.MODI_FLAG.eq(t
												.getModiFlag()),
										TBPARAM_TABLE.RESERVE1.eq(t
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
	public Pager<Tbparam> queryPager(int start, int limit, Tbparam tbparam,
			final OrderBy... orderArgs) {
		if (tbparam == null) {
			tbparam = new Tbparam();
		}
		return getDslTemplate().queryPager(start, limit, tbparam, false,
				new SelectGenerateCallback<Tbparam>() {
					public Select generate(Tbparam t) {
						Select select = Select
								.selectFrom(TBPARAM_TABLE)
								.where(and(
										TBPARAM_TABLE.ID.eq(t.getId()),
										TBPARAM_TABLE.TA_CODE.eq(t.getTaCode()),
										TBPARAM_TABLE.PARAM_ID.eq(t
												.getParamId()),
										TBPARAM_TABLE.PARAM_NAME.eq(t
												.getParamName()),
										TBPARAM_TABLE.PARAM_VALUE.eq(t
												.getParamValue()),
										TBPARAM_TABLE.VALUE_NAME.eq(t
												.getValueName()),
										TBPARAM_TABLE.BELONG_TYPE.eq(t
												.getBelongType()),
										TBPARAM_TABLE.MODI_FLAG.eq(t
												.getModiFlag()),
										TBPARAM_TABLE.RESERVE1.eq(t
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
	public Pager<Tbparam> queryPagerForSearch(int start, int limit, Tbparam tbparam,
			final OrderBy... orderArgs) {
		if (tbparam == null) {
			tbparam = new Tbparam();
		}
		return getDslTemplate().queryPager(start, limit, tbparam, false,
				new SelectGenerateCallback<Tbparam>() {
					public Select generate(Tbparam t) {
						Select select = Select
								.selectFrom(TBPARAM_TABLE)
								.where(and(
										TBPARAM_TABLE.ID.eq(t.getId()),
										TBPARAM_TABLE.TA_CODE.like(t.getTaCode()),
										TBPARAM_TABLE.PARAM_ID.like(t
												.getParamId()),
										TBPARAM_TABLE.PARAM_NAME.like(t
												.getParamName()),
										TBPARAM_TABLE.PARAM_VALUE.like(t
												.getParamValue()),
										TBPARAM_TABLE.VALUE_NAME.like(t
												.getValueName()),
										TBPARAM_TABLE.BELONG_TYPE.like(t
												.getBelongType()),
										TBPARAM_TABLE.MODI_FLAG.like(t
												.getModiFlag()),
										TBPARAM_TABLE.RESERVE1.like(t
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
	public int[] batchInsert(boolean autoGeneratedKeys, List<Tbparam> tbparam) {
		if (CollectionUtil.isEmpty(tbparam)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tbparam,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TBPARAM_TABLE)
								.values(TBPARAM_TABLE.TA_CODE
										.value(new JdbcNamedParameter("taCode")),
										TBPARAM_TABLE.PARAM_ID
												.value(new JdbcNamedParameter(
														"paramId")),
										TBPARAM_TABLE.PARAM_NAME
												.value(new JdbcNamedParameter(
														"paramName")),
										TBPARAM_TABLE.PARAM_VALUE
												.value(new JdbcNamedParameter(
														"paramValue")),
										TBPARAM_TABLE.VALUE_NAME
												.value(new JdbcNamedParameter(
														"valueName")),
										TBPARAM_TABLE.BELONG_TYPE
												.value(new JdbcNamedParameter(
														"belongType")),
										TBPARAM_TABLE.MODI_FLAG
												.value(new JdbcNamedParameter(
														"modiFlag")),
										TBPARAM_TABLE.RESERVE1
												.value(new JdbcNamedParameter(
														"reserve1"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<Tbparam> tbparams) {
		return batchInsert(true, tbparams);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<Tbparam> tbparam) {
		if (CollectionUtil.isEmpty(tbparam)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tbparam,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TBPARAM_TABLE)
								.set(TBPARAM_TABLE.TA_CODE
										.value(new JdbcNamedParameter("taCode")),
										TBPARAM_TABLE.PARAM_ID
												.value(new JdbcNamedParameter(
														"paramId")),
										TBPARAM_TABLE.PARAM_NAME
												.value(new JdbcNamedParameter(
														"paramName")),
										TBPARAM_TABLE.PARAM_VALUE
												.value(new JdbcNamedParameter(
														"paramValue")),
										TBPARAM_TABLE.VALUE_NAME
												.value(new JdbcNamedParameter(
														"valueName")),
										TBPARAM_TABLE.BELONG_TYPE
												.value(new JdbcNamedParameter(
														"belongType")),
										TBPARAM_TABLE.MODI_FLAG
												.value(new JdbcNamedParameter(
														"modiFlag")),
										TBPARAM_TABLE.RESERVE1
												.value(new JdbcNamedParameter(
														"reserve1"))

								).where(TBPARAM_TABLE.ID
										.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<Tbparam> tbparam) {
		if (CollectionUtil.isEmpty(tbparam)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tbparam,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TBPARAM_TABLE).where(
								and(TBPARAM_TABLE.TA_CODE
										.eq(new JdbcNamedParameter("taCode")),
										TBPARAM_TABLE.PARAM_ID
												.eq(new JdbcNamedParameter(
														"paramId")),
										TBPARAM_TABLE.PARAM_NAME
												.eq(new JdbcNamedParameter(
														"paramName")),
										TBPARAM_TABLE.PARAM_VALUE
												.eq(new JdbcNamedParameter(
														"paramValue")),
										TBPARAM_TABLE.VALUE_NAME
												.eq(new JdbcNamedParameter(
														"valueName")),
										TBPARAM_TABLE.BELONG_TYPE
												.eq(new JdbcNamedParameter(
														"belongType")),
										TBPARAM_TABLE.MODI_FLAG
												.eq(new JdbcNamedParameter(
														"modiFlag")),
										TBPARAM_TABLE.RESERVE1
												.eq(new JdbcNamedParameter(
														"reserve1"))

								));
					}
				});
	}

	/**
	 * 根据TA_CODE PARAM_ID获取值
	 *
	 * @param tbparam
	 * @return
	 */
	public List checkExist(Tbparam tbparam) {
		if (tbparam == null) {
			tbparam = new Tbparam();
		}
		return getDslTemplate().query(tbparam,
				new SelectGenerateCallback<Tbparam>() {
					@SuppressWarnings("rawtypes")
					public Select generate(Tbparam t) {
						Select select = selectFrom(TBPARAM_TABLE)
								.where(and(
										TBPARAM_TABLE.TA_CODE.eq(t.getTaCode()),
										TBPARAM_TABLE.PARAM_ID.eq(t
												.getParamId())

								));
						return select;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys,
									 List<Tbparam> tbparam) {
		if (CollectionUtil.isEmpty(tbparam)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tbparam,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TBPARAM_TABLE)
								.values(TBPARAM_TABLE.TA_CODE
												.value(new JdbcNamedParameter(
														"taCode")),
										TBPARAM_TABLE.PARAM_ID
												.value(new JdbcNamedParameter(
														"paramId")),
										TBPARAM_TABLE.PARAM_NAME
												.value(new JdbcNamedParameter(
														"paramName")),
										TBPARAM_TABLE.PARAM_VALUE
												.value(new JdbcNamedParameter(
														"paramValue")),
										TBPARAM_TABLE.VALUE_NAME
												.value(new JdbcNamedParameter(
														"valueName")),
										TBPARAM_TABLE.BELONG_TYPE
												.value(new JdbcNamedParameter(
														"belongType")),
										TBPARAM_TABLE.MODI_FLAG
												.value(new JdbcNamedParameter(
														"modiFlag")),
										TBPARAM_TABLE.RESERVE1
												.value(new JdbcNamedParameter(
														"reserve1"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<Tbparam> tbparam) {
		if (CollectionUtil.isEmpty(tbparam)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tbparam,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TBPARAM_TABLE)
								.set(TBPARAM_TABLE.TA_CODE
												.value(new JdbcNamedParameter(
														"taCode")),
										TBPARAM_TABLE.PARAM_ID
												.value(new JdbcNamedParameter(
														"paramId")),
										TBPARAM_TABLE.PARAM_NAME
												.value(new JdbcNamedParameter(
														"paramName")),
										TBPARAM_TABLE.PARAM_VALUE
												.value(new JdbcNamedParameter(
														"paramValue")),
										TBPARAM_TABLE.VALUE_NAME
												.value(new JdbcNamedParameter(
														"valueName")),
										TBPARAM_TABLE.BELONG_TYPE
												.value(new JdbcNamedParameter(
														"belongType")),
										TBPARAM_TABLE.MODI_FLAG
												.value(new JdbcNamedParameter(
														"modiFlag")),
										TBPARAM_TABLE.RESERVE1
												.value(new JdbcNamedParameter(
														"reserve1"))

								).where(TBPARAM_TABLE.ID
										.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<Tbparam> tbparam) {
		if (CollectionUtil.isEmpty(tbparam)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tbparam,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TBPARAM_TABLE).where(
								and(TBPARAM_TABLE.TA_CODE
												.eq(new JdbcNamedParameter(
														"taCode")),
										TBPARAM_TABLE.PARAM_ID
												.eq(new JdbcNamedParameter(
														"paramId")),
										TBPARAM_TABLE.PARAM_NAME
												.eq(new JdbcNamedParameter(
														"paramName")),
										TBPARAM_TABLE.PARAM_VALUE
												.eq(new JdbcNamedParameter(
														"paramValue")),
										TBPARAM_TABLE.VALUE_NAME
												.eq(new JdbcNamedParameter(
														"valueName")),
										TBPARAM_TABLE.BELONG_TYPE
												.eq(new JdbcNamedParameter(
														"belongType")),
										TBPARAM_TABLE.MODI_FLAG
												.eq(new JdbcNamedParameter(
														"modiFlag")),
										TBPARAM_TABLE.RESERVE1
												.eq(new JdbcNamedParameter(
														"reserve1"))

								));
					}
				});
	}

	public int[] preparedBatchInsert(List<Tbparam> tbparam) {
		return preparedBatchInsert(true, tbparam);
	}

}
