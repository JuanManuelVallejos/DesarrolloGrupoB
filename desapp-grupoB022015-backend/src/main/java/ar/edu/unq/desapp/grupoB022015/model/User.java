package ar.edu.unq.desapp.grupoB022015.model;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.MaximumNumberOfPlayersInTeamException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.PlayerNotFoundException;

public class User extends Entity implements Comparable<User>{

	private String userName;
	private int rankingPoints;
	private FantasyTeam team;
	private SuperGol superGol;
	private List<League> leagues;

	public User(){}
	
	public User(SuperGol sP, String name){
		this.rankingPoints = 0;
		this.leagues = new ArrayList<League>();
		this.superGol = sP;
		this.setUserName(name);
	}

	private void setUserName(String name) {
		this.userName = name;
	}

	public SuperGol getSystem(){
		return this.superGol;
	}
	
	public String getUserName(){
		return this.userName;
	}
	
	public void setRankingPoints(int _points){
		this.rankingPoints = _points;
	}
	
	public int getRankingPoints(){
		return this.rankingPoints;
	}
	
	public void addRankingPoints(int quantity){
		this.rankingPoints += quantity;
		actualizateLeagues();
	}
	
	private void actualizateLeagues() {
		for(League league: this.leagues){
			league.updateRanking();
		}
	}

	public League createLeague(String leagueName){
		League league = new League(leagueName,getSystem());
		league.addUser(this);
		getSystem().addLeague(league);
		return league;
	}
	
	public void createFantasyTeam(String teamName){
		this.team = new FantasyTeam(this,teamName);
	}
	
	public FantasyTeam getTeam(){
		return this.team;
	}
	
	public void addmeToLeague(League league){
		this.leagues.add(league);
		league.addUser(this);
	}
	
	public void addPlayersToMyTeam(int... IDplayers) throws MaximumNumberOfPlayersInTeamException, PlayerNotFoundException{
		for(int player_ID : IDplayers)
			getSystem().addPlayerTo(player_ID,this);
	}
	
	public void addPlayerToMyTeam(Player player) throws MaximumNumberOfPlayersInTeamException{
		getTeam().addPlayer(player);
	}
	
	public int compareTo(User otherUser) {
		return otherUser.getRankingPoints() - this.getRankingPoints();
	}
	
	public void setPlayers(Player... players) throws Throwable{
		for(Player player : players)
			getTeam().addPlayer(player);
	}
	
	public List<League> getLeagues(){
		return this.leagues;
	}
	
}
