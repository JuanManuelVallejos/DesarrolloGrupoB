package ar.edu.unq.desapp.grupoB022015.builders;

import ar.edu.unq.desapp.grupoB022015.model.Forward;

public class ForwardBuilder extends AbstractBuilder<Forward> {

	@Override
	public Forward anyObject() {
		return new Forward();
	}

}