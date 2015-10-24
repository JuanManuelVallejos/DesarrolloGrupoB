package ar.edu.unq.desapp.grupoB022015.rest;

import javax.ws.rs.Path;

import ar.edu.unq.desapp.grupoB022015.services.PointsForUserService;

@Path("/pointsForUser")
public class PointsForUserRest{

	private PointsForUserService pointsForUserService;
    
	public PointsForUserService getPointsForUserService() {
		return pointsForUserService;
	}

	public void setPointsForUserService(PointsForUserService pointsForUserService) {
		this.pointsForUserService = pointsForUserService;
	}
	
}
