package ar.edu.unq.desapp.grupoB022015.model;

public class Goalkeeper extends Position {

	@Override
	public int pointsForGoal(int amountGoals) {
		return amountGoals == 0? 2 : 0;
	}

}
