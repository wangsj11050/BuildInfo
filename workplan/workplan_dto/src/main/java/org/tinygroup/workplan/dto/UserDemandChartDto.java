package org.tinygroup.workplan.dto;

import java.io.Serializable;

public class UserDemandChartDto implements Serializable {

	private static final long serialVersionUID = -1145711322335650553L;

	private String name;
	
	private Integer y;
	
	private String id;
	
	private boolean drilldown = true;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public boolean isDrilldown() {
		return drilldown;
	}

	public void setDrilldown(boolean drilldown) {
		this.drilldown = drilldown;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
