package ar.edu.unq.desapp.grupoB022015.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ar.edu.unq.desapp.grupoB022015.model.Date;
import ar.edu.unq.desapp.grupoB022015.model.League;
import ar.edu.unq.desapp.grupoB022015.model.Match;
import ar.edu.unq.desapp.grupoB022015.model.User;

public class LeagueTest {

	private League league;
	private User u1;
	private User u2;
	private User u3;
	private User u4;
	
	@Before
	public void init(){
		league = new League("A name for League");
		
		u1 = Mockito.mock(User.class);
		u2 = Mockito.mock(User.class);
		u3 = Mockito.mock(User.class);
		u4 = Mockito.mock(User.class);
		
		league.addUser(u1);league.addUser(u2);
		league.addUser(u3);league.addUser(u4);
	}
	
	
	@Test
	public void testFirstEnd(){
		List<User> users = new ArrayList<User>();
		users.add(u1);users.add(u2);
		users.add(u3);users.add(u4);
		
		assertEquals(users.get(0),u1);
		assertEquals(users.get(1),u2);
		assertEquals(users.get(2),u3);
		assertEquals(users.get(3),u4);
		
		users = league.firstEnd(users);
		
		assertEquals(users.get(0),u2);
		assertEquals(users.get(1),u3);
		assertEquals(users.get(2),u4);
		assertEquals(users.get(3),u1);
	}
	/*RED TESTS
	@Test
	public void testCreateFixtureOnlyTrip_CorrectSize(){
		league.createFixtureOnlyTrip(new DateTime(), 1);
		
		assertEquals(league.getFixture().size(), 3);
	}
	
	@Test
	public void testCreateFixtureRoundTrip_CorrectSize(){
		league.createFixtureRoundTrip(new DateTime(), 1);
		
		assertEquals(league.getFixture().size(), 6);
	}
	
	*/
	@Test
	public void testCreateDateWith(){
		
		List<User> usersA = new ArrayList<User>();
		usersA.add(u1);usersA.add(u2);
		
		List<User> usersB = new ArrayList<User>();
		usersB.add(u3);usersB.add(u4);
		
		Date date = league.createDateWith(new DateTime(), new DateTime(), usersA, usersB);
		List<Match> matchs = date.getMatchs();
		
		assertEquals(matchs.get(0).getLocal(),u1);
		assertEquals(matchs.get(0).getVisitor(),u3);
		assertEquals(matchs.get(1).getLocal(),u2);
		assertEquals(matchs.get(1).getVisitor(),u4);
		
	}
	
}
