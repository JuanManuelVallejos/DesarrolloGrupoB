package ar.edu.unq.desapp.grupoB022015.model;

import java.util.ArrayList;
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
		return interval.contains(aDate);
	}

	public Date myOpposite(DateTime newStart, DateTime newEnd) {
		List<Match> oppositeMatchs = new ArrayList<Match>();
		for(Match currentMatch: matchs){
			oppositeMatchs.add(new Match(currentMatch.getVisitor(),currentMatch.getLocal()));
		}
		return new Date(oppositeMatchs,newStart,newEnd);
	}

	public void setPoints(TableForDate table) {
		for(Match match : getMatchs())
			match.setPoints(table);
	}

	public Match getMatchForUser(User user){
		for(Match match : getMatchs()){
			if(match.existUser(user)){
				return match;
			}
		}
		return null;
	}
	
	public int getPointsForUser(User user) {
		return getMatchForUser(user).getPointsForUser(user);
	}
	
}
