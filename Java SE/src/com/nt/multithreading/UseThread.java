package com.nt.multithreading;

import java.util.Random;

public class UseThread implements Runnable{

	String name;
	int time;
	Random r = new Random();
	
	public UseThread(String x){
		name=x;
		time=r.nextInt(999);
	}
	
	@Override
	public void run() {
		try {
			System.out.printf("%s is sleeping for %d\n", name,time);
			Thread.sleep(time);
			System.out.printf("%s is done\n", name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
