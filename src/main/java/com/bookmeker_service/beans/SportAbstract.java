package com.bookmeker_service.beans;

public abstract class SportAbstract {
	
	private int id;
	private String name;
	private String urlName;
	private String json;
	
	public SportAbstract() {
		super();
	}

	public SportAbstract(int id, String name, String urlName, String json) {
		super();
		this.id = id;
		this.name = name;
		this.urlName = urlName;
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
		return "id=" + id + ";name=" + name + ";urlName=" + urlName;
	}
}
