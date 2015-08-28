package main.java.ar.edu.unq.desapp.grupoB022015.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class League {

	private int currentDate = 1;
	private List<Date> dates;
	private List<Integer> IDusers;
	private List<User> ranking;
	
	public int getCurrentDate(){
		return currentDate;
	}

	/**
	 * Updates the number of date
	 * @param date is the current number date
	 */
	public void refreshCurrentDate(int date){
		currentDate = date;
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
