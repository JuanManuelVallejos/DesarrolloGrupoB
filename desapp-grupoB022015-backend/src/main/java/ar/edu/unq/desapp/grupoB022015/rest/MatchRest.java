package ar.edu.unq.desapp.grupoB022015.rest;

import javax.ws.rs.Path;

import ar.edu.unq.desapp.grupoB022015.services.MatchService;


@Path("/match")
public class MatchRest {

	private MatchService matchService;
    
	public MatchService getDateService() {
		return matchService;
	}

	public void setDateService(MatchService dateService) {
		this.matchService = dateService;
	}
	
}
