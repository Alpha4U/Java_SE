package com.nt.assertions;

public class AssertionsTest6 {
	public static void main(String[] args) {
		// -ea option enables assertions in every non-system(our-own) class, system (predefined)
		// -ea == -enableassertions
		// -da == -disableassertions
		// -esa == -enablesystemassertions
		// -dsa == -disablesystemassertions
		
		// java -ea -esa -ea -dsa Test = jvm considers left to right
		// last one in each will be used for every system and non-system class 
		
		// java -ea : pack1.B = enable assertions only in B class for pack1
		// java -ea : pack1.B -ea : pack1.pack2.D = enable assertions only in B and D class for pack1 and pack2
		// java -ea : pack1... = enable assertions in all non-system classes of pack1
		// java -ea : pack1... -da : pack1.B = enable assertions in all non-system classes of pack1 except B
		// java -ea : pack1... -da : pack1.pack2... = enable assertions in all non-system classes of pack1 and disable same in pack2
		
		// never use assert for business logic (bad coding)
		// not good for validating method arguments
	}
	
	public void withdraw(double amt) {
		assert(amt >=100);
		// process reuest; = never do this
	}
	
}
