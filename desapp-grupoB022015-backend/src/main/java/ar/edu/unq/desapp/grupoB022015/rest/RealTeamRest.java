package ar.edu.unq.desapp.grupoB022015.rest;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ar.edu.unq.desapp.grupoB022015.model.CVSParser;
import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.Position;
import ar.edu.unq.desapp.grupoB022015.services.RealTeamService;
import ar.edu.unq.desapp.grupoB022015.services.PlayerService;

public class RealTeamRest {

    private RealTeamService realTeamService;
    private PlayerService playerService;
    
	public RealTeamService getRealTeamService() {
		return realTeamService;
	}

	public void setRealTeamService(RealTeamService realTeamService) {
		this.realTeamService = realTeamService;
	}
    
	public PlayerService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	@POST
	@Path("/createPlayer/{team}/{name}/{position}")
	@Produces("application/json")
	public void setPlayer(@PathParam("team") String team,@PathParam("name") String name,@PathParam("position") String position){
			Player player = getPlayerService().createPlayer(name, position);
			getRealTeamService().createPlayerIn(player, team);
	}
	
}


