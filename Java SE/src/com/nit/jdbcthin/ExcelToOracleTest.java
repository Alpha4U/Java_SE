package com.nit.jdbcthin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExcelToOracleTest {
	
	private static final String SELECT_FROM_EXCEL ="SELECT * FROM [Sheet1$]";
	private static final String INSERT_INTO_ORACLE = "INSERT INTO STUDENT VALUES (?,?,?)";	
	
	public static void main(String[] args) {
		
		Connection oraCon = null;
		Connection xlsCon = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int sid = 0;
		String sname, state;
		
		try{

			//register JDBC Drivers
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//establish the connection
			xlsCon = DriverManager.getConnection("jdbc:odbc:xlsdsn");
			oraCon = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.16:1521:orcl","scott","tiger");
			
			//create statement objects
			if(oraCon !=null){
				ps = oraCon.prepareStatement(INSERT_INTO_ORACLE);
			}
			if(xlsCon !=null){
				st = xlsCon.createStatement();
			}
			
			//execute the select query in excel
			if(xlsCon!=null){
				rs=st.executeQuery(SELECT_FROM_EXCEL);
			}
			
			//process the resultSet to copy to Oracle DB table
			if(rs!=null && ps !=null){
				while(rs.next()){
					//get each record from ResultSet
					sid=rs.getInt(1);
					sname=rs.getString(2);
					state=rs.getString(3);
					//set result set values to insert query parameters
					ps.setInt(1, sid);
					ps.setString(2, sname);
					ps.setString(3, state);
					
					ps.executeUpdate();
				}//while
				System.out.println("Record are Copied");
			}//if
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
				if (ps != null) {
					ps.close();
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
				if (oraCon != null) {
					oraCon.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (xlsCon != null) {
					xlsCon.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}//finally


	}

}
