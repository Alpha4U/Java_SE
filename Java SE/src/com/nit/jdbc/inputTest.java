package com.nit.jdbc;

// run using Command Prompt

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.util.Scanner;

public class inputTest {

	public static void main(String []args) throws Exception{
		
		// command line argument
		String name1 = args[0];
		// system properties
		String name2 = System.getProperty("myName");
		// scanner class
		Scanner sc = new Scanner (System.in);
		String name3 = sc.next();
		Console cons = System.console();
		String name4 = cons.readLine();
		// buffer reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter name");
		String name5 = br.readLine();
		System.out.println(name1+ "  " + name2+ " " + name3+ " " + name4+ " " + name5);
		
		sc.close();
	}// main
}// class

// javac inputTest.java
// java -D myName= =Shubham inputTest Awasthi