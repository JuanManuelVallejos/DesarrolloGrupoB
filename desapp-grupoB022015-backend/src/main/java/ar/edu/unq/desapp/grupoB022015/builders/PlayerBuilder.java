package ar.edu.unq.desapp.grupoB022015.builders;

import ar.edu.unq.desapp.grupoB022015.model.Player;


public class PlayerBuilder extends AbstractBuilder<Player> {

	@Override
	public Player anyObject() {
		  return new Player("player", "Defender");
	}

}
