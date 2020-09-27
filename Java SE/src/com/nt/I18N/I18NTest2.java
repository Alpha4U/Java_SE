package com.nt.I18N;

import java.text.NumberFormat;
import java.util.Locale;

public class I18NTest2 {
	public static void main(String[] args) {
		// to implement = Locale, NumberFormat, DateFormat
		// NumberFormat(AC) = to format a java number acc to  particular locate
		
		NumberFormat nf1= NumberFormat.getInstance();
		NumberFormat nf2 = NumberFormat.getCurrencyInstance();
		NumberFormat nf3 = NumberFormat.getPercentInstance();
		NumberFormat nf4 = NumberFormat.getNumberInstance();
		
		// to get above objects for a particular locale, pass that locale object as an argument
		
		NumberFormat nf5 = NumberFormat.getNumberInstance(Locale.getDefault());
		String s1 = nf5.format(65.1216);
		// format() = to convert number to locale specific string
		// parse() = locale specific string to java number
		
	}
}
