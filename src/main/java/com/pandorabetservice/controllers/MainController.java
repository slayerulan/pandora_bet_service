package com.pandorabetservice.controllers;

//import java.io.StringReader;
//import java.util.Map;

// import javax.json.Json;
// import javax.json.JsonObject;
// import javax.json.JsonReader;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// import com.bookmeker_service.beans.EventGeneral;
// import com.bookmeker_service.beans.LeagueGeneral;
// import com.bookmeker_service.beans.SportGeneral;
// import com.bookmeker_service.connections.ConnectService;
// import com.bookmeker_service.data_builders.IXBetBuilder;
// import com.bookmeker_service.data_builders.MatchbookBuilder;
// import com.bookmeker_service.interfaces.IDataBuilder;

@Controller
@RequestMapping("/movie")
public class MainController {
	
	 /*@RequestMapping(value = "/index", method = RequestMethod.GET)
	   public ModelAndView listSports() {
	      return new ModelAndView("index", "command", "");
	   }*/
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String getMovie(ModelMap model) {

		//ConnectService cs = new ConnectService();
		//String json = cs.sendGETRequest(IXBetBuilder.URL_SPORT_LEAGUE_EVENTS);
		//IDataBuilder builder = new IXBetBuilder();
		//JsonReader reader = Json.createReader(new StringReader(json));;
	    //JsonObject jsonObject = reader.readObject();
		//Map<Integer, LeagueGeneral> map = builder.getListLeagues(jsonObject.getJsonArray(IXBetBuilder.J_VALUE).get(0).asJsonObject());
		//Map<Integer, EventGeneral> map = builder.getListEvents(jsonObject);
		//System.out.println(map.get(1));
		//model.addAttribute("movie", map);
		return "list";

	}
	}