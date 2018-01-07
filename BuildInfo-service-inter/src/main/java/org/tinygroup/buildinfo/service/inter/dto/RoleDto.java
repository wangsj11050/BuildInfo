package org.tinygroup.buildinfo.service.inter.dto;

import java.io.Serializable;

/**
 * Created by Mr.wang on 2016/7/6.
 */
public class RoleDto implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2643012513874161865L;

	private Integer id;

    private String name;

    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
