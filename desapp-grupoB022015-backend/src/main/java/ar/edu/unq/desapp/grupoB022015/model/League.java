package ar.edu.unq.desapp.grupoB022015.model;

import java.util.Collections;
import java.util.List;

import org.joda.time.DateTime;

public class League {

	private int currentDate = 1;
	private List<Date> dates;
	private List<Integer> IDusers;
	private List<User> ranking;
	
	public Date getCurrentDate(){
		for ( Date currentDate: dates)
			if(currentDate.dateMine(new DateTime()))
				return currentDate;
		
		return null;
	}
	
	/**
	 * Search the date
	 * @param numDate is the number of the  date
	 * @return the wanted date
	 */
	public Date getDate(int numDate){
		return dates.get(numDate-1);
	}
	
	public void updateRanking(){
		Collections.sort(ranking);
	}
	
}
