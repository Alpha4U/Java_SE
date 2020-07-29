package com.tnb.abstractclass;

public class FoodProvider extends AbstractClass{
	void eat(){
		System.out.println("This Food is Great");
	}
	
	//abstract method must be overridden
	@Override
	void drink() {
		System.out.println("This is inherited abstract drink method");
	}
}
