package com.tnb.stringhandling;

public class MoreStringMethods {
	public static void main(String[] args) {
		String s="shubhamawasthishubhamawasthi";
		String a="shubham ";
		String b="awasthi";
		String c="		awasthi		";
		
		System.out.println(s.indexOf('a'));
		System.out.println(s.indexOf("aw",12));
		System.out.println(s.indexOf('a',9));
		System.out.println(s.indexOf("x"));
		System.out.println(a+b);
		System.out.println(a.concat(b));
		System.out.println(a.replace("shubham","nikki")+b);
		System.out.println(a.toUpperCase()+b.toLowerCase());
		System.out.println(a+c);
		System.out.println(a+c.trim());
		
	}
}
