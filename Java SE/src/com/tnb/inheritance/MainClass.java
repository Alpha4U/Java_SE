package com.tnb.inheritance;

public class MainClass {

	public static void main(String[] args) {
		
		LunchProvider lpObj = new LunchProvider();
		DinnerProvider dpObj = new DinnerProvider();
		
		lpObj.eat();
		dpObj.eat();
		//lpObj.drink();
		
		//only public methods are inherited

	}

}
