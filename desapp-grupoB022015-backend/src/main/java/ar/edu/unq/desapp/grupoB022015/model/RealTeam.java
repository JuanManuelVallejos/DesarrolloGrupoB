package ar.edu.unq.desapp.grupoB022015.model;

public class RealTeam extends Team {

	
	public RealTeam(){}
	public RealTeam(String teamName){
		super(teamName);
	}
	
	@Override
	public void addPlayer(Player player) {
		getPlayers().add(player);
	}

}
