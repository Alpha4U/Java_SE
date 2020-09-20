package com.nit.jdbcthin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class selectTest4 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = null;
		int count = 0;
		
		try{
			//register JDBC Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.1:1521:orcl","scott","tiger");
			
			//create JDBC statement
			if(con!=null){
				st = con.createStatement();
			}
			
			//prepare the query
			query = "select count(*) from emp";
			
			//execute the query
			if(st!=null){
				rs = st.executeQuery(query);
			}
			
			//prepare the ResultSet
			if(rs!=null){
				if(rs.next()){
					count = rs.getInt("count(*)");
				}
			}//if
			System.out.println("Records Count : "+count);
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

		}// finally

	}

}
