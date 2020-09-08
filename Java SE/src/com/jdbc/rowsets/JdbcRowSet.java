package com.jdbc.rowsets;

import javax.sql.RowSet;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class JdbcRowSet {

	public static void main(String[] args) {
		
		try{
			//create RowSet object
			RowSet jrowset = new OracleJDBCRowSet();
			//set JDBC properties
			jrowset.setUrl("jdbc:oracle:thin:@alpha:1521:orcl");
			jrowset.setUsername("scott");
			jrowset.setPassword("tiger");
			jrowset.setCommand("select * from student");
			jrowset.execute();
			System.out.println("Command Executed");
			//process the rowset
			while(jrowset.next()){
				System.out.println(jrowset.getInt(1)+" "+jrowset.getString(2));
			}
			jrowset.close();
		}//try
		catch(Exception e){
			System.out.println(e.toString());
		}
	}

}
