package com.tnb.finalkeyword;

public class GetConstants {
	//constants defined in CAPITAL letters
	private int sum;
	private final int NUMBER;
	
	public GetConstants(int n){
		NUMBER =n;
	}
	
	public void add(){
		sum+=NUMBER;	
	}
	
	public String toString(){
		return String.format("Sum = %d\n", sum);
	}
	
}
