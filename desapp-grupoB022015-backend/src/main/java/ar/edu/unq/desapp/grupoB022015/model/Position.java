package ar.edu.unq.desapp.grupoB022015.model;

public abstract class Position extends Entity{

	public Position(){}
	public abstract int pointsForGoal(int amountGoals);
	public abstract Boolean isMine(String position);
}
