package com.jdbc.metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PMDTest {

	public static void main(String[] args) {

		Connection con = null;
		ParameterMetaData pmd = null;
		PreparedStatement ps = null;
		int count = 0;

		try {
			// register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// establish the connection
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@alpha:1521:orcl", "scott", "tiger");
			// create PreparedStatement
			if (con != null) {
				ps = con.prepareStatement("insert into student values(?,?,?)");
			}
			// create ParameterMetaData object
			if (ps != null) {
				pmd = ps.getParameterMetaData();
			}
			// display various details about parameter
			if (pmd != null) {
				count = pmd.getParameterCount();
				for (int i = 1; i <= count; ++i) {
					System.out.println("Parameter Number : " + i);
					System.out.println("Parameter Mode : "
							+ pmd.getParameterMode(i));
					System.out.println("Parameter Type Name : "
							+ pmd.getParameterTypeName(i));
					System.out.println("Parameter is Signed : "
							+ pmd.isSigned(i));
					System.out.println("Paraemeter is Nullable : "
							+ pmd.isNullable(i));
					System.out.println("Parameter Scale Area : "
							+ pmd.getScale(i));
					System.out.println("Parameter Precision Area : "
							+ pmd.getPrecision(i));
				}// for
			}// if
		}// try
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
