package com.tnb.finalkeyword;

public class MainClass {

	public static void main(String[] args) {

		GetConstants consObj = new GetConstants(10);
		
		for(int i=0;i<5;i++){
			consObj.add();
			System.out.printf("%s",consObj);
		}

	}

}
