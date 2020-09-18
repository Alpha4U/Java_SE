package com.nit.jdbc;

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
		
		try{
			sc = new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter the Emp ID : ");
				empno = sc.nextInt();
				System.out.println("Enter the Emp Name : ");
				ename = sc.next().toUpperCase();
				System.out.println("Enter the Job : ");
				job = sc.next().toUpperCase();
			}
			
			ename="'"+ename+"'";
			job="'"+job+"'";
			
			//register the JDBC driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			//establish the connection
			con = DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
			
			//create the statement
			if(con!=null){
				st = con.createStatement();
			}
			
			//prepare the query
			query = "update emp set ename="+ename+" ,job="+job+" where empno="+empno;
			
			//execute the query
			if(st!=null){
				result = st.executeUpdate(query);
			}
			
			//prepare the result
			if(result == 0){
				System.out.println("Record Not Updated ");
			}else{
				System.out.println("Record Updated");
			}
		}catch (SQLException se) {
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
		
	}//main

}//class
