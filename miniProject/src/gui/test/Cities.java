package gui.test;

public class Cities {
	private String name;
	private int cost;
	
	public Cities(){}
	public Cities(String name, int cost){
		this.name = name;
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
