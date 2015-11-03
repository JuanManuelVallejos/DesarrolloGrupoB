package ar.edu.unq.desapp.grupoB022015.builders;

import ar.edu.unq.desapp.grupoB022015.model.Midfielder;

public class MidfielderBuilder extends AbstractBuilder<Midfielder> {

	@Override
	public Midfielder anyObject() {
		return new Midfielder();
	}

}