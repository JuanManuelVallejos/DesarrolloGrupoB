package ar.edu.unq.desapp.grupoB022015.rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.RealTeam;
import ar.edu.unq.desapp.grupoB022015.services.RealTeamService;
import ar.edu.unq.desapp.grupoB022015.services.PlayerService;

@Path("/realTeam")
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
	@Path("/create/{name}/")
	@Produces("application/json")
	public Response create(@PathParam("name") String name){
			RealTeam t = new RealTeam(name);
			getRealTeamService().save(t);
			return Response.ok(t).build();
	}
	
	@POST
	@Path("/addPlayer/{team}/{name}/{position}")
	@Produces("application/json")
	public RealTeam setPlayer(@PathParam("team") String team,@PathParam("name") String name,@PathParam("position") String position){
			Player p = new Player(name, position);
			
			RealTeam t = getRealTeamService().findByTeamName(team);
			t.addPlayer(p);
			getRealTeamService().update(t);
			return t;
	}
	
	@POST
	@Path("/createPlayers")
	@Consumes("multipart/form-data")
	@Produces("application/json")
	public void setPlayers(@PathParam("is") FileInputStream  is) throws IOException{
		
		InputStreamReader in = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(in);
		
		String line = "";
		String cvsSplitBy = ",";
		
		line = br.readLine();
		
		
		while ((line = br.readLine()) != null) {

		    // use comma as separator
			String[] row = line.split(cvsSplitBy);
			
			String team = row[0];
			String position = row[1];
			String name = row[2];
			setPlayer(team,name,position);
		
		}
	}
}


