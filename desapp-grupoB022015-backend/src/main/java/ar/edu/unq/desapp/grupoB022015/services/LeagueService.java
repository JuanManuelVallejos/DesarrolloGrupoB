package ar.edu.unq.desapp.grupoB022015.services;

import ar.edu.unq.desapp.grupoB022015.model.League;
import ar.edu.unq.desapp.grupoB022015.repositories.LeagueDAO;

public class LeagueService extends GenericService<League> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2453337609983268700L;
	
	public League findByName(String name) {
		return ((LeagueDAO) this.getRepository()).findByName(name);
	}

	public void merge(League league) {
		((LeagueDAO) this.getRepository()).merge(league);
	}

}
