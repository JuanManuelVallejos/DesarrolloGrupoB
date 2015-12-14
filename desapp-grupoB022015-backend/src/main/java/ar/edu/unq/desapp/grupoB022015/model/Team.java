package ar.edu.unq.desapp.grupoB022015.model;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.PlayerNotFoundException;

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

	public List<String> searchNames(){
		List<String> namePlayers = new ArrayList<String>();
		for(Player p: this.getPlayers()){
			namePlayers.add(p.getName());
		}
		return namePlayers;
	}
	
	public void setPlayers(List<Player> players){
		this.players = players;
	}
	
	public abstract void addPlayer(Player player) throws Throwable;
	
	public boolean existsPlayer(Player player){
		return players.contains(player);
	}
	
	public boolean existsPlayer(int player_ID){
		try{
			getPlayer(player_ID);
			return true;
		}catch(PlayerNotFoundException e){
			return false;
		}
	}
	
	public Player getPlayer(int player_ID) throws PlayerNotFoundException{
		for(Player player : getPlayers())
			if(player.getId() == player_ID)
				return player;
		throw new PlayerNotFoundException();
	}

	public void setName(String name) {
		this.name = name;
	}
}