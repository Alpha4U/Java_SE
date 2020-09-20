package com.nit.jdbcthin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlSelectTest {
	private static final String SELECT_FROM_STUDENT = "SELECT * FROM STUDENT";
	public static void main(String[] args) {
		
		Connection con = null;
		Statement st  = null;
		ResultSet rs = null;
		
		try{
			//register the jdbc driver
			//Class.forName("org.gjt.mm.mysql.Driver");
			Class.forName("com.mysql.jdbc.Driver");
			
			//establish the connection
			//con=DriverManager.getConnection("jdbc:mysql:///jdbcdb","root","");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_nacre","root","root");
			
			//create statement object
			if(con!=null){
				st = con.createStatement();
			}
			
			//prepare and execute sql query
			if(st!=null){
				rs = st.executeQuery(SELECT_FROM_STUDENT);
			}
			
			//process the result set
			if(rs!=null){
				while(rs.next()){
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				}//while
			}//if
			
		}//try
		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
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
