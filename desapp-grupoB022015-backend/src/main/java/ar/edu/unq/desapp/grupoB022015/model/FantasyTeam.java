package ar.edu.unq.desapp.grupoB022015.model;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.MaximumNumberOfPlayersInTeamException;

public class FantasyTeam extends Team{
	
	private User dt;
	private int minTeams;
	private int maxTeams;
	
	public FantasyTeam(){}
	
	public FantasyTeam(User userDt, String teamName){
		super(teamName);
		this.setDt(userDt);
	}
	public FantasyTeam(User userDt, String teamName, int min, int max){
		super(teamName);
		this.minTeams = min;
		this.maxTeams = max;
		this.setDt(userDt);
	}

	public User getDt() {
		return dt;
	}

	public void setDt(User dt) {
		this.dt = dt;
	}

	@Override
	public void addPlayer(Player player) throws MaximumNumberOfPlayersInTeamException{
		if(getPlayers().size() < 11){
			getPlayers().add(player);
		}else{
			throw new MaximumNumberOfPlayersInTeamException();
		}
	}
	
	
}
