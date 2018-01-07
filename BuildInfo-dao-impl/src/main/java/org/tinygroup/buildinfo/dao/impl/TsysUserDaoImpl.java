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

import static org.tinygroup.buildinfo.dao.inter.constant.TsysBranchTable.TSYS_BRANCH_TABLE;
import static org.tinygroup.buildinfo.dao.inter.constant.TsysMenuTable.TSYS_MENU_TABLE;
import static org.tinygroup.buildinfo.dao.inter.constant.TsysRoleUserTable.TSYS_ROLE_USER_TABLE;
import static org.tinygroup.buildinfo.dao.inter.constant.TsysRoleRightTable.TSYS_ROLE_RIGHT_TABLE;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;
import static org.tinygroup.buildinfo.dao.inter.constant.TsysUserTable.*;
import static org.tinygroup.tinysqldsl.Select.*;
import static org.tinygroup.tinysqldsl.Insert.*;
import static org.tinygroup.tinysqldsl.Delete.*;
import static org.tinygroup.tinysqldsl.Update.*;

import java.io.Serializable;
import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.complex.TsysUserAllInfo;
import org.tinygroup.tinysqldsl.Delete;
import org.tinygroup.tinysqldsl.Insert;
import org.tinygroup.tinysqldsl.Select;
import org.tinygroup.tinysqldsl.Update;
import org.tinygroup.tinysqldsl.Pager;
import org.tinygroup.commons.tools.CollectionUtil;
import org.tinygroup.tinysqldsl.expression.JdbcNamedParameter;
import org.tinygroup.tinysqldsl.select.Join;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysUser;
import org.tinygroup.buildinfo.dao.inter.TsysUserDao;
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
public class TsysUserDaoImpl extends TinyDslDaoSupport implements TsysUserDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysUser add(TsysUser tsysUser) {
		return getDslTemplate().insertAndReturnKey(tsysUser,
				new InsertGenerateCallback<TsysUser>() {
					public Insert generate(TsysUser t) {
						Insert insert = insertInto(TSYS_USER_TABLE)
								.values(TSYS_USER_TABLE.USER_ID.value(t
										.getUserId()),
										TSYS_USER_TABLE.BRANCH_CODE.value(t
												.getBranchCode()),
										TSYS_USER_TABLE.DEP_CODE.value(t
												.getDepCode()),
										TSYS_USER_TABLE.USER_NAME.value(t
												.getUserName()),
										TSYS_USER_TABLE.USER_PWD.value(t
												.getUserPwd()),
										TSYS_USER_TABLE.USER_TYPE.value(t
												.getUserType()),
										TSYS_USER_TABLE.USER_LEVEL.value(t
												.getUserLevel()),
										TSYS_USER_TABLE.USER_STATUS.value(t
												.getUserStatus()),
										TSYS_USER_TABLE.LOCK_STATUS.value(t
												.getLockStatus()),
										TSYS_USER_TABLE.CREATOR.value(t
												.getCreator()),
										TSYS_USER_TABLE.CREATE_DATE.value(t
												.getCreateDate()),
										TSYS_USER_TABLE.MODIFY_DATE.value(t
												.getModifyDate()),
										TSYS_USER_TABLE.PASS_MODIFY_DATE
												.value(t.getPassModifyDate()),
										TSYS_USER_TABLE.AUTH_LEVEL.value(t
												.getAuthLevel()),
										TSYS_USER_TABLE.HOME_PAGE.value(t
												.getHomePage()),
										TSYS_USER_TABLE.REMARK.value(t
												.getRemark()),
										TSYS_USER_TABLE.EXT_FIELD_1.value(t
												.getExtField1()),
										TSYS_USER_TABLE.EXT_FIELD_2.value(t
												.getExtField2()),
										TSYS_USER_TABLE.EXT_FIELD_4.value(t
												.getExtField4()),
										TSYS_USER_TABLE.EXT_FIELD_5.value(t
												.getExtField5()),
										TSYS_USER_TABLE.EXT_FIELD_3.value(t
												.getExtField3())

								);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TsysUser tsysUser) {
		if (tsysUser == null || tsysUser.getUserId() == null) {
			return 0;
		}
		return getDslTemplate().update(tsysUser,
				new UpdateGenerateCallback<TsysUser>() {
					public Update generate(TsysUser t) {
						Update update = update(TSYS_USER_TABLE)
								.set(TSYS_USER_TABLE.BRANCH_CODE.value(t
										.getBranchCode()),
										TSYS_USER_TABLE.DEP_CODE.value(t
												.getDepCode()),
										TSYS_USER_TABLE.USER_NAME.value(t
												.getUserName()),
										TSYS_USER_TABLE.USER_PWD.value(t
												.getUserPwd()),
										TSYS_USER_TABLE.USER_TYPE.value(t
												.getUserType()),
										TSYS_USER_TABLE.USER_LEVEL.value(t
												.getUserLevel()),
										TSYS_USER_TABLE.USER_STATUS.value(t
												.getUserStatus()),
										TSYS_USER_TABLE.LOCK_STATUS.value(t
												.getLockStatus()),
										TSYS_USER_TABLE.CREATOR.value(t
												.getCreator()),
										TSYS_USER_TABLE.CREATE_DATE.value(t
												.getCreateDate()),
										TSYS_USER_TABLE.MODIFY_DATE.value(t
												.getModifyDate()),
										TSYS_USER_TABLE.PASS_MODIFY_DATE
												.value(t.getPassModifyDate()),
										TSYS_USER_TABLE.AUTH_LEVEL.value(t
												.getAuthLevel()),
										TSYS_USER_TABLE.HOME_PAGE.value(t
												.getHomePage()),
										TSYS_USER_TABLE.REMARK.value(t
												.getRemark()),
										TSYS_USER_TABLE.EXT_FIELD_1.value(t
												.getExtField1()),
										TSYS_USER_TABLE.EXT_FIELD_2.value(t
												.getExtField2()),
										TSYS_USER_TABLE.EXT_FIELD_4.value(t
												.getExtField4()),
										TSYS_USER_TABLE.EXT_FIELD_5.value(t
												.getExtField5()),
										TSYS_USER_TABLE.EXT_FIELD_3.value(t
												.getExtField3())).where(
										TSYS_USER_TABLE.USER_ID.eq(t
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
						return delete(TSYS_USER_TABLE).where(
								TSYS_USER_TABLE.USER_ID.eq(pk));
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
						return delete(TSYS_USER_TABLE).where(
								TSYS_USER_TABLE.USER_ID.in(t));
					}
				}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysUser getByKey(String pk) {
		return getDslTemplate().getByKey(pk, TsysUser.class,
				new SelectGenerateCallback<Serializable>() {

					@SuppressWarnings("rawtypes")
					public Select generate(Serializable t) {
						return selectFrom(TSYS_USER_TABLE).where(
								TSYS_USER_TABLE.USER_ID.eq(t));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TsysUser> query(TsysUser tsysUser, final OrderBy... orderArgs) {
		if (tsysUser == null) {
			tsysUser = new TsysUser();
		}
		return getDslTemplate().query(tsysUser,
				new SelectGenerateCallback<TsysUser>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysUser t) {
						Select select = selectFrom(TSYS_USER_TABLE)
								.where(and(
										TSYS_USER_TABLE.USER_ID.eq(t.getUserId()),
										TSYS_USER_TABLE.BRANCH_CODE.eq(t
												.getBranchCode()),
										TSYS_USER_TABLE.DEP_CODE.eq(t
												.getDepCode()),
										TSYS_USER_TABLE.USER_NAME.eq(t
												.getUserName()),
										TSYS_USER_TABLE.USER_PWD.eq(t
												.getUserPwd()),
										TSYS_USER_TABLE.USER_TYPE.eq(t
												.getUserType()),
										TSYS_USER_TABLE.USER_LEVEL.eq(t
												.getUserLevel()),
										TSYS_USER_TABLE.USER_STATUS.eq(t
												.getUserStatus()),
										TSYS_USER_TABLE.LOCK_STATUS.eq(t
												.getLockStatus()),
										TSYS_USER_TABLE.CREATOR.eq(t
												.getCreator()),
										TSYS_USER_TABLE.CREATE_DATE.eq(t
												.getCreateDate()),
										TSYS_USER_TABLE.MODIFY_DATE.eq(t
												.getModifyDate()),
										TSYS_USER_TABLE.PASS_MODIFY_DATE.eq(t
												.getPassModifyDate()),
										TSYS_USER_TABLE.AUTH_LEVEL.eq(t
												.getAuthLevel()),
										TSYS_USER_TABLE.HOME_PAGE.eq(t
												.getHomePage()),
										TSYS_USER_TABLE.REMARK.eq(t.getRemark()),
										TSYS_USER_TABLE.EXT_FIELD_1.eq(t
												.getExtField1()),
										TSYS_USER_TABLE.EXT_FIELD_2.eq(t
												.getExtField2()),
										TSYS_USER_TABLE.EXT_FIELD_4.eq(t
												.getExtField4()),
										TSYS_USER_TABLE.EXT_FIELD_5.eq(t
												.getExtField5()),
										TSYS_USER_TABLE.EXT_FIELD_3.eq(t
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
	public Pager<TsysUser> queryPager(int start, int limit, TsysUser tsysUser,
			final OrderBy... orderArgs) {
		if (tsysUser == null) {
			tsysUser = new TsysUser();
		}
		return getDslTemplate().queryPager(start, limit, tsysUser, false,
				new SelectGenerateCallback<TsysUser>() {
					public Select generate(TsysUser t) {
						Select select = Select
								.selectFrom(TSYS_USER_TABLE)
								.where(and(
										TSYS_USER_TABLE.BRANCH_CODE.eq(t
												.getBranchCode()),
										TSYS_USER_TABLE.DEP_CODE.eq(t
												.getDepCode()),
										TSYS_USER_TABLE.USER_NAME.eq(t
												.getUserName()),
										TSYS_USER_TABLE.USER_PWD.eq(t
												.getUserPwd()),
										TSYS_USER_TABLE.USER_TYPE.eq(t
												.getUserType()),
										TSYS_USER_TABLE.USER_LEVEL.eq(t
												.getUserLevel()),
										TSYS_USER_TABLE.USER_STATUS.eq(t
												.getUserStatus()),
										TSYS_USER_TABLE.LOCK_STATUS.eq(t
												.getLockStatus()),
										TSYS_USER_TABLE.CREATOR.eq(t
												.getCreator()),
										TSYS_USER_TABLE.CREATE_DATE.eq(t
												.getCreateDate()),
										TSYS_USER_TABLE.MODIFY_DATE.eq(t
												.getModifyDate()),
										TSYS_USER_TABLE.PASS_MODIFY_DATE.eq(t
												.getPassModifyDate()),
										TSYS_USER_TABLE.AUTH_LEVEL.eq(t
												.getAuthLevel()),
										TSYS_USER_TABLE.HOME_PAGE.eq(t
												.getHomePage()),
										TSYS_USER_TABLE.REMARK.eq(t.getRemark()),
										TSYS_USER_TABLE.EXT_FIELD_1.eq(t
												.getExtField1()),
										TSYS_USER_TABLE.EXT_FIELD_2.eq(t
												.getExtField2()),
										TSYS_USER_TABLE.EXT_FIELD_4.eq(t
												.getExtField4()),
										TSYS_USER_TABLE.EXT_FIELD_5.eq(t
												.getExtField5()),
										TSYS_USER_TABLE.EXT_FIELD_3.eq(t
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
	public int[] batchInsert(boolean autoGeneratedKeys, List<TsysUser> tsysUser) {
		if (CollectionUtil.isEmpty(tsysUser)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysUser,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_USER_TABLE)
								.values(TSYS_USER_TABLE.BRANCH_CODE
										.value(new JdbcNamedParameter(
												"branchCode")),
										TSYS_USER_TABLE.DEP_CODE
												.value(new JdbcNamedParameter(
														"depCode")),
										TSYS_USER_TABLE.USER_NAME
												.value(new JdbcNamedParameter(
														"userName")),
										TSYS_USER_TABLE.USER_PWD
												.value(new JdbcNamedParameter(
														"userPwd")),
										TSYS_USER_TABLE.USER_TYPE
												.value(new JdbcNamedParameter(
														"userType")),
										TSYS_USER_TABLE.USER_LEVEL
												.value(new JdbcNamedParameter(
														"userLevel")),
										TSYS_USER_TABLE.USER_STATUS
												.value(new JdbcNamedParameter(
														"userStatus")),
										TSYS_USER_TABLE.LOCK_STATUS
												.value(new JdbcNamedParameter(
														"lockStatus")),
										TSYS_USER_TABLE.CREATOR
												.value(new JdbcNamedParameter(
														"creator")),
										TSYS_USER_TABLE.CREATE_DATE
												.value(new JdbcNamedParameter(
														"createDate")),
										TSYS_USER_TABLE.MODIFY_DATE
												.value(new JdbcNamedParameter(
														"modifyDate")),
										TSYS_USER_TABLE.PASS_MODIFY_DATE
												.value(new JdbcNamedParameter(
														"passModifyDate")),
										TSYS_USER_TABLE.AUTH_LEVEL
												.value(new JdbcNamedParameter(
														"authLevel")),
										TSYS_USER_TABLE.HOME_PAGE
												.value(new JdbcNamedParameter(
														"homePage")),
										TSYS_USER_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark")),
										TSYS_USER_TABLE.EXT_FIELD_1
												.value(new JdbcNamedParameter(
														"extField1")),
										TSYS_USER_TABLE.EXT_FIELD_2
												.value(new JdbcNamedParameter(
														"extField2")),
										TSYS_USER_TABLE.EXT_FIELD_4
												.value(new JdbcNamedParameter(
														"extField4")),
										TSYS_USER_TABLE.EXT_FIELD_5
												.value(new JdbcNamedParameter(
														"extField5")),
										TSYS_USER_TABLE.EXT_FIELD_3
												.value(new JdbcNamedParameter(
														"extField3"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TsysUser> tsysUsers) {
		return batchInsert(true, tsysUsers);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TsysUser> tsysUser) {
		if (CollectionUtil.isEmpty(tsysUser)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysUser,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_USER_TABLE)
								.set(TSYS_USER_TABLE.BRANCH_CODE
										.value(new JdbcNamedParameter(
												"branchCode")),
										TSYS_USER_TABLE.DEP_CODE
												.value(new JdbcNamedParameter(
														"depCode")),
										TSYS_USER_TABLE.USER_NAME
												.value(new JdbcNamedParameter(
														"userName")),
										TSYS_USER_TABLE.USER_PWD
												.value(new JdbcNamedParameter(
														"userPwd")),
										TSYS_USER_TABLE.USER_TYPE
												.value(new JdbcNamedParameter(
														"userType")),
										TSYS_USER_TABLE.USER_LEVEL
												.value(new JdbcNamedParameter(
														"userLevel")),
										TSYS_USER_TABLE.USER_STATUS
												.value(new JdbcNamedParameter(
														"userStatus")),
										TSYS_USER_TABLE.LOCK_STATUS
												.value(new JdbcNamedParameter(
														"lockStatus")),
										TSYS_USER_TABLE.CREATOR
												.value(new JdbcNamedParameter(
														"creator")),
										TSYS_USER_TABLE.CREATE_DATE
												.value(new JdbcNamedParameter(
														"createDate")),
										TSYS_USER_TABLE.MODIFY_DATE
												.value(new JdbcNamedParameter(
														"modifyDate")),
										TSYS_USER_TABLE.PASS_MODIFY_DATE
												.value(new JdbcNamedParameter(
														"passModifyDate")),
										TSYS_USER_TABLE.AUTH_LEVEL
												.value(new JdbcNamedParameter(
														"authLevel")),
										TSYS_USER_TABLE.HOME_PAGE
												.value(new JdbcNamedParameter(
														"homePage")),
										TSYS_USER_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark")),
										TSYS_USER_TABLE.EXT_FIELD_1
												.value(new JdbcNamedParameter(
														"extField1")),
										TSYS_USER_TABLE.EXT_FIELD_2
												.value(new JdbcNamedParameter(
														"extField2")),
										TSYS_USER_TABLE.EXT_FIELD_4
												.value(new JdbcNamedParameter(
														"extField4")),
										TSYS_USER_TABLE.EXT_FIELD_5
												.value(new JdbcNamedParameter(
														"extField5")),
										TSYS_USER_TABLE.EXT_FIELD_3
												.value(new JdbcNamedParameter(
														"extField3"))

								).where(TSYS_USER_TABLE.USER_ID
										.eq(new JdbcNamedParameter("userId")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TsysUser> tsysUser) {
		if (CollectionUtil.isEmpty(tsysUser)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysUser,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_USER_TABLE)
								.where(and(
										TSYS_USER_TABLE.BRANCH_CODE
												.eq(new JdbcNamedParameter(
														"branchCode")),
										TSYS_USER_TABLE.DEP_CODE
												.eq(new JdbcNamedParameter(
														"depCode")),
										TSYS_USER_TABLE.USER_NAME
												.eq(new JdbcNamedParameter(
														"userName")),
										TSYS_USER_TABLE.USER_PWD
												.eq(new JdbcNamedParameter(
														"userPwd")),
										TSYS_USER_TABLE.USER_TYPE
												.eq(new JdbcNamedParameter(
														"userType")),
										TSYS_USER_TABLE.USER_LEVEL
												.eq(new JdbcNamedParameter(
														"userLevel")),
										TSYS_USER_TABLE.USER_STATUS
												.eq(new JdbcNamedParameter(
														"userStatus")),
										TSYS_USER_TABLE.LOCK_STATUS
												.eq(new JdbcNamedParameter(
														"lockStatus")),
										TSYS_USER_TABLE.CREATOR
												.eq(new JdbcNamedParameter(
														"creator")),
										TSYS_USER_TABLE.CREATE_DATE
												.eq(new JdbcNamedParameter(
														"createDate")),
										TSYS_USER_TABLE.MODIFY_DATE
												.eq(new JdbcNamedParameter(
														"modifyDate")),
										TSYS_USER_TABLE.PASS_MODIFY_DATE
												.eq(new JdbcNamedParameter(
														"passModifyDate")),
										TSYS_USER_TABLE.AUTH_LEVEL
												.eq(new JdbcNamedParameter(
														"authLevel")),
										TSYS_USER_TABLE.HOME_PAGE
												.eq(new JdbcNamedParameter(
														"homePage")),
										TSYS_USER_TABLE.REMARK
												.eq(new JdbcNamedParameter(
														"remark")),
										TSYS_USER_TABLE.EXT_FIELD_1
												.eq(new JdbcNamedParameter(
														"extField1")),
										TSYS_USER_TABLE.EXT_FIELD_2
												.eq(new JdbcNamedParameter(
														"extField2")),
										TSYS_USER_TABLE.EXT_FIELD_4
												.eq(new JdbcNamedParameter(
														"extField4")),
										TSYS_USER_TABLE.EXT_FIELD_5
												.eq(new JdbcNamedParameter(
														"extField5")),
										TSYS_USER_TABLE.EXT_FIELD_3
												.eq(new JdbcNamedParameter(
														"extField3"))

								));
					}
				});
	}

	public Pager queryAllInfoPager(int start, int pageSize, TsysUser tsysUser,final OrderBy... orderArgs) {
		if (tsysUser == null) {
			tsysUser = new TsysUser();
		}
		TsysUserAllInfo tsysUserAllInfo = new TsysUserAllInfo();
		final TsysUser finalTsysUser = tsysUser;
		return getDslTemplate().queryPager(start, pageSize, tsysUserAllInfo, false,
				new SelectGenerateCallback<TsysUser>() {
					public Select generate(TsysUser t) {
						Select select = Select
								.select(TSYS_USER_TABLE.ALL,TSYS_BRANCH_TABLE.BRANCH_NAME).from(TSYS_USER_TABLE)
								.join(Join.leftJoin(
										TSYS_BRANCH_TABLE,TSYS_BRANCH_TABLE.BRANCH_CODE
												.eq(TSYS_USER_TABLE.BRANCH_CODE)
								))
								.where(and(
										TSYS_USER_TABLE.USER_ID.like(finalTsysUser
												.getUserId()),
										TSYS_USER_TABLE.BRANCH_CODE.like(finalTsysUser
												.getBranchCode()),
										TSYS_USER_TABLE.DEP_CODE.like(finalTsysUser
												.getDepCode()),
										TSYS_USER_TABLE.USER_NAME.like(finalTsysUser
												.getUserName()),
										TSYS_USER_TABLE.USER_PWD.like(finalTsysUser
												.getUserPwd()),
										TSYS_USER_TABLE.USER_TYPE.like(finalTsysUser
												.getUserType()),
										TSYS_USER_TABLE.USER_LEVEL.like(finalTsysUser
												.getUserLevel()),
										TSYS_USER_TABLE.USER_STATUS.like(finalTsysUser
												.getUserStatus()),
										TSYS_USER_TABLE.LOCK_STATUS.like(finalTsysUser
												.getLockStatus()),
										TSYS_USER_TABLE.CREATOR.like(finalTsysUser
												.getCreator()),
/*										TSYS_USER_TABLE.CREATE_DATE.like(t
												.getCreateDate()),
										TSYS_USER_TABLE.MODIFY_DATE.like(t
												.getModifyDate()),
										TSYS_USER_TABLE.PASS_MODIFY_DATE.like(t
												.getPassModifyDate()),*/
										TSYS_USER_TABLE.AUTH_LEVEL.like(finalTsysUser
												.getAuthLevel()),
										TSYS_USER_TABLE.HOME_PAGE.like(finalTsysUser
												.getHomePage()),
										TSYS_USER_TABLE.REMARK.like(t.getRemark()),
										TSYS_USER_TABLE.EXT_FIELD_1.like(finalTsysUser
												.getExtField1()),
										TSYS_USER_TABLE.EXT_FIELD_2.like(finalTsysUser
												.getExtField2()),
										TSYS_USER_TABLE.EXT_FIELD_4.like(finalTsysUser
												.getExtField4()),
										TSYS_USER_TABLE.EXT_FIELD_5.like(finalTsysUser
												.getExtField5()),
										TSYS_USER_TABLE.EXT_FIELD_3.like(finalTsysUser
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
	public int updateLockStatusByKeys(String[] pks,String lockStatus) {
		if (pks == null || pks.length == 0) {
			return 0;
		}
		Update update = update(TSYS_USER_TABLE)
				.set(TSYS_USER_TABLE.LOCK_STATUS.value(lockStatus))
				.where(TSYS_USER_TABLE.USER_ID.in(pks));
		return getDslSession().execute(update);
		
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TsysUser> searchPager(int start, int limit, TsysUser tsysUser,
									  final OrderBy... orderArgs) {
		if (tsysUser == null) {
			tsysUser = new TsysUser();
		}
		return getDslTemplate().queryPager(start, limit, tsysUser, false,
				new SelectGenerateCallback<TsysUser>() {
					public Select generate(TsysUser t) {
						Select select = Select
								.selectFrom(TSYS_USER_TABLE)
								.where(and(
										TSYS_USER_TABLE.BRANCH_CODE.like(t
												.getBranchCode()),
										TSYS_USER_TABLE.DEP_CODE.like(t
												.getDepCode()),
										TSYS_USER_TABLE.USER_NAME.like(t
												.getUserName()),
										TSYS_USER_TABLE.USER_PWD.like(t
												.getUserPwd()),
										TSYS_USER_TABLE.USER_TYPE.like(t
												.getUserType()),
										TSYS_USER_TABLE.USER_LEVEL.like(t
												.getUserLevel()),
										TSYS_USER_TABLE.USER_STATUS.like(t
												.getUserStatus()),
										TSYS_USER_TABLE.LOCK_STATUS.like(t
												.getLockStatus()),
										TSYS_USER_TABLE.CREATOR.like(t
												.getCreator()),
										TSYS_USER_TABLE.CREATE_DATE.eq(t
												.getCreateDate()),
										TSYS_USER_TABLE.MODIFY_DATE.eq(t
												.getModifyDate()),
										TSYS_USER_TABLE.PASS_MODIFY_DATE.eq(t
												.getPassModifyDate()),
										TSYS_USER_TABLE.AUTH_LEVEL.eq(t
												.getAuthLevel()),
										TSYS_USER_TABLE.HOME_PAGE.like(t
												.getHomePage()),
										TSYS_USER_TABLE.REMARK.like(t.getRemark()),
										TSYS_USER_TABLE.EXT_FIELD_1.like(t
												.getExtField1()),
										TSYS_USER_TABLE.EXT_FIELD_2.like(t
												.getExtField2()),
										TSYS_USER_TABLE.EXT_FIELD_4.like(t
												.getExtField4()),
										TSYS_USER_TABLE.EXT_FIELD_5.like(t
												.getExtField5()),
										TSYS_USER_TABLE.EXT_FIELD_3.like(t
												.getExtField3())

								));
						return TinyDSLUtil
								.addOrderByElements(select, orderArgs);
					}
				});
	}

	public int updatePwd(final String defaultPwd, final String... userIds) {
		TsysUser tsysUser = new TsysUser();
		return getDslTemplate().update(tsysUser,
				new UpdateGenerateCallback<TsysUser>() {
					public Update generate(TsysUser t) {
						Update update = update(TSYS_USER_TABLE)
								.set(
										TSYS_USER_TABLE.USER_PWD.value(defaultPwd)
										).where(
										TSYS_USER_TABLE.USER_ID.in(userIds));
						return update;
					}
				});
	}

	/**
	 * 根据user_id 获取信息
	 *
	 * @param tsysUser
	 * @return
	 */
	public List checkExist(TsysUser tsysUser) {
		if (tsysUser == null) {
			tsysUser = new TsysUser();
		}
		return getDslTemplate().query(tsysUser,
				new SelectGenerateCallback<TsysUser>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysUser t) {
						Select select = selectFrom(TSYS_USER_TABLE)
								.where(and(
										TSYS_USER_TABLE.USER_ID.eq(t.getUserId())
								));
						return select;
					}
				});
	}

	public boolean validate(String userName, String password) {
		List users = getDslSession().fetchList(select(TSYS_USER_TABLE.USER_ID).from(TSYS_USER_TABLE)
								.where(and(
										TSYS_USER_TABLE.USER_ID.eq(userName),
										TSYS_USER_TABLE.USER_PWD.eq(password)
								)),String.class
				);
		return (users.size()>0)?true:false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys,
									 List<TsysUser> tsysUser) {
		if (CollectionUtil.isEmpty(tsysUser)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysUser,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_USER_TABLE)
								.values(TSYS_USER_TABLE.BRANCH_CODE
												.value(new JdbcNamedParameter(
														"branchCode")),
										TSYS_USER_TABLE.DEP_CODE
												.value(new JdbcNamedParameter(
														"depCode")),
										TSYS_USER_TABLE.USER_NAME
												.value(new JdbcNamedParameter(
														"userName")),
										TSYS_USER_TABLE.USER_PWD
												.value(new JdbcNamedParameter(
														"userPwd")),
										TSYS_USER_TABLE.USER_TYPE
												.value(new JdbcNamedParameter(
														"userType")),
										TSYS_USER_TABLE.USER_LEVEL
												.value(new JdbcNamedParameter(
														"userLevel")),
										TSYS_USER_TABLE.USER_STATUS
												.value(new JdbcNamedParameter(
														"userStatus")),
										TSYS_USER_TABLE.LOCK_STATUS
												.value(new JdbcNamedParameter(
														"lockStatus")),
										TSYS_USER_TABLE.CREATOR
												.value(new JdbcNamedParameter(
														"creator")),
										TSYS_USER_TABLE.CREATE_DATE
												.value(new JdbcNamedParameter(
														"createDate")),
										TSYS_USER_TABLE.MODIFY_DATE
												.value(new JdbcNamedParameter(
														"modifyDate")),
										TSYS_USER_TABLE.PASS_MODIFY_DATE
												.value(new JdbcNamedParameter(
														"passModifyDate")),
										TSYS_USER_TABLE.AUTH_LEVEL
												.value(new JdbcNamedParameter(
														"authLevel")),
										TSYS_USER_TABLE.HOME_PAGE
												.value(new JdbcNamedParameter(
														"homePage")),
										TSYS_USER_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark")),
										TSYS_USER_TABLE.EXT_FIELD_1
												.value(new JdbcNamedParameter(
														"extField1")),
										TSYS_USER_TABLE.EXT_FIELD_2
												.value(new JdbcNamedParameter(
														"extField2")),
										TSYS_USER_TABLE.EXT_FIELD_4
												.value(new JdbcNamedParameter(
														"extField4")),
										TSYS_USER_TABLE.EXT_FIELD_5
												.value(new JdbcNamedParameter(
														"extField5")),
										TSYS_USER_TABLE.EXT_FIELD_3
												.value(new JdbcNamedParameter(
														"extField3"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TsysUser> tsysUser) {
		if (CollectionUtil.isEmpty(tsysUser)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysUser,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_USER_TABLE)
								.set(TSYS_USER_TABLE.BRANCH_CODE
												.value(new JdbcNamedParameter(
														"branchCode")),
										TSYS_USER_TABLE.DEP_CODE
												.value(new JdbcNamedParameter(
														"depCode")),
										TSYS_USER_TABLE.USER_NAME
												.value(new JdbcNamedParameter(
														"userName")),
										TSYS_USER_TABLE.USER_PWD
												.value(new JdbcNamedParameter(
														"userPwd")),
										TSYS_USER_TABLE.USER_TYPE
												.value(new JdbcNamedParameter(
														"userType")),
										TSYS_USER_TABLE.USER_LEVEL
												.value(new JdbcNamedParameter(
														"userLevel")),
										TSYS_USER_TABLE.USER_STATUS
												.value(new JdbcNamedParameter(
														"userStatus")),
										TSYS_USER_TABLE.LOCK_STATUS
												.value(new JdbcNamedParameter(
														"lockStatus")),
										TSYS_USER_TABLE.CREATOR
												.value(new JdbcNamedParameter(
														"creator")),
										TSYS_USER_TABLE.CREATE_DATE
												.value(new JdbcNamedParameter(
														"createDate")),
										TSYS_USER_TABLE.MODIFY_DATE
												.value(new JdbcNamedParameter(
														"modifyDate")),
										TSYS_USER_TABLE.PASS_MODIFY_DATE
												.value(new JdbcNamedParameter(
														"passModifyDate")),
										TSYS_USER_TABLE.AUTH_LEVEL
												.value(new JdbcNamedParameter(
														"authLevel")),
										TSYS_USER_TABLE.HOME_PAGE
												.value(new JdbcNamedParameter(
														"homePage")),
										TSYS_USER_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark")),
										TSYS_USER_TABLE.EXT_FIELD_1
												.value(new JdbcNamedParameter(
														"extField1")),
										TSYS_USER_TABLE.EXT_FIELD_2
												.value(new JdbcNamedParameter(
														"extField2")),
										TSYS_USER_TABLE.EXT_FIELD_4
												.value(new JdbcNamedParameter(
														"extField4")),
										TSYS_USER_TABLE.EXT_FIELD_5
												.value(new JdbcNamedParameter(
														"extField5")),
										TSYS_USER_TABLE.EXT_FIELD_3
												.value(new JdbcNamedParameter(
														"extField3"))

								).where(TSYS_USER_TABLE.USER_ID
										.eq(new JdbcNamedParameter("userId")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TsysUser> tsysUser) {
		if (CollectionUtil.isEmpty(tsysUser)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysUser,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_USER_TABLE)
								.where(and(
										TSYS_USER_TABLE.BRANCH_CODE
												.eq(new JdbcNamedParameter(
														"branchCode")),
										TSYS_USER_TABLE.DEP_CODE
												.eq(new JdbcNamedParameter(
														"depCode")),
										TSYS_USER_TABLE.USER_NAME
												.eq(new JdbcNamedParameter(
														"userName")),
										TSYS_USER_TABLE.USER_PWD
												.eq(new JdbcNamedParameter(
														"userPwd")),
										TSYS_USER_TABLE.USER_TYPE
												.eq(new JdbcNamedParameter(
														"userType")),
										TSYS_USER_TABLE.USER_LEVEL
												.eq(new JdbcNamedParameter(
														"userLevel")),
										TSYS_USER_TABLE.USER_STATUS
												.eq(new JdbcNamedParameter(
														"userStatus")),
										TSYS_USER_TABLE.LOCK_STATUS
												.eq(new JdbcNamedParameter(
														"lockStatus")),
										TSYS_USER_TABLE.CREATOR
												.eq(new JdbcNamedParameter(
														"creator")),
										TSYS_USER_TABLE.CREATE_DATE
												.eq(new JdbcNamedParameter(
														"createDate")),
										TSYS_USER_TABLE.MODIFY_DATE
												.eq(new JdbcNamedParameter(
														"modifyDate")),
										TSYS_USER_TABLE.PASS_MODIFY_DATE
												.eq(new JdbcNamedParameter(
														"passModifyDate")),
										TSYS_USER_TABLE.AUTH_LEVEL
												.eq(new JdbcNamedParameter(
														"authLevel")),
										TSYS_USER_TABLE.HOME_PAGE
												.eq(new JdbcNamedParameter(
														"homePage")),
										TSYS_USER_TABLE.REMARK
												.eq(new JdbcNamedParameter(
														"remark")),
										TSYS_USER_TABLE.EXT_FIELD_1
												.eq(new JdbcNamedParameter(
														"extField1")),
										TSYS_USER_TABLE.EXT_FIELD_2
												.eq(new JdbcNamedParameter(
														"extField2")),
										TSYS_USER_TABLE.EXT_FIELD_4
												.eq(new JdbcNamedParameter(
														"extField4")),
										TSYS_USER_TABLE.EXT_FIELD_5
												.eq(new JdbcNamedParameter(
														"extField5")),
										TSYS_USER_TABLE.EXT_FIELD_3
												.eq(new JdbcNamedParameter(
														"extField3"))

								));
					}
				});
	}

	public int[] preparedBatchInsert(List<TsysUser> tsysUser) {
		return preparedBatchInsert(false, tsysUser);
	}

	@Override
	public List<TsysUser> getUserByIds(String... userIds) {
		SelectGenerateCallback<Serializable[]> callback = new SelectGenerateCallback<Serializable[]>() {

            public Select generate(Serializable[] serializables) {
                return selectFrom(TSYS_USER_TABLE).where(TSYS_USER_TABLE.USER_ID.in(serializables));
            }
        };
        return getDslSession().fetchList(callback.generate(userIds), TsysUser.class);
	}

	@Override
	public List<String> findPermissions(String userId) {
		List<String> tsysIntList = getDslSession().fetchList(
				select(TSYS_ROLE_RIGHT_TABLE.MENU_ID).from(TSYS_USER_TABLE,TSYS_ROLE_USER_TABLE,TSYS_ROLE_RIGHT_TABLE)
				.where(and(
						TSYS_USER_TABLE.USER_ID.eq(TSYS_ROLE_USER_TABLE.USER_CODE),
						TSYS_ROLE_USER_TABLE.ROLE_ID.eq(TSYS_ROLE_RIGHT_TABLE.ROLE_CODE))),String.class);
			return tsysIntList;
	}

}
