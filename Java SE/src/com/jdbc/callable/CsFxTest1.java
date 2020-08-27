
package com.jdbc.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsFxTest1 {
private static final String CALL_FUNCTION = "{?=call FX_GET_EMP_DETAILS_BY_NO(?,?,?)}";
	public static void main(String[] args) {
		
		Connection con = null;
		Scanner sc =null;
		String desg = null,name=null;
		int no=0,sal = 0;	
		CallableStatement cs = null;
		
		try{
			sc = new Scanner(System.in);
			//set IN parameter
			if(sc!=null){
				System.out.print("Enter Employee Id : ");
				no = sc.nextInt();
			}
			//register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@alpha:1521:orcl","scott","tiger");
			//create statement
			if(con!=null){
				cs = con.prepareCall(CALL_FUNCTION);
			}
			if(cs!=null){
				//register OUT parameter with JDBC Types
				cs.registerOutParameter(1, Types.INTEGER);
				cs.registerOutParameter(3, Types.VARCHAR);
				cs.registerOutParameter(4, Types.VARCHAR);
				
				cs.setInt(2, no);
				
				//call function
				cs.execute();
				
				//prepare output
				sal= cs.getInt(1);
				name = cs.getString(3);
				desg = cs.getString(4);
				
				System.out.println("Emp Name : "+name);
				System.out.println("Emp Desg : "+desg);
				System.out.println("Emp Sal : "+sal);
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