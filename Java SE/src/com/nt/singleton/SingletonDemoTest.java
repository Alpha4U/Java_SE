package com.nt.singleton;

public class SingletonDemoTest {
	public static void main(String[] args) {
		SingletonDemo sdt1 = SingletonDemo.getSingletonDemoInstance();
		SingletonDemo sdt2 = SingletonDemo.getSingletonDemoInstance();

		System.out.println(sdt1.hashCode());
		System.out.println(sdt2.hashCode());

		if (sdt1.hashCode() == sdt2.hashCode()) {
			System.out.println("Same Objects");
		} else {
			System.out.println("Different Objects");
		}

	}
}
