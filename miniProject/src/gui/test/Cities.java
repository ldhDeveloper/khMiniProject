package gui.test;

import java.io.*;

public class Cities implements Serializable{
	private String name;
	private int cost;
	private int status;
	private int owner;
	private int grandCost;
	private int upCost;
	
	public Cities(){}
	public Cities(String name, int cost){
		this.name = name;
		this.cost = cost;
	}
	
	
	public Cities(String name, int cost, int status, int owner, int grandCost, int upCost) {
		super();
		this.name = name;
		this.cost = cost;
		this.status = status;
		this.owner = owner;
		this.grandCost = grandCost;
		this.upCost = upCost;
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
	public int getUpCost() {
		return upCost;
	}
	public void setUpCost(int upCost) {
		this.upCost = upCost;
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
