package ar.edu.unq.desapp.grupoB022015.builders;

import ar.edu.unq.desapp.grupoB022015.model.Position;
import ar.edu.unq.desapp.grupoB022015.model.Defender;

public class PositionBuilder extends AbstractBuilder<Position> {

	@Override
	public Position anyObject() {
		return new Defender();
	}

}
