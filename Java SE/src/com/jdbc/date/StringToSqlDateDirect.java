//converting string to java.sql.Date class object directly using ValueOf()

package com.jdbc.date;

public class StringToSqlDateDirect {

	public static void main(String[] args) {
		
		String d2 = "2017-07-10";
		java.sql.Date sqd2 = java.sql.Date.valueOf(d2);
		System.out.println("Sql Date : "+sqd2);
	}

}
