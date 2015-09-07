package ar.edu.unq.desapp.grupoB022015.model;

import java.util.ArrayList;
import java.util.List;

public class SuperGol{

	private List<Player> players;
	private List<League> leagues;
	private List<User> users;
	private TableForDate tableForDate;
	
	public SuperGol(){
		players = new ArrayList<Player>();
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
	
	public void addPlayer(Player player){
		this.players.add(player);
	}
	
	public List<Player> getPlayers(){
		return this.players;
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
		tableForDate.addPointsOfPlayer(player,player.getPointForNGoals(amountGoals));
	}
	
	public int getPointsForTeam(Team team, int numDate){
		return getTable().getPointOfPlayersOfDate(team.getPlayers(), numDate);
	}
	
	public void completeDate(){
		this.tableForDate.addDate();
	}
	
}
