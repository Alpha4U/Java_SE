package com.tnb.array;


import java.util.Scanner;

public class SumArray {

	public static void main(String[] args) {
		
		Scanner sc = null;
		int num=0;
		double elements[] = new double[num];
		double sum = 0;
		
		try{
			sc = new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter No of Elements to Add ");
				num = sc.nextInt();
				for(int counter=0;counter<elements.length;counter++){
					sum = sc.nextInt();
				}
				System.out.println("Sum OF Array Elements = "+sum);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(sc!=null){
					sc.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}

}
