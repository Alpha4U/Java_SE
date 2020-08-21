package com.tnb.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class UseLinkedList {

	public static void main(String[] args) {
		String[] things1={"laptop","mouse","keyboard","usb","pendrive"};
		List<String> list1 = new LinkedList<String>();
		for(String x:things1){
			list1.add(x);
		}
		
		String[] things2={"pen","pencil","rubber","cutter","book","copy"};
		List<String> list2=new LinkedList<String>();
		for(String y:things2){
			list2.add(y);
		}
		
		list1.addAll(list2);
		list2=null;
		
		printMe(list1);
		System.out.println();
		removeStuff(list1,2,5);
		System.out.println();
		printMe(list1);
		System.out.println();
		reverseMe(list1);
		
	}
	private static void reverseMe(List<String> l) {
		ListIterator<String> it=l.listIterator(l.size());
		while(it.hasPrevious()){
			System.out.printf("%s ", it.previous());
			System.out.println();
		}
	}
	//printMe()method
	private static void removeStuff(List<String> l, int from, int to) {
		l.subList(from, to).clear();
	}
	private static void printMe(List<String> l1){
		for(String z:l1){
			System.out.println(z);
			//System.out.printf("%s ", z);
			//System.out.println();
		}
			
	}

}
