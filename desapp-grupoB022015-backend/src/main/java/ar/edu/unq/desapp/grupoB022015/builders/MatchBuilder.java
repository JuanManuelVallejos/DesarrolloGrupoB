package ar.edu.unq.desapp.grupoB022015.builders;

import ar.edu.unq.desapp.grupoB022015.model.Match;
import ar.edu.unq.desapp.grupoB022015.model.User;

public class MatchBuilder extends AbstractBuilder<Match> {

	@Override
	public Match anyObject() {
		return new Match(new User(),new User());
	}

}
