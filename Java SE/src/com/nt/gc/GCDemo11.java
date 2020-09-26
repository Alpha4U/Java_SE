package com.nt.gc;

public class GCDemo11 {

	public static void main(String[] args) {
//		String s = new String("Shubham"); // here String class finalize method will be called if not object
		GCDemo11 s = new GCDemo11();
		s= null;
		System.gc();
		// after above line teo threads are there main and gc
		System.out.println("End Of Main");
	}

	@Override
	public void finalize(){
		System.out.println("finalize method called");
	}
}