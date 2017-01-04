package gui.test;

import java.io.*;

public class Cities implements Serializable{
	
	private String name;
	private int status;
	private int owner;
	private int grandCost;
	
	public Cities(){}
	
	public Cities(String name, int status,
			int owner, int grandCost) {
		super();
		this.name = name;
		this.status = status;
		this.owner = owner;
		this.grandCost = grandCost;
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
	
}
