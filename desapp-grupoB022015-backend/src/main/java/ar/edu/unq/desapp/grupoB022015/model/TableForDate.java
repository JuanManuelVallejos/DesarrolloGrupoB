package ar.edu.unq.desapp.grupoB022015.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TableForDate extends Entity{

	private List<HashMap<Player,Integer>> table;
	private int currentDate;
	
	public TableForDate(){
		this.table = new ArrayList<HashMap<Player,Integer>>();
		this.table.add(new HashMap<Player, Integer>());
		this.currentDate = 0;
	}
	
	public void addDate(){
		this.table.add(new HashMap<Player, Integer>());
		this.currentDate++; 
	}
	
	public int getCurrentDate(){
		return this.currentDate;
	}
	
	public void addTablePointsOfPlayer(Player player,Integer points){
		this.table.get(getCurrentDate()).put(player, points);
	}
	
	public int getLastPointsOfDate(List<Player> players){
		return getTablePointOfPlayersOfDate(players, getCurrentDate());
	}
	
	public int getTablePointOfPlayersOfDate(List<Player> players,int numDate){
		int points = 0;
		for(Player player : players){
			points = getTablePointOfPlayerOfDate(player,numDate);
		}
		return points;
	}

	public int getTablePointOfPlayerOfDate(Player player, int numDate) {
		Integer value = table.get(numDate).get(player);
		return (value.equals(null)) ?  0 :  value; 
	}
}
