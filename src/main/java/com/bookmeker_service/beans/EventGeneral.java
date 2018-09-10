package com.bookmeker_service.beans;

import java.util.Map;

public class EventGeneral extends EventAbstract{

    Map<Integer, BetGeneral> bets;

    public EventGeneral() {
        super();
    }

	public EventGeneral(int id, String fullName, String urlName, String json) {
        super(id, fullName, urlName, json);
	}

    public void setBets(Map<Integer, BetGeneral> bets) {
        this.bets = bets;
    }

    public Map<Integer, BetGeneral> getBets() {
        return this.bets;
    }
    
    @Override
	public String toString() {
		return super.toString() + ";bets=" + bets;
	}

}
