package com.nit.jdbcthin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class selectTest {

	public static void main(String[] args) throws Exception {
		// register type-1 Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// establish the connection with DB s/w
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.1:1521:orcl",
				"scott", "tiger");

		// create JDBC statement object
		Statement st = con.createStatement();

		// execute the query and process resultSet
		ResultSet rs = st.executeQuery("select * from emp");

		while (rs.next() != false) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "+ rs.getString(3));
		}

		// close all JDBC stream objects
		rs.close();
		st.close();
		con.close();
	}// main

}// class
