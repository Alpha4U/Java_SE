package com.tnb.time;



public class TimeClas {

	public static void main(String[] args) {
		
		GetTime gt = new GetTime();
		System.out.println(gt.toMillitary());
		System.out.println(gt.toString());
		
		gt.setTime(17, 20, 20);
		System.out.println(gt.toMillitary());
		System.out.println(gt.toString());

	}

}
