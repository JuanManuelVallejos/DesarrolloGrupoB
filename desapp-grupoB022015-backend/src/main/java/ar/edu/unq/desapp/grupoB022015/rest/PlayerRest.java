package ar.edu.unq.desapp.grupoB022015.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ar.edu.unq.desapp.grupoB022015.model.Defender;
import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.Position;
import ar.edu.unq.desapp.grupoB022015.model.SuperGol;
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
	public Response findById(@PathParam("id") final
			Integer id) {
		Player p = getPlayerService().findById(id);
		return Response.ok(p).build();
	}
	
	@POST
	@Path("/create")
	@Produces("application/json")
	public Response createPlayer(@FormParam("name") String name,
			 @FormParam("ID") int id){//, @FormParam("position") Position position){
		
		
		Player player = getPlayerService().findByName(name);
		
		if(player == null){
			//pasar supergol q corresponde
			Player p = new Player(new SuperGol(), id, name ,new Defender());//, position);
			getPlayerService().save(p);
		}else{
			return Response.ok(-1).build();
		}
		return Response.ok(player).build();
	}

}
