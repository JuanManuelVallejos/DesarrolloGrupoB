package ar.edu.unq.desapp.grupoB022015.model;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.MaximumNumberOfPlayersInTeamException;

public class FantasyTeam extends Team{
	
	private User dt;
	
	public FantasyTeam(){}
	
	public FantasyTeam(User userDt, String teamName){
		super(teamName);
		this.setDt(userDt);
	}

	public FantasyTeam(String teamname) {
		super(teamname);
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
