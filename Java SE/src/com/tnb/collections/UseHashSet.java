package com.tnb.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UseHashSet {

	public static void main(String[] args) {
		//set is a collection that cannot contain duplicate items
		String[] things={"laptop","keyboard","mouse","mouse","laptop"};
		List<String> list1=Arrays.asList(things);
		
		System.out.printf("%s ", list1);
		System.out.println();
		
		Set<String> set1=new HashSet<String>(list1);
		System.out.printf("%s ", set1);
	}

}
