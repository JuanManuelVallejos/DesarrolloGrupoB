package ar.edu.unq.desapp.grupoB022015.model;

public class User implements Comparable<User>{//Comparable<User>{

	private int points;
	
	public int getPoints(){
		return this.points;
	}
	
	public int compareTo(User otherUser) {
		return this.getPoints() - otherUser.getPoints();
	}
		
	
}
