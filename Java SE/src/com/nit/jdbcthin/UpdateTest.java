package com.nit.jdbcthin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args) {

		Scanner sc = null;
		Connection con = null;
		Statement st = null;
		int empno = 0;
		String ename = null;
		String job = null;
		String query = null;
		int result = 0;

		try {
			sc = new Scanner(System.in);
			if (sc != null) {
				System.out.println("Enter the Employee ID : ");
				empno = sc.nextInt();
				System.out.println("Enter the Employee Name : ");
				ename = sc.next().toUpperCase();
				System.out.println("Enter the Employee Job : ");
				job = sc.next().toUpperCase();
			}

			ename = "'" + ename + "'";
			job = "'" + job + "'";

			// register the JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.1:1521:orcl", "scott",
					"tiger");

			// create the Statement
			if (con != null) {
				st = con.createStatement();
			}

			// prepare the query
			query = "update emp set ename=" + ename + ",job=" + job
					+ " where empno=" + empno;

			// execute the SQL query
			if (st != null) {
				result = st.executeUpdate(query);
			}

			// prepare the results
			if (result == 0) {
				System.out.println("Record Not Updated");
			} else {
				System.out.println("Record Updated");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close objects

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

	}

}
