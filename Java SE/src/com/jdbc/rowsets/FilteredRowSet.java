package com.jdbc.rowsets;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.Predicate;

import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleFilteredRowSet;

	class Filtered1 implements Predicate{
	private String colName ;
	public Filtered1 (String colName){
		this.colName = colName;
	}
	
	public boolean evaluate(RowSet rs){
		System.out.println("Evaluate");
		try{
			OracleCachedRowSet crs = (OracleCachedRowSet)rs;
			String object = crs.getString(colName);
			if(object!=null && (object.charAt(0)=='A'||object.charAt(0)=='a')){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}


	@Override
	public boolean evaluate(Object value, int column) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean evaluate(Object value, String columnName)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}//Filtered1 Class

public class FilteredRowSet{
	public static void main(String[] args) throws Exception {
		
		//create Filtered RowSets
		OracleFilteredRowSet frs = new OracleFilteredRowSet();
		frs.setUsername("scott");
		frs.setPassword("tiger");
		frs.setUrl("jdbc:oracle:thin:@alpha:1521:orcl");
		frs.setCommand("select * from emp");
		
		frs.setFilter(new Filtered1("ename"));
		frs.execute();
		while(frs.next()){
			System.out.println(frs.getInt(1)+" "+frs.getString(2)+" "+frs.getString(3));
		}
		
	}//main
}//class
