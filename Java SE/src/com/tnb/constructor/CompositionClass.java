package com.tnb.constructor;

public class CompositionClass {
	
	private String name;
	private ToStringClass birthday;
	
	public CompositionClass(String theName,ToStringClass theDate){
		name = theName;
		birthday = theDate;
	}
	
	public String toString(){
		return String.format("My name is %s and my birthday is %s", name,birthday);
	}

}
