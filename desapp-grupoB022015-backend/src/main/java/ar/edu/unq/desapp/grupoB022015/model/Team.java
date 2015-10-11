package ar.edu.unq.desapp.grupoB022015.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Team extends Entity{
	
	private String name;
	private List<Player> players;
	
	public Team(){}
	
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

	public List<String> getNames(){
		List<String> namePlayers = new ArrayList<String>();
		for(Player p: this.getPlayers()){
			namePlayers.add(p.getName());
		}
		return namePlayers;
	}
	
	public abstract void addPlayer(Player player);
	
	public boolean existsPlayer(Player player){
		return players.contains(player);
	}
}