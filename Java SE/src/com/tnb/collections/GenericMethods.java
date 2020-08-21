package com.tnb.collections;

public class GenericMethods {

	public static void main(String[] args) {
		Integer[] iray={1,2,3,4};
		Character[] cray ={'a','b','c','d'};
		
		printMe(iray);
		printMe(cray);
	}
	
	//generic method - In generic method we can pass any type of data we want	
	public static <T> void printMe(T[] a){
		for(T x:a){
			System.out.printf("%s ", x);
		}
		System.out.println();
	}
	
	//by using a generic method we don't have to overload same method
//	public static void printMe(Integer[] i2ray){
//		for(Integer x:i2ray){
//			System.out.printf("%s ", x);
//		}
//	}
//	
//	public static void printMe(Character[] c2ray){
//		for(Character x:c2ray){
//			System.out.printf("%s ", x);
//		}
//	}

}
