package com.tnb.array;


public class SumArrayDirect {
	public static void main(String[] args) {
		int a[] ={12,45,36,85,47,9,52,52};
		int sum = 0;
		
		for(int counter=0;counter<a.length;counter++){
			sum += a[counter];
		}
		
		System.out.println("Sum Of Array Elements : "+sum);
		
	}
}
