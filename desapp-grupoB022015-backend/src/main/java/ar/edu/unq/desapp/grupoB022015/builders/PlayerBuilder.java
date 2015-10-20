package ar.edu.unq.desapp.grupoB022015.builders;

import ar.edu.unq.desapp.grupoB022015.model.Defender;
import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.SuperGol;


public class PlayerBuilder extends AbstractBuilder<Player> {

	@Override
	public Player anyObject() {
		  return new Player(new SuperGol(), 10, "player", new Defender());
	}

}
