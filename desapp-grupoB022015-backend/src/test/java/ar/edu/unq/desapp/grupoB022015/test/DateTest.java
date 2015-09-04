package ar.edu.unq.desapp.grupoB022015.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ar.edu.unq.desapp.grupoB022015.model.Date;
import ar.edu.unq.desapp.grupoB022015.model.Match;
import ar.edu.unq.desapp.grupoB022015.model.User;

public class DateTest {


	private List<Match> matchs = new ArrayList<Match>();
	private DateTime dateStart =  new DateTime("2015-03-01");
	private DateTime dateEnd = new DateTime("2015-03-07");
	
	@Before
    public void init() {
		User u1 = Mockito.mock(User.class);
		User u2 = Mockito.mock(User.class);
		User u3 = Mockito.mock(User.class);
		User u4 = Mockito.mock(User.class);
		
		Match match1 = new Match(u1,u2);
		Match match2 = new Match(u3,u4);
		
		matchs.add(match1);
		matchs.add(match2);
    }
	
	@Test
	public void testDateMinePositive() {
		DateTime dateTest = new DateTime("2015-03-05");
		Date date = new Date(matchs,dateStart,dateEnd);

		assertTrue(date.dateMine(dateTest));
	}
	
	@Test
	public void testDateMineNegative() {
		DateTime dateTest = new DateTime("2015-03-08");
		Date date = new Date(matchs,dateStart,dateEnd);

		assertFalse(date.dateMine(dateTest));
	}
	
	@Test
	public void testMyOpposite(){
		Date date = new Date(matchs,dateStart,dateEnd);
		Date dateWithmatchsOpposites = date.myOpposite(dateStart, dateEnd);
		List<Match> matchsOpposites = dateWithmatchsOpposites.getMatchs();
		
		assertEquals(matchs.get(0).getLocal  () , matchsOpposites.get(0).getVisitor() );
		assertEquals(matchs.get(0).getVisitor() , matchsOpposites.get(0).getLocal()   );
		
		assertEquals(matchs.get(1).getLocal  () , matchsOpposites.get(1).getVisitor() );
		assertEquals(matchs.get(1).getVisitor() , matchsOpposites.get(1).getLocal()   );
		
	}
	
	
}
