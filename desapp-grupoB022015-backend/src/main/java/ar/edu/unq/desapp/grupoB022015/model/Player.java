package ar.edu.unq.desapp.grupoB022015.model;

public class Player {

	private int ID;
    private String name;
	private Position position;
	private String team;
    
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

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public int getPointForNGoals(int amountGoals){
		return amountGoals*getPosition().pointsForGoal();
	}
	
}
