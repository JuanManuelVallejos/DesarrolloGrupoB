package ar.edu.unq.desapp.grupoB022015.services;

public class GeneralService {

	private FantasyTeamService fantasyTeamService;
	private PlayerService playerService;
	
	public FantasyTeamService getFantasyTeamService() {
		return fantasyTeamService;
	}

	public void setFantasyTeamService(FantasyTeamService fantasyTeamService) {
		this.fantasyTeamService = fantasyTeamService;
	}

	public PlayerService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}
	
}
