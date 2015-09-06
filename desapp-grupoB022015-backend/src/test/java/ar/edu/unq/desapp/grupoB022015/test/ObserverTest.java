package ar.edu.unq.desapp.grupoB022015.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.desapp.grupoB022015.model.Defender;
import ar.edu.unq.desapp.grupoB022015.model.Forward;
import ar.edu.unq.desapp.grupoB022015.model.League;
import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.SuperGol;
import ar.edu.unq.desapp.grupoB022015.model.User;

public class ObserverTest {

	private SuperGol superGol;
	private User u1;
	private User u2;
	private Player p1;
	private Player p2;
	private League league;
	
	@Before
	public void init(){
		
		superGol = new SuperGol();
		league = new League("A name for League");
	
		u1 = new User(1);
		u1.createTeam("a name Team");
		
		u2 = new User(2);
		u2.createTeam("other name Team");
		
		p1 = new Player(superGol, 1, "a name player", new Forward());
		p2 = new Player(superGol, 2, "aNamePlayer", new Defender());
		
		u1.addPlayerToMyTeam(p1);
		u1.addPlayerToMyTeam(p2);
		u2.addPlayerToMyTeam(p2);
		
		u2.addmeToLeague(league);
		u1.addmeToLeague(league);
	}
	
	@Test
	public void testPlayerScoredNGoals(){
		assertEquals(league.getRanking().get(0),u2);
		
		superGol.playerScoredNGoals(p1, 1);
		superGol.playerScoredNGoals(p2, 2);
		
		assertEquals(p1.getPoints(),1);
		assertEquals(u1.getPoints(),7);

		assertEquals(p2.getPoints(),6);
		assertEquals(u2.getPoints(),6);
		assertEquals(league.getRanking().get(0),u1);
	}

}
