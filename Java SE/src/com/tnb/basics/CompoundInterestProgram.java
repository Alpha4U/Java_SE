package com.tnb.basics;


public class CompoundInterestProgram {
	public static void main(String[] args) {
		
		double amount = 0,principle=10000,rate=.01;
		
		for (int day = 1; day <= 20; day++) {
			amount = principle*Math.pow(1+rate, day);
			System.out.println(day+"    "+amount);
		}
		
	}
}
