package com.nit.jdbc;

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
		int no = 0;
		int result = 0;
		String query = null;
	
		try{
			//read input
			sc = new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter the Employee ID Number : ");
				no = sc.nextInt();
			}
			//register the JDBC Driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			//establish the connection
			con = DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
			
			//create the statement
			if(con!=null){
				st = con.createStatement();
			}
			
			//prepare the SQL Query
			query = "delete from emp where empno="+no;
			
			//execute the SQL Query
			if(st!=null){
				result =st.executeUpdate(query);
			}
			
			//process the result
			if(result == 0){
				System.out.println("No Record Found");
			}else{
				System.out.println("Record Found and Deleted");
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
		}//finally
	}
}
