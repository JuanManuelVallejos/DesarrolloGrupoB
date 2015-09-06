package ar.edu.unq.desapp.grupoB022015.model;

import java.util.Observable;

public class Player extends Observable{

	private int ID;
    private String name;
	private Position position;
	private SuperGol systemUpgrade;
	private int points;
    
	public Player(){}
	public Player(SuperGol superGol,int id, String aName,Position aPosition){
		this.ID = id;
		this.name= aName;
		this.position = aPosition;
		this.points = 0;
		this.setSystemUpgrade(superGol);
	}
	
	public int pointsInAMatch(Match aMatch){
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public int getPoints(){
		return this.points;
	}
	
	public int getPointForNGoals(int amountGoals){
		return amountGoals*getPosition().pointsForGoal();
	}
	
	public void addPointsForNGoals(int amountGoals){
		this.points += getPointForNGoals(amountGoals);
		setChanged();
		notifyObservers(getPointForNGoals(amountGoals));
	}
	public SuperGol getSystemUpgrade() {
		return systemUpgrade;
	}
	public void setSystemUpgrade(SuperGol systemUpgrade) {
		this.systemUpgrade = systemUpgrade;
	}
		
}
