package ar.edu.unq.desapp.grupoB022015.services;

public class GeneralService {

	private FantasyTeamService fantasyTeamService;
	private PlayerService playerService;
	private PositionService positionService;
	private UserService userService;
	private LeagueService leagueService;
	private DateService dateService;
	private PointsForUserService pointsForUserService;
	
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
	
	public PositionService getPositionService() {
		return positionService;
	}

	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public LeagueService getLeagueService() {
		return leagueService;
	}

	public void setLeagueService(LeagueService leagueService) {
		this.leagueService = leagueService;
	}
	
	public DateService getDateService() {
		return dateService;
	}

	public void setDateService(DateService dateService) {
		this.dateService = dateService;
	}
	
	public PointsForUserService getPointsForUserService() {
		return pointsForUserService;
	}

	public void setPointsForUserService(PointsForUserService pointsForUserService) {
		this.pointsForUserService = pointsForUserService;
	}
	
}
