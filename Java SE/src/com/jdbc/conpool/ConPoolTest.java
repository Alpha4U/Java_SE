package com.jdbc.conpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class ConPoolTest {
	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		OracleConnectionPoolDataSource ds = null;
		
		try{
			//Create DataSource object representing empty JDBC connection pool
			ds = new OracleConnectionPoolDataSource();
			if(ds!=null){
				//set JDBC properties to DB object to create con object in the connection pool
				ds.setDriverType("thin");
				ds.setURL("jdbc:oracle:thin:@192.168.18.1:1521:orcl");
				ds.setUser("scott");
				ds.setPassword("tiger");
				//get connection object from JDBC connection pool through data source object
				con=ds.getConnection();
			}
			//create statement object
			if(con!=null){
				st = con.createStatement();
			}
			//send and execute SQL query
			if(con!=null){
				rs=st.executeQuery("SELECT * FROM STUDENT");
			}
			//process the resultSet
			if(rs!=null){
				while(rs.next()){
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				}
			}
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null){
					rs.close();
				}
			}catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(st!=null){
					st.close();
				}
			}catch(SQLException se){
				se.printStackTrace();
			}
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
