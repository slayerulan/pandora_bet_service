package com.bookmeker_service.interfaces;

import java.util.Map;
import javax.json.JsonObject;

import com.bookmeker_service.beans.EventGeneral;
import com.bookmeker_service.beans.LeagueGeneral;
import com.bookmeker_service.beans.SportGeneral;

public interface IDataBuilder {
	
	SportGeneral getSingleSport(JsonObject jsonObject);
	
	Map<Integer, SportGeneral> getListSports();
	
	LeagueGeneral getSingleLeague(JsonObject jsonObject);
	
	Map<Integer, LeagueGeneral> getListLeagues(String sportId);
	
	EventGeneral getSingleEvent(JsonObject jsonObject);
	
	Map<Integer, EventGeneral> getListEvents(String sportId, String leagueId);
	

}
