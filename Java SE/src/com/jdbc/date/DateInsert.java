package com.jdbc.date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateInsert {
	private static final String INSERT_PERSONS_DETAILS = "INSERT INTO PERSONS VALUES (?,?,?,?,?)";

	public static void main(String[] args) {
		Scanner sc = null;
		Connection oraCon = null;
		Connection mysqlCon = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		int result = 0,result1 = 0, empno = 0;
		String ename = null, loc = null, dob = null, doj = null;
		java.util.Date udob = null;
		java.sql.Date sqdob = null, sqdoj = null;
		SimpleDateFormat sdf = null;
		long ms = 0;

		try {
			sc = new Scanner(System.in);
			if (sc != null) {
				System.out.println("Enter EmpNo : ");
				empno = sc.nextInt();
				System.out.println("Enter Emp Name : ");
				ename = sc.next().toUpperCase();
				System.out.println("Enter Emp Location : ");
				loc = sc.next().toUpperCase();
				System.out.println("Enter Date Of Birth (dd-MM-yyyy) : ");
				dob = sc.next();
				System.out.println("Enter Date Of Joining (yyyy-MM-dd) : ");
				doj = sc.next();
			}
			// convert string date values to java.sql.Date class objects
			// for DOB
			sdf = new SimpleDateFormat("dd-MM-yyyy");
			// converting string date to java.util.Date class object
			if (sdf != null) {
				udob = sdf.parse(dob);
			}
			// convert time to miliseconds
			if (udob != null) {
				ms = udob.getTime();
			}
			// converting java.util.Date class object to java.sql.Date class
			// object
			sqdob = new java.sql.Date(ms);
			// for DOJ
			sqdoj = java.sql.Date.valueOf(doj);

			// register the jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");

			// establish the connection
			oraCon = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.0.16:1521:orcl", "scott",
					"tiger");
			mysqlCon = DriverManager.getConnection("jdbc:mysql:///jdbcdb", "root",
					"");

			// create PreapareStatement object
			if (oraCon != null && mysqlCon!=null) {
				ps = oraCon.prepareStatement(INSERT_PERSONS_DETAILS);
				ps1 = mysqlCon.prepareStatement(INSERT_PERSONS_DETAILS);
			}
			// set query parameter values
			if (ps != null && ps1 !=null) {
				ps.setInt(1, empno);
				ps.setString(2, ename);
				ps.setString(3, loc);
				ps.setDate(4, sqdob);
				ps.setDate(5, sqdoj);
				
				ps1.setInt(1, empno);
				ps1.setString(2, ename);
				ps1.setString(3, loc);
				ps1.setDate(4, sqdob);
				ps1.setDate(5, sqdoj);
			}
			// execute the query
			if (ps != null && ps1 !=null) {
				result = ps.executeUpdate();
				result1 = ps1.executeUpdate();
			}
			// process the reasultSet
			if (result == 0 && result1 ==0) {
				System.out.println("Record Not Inserted");
			} else {
				System.out.println("Record Inserted");
			}
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
				if (oraCon != null) {
					oraCon.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (mysqlCon != null) {
					mysqlCon.close();
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
