package com.nt.enums;

public class EnumTest6 {
	public static void main(String[] args) {
		Beer6 b = Beer6.RC;
		System.out.println("Hello");
		Beer6 b1[] = Beer6.values();
		for(Beer6 beer : b1) {
			System.out.println(beer +" ********** "+ beer.getPrice());
		}
	}
}

enum Beer6{
	BW(50),RC(60),KO(70),SO(80),VK; // these all are nothing but static objects only
	// public static final Beer6 KF = new Beer6(); = KF
	// public static final Beer6 KF = new Beer6(60); = KF(60)
	int price;
	Beer6(int price){
		this.price = price;
	}
	
	Beer6(){
		this.price = 47;
	}
	
	public int getPrice(){
		return this.price;
	}
}