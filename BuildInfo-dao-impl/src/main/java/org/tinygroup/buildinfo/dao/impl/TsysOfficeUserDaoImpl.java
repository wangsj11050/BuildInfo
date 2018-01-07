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

import static org.tinygroup.buildinfo.dao.inter.constant.TsysOfficeTable.TSYS_OFFICE_TABLE;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;
import static org.tinygroup.buildinfo.dao.inter.constant.TsysOfficeUserTable.*;
import static org.tinygroup.tinysqldsl.Select.*;
import static org.tinygroup.tinysqldsl.Insert.*;
import static org.tinygroup.tinysqldsl.Delete.*;
import static org.tinygroup.tinysqldsl.Update.*;
import static org.tinygroup.tinysqldsl.formitem.SubSelect.subSelect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.TsysOffice;
import org.tinygroup.tinysqldsl.Delete;
import org.tinygroup.tinysqldsl.Insert;
import org.tinygroup.tinysqldsl.Select;
import org.tinygroup.tinysqldsl.Update;
import org.tinygroup.tinysqldsl.Pager;

import org.tinygroup.commons.tools.CollectionUtil;
import org.tinygroup.tinysqldsl.base.Condition;
import org.tinygroup.tinysqldsl.expression.JdbcNamedParameter;
import org.tinygroup.tinysqldsl.select.OrderByElement;

