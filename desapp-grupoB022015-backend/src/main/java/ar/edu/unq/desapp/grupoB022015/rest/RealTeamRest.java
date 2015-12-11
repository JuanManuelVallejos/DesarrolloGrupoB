package ar.edu.unq.desapp.grupoB022015.rest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.Position;
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
			RealTeam t = getRealTeamService().findByTeamName(name);
			if(t==null){
				t = createRT(name);
			}
			return Response.ok(t).build();
	}
	
	@GET
	@Path("/getPlayers/{teamName}/{position}")
	@Produces("application/json")
	public List<Player> searchPlayers(@PathParam("teamName") String teamName, @PathParam("position") String position){
			RealTeam realTeam = getRealTeamService().findByTeamName(teamName);
			List<Player> playerList = new ArrayList<Player>();
			for(Player player : realTeam.getPlayers()){
				Position p = player.getPosition();
				Boolean b = p.isMine(position);
				if(p.isMine(position))
					playerList.add(player);
			}
			return playerList;
	}
	
	public RealTeam createRT(String name){
		RealTeam team = new RealTeam(name);
		getRealTeamService().save(team);
		return team;
	}
	
	@POST
	@Path("/addPlayer/{team}/{name}/{position}")
	@Produces("application/json")
	public RealTeam setPlayer(@PathParam("team") String team,@PathParam("name") String name,@PathParam("position") String position){
			Player p = new Player(name, position);
			
			RealTeam t = getRealTeamService().findByTeamName(team);
			if(t == null){
				t = createRT(team);
			}
			getPlayerService().save(p);
			t.addPlayer(p);
			getRealTeamService().update(t);
			return t;
	}
	
	@GET
    @Path("/list")
    @Produces("application/json")
    public List<RealTeam> getTeams() {
        List<RealTeam> teams = realTeamService.retriveAll();
        return teams;
    }
	
	@POST
	@Path("/createPlayers")
	@Consumes("multipart/form-data")
	@Produces("application/json")
	public void setPlayers(@FormParam("csvText") String csvText) throws IOException{
		processCsv(csvText);
	}
	
	@POST
	@Path("/createPlayers2/{csvText}")
	@Consumes("multipart/form-data")
	@Produces("application/json")
	public void setPlayers2(@PathParam("csvText") String csvText) throws IOException{
		processCsv(csvText);
	}
	
	public void processCsv(String csv) throws IOException{
		InputStream is = new ByteArrayInputStream(csv.getBytes());
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

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


