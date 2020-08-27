package com.jdbc.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsTest1 {
	private static final String CALL_PROCEDURE = "{call FIRST_PRO1(?,?) }";

	public static void main(String[] args) {
		
		int no =0,result=0;
		Connection con = null;
		CallableStatement cs = null;
		Scanner sc = null;
		
		try{
			sc = new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter the Number : ");
				no = sc.nextInt();
			}
			//register the JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@alpha:1521:orcl","scott","tiger");
			//create callableStatement
			if(con!=null){
				cs = con.prepareCall(CALL_PROCEDURE);
			}
			if(cs!=null){
				//register out parameter with JDBC types
				cs.registerOutParameter(2,Types.INTEGER);
				
				//set value to IN parameter
				cs.setInt(1, no);
				
				//execute PL/SQL procedure
				cs.execute();
				
				//gather result from OUT param
				result = cs.getInt(2);
				System.out.println("SQUARE value : "+result);
			}//if
		}catch(SQLException se){
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
