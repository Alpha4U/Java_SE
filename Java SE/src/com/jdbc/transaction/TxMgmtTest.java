package com.jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TxMgmtTest {

	public static void main(String[] args) {
		
		Scanner sc = null;
		int srcNo=0,destNo = 0,amt = 0;
		Connection con = null;
		Statement st  = null;
		int result[]= null;
		boolean flag = false;
		
		try{
			sc = new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter Source Account Number : ");
				srcNo = sc.nextInt();
				System.out.println("Enter Destination Account Number : ");
				destNo = sc.nextInt();
				System.out.println("Enter Ammount To Transfer : ");
				amt = sc.nextInt();
			}
			//register JDBC Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@alpha:1521:orcl","scott","tiger");
			//begin transaction
			if(con!=null){
				con.setAutoCommit(false);
				//create statement object
				st = con.createStatement();
			}
			if(st!=null){
				//add queries to the batch
				//withdraw amount from source account
				st.addBatch("update jdbc_account set balance=balance-"+amt+"where accno="+srcNo);
				//deposit amount into destination account
				st.addBatch("update jdbc_account set balance=balance+"+amt+"where accno="+destNo);
				//execute batch
				result = st.executeBatch();
			}//if
			//perform TXmgmt (commit or rollback)
			if(result!=null){
				for(int i=0;i<result.length;++i){
					if(result[i]==0){
						flag = true;
						break;
					}//if
				}//for
			}
			
			if(flag==true){
				con.rollback();
				System.out.println("Tx Rollback - Money Not Transfered");
			}else{
				System.out.println("Tx Committed - Money Transfered");
			}//else
		}//try
		catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
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
			try {
				if (sc != null) {
					sc.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
