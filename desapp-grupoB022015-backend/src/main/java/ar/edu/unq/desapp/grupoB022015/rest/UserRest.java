package ar.edu.unq.desapp.grupoB022015.rest;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ar.edu.unq.desapp.grupoB022015.model.SuperGol;
import ar.edu.unq.desapp.grupoB022015.model.User;
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
	
	@POST
	@Path("/create")
	@Produces("application/json")
	public Response createUser(@FormParam("name") String name,
			 @FormParam("ID") int id, @FormParam("supergol") SuperGol supergol){
		
		
		User user = getUserService().findById(id);
		
		if(user == null){
			//pasar supergol q corresponde
			User p = new User(id, new SuperGol(), name);
			getUserService().save(p);
		}else{
			return Response.ok(-1).build();
		}
		return Response.ok(user).build();
	}
	
	@GET
    @Path("/list")
    @Produces("application/json")
    public List<User> getUsers() {
        List<User> users = userService.retriveAll();
        return users;
    }

}
