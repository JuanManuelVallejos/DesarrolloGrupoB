package ar.edu.unq.desapp.grupoB022015.model;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import ar.edu.unq.desapp.grupoB022015.model.Match;

public class Date {

	private List<Match> matchs;
	private DateTime startDate;
	private DateTime endDate;
	
	
	public Date(List<Match> theMatchs, DateTime aStartDate,DateTime aEndDate){
		matchs = theMatchs;
		startDate = aStartDate;
		endDate = aEndDate;
	}
	
	public DateTime getStartDate(){
		return startDate;
	}
	
	public DateTime getEndDate(){
		return endDate;
	}
	
	public List<Match> getMatchs() {
		return matchs;
	}

	public boolean dateMine(DateTime aDate){
		Interval interval = new Interval(getStartDate(), getEndDate());				
		return false;//interval.contains(aDate);
	}
	
}
