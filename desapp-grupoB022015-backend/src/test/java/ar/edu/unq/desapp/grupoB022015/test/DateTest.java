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

public class DateTest {


	private List<Match> aListMocked = new ArrayList<Match>();
	private DateTime dateStart =  new DateTime("2015-03-01");
	private DateTime dateEnd = new DateTime("2015-03-07");

	@Before
    public void init() {
		Match aMatchMocked = Mockito.mock(Match.class);
		aListMocked.add(aMatchMocked);
    }
	
	@Test
	public void testDateMinePositive() {
		
		DateTime dateTest = new DateTime("2015-03-05");
		
		Date date = new Date(aListMocked,dateStart,dateEnd);

		assertTrue(date.dateMine(dateTest));
	}
	
	@Test
	public void testDateMineNegative() {
		
		DateTime dateTest = new DateTime("2015-03-08");
		
		Date date = new Date(aListMocked,dateStart,dateEnd);

		assertFalse(date.dateMine(dateTest));
		
	}
	
}
