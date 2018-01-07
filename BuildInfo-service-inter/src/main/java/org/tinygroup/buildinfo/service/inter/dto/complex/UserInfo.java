package org.tinygroup.buildinfo.service.inter.dto.complex;

import java.io.Serializable;

/**
 * 用户登录信息
 * Created by Mr.wang on 2016/7/30.
 */
public class UserInfo implements Serializable{
    /**
     *
     */

    /**
     * <!-- begin-user-doc --> 用户代码 * <!-- end-user-doc -->
     */
    private String userId;

    /**
     * <!-- begin-user-doc --> 机构编号 * <!-- end-user-doc -->
     */
    private String branchCode;

    /**
     * <!-- begin-user-doc --> 部门编号 * <!-- end-user-doc -->
     */
    private String depCode;

    /**
     * <!-- begin-user-doc --> 用户名称 * <!-- end-user-doc -->
     */
    private String userName;

    /**
     * <!-- begin-user-doc --> 用户状态 * <!-- end-user-doc -->
     */
    private String userStatus;


    /**
     * <!-- begin-user-doc --> 授权级别 * <!-- end-user-doc -->
     */
    private String authLevel;

    /**
     * <!-- begin-user-doc --> 个性化主页 * <!-- end-user-doc -->
     */
    private String homePage;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getAuthLevel() {
        return authLevel;
    }

    public void setAuthLevel(String authLevel) {
        this.authLevel = authLevel;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }
}
