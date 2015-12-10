package ar.edu.unq.desapp.grupoB022015.services;

import ar.edu.unq.desapp.grupoB022015.model.User;
import ar.edu.unq.desapp.grupoB022015.repositories.UserDAO;

public class UserService extends GenericService<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6143091016226478860L;

	public User findByIdGoogle(String idGoogle) {
		return ((UserDAO) this.getRepository()).findByIdGoogle(idGoogle);
	}

	
	
}
