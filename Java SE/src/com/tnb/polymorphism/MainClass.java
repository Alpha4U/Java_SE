package com.tnb.polymorphism;

public class MainClass {

	public static void main(String[] args) {
		
//		FoodProvider fp= new DinnerProvider();
//		fp.eat();
//		//DinnerProvider f= new FoodProvider();	Not Possible
//		LunchProvider lp = new LunchProvider();
//		lp.eat(); 
//		
//		//Below is made a Polymorphic Array
//		FoodProvider fpArray[]=new FoodProvider[2];
//		fpArray[0]=new LunchProvider(); //fpArray[0] variable holding LunchProvider object
//		fpArray[1]=new DinnerProvider();//fpArray[1] variable holding DinnerProvider object
//		
//		for (int x = 0; x < fpArray.length; x++) {
//			fpArray[x].eat();
//			
//		}
		
		//Example having polymorphic arguments
//		FoodEater fe = new FoodEater();
//		FoodProvider fp =new FoodProvider();
//		FoodProvider fpObject =new DinnerProvider();
//		fe.digest(fp);
//		fe.digest(fpObject);    
		
		//overriding methods takes same arguments and cannot make the overriden method private
		//overloaded method means same method name with different arguments
		
		DinnerProvider dp = new DinnerProvider();
		dp.eat();
		
		//while overriding a method you must take same arguments and same return types
		
		
		
		
		

	}

}
