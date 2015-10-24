package ar.edu.unq.desapp.grupoB022015.repositories;

import ar.edu.unq.desapp.grupoB022015.model.Match;

public class MatchDAO extends HibernateGenericDAO<Match> implements GenericRepository<Match> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9043793740931228834L;

	@Override
	protected Class<Match> getDomainClass() {
		// TODO Auto-generated method stub
		return Match.class;
	}

}
