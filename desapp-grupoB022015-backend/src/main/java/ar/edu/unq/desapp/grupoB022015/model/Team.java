package ar.edu.unq.desapp.grupoB022015.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Team{
	
	private String name;
	private List<Player> players;
	
	public Team(String teamName){
		this.name = teamName;
		this.players = new ArrayList<Player>();
	}
	
	public String getName(){
		return this.name;
	}
	
	public List<Player> getPlayers(){
		return this.players;
	}

	public abstract void addPlayer(Player player);
	
	public boolean existsPlayer(Player player){
		return players.contains(player);
	}
}