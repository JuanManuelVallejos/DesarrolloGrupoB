package ar.edu.unq.desapp.grupoB022015.repositories;

import java.util.List;

import org.hibernate.Session;

import ar.edu.unq.desapp.grupoB022015.model.Player;

public class PlayerDAO extends HibernateGenericDAO<Player> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6564114444279587287L;

	@Override
	protected Class<Player> getDomainClass() {
		return Player.class;
	}

	public Player findByName(String name) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
	    try {
	    	String queryStr = " SELECT e FROM " + this.persistentClass.getName() + " AS e WHERE e.name like :name";
	        
	    	@SuppressWarnings("unchecked")
			List<Player> player = session.createQuery(queryStr).setParameter("name", name).list();
	             
	        if(player.size() == 0){
	        	return null;
	        }else{
	        	return player.get(0);
	        }
	        } finally {
	            session.close();
	        }
	}

	
}


