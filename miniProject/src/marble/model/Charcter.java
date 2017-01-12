package marble.model;

public class Charcter {
	private int cNo;
	private String name;
	private int money;
	private int location;
	private boolean islandflag; 
	private boolean start;
	private int freeCoupon;
	private int ownBuild;
	
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
	
	
	public int getFreeCoupon() {
		return freeCoupon;
	}
	public void setFreeCoupon(int freeCoupon) {
		this.freeCoupon = freeCoupon;
	}
	public int getcNo() {
		return cNo;
	}
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}
	
	
	public int getOwnBuild() {
		return ownBuild;
	}
	public void setOwnBuild(int ownBuild) {
		this.ownBuild = ownBuild;
	}
	public boolean isIslandflag() {
		return islandflag;
	}
	public void setIslandflag(boolean islandflag) {
		this.islandflag = islandflag;
	}
	
	public boolean isStart() {
		return start;
	}
	public void setStart(boolean start) {
		this.start = start;
	}
	public Charcter(){
		
	}
	public Charcter(int cNo, String name, int money, int location, boolean islandflag, boolean start, int freeCoupon, int ownBuild) {
		super();
		this.cNo = cNo;
		this.name = name;
		this.money = money;
		this.location = location;
		this.islandflag = islandflag;
		this.start = start;
		this.freeCoupon = freeCoupon;
		this.ownBuild = ownBuild;
	}
	@Override
	public String toString() {
		return "Charcter [cNo = " + cNo + "name=" + name + ", money=" + money + ", location=" + location + "]";
	}
	
	
}
