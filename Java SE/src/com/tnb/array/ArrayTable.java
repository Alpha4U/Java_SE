package com.tnb.array;


public class ArrayTable {

	public static void main(String[] args) {
		
		int a[] = {45,54,32,12,98,78};
		System.out.println("Index \t Value");
		for(int counter = 1;counter<a.length;counter++){
			System.out.println(counter+"\t\t"+a[counter]);
		}

	}

}
