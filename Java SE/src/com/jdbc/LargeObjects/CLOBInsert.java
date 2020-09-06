package com.jdbc.LargeObjects;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CLOBInsert {
	private static final String INSERT_CANDIDATE_RESUME = "INSERT INTO CANDIDATES VALUES (?,?,?,?)";

	public static void main(String[] args) {
		
		Scanner sc = null;
		Connection con = null;
		PreparedStatement ps = null;
		int cid = 0,csalary = 0,result=0;
		String cname = null, resumePath = null;
		File file = null;
		Reader reader = null;
		
		try{
			sc = new Scanner(System.in);
			if (sc!=null) {
				System.out.println("Enter the ID : ");
				cid = sc.nextInt();
				System.out.println("Enter the Name : ");
				cname = sc.next().toUpperCase();
				System.out.println("Enter the Salary : ");
				csalary = sc.nextInt();
				System.out.println("Enter Resume Path : ");
				resumePath = sc.next();
			}//if
			
			//register the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb","root","");
			//create prepared statement
			if(con!=null){
				ps = con.prepareStatement(INSERT_CANDIDATE_RESUME);
			}
			
			file = new File(resumePath);
			reader = new FileReader(file);
			
			//set query parameter values
			if(ps!=null){
				ps.setInt(1, cid);
				ps.setString(2, cname);
				ps.setInt(3, csalary);
				ps.setCharacterStream(4, reader, file.length());
			}
			
			//execute the query
			if(ps!=null){
				result = ps.executeUpdate();
			}
			
			//process the result
			if(result==0){
				System.out.println("Record Not Inserted");
			}else{
				System.out.println("Record Inserted");
			}
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
		}
	}
}
