package ar.edu.unq.desapp.grupoB022015.model;

import java.util.ArrayList;
import java.util.List;

public class User implements Comparable<User>{

	private int ID;
	private int points;
	private Team team;
	private List<League> leagues;
	
	public User(int ID_U){
		this.ID = ID_U;
		this.points = 0;
		this.leagues = new ArrayList<League>();
	}
	
	public int getID(){
		return this.ID;
	}
	
	public void setPoints(int _points){
		this.points = _points;
	}
	
	public int getPoints(){
		return this.points;
	}
	
	public void addPoints(int quantity){
		this.points += quantity;
		actualizateLeagues();
	}
	
	private void actualizateLeagues() {
		for(League league: this.leagues){
			league.updateRanking();
		}
	}

	public void createTeam(String teamName){
		this.team = new Team(this,teamName);
	}
	
	public Team getTeam(){
		return this.team;
	}
	
	public void addmeToLeague(League league){
		this.leagues.add(league);
		league.addUser(this);
	}
	
	public void addPlayerToMyTeam(Player player){
		this.team.addPlayer(player);
	}
	
	public int compareTo(User otherUser) {
		return otherUser.getPoints() - this.getPoints();
	}
	
}
