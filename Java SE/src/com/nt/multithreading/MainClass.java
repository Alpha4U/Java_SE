package com.nt.multithreading;

public class MainClass {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new UseThread("one"));
		Thread t2 = new Thread(new UseThread("two"));
		Thread t3 = new Thread(new UseThread("three"));
		Thread t4 = new Thread(new UseThread("four"));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
