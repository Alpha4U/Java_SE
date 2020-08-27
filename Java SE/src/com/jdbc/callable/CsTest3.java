package com.jdbc.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsTest3 {
	private static final String CALL_PROCEDURE = "{call P_authUser(?,?,?)}";
	public static void main(String []args){
		Connection con = null;
		Scanner sc = null;
		CallableStatement cs = null;
		String user = null,pass = null,result = null;
		
		try{
			sc = new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter the UserName : ");
				user = sc.next().toUpperCase();
				System.out.println("Enter the Password : ");
				pass = sc.next().toUpperCase();
			}//if
			//register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@alpha:1521:orcl","scott","tiger");
			//create callable statement
			if(con!=null){
				cs = con.prepareCall(CALL_PROCEDURE);
			}
			if(cs!=null){
				//register OUT parameter 
				cs.registerOutParameter(3, Types.VARCHAR);
				//set IN params
				cs.setString(1, user);
				cs.setString(2, pass);
				//call procedure
				cs.execute();
				//get output
				result = cs.getString(3);
				System.out.println(result);
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
