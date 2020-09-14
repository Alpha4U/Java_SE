package com.jdbc.scrollable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScrollableTest {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		String dburl = "jdbc:oracle:thin:@alpha:1521:orcl";
		String dbuser = "scott",dbpass="tiger";
		
		try{
			//register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection(dburl,dbuser,dbpass);
			//create prepared Statement object
			if(con!=null){
				ps = con.prepareStatement("select * from emp",
														ResultSet.TYPE_SCROLL_SENSITIVE,
														ResultSet.CONCUR_READ_ONLY);
			}
			//create resultSet object
			if(ps!=null){
				rs = ps.executeQuery("select * from emp");
			}
			//display records (top-bottom)
			if(rs!=null){
				System.out.println("Top - Bottom");
				while(rs.next()){
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				}//while
				
				System.out.println("Bottom - Top");
				while(rs.previous()){
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				}
				
				System.out.println("-----------------------------------------------------");
				//first record
				rs.first();
				System.out.println(rs.getRow()+" "+"--->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				//last record
				rs.last();
				System.out.println(rs.getRow()+" "+"--->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				//3rd record from top
				rs.absolute(3);
				System.out.println(rs.getRow()+" "+"--->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				//3rd record from bottom
				rs.absolute(-3);
				System.out.println(rs.getRow()+" "+"--->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				//relative
				rs.relative(2);
				System.out.println(rs.getRow()+" "+"--->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				//relative
				rs.relative(-4);
				System.out.println(rs.getRow()+" "+"--->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
	
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
				if(ps!=null){
					ps.close();
				}
			}catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(rs!=null){
					rs.close();
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
		}
	}

}
