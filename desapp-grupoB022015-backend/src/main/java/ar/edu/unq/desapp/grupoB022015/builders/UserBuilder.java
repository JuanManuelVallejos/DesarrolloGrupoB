package ar.edu.unq.desapp.grupoB022015.builders;

import ar.edu.unq.desapp.grupoB022015.model.SuperGol;
import ar.edu.unq.desapp.grupoB022015.model.User;

public class UserBuilder extends AbstractBuilder<User> {

	@Override
	public User anyObject() {
		return new User(1,new SuperGol(),"");
	}

}
