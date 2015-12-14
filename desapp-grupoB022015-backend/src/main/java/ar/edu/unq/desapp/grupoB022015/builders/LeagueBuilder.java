package ar.edu.unq.desapp.grupoB022015.builders;

import ar.edu.unq.desapp.grupoB022015.model.League;
import ar.edu.unq.desapp.grupoB022015.model.SuperGol;

public class LeagueBuilder extends AbstractBuilder<League> {

	@Override
	public League anyObject() {
		return new League();
	}

}
