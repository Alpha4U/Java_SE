package com.tnb.basics;


public class EnhancedFor {

	public static void main(String[] args) {
		
		int arr[]= {12,45,32,65,65,45,12,65,88};
		int sum = 0;
		
		for (int index: arr) {
			sum +=index;
		}
		
		System.out.println("Sum of Array Elements : "+sum);
		
	}

}
