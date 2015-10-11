package ar.edu.unq.desapp.grupoB022015.model;

public class Match {
	
	private User local;
	private User visitor;
	private int localPoints;
	private int visitorPoints;
	
	public Match(){}
	public Match(User localU, User visitorU){
		this.local = localU;
		this.visitor = visitorU;
		this.localPoints = 0;
		this.visitorPoints = 0;
	}
	
	
	//WARNING: Add Exception
	@SuppressWarnings("null")
	public int getPointsForUser(User user){
		if(local.equals(user))
			return localPoints;
		if(visitor.equals(user))
			return visitorPoints;
		return (Integer) null;
	}
	
	public User getLocal() {
		return local;
	}
	public void setLocal(User local) {
		this.local = local;
	}
	public User getVisitor() {
		return visitor;
	}
	public void setVisitor(User visitor) {
		this.visitor = visitor;
	}
	
	public void setPointsForUsers(int pointsLocal, int pointsVisitor){
		this.localPoints = pointsLocal;
		this.visitorPoints = pointsVisitor;
	}
	
	public void setPoints(TableForDate table){
		int localPointsByPlayers = table.getLastPointsOfDate(local.getTeam().getPlayers());
		int visitorsPointsByPlayers = table.getLastPointsOfDate(visitor.getTeam().getPlayers());
		
		if(localPointsByPlayers>visitorsPointsByPlayers){
			setPointsForUsers(3, 0);
		}else if(localPointsByPlayers<visitorsPointsByPlayers){
			setPointsForUsers(0, 3);
		}else{
			setPointsForUsers(1, 1);
		}
	}


	public boolean existUser(User user) {
		if(local.equals(user)||visitor.equals(user))
			return true;
		return false;
	}
	
}
