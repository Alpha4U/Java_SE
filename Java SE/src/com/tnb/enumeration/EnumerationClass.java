package com.tnb.enumeration;

public enum EnumerationClass {
	
	gauri("crush","20"),deepika("cute","21"),angelina("smiley","21"),
	sakshi("friend","20"),geetu("smiley","21"),akansha("hot","21");
	
	private final String desc;
	private final String year;
	
	EnumerationClass(String description,String birthday){
		desc = description;
		year = birthday;
	}
	
	public String getDesc(){
		return desc;
	}
	
	public String getYear(){
		return year;
	}
	
}
