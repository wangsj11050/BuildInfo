package org.tinygroup.buildinfo.service.inter.dto.complex;

import java.io.Serializable;

/**
 * 权限关联查询需要用到的dto
 * Created by Mr.wang on 2016/7/23.
 */
public class TRightRefDto implements Serializable{
    /**
	 * long
	 */
	private static final long serialVersionUID = 1030816682686180487L;

	private String subTransCode;

    private String subTransName;

    private String transCode;

    private String transName;

    private String modelCode;
    
    private String kindCode;

    private Integer id;

	public String getKindCode() {
		return kindCode;
	}

	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}

	public String getSubTransCode() {
        return subTransCode;
    }

    public void setSubTransCode(String subTransCode) {
        this.subTransCode = subTransCode;
    }

    public String getSubTransName() {
        return subTransName;
    }

    public void setSubTransName(String subTransName) {
        this.subTransName = subTransName;
    }

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
