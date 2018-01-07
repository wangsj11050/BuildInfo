package org.tinygroup.buildinfo.dao.inter.pojo.complex;

import org.tinygroup.buildinfo.dao.inter.pojo.TsysUser;

/**
 * Created by Mr.wang on 2016/7/24.
 */
public class TsysUserAllInfo extends TsysUser {
    private String branchName;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
