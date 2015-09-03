package ar.edu.unq.desapp.grupoB022015.model;

public class Match {
	
	private User local;
	private User visitor;
	
	
	public Match(User localU, User visitorU){
		this.local = localU;
		this.visitor = visitorU;
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
	
	
}
