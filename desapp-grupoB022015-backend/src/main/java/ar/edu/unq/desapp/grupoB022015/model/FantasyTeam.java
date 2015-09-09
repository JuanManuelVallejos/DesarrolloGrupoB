package ar.edu.unq.desapp.grupoB022015.model;

public class FantasyTeam extends Team{
	
	private User dt;
	
	public FantasyTeam(User userDt, String teamName){
		super(teamName);
		this.setDt(userDt);
	}

	public User getDt() {
		return dt;
	}

	public void setDt(User dt) {
		this.dt = dt;
	}

	//WARNING: Need to add logic
	@Override
	public void addPlayer(Player player) {
		getPlayers().add(player);
	}
	
}
