package ar.edu.unq.desapp.grupoB022015.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.InvalidDateForThisLeagueException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.UserNotFoundException;

public class League extends Entity{

	private String name;
	private SuperGol superGol;
	private List<Date> fixture;
	private List<PointsForUser> rankingForLeague;
	private int minTeams;
	private int maxTeams;
	private int currentDate;
	
	public League(){}
	
	public League(String leagueName, SuperGol system) {
		this.name = leagueName;
		this.superGol = system;
		this.fixture = new ArrayList<Date>();
		this.rankingForLeague = new ArrayList<PointsForUser>();
		this.setCurrentDate(0);
	}
	
	public League(String leagueName, int min, int max) {
		this.name = leagueName;
		this.fixture = new ArrayList<Date>();
		this.rankingForLeague = new ArrayList<PointsForUser>();
		this.setMinTeams(min);
		this.setMaxTeams(max);
		this.setCurrentDate(0);
	}
	
	public void updateLeague(String name, int minTeams, int maxTeams){
		this.setName(name);
		this.setMaxTeams(maxTeams);
		this.setMinTeams(minTeams);
	}

	public Integer getTablePointsForUser(User user) throws UserNotFoundException{
		for(PointsForUser pfu : this.rankingForLeague){
			if(pfu.getKey()==user){
				return pfu.getValue();
			}
		}
		throw new UserNotFoundException();
	}
	
	public SuperGol getSystem(){
		return this.superGol;
	}
	
	public void refreshTablePoints() throws Throwable {
		currentDate().setPoints(getSystem().getTable());
	}
	
	public String getName(){
		return this.name;
	}
	
	public List<Date> getFixture(){
		return this.fixture;
	}
	
	public Date currentDate() throws Throwable{
		for ( Date currentDate: fixture)
			if(currentDate.dateMine(new DateTime()))
				return currentDate;
		
		throw new InvalidDateForThisLeagueException();
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
		List<User> secondHalf = new ArrayList<User>();
		//List<User> secondHalf = (List<User>) ((ArrayList<User>)list).clone();
		for(User user : list){
			secondHalf.add(user);
		}
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
		int totalSize = searchRanking().size();
		List<List<User>> halfs = splitListUser(searchRanking());
		List<User> usersLocals = halfs.get(0);
		List<User> usersVisitors = halfs.get(1);
		Collections.reverse(usersVisitors);
		
		DateTime currentDate = start;
		DateTime finalDate = start.plusDays(durationOfDateinDays);

		for(int numDate = 0; numDate < totalSize-1; numDate++){
			fixture.add(createDateWith(currentDate, finalDate, usersLocals,usersVisitors));

			int last = usersLocals.size()-1;
			User newUserVisitor = usersLocals.remove(last);
			usersVisitors.add(newUserVisitor);
			User newUserLocal = usersVisitors.remove(0); 
			if(searchRanking().size() == 2){
				usersLocals.add(newUserLocal);
			}else{
				usersLocals.add(1,newUserLocal);
			}
			currentDate = finalDate;
			finalDate = finalDate.plusDays(durationOfDateinDays);
		}
	}
	
	
	public Date createDateWith(DateTime startD, DateTime endD, List<User> usersA,List<User> usersB){
		List<Match> matchsOfDate = new ArrayList<Match>();
		for(int indexU = 0; indexU < usersA.size(); indexU ++){
			Match match = new Match(usersA.get(indexU),usersB.get(indexU));
			matchsOfDate.add(match);
		}
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
		PointsForUser pfu = new PointsForUser(aUser,0);
		rankingForLeague.add(pfu);
	}
	
	public void addUser(User aUser, PointsForUser pfu){
		rankingForLeague.add(pfu);
	}
	
	public List<User> searchRanking(){
		List<User> users = new ArrayList<User>();
		for(PointsForUser pfu : rankingForLeague ){
			users.add(pfu.getKey());
		}
		return users;
	}

	public void updateGeneralRAnking() throws Throwable{
		for(PointsForUser pfu : this.rankingForLeague){
			User user = pfu.getKey();
			int newPoints = currentDate().getPointsForUser(user);
			int oldPoints = pfu.getValue();
			pfu.setValue(newPoints+oldPoints);
		}
		
	}
	
	public Boolean satisfiesTeams(){
		int sizeTeams = searchRanking().size(); 
		return ((sizeTeams >= getMinTeams()) && (sizeTeams <= getMaxTeams()));
	}
	
	public List<PointsForUser> getRankingForLeague() {
		return rankingForLeague;
	}
	
	public void setRankingForLeague(List<PointsForUser> rankingForL) {
		this.rankingForLeague= rankingForL;
	}
	
	public int getMinTeams() {
		return minTeams;
	}
	public void setMinTeams(int minTeams) {
		this.minTeams = minTeams;
	}
	public int getMaxTeams() {
		return maxTeams;
	}
	public void setMaxTeams(int maxTeams) {
		this.maxTeams = maxTeams;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	public int getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(int currentDate) {
		this.currentDate = currentDate;
	}
	
	public void setFixture(List<Date> fixture) {
		this.fixture = fixture;
	}
	
	
	public void assignParameters(String name2, Integer minTeams2,Integer maxTeams2) {
		setFixture(new ArrayList<Date>());
		setName(name2);
		setMinTeams(minTeams2);
		setMaxTeams(maxTeams2);
		setRankingForLeague(new ArrayList<PointsForUser>());
	}
}
