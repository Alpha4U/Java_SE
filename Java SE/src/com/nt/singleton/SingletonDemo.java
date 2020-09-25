package com.nt.singleton;

public class SingletonDemo {
	private static SingletonDemo singletonObject = null;
	private SingletonDemo() {	}
	
	public static synchronized SingletonDemo getSingletonDemoInstance(){
		if(singletonObject == null){
			singletonObject = new SingletonDemo(); 
			return singletonObject;
		}else{
			return singletonObject;
		}
	}
}
