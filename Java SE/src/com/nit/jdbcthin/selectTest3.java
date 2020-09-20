package com.nit.jdbcthin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class selectTest3 {

	public static void main(String[] args) {
		
		Scanner sc = null;
		String desg1 = null;
		String desg2 = null;
		String desg3 = null;
		String cond = null;
		String query = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		boolean flag = false;

		// read inputs
		try {
			sc = new Scanner(System.in);
			if (sc != null) {
				System.out.print("Enter Desg1 : ");
				desg1 = sc.next().toUpperCase(); // gives CLERK
				System.out.print("Enter Desg 2 : ");
				desg2 = sc.next().toUpperCase(); // gives SALESMAN
				System.out.print("Enter Desg 3 : ");
				desg3 = sc.next().toUpperCase(); // gives MANAGER
			}

			// frame the condition ('CLERK','MANAGER','SALESMAN')
			cond = ("('" + desg1 + "','" + desg2 + "','" + desg3 + "')");

			// register JDBC Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.1:1521:orcl", "scott",
					"tiger");

			// create JDBC statement
			if (con != null) {
				st = con.createStatement();
			}

			// frame the Query
			query = "select empno,ename,job,sal from emp where job in " + cond
					+ " order by job";
			System.out.println(query);

			// execute the SQL query
			if (st != null) {
				rs = st.executeQuery(query);
			}

			// prepare the resultSet
			if (rs != null) {
				while (rs.next()) {
					flag = true;
					System.out.println(rs.getInt(1) + " " + rs.getString(2)
							+ " " + rs.getString(3) + " " + rs.getInt(4));
				}
				if (flag == false) {
					System.out.println("No Records Found");
				}
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
		}//finally

	}

}
