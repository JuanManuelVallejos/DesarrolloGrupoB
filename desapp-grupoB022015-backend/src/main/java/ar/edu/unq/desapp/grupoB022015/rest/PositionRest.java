package ar.edu.unq.desapp.grupoB022015.rest;

import javax.ws.rs.Path;

import ar.edu.unq.desapp.grupoB022015.services.PositionService;

@Path("/position")
public class PositionRest {

	private PositionService positionService;
	
	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}
	
	public PositionService getPositionService() {
		return positionService;
	}
	
}
