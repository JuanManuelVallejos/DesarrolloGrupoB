package ar.edu.unq.desapp.grupoB022015.services;

import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.repositories.PlayerDAO;

public class PlayerService extends GenericService<Player> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4264669542806269937L;

	public Player findByName(String name) {
		return ((PlayerDAO) this.getRepository()).findByName(name);
	}
}
