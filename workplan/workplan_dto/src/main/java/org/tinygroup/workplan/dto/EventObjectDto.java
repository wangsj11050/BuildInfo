package org.tinygroup.workplan.dto;

import java.io.Serializable;
import java.util.Date;

public class EventObjectDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2795984833630340041L;

	private Integer id;
	
	private String title;
	
	private boolean allDay;
	
	private String start;
	
	private String end;
	
	private String backgroundColor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
}
