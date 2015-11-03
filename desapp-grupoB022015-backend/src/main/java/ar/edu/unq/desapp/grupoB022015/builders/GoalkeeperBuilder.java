package ar.edu.unq.desapp.grupoB022015.builders;

import ar.edu.unq.desapp.grupoB022015.model.Goalkeeper;

public class GoalkeeperBuilder extends AbstractBuilder<Goalkeeper> {

	@Override
	public Goalkeeper anyObject() {
		return new Goalkeeper();
	}

}