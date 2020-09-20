package com.nit.jdbcthin;

import java.sql.Connection;
import java.sql.DriverManager;

public class conTest {

	public static void main(String[] args) throws Exception{
		// register JDBC driver class 
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// establish the connection
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.1:1521:orcl", "scott", "tiger");

				if (con != null) {
					System.out.println("Connection Established");
				} else {
					System.out.println("Connection Not Estblished");
				}
	}

}
