package com.jdbc.savepoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavePointTest {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		Savepoint sp = null;
		
		try{
			//register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@alpha:1521:orcl","scott","tiger");
			//create statement object
			if(con!=null){
				st = con.createStatement();
			}
			//begin Transaction
			con.setAutoCommit(false);
			if(st!=null){
				//execute query1
				st.executeUpdate("insert into student values(9472,'Rajat','Lucknow')");
				//create savepoint
				sp=con.setSavepoint("mysp");
				//execute query2
				st.executeUpdate("insert into student values(4935,'Sooraj','Lakhimpur')");
				//rollback upto savepoint
				con.rollback(sp);
				con.commit();
				System.out.println("Done");
			}//if
		}//try
		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}catch(SQLException se){
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
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
