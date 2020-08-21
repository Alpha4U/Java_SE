package com.tnb.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseAndCopyMethods {

	public static void main(String[] args) {
		//create an array and convert to list
		Character[] things={'l','m','k'};
		List<Character> list1=Arrays.asList(things);
		System.out.println("List1 Is : ");
		output(list1);
		
		//reverse and print out the list
		Collections.reverse(list1);
		System.out.println("After Reverse List1 is: ");
		output(list1);
		
		//create new array and a new list
		Character[] newArray=new Character[3];
		List<Character> list2=Arrays.asList(newArray);
		
		//copy contents of list1 into list2
		Collections.copy(list2, list1);
		System.out.println("list 2 is : ");
		output(list2);
		
		//fill collection with crap
		Collections.fill(list1,'P');
		System.out.println("LIst1 after filling P : ");
		 output(list1);
	}
	
	//output method
	public static void output(List<Character> finalList){
		for(Character listItems:finalList){
			System.out.printf("%s ",listItems);
		}
		System.out.println();
	}

}
