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

import static org.tinygroup.buildinfo.dao.inter.constant.TsysRoleTable.TSYS_ROLE_TABLE;
import static org.tinygroup.buildinfo.dao.inter.constant.TsysRoleUserTable.TSYS_ROLE_USER_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.select;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;
import static org.tinygroup.tinysqldsl.formitem.SubSelect.subSelect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.tinygroup.buildinfo.dao.inter.TsysRoleUserDao;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysRightRef;
import org.tinygroup.buildinfo.dao.inter.pojo.complex.RoleUserRef;
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
import org.tinygroup.tinysqldsl.base.Condition;
import org.tinygroup.tinysqldsl.expression.JdbcNamedParameter;

/**
 * <!-- begin-user-doc --> 濡傛灉涓嶅笇鏈涙煇鏂规硶鎴栬�鍙橀噺琚鐩栵紝鍙互鍦ㄦ柟娉曟垨鑰呭彉閲忔敞閲婁腑澧炲姞@unmodifiable
 * <!-- end-user-doc -->
 */
public class TsysRoleUserDaoImpl extends TinyDslDaoSupport implements
		TsysRoleUserDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysRightRef add(TsysRightRef tsysRoleUser) {
		return getDslTemplate().insertAndReturnKey(tsysRoleUser,
				new InsertGenerateCallback<TsysRightRef>() {
					public Insert generate(TsysRightRef t) {
						Insert insert = insertInto(TSYS_ROLE_USER_TABLE)
								.values(TSYS_ROLE_USER_TABLE.ID
										.value(t.getId()),
										TSYS_ROLE_USER_TABLE.USER_CODE.value(t
												.getUserCode()),
										TSYS_ROLE_USER_TABLE.ROLE_CODE.value(t
												.getRoleCode()),
										TSYS_ROLE_USER_TABLE.RIGHT_FLAG.value(t
												.getRightFlag())

								);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TsysRightRef tsysRoleUser) {
		if (tsysRoleUser == null || tsysRoleUser.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tsysRoleUser,
				new UpdateGenerateCallback<TsysRightRef>() {
					public Update generate(TsysRightRef t) {
						Update update = update(TSYS_ROLE_USER_TABLE).set(
								TSYS_ROLE_USER_TABLE.USER_CODE.value(t
										.getUserCode()),
								TSYS_ROLE_USER_TABLE.ROLE_CODE.value(t
										.getRoleCode()),
								TSYS_ROLE_USER_TABLE.RIGHT_FLAG.value(t
										.getRightFlag())).where(
								TSYS_ROLE_USER_TABLE.ID.eq(t.getId()));
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
				return delete(TSYS_ROLE_USER_TABLE).where(TSYS_ROLE_USER_TABLE.USER_CODE.eq(pk));
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
				return delete(TSYS_ROLE_USER_TABLE).where(TSYS_ROLE_USER_TABLE.USER_CODE.in(t));
		}
		},pks);
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public TsysRightRef getByKey(String pk) {
		return getDslTemplate().getByKey(pk, TsysRightRef.class, new SelectGenerateCallback<Serializable>() {
		@SuppressWarnings("rawtypes")
		public Select generate(Serializable t) {
			return selectFrom(TSYS_ROLE_USER_TABLE).where(TSYS_ROLE_USER_TABLE.USER_CODE.eq(t));
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
						return delete(TSYS_ROLE_USER_TABLE).where(
								TSYS_ROLE_USER_TABLE.ID.eq(pk));
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
						return delete(TSYS_ROLE_USER_TABLE).where(
								TSYS_ROLE_USER_TABLE.ID.in(t));
					}
				}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysRightRef getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, TsysRightRef.class,
				new SelectGenerateCallback<Serializable>() {

					@SuppressWarnings("rawtypes")
					public Select generate(Serializable t) {
						return selectFrom(TSYS_ROLE_USER_TABLE).where(
								TSYS_ROLE_USER_TABLE.ID.eq(t));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TsysRightRef> query(TsysRightRef tsysRoleUser,
									final OrderBy... orderArgs) {
		if (tsysRoleUser == null) {
			tsysRoleUser = new TsysRightRef();
		}
		return getDslTemplate().query(tsysRoleUser,
				new SelectGenerateCallback<TsysRightRef>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysRightRef t) {
						Select select = selectFrom(TSYS_ROLE_USER_TABLE).where(
								and(TSYS_ROLE_USER_TABLE.USER_CODE.eq(t
										.getUserCode()),
										TSYS_ROLE_USER_TABLE.ROLE_CODE.eq(t
												.getRoleCode()),
										TSYS_ROLE_USER_TABLE.RIGHT_FLAG.eq(t
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
	public Pager<TsysRightRef> queryPager(int start, int limit,
										  TsysRightRef tsysRoleUser, final OrderBy... orderArgs) {
		if (tsysRoleUser == null) {
			tsysRoleUser = new TsysRightRef();
		}
		return getDslTemplate().queryPager(start, limit, tsysRoleUser, false,
				new SelectGenerateCallback<TsysRightRef>() {
					public Select generate(TsysRightRef t) {
						Select select = Select.selectFrom(TSYS_ROLE_USER_TABLE)
								.where(and(TSYS_ROLE_USER_TABLE.USER_CODE.eq(t
										.getUserCode()),
										TSYS_ROLE_USER_TABLE.ROLE_CODE.eq(t
												.getRoleCode()),
										TSYS_ROLE_USER_TABLE.RIGHT_FLAG.eq(t
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
			List<TsysRightRef> tsysRoleUser) {
		if (CollectionUtil.isEmpty(tsysRoleUser)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysRoleUser,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_ROLE_USER_TABLE).values(
								TSYS_ROLE_USER_TABLE.USER_CODE
										.value(new JdbcNamedParameter(
												"userCode")),
								TSYS_ROLE_USER_TABLE.ROLE_ID
										.value(new JdbcNamedParameter(
												"roleId")),
								TSYS_ROLE_USER_TABLE.RIGHT_FLAG
										.value(new JdbcNamedParameter(
												"rightFlag"))

						);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TsysRightRef> tsysRoleUsers) {
		return batchInsert(true, tsysRoleUsers);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TsysRightRef> tsysRoleUser) {
		if (CollectionUtil.isEmpty(tsysRoleUser)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysRoleUser,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_ROLE_USER_TABLE).set(
								TSYS_ROLE_USER_TABLE.USER_CODE
										.value(new JdbcNamedParameter(
												"userCode")),
								TSYS_ROLE_USER_TABLE.ROLE_CODE
										.value(new JdbcNamedParameter(
												"roleCode")),
								TSYS_ROLE_USER_TABLE.RIGHT_FLAG
										.value(new JdbcNamedParameter(
												"rightFlag"))

						).where(TSYS_ROLE_USER_TABLE.ID
								.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TsysRightRef> tsysRoleUser) {
		if (CollectionUtil.isEmpty(tsysRoleUser)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysRoleUser,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_ROLE_USER_TABLE)
								.where(and(
										TSYS_ROLE_USER_TABLE.USER_CODE
												.eq(new JdbcNamedParameter(
														"userCode")),
										TSYS_ROLE_USER_TABLE.ROLE_CODE
												.eq(new JdbcNamedParameter(
														"roleCode")),
										TSYS_ROLE_USER_TABLE.RIGHT_FLAG
												.eq(new JdbcNamedParameter(
														"rightFlag"))

								));
					}
				});
	}


	public int[] grantRoles(String userCode, Integer[] preAddRoleIds) {
		List<TsysRightRef> list = new ArrayList<TsysRightRef>();
		for(Integer roleId : preAddRoleIds){
			TsysRightRef tsysRoleUser = new TsysRightRef();
			tsysRoleUser.setUserCode(userCode);
			tsysRoleUser.setRoleId(roleId);
			tsysRoleUser.setRightFlag("1");//权限表示,1:操作,2:授权
			list.add(tsysRoleUser);
		}
		return batchInsert(list);
	}

	public int revokeRoles(String userCode, Integer[] preRemoveRoleIds) {
		final Integer[] removeRoleCpIds = preRemoveRoleIds;
		final String userCodeCp = userCode;
		return getDslTemplate().delete(new NoParamDeleteGenerateCallback(){
			public Delete generate() {
				return Delete.delete(TSYS_ROLE_USER_TABLE).where(
						and(TSYS_ROLE_USER_TABLE.USER_CODE.eq(userCodeCp)
						,TSYS_ROLE_USER_TABLE.ROLE_ID.in(removeRoleCpIds)));
			}
		});
	}

	public Pager<RoleUserRef> queryRolesInUser(int start, int limit, final String userCode, RoleUserRef roleUserRef, Boolean isAssign,
											final Integer assignFlag, final OrderBy... orderArgs) {
		if (roleUserRef == null) {
			roleUserRef = new RoleUserRef();
		}
		final Condition subCondition;
		if (isAssign.booleanValue()) {//取消分配
//			subCondition = TSYS_ROLE_TABLE.ROLE_CODE.inExpression(
//					subSelect(select(TSYS_ROLE_USER_TABLE.ROLE_CODE)
//							.from(TSYS_ROLE_USER_TABLE).where(and(
//									TSYS_ROLE_USER_TABLE.USER_CODE.eq(userCode),
//									TSYS_ROLE_USER_TABLE.RIGHT_FLAG.eq(assignFlag)
//									)))
//			);
			return getDslTemplate().queryPager(start, limit, roleUserRef, false,
					new SelectGenerateCallback<RoleUserRef>() {
				public Select generate(RoleUserRef t) {
					Select select = select(TSYS_ROLE_USER_TABLE.RIGHT_FLAG,TSYS_ROLE_TABLE.ALL)
							.from(TSYS_ROLE_USER_TABLE,TSYS_ROLE_TABLE)
							.where(and(
										TSYS_ROLE_USER_TABLE.ROLE_ID.eq(TSYS_ROLE_TABLE.ROLE_ID),
										TSYS_ROLE_USER_TABLE.USER_CODE.eq(userCode),
										TSYS_ROLE_TABLE.ROLE_CODE.like(t.getRoleCode()),
										TSYS_ROLE_USER_TABLE.RIGHT_FLAG.like(t.getRightFlag()),
										TSYS_ROLE_TABLE.ROLE_NAME.like(t.getRoleName()),
										TSYS_ROLE_TABLE.REMARK.like(t.getRemark())
									));
					return TinyDSLUtil
							.addOrderByElements(select, orderArgs);
				}
			});

			
		} else {//分配
			subCondition = TSYS_ROLE_TABLE.ROLE_ID.notInExpression(
					subSelect(select(TSYS_ROLE_USER_TABLE.ROLE_ID)
							.from(TSYS_ROLE_USER_TABLE).where(and(
									TSYS_ROLE_USER_TABLE.USER_CODE.eq(userCode),
									TSYS_ROLE_USER_TABLE.RIGHT_FLAG.eq(assignFlag)
							)))
			);
			return getDslTemplate().queryPager(start, limit, roleUserRef, false,
					new SelectGenerateCallback<RoleUserRef>() {
				public Select generate(RoleUserRef t) {
					Select select = Select
							.selectFrom(TSYS_ROLE_TABLE)
							.where(and(
									subCondition,
									TSYS_ROLE_TABLE.ROLE_CODE.like(t
											.getRoleCode()),
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
	}
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys,
									 List<TsysRightRef> tsysRightRefs) {
		if (CollectionUtil.isEmpty(tsysRightRefs)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysRightRefs,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_ROLE_USER_TABLE).values(
								TSYS_ROLE_USER_TABLE.USER_CODE
										.value(new JdbcNamedParameter(
												"userCode")),
								TSYS_ROLE_USER_TABLE.ROLE_CODE
										.value(new JdbcNamedParameter(
												"roleCode")),
								TSYS_ROLE_USER_TABLE.RIGHT_FLAG
										.value(new JdbcNamedParameter(
												"rightFlag"))

						);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TsysRightRef> tsysRightRefs) {
		if (CollectionUtil.isEmpty(tsysRightRefs)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysRightRefs,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_ROLE_USER_TABLE).set(
								TSYS_ROLE_USER_TABLE.USER_CODE
										.value(new JdbcNamedParameter(
												"userCode")),
								TSYS_ROLE_USER_TABLE.ROLE_CODE
										.value(new JdbcNamedParameter(
												"roleCode")),
								TSYS_ROLE_USER_TABLE.RIGHT_FLAG
										.value(new JdbcNamedParameter(
												"rightFlag"))

						).where(TSYS_ROLE_USER_TABLE.ID
								.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TsysRightRef> tsysRightRef) {
		if (CollectionUtil.isEmpty(tsysRightRef)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysRightRef,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_ROLE_USER_TABLE)
								.where(and(
										TSYS_ROLE_USER_TABLE.USER_CODE
												.eq(new JdbcNamedParameter(
														"userCode")),
										TSYS_ROLE_USER_TABLE.ROLE_CODE
												.eq(new JdbcNamedParameter(
														"roleCode")),
										TSYS_ROLE_USER_TABLE.RIGHT_FLAG
												.eq(new JdbcNamedParameter(
														"rightFlag"))

								));
					}
				});
	}

	public int[] preparedBatchInsert(List<TsysRightRef> tsysRightRefs) {
		return preparedBatchInsert(true, tsysRightRefs);
	}
}
