package com.tnb.basics;


public class VarLenArgs {
	public static void main(String[] args) {
		
		System.out.println(average(45,65,32,45,21,32,64));
		
	}
	
	public static int average(int...numbers){
		
		int total = 0;
		for(int x:numbers){
			total+=x;
		}
		
		return total/numbers.length;
		
	}
	
}
