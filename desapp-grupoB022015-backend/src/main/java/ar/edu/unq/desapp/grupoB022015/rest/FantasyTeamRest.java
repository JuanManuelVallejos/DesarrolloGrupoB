/**
 * 
 */
package ar.edu.unq.desapp.grupoB022015.rest;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
        List<FantasyTeam> players = fantasyTeamService.retriveAll();
        return players;
    }
	
	 @POST
	 @Path("/create")
	 @Produces("application/json")
	 public Response createDiagnostic(@FormParam("name") String name) {
		 	FantasyTeam fantasyTeam = new FantasyTeam(new User(1,new SuperGol()),name);
		 	getFantasyTeamService().save(fantasyTeam);
			return Response.ok(fantasyTeam).build();
	 }

}
