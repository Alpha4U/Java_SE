package com.tnb.statickeyword;

public class MainClass {

	public static void main(String[] args) {
		
		GetMembers member1 = new GetMembers("Megan", "Fox");
		GetMembers member2 = new GetMembers("Natalie", "Portman");
		GetMembers member3 = new GetMembers("Shradhdha", "Kapoor");
		GetMembers member4 = new GetMembers("Alia", "Bhatt");

		System.out.println();
		System.out.println(member1.getFname());
		System.out.println(member1.getLname());
		System.out.println(member1.getMembers());
		
		System.out.println(member2.getFname());
		System.out.println(member2.getLname());
		System.out.println(member2.getMembers());
		
		//static members of a class can be accessed directly
		System.out.println(GetMembers.getMembers());
		
	}

}
