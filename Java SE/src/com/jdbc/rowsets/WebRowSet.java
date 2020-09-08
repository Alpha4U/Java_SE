package com.jdbc.rowsets;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;

import oracle.jdbc.rowset.OracleWebRowSet;

public class WebRowSet {

	public static void main(String[] args) {
		
		try{
			//create WebRowSet object
			OracleWebRowSet webRS = new OracleWebRowSet();
			//set JDBC properties
			webRS.setUrl("jdbc:oracle:thin:@alpha:1521:orcl");
			webRS.setUsername("scott");
			webRS.setPassword("tiger");
			webRS.setCommand("select * from student");
			webRS.execute();
			System.out.println("Query Executed");
			
			//create or locate file
			File myFile = new File("E:/note.xml");
			FileWriter fw = new FileWriter(myFile);
			System.out.println("Writing Database Data To the File "+myFile.getAbsolutePath());
			webRS.writeXml(fw); //writes the records of Rowset to a File
			
			//convert xml to a String object for display purpose
			StringWriter sw = new StringWriter();
			webRS.writeXml(sw);
			System.out.println(sw.toString());
			fw.flush();
			fw.close();
			
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
