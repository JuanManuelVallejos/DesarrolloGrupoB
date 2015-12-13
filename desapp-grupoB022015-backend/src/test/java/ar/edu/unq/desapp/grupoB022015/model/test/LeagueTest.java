package ar.edu.unq.desapp.grupoB022015.model.test;

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
import ar.edu.unq.desapp.grupoB022015.model.SuperGol;
import ar.edu.unq.desapp.grupoB022015.model.User;

public class LeagueTest {

	private League league;
	private User u1;
	private User u2;
	private User u3;
	private User u4;
	
	@Before
	public void init(){
		SuperGol dummySuperGol = Mockito.mock(SuperGol.class);
		league = new League("A name for League", dummySuperGol);
		
		u1 = Mockito.mock(User.class);
		u2 = Mockito.mock(User.class);
		u3 = Mockito.mock(User.class);
		u4 = Mockito.mock(User.class);
		
		league.addUser(u1);league.addUser(u2);
		league.addUser(u3);league.addUser(u4);
	}
	
	@Test
	public void testCreateFixtureOnlyTrip_CorrectSize(){
		league.createFixtureOnlyTrip(new DateTime(), 1);
		
		assertEquals(league.getFixture().size(), 3);
	}
	
	@Test
	public void testCreateFixtureOnlyTrip_CorrectMatchs(){
		league.createFixtureOnlyTrip(new DateTime(), 1);
		
		List<Date> fixture = league.getFixture();
		List<Match> matchs_zero = fixture.get(0).getMatchs();
		List<Match> matchs_one = fixture.get(1).getMatchs();
		List<Match> matchs_two = fixture.get(2).getMatchs();
		
		assertEquals(matchs_zero.get(0).getLocal(),u1);
		assertEquals(matchs_zero.get(0).getVisitor(),u4);
		assertEquals(matchs_zero.get(1).getLocal(),u2);
		assertEquals(matchs_zero.get(1).getVisitor(),u3);
		
		assertEquals(matchs_one.get(0).getLocal(),u1);
		assertEquals(matchs_one.get(0).getVisitor(),u3);
		assertEquals(matchs_one.get(1).getLocal(),u4);
		assertEquals(matchs_one.get(1).getVisitor(),u2);
		
		assertEquals(matchs_two.get(0).getLocal(),u1);
		assertEquals(matchs_two.get(0).getVisitor(),u2);
		assertEquals(matchs_two.get(1).getLocal(),u3);
		assertEquals(matchs_two.get(1).getVisitor(),u4);
		
	}
	
	@Test
	public void testCreateFixtureOnlyTrip_CorrectDates(){
		league.createFixtureRoundTrip(new DateTime(2000,1,1,0,0,0), 5);
		
		Date firstDate = league.getDate(1);
		Date secondDate = league.getDate(2);
		Date thirdDate = league.getDate(3);
		
		assertTrue(firstDate.getStartDate().isEqual(new DateTime(2000,1,1,0,0,0)));
		assertTrue(firstDate.getEndDate().isEqual(new DateTime(2000,1,6,0,0,0)));
		
		assertTrue(secondDate.getStartDate().isEqual(new DateTime(2000,1,6,0,0,0)));
		assertTrue(secondDate.getEndDate().isEqual(new DateTime(2000,1,11,0,0,0)));
		
		assertTrue(thirdDate.getStartDate().isEqual(new DateTime(2000,1,11,0,0,0)));
		assertTrue(thirdDate.getEndDate().isEqual(new DateTime(2000,1,16,0,0,0)));
		
	}
	
	@Test
	public void testCreateFixtureRoundTrip_CorrectSize(){
		league.createFixtureRoundTrip(new DateTime(), 1);
		
		assertEquals(league.getFixture().size(), 6);
	}
	
