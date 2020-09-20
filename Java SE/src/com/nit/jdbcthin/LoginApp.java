package com.nit.jdbcthin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginApp {

	public static void main(String[] args) {
		
		Scanner sc =null;
		Connection con = null;
		Statement st = null;
		String uname = null;
		String pass = null;
		String query = null;
		ResultSet rs = null;
		int count = 0;
		
		try{
			//read inputs
			sc = new Scanner(System.in);
			if(sc!=null){
				System.out.print("Username : ");
				uname = sc.next().toUpperCase();
				System.out.print("Password : ");
				pass = sc.next().toUpperCase();
			}
			
			uname = "'"+uname+"'";
			pass = "'"+pass+"'";
			
			//register JDBC Driver Class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.1:1521:orcl","scott","tiger");
			
			//create JDBC statement
			if(con!=null){
				st = con.createStatement();
			}
			
			//prepare the SQL query
			query = "select count(*) from emp where ename="+uname+"and job="+pass;
			
			//execute the SQL Query
			if(st!=null){
				rs = st.executeQuery(query);
			}
			
			//process the resultSet
			if(rs!=null){
				if(rs.next()){
					count = rs.getInt(1);
					System.out.println(count);
				}
			}
			if(count == 0){
				System.out.println("Invalid Credentials");
			}else{
				System.out.println("Valid Credentials");
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
			try {
				if (sc != null) {
					sc.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//finally
			
	}

}
