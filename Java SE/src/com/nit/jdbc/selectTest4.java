//JDBC application that gives the records count of DB table

package com.nit.jdbc;

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
		int count = 0;
		String query = null;

		try {
			// register the JDBC Driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			// establish the connection
			con = DriverManager.getConnection("jdbc:odbc:oradsn", "scott",
					"tiger");

			// create JDBC statement
			if (con != null) {
				st = con.createStatement();
			}

			// prepare the query
			query = "select count (*) from emp";

			// execute the query
			if (st != null) {
				rs = st.executeQuery(query);
			}

			// get the count
			if(rs!=null){
				if (rs.next()) {
					count = rs.getInt("count(*)");
				}	
			}
			System.out.println("Records Count : " + count);
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
	}//main
}//class
