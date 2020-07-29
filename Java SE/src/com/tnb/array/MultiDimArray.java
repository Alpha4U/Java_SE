package com.tnb.array;


public class MultiDimArray{
	
	public static void main(String []args){
		
		int firstArray[][] = {{12,45,65},{78,65,21},{63,95,24}};
		int secondArray[][]={{97,64,31,59},{45},{12,64,78}};
		
		System.out.println("First Array");
		System.out.println();
		display(firstArray);
		
		System.out.println();
		System.out.println("Second Array");
		System.out.println();
		display(secondArray);
		
	}

	public static void display(int arr[][]){
		for(int row=0;row<arr.length;row++){
			for(int column=0;column<arr[row].length;column++){
				System.out.print(arr[row][column]+"\t");
			}
			System.out.println();
		}
	}
	
}