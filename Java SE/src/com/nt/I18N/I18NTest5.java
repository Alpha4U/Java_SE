package com.nt.I18N;

import java.text.NumberFormat;

public class I18NTest5 {
	public static void main(String[] args) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		System.out.println(nf.format(123.4567));
		System.out.println(nf.format(123.4));
		
		nf.setMinimumFractionDigits(2);
		System.out.println(nf.format(123.4567));
		System.out.println(nf.format(123.4));
		
		nf.setMaximumIntegerDigits(3);
		System.out.println(nf.format(123456.789));
		System.out.println(nf.format(1.2345));
		
		nf.setMinimumIntegerDigits(3);
		System.out.println(nf.format(123456.789));
		System.out.println(nf.format(1.2345));
	}
}
