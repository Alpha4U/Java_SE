package com.nt.I18N;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class I18NTest6 {
	public static void main(String[] args) {
		// FILL, LONG, MEDIUM, SHORT = 0,1,2,3 = for time also 0 to 3
		DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println(df1.format(new Date()));
		
		System.out.println("LONG Form is : "+DateFormat.getDateInstance(DateFormat.LONG).format(new Date()));
		
		String date = DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date()); // default
		System.out.println(date);
		
		DateFormat df4 = DateFormat.getDateInstance(DateFormat.SHORT,Locale.US);
		System.out.println(df4.format(new Date()));
		
		System.out.println(DateFormat.getDateInstance(0, Locale.UK).format(new Date()));
		System.out.println(DateFormat.getDateInstance(0, Locale.ITALY).format(new Date()));
		System.out.println(DateFormat.getDateTimeInstance().format(new Date()));
		System.out.println(DateFormat.getDateTimeInstance(0,0,Locale.US).format(new Date()));
		
	}
}
