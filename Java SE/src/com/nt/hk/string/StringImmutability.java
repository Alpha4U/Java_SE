package com.nt.hk.string;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class StringImmutability {
	public static void main(String[] args) {
		// now a days in server only we need to install JDK and configure it properly 
		// no need to install JRE separately in client system because that's just html
		Hashtable ht = new Hashtable<>();
		String s1 = "hk";
		ht.put(s1, 1);
		ht.put("Kunj", 2);
		ht.put("Avi", 3);
		
		s1 = s1.toUpperCase();
		System.out.println(s1);
		Object obj1 = ht.get("hk");
		Object obj2 = ht.get("hk");
		System.out.println(obj1);
		System.out.println(obj2);
		
		Set st = ht.keySet();
		Iterator itr = st.iterator();
		while(itr.hasNext()) {
			String s = (String)itr.next();
			System.out.println(s);
		}
		
	}
}
