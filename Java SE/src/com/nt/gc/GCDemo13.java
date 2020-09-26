package com.nt.gc;

public class GCDemo13 {
	static GCDemo13 g;
	
	public static void main(String[] args) throws InterruptedException{
		GCDemo13 g1 = new GCDemo13();
		System.out.println(g1.hashCode());
		g1 = null;
		System.gc();
		//System.out.println(g.hashCode()); RE : NPE
		Thread.sleep(2000);
		System.out.println(g.hashCode());
		g = null;
		System.gc();
		Thread.sleep(2000); 
		// for an object finalize method is called only once even if it is eligible for GC multiple times
		System.out.println("End Of Main");
	}

	@Override
	public void finalize() {
		System.out.println("finalize method called");
		g = this;
	}
}