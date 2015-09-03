package ar.edu.unq.desapp.grupoB022015.test;

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
	private DateTime dateStart;
	private DateTime dateEnd;

	@Before
    public void init() {
		Match aMatchMocked = Mockito.mock(Match.class);
		aListMocked.add(aMatchMocked);
		DateTime dateStart = new DateTime("2015-03-01"); 
		DateTime dateEnd = new DateTime("2015-03-07");
    }
	
	@Test
	public void dateMinePositivetest() {
		
		DateTime dateTest = new DateTime("2015-03-05");
		
		Date date = new Date(aListMocked,dateStart,dateEnd);
		
		assert(date.dateMine(dateTest));
	}
	
	@Test
	public void dateMineNegativetest() {
		
		DateTime dateTest = new DateTime("2015-03-08");
		
		Date date = new Date(aListMocked,dateStart,dateEnd);
		
		assert(!date.dateMine(dateTest));
		
	}
	
}
