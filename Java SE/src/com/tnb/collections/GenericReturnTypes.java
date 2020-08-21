package com.tnb.collections;

public class GenericReturnTypes {

	public static void main(String[] args) {
		System.out.println(max(24,21,98));
		System.out.println(max("zzzzzz","xasfgdf","zsdfgdsf"));
	}

	public static <T extends Comparable<T>> T max(T a, T b, T c) {
		T m = a;
		if (b.compareTo(a) > 0)//if less -ve no return, if equal 0, if greater +ve no return
			m = b;
		if (c.compareTo(m)>0)
			m = c;
		return m;
	}

}
