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
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;

import ar.edu.unq.desapp.grupoB022015.model.League;
import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.PointsForUser;
import ar.edu.unq.desapp.grupoB022015.model.SuperGol;
import ar.edu.unq.desapp.grupoB022015.model.User;
import ar.edu.unq.desapp.grupoB022015.services.LeagueService;
import ar.edu.unq.desapp.grupoB022015.services.PointsForUserService;
import ar.edu.unq.desapp.grupoB022015.services.UserService;

@Path("/league")
public class LeagueRest {
	
	private LeagueService leagueService;
	private UserService userService;
	private PointsForUserService pointsForUserService;

	public LeagueService getLeagueService() {
		return leagueService;
	}

	public void setLeagueService(LeagueService leagueService) {
		this.leagueService = leagueService;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setPointsForUserService(PointsForUserService pointsForUserService) {
		this.pointsForUserService = pointsForUserService;
	}
	
	public PointsForUserService getPointsForUserService() {
		return pointsForUserService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@POST
	@Path("/create/{name}/{minTeams}/{maxTeams}/{idGoogle}")
	@Produces("application/json")
	public Response createLeague
	(@PathParam("name") String name,  @PathParam("minTeams") Integer minTeams,@PathParam("maxTeams") Integer maxTeams, @PathParam("idGoogle") String idGoogle){

		League league = new League();
		league.assignParameters(name,minTeams,maxTeams);
		User user = getUserService().findByIdGoogle(idGoogle);
		getLeagueService().save(league);
		addUser(user,league);
		return Response.ok(league).build();
		//PointsForUser pfu = new PointsForUser(user,0);
		//getPointsForUserService().save(pfu);
		//league.addUser(user,pfu);
		//getLeagueService().save(league);
	}
	
	@POST
	@Path("/addUser/{idGoogle}/{idLeague}/")
	@Produces("application/json")
	public void addUser
	(@PathParam("idGoogle") String idGoogle,  @PathParam("idLeague") Integer idLeague){
		League league = getLeagueService().findById(idLeague);
		User user = this.getUserService().findByIdGoogle(idGoogle);
		league.addUser(user);
		getLeagueService().update(league);
	}
	
	@POST
	@Path("/addUser2/{idGoogle}/{idLeague}")
	@Produces("application/json")
	public void addUser
	(@PathParam("idGoogle") String idGoogle,  @PathParam("idLeague") Integer idLeague){
		League league = getLeagueService().findById(idLeague);
		User user = getUserService().findByIdGoogle(idGoogle);
		league.addUser(user);
		getLeagueService().update(league);
	}
	
	public void addUser(User user,  League league){
		league.addUser(user);
		getUserService().update(user);
		getLeagueService().update(league);
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response findById(@PathParam("id") final
			Integer id) {
		League l = getLeagueService().findById(id);
		return Response.ok(l).build();
	}
	
	@GET
	@Path("/name/{name}")
	@Produces("application/json")
	public Response findByName(@PathParam("name") String name) {
		League l = getLeagueService().findByName(name);
		return Response.ok(l).build();
	}
	
	
	
	@GET
    @Path("/list")
    @Produces("application/json")
    public List<League> getLeagues() {
        List<League> leagues = leagueService.retriveAll();
        return leagues;
    }
	
	@GET
    @Path("/getCurrentDate")
    @Produces("application/json")
    public int getCurrentDate() {
        return getLeagues().get(0).getCurrentDate();
    }
	
	@PUT
	@Path("/increaseCurrentDate")
	@Produces("application/json")
	public int increaseCurrentDate(){
		List<League> leagues = getLeagueService().retriveAll();
		int currDate = leagues.get(0).getCurrentDate() + 1 ;
		for(League league : leagues){
			league.setCurrentDate(currDate);
			getLeagueService().update(league);
		}
		return currDate;
	}
	
	@PUT
	@Path("/edit/{id}/{name}/{minTeams}/{maxTeams}")
	@Produces("application/json")
	public void editLeague(@PathParam("id") Integer id, @PathParam("name") String name, @PathParam("minTeams")Integer minTeams, 
			@PathParam("maxTeams") Integer maxTeams){
		
		
		League l = this.getLeagueService().findById(id);
		l.updateLeague(name, minTeams, maxTeams);
		
		
		this.getLeagueService().update(l);
		
	}
	
	@GET
	@Path("/findRival/{idGoogle}/{idLeague}/{aDate}")
	@Produces("application/json")
	public User findRival(@PathParam("idGoogle") String idGoogle, @PathParam("idLeague") Integer idLeague, @PathParam("aDate") Integer aDate) {
		
		User user = this.getUserService().findByIdGoogle(idGoogle);
		League league = this.getLeagueService().findById(idLeague);
		
		User rival = league.getDate(aDate).getMatchForUser(user).getLocal();
		if(rival.getIdGoogle() == idGoogle){
			rival = league.getDate(aDate).getMatchForUser(user).getVisitor();
		}
	
		return rival;
	}
	
	@PUT
	@Path("/initializeFixtures")
	@Produces("application/json")
	public void initializeFixtures(){
		List<List<League>> leagues = filterLeagues();
		List<League> correctLeagues = leagues.get(0);
		List<League> incorrectLeagues = leagues.get(1);
		setFixtures(correctLeagues);
		removeLeagues(incorrectLeagues);
 	}
	
	public List<List<League>> filterLeagues(){
		List<League> leagues = getLeagueService().retriveAll();
		List<League> correctLeagues = new ArrayList<League>();
		List<League> incorrectLeagues = new ArrayList<League>();
		for(League league : leagues){
			if(league.satisfiesTeams()){
				correctLeagues.add(league);
			}else{
				incorrectLeagues.add(league);
			}
		}
		List<List<League>> allLeagues = new ArrayList<List<League>>();
		allLeagues.add(correctLeagues);
		allLeagues.add(incorrectLeagues);
		return allLeagues;
	}
	
	public void removeLeagues(List<League> incorrectLeagues){
		for(League incLeague : incorrectLeagues)
			getLeagueService().delete(incLeague);
	}
	
	public void setFixtures(List<League> correctLeagues){
		for(League corrLeague : correctLeagues){
			corrLeague.createFixtureRoundTrip(new DateTime(), 7);
			getLeagueService().update(corrLeague);
		}
	}
}
