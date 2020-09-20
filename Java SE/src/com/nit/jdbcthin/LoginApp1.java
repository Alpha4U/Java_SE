package com.nit.jdbcthin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginApp1 {
	private static String VERIFY_STUDENT_LOGIN = "SELECT COUNT(*) FROM STUDENT WHERE SNAME=? AND STATE=?";
	public static void main(String[] args) {
		
		Scanner sc =null;
		Connection con = null;
		PreparedStatement ps = null;
		String uname = null;
		String pass = null;
		ResultSet rs = null;
		int count = 0;
		
		try{
			//read inputs
			sc = new Scanner(System.in);
			if(sc!=null){
				System.out.println("Username : ");
				uname = sc.next().toUpperCase();
				System.out.println("Password : ");
				pass = sc.next().toUpperCase();
			}
			
			//register JDBC Driver Class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.16:1521:orcl","scott","tiger");
			
			//create JDBC statement
			if(con!=null){
				ps = con.prepareStatement(VERIFY_STUDENT_LOGIN);
			}
			
			//set param values
			if(ps!=null){
				ps.setString(1,uname);
				ps.setString(2,pass);
			}
			
			//send and execute sql query
			if(ps!=null){
				rs=ps.executeQuery();
				if(rs.next()){
					count = rs.getInt(1);
				}
			}
			
			if(count==0){
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
				if (ps != null) {
					ps.close();
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
