package ar.edu.unq.desapp.grupoB022015.model.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.RealTeam;
import ar.edu.unq.desapp.grupoB022015.model.SuperGol;
import ar.edu.unq.desapp.grupoB022015.model.User;

public class SuperGolTest {

	
	private SuperGol supergol;
	
	@Before
	public void init(){
		supergol =  new SuperGol();
	}
	
	@Test
	public void addRealTeamTest() {
		supergol.addRealTeam("Boca Juniors");
		assertEquals(supergol.getRealTeams().size(),1);
		assertEquals(supergol.getTeamWithName("River") ,null);
	}
	
	@Test
	public void addUserTest(){
		User user = Mockito.mock(User.class);
		supergol.addUser(user);
		assertEquals(supergol.getUsers().get(0),user);
	}
	
	@Test
	public void addPlayerToRealTeam(){
		supergol.addRealTeam("Independiente");
		Player player = Mockito.mock(Player.class);
		supergol.addPlayerTo(player, "Independiente");
		RealTeam indep = supergol.getTeamWithName("Independiente");
		assertEquals(indep.getPlayers().size() , 1);
		assertEquals(indep.getPlayers().get(0),player);
	}

}