	@Test
	public void testCreateFixtureRoundTrip_CorrectMatchs(){
		league.createFixtureRoundTrip(new DateTime(), 1);
		
		List<Date> fixture = league.getFixture();
		List<Match> matchs_zero = fixture.get(0).getMatchs();
		List<Match> matchs_one = fixture.get(1).getMatchs();
		List<Match> matchs_two = fixture.get(2).getMatchs();
		List<Match> matchs_three = fixture.get(3).getMatchs();
		List<Match> matchs_four = fixture.get(4).getMatchs();
		List<Match> matchs_five = fixture.get(5).getMatchs();
		
		//TRIP 		
		assertEquals(matchs_zero.get(0).getLocal(),u1);
		assertEquals(matchs_zero.get(0).getVisitor(),u4);
		assertEquals(matchs_zero.get(1).getLocal(),u2);
		assertEquals(matchs_zero.get(1).getVisitor(),u3);
		
		assertEquals(matchs_one.get(0).getLocal(),u1);
		assertEquals(matchs_one.get(0).getVisitor(),u3);
		assertEquals(matchs_one.get(1).getLocal(),u4);
		assertEquals(matchs_one.get(1).getVisitor(),u2);
		
		assertEquals(matchs_two.get(0).getLocal(),u1);
		assertEquals(matchs_two.get(0).getVisitor(),u2);
		assertEquals(matchs_two.get(1).getLocal(),u3);
		assertEquals(matchs_two.get(1).getVisitor(),u4);
		
		//ROUND
		assertEquals(matchs_three.get(0).getLocal(),u4);
		assertEquals(matchs_three.get(0).getVisitor(),u1);
		assertEquals(matchs_three.get(1).getLocal(),u3);
		assertEquals(matchs_three.get(1).getVisitor(),u2);
		
		assertEquals(matchs_four.get(0).getLocal(),u3);
		assertEquals(matchs_four.get(0).getVisitor(),u1);
		assertEquals(matchs_four.get(1).getLocal(),u2);
		assertEquals(matchs_four.get(1).getVisitor(),u4);
		
		assertEquals(matchs_five.get(0).getLocal(),u2);
		assertEquals(matchs_five.get(0).getVisitor(),u1);
		assertEquals(matchs_five.get(1).getLocal(),u4);
		assertEquals(matchs_five.get(1).getVisitor(),u3);
		
	}
	
	@Test
	public void testCreateFixtureRoundTrip_CorrectDates(){
		league.createFixtureRoundTrip(new DateTime(2000,1,20,0,0,0), 5);
		
		Date firstDate = league.getDate(1);
		Date secondDate = league.getDate(2);
		Date thirdDate = league.getDate(3);
		Date fourthDate = league.getDate(4);
		Date fifthDate = league.getDate(5);
		Date sixthDate = league.getDate(6);
		
		assertTrue(firstDate.getStartDate().isEqual(new DateTime(2000,1,20,0,0,0)));
		assertTrue(firstDate.getEndDate().isEqual(new DateTime(2000,1,25,0,0,0)));
		
		assertTrue(secondDate.getStartDate().isEqual(new DateTime(2000,1,25,0,0,0)));
		assertTrue(secondDate.getEndDate().isEqual(new DateTime(2000,1,30,0,0,0)));
		
		assertTrue(thirdDate.getStartDate().isEqual(new DateTime(2000,1,30,0,0,0)));
		assertTrue(thirdDate.getEndDate().isEqual(new DateTime(2000,2,4,0,0,0)));
		
		assertTrue(fourthDate.getStartDate().isEqual(new DateTime(2000,2,4,0,0,0)));
		assertTrue(fourthDate.getEndDate().isEqual(new DateTime(2000,2,9,0,0,0)));
		
		assertTrue(fifthDate.getStartDate().isEqual(new DateTime(2000,2,9,0,0,0)));
		assertTrue(fifthDate.getEndDate().isEqual(new DateTime(2000,2,14,0,0,0)));
		
		assertTrue(sixthDate.getStartDate().isEqual(new DateTime(2000,2,14,0,0,0)));
		assertTrue(sixthDate.getEndDate().isEqual(new DateTime(2000,2,19,0,0,0)));
	}
	
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
	
	@Test
	public void testSplitListUser(){
		List<List<User>> lists = league.splitListUser(league.getRanking());
		List<User> firstHalf = league.getRanking().subList(0, league.getRanking().size()/2);
		List<User> secondHalf = league.getRanking().subList(league.getRanking().size()/2, league.getRanking().size());
		assertEquals(lists.get(0),firstHalf);
		assertEquals(lists.get(1),secondHalf);
	}
	
	@Test
	public void testSplitListUserWithTwoUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User("pancho"));
		users.add(new User("pepe"));
		List<List<User>> lists = league.splitListUser(users);
		assertEquals(lists.size(), 2);
	}
	
}
