package com.tnb.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddAllClass {

	public static void main(String[] args) {
		//convert stuff array to list
		String[] things={"laptop","mouse","keyboard","ups","pendrive"};
		List<String> list1=Arrays.asList(things);
		
		ArrayList<String> list2= new ArrayList<String>();
		list2.add("games");
		list2.add("movies");
		list2.add("travel");
		
		for(String x:list2)
			System.out.printf("%s ",x); 
		
		System.out.println();
		Collections.addAll(list2, things);
		
		for(String x:list2)
			System.out.printf("%s ",x);
		
		System.out.println();
		System.out.println(Collections.frequency(list2, "games"));
		System.out.println(Collections.frequency(list2, "game"));
		
		//disjoint checks collection against collection and  returns true if it has nothing in common
		boolean tof=Collections.disjoint(list1, list2);
		System.out.println(tof);//output is false because both list have common items
		if(tof)
			System.out.println("nothing in common");
		else
			System.out.println("both have common items !");
		
	}
}
