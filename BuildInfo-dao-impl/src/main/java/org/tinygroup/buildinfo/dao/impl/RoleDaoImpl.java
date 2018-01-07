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
import static org.tinygroup.buildinfo.dao.inter.constant.RoleTable.*;
import static org.tinygroup.tinysqldsl.Select.*;
import static org.tinygroup.tinysqldsl.Insert.*;
import static org.tinygroup.tinysqldsl.Delete.*;
import static org.tinygroup.tinysqldsl.Update.*;

import java.io.Serializable;
import java.util.List;
import org.tinygroup.tinysqldsl.Delete;
import org.tinygroup.tinysqldsl.Insert;
import org.tinygroup.tinysqldsl.Select;
import org.tinygroup.tinysqldsl.Update;
import org.tinygroup.tinysqldsl.Pager;
import org.tinygroup.commons.tools.CollectionUtil;
import org.tinygroup.tinysqldsl.expression.JdbcNamedParameter;
import org.tinygroup.buildinfo.dao.inter.pojo.Role;
import org.tinygroup.buildinfo.dao.inter.RoleDao;
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
	 * 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable
	 * <!-- end-user-doc -->
	 */
public class RoleDaoImpl extends TinyDslDaoSupport implements RoleDao {

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Role add(Role role) {
		return getDslTemplate().insertAndReturnKey(role, new InsertGenerateCallback<Role>() {
			public Insert generate(Role t) {
				Insert insert = insertInto(ROLE_TABLE).values(
					ROLE_TABLE.ID.value(t.getId()),
					ROLE_TABLE.NAME.value(t.getName()),
					ROLE_TABLE.TYPE.value(t.getType()));
				return insert;
			}
		});
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public int edit(Role role) {
		if(role == null || role.getId() == null){
			return 0;
		}
		return getDslTemplate().update(role, new UpdateGenerateCallback<Role>() {
			public Update generate(Role t) {
				Update update = update(ROLE_TABLE).set(
					ROLE_TABLE.NAME.value(t.getName()),
					ROLE_TABLE.TYPE.value(t.getType())).where(
					ROLE_TABLE.ID.eq(t.getId()));
				return update;
			}
		});
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public int deleteByKey(Integer pk){
		if(pk == null){
			return 0;
		}
		return getDslTemplate().deleteByKey(pk, new DeleteGenerateCallback<Serializable>() {
			public Delete generate(Serializable pk) {
				return delete(ROLE_TABLE).where(ROLE_TABLE.ID.eq(pk));
			}
		});
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public int deleteByKeys(Integer... pks) {
		if(pks == null || pks.length == 0){
			return 0;
		}
		return getDslTemplate().deleteByKeys(new DeleteGenerateCallback<Serializable[]>() {
			public Delete generate(Serializable[] t) {
				return delete(ROLE_TABLE).where(ROLE_TABLE.ID.in(t));
		}
		},pks);
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Role getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, Role.class, new SelectGenerateCallback<Serializable>() {
		@SuppressWarnings("rawtypes")
		public Select generate(Serializable t) {
			return selectFrom(ROLE_TABLE).where(ROLE_TABLE.ID.eq(t));
			}
		});
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public List<Role> query(Role role ,final OrderBy... orderArgs) {
		if(role==null){
			role=new Role();
		}
		return getDslTemplate().query(role, new SelectGenerateCallback<Role>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Role t) {
				Select select = selectFrom(ROLE_TABLE).where(
				and(
					ROLE_TABLE.NAME.eq(t.getName()),
					ROLE_TABLE.TYPE.eq(t.getType())));
			return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Pager<Role> queryPager(int start,int limit ,Role role ,final OrderBy... orderArgs) {
		if(role==null){
			role=new Role();
		}
		return getDslTemplate().queryPager(start, limit, role, false, new SelectGenerateCallback<Role>() {

			public Select generate(Role t) {
				Select select = Select.selectFrom(ROLE_TABLE).where(
				and(
					ROLE_TABLE.NAME.eq(t.getName()),
					ROLE_TABLE.TYPE.eq(t.getType())));
			return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys ,List<Role> roles) {
		if (CollectionUtil.isEmpty(roles)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, roles, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(ROLE_TABLE).values(
					ROLE_TABLE.NAME.value(new JdbcNamedParameter("name")),
					ROLE_TABLE.TYPE.value(new JdbcNamedParameter("type")));
			}
		});
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<Role> roles){
			return batchInsert(true ,roles);
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<Role> roles) {
		if (CollectionUtil.isEmpty(roles)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(roles, new NoParamUpdateGenerateCallback() {

			public Update generate() {
				return update(ROLE_TABLE).set(
					ROLE_TABLE.NAME.value(new JdbcNamedParameter("name")),
					ROLE_TABLE.TYPE.value(new JdbcNamedParameter("type"))).where(
				ROLE_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<Role> roles) {
		if (CollectionUtil.isEmpty(roles)) {
			return new int[0];
		}
		return getDslTemplate().batchDelete(roles, new NoParamDeleteGenerateCallback() {

			public Delete generate() {
				return delete(ROLE_TABLE).where(and(
				ROLE_TABLE.ID.eq(new JdbcNamedParameter("id")),
				ROLE_TABLE.NAME.eq(new JdbcNamedParameter("name")),
				ROLE_TABLE.TYPE.eq(new JdbcNamedParameter("type"))));
			}
		});
	}

		public int[] preparedBatchInsert(List<Role> list) {
			return new int[0];
		}

		public int[] preparedBatchUpdate(List<Role> list) {
			return new int[0];
		}

		public int[] preparedBatchDelete(List<Role> list) {
			return new int[0];
		}

	}
