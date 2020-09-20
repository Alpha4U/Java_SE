package com.nit.jdbcthin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest {

	public static void main(String[] args) {

		Scanner sc = null;
		Connection con = null;
		Statement st = null;
		String query = null;
		int no = 0;
		int result = 0;

		try {
			// read input
			sc = new Scanner(System.in);
			if (sc != null) {
				System.out.println("Enter the Employee ID : ");
				no = sc.nextInt();
			}

			// register the JDBC Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// establish the connection
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.18.1:1521:orcl", "scott",
					"tiger");

			// create the JDBC Statement
			if (con != null) {
				st = con.createStatement();
			}

			// prepare the query
			query = "delete from emp where empno=" + no;

			// execute the query
			if (st != null) {
				result = st.executeUpdate(query);
			}

			// process the result
			if (result == 0) {
				System.out.println("No Record Found with Given ID");
			} else {
				System.out.println("Record Found and Deleted");
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
