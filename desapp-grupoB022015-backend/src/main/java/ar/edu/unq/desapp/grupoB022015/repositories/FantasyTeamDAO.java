package ar.edu.unq.desapp.grupoB022015.repositories;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import ar.edu.unq.desapp.grupoB022015.model.FantasyTeam;
import ar.edu.unq.desapp.grupoB022015.model.Player;

public class FantasyTeamDAO extends HibernateGenericDAO<FantasyTeam> implements GenericRepository<FantasyTeam> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public List<Player> getPlayers(List<FantasyTeam> fantasyTeams){
        List<Player> players = new ArrayList<Player>();
        for(FantasyTeam ft: fantasyTeams){
        	players.addAll(ft.getPlayers());
     	}
        return players;
	}
	
	@Override
	protected Class<FantasyTeam> getDomainClass() {
		return FantasyTeam.class;
	}

	public Set<Player> getAllPlayers() {
		
	Session session = this.getHibernateTemplate().getSessionFactory().openSession();
    try {
      	 String queryStr = " SELECT d FROM " + this.persistentClass.getName() + " AS d";
         @SuppressWarnings("unchecked")
		 List<FantasyTeam> fantasyTeams = session.createQuery(queryStr).list();
		 List<Player> playersList = getPlayers(fantasyTeams);
         Set<Player> playersSet = new HashSet<Player>();
         playersSet.addAll(playersList);
         return playersSet;

    } finally {
        session.close();
    }
	}
	
}
