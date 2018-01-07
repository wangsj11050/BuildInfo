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

import static org.tinygroup.buildinfo.dao.inter.constant.TsysMenuTable.TSYS_MENU_TABLE;
import static org.tinygroup.buildinfo.ext.dao.inter.constant.TsysRoleRightTable.TSYS_ROLE_RIGHT_TABLE;
import static org.tinygroup.buildinfo.dao.inter.constant.TsysRoleUserTable.TSYS_ROLE_USER_TABLE;
import static org.tinygroup.buildinfo.ext.dao.inter.constant.TsysUserRightTable.TSYS_USER_RIGHT_TABLE;
import static org.tinygroup.jdbctemplatedslsession.util.TinyDSLUtil.addOrderByElements;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.select;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.tinygroup.buildinfo.common.dto.biz.SysMenuExt;
import org.tinygroup.buildinfo.dao.inter.TsysMenuDao;
import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysMenu;
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
import org.tinygroup.tinysqldsl.*;
import org.tinygroup.tinysqldsl.expression.JdbcNamedParameter;

import static org.tinygroup.tinysqldsl.ComplexSelect.union;

/**
 * <!-- begin-user-doc --> 濡傛灉涓嶅笇鏈涙煇鏂规硶鎴栬�鍙橀噺琚鐩栵紝鍙互鍦ㄦ柟娉曟垨鑰呭彉閲忔敞閲婁腑澧炲姞@unmodifiable
 * <!-- end-user-doc -->
 */
