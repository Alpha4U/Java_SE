//converting string date to java.util.Date class object in two steps
package com.jdbc.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringToDateConversion {

	public static void main(String[] args) {
		
		try {
			
			//converting string date value to java.util.Date class object
			String d1 = "10-07-2017";
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date ud1 = sdf1.parse(d1);
			System.out.println("util date : "+ud1);
			
			//converting java.util.Date class object to java.sql.Date class object
			long ms = ud1.getTime();
			java.sql.Date sqd1 = new java.sql.Date(ms);
			System.out.println("sql date : "+sqd1);
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}
