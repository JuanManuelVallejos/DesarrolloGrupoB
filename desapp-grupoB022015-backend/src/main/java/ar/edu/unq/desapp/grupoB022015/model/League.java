package ar.edu.unq.desapp.grupoB022015.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.joda.time.DateTime;

public class League {

	private String name;
	private SuperGol superGol;
	private List<Date> fixture;
	private List<User> ranking;
	private HashMap<User,Integer> rankingForLeague;
	
	public League(String leagueName){
		this.name = leagueName;
		this.fixture = new ArrayList<Date>();
		this.ranking = new ArrayList<User>();
		this.rankingForLeague = new HashMap<User,Integer>();
	}
	
	public League(String leagueName, SuperGol system) {
		this.name = leagueName;
		this.superGol = system;
		this.fixture = new ArrayList<Date>();
		this.ranking = new ArrayList<User>();
		this.rankingForLeague = new HashMap<User,Integer>();
	}
	
	public int getPointsForUserInLeagueTable(User user){
		return this.rankingForLeague.get(user);
	}
	
	public SuperGol getSystem(){
		return this.superGol;
	}
	
	public void refreshPoints(){
		getCurrentDate().setPoints(getSystem().getTable());
	}
	
	public String getName(){
		return this.name;
	}
	
	public List<Date> getFixture(){
		return this.fixture;
	}
	
	//WARNING: need to add Exception 
	public Date getCurrentDate(){
		for ( Date currentDate: fixture)
			if(currentDate.dateMine(new DateTime()))
				return currentDate;
		
		return null;
	}
	
	
	public void createFixtureRoundTrip(DateTime start, int durationOfDateinDays){
		createFixtureOnlyTrip(start,durationOfDateinDays);
		int limitLoop = fixture.size();
		DateTime startNewDate = start.plusDays(durationOfDateinDays * limitLoop);
		DateTime endNewDate = startNewDate.plusDays(durationOfDateinDays);
		for(int index = 0; index < limitLoop;index++){
			fixture.add(fixture.get(index).myOpposite(startNewDate,endNewDate));
			startNewDate = startNewDate.plusDays(durationOfDateinDays);
			endNewDate = endNewDate.plusDays(durationOfDateinDays);
		}
	}
	

	public List<List<User>> splitListUser(List<User> list){
		List<List<User>> listToRet = new ArrayList<List<User>>();
		
		List<User> firstHalf = new ArrayList<User>();
		@SuppressWarnings("unchecked")
		List<User> secondHalf = (List<User>) ((ArrayList<User>)list).clone();
		
		int sizeList = list.size(); 
		for(int i = 0; i<sizeList/2;i++){
			firstHalf.add(secondHalf.get(0));
			secondHalf.remove(0);
		}
		listToRet.add(firstHalf);
		listToRet.add(secondHalf);
		return listToRet;
	}
	
	public void createFixtureOnlyTrip(DateTime start, int durationOfDateinDays){
		int totalSize = ranking.size();
		List<List<User>> halfs = splitListUser(ranking);
		List<User> usersLocals = halfs.get(0);
		List<User> usersVisitors = halfs.get(1);
		Collections.reverse(usersVisitors);
		
		DateTime currentDate = start;
		DateTime finalDate = start.plusDays(durationOfDateinDays);

		for(int numDate = 0; numDate < totalSize-1; numDate++){
			fixture.add(createDateWith(currentDate, finalDate, usersLocals,usersVisitors));

			usersVisitors.add(usersLocals.remove(usersLocals.size()-1));
			usersLocals.add(1,usersVisitors.remove(0));			
			currentDate = finalDate;
			finalDate = finalDate.plusDays(durationOfDateinDays);
		}
	}
	
	
	public Date createDateWith(DateTime startD, DateTime endD, List<User> usersA,List<User> usersB){
		List<Match> matchsOfDate = new ArrayList<Match>();
		for(int indexU = 0; indexU < usersA.size(); indexU ++)
			matchsOfDate.add(new Match(usersA.get(indexU),usersB.get(indexU)));
		return new Date(matchsOfDate, startD, endD);
	}
	
	/**
	 * Search the date
	 * @param numDate is the number of the  date
	 * @return the wanted date
	 */
	public Date getDate(int numDate){
		return fixture.get(numDate-1);
	}
	
	public void addUser(User aUser){
		ranking.add(aUser);
		rankingForLeague.put(aUser,0);
	}
	
	public List<User> getRanking(){
		return ranking;
	}
	
	public void updateRanking(){
		Collections.sort(ranking);
	}
	
	public void updateGeneralRAnking(){
		for(User user : rankingForLeague.keySet()){
			int points = getCurrentDate().getPointsForUser(user);
			rankingForLeague.replace(user, points);
		}
	}
}
