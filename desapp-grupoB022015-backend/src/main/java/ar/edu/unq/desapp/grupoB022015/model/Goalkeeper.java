package ar.edu.unq.desapp.grupoB022015.model;

public class Goalkeeper extends Position {

	@Override
	public int pointsForGoal(int amountGoals) {
		int res = 0;
		if(amountGoals == 0){
			res = 2;
		}
		return res;
	}

}
