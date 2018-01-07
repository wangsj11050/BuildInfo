
package org.tinygroup.workplan.dao.impl;

import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;
import static org.tinygroup.workplan.dao.inter.constant.TDemandDefectTable.T_DEMAND_DEFECT_TABLE;

import java.io.Serializable;
import java.util.List;

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
import org.tinygroup.workplan.dao.inter.TDemandDefectDao;
import org.tinygroup.workplan.dao.inter.pojo.TDemandDefect;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public class TDemandDefectDaoImpl extends TinyDslDaoSupport implements TDemandDefectDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TDemandDefect add(TDemandDefect tDemandDefect) {
		return getDslTemplate().insertAndReturnKey(tDemandDefect, new InsertGenerateCallback<TDemandDefect>() {
			public Insert generate(TDemandDefect t) {
				Insert insert = insertInto(T_DEMAND_DEFECT_TABLE).values(T_DEMAND_DEFECT_TABLE.ID.value(t.getId()),
						T_DEMAND_DEFECT_TABLE.SUB_PLANN_ID.value(t.getSubPlannId()),
						T_DEMAND_DEFECT_TABLE.SUB_PLANN_NAME.value(t.getSubPlannName()),
						T_DEMAND_DEFECT_TABLE.HAPPEN_DATE.value(t.getHappenDate()),
						T_DEMAND_DEFECT_TABLE.PROBLEM_PHENOMENON.value(t.getProblemPhenomenon()),
						T_DEMAND_DEFECT_TABLE.PROBLEM_DESCRIBE.value(t.getProblemDescribe()),
						T_DEMAND_DEFECT_TABLE.PROBLEM_SOLUTION.value(t.getProblemSolution()),
						T_DEMAND_DEFECT_TABLE.WORKPLAN_CREATE_DATE.value(t.getWorkplanCreateDate()),
						T_DEMAND_DEFECT_TABLE.CREATE_USER.value(t.getCreateUser()),
						T_DEMAND_DEFECT_TABLE.UPDATE_DATE.value(t.getUpdateDate()),
						T_DEMAND_DEFECT_TABLE.UPDATE_USER.value(t.getUpdateUser()),
						T_DEMAND_DEFECT_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						T_DEMAND_DEFECT_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						T_DEMAND_DEFECT_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						T_DEMAND_DEFECT_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						T_DEMAND_DEFECT_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
				return insert;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(TDemandDefect tDemandDefect) {
		if (tDemandDefect == null || tDemandDefect.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(tDemandDefect, new UpdateGenerateCallback<TDemandDefect>() {
			public Update generate(TDemandDefect t) {
				Update update = update(T_DEMAND_DEFECT_TABLE)
						.set(T_DEMAND_DEFECT_TABLE.SUB_PLANN_ID.value(t.getSubPlannId()),
								T_DEMAND_DEFECT_TABLE.SUB_PLANN_NAME.value(t.getSubPlannName()),
								T_DEMAND_DEFECT_TABLE.HAPPEN_DATE.value(t.getHappenDate()),
								T_DEMAND_DEFECT_TABLE.PROBLEM_PHENOMENON.value(t.getProblemPhenomenon()),
								T_DEMAND_DEFECT_TABLE.PROBLEM_DESCRIBE.value(t.getProblemDescribe()),
								T_DEMAND_DEFECT_TABLE.PROBLEM_SOLUTION.value(t.getProblemSolution()),
								T_DEMAND_DEFECT_TABLE.WORKPLAN_CREATE_DATE.value(t.getWorkplanCreateDate()),
								T_DEMAND_DEFECT_TABLE.CREATE_USER.value(t.getCreateUser()),
								T_DEMAND_DEFECT_TABLE.UPDATE_DATE.value(t.getUpdateDate()),
								T_DEMAND_DEFECT_TABLE.UPDATE_USER.value(t.getUpdateUser()),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_5.value(t.getExtField_5()))
						.where(T_DEMAND_DEFECT_TABLE.ID.eq(t.getId()));
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
		return getDslTemplate().deleteByKey(pk, new DeleteGenerateCallback<Serializable>() {
			public Delete generate(Serializable pk) {
				return delete(T_DEMAND_DEFECT_TABLE).where(T_DEMAND_DEFECT_TABLE.ID.eq(pk));
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
		return getDslTemplate().deleteByKeys(new DeleteGenerateCallback<Serializable[]>() {
			public Delete generate(Serializable[] t) {
				return delete(T_DEMAND_DEFECT_TABLE).where(T_DEMAND_DEFECT_TABLE.ID.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public TDemandDefect getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, TDemandDefect.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(T_DEMAND_DEFECT_TABLE).where(T_DEMAND_DEFECT_TABLE.ID.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<TDemandDefect> query(TDemandDefect tDemandDefect, final OrderBy... orderArgs) {
		if (tDemandDefect == null) {
			tDemandDefect = new TDemandDefect();
		}
		return getDslTemplate().query(tDemandDefect, new SelectGenerateCallback<TDemandDefect>() {
			@SuppressWarnings("rawtypes")
			public Select generate(TDemandDefect t) {
				Select select = selectFrom(T_DEMAND_DEFECT_TABLE).where(and(T_DEMAND_DEFECT_TABLE.ID.eq(t.getId()),
						T_DEMAND_DEFECT_TABLE.SUB_PLANN_ID.eq(t.getSubPlannId()),
						T_DEMAND_DEFECT_TABLE.SUB_PLANN_NAME.eq(t.getSubPlannName()),
						T_DEMAND_DEFECT_TABLE.HAPPEN_DATE.eq(t.getHappenDate()),
						T_DEMAND_DEFECT_TABLE.PROBLEM_PHENOMENON.eq(t.getProblemPhenomenon()),
						T_DEMAND_DEFECT_TABLE.PROBLEM_DESCRIBE.eq(t.getProblemDescribe()),
						T_DEMAND_DEFECT_TABLE.PROBLEM_SOLUTION.eq(t.getProblemSolution()),
						T_DEMAND_DEFECT_TABLE.WORKPLAN_CREATE_DATE.eq(t.getWorkplanCreateDate()),
						T_DEMAND_DEFECT_TABLE.CREATE_USER.eq(t.getCreateUser()),
						T_DEMAND_DEFECT_TABLE.UPDATE_DATE.eq(t.getUpdateDate()),
						T_DEMAND_DEFECT_TABLE.UPDATE_USER.eq(t.getUpdateUser()),
						T_DEMAND_DEFECT_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						T_DEMAND_DEFECT_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						T_DEMAND_DEFECT_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						T_DEMAND_DEFECT_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						T_DEMAND_DEFECT_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<TDemandDefect> queryPager(int start, int limit, TDemandDefect tDemandDefect,
			final OrderBy... orderArgs) {
		if (tDemandDefect == null) {
			tDemandDefect = new TDemandDefect();
		}
		return getDslTemplate().queryPager(start, limit, tDemandDefect, false,
				new SelectGenerateCallback<TDemandDefect>() {
					public Select generate(TDemandDefect t) {
						Select select = Select.selectFrom(T_DEMAND_DEFECT_TABLE)
								.where(and(T_DEMAND_DEFECT_TABLE.ID.eq(t.getId()),
										T_DEMAND_DEFECT_TABLE.SUB_PLANN_ID.eq(t.getSubPlannId()),
										T_DEMAND_DEFECT_TABLE.SUB_PLANN_NAME.eq(t.getSubPlannName()),
										T_DEMAND_DEFECT_TABLE.HAPPEN_DATE.eq(t.getHappenDate()),
										T_DEMAND_DEFECT_TABLE.PROBLEM_PHENOMENON.eq(t.getProblemPhenomenon()),
										T_DEMAND_DEFECT_TABLE.PROBLEM_DESCRIBE.eq(t.getProblemDescribe()),
										T_DEMAND_DEFECT_TABLE.PROBLEM_SOLUTION.eq(t.getProblemSolution()),
										T_DEMAND_DEFECT_TABLE.WORKPLAN_CREATE_DATE.eq(t.getWorkplanCreateDate()),
										T_DEMAND_DEFECT_TABLE.CREATE_USER.eq(t.getCreateUser()),
										T_DEMAND_DEFECT_TABLE.UPDATE_DATE.eq(t.getUpdateDate()),
										T_DEMAND_DEFECT_TABLE.UPDATE_USER.eq(t.getUpdateUser()),
										T_DEMAND_DEFECT_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
										T_DEMAND_DEFECT_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
										T_DEMAND_DEFECT_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
										T_DEMAND_DEFECT_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
										T_DEMAND_DEFECT_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
						return TinyDSLUtil.addOrderByElements(select, orderArgs);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<TDemandDefect> tDemandDefect) {
		if (CollectionUtil.isEmpty(tDemandDefect)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tDemandDefect,
				new InsertGenerateCallback<TDemandDefect>() {

					public Insert generate(TDemandDefect t) {
						return insertInto(T_DEMAND_DEFECT_TABLE).values(T_DEMAND_DEFECT_TABLE.ID.value(t.getId()),
								T_DEMAND_DEFECT_TABLE.SUB_PLANN_ID.value(t.getSubPlannId()),
								T_DEMAND_DEFECT_TABLE.SUB_PLANN_NAME.value(t.getSubPlannName()),
								T_DEMAND_DEFECT_TABLE.HAPPEN_DATE.value(t.getHappenDate()),
								T_DEMAND_DEFECT_TABLE.PROBLEM_PHENOMENON.value(t.getProblemPhenomenon()),
								T_DEMAND_DEFECT_TABLE.PROBLEM_DESCRIBE.value(t.getProblemDescribe()),
								T_DEMAND_DEFECT_TABLE.PROBLEM_SOLUTION.value(t.getProblemSolution()),
								T_DEMAND_DEFECT_TABLE.WORKPLAN_CREATE_DATE.value(t.getWorkplanCreateDate()),
								T_DEMAND_DEFECT_TABLE.CREATE_USER.value(t.getCreateUser()),
								T_DEMAND_DEFECT_TABLE.UPDATE_DATE.value(t.getUpdateDate()),
								T_DEMAND_DEFECT_TABLE.UPDATE_USER.value(t.getUpdateUser()),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<TDemandDefect> tDemandDefects) {
		return batchInsert(false, tDemandDefects);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<TDemandDefect> tDemandDefect) {
		if (CollectionUtil.isEmpty(tDemandDefect)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tDemandDefect, new UpdateGenerateCallback<TDemandDefect>() {
			public Update generate(TDemandDefect t) {
				return update(T_DEMAND_DEFECT_TABLE).set(T_DEMAND_DEFECT_TABLE.SUB_PLANN_ID.value(t.getSubPlannId()),
						T_DEMAND_DEFECT_TABLE.SUB_PLANN_NAME.value(t.getSubPlannName()),
						T_DEMAND_DEFECT_TABLE.HAPPEN_DATE.value(t.getHappenDate()),
						T_DEMAND_DEFECT_TABLE.PROBLEM_PHENOMENON.value(t.getProblemPhenomenon()),
						T_DEMAND_DEFECT_TABLE.PROBLEM_DESCRIBE.value(t.getProblemDescribe()),
						T_DEMAND_DEFECT_TABLE.PROBLEM_SOLUTION.value(t.getProblemSolution()),
						T_DEMAND_DEFECT_TABLE.WORKPLAN_CREATE_DATE.value(t.getWorkplanCreateDate()),
						T_DEMAND_DEFECT_TABLE.CREATE_USER.value(t.getCreateUser()),
						T_DEMAND_DEFECT_TABLE.UPDATE_DATE.value(t.getUpdateDate()),
						T_DEMAND_DEFECT_TABLE.UPDATE_USER.value(t.getUpdateUser()),
						T_DEMAND_DEFECT_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						T_DEMAND_DEFECT_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						T_DEMAND_DEFECT_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						T_DEMAND_DEFECT_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						T_DEMAND_DEFECT_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				).where(T_DEMAND_DEFECT_TABLE.ID.eq(t.getId()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<TDemandDefect> tDemandDefect) {
		if (CollectionUtil.isEmpty(tDemandDefect)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tDemandDefect, new DeleteGenerateCallback<TDemandDefect>() {
			public Delete generate(TDemandDefect t) {
				return delete(T_DEMAND_DEFECT_TABLE).where(and(T_DEMAND_DEFECT_TABLE.ID.eq(t.getId()),
						T_DEMAND_DEFECT_TABLE.SUB_PLANN_ID.eq(t.getSubPlannId()),
						T_DEMAND_DEFECT_TABLE.SUB_PLANN_NAME.eq(t.getSubPlannName()),
						T_DEMAND_DEFECT_TABLE.HAPPEN_DATE.eq(t.getHappenDate()),
						T_DEMAND_DEFECT_TABLE.PROBLEM_PHENOMENON.eq(t.getProblemPhenomenon()),
						T_DEMAND_DEFECT_TABLE.PROBLEM_DESCRIBE.eq(t.getProblemDescribe()),
						T_DEMAND_DEFECT_TABLE.PROBLEM_SOLUTION.eq(t.getProblemSolution()),
						T_DEMAND_DEFECT_TABLE.WORKPLAN_CREATE_DATE.eq(t.getWorkplanCreateDate()),
						T_DEMAND_DEFECT_TABLE.CREATE_USER.eq(t.getCreateUser()),
						T_DEMAND_DEFECT_TABLE.UPDATE_DATE.eq(t.getUpdateDate()),
						T_DEMAND_DEFECT_TABLE.UPDATE_USER.eq(t.getUpdateUser()),
						T_DEMAND_DEFECT_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						T_DEMAND_DEFECT_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						T_DEMAND_DEFECT_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						T_DEMAND_DEFECT_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						T_DEMAND_DEFECT_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<TDemandDefect> tDemandDefect) {
		if (CollectionUtil.isEmpty(tDemandDefect)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tDemandDefect, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(T_DEMAND_DEFECT_TABLE)
						.values(T_DEMAND_DEFECT_TABLE.SUB_PLANN_ID.value(new JdbcNamedParameter("subPlannId")),
								T_DEMAND_DEFECT_TABLE.SUB_PLANN_NAME.value(new JdbcNamedParameter("subPlannName")),
								T_DEMAND_DEFECT_TABLE.HAPPEN_DATE.value(new JdbcNamedParameter("happenDate")),
								T_DEMAND_DEFECT_TABLE.PROBLEM_PHENOMENON
										.value(new JdbcNamedParameter("problemPhenomenon")),
								T_DEMAND_DEFECT_TABLE.PROBLEM_DESCRIBE.value(new JdbcNamedParameter("problemDescribe")),
								T_DEMAND_DEFECT_TABLE.PROBLEM_SOLUTION.value(new JdbcNamedParameter("problemSolution")),
								T_DEMAND_DEFECT_TABLE.WORKPLAN_CREATE_DATE
										.value(new JdbcNamedParameter("workplanCreateDate")),
								T_DEMAND_DEFECT_TABLE.CREATE_USER.value(new JdbcNamedParameter("createUser")),
								T_DEMAND_DEFECT_TABLE.UPDATE_DATE.value(new JdbcNamedParameter("updateDate")),
								T_DEMAND_DEFECT_TABLE.UPDATE_USER.value(new JdbcNamedParameter("updateUser")),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<TDemandDefect> tDemandDefect) {
		if (CollectionUtil.isEmpty(tDemandDefect)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(tDemandDefect, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(T_DEMAND_DEFECT_TABLE)
						.set(T_DEMAND_DEFECT_TABLE.SUB_PLANN_ID.value(new JdbcNamedParameter("subPlannId")),
								T_DEMAND_DEFECT_TABLE.SUB_PLANN_NAME.value(new JdbcNamedParameter("subPlannName")),
								T_DEMAND_DEFECT_TABLE.HAPPEN_DATE.value(new JdbcNamedParameter("happenDate")),
								T_DEMAND_DEFECT_TABLE.PROBLEM_PHENOMENON
										.value(new JdbcNamedParameter("problemPhenomenon")),
								T_DEMAND_DEFECT_TABLE.PROBLEM_DESCRIBE.value(new JdbcNamedParameter("problemDescribe")),
								T_DEMAND_DEFECT_TABLE.PROBLEM_SOLUTION.value(new JdbcNamedParameter("problemSolution")),
								T_DEMAND_DEFECT_TABLE.WORKPLAN_CREATE_DATE
										.value(new JdbcNamedParameter("workplanCreateDate")),
								T_DEMAND_DEFECT_TABLE.CREATE_USER.value(new JdbcNamedParameter("createUser")),
								T_DEMAND_DEFECT_TABLE.UPDATE_DATE.value(new JdbcNamedParameter("updateDate")),
								T_DEMAND_DEFECT_TABLE.UPDATE_USER.value(new JdbcNamedParameter("updateUser")),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

						).where(T_DEMAND_DEFECT_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<TDemandDefect> tDemandDefect) {
		if (CollectionUtil.isEmpty(tDemandDefect)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(tDemandDefect, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(T_DEMAND_DEFECT_TABLE)
						.where(and(T_DEMAND_DEFECT_TABLE.SUB_PLANN_ID.eq(new JdbcNamedParameter("subPlannId")),
								T_DEMAND_DEFECT_TABLE.SUB_PLANN_NAME.eq(new JdbcNamedParameter("subPlannName")),
								T_DEMAND_DEFECT_TABLE.HAPPEN_DATE.eq(new JdbcNamedParameter("happenDate")),
								T_DEMAND_DEFECT_TABLE.PROBLEM_PHENOMENON
										.eq(new JdbcNamedParameter("problemPhenomenon")),
								T_DEMAND_DEFECT_TABLE.PROBLEM_DESCRIBE.eq(new JdbcNamedParameter("problemDescribe")),
								T_DEMAND_DEFECT_TABLE.PROBLEM_SOLUTION.eq(new JdbcNamedParameter("problemSolution")),
								T_DEMAND_DEFECT_TABLE.WORKPLAN_CREATE_DATE
										.eq(new JdbcNamedParameter("workplanCreateDate")),
								T_DEMAND_DEFECT_TABLE.CREATE_USER.eq(new JdbcNamedParameter("createUser")),
								T_DEMAND_DEFECT_TABLE.UPDATE_DATE.eq(new JdbcNamedParameter("updateDate")),
								T_DEMAND_DEFECT_TABLE.UPDATE_USER.eq(new JdbcNamedParameter("updateUser")),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_1.eq(new JdbcNamedParameter("extField1")),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_2.eq(new JdbcNamedParameter("extField2")),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_3.eq(new JdbcNamedParameter("extField3")),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_4.eq(new JdbcNamedParameter("extField4")),
								T_DEMAND_DEFECT_TABLE.EXT_FIELD_5.eq(new JdbcNamedParameter("extField5"))

				));
			}
		});
	}

	public int[] preparedBatchInsert(List<TDemandDefect> tDemandDefect) {
		return preparedBatchInsert(false, tDemandDefect);
	}

	@Override
	public List<TDemandDefect> getUserDemandDefectList(TDemandDefect tdemandDefect) {
		if(tdemandDefect == null){
			tdemandDefect = new TDemandDefect();
		}
		return getDslTemplate().query(tdemandDefect,new SelectGenerateCallback<TDemandDefect>(){
			@Override
			public Select generate(TDemandDefect t) {
				// TODO Auto-generated method stub
				return Select.selectFrom(T_DEMAND_DEFECT_TABLE)
						.where(T_DEMAND_DEFECT_TABLE.EXT_FIELD_1.eq(t.getExtField_1()));
			}
			
		});
	}

	@Override
	public List<TDemandDefect> getFinishUserDemandDefectList(TDemandDefect tdemandDefect) {
		if(tdemandDefect == null){
			tdemandDefect = new TDemandDefect();
		}
		return getDslTemplate().query(tdemandDefect,new SelectGenerateCallback<TDemandDefect>(){
			@Override
			public Select generate(TDemandDefect t) {
				// TODO Auto-generated method stub
				return Select.selectFrom(T_DEMAND_DEFECT_TABLE)
						.where(and(T_DEMAND_DEFECT_TABLE.EXT_FIELD_1.eq(t.getExtField_1())
								,T_DEMAND_DEFECT_TABLE.EXT_FIELD_2.eq(t.getExtField_2())));
			}
			
		});
	}

}
