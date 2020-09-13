package com.jdbc.rstypes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatableTest {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try{
			//register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@alpha:1521:orcl","scott","tiger");
			//create statement object
			if(con!=null){
				st  = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			}
			//execute the query
			if(st!=null){
				rs = st.executeQuery("select empno,ename,job from emp");
			}
			//read records
			if(rs!=null){
				while(rs.next()){
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				}//while
			
			//update operation
			rs.absolute(3);
			rs.updateString(2, "HARRY");
			System.out.println("Record Updated");
			//to insert new record
			rs.moveToInsertRow();
			rs.updateInt(1, 456);
			rs.updateString(2, "NIKKI");
			rs.updateString(3, "TEACHER");
			rs.insertRow();
			System.out.println("Record Inserted");
			//to delete record
			rs.absolute(2);
			rs.deleteRow();
			System.out.println("Record Delerted");	
			}
			
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}catch (ClassNotFoundException se) {
			se.printStackTrace();
		}catch(Exception e){
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
