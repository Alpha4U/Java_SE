package com.tnb.constructor;

public class mainClass {

	public static void main(String[] args) {
		
//		constructorClass cobj1 = new constructorClass();
//		constructorClass cobj2 = new constructorClass(4);
//		constructorClass cobj3 = new constructorClass(7,45);
//		constructorClass cobj4 = new constructorClass(11,45,12);
//		
//		System.out.println(cobj1.toMillitary());
//		System.out.println(cobj2.toMillitary());
//		System.out.println(cobj3.toMillitary());
//		System.out.println(cobj4.toMillitary());
		
		// To Convert an Object To a String we need toString() method
		//Composition = Referring to Objects		(Eg. private ToStringClass birthday;)
		
		ToStringClass strObj=new ToStringClass(4, 5, 6);
		CompositionClass compObj = new CompositionClass("Shubham", strObj);
		System.out.println(compObj);

	}

}
