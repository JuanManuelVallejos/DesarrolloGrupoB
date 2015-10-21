package ar.edu.unq.desapp.grupoB022015.rest;

import javax.ws.rs.Path;

import ar.edu.unq.desapp.grupoB022015.services.UserService;

@Path("/user")
public class UserRest {
	
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	

}
