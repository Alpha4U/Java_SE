package com.jdbc.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessTest {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		int result[] = null;
		int sum = 0;
		
		try{
			//register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@alpha:1521:orcl","scott","tiger");
			//create statement object
			if(con!=null){
				st = con.createStatement();
			}
			if(st!=null){
				st.addBatch("insert into student values(585,'raja','hyd')");
				st.addBatch("update student set state='delhi' where sid = 5");
				st.addBatch("delete from student where sid >= 5");
				//execute the batch
				result = st.executeBatch();
			}
			//process the results
			if(result!=null){
				for(int i=0;i<result.length;++i){
					sum = sum + result[i];
				}//for
				System.out.println("No Of Records Affected Are : "+sum);
			}//if
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
		}

	}

}
