package com.jdbc.LargeObjects;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PhotoRetrieve {
	private static final String PERSON_DETAILS_RETRIEVE = "SELECT ENAME,SALARY,PHOTOPATH FROM DETAILS WHERE EMPNO = ?";
	public static void main(String[] args) {
		
		Scanner sc = null;
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int no=0 ;
		InputStream is =null;
		OutputStream os = null;
		byte[] buffer = null;
		int bytesRead = 0;
		
		try{
			sc = new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter Person ID : ");
				no = sc.nextInt();
			}
			//register the JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@alpha:1521:orcl","scott","tiger");
			//create the pareparedStatement object
			if(con!=null){
				ps = con.prepareStatement(PERSON_DETAILS_RETRIEVE);
			}
			if(ps!=null){
				//set parameter values
				ps.setInt(1, no);
				//execute the query
				rs = ps.executeQuery();
			}
			//process the resultSet (get BLOB value)
			if(rs!=null){
				if(rs.next()){
					is = rs.getBinaryStream(3);
				}
			}//if
			
			//create outputStream for destination file
			os = new FileOutputStream("E:/JG.jpg");
			
			//write buffer based logic to copy file content 
			buffer = new byte[4096];
			while((bytesRead = is.read(buffer)) != (-1)){
				os.write(buffer,0,bytesRead);
			}//while
			
			System.out.println("Photo Retrived");
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
				if (is != null) {
					is.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
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

		}// finally
		
	}
}
