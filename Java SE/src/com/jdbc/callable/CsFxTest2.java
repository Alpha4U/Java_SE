package com.jdbc.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class CsFxTest2 {
	private static final String CALL_FUNCTION ="{?=call FX_GET_STUDENT_FOR_DELETION(?,?)}";
	public static void main(String[] args) {
		Scanner sc =null;
		Connection con = null;
		CallableStatement cs = null;
		int no=0;
		String dburl = "jdbc:oracle:thin:@alpha:1521:orcl",user="scott",pass="tiger";
		ResultSet rs = null;
		
		try{
			sc = new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter the Emp ID : ");
				no = sc.nextInt();
			}
			//register the JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection(dburl,user,pass);
			//create statement
			if(con!=null){
				cs = con.prepareCall(CALL_FUNCTION);
			}
			if(cs!=null){
				//register OUT parameter 
				cs.registerOutParameter(1, OracleTypes.CURSOR);
				cs.registerOutParameter(3, Types.VARCHAR);
				
				//set IN parameter
				cs.setInt(2, no);
				
				//call function
				cs.execute();
				
				//get output
				rs = (ResultSet)cs.getObject(1);
				if(rs!=null){
					if(rs.next()){
						System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
					}//if
				}//if
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
				if(rs!=null){
					rs.close();
				}
			}catch(SQLException se){
				se.printStackTrace();
			}
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
