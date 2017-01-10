package marble.model;

import java.io.*;

public class Cities implements Serializable{
	
	private String name;
	private int status;
	private int owner;
	private int grandCost;
	private int fee;
	
	public Cities(){}
	
	public Cities(String name, int status,
			int owner, int grandCost, int fee) {
		super();
		this.name = name;
		this.status = status;
		this.owner = owner;
		this.grandCost = grandCost;
		this.fee = fee;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	public int getGrandCost() {
		return grandCost;
	}
	public void setGrandCost(int grandCost) {
		this.grandCost = grandCost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}
	
}
