package com.tnb.exception;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x=1;
		do {
			try {
				System.out.println("Enter First Num : ");
				int n1 = sc.nextInt();
				System.out.println("Enter Second Num : ");
				int n2 = sc.nextInt();
				int sum = n1 / n2;
				System.out.println(sum);
				x=2;// this statement will end the execution after correct result
			} catch (Exception e) {
				System.out.println("You Can't Do that");
			}	
		} while (x==1);//this condition will run this program again and again
	}
}
