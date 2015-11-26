package ar.edu.unq.desapp.grupoB022015.rest;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

@Path("/player")
public class PlayerRest {
	
	private PlayerService playerService;

	public PlayerService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response findById(@PathParam("id") Integer id) {
		Player p = getPlayerService().findById(id);
		return Response.ok(p).build();
	}
	
	@POST
	@Path("/create")
	@Produces("application/json")
	public Response createPlayer(@FormParam("name") String name, @FormParam("position") String position){
		
		Player p = new Player(name, position);
		getPlayerService().save(p);
		return Response.ok(p).build();
	}

	private Position getPosition(String position) {
		if(position.equals("Goalkeeper"))
			return new Goalkeeper();
		if(position.equals("Defender"))
			return new Defender();
		if(position.equals("Midfielder"))
			return new Midfielder();
		return new Forward();
	}

	@GET
    @Path("/list")
    @Produces("application/json")
    public List<Player> getPlayers() {
        List<Player> players = playerService.retriveAll();
        return players;
    }
	
}
