package com.nt.hk.datatypes;

public class Case2 {
	public static void main(String[] args) {
		
		int a = 10;
		float f = a;		//implicit type conversion or widening
		long l = a;		//implicit type conversion or widening
		//int i = l; 		//type mismatch
		int i = (int) l;		//type casting
		//boolean b = a; //Type mismatch: cannot convert from int to boolean
		double d = f;
		//int p = f;		//Type mismatch: cannot convert from float to int
		
		
		System.out.println(f);		//10.0
		System.out.println(a);		//10
		System.out.println(l);		//10
		System.out.println(i); 		//10
		
	}
}
