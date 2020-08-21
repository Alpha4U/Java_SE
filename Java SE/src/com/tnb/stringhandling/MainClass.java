package com.tnb.stringhandling;

public class MainClass {

	public static void main(String[] args) {
		//String class object is immutable
		String[] words = {"funk","chunk","furry","ragnarock"};
		
		for(String w:words){
			if(w.startsWith("fu")){
				System.out.println(w+" starts with fu");
			}
		}
		
		for(String w:words){
			if(w.endsWith("nk")){
				System.out.println(w+" ends with nk");
			}
		}

	}

}
