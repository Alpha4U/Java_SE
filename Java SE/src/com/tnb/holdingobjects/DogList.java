package com.tnb.holdingobjects;

public class DogList {
	private Dog[] thelist = new Dog[5];
	private int i=0;
	
	//useful for holding only single class object 
	//specific to Dog class
	//that's why we created comman AnimalList to hold multiple class objects
	public void add(Dog d){
		if(i<thelist.length){
			thelist[i]=d;
			System.out.println("Dog added at index : "+i);
			i++;
		}
	}
}
