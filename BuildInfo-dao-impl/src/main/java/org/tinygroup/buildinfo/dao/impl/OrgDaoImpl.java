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
import static org.tinygroup.buildinfo.dao.inter.constant.OrgTable.*;
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
import org.tinygroup.buildinfo.dao.inter.pojo.Org;
import org.tinygroup.buildinfo.dao.inter.OrgDao;
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
public class OrgDaoImpl extends TinyDslDaoSupport implements OrgDao {

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Org add(Org org) {
		return getDslTemplate().insertAndReturnKey(false ,org, new InsertGenerateCallback<Org>() {
			public Insert generate(Org t) {
				Insert insert = insertInto(ORG_TABLE).values(
					ORG_TABLE.ORG_ID.value(t.getOrgId()),
					ORG_TABLE.ORG_NAME.value(t.getOrgName()),
					ORG_TABLE.PARENT_ID.value(t.getParentId()),
					ORG_TABLE.SORT_NUM.value(t.getSortNum()));
				return insert;
			}
		});
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public int edit(Org org) {
		if(org == null || org.getOrgId() == null){
			return 0;
		}
		return getDslTemplate().update(org, new UpdateGenerateCallback<Org>() {
			public Update generate(Org t) {
				Update update = update(ORG_TABLE).set(
					ORG_TABLE.ORG_NAME.value(t.getOrgName()),
					ORG_TABLE.PARENT_ID.value(t.getParentId()),
					ORG_TABLE.SORT_NUM.value(t.getSortNum())).where(
					ORG_TABLE.ORG_ID.eq(t.getOrgId()));
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
				return delete(ORG_TABLE).where(ORG_TABLE.ORG_ID.eq(pk));
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
				return delete(ORG_TABLE).where(ORG_TABLE.ORG_ID.in(t));
		}
		},pks);
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Org getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, Org.class, new SelectGenerateCallback<Serializable>() {
		@SuppressWarnings("rawtypes")
		public Select generate(Serializable t) {
			return selectFrom(ORG_TABLE).where(ORG_TABLE.ORG_ID.eq(t));
			}
		});
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public List<Org> query(Org org ,final OrderBy... orderArgs) {
		if(org==null){
			org=new Org();
		}
		return getDslTemplate().query(org, new SelectGenerateCallback<Org>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Org t) {
				Select select = selectFrom(ORG_TABLE).where(
				and(
					ORG_TABLE.ORG_NAME.eq(t.getOrgName()),
					ORG_TABLE.PARENT_ID.eq(t.getParentId()),
					ORG_TABLE.SORT_NUM.eq(t.getSortNum())));
			return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Pager<Org> queryPager(int start,int limit ,Org org ,final OrderBy... orderArgs) {
		if(org==null){
			org=new Org();
		}
		return getDslTemplate().queryPager(start, limit, org, false, new SelectGenerateCallback<Org>() {

			public Select generate(Org t) {
				Select select = Select.selectFrom(ORG_TABLE).where(
				and(
					ORG_TABLE.ORG_NAME.eq(t.getOrgName()),
					ORG_TABLE.PARENT_ID.eq(t.getParentId()),
					ORG_TABLE.SORT_NUM.eq(t.getSortNum())));
			return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys ,List<Org> orgs) {
		if (CollectionUtil.isEmpty(orgs)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, orgs, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(ORG_TABLE).values(
					ORG_TABLE.ORG_NAME.value(new JdbcNamedParameter("orgName")),
					ORG_TABLE.PARENT_ID.value(new JdbcNamedParameter("parentId")),
					ORG_TABLE.SORT_NUM.value(new JdbcNamedParameter("sortNum")));
			}
		});
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<Org> orgs){
			return batchInsert(true ,orgs);
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<Org> orgs) {
		if (CollectionUtil.isEmpty(orgs)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(orgs, new NoParamUpdateGenerateCallback() {

			public Update generate() {
				return update(ORG_TABLE).set(
					ORG_TABLE.ORG_NAME.value(new JdbcNamedParameter("orgName")),
					ORG_TABLE.PARENT_ID.value(new JdbcNamedParameter("parentId")),
					ORG_TABLE.SORT_NUM.value(new JdbcNamedParameter("sortNum"))).where(
				ORG_TABLE.ORG_ID.eq(new JdbcNamedParameter("orgId")));
			}
		});
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<Org> orgs) {
		if (CollectionUtil.isEmpty(orgs)) {
			return new int[0];
		}
		return getDslTemplate().batchDelete(orgs, new NoParamDeleteGenerateCallback() {

			public Delete generate() {
				return delete(ORG_TABLE).where(and(
				ORG_TABLE.ORG_ID.eq(new JdbcNamedParameter("orgId")),
				ORG_TABLE.ORG_NAME.eq(new JdbcNamedParameter("orgName")),
				ORG_TABLE.PARENT_ID.eq(new JdbcNamedParameter("parentId")),
				ORG_TABLE.SORT_NUM.eq(new JdbcNamedParameter("sortNum"))));
			}
		});
	}

		public int[] preparedBatchInsert(List<Org> list) {
			return new int[0];
		}

		public int[] preparedBatchUpdate(List<Org> list) {
			return new int[0];
		}

		public int[] preparedBatchDelete(List<Org> list) {
			return new int[0];
		}

	}
