package com.tnb.array;


public class ArrayInMethods {

	public static void main(String[] args) {
		
		int nikki[] = {26,45,65,32,98,64,78};
		change(nikki);
		
		for(int resArr:nikki){
			System.out.println(resArr);
		}

	}
	
	public static void change(int addedArray[]){
		
		for(int counter =0;counter<addedArray.length;counter++){
			addedArray[counter]+=5;
		}
		
	}

}
