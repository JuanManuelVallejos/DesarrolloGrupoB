package ar.edu.unq.desapp.grupoB022015.repositories;

import ar.edu.unq.desapp.grupoB022015.model.League;

public class LeagueDAO extends HibernateGenericDAO<League>implements GenericRepository<League> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -176962814322141182L;

	@Override
	protected Class<League> getDomainClass() {
		return League.class;
	}

}
