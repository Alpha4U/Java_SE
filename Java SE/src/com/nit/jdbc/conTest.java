//conTest.java
// Type 1 Driver Used
package com.nit.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;

public class conTest {

	public static void main(String[] args) throws Exception {
		// register JDBC driver class object
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// establish the connection
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@alpha:1521:orcl", "scott", "tiger");

		if (con != null) {
			System.out.println("Connection Established");
		} else {
			System.out.println("Connection Not Estblished");
		}
	}// main

}// class
