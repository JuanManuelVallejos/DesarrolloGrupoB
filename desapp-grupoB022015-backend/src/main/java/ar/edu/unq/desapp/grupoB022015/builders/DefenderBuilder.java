package ar.edu.unq.desapp.grupoB022015.builders;

import ar.edu.unq.desapp.grupoB022015.model.Defender;

public class DefenderBuilder extends AbstractBuilder<Defender> {

	@Override
	public Defender anyObject() {
		return new Defender();
	}

}