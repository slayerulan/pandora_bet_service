package com.bookmeker_service.beans;

public abstract class EventAbstract {
	
	private int id;
	private String fullName;
	private String urlName;
	private String json;
	public EventAbstract() {
		super();
	}
	public EventAbstract(int id, String fullName, String urlName, String json) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.urlName = urlName;
		this.json = json;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUrlName() {
		return urlName;
	}
	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	@Override
	public String toString() {
		return "id=" + id + ";fullName=" + fullName + ";urlName=" + urlName;
	}
	
	

}
