package com.tnb.inheritance;

public class DinnerProvider extends LunchProvider{
	@Override
	public void eat() {
		System.out.println("Overriden Eat Method");
	}
}
