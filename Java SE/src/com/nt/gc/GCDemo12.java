package com.nt.gc;

public class GCDemo12 {

	public static void main(String[] args) {
		GCDemo12 s = new GCDemo12();
		s.finalize();
		s.finalize();
		// in above lines finalize called as a normal method
		s = null;
		System.gc(); // here GC called finalize method
		System.out.println("End Of Main");
	}

	@Override
	public void finalize(){
		System.out.println("finalize method called");
	}
}