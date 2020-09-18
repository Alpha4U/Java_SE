// selectTest1.java
// JDBC app that gives employee details based on job
// query = select * from emp where where job="CLERK"

package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class selectTest1 {

	public static void main(String[] args) throws Exception {

		// take the input from user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Job : ");
		String job = sc.next(); // gives CLERK
		job = "'" + job + "'"; // gives 'CLERK'

		// register Type-1 JDBC Driver
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		// establish the connection with DB s/w
		Connection con = DriverManager.getConnection("jdbc:odbc:oradsn",
				"scott", "tiger");

		// Create the JDBC statement object and prepare Query
		Statement st = con.createStatement();
		String query = "select * from emp where job=" + job;
		System.out.println(query);

		// execute the query and process the resutSet

		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
					+ rs.getString(3));
		}

		// close all JDBC stream objects
		sc.close();
		rs.close();
		st.close();
		con.close();

	}// main

}// class
