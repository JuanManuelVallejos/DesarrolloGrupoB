package ar.edu.unq.desapp.grupoB022015.model;

public class User implements Comparable<User>{

	private int ID;
	private int points;
	
	public User(int ID_U){
		this.ID = ID_U;
		this.points = 0;
	}
	
	public int getID(){
		return this.ID;
	}
	
	public int getPoints(){
		return this.points;
	}
	
	public int compareTo(User otherUser) {
		return this.getPoints() - otherUser.getPoints();
	}
	
}
