package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectNonSelectTest {

	public static void main(String[] args) {
		
		Scanner sc = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = null;
		boolean flag = false;
		int count = 0;
		
		try{
			//read input
			sc= new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter the Query : ");
				query = sc.nextLine();
			}//if
			
			//register JDBC driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			//establish the connection
			con = DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
			
			//create the statement
			if(con!=null){
				st = con.createStatement();
			}
			
			//send and execute SQL query
			flag = st.execute(query);
			if(flag == true){
				System.out.println("Select Query Executed");
				rs = st.getResultSet();
				//process the resultSet
				while(rs.next()){
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				}//while
			}//if 
			else{
				System.out.println("NonSelect Query Executed");
				count = st.getUpdateCount();
				System.out.println("No of Records that are Affected : "+count);
			}//else
		}//try
		catch (SQLException se) {
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
	}//main
}//class
