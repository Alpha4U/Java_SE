package com.tnb.constructor;

public class constructorClass {

	private int hour;
	private int min;
	private int sec;
	
	public constructorClass(){
		this(0,0,0);
	}
	
	public constructorClass(int h){
		this(h,0,0);
	}
	
	public constructorClass(int h,int m){
		this(h,m,0);
	}
	
	public constructorClass(int h,int m,int s){
		setTime(h,m,s);
	}
	
	public void setTime(int h,int m,int s){
		setHour(h);
		setMinute(m);
		setSecond(s);
	}
	
	public void setHour(int h){
		hour=((hour<=0 && hour <24)?h:0);
	}

	public void setMinute(int m){
		min=((min<=0 && min <60)?m:0);
	}
	
	public void setSecond(int s){
		sec=((sec<=0 && sec <60)?s:0);
	}
	
	public int getHour(){
		return hour;
	}

	public int getMinute(){
		return min;
	}
	
	public int getSecond(){
		return sec;
	}

	public String toMillitary(){
		return String.format("%02d:%02d:%02d", getHour(),getMinute(),getSecond()); 	
	}
	
}

