package ar.edu.unq.desapp.grupoB022015.services;

import java.util.Set;

import ar.edu.unq.desapp.grupoB022015.model.RealTeam;
import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.repositories.RealTeamDAO;

public class RealTeamService  extends GenericService<RealTeam> {

	
	public Set<Player> getPlayers() {
		return ((RealTeamDAO) this.getRepository()).getAllPlayers();
	}

	public RealTeam findByTeamName(String teamname) {
		return  ((RealTeamDAO) this.getRepository()).findByTeamName(teamname);
	}
}
