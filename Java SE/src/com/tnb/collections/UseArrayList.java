//collection is an array that holds stuff
//collection holds references to other objects
//array requires how many items you want to hold in that array
//a list or set or his type of collection it's dynamic, no need to provide a number, it will change by itself
//a set cannot contain duplicates, whereas list can contain duplicates
package com.tnb.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class UseArrayList {

	public static void main(String[] args) {
		String[] things= {"laptop","mouse","keyboard","monitor","pen drive"};
		List<String> list1 = new ArrayList<String>();
		//add array item to the list
		for(String x:things){
			list1.add(x); 
		}
		
		String[] morethings={"mouse","keyboard"};
		List<String> list2=new ArrayList<String>();
		for(String y:morethings){
			list2.add(y);
		}
		
		for(int i=0;i<list1.size();i++){ 
			System.out.printf("%s", list1.get(i));
			System.out.println();
		}
		
		editlist(list1, list2);
		System.out.println();
		
		for(int i=0;i<list1.size();i++){
			System.out.printf("%s", list1.get(i));
			System.out.println();
		}
	}
	//iterator goes to each list item by item
	//hasnext() means go to next untill the end
	//as a parameter Collections is passed because it's highest in heirarchy
	public static void editlist(Collection<String> l1,Collection<String> l2){
		Iterator<String> it=l1.iterator();
		while(it.hasNext()){
			if(l2.contains(it.next())){
				it.remove();
			}
		}
	}
	
}
