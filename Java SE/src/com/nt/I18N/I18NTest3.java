package com.nt.I18N;

import java.text.NumberFormat;
import java.util.Locale;

public class I18NTest3 {
	public static void main(String[] args) {
		double d = 123456.789;
		System.out.println(d);
		NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
		String s = nf.format(d);
		System.out.println(s);
	}
}
