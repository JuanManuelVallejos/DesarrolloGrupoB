package ar.edu.unq.desapp.grupoB022015.model;

public class PointsForUser extends Entity{

	private User key;
	private Integer value;
	
	public PointsForUser(User aUser,Integer i) {
		this.key = aUser;
		this.value = i;
	}
	
	public User getKey() {
		return key;
	}
	public void setKey(User key) {
		this.key = key;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	
	
}
