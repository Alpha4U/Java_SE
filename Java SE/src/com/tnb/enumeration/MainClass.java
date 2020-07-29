package com.tnb.enumeration;

import java.util.EnumSet;

public class MainClass {
	
	public static void main(String[] args) {
		
		//to access enum
		for(EnumerationClass people:EnumerationClass.values()){
			System.out.printf("%s\t%s\t%s\n", people,people.getDesc(),people.getYear());
		}
		
		//enum set range
		System.out.println("\nAnd Now for the EnumSet range of Constants \n");
		for(EnumerationClass people : EnumSet.range(EnumerationClass.deepika, EnumerationClass.geetu)){
			System.out.printf("%s\t%s\t%s\n", people,people.getDesc(),people.getYear());
		}

	}

}
