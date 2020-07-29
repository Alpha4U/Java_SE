package com.tnb.constructor;

public class ToStringClass {
	
	private int year;
	private int month;
	private int day;
	
	public ToStringClass(int d,int m,int y){
		month = m;
		year = y;
		day = d;	
		
		System.out.printf("The Constructor for this is %s\n", this );
	}
	
	public String toString(){
		return String.format("%d/%d/%d", day,month,year);
	}
	
}
