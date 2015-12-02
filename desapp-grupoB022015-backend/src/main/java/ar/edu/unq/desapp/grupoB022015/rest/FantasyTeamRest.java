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
import ar.edu.unq.desapp.grupoB022015.model.League;
import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.RealTeam;
import ar.edu.unq.desapp.grupoB022015.model.SuperGol;
import ar.edu.unq.desapp.grupoB022015.model.User;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.MaximumNumberOfPlayersInTeamException;
import ar.edu.unq.desapp.grupoB022015.services.FantasyTeamService;
import ar.edu.unq.desapp.grupoB022015.services.PlayerService;
import ar.edu.unq.desapp.grupoB022015.services.UserService;

import javax.ws.rs.core.Response;

import org.hibernate.id.CompositeNestedGeneratedValueGenerator.GenerationPlan;

@Path("/fantasyTeam")
public class FantasyTeamRest {
	
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
    
    private FantasyTeamService fantasyTeamService;
    
	public FantasyTeamService getFantasyTeamService() {
		return fantasyTeamService;
	}

	public void setFantasyTeamService(FantasyTeamService fantasyTeamService) {
		this.fantasyTeamService = fantasyTeamService;
	}
	
	private PlayerService playerService;

	public PlayerService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	@GET
    @Path("/list")
    @Produces("application/json")
    public List<FantasyTeam> getFantasyTeams() {
        List<FantasyTeam> fantasyTeams = fantasyTeamService.retriveAll();
        return fantasyTeams;
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
