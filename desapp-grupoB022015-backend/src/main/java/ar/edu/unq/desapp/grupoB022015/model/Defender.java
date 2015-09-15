package ar.edu.unq.desapp.grupoB022015.model;

public class Defender extends Position {

	@Override
	public int pointsForGoal(int amountGoals) {
		return amountGoals * 3;
	}

}
