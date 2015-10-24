package ar.edu.unq.desapp.grupoB022015.rest;

import javax.ws.rs.Path;

import ar.edu.unq.desapp.grupoB022015.services.DateService;

@Path("/date")
public class DateRest {

	private DateService dateService;
    
	public DateService getDateService() {
		return dateService;
	}

	public void setDateService(DateService dateService) {
		this.dateService = dateService;
	}
	
}
