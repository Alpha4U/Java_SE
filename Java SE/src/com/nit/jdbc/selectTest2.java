/** 
 selectTest2
 JDBC application to get employee details by given Jobs
 Coding with Coding Standards
 Java Version : 1.7
 Author : alpha
 Date : 14/08/2017
 */

package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class selectTest2 {

	public static void main(String[] args) {

		Scanner sc = null;
		String desg1 = null;
		String desg2 = null;
		String desg3 = null;
		String cond = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = null;
		boolean flag = false;

		try {
			// read inputs
			sc = new Scanner(System.in);
			if (sc != null) {
				System.out.println("Enter the Desg 1 : "); // gives CLERK
				desg1 = sc.next().toUpperCase();
				System.out.println("Enter the Desg 2 : "); // gives SALESMAN
				desg2 = sc.next().toUpperCase();
				System.out.println("Enter the Desg 3 : "); // gives MANAGER
				desg3 = sc.next().toUpperCase();
			}

			// frame condition ('CLERK','SALESMAN','MANAGER')
			cond = "('" + desg1 + "'" + "," + "'" + desg2 + "'" + "," + "'"
					+ desg3 + "')"; // gives ('CLERK','SALESMAN','MANAGER')

			// register JDBC Driver Software
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			// establish the connection
			con = DriverManager.getConnection("jdbc:odbc:oradsn", "scott",
					"tiger");

			// create the statement and prepare query
			if (con != null) {
				st = con.createStatement();
			}

			// frame the SQL Query
			// select empno,ename,job,sal from emp where job in
			// ('CLERK','SALESMAN','MANAGER') order by job
			// " in " clause in SQL query used as substitute of OR
			query = "select empno,ename,job,sal from emp where job in" + cond
					+ "order by job";
			System.out.println(query);

			// send and execute query
			if (st != null) {
				rs = st.executeQuery(query);
			}

			// process the ResultSet
			if (rs != null) {
				while (rs.next()) {
					flag = true;
					System.out.println(rs.getInt(1) + " " + rs.getString(2)
							+ " " + rs.getString(3) + " " + rs.getInt(4));
				}// while
				if (flag == false) {
					System.out.println("No Records Found");
				}// if
			}// try
		} catch (SQLException se) { // known exception
			se.printStackTrace();
		} catch (ClassNotFoundException cnf) { // known exception
			cnf.printStackTrace();
		} catch (Exception e) { // unknown exception
			e.printStackTrace();
		} finally {
			// close objects
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (sc != null) {
					sc.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}// finally
	}// main
}// class

