package com.tnb.basics;

import java.util.Scanner;

public class SimpleAverageProgram {

	public static void main(String []args){
		
		int counter = 0,total=0,marks;
		float average = 0;
		Scanner sc = null;
		
		try {
			
			sc = new Scanner(System.in);
			System.out.println("Enter the Numbers : ");
			while(counter < 10){
				marks = sc.nextInt();
				total = total+marks;
				counter++;
			}
			
			average = total/10;
			System.out.println("The Total Average of 10 Subjects : "+average);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(sc !=null){
					sc.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		
	}
	
}
