package marble.model;

public class Charcter {
	private int cNo;
	private String name;
	private int money;
	private int location;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	
	
	public int getcNo() {
		return cNo;
	}
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}
	public Charcter(){
		
	}
	public Charcter(int cNo, String name, int money, int location) {
		super();
		this.cNo = cNo;
		this.name = name;
		this.money = money;
		this.location = location;
	}
	@Override
	public String toString() {
		return "Charcter [cNo = " + cNo + "name=" + name + ", money=" + money + ", location=" + location + "]";
	}
	
	
}
