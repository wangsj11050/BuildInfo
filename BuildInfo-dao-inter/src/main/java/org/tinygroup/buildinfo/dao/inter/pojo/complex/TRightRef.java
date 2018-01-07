package org.tinygroup.buildinfo.dao.inter.pojo.complex;


/**
 * Created by Mr.wang on 2016/7/23.
 */
public class TRightRef {

    private String modelCode;

    private String kindCode;

    private Integer id;

    private Integer menuId;

    private String menuName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
