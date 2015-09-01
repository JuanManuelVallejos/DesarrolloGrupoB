package ar.edu.unq.desapp.grupoB022015.model;

import java.util.List;

public class Team {
	
	private List<Integer> IDplayers;

	public void addPlayer(int IDPlayer){
		IDplayers.add(IDPlayer);
	}
	
	public boolean existsPlayer(int IDPlayer){
		return IDplayers.contains(IDPlayer);
	}
	
}
