package com.bookmeker_service.data_builders;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import com.bookmeker_service.beans.EventGeneral;
import com.bookmeker_service.beans.LeagueGeneral;
import com.bookmeker_service.beans.SportGeneral;
import com.bookmeker_service.connections.ConnectService;
import com.bookmeker_service.interfaces.IDataBuilder;

public class MatchbookBuilder implements IDataBuilder{

	public static String URL_ALL_SPORTS_TYPES = "https://api.matchbook.com/edge/rest/lookups/sports?per-page=50";//get sport types
	public static String URL_ALL_SPORTS_TYPES_POPULAR = "https://api.matchbook.com/edge/rest/popular/sports";//get popular sport types
	public static String URL_SPORT_LEAGUES = "https://api.matchbook.com/edge/rest/navigation?per-page=100";//get list leagues
	public static String URL_SPORT_EVENTS_ALL = "https://api.matchbook.com/edge/rest/events?per-page=100&sport-ids=%s";
	public static String URL_SPORT_LEAGUE_EVENTS = "https://api.matchbook.com/edge/rest/events?per-page=100&sport-ids=%s&category-ids=%s&states=true";
	public static String URL_SPORT_MATCH = "https://api.matchbook.com/edge/rest/events/%s/markets";
	
	public static int J_ID_SOCCER = 15;
	public static String J_SPORTS_ARRAY = "sports";
	//Sport
	public static String J_ID_SPORT = "id";
	public static String J_TITLE_SPORT_EN = "name";
	//Liga
	public static String J_ID_LEAGUE = "id";
	public static String J_SPORT_ID_TITLE ="sport-id";
	public static String J_TITLE_LEAGUE_EN = "name";
	public static String J_LEAGUE_ARRAY = "meta-tags";
	//Events
	public static String J_EVENTS_ARRAY = "events";
	public static String J_ID_MATCH = "event-id";
	public static String J_EVENT_ID = "id";
	public static String J_EVENT_NAME = "name";
	//Bets
	public static String J_BETS_OBJECT_1XBET = "G";
	public static String J_BETS_ARRAY_MATCHBOOK = "markets";
	public static String J_BETS_NAME_MATCHBOOK = "name";
	public static String J_BETS_RUNNERS_MATCHBOOK ="runners";
	public static String J_BETS_PRICES_MATCHBOOK = "prices";
	public static String J_BET_ODDS_MATCHBOOK = "odds";

	private BuilderEntity builder;
	private ConnectService cs;

	public MatchbookBuilder() {
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
		JsonReader reader = Json.createReader(new StringReader(json));;
	    JsonObject jsonObject = reader.readObject();
		Map<Integer, SportGeneral> sportList = new HashMap<Integer, SportGeneral>();
		
    	for(JsonValue value: jsonObject.getJsonArray(J_SPORTS_ARRAY)) {
			JsonObject obj = value.asJsonObject();
    	    sportList.put(obj.getInt(J_ID_SPORT), 
    	    			    builder.getSportGeneral(obj.getInt(J_ID_SPORT),
		    	    			    		  obj.getString(J_TITLE_SPORT_EN),
		    	    			    		  null,
		    	    			    		  obj.toString()));
	    }
    	return sportList;
	}

	@Override
	public LeagueGeneral getSingleLeague(JsonObject jsonObject) {
		return null;
	}

	@Override
	public Map<Integer, LeagueGeneral> getListLeagues(String sportId) {
		String json = cs.sendGETRequest(URL_SPORT_LEAGUES);
		JsonReader reader = Json.createReader(new StringReader(json));;
		JsonArray jsonArray = reader.readArray();
		Map<Integer, LeagueGeneral> leagueList = new HashMap<Integer, LeagueGeneral>();
		//System.out.println(getSportObject(jsonArray, sportId).toString());
		JsonObject jsonObject = getSportObject(jsonArray, sportId);

		for(JsonValue values: jsonObject.getJsonArray(J_LEAGUE_ARRAY)) {
			JsonObject objs = values.asJsonObject();
			String name = objs.getString(J_TITLE_LEAGUE_EN);
			for(JsonValue value: objs.getJsonArray(J_LEAGUE_ARRAY)) {
				JsonObject obj = value.asJsonObject();
				leagueList.put(obj.getInt(J_ID_LEAGUE), 
								builder.getLeagueGeneral(obj.getInt(J_ID_LEAGUE),
		    	    			    		  name + ". " + obj.getString(J_TITLE_LEAGUE_EN),
		    	    			    		  null,
		    	    			    		  obj.toString()));
			}
		}
		return leagueList;
	}

	private JsonObject getSportObject(JsonArray jsonArray, String sportId) {
		JsonObject sportObject = null;
		for(JsonValue values: jsonArray) {
			JsonObject objs = values.asJsonObject();
			if(objs.getString("name").equals("Sport")) {
				for(JsonValue value: objs.getJsonArray(J_LEAGUE_ARRAY)) {
					JsonObject obj = value.asJsonObject();
					if(obj.getString(J_ID_SPORT) == sportId) {
						System.out.println(obj.getInt(J_ID_SPORT));
						return obj;
					}
				}
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

    	for(JsonValue value: jsonObject.getJsonArray(J_EVENTS_ARRAY)) {
			JsonObject obj = value.asJsonObject();
    	    eventList.put(obj.getInt(J_EVENT_ID), 
    	    			    builder.getEventGeneral(obj.getInt(J_EVENT_ID),
		    	    			    		  obj.getString(J_EVENT_NAME),
		    	    			    		  null,
		    	    			    		  obj.toString()));
	    }
    	return eventList;
	}
}