import org.tinygroup.buildinfo.dao.inter.pojo.TsysOfficeUser;
import org.tinygroup.buildinfo.dao.inter.TsysOfficeUserDao;

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
public class TsysOfficeUserDaoImpl extends TinyDslDaoSupport implements	TsysOfficeUserDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysOfficeUser add(TsysOfficeUser tsysOfficeUser) {
		return getDslTemplate().insertAndReturnKey(tsysOfficeUser,
				new InsertGenerateCallback<TsysOfficeUser>() {
					public Insert generate(TsysOfficeUser t) {
						Insert insert = insertInto(TSYS_OFFICE_USER_TABLE)
								.values(TSYS_OFFICE_USER_TABLE.ID.value(t
										.getId()),
										TSYS_OFFICE_USER_TABLE.USER_ID.value(t
												.getUserId()),
										TSYS_OFFICE_USER_TABLE.OFFICE_CODE
												.value(t.getOfficeCode())

								);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TsysOfficeUser tsysOfficeUser) {
		if (tsysOfficeUser == null || tsysOfficeUser.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tsysOfficeUser,
				new UpdateGenerateCallback<TsysOfficeUser>() {
					public Update generate(TsysOfficeUser t) {
						Update update = update(TSYS_OFFICE_USER_TABLE).set(
								TSYS_OFFICE_USER_TABLE.USER_ID.value(t
										.getUserId()),
								TSYS_OFFICE_USER_TABLE.OFFICE_CODE.value(t
										.getOfficeCode())).where(
								TSYS_OFFICE_USER_TABLE.ID.eq(t.getId()));
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
				return delete(TSYS_OFFICE_USER_TABLE).where(TSYS_OFFICE_USER_TABLE.USER_ID.eq(pk));
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
				return delete(TSYS_OFFICE_USER_TABLE).where(TSYS_OFFICE_USER_TABLE.USER_ID.in(t));
		}
		},pks);
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public TsysOfficeUser getByKey(String pk) {
		return getDslTemplate().getByKey(pk, TsysOfficeUser.class, new SelectGenerateCallback<Serializable>() {
		@SuppressWarnings("rawtypes")
		public Select generate(Serializable t) {
			return selectFrom(TSYS_OFFICE_USER_TABLE).where(TSYS_OFFICE_USER_TABLE.USER_ID.eq(t));
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
						return delete(TSYS_OFFICE_USER_TABLE).where(
								TSYS_OFFICE_USER_TABLE.ID.eq(pk));
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
						return delete(TSYS_OFFICE_USER_TABLE).where(
								TSYS_OFFICE_USER_TABLE.ID.in(t));
					}
				}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysOfficeUser getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, TsysOfficeUser.class,
				new SelectGenerateCallback<Serializable>() {

					@SuppressWarnings("rawtypes")
					public Select generate(Serializable t) {
						return selectFrom(TSYS_OFFICE_USER_TABLE).where(
								TSYS_OFFICE_USER_TABLE.ID.eq(t));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TsysOfficeUser> query(TsysOfficeUser tsysOfficeUser,
			final OrderBy... orderArgs) {
		if (tsysOfficeUser == null) {
			tsysOfficeUser = new TsysOfficeUser();
		}
		return getDslTemplate().query(tsysOfficeUser,
				new SelectGenerateCallback<TsysOfficeUser>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysOfficeUser t) {
						Select select = selectFrom(TSYS_OFFICE_USER_TABLE)
								.where(and(TSYS_OFFICE_USER_TABLE.USER_ID.eq(t
										.getUserId()),
										TSYS_OFFICE_USER_TABLE.OFFICE_CODE.eq(t
												.getOfficeCode())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TsysOfficeUser> queryPager(int start, int limit,
			TsysOfficeUser tsysOfficeUser, final OrderBy... orderArgs) {
		if (tsysOfficeUser == null) {
			tsysOfficeUser = new TsysOfficeUser();
		}
		return getDslTemplate().queryPager(start, limit, tsysOfficeUser, false,
				new SelectGenerateCallback<TsysOfficeUser>() {
					public Select generate(TsysOfficeUser t) {
						Select select = Select.selectFrom(
								TSYS_OFFICE_USER_TABLE).where(
								and(TSYS_OFFICE_USER_TABLE.USER_ID.eq(t
										.getUserId()),
										TSYS_OFFICE_USER_TABLE.OFFICE_CODE.eq(t
												.getOfficeCode())

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
			List<TsysOfficeUser> tsysOfficeUser) {
		if (CollectionUtil.isEmpty(tsysOfficeUser)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysOfficeUser,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_OFFICE_USER_TABLE)
								.values(TSYS_OFFICE_USER_TABLE.USER_ID
										.value(new JdbcNamedParameter("userId")),
										TSYS_OFFICE_USER_TABLE.OFFICE_CODE
												.value(new JdbcNamedParameter(
														"officeCode"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TsysOfficeUser> tsysOfficeUsers) {
		return batchInsert(true, tsysOfficeUsers);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TsysOfficeUser> tsysOfficeUser) {
		if (CollectionUtil.isEmpty(tsysOfficeUser)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysOfficeUser,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_OFFICE_USER_TABLE)
								.set(TSYS_OFFICE_USER_TABLE.USER_ID
										.value(new JdbcNamedParameter("userId")),
										TSYS_OFFICE_USER_TABLE.OFFICE_CODE
												.value(new JdbcNamedParameter(
														"officeCode"))

								).where(TSYS_OFFICE_USER_TABLE.ID
										.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TsysOfficeUser> tsysOfficeUser) {
		if (CollectionUtil.isEmpty(tsysOfficeUser)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysOfficeUser,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_OFFICE_USER_TABLE).where(
								and(TSYS_OFFICE_USER_TABLE.USER_ID
										.eq(new JdbcNamedParameter("userId")),
										TSYS_OFFICE_USER_TABLE.OFFICE_CODE
												.eq(new JdbcNamedParameter(
														"officeCode"))

								));
					}
				});
	}

	public int revokeUserOffices(String userCode, String[] removeOfficeId) {
			final String[] removeOfficeCpId = removeOfficeId;
			final String userCodeCp = userCode;
			return getDslTemplate().delete(new NoParamDeleteGenerateCallback(){
				public Delete generate() {
					return Delete.delete(TSYS_OFFICE_USER_TABLE).where(and(TSYS_OFFICE_USER_TABLE.USER_ID.eq(userCodeCp)
							,TSYS_OFFICE_USER_TABLE.OFFICE_CODE.in(removeOfficeCpId)));
				}
			});
	}

	public int[] grantUserOfficeBatch(String userCode, String[] officeIds) {
		List<TsysOfficeUser> list = new ArrayList<TsysOfficeUser>();
		for(String officeId:officeIds){
			if(officeId.length()==0){continue;}
			TsysOfficeUser tsysOfficeUser = new TsysOfficeUser();
			tsysOfficeUser.setOfficeCode(officeId);
			tsysOfficeUser.setUserId(userCode);
			list.add(tsysOfficeUser);
		}
		return batchInsert(list);
	}

	public Pager<TsysOffice> queryOfficeInUser(int start,int limit,final String userCode, TsysOffice tsysOffice,Boolean isAssign, final OrderBy... orderArgs) {
		if (tsysOffice == null) {
			tsysOffice = new TsysOffice();
		}
		final Condition subCondition;
		if(isAssign.booleanValue()){
			subCondition = TSYS_OFFICE_TABLE.OFFICE_CODE.inExpression(
					subSelect(select(TSYS_OFFICE_USER_TABLE.OFFICE_CODE)
							.from(TSYS_OFFICE_USER_TABLE).where(TSYS_OFFICE_USER_TABLE.USER_ID.eq(userCode)))
			);
		}else{
			subCondition = TSYS_OFFICE_TABLE.OFFICE_CODE.notInExpression(
					subSelect(select(TSYS_OFFICE_USER_TABLE.OFFICE_CODE)
							.from(TSYS_OFFICE_USER_TABLE).where(TSYS_OFFICE_USER_TABLE.USER_ID.eq(userCode)))
			);
		}
		return getDslTemplate().queryPager(start,limit,tsysOffice,false,
				new SelectGenerateCallback<TsysOffice>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysOffice t) {
						Select select = selectFrom(TSYS_OFFICE_TABLE).where(
								and(
										subCondition,
										TSYS_OFFICE_TABLE.OFFICE_CODE.eq(t
												.getOfficeCode()),
										TSYS_OFFICE_TABLE.OFFICE_NAME.like(t
												.getOfficeName()),
										TSYS_OFFICE_TABLE.SHORT_NAME.like(t
												.getShortName()),
										TSYS_OFFICE_TABLE.PARENT_CODE.like(t
												.getParentCode()),
										TSYS_OFFICE_TABLE.BRANCH_CODE.like(t
												.getBranchCode()),
										TSYS_OFFICE_TABLE.DEP_CODE.like(t
												.getDepCode()),
										TSYS_OFFICE_TABLE.OFFICE_PATH.like(t
												.getOfficePath()),
										TSYS_OFFICE_TABLE.BRANCH_LEVEL.like(t
												.getBranchLevel()),
										TSYS_OFFICE_TABLE.REMARK.like(t
												.getRemark()),
										TSYS_OFFICE_TABLE.EXT_FIELD_1.like(t
												.getExtField1()),
										TSYS_OFFICE_TABLE.EXT_FIELD_2.like(t
												.getExtField2()),
										TSYS_OFFICE_TABLE.EXT_FIELD_3.like(t
												.getExtField3())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys,
									 List<TsysOfficeUser> tsysOfficeUser) {
		if (CollectionUtil.isEmpty(tsysOfficeUser)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysOfficeUser,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_OFFICE_USER_TABLE)
								.values(TSYS_OFFICE_USER_TABLE.USER_ID
												.value(new JdbcNamedParameter("userId")),
										TSYS_OFFICE_USER_TABLE.OFFICE_CODE
												.value(new JdbcNamedParameter(
														"officeCode"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TsysOfficeUser> tsysOfficeUser) {
		if (CollectionUtil.isEmpty(tsysOfficeUser)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysOfficeUser,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_OFFICE_USER_TABLE)
								.set(TSYS_OFFICE_USER_TABLE.USER_ID
												.value(new JdbcNamedParameter("userId")),
										TSYS_OFFICE_USER_TABLE.OFFICE_CODE
												.value(new JdbcNamedParameter(
														"officeCode"))

								).where(TSYS_OFFICE_USER_TABLE.ID
										.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TsysOfficeUser> tsysOfficeUser) {
		if (CollectionUtil.isEmpty(tsysOfficeUser)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysOfficeUser,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_OFFICE_USER_TABLE).where(
								and(TSYS_OFFICE_USER_TABLE.USER_ID
												.eq(new JdbcNamedParameter("userId")),
										TSYS_OFFICE_USER_TABLE.OFFICE_CODE
												.eq(new JdbcNamedParameter(
														"officeCode"))

								));
					}
				});
	}

	public int[] preparedBatchInsert(List<TsysOfficeUser> tsysOfficeUser) {
		return preparedBatchInsert(true, tsysOfficeUser);
	}

}
