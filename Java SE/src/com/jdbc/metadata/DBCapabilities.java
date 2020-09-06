package com.jdbc.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCapabilities {

	public static void main(String[] args) {
		
		Connection con = null;
		DatabaseMetaData dbmd = null;
		
		try{
			//register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@alpha:1521:orcl","scott","tiger");
			//get MetaData
			dbmd = con.getMetaData();
			//the database details are
			if(dbmd!=null){
				System.out.println("Database Name : "+dbmd.getDatabaseProductName());
				System.out.println("Database Version : "+dbmd.getDatabaseProductVersion());
				System.out.println("Database Major Version : "+dbmd.getDatabaseMajorVersion());
				System.out.println("Database Minor Version : "+dbmd.getDatabaseMinorVersion());
			}
			
			
		}catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(con!=null){
					con.close();
				}
			}catch(SQLException se){
				se.printStackTrace();
			}
		}

	}

}
