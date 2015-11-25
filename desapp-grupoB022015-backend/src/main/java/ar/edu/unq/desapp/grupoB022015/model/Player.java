package ar.edu.unq.desapp.grupoB022015.model;


public class Player  extends Entity{

    private String name;
	private Position position;
	private SuperGol systemUpgrade;
	private int points;
    
	public Player(){}

	public Player(SuperGol superGol, String aName,Position aPosition){
		this.name= aName;
		this.position = aPosition;
		this.points = 0;
		this.setSystemUpgrade(superGol);
	}
	
	public Player(String aName,String aPosition){
		this.name= aName;
		this.position = getPosition(aPosition);
		this.points = 0;
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
	
	public int getPointForNGoals(int amountGoals){
		return getPosition().pointsForGoal(amountGoals);
	}
	
	public void addPointsForNGoals(int amountGoals){
		this.points += getPointForNGoals(amountGoals);
	}
	public SuperGol getSystemUpgrade() {
		return systemUpgrade;
	}
	public void setSystemUpgrade(SuperGol systemUpgrade) {
		this.systemUpgrade = systemUpgrade;
	}
		
}
