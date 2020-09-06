package com.jdbc.LargeObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PhotoInsert {
	private static final String INSERT_WITH_PHOTO = "INSERT INTO DETAILS VALUES (?,?,?,?)";
	public static void main(String[] args) {
		
		Scanner sc = null;
		PreparedStatement ps = null;
		Connection con = null;
		int empno = 0, result = 0;
		String ename =null,photopath = null;
		Float sal = 0.0f;
		File file = null;
		InputStream is = null;
		
		try {
			sc = new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter Emp No : ");
				empno = sc.nextInt();
				System.out.println("Enter Emp Name : ");
				ename = sc.next().toUpperCase();
				System.out.println("Enter the Slary : ");
				sal = sc.nextFloat();
				System.out.println("Enter the Photopath : ");
				photopath = sc.next();
			}//if
			//create input stream by locating file based on photopath
			file = new File(photopath);
			is = new FileInputStream(file);
			//register jdbc driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.1:1521:orcl","scott","tiger");
			//create PreparedStatement object
			if(con!=null){
				ps = con.prepareStatement(INSERT_WITH_PHOTO);
			}
			//set query parameter values
			if(ps!=null){
				ps.setInt(1, empno);
				ps.setString(2, ename);
				ps.setFloat(3, sal);
				ps.setBinaryStream(4, is,file.length());
			}
			//execute the query
			if(ps!=null){
				result = ps.executeUpdate();
			}
			//process the result
			if(result == 0){
				System.out.println("Record Not Inserted");
			}else{
				System.out.println("Record Inserted");
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

		}// finally
	}//main
}//class
