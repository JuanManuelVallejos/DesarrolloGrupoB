/**
 * 
 */
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

import ar.edu.unq.desapp.grupoB022015.model.FantasyTeam;
import ar.edu.unq.desapp.grupoB022015.model.League;
import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.Position;
import ar.edu.unq.desapp.grupoB022015.model.RealTeam;
import ar.edu.unq.desapp.grupoB022015.model.SuperGol;
import ar.edu.unq.desapp.grupoB022015.model.User;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.MaximumNumberOfPlayersInTeamException;
import ar.edu.unq.desapp.grupoB022015.services.FantasyTeamService;
import ar.edu.unq.desapp.grupoB022015.services.PlayerService;
import ar.edu.unq.desapp.grupoB022015.services.RealTeamService;
import ar.edu.unq.desapp.grupoB022015.services.UserService;

import javax.ws.rs.core.Response;

import org.hibernate.id.CompositeNestedGeneratedValueGenerator.GenerationPlan;

@Path("/fantasyTeam")
public class FantasyTeamRest {
	
	private RealTeamService realTeamService;
    
	public RealTeamService getRealTeamService() {
		return realTeamService;
	}

	public void setRealTeamService(RealTeamService realTeamService) {
		this.realTeamService = realTeamService;
	}
	
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
	
	@GET
	@Path("/getTeam/{teamname}")
	@Produces("application/json")
	public FantasyTeam getTeam(@PathParam("teamname") String teamname){
		return this.getFantasyTeamService().findByTeamName(teamname);
	}
	
	@GET
	@Path("/getPlayersByPosition/{idgoogle}/{position}")
	@Produces("application/json")
	public List<Player> getPlayersByPosition(@PathParam("idgoogle") String idgoogle, @PathParam("position") String position){
			FantasyTeam team = getUserService().findByIdGoogle(idgoogle).getTeam();
			List<Player> playerList = new ArrayList<Player>();
			for(Player player : team.getPlayers()){
				Position p = player.getPosition();
				if(p.isMine(position))
					playerList.add(player);
			}
			return playerList;
	}
	
	@GET
	@Path("/getPlayerInATeam/{playername}/{position}/{idgoogle}")
	@Produces("application/json")
	public Player getPlayerInATeam(@PathParam("playername") String playername, @PathParam("position") String position, @PathParam("idgoogle") String idgoogle){
			List<Player> players = getPlayersByPosition(idgoogle, position);
			System.out.println("");
			for(Player player: players){
				if(player.getName().equals(playername)){
					return player;
				}
			}
			return null;
	}
	
	@POST
	@Path("/addPlayer/{playername}/{position}/{idgoogle}")
	@Produces("application/json")
	public Response addPlayer(@PathParam("playername") String playername, @PathParam("position") String position, @PathParam("idgoogle") String idgoogle) throws MaximumNumberOfPlayersInTeamException{
		Player player = getPlayerInATeam(playername, position, idgoogle);
		User user = getUserService().findByIdGoogle(idgoogle);
		user.addPlayerToMyTeam(player);
		user.getTeam().addPlayer(player);
		User user2 = user;
		getUserService().update(user);			
		return Response.ok(user).build();
	}
	
	@GET
	@Path("/getRealTeam/{teamName}")
	@Produces("application/json")
	public RealTeam getRealTeam(@PathParam("teamName") String teamName){
			List<RealTeam> teams = getRealTeamService().retriveAll();
			RealTeam team = null;
			for(RealTeam ateam: teams){
				if(ateam.getName().equals(teamName))
					team = ateam;
			}
			return team;
	}
	
	
	@GET
	@Path("/getRealPlayersByPosition/{teamName}/{position}")
	@Produces("application/json")
	public List<Player> getRealPlayersByPosition(@PathParam("teamName") String teamName, @PathParam("position") String position){
			RealTeam team = getRealTeam(teamName);
			List<Player> playerList = new ArrayList<Player>();
			for(Player player : team.getPlayers()){
				Position p = player.getPosition();
				if(p.isMine(position))
					playerList.add(player);
			}
			return playerList;
	}
	
	@GET
	@Path("/getPlayerInARealTeam/{playername}/{position}/{teamName}")
	@Produces("application/json")
	public Player getPlayerInARealTeam(@PathParam("playername") String playername, @PathParam("position") String position, @PathParam("teamName") String teamName){
			List<Player> players = getRealPlayersByPosition(teamName, position);
			for(Player player: players){
				if(player.getName().equals(playername)){
					return player;
				}
			}
			return null;
	}
	
	@POST
	@Path("/addMyPlayer/{playername}/{position}/{teamname}/{idgoogle}")
	@Produces("application/json")
	public Response addMyPlayer(@PathParam("playername") String playername, @PathParam("position") String position, @PathParam("teamname") String teamname, @PathParam("idgoogle") String idgoogle) throws MaximumNumberOfPlayersInTeamException{
		Player player = getPlayerInARealTeam(playername, position, teamname);
		User user = getUserService().findByIdGoogle(idgoogle);
		user.getTeam().addPlayer(player);
		getUserService().update(user);			
		return Response.ok(user).build();
	}
	
	@GET
	@Path("/getOnePlayer/{playerId}")
	@Produces("application/json")
	public Player getOnePlayer(@PathParam("playerId") Integer playerId){
		return getPlayerService().findById(playerId);
	}
	
	@POST
	@Path("/addOnePlayer/{playerId}/{idgoogle}")
	@Produces("application/json")
	public Response addOnePlayer(@PathParam("playerId") Integer playerId, @PathParam("idgoogle") String idgoogle) throws MaximumNumberOfPlayersInTeamException{
		Player player = getPlayerService().findById(playerId);
		User user = getUserService().findByIdGoogle(idgoogle);
		user.getTeam().addPlayer(player);
		getUserService().update(user);			
		return Response.ok(user).build();
	}
	
	@GET
	@Path("/getGoalkeeper/{idgoogle}")
	@Produces("application/json")
	public Player getGoalkeeper(@PathParam("idgoogle") String idgoogle){
		FantasyTeam team = getUserService().findByIdGoogle(idgoogle).getTeam();
		Player player = null;
		for(Player aplayer : team.getPlayers()){
			Position p = player.getPosition();
			if(p.isMine("Goalkeeper"))
				player = aplayer;
		}
		return player;
	}

}
