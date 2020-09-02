package com.jdbc.date;

import java.sql.Date;

public class SQLDateMethods {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		Date date = new Date(time);
		System.out.println(date.toLocalDate());
		System.out.println(date.toInstant());
	}
}
