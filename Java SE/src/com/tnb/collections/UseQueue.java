package com.tnb.collections;

import java.util.PriorityQueue;

public class UseQueue {

	public static void main(String[] args) {
		PriorityQueue<String> q1=new PriorityQueue<>();
		q1.offer("first");
		q1.offer("second");
		q1.offer("third");
		System.out.printf("%s ", q1);
		System.out.println();
		System.out.printf("%s ",q1.peek());
		System.out.println();
		q1.poll(); //poll means queue element with highest priority
		System.out.printf("%s ", q1);
	}

}
