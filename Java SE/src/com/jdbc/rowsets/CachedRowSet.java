package com.jdbc.rowsets;

public class CachedRowSet {

	public static void main(String[] args) throws Exception{
		
		//create RowSet object
		oracle.jdbc.rowset.OracleCachedRowSet crowset = new oracle.jdbc.rowset.OracleCachedRowSet();
		//set JDBC properties
		crowset.setUrl("jdbc:oracle:thin:@alpha:1521:orcl");
		crowset.setUsername("scott");
		crowset.setPassword("tiger");
		crowset.setCommand("select * from student");
		crowset.execute();
		//process the resultSet
		while(crowset.next()){
			System.out.println(crowset.getInt(1)+" "+crowset.getString(2)+" "+crowset.getString(3));
		}
		crowset.close();
		
	}

}
