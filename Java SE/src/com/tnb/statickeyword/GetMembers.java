package com.tnb.statickeyword;

public class GetMembers {

	private String fname;
	private String lname;
	
	private static int members;	//shared variable - all members shairing same variable because it is static
	
	public GetMembers(String fn,String ln){
		fname = fn;
		lname = ln;
		members ++;
		
		System.out.printf("Constructor for %s %s, Members in the club %d.\n", fname,lname,members);
	}
	
	public String getFname(){
		return fname;
	}
	
	public String getLname(){
		return lname;
	}
	
	public static int getMembers(){
		return members;
	}

}
