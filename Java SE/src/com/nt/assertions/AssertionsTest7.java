package com.nt.assertions;
// it is legal to catch assertion error but not a good programming practice
public class AssertionsTest7 {
	int z = 5;
	public void m1(int x) {
		assert(x >10); // wrong
		
		switch (x) {
		case 10:
			System.out.println(10);
			break;
		case 11:
			System.out.println(11);
			break;

		default:
			assert(false); // right
		}
	}
	
	private void m2(int x) {
		assert(x<10); // right
	}
	
	private void m3() {
		assert(m4()); // wrong
	}
	
	private boolean m4() {
		z = 6;
		return true;	
	}
	
}
