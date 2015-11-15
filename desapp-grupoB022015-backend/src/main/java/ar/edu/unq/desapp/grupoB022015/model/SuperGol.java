package ar.edu.unq.desapp.grupoB022015.model;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.MaximumNumberOfPlayersInTeamException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.PlayerNotFoundException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.TeamNotFoundException;

public class SuperGol extends Entity{

	private List<RealTeam> realTeams;
	private List<League> leagues;
	private List<User> users;
	private TableForDate tableForDate;
	
	//CONSTRUCTORS
	
	public SuperGol(){
		realTeams = new ArrayList<RealTeam>();
		leagues = new ArrayList<League>();
		users = new ArrayList<User>();
		tableForDate = new TableForDate();
	}
	
	public User createNewUserWithTeam(String userName, String nameFantasyTeam){
		User user= new User(this, userName);
		addUser(user);
		user.createFantasyTeam(nameFantasyTeam);
		return user;
	}
	
	// MODIFIERS
	
	public void playerScoredNGoals(int player_ID, int amountGoals) throws PlayerNotFoundException{
		playerScoredNGoals(findPlayer(player_ID),amountGoals);
	}
	
	public void playerScoredNGoals(Player player,int amountGoals){
		player.addPointsForNGoals(amountGoals);
		tableForDate.addTablePointsOfPlayer(player,player.getPointForNGoals(amountGoals));
	}
	
	public void completeDate(){
		this.tableForDate.addDate();
	}
	//CVS Reader
	public void refreshDate(String pathFile) throws Throwable{
		CVSParser.refresh(this, pathFile);
		completeDate();
	}
	public void setRealTeams(String pathFile) throws Throwable{
		List<List<String>> dataForPlayers = CVSParser.readCVSForPlayers(pathFile);
		for(List<String> playerData : dataForPlayers){
			String team = playerData.get(0);
			Position position = Player.getPosition(playerData.get(1));
			String name = playerData.get(2);
			Player player = new Player(this,name,position);
			addPlayerTo(player,team);
		}
	}	
		// FINDERS
	
	public int getPointsForTeam(FantasyTeam team, int numDate){
		return getTable().getTablePointOfPlayersOfDate(team.getPlayers(), numDate);
	}
	
	public RealTeam getTeamWithName(String nameRealTeam) throws TeamNotFoundException{
		for(RealTeam team : getRealTeams())
			if(team.getName().equals(nameRealTeam))
				return team;
		throw new TeamNotFoundException();
	}
	
	public Player findPlayer(int player_ID) throws PlayerNotFoundException{
		for(RealTeam rt : getRealTeams())
			if(rt.existsPlayer(player_ID))
				return rt.getPlayer(player_ID);
		throw new PlayerNotFoundException();
	}
	
	// ADD THINGS
	
	public void addLeague(League league){
		this.leagues.add(league);
	}
	
	public void addUser(User user){
		this.users.add(user);
	}
	
	public RealTeam createRealTeam(String teamName){
		RealTeam rt = new RealTeam(teamName);
		this.realTeams.add(rt);
		return rt;
	}
	
	public void addRealTeam(RealTeam rt){
		this.realTeams.add(rt);
	}
	
	public void addPlayerTo(Player player,String nameRealTeam) throws TeamNotFoundException{
		try{
			getTeamWithName(nameRealTeam).addPlayer(player);
		}catch(TeamNotFoundException e){
			createRealTeam(nameRealTeam);
			getTeamWithName(nameRealTeam).addPlayer(player);
		}
	}
	
	// GETTERS AND SETTERS
	
	public List<RealTeam> getRealTeams(){
		return this.realTeams;
	}
	
	public List<League> getLeagues(){
		return this.leagues;
	}
	
	public List<User> getUsers(){
		return this.users;
	}
	
	public TableForDate getTable(){
		return this.tableForDate;
	}

	public void addPlayerTo(int player_ID, User user) throws MaximumNumberOfPlayersInTeamException,PlayerNotFoundException {
		user.addPlayerToMyTeam(findPlayer(player_ID));
	}
	/*
	public static void main(String[] args) throws Throwable {
		SuperGol sup = new SuperGol();
		sup.setRealTeams("/Users/musimundo/Downloads/players.cvs");
		System.out.println();
		for(Player player : sup.getRealTeams().get(0).getPlayers()){
			String str= player.getName();
			str += ' ';
			str += player.getPosition();
			System.out.println(str);
		}
	}
	*/
}
