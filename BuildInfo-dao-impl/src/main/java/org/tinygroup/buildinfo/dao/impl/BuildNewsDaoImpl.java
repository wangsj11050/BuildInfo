
package org.tinygroup.buildinfo.dao.impl;

import static org.tinygroup.buildinfo.dao.inter.constant.BuildNewsTable.BUILD_NEWS_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;

import java.io.Serializable;
import java.util.List;

import org.tinygroup.buildinfo.dao.inter.BuildNewsDao;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildNews;
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
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以在方法或者变量注释中增加@unmodifiable <!--
 * end-user-doc -->
 */
public class BuildNewsDaoImpl extends TinyDslDaoSupport implements BuildNewsDao {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public BuildNews add(BuildNews buildNews) {
		return getDslTemplate().insertAndReturnKey(buildNews, new InsertGenerateCallback<BuildNews>() {
			public Insert generate(BuildNews t) {
				Insert insert = insertInto(BUILD_NEWS_TABLE).values(BUILD_NEWS_TABLE.ID.value(t.getId()),
						BUILD_NEWS_TABLE.NEWS_NAME.value(t.getNewsName()),
						BUILD_NEWS_TABLE.PUB_DATE.value(t.getPubDate()),
						BUILD_NEWS_TABLE.NEWS_DESC.value(t.getNewsDesc()),
						BUILD_NEWS_TABLE.NEWS_TYPE.value(t.getNewsType()),
						BUILD_NEWS_TABLE.NEWS_CONTENT.value(t.getNewsContent()),
						BUILD_NEWS_TABLE.IS_HOT.value(t.getIsHot()), BUILD_NEWS_TABLE.NEWS_IMG.value(t.getNewsImg()),
						BUILD_NEWS_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						BUILD_NEWS_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						BUILD_NEWS_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						BUILD_NEWS_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						BUILD_NEWS_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
				return insert;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int edit(BuildNews buildNews) {
		if (buildNews == null || buildNews.getId() == null) {
			return 0;
		}
		return getDslTemplate().update(buildNews, new UpdateGenerateCallback<BuildNews>() {
			public Update generate(BuildNews t) {
				Update update = update(BUILD_NEWS_TABLE).set(BUILD_NEWS_TABLE.NEWS_NAME.value(t.getNewsName()),
						BUILD_NEWS_TABLE.PUB_DATE.value(t.getPubDate()),
						BUILD_NEWS_TABLE.NEWS_DESC.value(t.getNewsDesc()),
						BUILD_NEWS_TABLE.NEWS_TYPE.value(t.getNewsType()),
						BUILD_NEWS_TABLE.NEWS_CONTENT.value(t.getNewsContent()),
						BUILD_NEWS_TABLE.IS_HOT.value(t.getIsHot()), BUILD_NEWS_TABLE.NEWS_IMG.value(t.getNewsImg()),
						BUILD_NEWS_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						BUILD_NEWS_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						BUILD_NEWS_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						BUILD_NEWS_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						BUILD_NEWS_TABLE.EXT_FIELD_5.value(t.getExtField_5())).where(BUILD_NEWS_TABLE.ID.eq(t.getId()));
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
				return delete(BUILD_NEWS_TABLE).where(BUILD_NEWS_TABLE.ID.eq(pk));
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
				return delete(BUILD_NEWS_TABLE).where(BUILD_NEWS_TABLE.ID.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public BuildNews getByKey(Integer pk) {
		return getDslTemplate().getByKey(pk, BuildNews.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(BUILD_NEWS_TABLE).where(BUILD_NEWS_TABLE.ID.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public List<BuildNews> query(BuildNews buildNews, final OrderBy... orderArgs) {
		if (buildNews == null) {
			buildNews = new BuildNews();
		}
		return getDslTemplate().query(buildNews, new SelectGenerateCallback<BuildNews>() {
			@SuppressWarnings("rawtypes")
			public Select generate(BuildNews t) {
				Select select = selectFrom(BUILD_NEWS_TABLE).where(and(BUILD_NEWS_TABLE.ID.eq(t.getId()),
						BUILD_NEWS_TABLE.NEWS_NAME.eq(t.getNewsName()), BUILD_NEWS_TABLE.PUB_DATE.eq(t.getPubDate()),
						BUILD_NEWS_TABLE.NEWS_DESC.eq(t.getNewsDesc()),BUILD_NEWS_TABLE.NEWS_TYPE.eq(t.getNewsType()),
						BUILD_NEWS_TABLE.NEWS_CONTENT.eq(t.getNewsContent()), BUILD_NEWS_TABLE.IS_HOT.eq(t.getIsHot()),
						BUILD_NEWS_TABLE.NEWS_IMG.eq(t.getNewsImg()), BUILD_NEWS_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						BUILD_NEWS_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						BUILD_NEWS_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						BUILD_NEWS_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						BUILD_NEWS_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public Pager<BuildNews> queryPager(int start, int limit, BuildNews buildNews, final OrderBy... orderArgs) {
		if (buildNews == null) {
			buildNews = new BuildNews();
		}
		return getDslTemplate().queryPager(start, limit, buildNews, false, new SelectGenerateCallback<BuildNews>() {
			public Select generate(BuildNews t) {
				Select select = Select.selectFrom(BUILD_NEWS_TABLE).where(and(BUILD_NEWS_TABLE.ID.eq(t.getId()),
						BUILD_NEWS_TABLE.NEWS_NAME.eq(t.getNewsName()), BUILD_NEWS_TABLE.PUB_DATE.eq(t.getPubDate()),
						BUILD_NEWS_TABLE.NEWS_DESC.eq(t.getNewsDesc()),BUILD_NEWS_TABLE.NEWS_TYPE.eq(t.getNewsType()),
						BUILD_NEWS_TABLE.NEWS_CONTENT.eq(t.getNewsContent()), BUILD_NEWS_TABLE.IS_HOT.eq(t.getIsHot()),
						BUILD_NEWS_TABLE.NEWS_IMG.eq(t.getNewsImg()), BUILD_NEWS_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						BUILD_NEWS_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						BUILD_NEWS_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						BUILD_NEWS_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						BUILD_NEWS_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<BuildNews> buildNews) {
		if (CollectionUtil.isEmpty(buildNews)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, buildNews, new InsertGenerateCallback<BuildNews>() {

			public Insert generate(BuildNews t) {
				return insertInto(BUILD_NEWS_TABLE).values(BUILD_NEWS_TABLE.ID.value(t.getId()),
						BUILD_NEWS_TABLE.NEWS_NAME.value(t.getNewsName()),
						BUILD_NEWS_TABLE.PUB_DATE.value(t.getPubDate()),
						BUILD_NEWS_TABLE.NEWS_DESC.value(t.getNewsDesc()),
						BUILD_NEWS_TABLE.NEWS_TYPE.value(t.getNewsType()),
						BUILD_NEWS_TABLE.NEWS_CONTENT.value(t.getNewsContent()),
						BUILD_NEWS_TABLE.IS_HOT.value(t.getIsHot()), BUILD_NEWS_TABLE.NEWS_IMG.value(t.getNewsImg()),
						BUILD_NEWS_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						BUILD_NEWS_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						BUILD_NEWS_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						BUILD_NEWS_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						BUILD_NEWS_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchInsert(List<BuildNews> buildNewss) {
		return batchInsert(true, buildNewss);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchUpdate(List<BuildNews> buildNews) {
		if (CollectionUtil.isEmpty(buildNews)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(buildNews, new UpdateGenerateCallback<BuildNews>() {
			public Update generate(BuildNews t) {
				return update(BUILD_NEWS_TABLE).set(BUILD_NEWS_TABLE.NEWS_NAME.value(t.getNewsName()),
						BUILD_NEWS_TABLE.PUB_DATE.value(t.getPubDate()),
						BUILD_NEWS_TABLE.NEWS_DESC.value(t.getNewsDesc()),
						BUILD_NEWS_TABLE.NEWS_TYPE.value(t.getNewsType()),
						BUILD_NEWS_TABLE.NEWS_CONTENT.value(t.getNewsContent()),
						BUILD_NEWS_TABLE.IS_HOT.value(t.getIsHot()), BUILD_NEWS_TABLE.NEWS_IMG.value(t.getNewsImg()),
						BUILD_NEWS_TABLE.EXT_FIELD_1.value(t.getExtField_1()),
						BUILD_NEWS_TABLE.EXT_FIELD_2.value(t.getExtField_2()),
						BUILD_NEWS_TABLE.EXT_FIELD_3.value(t.getExtField_3()),
						BUILD_NEWS_TABLE.EXT_FIELD_4.value(t.getExtField_4()),
						BUILD_NEWS_TABLE.EXT_FIELD_5.value(t.getExtField_5())

				).where(BUILD_NEWS_TABLE.ID.eq(t.getId()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] batchDelete(List<BuildNews> buildNews) {
		if (CollectionUtil.isEmpty(buildNews)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(buildNews, new DeleteGenerateCallback<BuildNews>() {
			public Delete generate(BuildNews t) {
				return delete(BUILD_NEWS_TABLE).where(and(BUILD_NEWS_TABLE.ID.eq(t.getId()),
						BUILD_NEWS_TABLE.NEWS_NAME.eq(t.getNewsName()), BUILD_NEWS_TABLE.PUB_DATE.eq(t.getPubDate()),
						BUILD_NEWS_TABLE.NEWS_DESC.eq(t.getNewsDesc()),BUILD_NEWS_TABLE.NEWS_TYPE.eq(t.getNewsType()),
						BUILD_NEWS_TABLE.NEWS_CONTENT.eq(t.getNewsContent()), BUILD_NEWS_TABLE.IS_HOT.eq(t.getIsHot()),
						BUILD_NEWS_TABLE.NEWS_IMG.eq(t.getNewsImg()), BUILD_NEWS_TABLE.EXT_FIELD_1.eq(t.getExtField_1()),
						BUILD_NEWS_TABLE.EXT_FIELD_2.eq(t.getExtField_2()),
						BUILD_NEWS_TABLE.EXT_FIELD_3.eq(t.getExtField_3()),
						BUILD_NEWS_TABLE.EXT_FIELD_4.eq(t.getExtField_4()),
						BUILD_NEWS_TABLE.EXT_FIELD_5.eq(t.getExtField_5())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<BuildNews> buildNews) {
		if (CollectionUtil.isEmpty(buildNews)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, buildNews, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(BUILD_NEWS_TABLE).values(
						BUILD_NEWS_TABLE.NEWS_NAME.value(new JdbcNamedParameter("newsName")),
						BUILD_NEWS_TABLE.PUB_DATE.value(new JdbcNamedParameter("pubDate")),
						BUILD_NEWS_TABLE.NEWS_DESC.value(new JdbcNamedParameter("newsDesc")),
						BUILD_NEWS_TABLE.NEWS_TYPE.value(new JdbcNamedParameter("newsType")),
						BUILD_NEWS_TABLE.NEWS_CONTENT.value(new JdbcNamedParameter("newsContent")),
						BUILD_NEWS_TABLE.IS_HOT.value(new JdbcNamedParameter("isHot")),
						BUILD_NEWS_TABLE.NEWS_IMG.value(new JdbcNamedParameter("newsImg")),
						BUILD_NEWS_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
						BUILD_NEWS_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
						BUILD_NEWS_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
						BUILD_NEWS_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
						BUILD_NEWS_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchUpdate(List<BuildNews> buildNews) {
		if (CollectionUtil.isEmpty(buildNews)) {
			return new int[0];
		}
		return getDslTemplate().batchUpdate(buildNews, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(BUILD_NEWS_TABLE)
						.set(BUILD_NEWS_TABLE.NEWS_NAME.value(new JdbcNamedParameter("newsName")),
								BUILD_NEWS_TABLE.PUB_DATE.value(new JdbcNamedParameter("pubDate")),
								BUILD_NEWS_TABLE.NEWS_DESC.value(new JdbcNamedParameter("newsDesc")),
								BUILD_NEWS_TABLE.NEWS_TYPE.value(new JdbcNamedParameter("newsType")),
								BUILD_NEWS_TABLE.NEWS_CONTENT.value(new JdbcNamedParameter("newsContent")),
								BUILD_NEWS_TABLE.IS_HOT.value(new JdbcNamedParameter("isHot")),
								BUILD_NEWS_TABLE.NEWS_IMG.value(new JdbcNamedParameter("newsImg")),
								BUILD_NEWS_TABLE.EXT_FIELD_1.value(new JdbcNamedParameter("extField1")),
								BUILD_NEWS_TABLE.EXT_FIELD_2.value(new JdbcNamedParameter("extField2")),
								BUILD_NEWS_TABLE.EXT_FIELD_3.value(new JdbcNamedParameter("extField3")),
								BUILD_NEWS_TABLE.EXT_FIELD_4.value(new JdbcNamedParameter("extField4")),
								BUILD_NEWS_TABLE.EXT_FIELD_5.value(new JdbcNamedParameter("extField5"))

						).where(BUILD_NEWS_TABLE.ID.eq(new JdbcNamedParameter("id")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public int[] preparedBatchDelete(List<BuildNews> buildNews) {
		if (CollectionUtil.isEmpty(buildNews)) {
			return new int[0];
		}

		return getDslTemplate().batchDelete(buildNews, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(BUILD_NEWS_TABLE)
						.where(and(BUILD_NEWS_TABLE.NEWS_NAME.eq(new JdbcNamedParameter("newsName")),
								BUILD_NEWS_TABLE.PUB_DATE.eq(new JdbcNamedParameter("pubDate")),
								BUILD_NEWS_TABLE.NEWS_DESC.eq(new JdbcNamedParameter("newsDesc")),
								BUILD_NEWS_TABLE.NEWS_TYPE.eq(new JdbcNamedParameter("newsType")),
								BUILD_NEWS_TABLE.NEWS_CONTENT.eq(new JdbcNamedParameter("newsContent")),
								BUILD_NEWS_TABLE.IS_HOT.eq(new JdbcNamedParameter("isHot")),
								BUILD_NEWS_TABLE.NEWS_IMG.eq(new JdbcNamedParameter("newsImg")),
								BUILD_NEWS_TABLE.EXT_FIELD_1.eq(new JdbcNamedParameter("extField1")),
								BUILD_NEWS_TABLE.EXT_FIELD_2.eq(new JdbcNamedParameter("extField2")),
								BUILD_NEWS_TABLE.EXT_FIELD_3.eq(new JdbcNamedParameter("extField3")),
								BUILD_NEWS_TABLE.EXT_FIELD_4.eq(new JdbcNamedParameter("extField4")),
								BUILD_NEWS_TABLE.EXT_FIELD_5.eq(new JdbcNamedParameter("extField5"))

				));
			}
		});
	}

	public int[] preparedBatchInsert(List<BuildNews> buildNews) {
		return preparedBatchInsert(true, buildNews);
	}

}
