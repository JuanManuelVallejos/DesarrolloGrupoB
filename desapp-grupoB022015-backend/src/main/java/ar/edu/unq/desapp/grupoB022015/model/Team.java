package ar.edu.unq.desapp.grupoB022015.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Team implements Observer{
	
	private User dt;
	private String name;
	private List<Player> players;
	
	public Team(User userDt, String teamName){
		this.dt = userDt;
		this.name = teamName;
		this.players = new ArrayList<Player>();
	}
	
	public String getName(){
		return this.name;
	}
	
	public List<Player> getPlayers(){
		return this.players;
	}
	
	//WARNING: Need to add logic
	public void addPlayer(Player player){
		players.add(player);
		player.addObserver(this);
	}
	
	public boolean existsPlayer(Player player){
		return players.contains(player);
	}
	
	public void update(Observable o, Object quantity) {
		// TODO Auto-generated method stub
		this.dt.addPoints((Integer) quantity);
	}
	
}
