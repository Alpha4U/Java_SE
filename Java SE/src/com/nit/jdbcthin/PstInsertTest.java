package com.nit.jdbcthin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PstInsertTest {
	private static String INSERT_STUDENT_RECORD = "INSERT INTO STUDENT VALUES(?,?,?)";
	public static void main(String[] args) {

		Scanner sc = null;
		Connection con = null;
		PreparedStatement ps = null;
		int count = 0;
		int sid = 0;
		String sname = null;
		String state = null;
		int result = 0;

		try {
			// read inputs
			sc = new Scanner(System.in);
			System.out.println("Enter Student Count : ");
			if (sc != null) {
				count = sc.nextInt();
			}

			// register the JDBC driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// establish the connection
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.0.16:1521:orcl", "scott",
					"tiger");

			// execute the pre-compiled query
			if (con != null) {
				ps = con.prepareStatement(INSERT_STUDENT_RECORD);
			}

			// read multiple set of input values from end user
			if (sc != null) {
				for (int i = 1; i <= count; ++i) {
					System.out.println("Enter " + i + " Student details");
					System.out.println("Enter Student ID :");
					sid = sc.nextInt();
					System.out.println("Enter Student Name : ");
					sname = sc.next().toUpperCase();
					System.out.println("Enter Student State : ");
					state = sc.next().toUpperCase();

					// send the input values to query parameters
					ps.setInt(1, sid);
					ps.setString(2, sname);
					ps.setString(3, state);

					// execute the query
					result = ps.executeUpdate();

					if (result == 0) {
						System.out.println(i
								+ " student details are not inserted");
					} else {
						System.out
								.println(i + " student details are inserted");
					}
				}// for
			}// if
		}// try
		catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close objects

			try {
				if (ps != null) {
					ps.close();
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
