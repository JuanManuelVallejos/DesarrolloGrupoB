package ar.edu.unq.desapp.grupoB022015.repositories;

import ar.edu.unq.desapp.grupoB022015.model.User;

public class UserDAO extends HibernateGenericDAO<User>implements GenericRepository<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5408424112494868866L;

	

	@Override
	protected Class<User> getDomainClass() {
		return User.class;
	}

}
