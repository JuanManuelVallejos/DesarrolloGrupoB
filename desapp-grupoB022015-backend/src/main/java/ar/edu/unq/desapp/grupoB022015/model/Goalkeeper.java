package ar.edu.unq.desapp.grupoB022015.model;

public class Goalkeeper extends Position {

	public Goalkeeper() {}
	
	@Override
	public int pointsForGoal(int amountGoals) {
		return amountGoals == 0? 2 : 0;
	}

	@Override
	public Boolean isMine(String position) {
		return position.equals("Goalkeeper");
	}

}
