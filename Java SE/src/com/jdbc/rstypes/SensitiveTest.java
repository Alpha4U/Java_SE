package com.jdbc.rstypes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SensitiveTest {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int cnt = 0;
		try{
			//register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@alpha:1521:orcl","scott","tiger");
			//create statement object
			if(con!=null){
				st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			}
			//execute the query
			if(st!=null){
				rs=st.executeQuery("select empno,ename,job from emp");
			}
			System.out.println("Modify data from SQL prompt");
			//process the resultSet
			if(rs!=null){
				while(rs.next()){
					rs.refreshRow();
					if(cnt == 0){
						Thread.sleep(30000);
					}
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
					cnt++;
				}//while
			}//if
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
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
