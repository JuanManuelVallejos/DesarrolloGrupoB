package ar.edu.unq.desapp.grupoB022015.model;

import java.util.ArrayList;
import java.util.List;


public class Player  extends Entity{

    private String name;
	private Position position;
	private SuperGol systemUpgrade;
	private int points;

	private int[] pointsForDate;
	
	public Player(){}
	
	public Player(String aName,String aPosition){
		this.name= aName;
		this.position = getPosition(aPosition);
		this.points = 0;
		this.setPointsForDate(new int[]{0,0,0,0,0});
	}

	public static Position getPosition(String position) {
		if(position.equals("Goalkeeper"))
			return new Goalkeeper();
		if(position.equals("Defender"))
			return new Defender();
		if(position.equals("Midfielder"))
			return new Midfielder();
		return new Forward();
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
	
	public int getPoints(){
		return this.points;
	}
	
	public void setPoints(int points){
		this.points = points;
	}
	
	public int calculatePointForNGoals(int amountGoals){
		return getPosition().pointsForGoal(amountGoals);
	}
	
	public void addPointsForNGoals(int amountGoals){
		int pointsBefore = getPoints();
		int pointsForGoals = calculatePointForNGoals(amountGoals);
		setPoints(pointsBefore + pointsForGoals);
	}
	public SuperGol getSystemUpgrade() {
		return systemUpgrade;
	}
	public void setSystemUpgrade(SuperGol systemUpgrade) {
		this.systemUpgrade = systemUpgrade;
	}

	public int[] getPointsForDate() {
		return pointsForDate;
	}

	public void setPointsForDate(int[] pointsForDate) {
		this.pointsForDate = pointsForDate;
	}

	public void updateGoalsForADate(int goals, int date){
		this.getPointsForDate()[date]= calculatePointForNGoals(goals);
	}
}
