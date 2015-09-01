package ar.edu.unq.desapp.grupoB022015.model;

public abstract class Player {

	private int ID;
    private String name;
	private String position;
	private String team;
    
	public int pointsInAMatch(Match aMatch){
		return 0;
	}
	
	public abstract int calculatePoints();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
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
}
