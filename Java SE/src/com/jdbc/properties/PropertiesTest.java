package com.jdbc.properties;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PropertiesTest {
private static final String SELECT_EMP_DETAILS = "SELECT * FROM EMP";
	public static void main(String[] args) {
		
		InputStream is = null;
		String driver=null,url=null,dbuser=null,dbpwd=null;
		Connection con= null;
		Statement st =null;
		ResultSet rs = null;
		Properties props = null;
		
		try{
			//locate properties file
			is = new FileInputStream("src/com/jdbc/properties/DBprop.properties");
			//load properties file data into java.util.Properties class object
			props = new Properties();
			props.load(is);
			//read JDBC properties from properties file
			driver = props.getProperty("jdbc.driver");
			url = props.getProperty("jdbc.url");
			dbuser = props.getProperty("jdbc.user");
			dbpwd = props.getProperty("jdbc.password");
			
			//register jdbc driver
			Class.forName(driver);
			//establish the connection
			con = DriverManager.getConnection(url,dbuser,dbpwd);
			//create statement
			if(con!=null){
				st = con.createStatement();
			}
			if(st!=null){
				rs = st.executeQuery(SELECT_EMP_DETAILS);
			}
			if(rs!=null){
				while(rs.next()){
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				}
			}else{
				System.out.println("No Record Found");
			}
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

		}// finally
		
	}

}
