package ar.edu.unq.desapp.grupoB022015.builders;

import ar.edu.unq.desapp.grupoB022015.model.PointsForUser;
import ar.edu.unq.desapp.grupoB022015.model.User;

public class PointsForUserBuilder extends AbstractBuilder<PointsForUser> {

	@Override
	public PointsForUser anyObject() {
		return new PointsForUser(new User(), 0);
	}

}
