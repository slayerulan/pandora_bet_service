package com.bookmeker_service.data_builders;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
//import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.JsonReader;
import com.bookmeker_service.beans.EventGeneral;
import com.bookmeker_service.beans.LeagueGeneral;
import com.bookmeker_service.beans.SportGeneral;
import com.bookmeker_service.connections.ConnectService;
import com.bookmeker_service.interfaces.IDataBuilder;

public class IXBetBuilder implements IDataBuilder{
	
	/*<<<<<<<<<<<<<<<<<<<<<<<<<    Constants    >>>>>>>>>>>>>>>>>>>>>>*/
	public static final String URL_ALL_SPORTS_TYPES = "https://1xbet.com/LineFeed/GetSportsShortZip?tf=1500000&country=1&virtualSports=true";
	public static final String URL_SPORT_LEAGUES = "https://1xbet.com/LineFeed/GetSportsShortZip?sports=%s&tf=1500000&country=1&virtualSports=true";
	public static final String URL_SPORT_LEAGUE_EVENTS = "https://1xbet.com/LineFeed/GetChampZip?sport=%s&champ=%s&tf=1500000&country=1&virtualSports=true";
	public static final String URL_SPORT_MARKET = "https://1xbet.com/LineFeed/GetGameZip?id=%s&lng=ru&cfview=0&isSubGames=true&GroupEvents=true&allEventsGroupSubGames=true&countevents=250&grMode=2";
	
	//Sport
	public static final String J_ID_SPORT = "I";
	public static final String J_COUNT_SPORT ="C";
	public static final String J_TITLE_SPORT_EN = "E";
	public static final String J_TITLE_SPORT_RU = "N";
	public static final String J_MS_SPORT = "MS";
	
	//Liga
	public static final String J_ID_LIGA = "LI";
	public static final String J_COUNT_LIGA ="GC";
	public static final String J_TITLE_LIGA_EN = "LE";
	public static final String J_TITLE_LIGA_RU = "L";
	public static final String J_CI_LIGA = "CI";
	public static final String J_T_LIGA = "T";
	public static final String J_LEAGUE_ARRAY = "L";
	
	//Match
	public static final String J_EVENTS_ARRAY = "G";
	public static final String J_ID_EVENT = "CI";
	public static final String J_TITLE_TEAM1_RU_EVENT ="O1";
	public static final String J_TITLE_TEAM1_EN_EVENT = "O1E";
	public static final String J_TITLE_TEAM2_RU_EVENT = "O2";
	public static final String J_TITLE_TEAM2_EN_EVENT = "O2E";
	//Bets
	public static final String J_BETS_OBJECT = "G";
	public static final String J_BETS_ARRAY = "GE";
	public static final String J_ID_BETS = "CI";
	public static final String J_G_INDEX_BETS ="G";
	public static final String J_ARRAY_OF_BETS = "E";
	public static final String J_BET_VALUE_BETS = "C";
	public static final String J_VALUE = "Value";

	/*<<<<<<<<<<<<<<<<<<<<<<<<<    private fields    >>>>>>>>>>>>>>>>>>>>>>*/
	private BuilderEntity builder;
	private ConnectService cs;
	private JsonReader reader;
	private JsonObject jsonObject;

	public IXBetBuilder() {
		super();
		this.builder = new BuilderEntity();
		this.cs = new ConnectService();
	}

	@Override
	public SportGeneral getSingleSport(JsonObject jsonObject) {
		return null;
	}

	@Override
	public Map<Integer, SportGeneral> getListSports() {
		String json = cs.sendGETRequest(URL_ALL_SPORTS_TYPES);
		reader = Json.createReader(new StringReader(json));;
	    jsonObject = reader.readObject();
		Map<Integer, SportGeneral> sportList = new HashMap<Integer, SportGeneral>();
		
    	for(JsonValue value: jsonObject.getJsonArray(J_VALUE)) {
    		JsonObject obj = value.asJsonObject();
    		if(obj.containsKey(J_MS_SPORT)) {
    	    	//this.ms = jsonObject.getInt(J_MS_SPORT_1XBET);
    	    }else {
    	    	sportList.put(obj.getInt(J_ID_SPORT), 
								builder.getSportGeneral(obj.getInt(J_ID_SPORT),
		    	    			    		  obj.getString(J_TITLE_SPORT_EN),
		    	    			    		  null,
		    	    			    		  obj.toString()));
    	    }	
	    }
		return sportList;
	}

	@Override
	public LeagueGeneral getSingleLeague(JsonObject jsonObject) {
		
		return null;
	}

	@Override
	public Map<Integer, LeagueGeneral> getListLeagues(String sportId) {
		String json = cs.sendGETRequest(String.format(URL_SPORT_LEAGUES, sportId));
		JsonReader reader = Json.createReader(new StringReader(json));;
	    JsonObject jsonObject = reader.readObject();
		Map<Integer, LeagueGeneral> leagueList = new HashMap<Integer, LeagueGeneral>();
		JsonObject sportObject = getSportObject(jsonObject, sportId);
		
		if(sportObject.containsKey(J_LEAGUE_ARRAY)) {
			for(JsonValue value: sportObject.getJsonArray(J_LEAGUE_ARRAY)) {
				JsonObject obj = value.asJsonObject();
				leagueList.put(obj.getInt(J_ID_LIGA), 
								builder.getLeagueGeneral(obj.getInt(J_ID_LIGA),
		    	    			    		  obj.getString(J_TITLE_LIGA_EN),
		    	    			    		  null,
		    	    			    		  obj.toString()));
			}
		}
		return leagueList;
	}

	private JsonObject getSportObject(JsonObject jsonObject, String sportId) {
		JsonObject sportObject = null;
		for(JsonValue values: jsonObject.getJsonArray(J_VALUE)) {
			JsonObject obj = values.asJsonObject();
			if(obj.getString(J_ID_SPORT) == sportId) {
				return obj;	
			}
		}
		return sportObject;
	}

	@Override
	public EventGeneral getSingleEvent(JsonObject jsonObject) {
		return null;
	}

	@Override
	public Map<Integer, EventGeneral> getListEvents(String sportId, String leagueId) {
		String json = cs.sendGETRequest(String.format(URL_SPORT_LEAGUE_EVENTS, sportId, leagueId));
		JsonReader reader = Json.createReader(new StringReader(json));;
	    JsonObject jsonObject = reader.readObject();
		Map<Integer, EventGeneral> eventList = new HashMap<Integer, EventGeneral>();

    	for(JsonValue value: jsonObject.getJsonObject(J_VALUE).getJsonArray(J_EVENTS_ARRAY)) {
			JsonObject obj = value.asJsonObject();
    	    eventList.put(obj.getInt(J_ID_EVENT), 
    	    			    builder.getEventGeneral(obj.getInt(J_ID_EVENT),
											  obj.containsKey(J_TITLE_TEAM2_EN_EVENT) ? 
												obj.getString(J_TITLE_TEAM1_EN_EVENT) + " vs " + 
												obj.getString(J_TITLE_TEAM2_EN_EVENT) : 
												obj.getString(J_TITLE_TEAM1_EN_EVENT),
		    	    			    		  null,
		    	    			    		  obj.toString()));
	    }
    	return eventList;
	}

}
