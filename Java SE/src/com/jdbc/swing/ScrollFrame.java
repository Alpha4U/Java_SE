package com.jdbc.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ScrollFrame extends JFrame implements ActionListener{
	
		private JLabel lno,lname,laddrs;
		private JTextField tno,tname,taddrs;
		private JButton bfirst,blast,bnext,bprevious;
		private Connection con = null;
		private PreparedStatement ps = null;
		private ResultSet rs = null;
		
			public static void main(String[] args) {
				
				System.out.println("main(-)");
				ScrollFrame frame = new ScrollFrame();

			}
	
			//constructor
			public ScrollFrame(){
				System.out.println("Constructor");
				setTitle("Swing App");
				setSize(300,300);
				setLayout(new FlowLayout());
				//add components
				lno = new JLabel("Student ID : ");
				add(lno);
				tno = new JTextField(10);
				add(tno);
				lname = new JLabel("Name");
				add(lname);
				tname = new JTextField(10);
				add(tname);
				laddrs = new JLabel("Address");
				add(laddrs);
				taddrs = new JTextField(10);
				add(taddrs);
				
				bfirst = new JButton("First");
				bfirst.addActionListener(this);
				add(bfirst);
				blast = new JButton("Last");
				blast.addActionListener(this);
				add(blast);
				bnext = new JButton("Next");
				bnext.addActionListener(this);
				add(bnext);
				bprevious = new JButton("Previous");
				bprevious.addActionListener(this);
				add(bprevious);
				
				setVisible(true);
				makeConnection();
				addWindowListener(new MyWindowAdapter());
				
			}
			
			public void makeConnection(){
				try{
					//register JDBC driver
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//establish the connection
					con = DriverManager.getConnection("jdbc:oracle:thin:@alpha:1521:orcl","scott","tiger");
					//create prepared statement
					if(con!=null){
						ps = con.prepareStatement("select * from emp",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					}
					//create scrollable resultSet object
					if(ps!=null){
						rs = ps.executeQuery();
					}
				}catch(SQLException se){
					se.printStackTrace();
				}catch(ClassNotFoundException cnf){
					cnf.printStackTrace();
				}catch(Exception e){
					e.printStackTrace();
				}
			}//makeConnection

			@Override
			public void actionPerformed(ActionEvent ae) {
				
				System.out.println(ae.getActionCommand());
				System.out.println("actionPerformed(-)");
				boolean flag = false;
				
				try{
					if(ae.getSource()==bfirst){
						System.out.println("First Button");
						rs.first();
						flag = true;
					}else if(ae.getSource()==blast){
						System.out.println("Last Button");
						rs.last();
						flag = true;
					}else if(ae.getSource()==bnext){
						System.out.println("Next Button");
						if(!rs.isLast()){
							rs.next();
							flag=true;
						}//if
					}else 
						System.out.println("Prevoius Button");
						if(!rs.isFirst()){
							rs.previous();
							flag=true;
					}
					
					if(flag==true){
						tno.setText(rs.getString(1));
						tname.setText(rs.getString(2));
						taddrs.setText(rs.getString(3));
					}
					
				}//try
				catch(SQLException se){
					se.printStackTrace();
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			
			public class MyWindowAdapter extends WindowAdapter{
				@Override
				public void windowClosing(WindowEvent e) {
					System.out.println("windowClosing(-)");
					//close JDBC objects
					try{
						if(rs!=null){
							rs.close();
						}
					}catch(SQLException se){
						se.printStackTrace();
					}
					
					try{
						if(ps!=null){
							ps.close();
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
