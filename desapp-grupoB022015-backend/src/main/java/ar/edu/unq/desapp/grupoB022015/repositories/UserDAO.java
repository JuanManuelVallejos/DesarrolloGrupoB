package ar.edu.unq.desapp.grupoB022015.repositories;

import java.util.List;

import org.hibernate.Session;

import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.User;

public class UserDAO extends HibernateGenericDAO<User>implements GenericRepository<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5408424112494868866L;

	public User findByIdGoogle(String idGoogle) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
	    try {
	    	String queryStr = " SELECT e FROM " + this.persistentClass.getName() + " AS e WHERE e.idGoogle like :idGoogle";
	        
	    	@SuppressWarnings("unchecked")
			List<User> user = session.createQuery(queryStr).setParameter("idGoogle", idGoogle).list();
	             
	        if(user.size() == 0){
	        	return null;
	        }else{
	        	return user.get(0);
	        }
	        } finally {
	            session.close();
	        }
	}

	@Override
	protected Class<User> getDomainClass() {
		return User.class;
	}

}
