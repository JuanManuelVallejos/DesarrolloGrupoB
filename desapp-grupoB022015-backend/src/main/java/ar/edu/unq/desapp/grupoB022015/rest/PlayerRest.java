package ar.edu.unq.desapp.grupoB022015.rest;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ar.edu.unq.desapp.grupoB022015.model.Defender;
import ar.edu.unq.desapp.grupoB022015.model.Forward;
import ar.edu.unq.desapp.grupoB022015.model.Goalkeeper;
import ar.edu.unq.desapp.grupoB022015.model.Midfielder;
import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.Position;
import ar.edu.unq.desapp.grupoB022015.services.PlayerService;
import ar.edu.unq.desapp.grupoB022015.services.PositionService;

@Path("/player")
public class PlayerRest {
	
	private PlayerService playerService;
	private PositionService positionService;
	
	public PlayerService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	public PositionService getPositionService() {
		return positionService;
	}

	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response findById(@PathParam("id") Integer id) {
		Player p = getPlayerService().findById(id);
		return Response.ok(p).build();
	}
	
	@POST
	@Path("/create/{name}/{position}")
	@Produces("application/json")
	public Response createPlayer(@PathParam("name") String name, @PathParam("position") String position){
		
		Player p = new Player(name, position);
		getPositionService().save(p.getPosition());
		getPlayerService().save(p);
		return Response.ok(p).build();
	}

	@GET
    @Path("/list")
    @Produces("application/json")
    public List<Player> getPlayers() {
        List<Player> players = playerService.retriveAll();
        return players;
    }
	
	@PUT
	@Path("/updatePoints/{playerId}/{goals}")
	@Produces("application/json")
	public Response updatePoints(@PathParam("playerId") Integer playerId, @PathParam("goals") Integer goals){
		
		Player player = getPlayerService().findById(playerId);
		player.addPointsForNGoals(goals);
		getPlayerService().update(player);
		return Response.ok(player).build();
	}
	
	
	
}
