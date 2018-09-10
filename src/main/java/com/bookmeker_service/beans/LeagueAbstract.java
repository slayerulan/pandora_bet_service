package com.bookmeker_service.beans;

public abstract class LeagueAbstract {
	
	private int id;
	private String name;
	private String urlName;
	private String json;
	public LeagueAbstract() {
		super();
	}
	public LeagueAbstract(int id, String name, String nameUrl, String json) {
		super();
		this.id = id;
		this.name = name;
		this.urlName = nameUrl;
		this.json = json;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrlName() {
		return urlName;
	}
	public void setUrlName(String nameUrl) {
		this.urlName = nameUrl;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	@Override
	public String toString() {
		return "id=" + id + ";name=" + name + ";urlName=" + urlName;
	}
	
	

}
