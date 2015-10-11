package ar.edu.unq.desapp.grupoB022015.model;

import java.util.ArrayList;
import java.util.List;

public class User implements Comparable<User>{

	private int ID;
	private int rankingPoints;
	private FantasyTeam team;
	private SuperGol superGol;
	private List<League> leagues;

	public User(){}
	
	public User(int ID_U, SuperGol sP){
		this.ID = ID_U;
		this.rankingPoints = 0;
		this.leagues = new ArrayList<League>();
		this.superGol = sP;
	}
	
	public SuperGol getSystem(){
		return this.superGol;
	}
	
	public int getID(){
		return this.ID;
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
	
	public void createTeam(String teamName){
		this.team = new FantasyTeam(this,teamName);
	}
	
	public FantasyTeam getTeam(){
		return this.team;
	}
	
	public void addmeToLeague(League league){
		this.leagues.add(league);
		league.addUser(this);
	}
	
	public void addPlayersToMyTeam(Player... players){
		for(Player player : players)
			this.team.addPlayer(player);
	}
	
	public int compareTo(User otherUser) {
		return otherUser.getRankingPoints() - this.getRankingPoints();
	}
	
}
