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
	
	@Before
    public void init() {
		
		Player goalk1 = Player.PlayerGoalkeeper(superGol, 0 , "goalk1");
		Player goalk2 = Player.PlayerGoalkeeper(superGol, 1 , "goalk2");
		
		Player def1 = Player.PlayerGoalkeeper(superGol, 2 , "def1");
		Player def2 = Player.PlayerGoalkeeper(superGol, 3 , "def2");
		Player def3 = Player.PlayerGoalkeeper(superGol, 4 , "def3");
		Player def4 = Player.PlayerGoalkeeper(superGol, 5 , "def4");
		Player def5 = Player.PlayerGoalkeeper(superGol, 6 , "def5");
		Player def6 = Player.PlayerGoalkeeper(superGol, 7 , "def6");
		
		Player mid1 = Player.PlayerMidfielder(superGol,8, "mid1");
		Player mid2 = Player.PlayerMidfielder(superGol,9, "mid2");
		Player mid3 = Player.PlayerMidfielder(superGol,10, "mid3");
		Player mid4 = Player.PlayerMidfielder(superGol,11, "mid4");
		Player mid5 = Player.PlayerMidfielder(superGol,12, "mid5");
		Player mid6 = Player.PlayerMidfielder(superGol,13, "mid6");
		Player mid7 = Player.PlayerMidfielder(superGol,14, "mid7");
		Player mid8 = Player.PlayerMidfielder(superGol,15, "mid8");
		
		Player for1 = Player.PlayerForward(superGol,16 , "for1");
		Player for2 = Player.PlayerForward(superGol,17 , "for2");
		Player for3 = Player.PlayerForward(superGol,18 , "for3");
		Player for4 = Player.PlayerForward(superGol,19 , "for4");
		Player for5=  Player.PlayerForward(superGol,20 , "for5");
		Player for6 = Player.PlayerForward(superGol,21 , "for6");
		
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
		
		user1.addPlayersToMyTeam(0,  2,3,4,  8,9,10,11,  16,17,18);
		
		assertEquals(11,user1.getTeam().getPlayers().size());
		assertEquals(0,user2.getTeam().getPlayers().size());
	}
	
	@Test(expected = MaximumNumberOfPlayersInTeamException.class)
	public void testExcessAddPlayers() throws Throwable{
		
		user2.addPlayersToMyTeam(1,2,  5,6,7,  12,13,14,15,  19,20,21);
	
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
