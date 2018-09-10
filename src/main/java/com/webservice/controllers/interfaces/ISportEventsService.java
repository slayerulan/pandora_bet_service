package com.webservice.controllers.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
//import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.webservice.model.SportResponce;

@Consumes("application/json")
@Produces("application/json")
public interface ISportEventsService {

    @GET
	@Path("/allSportTypes/{bookmeker}")
	public SportResponce getAllSportTypes(@PathParam("bookmeker") String bookmeker);

	@GET
	@Path("/sportLeagues/{bookmeker}/{sportId}")
	public SportResponce getListLeagues(@PathParam("bookmeker") String bookmeker, @PathParam("sportId") String sportId);

	@GET
	@Path("/leagueEvents/{bookmeker}/{sportId}/{leagueId}")
	public SportResponce getListEvents(@PathParam("bookmeker") String bookmeker, @PathParam("sportId") String sportId, @PathParam("leagueId") String leagueId);
}