public class TsysMenuDaoImpl extends TinyDslDaoSupport implements TsysMenuDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysMenu add(TsysMenu tsysMenu) {
		return getDslTemplate().insertAndReturnKey(tsysMenu,
				new InsertGenerateCallback<TsysMenu>() {
					public Insert generate(TsysMenu t) {
						Insert insert = insertInto(TSYS_MENU_TABLE)
								.values(TSYS_MENU_TABLE.ID.value(t.getMenuId()),
										TSYS_MENU_TABLE.MENU_CODE.value(t
												.getMenuCode()),
										TSYS_MENU_TABLE.KIND_CODE.value(t
												.getKindCode()),
										TSYS_MENU_TABLE.MENU_NAME.value(t
												.getMenuName()),
										TSYS_MENU_TABLE.MENU_ARG.value(t
												.getMenuArg()),
										TSYS_MENU_TABLE.MENU_ICON.value(t
												.getMenuIcon()),
										TSYS_MENU_TABLE.WINDOW_TYPE.value(t
												.getWindowType()),
										TSYS_MENU_TABLE.TIP.value(t.getTip()),
										TSYS_MENU_TABLE.HOT_KEY.value(t
												.getHotKey()),
										TSYS_MENU_TABLE.ORDER_NO.value(t
												.getOrderNo()),
										TSYS_MENU_TABLE.OPEN_FLAG.value(t
												.getOpenFlag()),
										TSYS_MENU_TABLE.TREE_IDX.value(t
												.getTreeIdx()),
										TSYS_MENU_TABLE.REMARK.value(t
												.getRemark()),
										TSYS_MENU_TABLE.WINDOW_MODEL.value(t
												.getWindowModel()),
										TSYS_MENU_TABLE.MENU_URL.value(t
												.getMenuUrl()),
										TSYS_MENU_TABLE.PARENT_ID.value(t.getParentId())

								);
						return insert;
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TsysMenu tsysMenu) {
		if (tsysMenu == null || tsysMenu.getMenuId() == null) {
			return 0;
		}
		return getDslTemplate().update(tsysMenu,
				new UpdateGenerateCallback<TsysMenu>() {
					public Update generate(TsysMenu t) {
						Update update = update(TSYS_MENU_TABLE)
								.set(TSYS_MENU_TABLE.MENU_CODE.value(t
										.getMenuCode()),
										TSYS_MENU_TABLE.KIND_CODE.value(t
												.getKindCode()),
										TSYS_MENU_TABLE.MENU_NAME.value(t
												.getMenuName()),
										TSYS_MENU_TABLE.MENU_ARG.value(t
												.getMenuArg()),
										TSYS_MENU_TABLE.MENU_ICON.value(t
												.getMenuIcon()),
										TSYS_MENU_TABLE.WINDOW_TYPE.value(t
												.getWindowType()),
										TSYS_MENU_TABLE.TIP.value(t.getTip()),
										TSYS_MENU_TABLE.HOT_KEY.value(t
												.getHotKey()),
										TSYS_MENU_TABLE.PARENT_ID.value(t.getParentId()),
										TSYS_MENU_TABLE.ORDER_NO.value(t
												.getOrderNo()),
										TSYS_MENU_TABLE.OPEN_FLAG.value(t
												.getOpenFlag()),
										TSYS_MENU_TABLE.TREE_IDX.value(t
												.getTreeIdx()),
										TSYS_MENU_TABLE.REMARK.value(t
												.getRemark()),
										TSYS_MENU_TABLE.WINDOW_MODEL.value(t
												.getWindowModel()),
										TSYS_MENU_TABLE.MENU_URL.value(t
												.getMenuUrl())).where(
										TSYS_MENU_TABLE.ID.eq(t.getMenuId()));
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
				return delete(TSYS_MENU_TABLE).where(TSYS_MENU_TABLE.MENU_CODE.eq(pk));
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
				return delete(TSYS_MENU_TABLE).where(TSYS_MENU_TABLE.MENU_CODE.in(t));
		}
		},pks);
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public TsysMenu getByKey(String pk) {
		return getDslTemplate().getByKey(pk, TsysMenu.class, new SelectGenerateCallback<Serializable>() {
		@SuppressWarnings("rawtypes")
		public Select generate(Serializable t) {
			return selectFrom(TSYS_MENU_TABLE).where(TSYS_MENU_TABLE.MENU_CODE.eq(t));
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
						return delete(TSYS_MENU_TABLE).where(
								TSYS_MENU_TABLE.ID.eq(pk));
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
						return delete(TSYS_MENU_TABLE).where(
								TSYS_MENU_TABLE.ID.in(t));
					}
				}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TsysMenu getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, TsysMenu.class,
				new SelectGenerateCallback<Serializable>() {

					@SuppressWarnings("rawtypes")
					public Select generate(Serializable t) {
						return selectFrom(TSYS_MENU_TABLE).where(
								TSYS_MENU_TABLE.ID.eq(t));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TsysMenu> query(TsysMenu tsysMenu, final OrderBy... orderArgs) {
		if (tsysMenu == null) {
			tsysMenu = new TsysMenu();
		}
		return getDslTemplate().query(tsysMenu,
				new SelectGenerateCallback<TsysMenu>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysMenu t) {
						Select select = selectFrom(TSYS_MENU_TABLE)
								.where(and(
										TSYS_MENU_TABLE.MENU_CODE.eq(t
												.getMenuCode()),
										TSYS_MENU_TABLE.KIND_CODE.eq(t
												.getKindCode()),
										TSYS_MENU_TABLE.MENU_NAME.eq(t
												.getMenuName()),
										TSYS_MENU_TABLE.MENU_ARG.eq(t
												.getMenuArg()),
										TSYS_MENU_TABLE.MENU_ICON.eq(t
												.getMenuIcon()),
										TSYS_MENU_TABLE.WINDOW_TYPE.eq(t
												.getWindowType()),
										TSYS_MENU_TABLE.TIP.eq(t.getTip()),
										TSYS_MENU_TABLE.HOT_KEY.eq(t
												.getHotKey()),
										TSYS_MENU_TABLE.PARENT_ID.eq(t.getParentId()),
										TSYS_MENU_TABLE.ORDER_NO.eq(t
												.getOrderNo()),
										TSYS_MENU_TABLE.OPEN_FLAG.eq(t
												.getOpenFlag()),
										TSYS_MENU_TABLE.TREE_IDX.eq(t
												.getTreeIdx()),
										TSYS_MENU_TABLE.REMARK.eq(t.getRemark()),
										TSYS_MENU_TABLE.WINDOW_MODEL.eq(t
												.getWindowModel()),
										TSYS_MENU_TABLE.MENU_URL.eq(t
												.getMenuUrl())

								));
						return
                                addOrderByElements(select, orderArgs);
					}
				});
	}

	public List<SysMenuExt> querySysMenuExt(SysMenuExt sysMenuExt, final OrderBy... orderArgs) {
		if (sysMenuExt == null) {
			sysMenuExt = new SysMenuExt();
		}
		return getDslTemplate().query(sysMenuExt,
				new SelectGenerateCallback<SysMenuExt>() {
					@SuppressWarnings("rawtypes")
					public Select generate(SysMenuExt t) {
						Select select = select(TSYS_MENU_TABLE.ALL).from(TSYS_MENU_TABLE)
								.where(and(
										TSYS_MENU_TABLE.MENU_NAME.eq(t
												.getMenuName()),
										TSYS_MENU_TABLE.MENU_ICON.eq(t
												.getMenuIcon()),
										TSYS_MENU_TABLE.PARENT_ID.eq(t.getParentCode()),
										TSYS_MENU_TABLE.ORDER_NO.eq(t
												.getOrderNo())
								));
						return
                                addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TsysMenu> queryPager(int start, int limit, TsysMenu tsysMenu,
			final OrderBy... orderArgs) {
		if (tsysMenu == null) {
			tsysMenu = new TsysMenu();
		}
		return getDslTemplate().queryPager(start, limit, tsysMenu, false,
				new SelectGenerateCallback<TsysMenu>() {
					public Select generate(TsysMenu t) {
						Select select = Select
								.selectFrom(TSYS_MENU_TABLE)
								.where(and(
										TSYS_MENU_TABLE.MENU_CODE.eq(t
												.getMenuCode()),
										TSYS_MENU_TABLE.KIND_CODE.eq(t
												.getKindCode()),
										TSYS_MENU_TABLE.MENU_NAME.eq(t
												.getMenuName()),
										TSYS_MENU_TABLE.MENU_ARG.eq(t
												.getMenuArg()),
										TSYS_MENU_TABLE.MENU_ICON.eq(t
												.getMenuIcon()),
										TSYS_MENU_TABLE.WINDOW_TYPE.eq(t
												.getWindowType()),
										TSYS_MENU_TABLE.TIP.eq(t.getTip()),
										TSYS_MENU_TABLE.HOT_KEY.eq(t
												.getHotKey()),
										TSYS_MENU_TABLE.PARENT_ID.eq(t.getParentId()),
										TSYS_MENU_TABLE.ORDER_NO.eq(t
												.getOrderNo()),
										TSYS_MENU_TABLE.OPEN_FLAG.eq(t
												.getOpenFlag()),
										TSYS_MENU_TABLE.TREE_IDX.eq(t
												.getTreeIdx()),
										TSYS_MENU_TABLE.REMARK.eq(t.getRemark()),
										TSYS_MENU_TABLE.WINDOW_MODEL.eq(t
												.getWindowModel()),
										TSYS_MENU_TABLE.MENU_URL.eq(t
												.getMenuUrl())

								));
						return
                                addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * like 搜索
	 */
	public Pager<TsysMenu> queryPagerForSearch(int start, int limit, TsysMenu tsysMenu,
			final OrderBy... orderArgs) {
		if (tsysMenu == null) {
			tsysMenu = new TsysMenu();
		}
		return getDslTemplate().queryPager(start, limit, tsysMenu, false,
				new SelectGenerateCallback<TsysMenu>() {
					public Select generate(TsysMenu t) {
						Select select = Select
								.selectFrom(TSYS_MENU_TABLE)
								.where(and(
										TSYS_MENU_TABLE.MENU_CODE.like(t
												.getMenuCode()),
										TSYS_MENU_TABLE.KIND_CODE.like(t
												.getKindCode()),
										TSYS_MENU_TABLE.MENU_NAME.like(t
												.getMenuName()),
										TSYS_MENU_TABLE.MENU_ARG.like(t
												.getMenuArg()),
										TSYS_MENU_TABLE.MENU_ICON.like(t
												.getMenuIcon()),
										TSYS_MENU_TABLE.WINDOW_TYPE.like(t
												.getWindowType()),
										TSYS_MENU_TABLE.TIP.like(t.getTip()),
										TSYS_MENU_TABLE.HOT_KEY.like(t
												.getHotKey()),
										TSYS_MENU_TABLE.PARENT_ID.eq(t
												.getParentId()),
										TSYS_MENU_TABLE.ORDER_NO.eq(t
												.getOrderNo()),
										TSYS_MENU_TABLE.OPEN_FLAG.like(t
												.getOpenFlag()),
										TSYS_MENU_TABLE.TREE_IDX.like(t
												.getTreeIdx()),
										TSYS_MENU_TABLE.REMARK.like(t.getRemark()),
										TSYS_MENU_TABLE.WINDOW_MODEL.like(t
												.getWindowModel()),
										TSYS_MENU_TABLE.MENU_URL.like(t
												.getMenuUrl())

								));
						return
                                addOrderByElements(select, orderArgs);
					}
				});
	}


	public List<SysMenuExt> findMenusBySubTrans(final List<Integer> subTransId, final OrderBy... orderArgs) {
		Integer[] subTransIdArray = new Integer[subTransId.size()];
		subTransId.toArray(subTransIdArray);
		return findMenusBySubTrans(subTransIdArray,orderArgs);
	}

	public List<SysMenuExt> findMenusBySubTrans(final Integer[] subTransId, final OrderBy... orderArgs) {

		return null;
	}


	public List<Integer> findSubTransIdByUser(String userCode, OrderBy... orderArgs){
/*		List<Integer> tsysIntList = getDslSession().fetchList(
				union(select(TSYS_USER_RIGHT_TABLE.SUB_TRANS_ID).from(TSYS_USER_RIGHT_TABLE).where(
								TSYS_USER_RIGHT_TABLE.USER_ID.eq(userCode)),
								select(TSYS_ROLE_RIGHT_TABLE.SUB_TRANS_ID).from(TSYS_ROLE_USER_TABLE,TSYS_ROLE_RIGHT_TABLE).where(
										and(TSYS_ROLE_USER_TABLE.ROLE_CODE.eq(TSYS_ROLE_RIGHT_TABLE.ROLE_CODE),
												TSYS_ROLE_USER_TABLE.USER_CODE.eq(userCode))
								)),Integer.class);*/
		return null;
	}

	public List<Integer> findMenuIdsByUser(final String userCode, final OrderBy... orderArgs){
		List<Integer> tsysIntList = getDslSession().fetchList(
				union(addOrderByElements(select(TSYS_USER_RIGHT_TABLE.MENU_ID).from(TSYS_USER_RIGHT_TABLE).where(
						TSYS_USER_RIGHT_TABLE.USER_ID.eq(userCode)),orderArgs),
                        addOrderByElements(select(TSYS_ROLE_RIGHT_TABLE.MENU_ID).from(TSYS_ROLE_USER_TABLE,TSYS_ROLE_RIGHT_TABLE).where(
								and(TSYS_ROLE_USER_TABLE.ROLE_ID.eq(TSYS_ROLE_RIGHT_TABLE.ROLE_ID),
										TSYS_ROLE_USER_TABLE.USER_CODE.eq(userCode)))
						,orderArgs)),Integer.class);
		return tsysIntList;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<TsysMenu> tsysMenu) {
		if (CollectionUtil.isEmpty(tsysMenu)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysMenu,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_MENU_TABLE)
								.values(TSYS_MENU_TABLE.MENU_CODE
										.value(new JdbcNamedParameter(
												"menuCode")),
										TSYS_MENU_TABLE.KIND_CODE
												.value(new JdbcNamedParameter(
														"kindCode")),
										TSYS_MENU_TABLE.MENU_NAME
												.value(new JdbcNamedParameter(
														"menuName")),
										TSYS_MENU_TABLE.MENU_ARG
												.value(new JdbcNamedParameter(
														"menuArg")),
										TSYS_MENU_TABLE.MENU_ICON
												.value(new JdbcNamedParameter(
														"menuIcon")),
										TSYS_MENU_TABLE.WINDOW_TYPE
												.value(new JdbcNamedParameter(
														"windowType")),
										TSYS_MENU_TABLE.TIP
												.value(new JdbcNamedParameter(
														"tip")),
										TSYS_MENU_TABLE.HOT_KEY
												.value(new JdbcNamedParameter(
														"hotKey")),
										TSYS_MENU_TABLE.PARENT_ID
												.value(new JdbcNamedParameter(
														"parentId")),
										TSYS_MENU_TABLE.ORDER_NO
												.value(new JdbcNamedParameter(
														"orderNo")),
										TSYS_MENU_TABLE.OPEN_FLAG
												.value(new JdbcNamedParameter(
														"openFlag")),
										TSYS_MENU_TABLE.TREE_IDX
												.value(new JdbcNamedParameter(
														"treeIdx")),
										TSYS_MENU_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark")),
										TSYS_MENU_TABLE.WINDOW_MODEL
												.value(new JdbcNamedParameter(
														"windowModel")),
										TSYS_MENU_TABLE.MENU_URL
												.value(new JdbcNamedParameter(
														"menuUrl"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TsysMenu> tsysMenus) {
		return batchInsert(true, tsysMenus);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TsysMenu> tsysMenu) {
		if (CollectionUtil.isEmpty(tsysMenu)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysMenu,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_MENU_TABLE)
								.set(TSYS_MENU_TABLE.MENU_CODE
										.value(new JdbcNamedParameter(
												"menuCode")),
										TSYS_MENU_TABLE.KIND_CODE
												.value(new JdbcNamedParameter(
														"kindCode")),
										TSYS_MENU_TABLE.MENU_NAME
												.value(new JdbcNamedParameter(
														"menuName")),
										TSYS_MENU_TABLE.MENU_ARG
												.value(new JdbcNamedParameter(
														"menuArg")),
										TSYS_MENU_TABLE.MENU_ICON
												.value(new JdbcNamedParameter(
														"menuIcon")),
										TSYS_MENU_TABLE.WINDOW_TYPE
												.value(new JdbcNamedParameter(
														"windowType")),
										TSYS_MENU_TABLE.TIP
												.value(new JdbcNamedParameter(
														"tip")),
										TSYS_MENU_TABLE.HOT_KEY
												.value(new JdbcNamedParameter(
														"hotKey")),
										TSYS_MENU_TABLE.PARENT_ID
												.value(new JdbcNamedParameter(
														"parentId")),
										TSYS_MENU_TABLE.ORDER_NO
												.value(new JdbcNamedParameter(
														"orderNo")),
										TSYS_MENU_TABLE.OPEN_FLAG
												.value(new JdbcNamedParameter(
														"openFlag")),
										TSYS_MENU_TABLE.TREE_IDX
												.value(new JdbcNamedParameter(
														"treeIdx")),
										TSYS_MENU_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark")),
										TSYS_MENU_TABLE.WINDOW_MODEL
												.value(new JdbcNamedParameter(
														"windowModel")),
										TSYS_MENU_TABLE.MENU_URL
												.value(new JdbcNamedParameter(
														"menuUrl"))

								).where(TSYS_MENU_TABLE.ID
										.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TsysMenu> tsysMenu) {
		if (CollectionUtil.isEmpty(tsysMenu)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysMenu,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_MENU_TABLE)
								.where(and(
										TSYS_MENU_TABLE.MENU_CODE
												.eq(new JdbcNamedParameter(
														"menuCode")),
										TSYS_MENU_TABLE.KIND_CODE
												.eq(new JdbcNamedParameter(
														"kindCode")),
										TSYS_MENU_TABLE.MENU_NAME
												.eq(new JdbcNamedParameter(
														"menuName")),
										TSYS_MENU_TABLE.MENU_ARG
												.eq(new JdbcNamedParameter(
														"menuArg")),
										TSYS_MENU_TABLE.MENU_ICON
												.eq(new JdbcNamedParameter(
														"menuIcon")),
										TSYS_MENU_TABLE.WINDOW_TYPE
												.eq(new JdbcNamedParameter(
														"windowType")),
										TSYS_MENU_TABLE.TIP
												.eq(new JdbcNamedParameter(
														"tip")),
										TSYS_MENU_TABLE.HOT_KEY
												.eq(new JdbcNamedParameter(
														"hotKey")),
										TSYS_MENU_TABLE.PARENT_ID
												.eq(new JdbcNamedParameter(
														"parentId")),
										TSYS_MENU_TABLE.ORDER_NO
												.eq(new JdbcNamedParameter(
														"orderNo")),
										TSYS_MENU_TABLE.OPEN_FLAG
												.eq(new JdbcNamedParameter(
														"openFlag")),
										TSYS_MENU_TABLE.TREE_IDX
												.eq(new JdbcNamedParameter(
														"treeIdx")),
										TSYS_MENU_TABLE.REMARK
												.eq(new JdbcNamedParameter(
														"remark")),
										TSYS_MENU_TABLE.WINDOW_MODEL
												.eq(new JdbcNamedParameter(
														"windowModel")),
										TSYS_MENU_TABLE.MENU_URL
												.eq(new JdbcNamedParameter(
														"menuUrl"))

								));
					}
				});
	}

	public List getMenuTree(TreeData tree) {
		if(tree == null){
			tree =  new TreeData();
		}
		return getDslTemplate().query(tree,new SelectGenerateCallback<TreeData>() {

			@SuppressWarnings("rawtypes")
			public Select generate(TreeData t) {
				Select select =
						select(
								TSYS_MENU_TABLE.PARENT_ID.as("pid"),
								TSYS_MENU_TABLE.ID.as("id"),
								TSYS_MENU_TABLE.MENU_NAME.as("name")).
						from(TSYS_MENU_TABLE).where(and(
								TSYS_MENU_TABLE.ID.eq(t.getId()),
								TSYS_MENU_TABLE.PARENT_ID.eq(t.getpId()),
								TSYS_MENU_TABLE.MENU_NAME.eq(t.getName())
								));
				return select;
			}

		} );
	}

	/**
	 * 根据kind_code menu_code获取信息
	 *
	 * @param tsysMenu
	 * @return
	 */
	public List checkExist(TsysMenu tsysMenu) {
		if (tsysMenu == null) {
			tsysMenu = new TsysMenu();
		}
		return getDslTemplate().query(tsysMenu,
				new SelectGenerateCallback<TsysMenu>() {
					@SuppressWarnings("rawtypes")
					public Select generate(TsysMenu t) {
						Select select = selectFrom(TSYS_MENU_TABLE)
								.where(and(
										TSYS_MENU_TABLE.MENU_CODE.eq(t
												.getMenuCode()),
										TSYS_MENU_TABLE.KIND_CODE.eq(t
												.getKindCode())

								));
						return select;
					}
				});
	}
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys,
									 List<TsysMenu> tsysMenu) {
		if (CollectionUtil.isEmpty(tsysMenu)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tsysMenu,
				new NoParamInsertGenerateCallback() {

					public Insert generate() {
						return insertInto(TSYS_MENU_TABLE)
								.values(TSYS_MENU_TABLE.MENU_CODE
												.value(new JdbcNamedParameter(
														"menuCode")),
										TSYS_MENU_TABLE.KIND_CODE
												.value(new JdbcNamedParameter(
														"kindCode")),
										TSYS_MENU_TABLE.MENU_NAME
												.value(new JdbcNamedParameter(
														"menuName")),
										TSYS_MENU_TABLE.MENU_ARG
												.value(new JdbcNamedParameter(
														"menuArg")),
										TSYS_MENU_TABLE.MENU_ICON
												.value(new JdbcNamedParameter(
														"menuIcon")),
										TSYS_MENU_TABLE.WINDOW_TYPE
												.value(new JdbcNamedParameter(
														"windowType")),
										TSYS_MENU_TABLE.TIP
												.value(new JdbcNamedParameter(
														"tip")),
										TSYS_MENU_TABLE.HOT_KEY
												.value(new JdbcNamedParameter(
														"hotKey")),
										TSYS_MENU_TABLE.PARENT_ID
												.value(new JdbcNamedParameter(
														"parentId")),
										TSYS_MENU_TABLE.ORDER_NO
												.value(new JdbcNamedParameter(
														"orderNo")),
										TSYS_MENU_TABLE.OPEN_FLAG
												.value(new JdbcNamedParameter(
														"openFlag")),
										TSYS_MENU_TABLE.TREE_IDX
												.value(new JdbcNamedParameter(
														"treeIdx")),
										TSYS_MENU_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark")),
										TSYS_MENU_TABLE.WINDOW_MODEL
												.value(new JdbcNamedParameter(
														"windowModel")),
										TSYS_MENU_TABLE.MENU_URL
												.value(new JdbcNamedParameter(
														"menuUrl"))

								);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TsysMenu> tsysMenu) {
		if (CollectionUtil.isEmpty(tsysMenu)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tsysMenu,
				new NoParamUpdateGenerateCallback() {
					public Update generate() {
						return update(TSYS_MENU_TABLE)
								.set(TSYS_MENU_TABLE.MENU_CODE
												.value(new JdbcNamedParameter(
														"menuCode")),
										TSYS_MENU_TABLE.KIND_CODE
												.value(new JdbcNamedParameter(
														"kindCode")),
										TSYS_MENU_TABLE.MENU_NAME
												.value(new JdbcNamedParameter(
														"menuName")),
										TSYS_MENU_TABLE.MENU_ARG
												.value(new JdbcNamedParameter(
														"menuArg")),
										TSYS_MENU_TABLE.MENU_ICON
												.value(new JdbcNamedParameter(
														"menuIcon")),
										TSYS_MENU_TABLE.WINDOW_TYPE
												.value(new JdbcNamedParameter(
														"windowType")),
										TSYS_MENU_TABLE.TIP
												.value(new JdbcNamedParameter(
														"tip")),
										TSYS_MENU_TABLE.HOT_KEY
												.value(new JdbcNamedParameter(
														"hotKey")),
										TSYS_MENU_TABLE.PARENT_ID
												.value(new JdbcNamedParameter(
														"parentId")),
										TSYS_MENU_TABLE.ORDER_NO
												.value(new JdbcNamedParameter(
														"orderNo")),
										TSYS_MENU_TABLE.OPEN_FLAG
												.value(new JdbcNamedParameter(
														"openFlag")),
										TSYS_MENU_TABLE.TREE_IDX
												.value(new JdbcNamedParameter(
														"treeIdx")),
										TSYS_MENU_TABLE.REMARK
												.value(new JdbcNamedParameter(
														"remark")),
										TSYS_MENU_TABLE.WINDOW_MODEL
												.value(new JdbcNamedParameter(
														"windowModel")),
										TSYS_MENU_TABLE.MENU_URL
												.value(new JdbcNamedParameter(
														"menuUrl"))

								).where(TSYS_MENU_TABLE.ID
										.eq(new JdbcNamedParameter("id")));
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TsysMenu> tsysMenu) {
		if (CollectionUtil.isEmpty(tsysMenu)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tsysMenu,
				new NoParamDeleteGenerateCallback() {
					public Delete generate() {
						return delete(TSYS_MENU_TABLE)
								.where(and(
										TSYS_MENU_TABLE.MENU_CODE
												.eq(new JdbcNamedParameter(
														"menuCode")),
										TSYS_MENU_TABLE.KIND_CODE
												.eq(new JdbcNamedParameter(
														"kindCode")),
										TSYS_MENU_TABLE.MENU_NAME
												.eq(new JdbcNamedParameter(
														"menuName")),
										TSYS_MENU_TABLE.MENU_ARG
												.eq(new JdbcNamedParameter(
														"menuArg")),
										TSYS_MENU_TABLE.MENU_ICON
												.eq(new JdbcNamedParameter(
														"menuIcon")),
										TSYS_MENU_TABLE.WINDOW_TYPE
												.eq(new JdbcNamedParameter(
														"windowType")),
										TSYS_MENU_TABLE.TIP
												.eq(new JdbcNamedParameter(
														"tip")),
										TSYS_MENU_TABLE.HOT_KEY
												.eq(new JdbcNamedParameter(
														"hotKey")),
										TSYS_MENU_TABLE.PARENT_ID
												.eq(new JdbcNamedParameter(
														"parentId")),
										TSYS_MENU_TABLE.ORDER_NO
												.eq(new JdbcNamedParameter(
														"orderNo")),
										TSYS_MENU_TABLE.OPEN_FLAG
												.eq(new JdbcNamedParameter(
														"openFlag")),
										TSYS_MENU_TABLE.TREE_IDX
												.eq(new JdbcNamedParameter(
														"treeIdx")),
										TSYS_MENU_TABLE.REMARK
												.eq(new JdbcNamedParameter(
														"remark")),
										TSYS_MENU_TABLE.WINDOW_MODEL
												.eq(new JdbcNamedParameter(
														"windowModel")),
										TSYS_MENU_TABLE.MENU_URL
												.eq(new JdbcNamedParameter(
														"menuUrl"))

								));
					}
				});
	}

	public int[] preparedBatchInsert(List<TsysMenu> tsysMenu) {
		return preparedBatchInsert(true, tsysMenu);
	}

	@Override
	public List<Integer> findAppMenuIds(TsysMenu sysMenu) {
		List<Integer> tsysIntList = getDslSession().fetchList(
			select(TSYS_MENU_TABLE.ID).from(TSYS_MENU_TABLE).where(
					TSYS_MENU_TABLE.KIND_CODE.eq(sysMenu.getKindCode())),Integer.class);
		return tsysIntList;
	}

}

