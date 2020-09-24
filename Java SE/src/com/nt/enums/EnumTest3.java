package com.nt.enums;

public class EnumTest3 {
	public static void main(String[] args) {
		// all enums immediate parent for java.lang.Enum by default
		// so enum can't extend any other enum
		// can't create child for enum also because final
		// for enums inheritance concept not applicable explicitly
		// enum can implement any number of interfaces
		// java.lang.Enum = abstract class, child of object, implements Serializable and Comparable
		// values() = to get all values present inside Enum
		
		Beer3 b[] = Beer3.values(); // enum keyword implicitly provides this values() method
		for(Beer3 x : b) {
			System.out.println(x + " =========== "+ x.ordinal());
		}
		// ordinal() = for order of enum constants
	}
}

enum Beer3{
	RC,BW,KO // list of constants must be in first line
}

enum Number{
	ONE,TWO,THREE; // here ; mandatory 
	public static void main(String []args) {
		System.out.println("Number.main()");
	}
}
