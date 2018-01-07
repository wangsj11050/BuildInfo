package org.tinygroup.buildinfo.service.inter.dto;

import java.io.Serializable;

/**
 * Created by Mr.wang on 2016/7/11.
 */
public class OrgDto implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6571686615230999289L;

	private Integer orgId;

    private String orgName;

    private Integer parentId;

    private Integer sortNum;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }
}
