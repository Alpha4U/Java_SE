package com.nt.gc;

public class GCDemo14 {
	// test case for when GC is called automatically
	// mark and sweep - standard algo followed by most GC
	static int count = 0;
	public static void main(String[] args){
		for (int i = 0; i < 1000000; i++) {
			GCDemo14 t = new GCDemo14();
			t = null;
			// 10 objects created all eligible for GC
		}
	}

	@Override
	public void finalize() {
		System.out.println("finalize method called : "+ ++count);
		// how much count value you get those many objects are destroyed by GC 
		// value not fixed, destruction order for objects not fixed
	}
}