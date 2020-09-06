package com.jdbc.metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaApplication {

	public static void main(String[] args) {
		
		 Connection con = null;
		 Statement st  = null;
		 ResultSet rs = null;
		 ResultSetMetaData rsmd = null;
		 int colCnt = 0; 
		 try{
			 //register JDBC driver
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 //establish the connection
			 con = DriverManager.getConnection("jdbc:oracle:thin:@alpha:1521:orcl","scott","tiger");
			 //create statement object
			 if(con!=null){
				 st = con.createStatement();
			 }
			 //send and execute SQL query in DB software
			 if(st!=null){
				 rs = st.executeQuery("select * from student");
			 } 
			 if(rs!=null){
				 //create resultSet MetaData 
				 rsmd=rs.getMetaData();
				 //get column count
				 colCnt = rsmd.getColumnCount();
				 //display column names
				 for (int i = 1; i <= colCnt; ++i) {
					System.out.print(rsmd.getColumnLabel(i)+"   ");
				}
				System.out.println();
				//display column types
				for (int i = 1; i <= colCnt; ++i) {
					System.out.print(rsmd.getColumnTypeName(i)+"   ");
				}
				System.out.println();
				//process the resultSet
				while(rs.next()){
					for (int i = 1; i <= colCnt; ++i) {
						System.out.print(rs.getString(i)+"   ");
					}//for
					System.out.println();
				}//while 
			 }//if
		 }//try
		 catch(SQLException se){
			 se.printStackTrace();
		 }
		 catch(ClassNotFoundException cnf){
				cnf.printStackTrace();
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
