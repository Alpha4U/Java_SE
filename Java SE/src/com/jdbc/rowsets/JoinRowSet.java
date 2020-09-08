package com.jdbc.rowsets;

import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleJoinRowSet;

public class JoinRowSet {

	public static void main(String[] args) throws Exception {

		// cached RowSet1
		OracleCachedRowSet crs1 = new OracleCachedRowSet();
		// set JDBC properties
		crs1.setUrl("jdbc:oracle:thin:@alpha:1521:orcl");
		crs1.setUsername("scott");
		crs1.setPassword("tiger");
		crs1.setCommand("select empno,ename,deptno from emp");
		crs1.setMatchColumn(3);
		crs1.execute();

		// cached RowSet2
		OracleCachedRowSet crs2 = new OracleCachedRowSet();
		crs2.setUrl("jdbc:oracle:thin:@alpha:1521:orcl");
		crs2.setUsername("scott");
		crs2.setPassword("tiger");
		crs2.setCommand("select deptno,dname,loc from dept");
		crs2.setMatchColumn(1);
		crs2.execute();

		// JoinRowSet
		OracleJoinRowSet joinRS = new OracleJoinRowSet();
		joinRS.addRowSet(crs2);
		joinRS.addRowSet(crs1);

		// process the JoinRowSet
		while (joinRS.next()) {
			System.out.println(joinRS.getString(1) + " " + joinRS.getString(2)
					+ " " + joinRS.getString(3) + " " + joinRS.getString(4)
					+ " " + joinRS.getString(5));
		}

	}

}
