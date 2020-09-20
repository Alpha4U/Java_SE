package com.nit.jdbcthin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class selectTest2 {

	public static void main(String[] args) {

		Scanner sc = null;
		String desg1 = null;
		String desg2 = null;
		String desg3 = null;
		String cond = null;
		String query = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		boolean flag = false;

		// read inputs
		try {
			sc = new Scanner(System.in);
			if (sc != null) {
				System.out.print("Enter Desg1 : ");
				desg1 = sc.next().toUpperCase();
				System.out.print("Enter Desg2 : ");
				desg2 = sc.next().toUpperCase();
				System.out.print("Enter Desg3 : ");
				desg3 = sc.next().toUpperCase();
			}

			// frame the condition
			cond = "('" + desg1 + "','" + desg2 + "','" + desg3 + "')";

			// register the JDBC Driver Software
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.1:1521:orcl", "scott",
					"tiger");

			// create the Statement
			if (con != null) {
				st = con.createStatement();
			}

			// prepare the query
			query = "select empno,ename,job,sal from emp where job in " + cond
					+ " order by job";
			System.out.println(query);
			
			// execute the SQL query
			if (st != null) {
				rs = st.executeQuery(query);
			}

			if (rs != null) {
				while (rs.next()) {
					flag = true;
					System.out.println(rs.getInt(1) + " " + rs.getString(2)
							+ " " + rs.getString(3) + " " + rs.getInt(4));
				}
				if (flag == false) {
					System.out.println("No Records Found");
				}
			}
		} catch (SQLException se) { // for known exception
			se.printStackTrace();
		} catch (ClassNotFoundException cnf) { // for known exception
			cnf.printStackTrace();
		} catch (Exception e) { // for unknown exceptions
			e.printStackTrace();
		}finally{
			// close objects
			try{
				if(rs!=null){
					rs.close();
				}
			}catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(st!=null){
					st.close();
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
