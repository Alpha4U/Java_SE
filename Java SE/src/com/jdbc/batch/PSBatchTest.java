package com.jdbc.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PSBatchTest {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		int result[] = null;
		
		try{
			//register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@alpha:1521:orcl","scott","tiger");
			//create PreaparedStatement object
			if(con!=null){
				ps = con.prepareStatement("insert into student values (?,?,?)");
			}
			if(ps!=null){
				//add multiple sets of parameter values to the batch
				ps.setInt(1, 7398);ps.setString(2, "raja");ps.setString(3, "hyd");
				ps.addBatch();
				ps.setInt(1, 1937);ps.setString(2, "ramesh");ps.setString(3, "vizag");
				ps.addBatch();
				
				//execute the batch
				result = ps.executeBatch();
			}
			if(result!=null){
				System.out.println("Records Inserted");
			}else{
				System.out.println("Records Not Inserted");
			}
		}//try
		catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
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
		}

	}

}
