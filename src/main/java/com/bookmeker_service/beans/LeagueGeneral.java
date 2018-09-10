package com.bookmeker_service.beans;

import java.util.Map;

public class LeagueGeneral extends LeagueAbstract{
    
    Map<Integer, EventGeneral> events;

    public LeagueGeneral() {
        super();
    }

    public LeagueGeneral(int id, String name, String nameUrl, String json) {
        super(id, name, nameUrl, json);
    }

    public void setEvents(Map<Integer, EventGeneral> events) {
        this.events = events;
    }
    
    public Map<Integer, EventGeneral> getEvents() {
        return this.events;
    }

	@Override
	public String toString() {
		return super.toString() + ";events=" + events;
	}
}
