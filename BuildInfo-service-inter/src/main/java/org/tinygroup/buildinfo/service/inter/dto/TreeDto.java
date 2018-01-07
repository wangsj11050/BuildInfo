package org.tinygroup.buildinfo.service.inter.dto;

import java.io.Serializable;

public class TreeDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2862595555865721356L;
	private String id;
	private String pId;
	private String name;
	private String disableClick;
	private String disableSub;
	
	public String getDisableClick() {
		return disableClick;
	}
	public void setDisableClick(String disableClick) {
		this.disableClick = disableClick;
	}
	public String getDisableSub() {
		return disableSub;
	}
	public void setDisableSub(String disableSub) {
		this.disableSub = disableSub;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
