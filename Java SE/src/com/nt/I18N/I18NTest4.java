package com.nt.I18N;

import java.text.NumberFormat;
import java.util.Locale;

public class I18NTest4 {
	public static void main(String[] args) {
		double d = 123456.789;
		Locale india = new Locale("pa","IN");
		NumberFormat nf1 = NumberFormat.getCurrencyInstance(india);
		System.out.println(nf1.format(d));
		 	
		NumberFormat nf2 = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(nf2.format(d));
		
		NumberFormat nf3 = NumberFormat.getInstance(Locale.UK);
		System.out.println(nf3.format(d));
		
		NumberFormat nf4 = NumberFormat.getInstance(Locale.FRANCE);
		System.out.println(nf4.format(d));
	}
}
