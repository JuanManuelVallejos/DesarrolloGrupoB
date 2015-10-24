package ar.edu.unq.desapp.grupoB022015.repositories;

import ar.edu.unq.desapp.grupoB022015.model.PointsForUser;

public class PointsForUserDAO extends HibernateGenericDAO<PointsForUser> implements GenericRepository<PointsForUser> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8818284680868015166L;

	@Override
	protected Class<PointsForUser> getDomainClass() {
		// TODO Auto-generated method stub
		return PointsForUser.class;
	}

}
