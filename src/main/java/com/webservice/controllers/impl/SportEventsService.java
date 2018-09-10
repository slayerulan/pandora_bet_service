package com.webservice.controllers.impl;

// import javax.json.JsonObject;
// import javax.json.JsonReader;
// import java.io.StringReader;
// import java.util.Map;
// import javax.json.Json;

// import com.bookmeker_service.beans.SportGeneral;
// import com.bookmeker_service.connections.ConnectService;
import com.bookmeker_service.data_builders.FactoryBuilder;
//import com.bookmeker_service.data_builders.MatchbookBuilder;
import com.bookmeker_service.interfaces.IDataBuilder;
import com.webservice.controllers.interfaces.ISportEventsService;
//import com.webservice.model.BaseRequest;
import com.webservice.model.SportResponce;

public class SportEventsService implements ISportEventsService {

    public SportResponce getAllSportTypes(String bookmeker) {
        SportResponce sr = new SportResponce();
		IDataBuilder builder = new FactoryBuilder().getDataBuilder(bookmeker);
		sr.setSports(builder.getListSports());
        return sr;
	}
	
	public SportResponce getListLeagues(String bookmeker, String sportId) {
		SportResponce sr = new SportResponce();
		IDataBuilder builder = new FactoryBuilder().getDataBuilder(bookmeker);
		sr.setLeagues(builder.getListLeagues(sportId));
        return sr;
	}

	public SportResponce getListEvents(String bookmeker, String sportId, String leagueId) {
		SportResponce sr = new SportResponce();
		IDataBuilder builder = new FactoryBuilder().getDataBuilder(bookmeker);
		sr.setEvents(builder.getListEvents(sportId, leagueId));
        return sr;
	}
}