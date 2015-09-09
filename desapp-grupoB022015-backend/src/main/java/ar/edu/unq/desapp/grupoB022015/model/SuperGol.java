package ar.edu.unq.desapp.grupoB022015.model;

import java.util.ArrayList;
import java.util.List;

public class SuperGol{

	private List<RealTeam> realTeams;
	private List<League> leagues;
	private List<User> users;
	private TableForDate tableForDate;
	
	public SuperGol(){
		realTeams = new ArrayList<RealTeam>();
		leagues = new ArrayList<League>();
		users = new ArrayList<User>();
		tableForDate = new TableForDate();
	}
	
	public void addLeague(League league){
		this.leagues.add(league);
	}
	
	public void addUser(User user){
		this.users.add(user);
	}
	
	public void addRealTeam(String teamName){
		this.realTeams.add(new RealTeam(teamName));
	}
	
	//WARNING: Add exception !!
	public RealTeam getTeamWithName(String nameRealTeam){
		for(RealTeam team : getRealTeams())
			if(team.getName().equals(nameRealTeam))
				return team;
		return null;
	}
	
	public void addPlayerTo(Player player,String nameRealTeam){
		getTeamWithName(nameRealTeam).addPlayer(player);
	}
	
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
	
	public void playerScoredNGoals(Player player,int amountGoals){
		player.addPointsForNGoals(amountGoals);
		tableForDate.addTablePointsOfPlayer(player,player.getPointForNGoals(amountGoals));
	}
	
	public int getPointsForTeam(FantasyTeam team, int numDate){
		return getTable().getTablePointOfPlayersOfDate(team.getPlayers(), numDate);
	}
	
	public void completeDate(){
		this.tableForDate.addDate();
	}
	
}
