package com.tnb.holdingobjects;

public class MainClass {

	public static void main(String[] args) {
		
//		DogList dlo = new DogList();
//		Dog d = new Dog();
//		dlo.add(d);
		
		//Fish f = new Fish();
		//dlo.add(f); not accepted throws compile time error

		AnimalList alo = new AnimalList();
		Dog d = new Dog();
		Fish f = new Fish();
		alo.add(d);
		alo.add(f);
		alo.add(d);
		alo.add(f);
		
	}

}
