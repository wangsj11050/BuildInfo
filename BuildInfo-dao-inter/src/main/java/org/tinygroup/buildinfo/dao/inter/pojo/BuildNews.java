
package org.tinygroup.buildinfo.dao.inter.pojo;

/**
 * <!-- begin-user-doc --> 新闻动态 * <!-- end-user-doc -->
 */
public class BuildNews {

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 新闻标题 * <!-- end-user-doc -->
	 */
	private String newsName;

	/**
	 * <!-- begin-user-doc --> 发布时间 * <!-- end-user-doc -->
	 */
	private String pubDate;

	private String newsDesc;
	/**
	 * <!-- begin-user-doc --> 新闻类别 * <!-- end-user-doc -->
	 */
	private String newsType;

	/**
	 * <!-- begin-user-doc --> 新闻内容 * <!-- end-user-doc -->
	 */
	private String newsContent;

	/**
	 * <!-- begin-user-doc --> 是否热点新闻 * <!-- end-user-doc -->
	 */
	private String isHot;

	/**
	 * <!-- begin-user-doc --> 新闻图片 * <!-- end-user-doc -->
	 */
	private String newsImg;

	/**
	 * <!-- begin-user-doc --> 扩展字段1 * <!-- end-user-doc -->
	 */
	private String extField_1;

	/**
	 * <!-- begin-user-doc --> 扩展字段2 * <!-- end-user-doc -->
	 */
	private String extField_2;

	/**
	 * <!-- begin-user-doc --> 扩展字段3 * <!-- end-user-doc -->
	 */
	private String extField_3;

	/**
	 * <!-- begin-user-doc --> 扩展字段4 * <!-- end-user-doc -->
	 */
	private String extField_4;

	/**
	 * <!-- begin-user-doc --> 扩展字段5 * <!-- end-user-doc -->
	 */
	private String extField_5;

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> 新闻标题 * <!-- end-user-doc -->
	 */
	public void setNewsName(String newsName) {
		this.newsName = newsName;
	}

	public String getNewsName() {
		return newsName;
	}

	/**
	 * <!-- begin-user-doc --> 发布时间 * <!-- end-user-doc -->
	 */
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getPubDate() {
		return pubDate;
	}

	public String getNewsDesc() {
		return newsDesc;
	}

	public void setNewsDesc(String newsDesc) {
		this.newsDesc = newsDesc;
	}

	/**
	 * <!-- begin-user-doc --> 新闻类别 * <!-- end-user-doc -->
	 */
	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}

	public String getNewsType() {
		return newsType;
	}

	/**
	 * <!-- begin-user-doc --> 新闻内容 * <!-- end-user-doc -->
	 */
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getNewsContent() {
		return newsContent;
	}

	/**
	 * <!-- begin-user-doc --> 是否热点新闻 * <!-- end-user-doc -->
	 */
	public void setIsHot(String isHot) {
		this.isHot = isHot;
	}

	public String getIsHot() {
		return isHot;
	}

	/**
	 * <!-- begin-user-doc --> 新闻图片 * <!-- end-user-doc -->
	 */
	public void setNewsImg(String newsImg) {
		this.newsImg = newsImg;
	}

	public String getNewsImg() {
		return newsImg;
	}

	public String getExtField_1() {
		return extField_1;
	}

	public void setExtField_1(String extField_1) {
		this.extField_1 = extField_1;
	}

	public String getExtField_2() {
		return extField_2;
	}

	public void setExtField_2(String extField_2) {
		this.extField_2 = extField_2;
	}

	public String getExtField_3() {
		return extField_3;
	}

	public void setExtField_3(String extField_3) {
		this.extField_3 = extField_3;
	}

	public String getExtField_4() {
		return extField_4;
	}

	public void setExtField_4(String extField_4) {
		this.extField_4 = extField_4;
	}

	public String getExtField_5() {
		return extField_5;
	}

	public void setExtField_5(String extField_5) {
		this.extField_5 = extField_5;
	}

	

}
