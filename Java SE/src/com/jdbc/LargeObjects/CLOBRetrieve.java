package com.jdbc.LargeObjects;

import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CLOBRetrieve {
	private static final String SELECT_CANDIDATE_RESUME = "SELECT * FROM CANDIDATES WHERE CID = ?";

	public static void main(String[] args) {
		
		Scanner sc = null;
		Connection con = null;
		PreparedStatement ps = null;
		int cid = 0;
		Reader reader = null;
		char[] buffer = null;
		int charsRead = 0;
		ResultSet rs = null;
		Writer writer = null;
		
		try{
			sc = new Scanner(System.in);
			if (sc!=null) {
				System.out.println("Enter the ID : ");
				cid = sc.nextInt();
			}//if
			
			//register the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb","root","");
			//create prepared statement
			if(con!=null){
				ps = con.prepareStatement(SELECT_CANDIDATE_RESUME);
			}
			
			//set query parameter values
			if(ps!=null){
				ps.setInt(1, cid);
			}
			
			//execute the query
			if(ps!=null){
				rs = ps.executeQuery();
			}
			
			//process the result
			if(rs.next()){
				reader=rs.getCharacterStream(4);
			}
			//create output stream for destination file
			writer = new FileWriter("E:cvout/resume.txt");
			//write buffer based logic to copy the content
			buffer = new char[2048];
			while((charsRead=reader.read(buffer))!=(-1)){
				writer.write(buffer,0,charsRead);
			}
			
			System.out.println("CLOB Retrieved");
			
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//close jdbc objects
			try{
				if(rs!=null){
					rs.close();
				}
			}catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(ps!=null){
					ps.close();
				}
			}catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(con!=null){
					ps.close();
				}
			}catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(sc!=null){
					sc.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				if(reader!=null){
					reader.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				if(writer!=null){
					writer.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
