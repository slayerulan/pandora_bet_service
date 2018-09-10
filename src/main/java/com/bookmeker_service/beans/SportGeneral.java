package com.bookmeker_service.beans;

import java.util.Map;

public class SportGeneral extends SportAbstract{
	
	private Map<Integer, LeagueAbstract> leagues;
	
	public SportGeneral() {
		super();
	}

	public SportGeneral(int id, String name, String urlName, String json) {
		super(id, name, urlName, json);
	}

	

	public Map<Integer, LeagueAbstract> getLeagues() {
		return leagues;
	}

	public void setLeagues(Map<Integer, LeagueAbstract> leagues) {
		this.leagues = leagues;
	}

	@Override
	public String toString() {
		return super.toString() + ";leagues=" + leagues;
	}
}
