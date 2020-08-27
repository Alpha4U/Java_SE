package com.jdbc.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.internal.OracleTypes;

public class CsCursorTest {
private static final String CALL_PROCEDURE = "{call P_fetch_AllEmpDetails(?,?)}";
	public static void main(String[] args) {

		Scanner sc = null;
		Connection con = null;
		String initChars = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		boolean flag = false;
		
		try{
			sc = new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter the Initial Character : ");
				initChars = sc.next().toUpperCase()+"%";
			}//if
			//register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@alpha:1521:orcl","scott","tiger");
			//call callable statement
			if(con!=null){
				cs = con.prepareCall(CALL_PROCEDURE);
			}
			if(cs!=null){
				//register out parameter with JDBC types
				cs.registerOutParameter(2, OracleTypes.CURSOR);
				//set IN parameter value
				cs.setString(1, initChars);
				//call procedure
				cs.execute();
				//gather OUT parameters
				rs = (ResultSet)cs.getObject(2);
			}
			//prepare resultSet 
			if(rs!=null){
				while(rs.next()){
					flag = true;
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
				}//while
			}//if
			if(flag == false){
				System.out.println("No Records Found");
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
