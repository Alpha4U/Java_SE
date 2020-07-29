package com.tnb.basics;


import java.util.Random;

public class RandomNumberGenerater {
	public static void main(String[] args) {
		Random dice = new Random();
		int number = 0;
		
		for(int counter=0;counter<=10;counter++){
			number = 1+dice.nextInt(6);
			System.out.println(number);
		}
		
	}
}
