package ar.edu.unq.desapp.grupoB022015.repositories;

import java.util.List;

import org.hibernate.Session;

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
	
	public League findByName(String name) {
		
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        try {
        	 String queryStr = " SELECT e FROM " + this.persistentClass.getName() + " AS e WHERE e.name like :name";

             @SuppressWarnings("unchecked")
			List<League> leagues = session.createQuery(queryStr).setParameter("name", name).list();
             
             if(leagues.size() == 0){
            	 return null;
             }else{
            	 return leagues.get(0);
             }

        } finally {
            session.close();
        }
	}

}
