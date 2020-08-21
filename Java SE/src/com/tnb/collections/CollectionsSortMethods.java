package com.tnb.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsSortMethods {

	public static void main(String[] args) {
		String[] things={"laptop","mouse","keyboard","usb","pendrive","monitor"};
		List<String> list1= Arrays.asList(things);
		
		Collections.sort(list1);
		System.out.printf("%s",list1);
		
		System.out.println();
		
		Collections.sort(list1,Collections.reverseOrder());
		System.out.printf("%s ",list1);
		
	}

}
