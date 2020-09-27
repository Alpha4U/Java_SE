package com.nt.I18N;

import java.util.Locale;
 
public class I18NTest1 {
	public static void main(String[] args) {
		// providing response as per the request regional domain is called internationalization
		// enadu.net = no I18N
		// amazon.com = I18N
		// to implement = Locale, NumberFormat, DateFormat
		// Locale = final class
		
		Locale l1 = new Locale("pa");
		System.out.println(l1.getLanguage());
		
		Locale l3 = Locale.getDefault();
		System.out.println(l3.getLanguage());
		
		Locale l2 = new Locale("pa","IN");
		System.out.println(l2.getDisplayLanguage());
		// pn = punjabi
		// IN = india
		// locale = language + country
		Locale []l = l1.getAvailableLocales();
		System.out.println("********************************************************************");
		for(Locale lo : l) {
			System.out.println(lo.getLanguage());
			System.out.println(lo.getCountry());
			System.out.println("*********************************************************************");
		}
	}
}
