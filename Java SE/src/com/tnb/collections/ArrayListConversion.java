package com.tnb.collections;

import java.util.Arrays;
import java.util.LinkedList;

public class ArrayListConversion {

	public static void main(String[] args) {
		
		String[] things={"laptop","mouse","keyboard","pendrive","powerbank","monitor"};
		
		LinkedList<String> list1=new LinkedList<String>(Arrays.asList(things));
		list1.add("headphone");
		list1.addFirst("hdd");
		
		for(String x:list1){
			System.out.printf("%s ",x);
			System.out.println();
		}
		
		System.out.println();
		things=list1.toArray(new String[list1.size()]);	//list1.size() to give array size equal to list
		
		for(String y:things){
			System.out.printf("%s ",y);
			System.out.println();
		}

	}

}
