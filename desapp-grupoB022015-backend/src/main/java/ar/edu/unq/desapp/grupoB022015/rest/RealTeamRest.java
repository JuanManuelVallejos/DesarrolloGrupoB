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
	@Path("/createPlayer/{team}/{name}/{position}")
	@Produces("application/json")
	public void setPlayer(@PathParam("team") String team,@PathParam("name") String name,@PathParam("position") String position){
			Player player = getPlayerService().createPlayer(name, position);
			getRealTeamService().createPlayerIn(player, team);
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


