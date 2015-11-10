/**
 * 
 */
package ar.edu.unq.desapp.grupoB022015.rest;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ar.edu.unq.desapp.grupoB022015.model.FantasyTeam;
import ar.edu.unq.desapp.grupoB022015.model.SuperGol;
import ar.edu.unq.desapp.grupoB022015.model.User;
import ar.edu.unq.desapp.grupoB022015.services.FantasyTeamService;
import javax.ws.rs.core.Response;

@Path("/fantasyTeam")
public class FantasyTeamRest {
    
    private FantasyTeamService fantasyTeamService;
    
	public FantasyTeamService getFantasyTeamService() {
		return fantasyTeamService;
	}

	public void setFantasyTeamService(FantasyTeamService fantasyTeamService) {
		this.fantasyTeamService = fantasyTeamService;
	}
	
	@GET
    @Path("/list")
    @Produces("application/json")
    public List<FantasyTeam> getFantasyTeams() {
        List<FantasyTeam> fantasyTeams = fantasyTeamService.retriveAll();
        return fantasyTeams;
    }
	
	 @POST
	 @Path("/create")
	 @Produces("application/json")
	 public Response createFantasyTeam(@FormParam("name") String name) {
		 	FantasyTeam fantasyTeam = new FantasyTeam(new User(new SuperGol(),""),name);
		 	getFantasyTeamService().save(fantasyTeam);
			return Response.ok(fantasyTeam).build();
	 }
	 
		
	@PUT
	@Path("/edit/{teamname}")
	@Produces("application/json")
	public void editFantasyTeam(@PathParam("teamname") String teamname){
			
		FantasyTeam team = this.getFantasyTeamService().findByTeamName(teamname);
		team.setName(teamname);
				
		this.getFantasyTeamService().update(team);
			
	}
	 

}
