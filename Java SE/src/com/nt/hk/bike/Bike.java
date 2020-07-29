package com.nt.hk.bike;

public class Bike {
	private String engineNo;
	private String color;
	private String ownerName;
	private String bikeNo;

	public Bike(String engineNo,String color) {
		this.engineNo=engineNo;
		this.color=color;
	}
	
	public String getEngNo(){
		return this.engineNo;
	}
	
	public String getColor(){
		return this.color;
	}
	
}
