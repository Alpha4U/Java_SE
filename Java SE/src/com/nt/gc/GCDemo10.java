package com.nt.gc;

import java.util.Date;

public class GCDemo10 {
	static Date d;

	public static void main(String[] args) {
		for (int i = 1; i <= 10000; i++) {
			d = new Date();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		for (int i = 1; i <= 10000; i++) {
			d = null;
		}
	}
}