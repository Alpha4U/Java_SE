package com.nit.jdbcthin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {

	public static void main(String[] args) {

		Scanner sc = null;
		Connection con = null;
		Statement st = null;
		int empno = 0;
		String ename = null;
		String job = null;
		int result = 0;
		String query = null;
		
		try{
			//read inputs
			sc = new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter the Employee ID : ");
				empno = sc.nextInt();
				System.out.println("Enter the Employee Name : ");
				ename = sc.next().toUpperCase();
				System.out.println("Enter the Job : ");
				job = sc.next().toUpperCase();
			}
			
			ename = "'"+ename+"'";
			job = "'"+job+"'";
			
			//register the JDBC Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.16:1521:orcl","scott","tiger");
			
			//create the Statement
			if(con!=null){
				st=con.createStatement();
			}
			
			//prepare the Query
			query = "insert into emp (empno,ename,job) values ("+empno+","+ename+","+job+")";
			
			//execute the query
			if(st!=null){
				result = st.executeUpdate(query);
			}
			
			//prepare the result
			if(result == 0){
				System.out.println("Record Not Inserted");
			}else{
				System.out.println("Record Inserted");
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

	}

}
