package org.tinygroup.buildinfo.common.dto.biz;

/**
 * Created by Mr.wang on 2016/7/31.
 */
public class SysMenuExt {
    /**
     * id
     */
    private Integer id;

     /**
     * <!-- begin-user-doc --> 菜单名称 * <!-- end-user-doc -->
     */
    private String menuName;

    /**
     * <!-- begin-user-doc --> 菜单图标 * <!-- end-user-doc -->
     */
    private String menuIcon;

    /**
     * <!-- begin-user-doc --> 上级 * <!-- end-user-doc -->
     */
    private String parentCode;

    /**
     * <!-- begin-user-doc --> 序号 * <!-- end-user-doc -->
     */
    private Integer orderNo;

    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
