package com.jdbc.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsTest2 {
	private static final String CALL_PROCEDURE = "{call P_GET_EMP_DETAILS(?,?,?,?)}";
	public static void main(String[] args) {
		
		Scanner sc = null;
		Connection con = null;
		int no = 0;
		CallableStatement cs = null;
		
		try{
			sc = new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter the ID : ");
				no = sc.nextInt();
			}//if
			//register JDBC Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@alpha:1521:orcl","scott","tiger");
			//create statement
			if(con!=null){
				cs = con.prepareCall(CALL_PROCEDURE);
			}
			if(cs!=null){
				//register OUT parameters with JDBC types
				cs.registerOutParameter(2, Types.VARCHAR);
				cs.registerOutParameter(3, Types.VARCHAR);
				cs.registerOutParameter(4, Types.INTEGER);
				
				//set input parameter 
				cs.setInt(1, no);
				
				//call PL/SQL procedure
				cs.execute();
				
				//gather results from OUT parameters
				System.out.println("Emp Name : "+cs.getString(2));
				System.out.println("Emp Job: "+cs.getString(3));
				System.out.println("Emp Salary: "+cs.getString(4));
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
				if(cs!=null){
					cs.close();
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
			try{
				if(sc!=null){
					sc.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
