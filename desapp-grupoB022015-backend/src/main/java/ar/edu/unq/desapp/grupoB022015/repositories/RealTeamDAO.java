package ar.edu.unq.desapp.grupoB022015.repositories;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import ar.edu.unq.desapp.grupoB022015.model.RealTeam;
import ar.edu.unq.desapp.grupoB022015.model.Player;

public class RealTeamDAO extends HibernateGenericDAO<RealTeam> implements GenericRepository<RealTeam> {


	
	public List<Player> getPlayers(List<RealTeam> realTeams){
        List<Player> players = new ArrayList<Player>();
        for(RealTeam rt: realTeams){
        	players.addAll(rt.getPlayers());
     	}
        return players;
	}
	
	@Override
	protected Class<RealTeam> getDomainClass() {
		return RealTeam.class;
	}

	public Set<Player> getAllPlayers() {
		
	Session session = this.getHibernateTemplate().getSessionFactory().openSession();
    try {
      	 String queryStr = " SELECT d FROM " + this.persistentClass.getName() + " AS d";
         @SuppressWarnings("unchecked")
		 List<RealTeam> realTeams = session.createQuery(queryStr).list();
		 List<Player> playersList = getPlayers(realTeams);
         Set<Player> playersSet = new HashSet<Player>();
         playersSet.addAll(playersList);
         return playersSet;

    } finally {
        session.close();
    }
	}
	
	
	public RealTeam findByTeamName(String name) {
		//funciona si los nombres de equipos son unicos
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
	    try {
	    	String queryStr = " SELECT e FROM " + this.persistentClass.getName() + " AS e WHERE e.name like :name";
	        
	    	@SuppressWarnings("unchecked")
			List<RealTeam> team = session.createQuery(queryStr).setParameter("name", name).list();
	             
	        if(team.size() == 0){
	        	return null;
	        }else{
	        	return team.get(0);
	        }
	        } finally {
	            session.close();
	        }
	}

}
