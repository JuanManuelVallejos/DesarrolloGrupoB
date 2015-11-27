package ar.edu.unq.desapp.grupoB022015.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ar.edu.unq.desapp.grupoB022015.model.League;
import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.SuperGol;
import ar.edu.unq.desapp.grupoB022015.services.LeagueService;

@Path("/league")
public class LeagueRest {
	
	private LeagueService leagueService;

	public LeagueService getLeagueService() {
		return leagueService;
	}

	public void setLeagueService(LeagueService leagueService) {
		this.leagueService = leagueService;
	}
	
	@POST
	@Path("/create/{name}/{minTeams}/{maxTeams}")
	@Produces("application/json")
	public Response createLeague
	(@PathParam("name") String name,  @PathParam("minTeams") Integer minTeams,@PathParam("maxTeams") Integer maxTeams){

		League league = new League(name, new SuperGol(),minTeams,maxTeams);
		getLeagueService().save(league);
		return Response.ok(league).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response findById(@PathParam("id") final
			Integer id) {
		League l = getLeagueService().findById(id);
		return Response.ok(l).build();
	}
	
	@GET
	@Path("/name/{name}")
	@Produces("application/json")
	public Response findByName(@PathParam("name") String name) {
		League l = getLeagueService().findByName(name);
		return Response.ok(l).build();
	}
	
	
	
	@GET
    @Path("/list")
    @Produces("application/json")
    public List<League> getLeagues() {
        List<League> leagues = leagueService.retriveAll();
        return leagues;
    }
	
	@PUT
	@Path("/edit/{id}/{name}/{minTeams}/{maxTeams}")
	@Produces("application/json")
	public void editLeague(@PathParam("id") Integer id, @PathParam("name") String name, @PathParam("minTeams")Integer minTeams, 
			@PathParam("maxTeams") Integer maxTeams){
		
		
		League l = this.getLeagueService().findById(id);
		l.updateLeague(name, minTeams, maxTeams);
		
		
		this.getLeagueService().update(l);
		
	}
}
