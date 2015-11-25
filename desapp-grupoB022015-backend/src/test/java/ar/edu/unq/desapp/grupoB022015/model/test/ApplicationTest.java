package ar.edu.unq.desapp.grupoB022015.model.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.desapp.grupoB022015.model.League;
import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.RealTeam;
import ar.edu.unq.desapp.grupoB022015.model.SuperGol;
import ar.edu.unq.desapp.grupoB022015.model.User;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.MaximumNumberOfPlayersInTeamException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.PlayerNotFoundException;

public class ApplicationTest {

	private RealTeam rTeam1 = new RealTeam("rTeam1");
	private RealTeam rTeam2 = new RealTeam("rTeam2");
	private SuperGol superGol = new SuperGol();
	private ArrayList<Player> playersTeam1 = new ArrayList<Player>();
	private ArrayList<Player> playersTeam2 = new ArrayList<Player>();
	private User user1 = superGol.createNewUserWithTeam("aName","aTeam");
	private User user2 = superGol.createNewUserWithTeam("otherName","otherTeam");
	
		
	private Player goalk1 = new Player("goalk1","Goalkeeper");
	private Player goalk2 = new Player("goalk2","Goalkeeper");

	private Player def1 = new Player("def1", "Defender");
	private Player def2 = new Player("def2", "Defender");
	private Player def3 = new Player("def3", "Defender");
	private Player def4 = new Player("def4", "Defender");
	private Player def5 = new Player("def5", "Defender");
	private Player def6 = new Player("def6", "Defender");

	private Player mid1 = new Player( "mid1","Midfielder");
	private Player mid2 = new Player("mid2","Midfielder");
	private Player mid3 = new Player("mid3","Midfielder");
	private Player mid4 = new Player("mid4","Midfielder");
	private Player mid5 = new Player("mid5","Midfielder");
	private Player mid6 = new Player("mid6","Midfielder");
	private Player mid7 = new Player("mid7","Midfielder");
	private Player mid8 = new Player("mid8","Midfielder");

	private Player for1 = new Player("for1","Forward");
	private Player for2 = new Player("for2","Forward");
	private Player for3 = new Player("for3","Forward");
	private Player for4 = new Player("for4","Forward");
	private Player for5=  new Player("for5","Forward");
	private Player for6 = new Player("for6","Forward");
	
	@Before	
	public void init() {	
		playersTeam1.add(goalk1);playersTeam1.add(def1);playersTeam1.add(def2);
		playersTeam1.add(def3);playersTeam1.add(mid1);playersTeam1.add(mid2);
		playersTeam1.add(mid3);playersTeam1.add(mid4);playersTeam1.add(for1);
		playersTeam1.add(for2);playersTeam1.add(for3);
		
		playersTeam2.add(goalk2);playersTeam2.add(def4);playersTeam2.add(def5);
		playersTeam2.add(def6);playersTeam2.add(mid5);playersTeam2.add(mid6);
		playersTeam2.add(mid7);playersTeam2.add(mid8);playersTeam2.add(for4);
		playersTeam2.add(for5);playersTeam2.add(for6);
		
		rTeam1.setPlayers(playersTeam1);
		rTeam2.setPlayers(playersTeam2);

		superGol.addRealTeam(rTeam1);
		superGol.addRealTeam(rTeam2);
	}
	
	@Test
	public void testCorrectAddPlayers() throws Throwable{
		
		user1.addPlayersToMyTeam(goalk1.getId(),
								 def1.getId(),def2.getId(),def3.getId(),
								 mid1.getId(),mid2.getId(),mid3.getId(),mid4.getId(),
								 for1.getId(),for2.getId(),for3.getId());
		
		assertEquals(11,user1.getTeam().getPlayers().size());
		assertEquals(0,user2.getTeam().getPlayers().size());
	}
	
	@Test(expected = MaximumNumberOfPlayersInTeamException.class)
	public void testExcessAddPlayers() throws Throwable{
		
		user1.addPlayersToMyTeam(goalk2.getId(),
				 def4.getId(),def5.getId(),def6.getId(),
				 mid5.getId(),mid6.getId(),mid7.getId(),mid8.getId(),
				 for3.getId(),for4.getId(),for5.getId(),for6.getId());
	
	}
	
	@Test(expected = PlayerNotFoundException.class)
	public void testNotExistPlayerInAddPlayers() throws Throwable{
		user1.addPlayersToMyTeam(20122);
	}
	
	@Test
	public void testUserCreatesLeague(){
		League league = user1.createLeague("aLeagueName");
		
		assert(league.getRanking().contains(user1));
		//assert(user1.getLeagues().contains(league));
	}
	
}
