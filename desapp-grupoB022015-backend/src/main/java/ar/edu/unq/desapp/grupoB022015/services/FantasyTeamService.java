package ar.edu.unq.desapp.grupoB022015.services;

import java.util.Set;

import ar.edu.unq.desapp.grupoB022015.model.FantasyTeam;
import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.repositories.FantasyTeamDAO;

public class FantasyTeamService extends GenericService<FantasyTeam> {

	private static final long serialVersionUID = -6652628622081947349L;
	
	public Set<Player> getPlayers() {
		return ((FantasyTeamDAO) this.getRepository()).getAllPlayers();
	}

}
