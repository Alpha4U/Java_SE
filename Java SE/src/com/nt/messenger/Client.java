package com.nt.messenger;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Client extends JFrame{
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = "";
	private String serverIP;
	private Socket  connection;
	
	//constructor
	public Client(String host) {
		super("Client App");
		serverIP = host;
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				sendMessage(event.getActionCommand());
				userText.setText(" ");
			}
		});
		add(userText,BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow),BorderLayout.CENTER);
		setSize(300,150);
		setVisible(true);
	}
	
	//connect to server
	public 	void startRunning(){
		try{
			connectToServer();
			setupStreams();
			whileChatting();
		}catch(EOFException eof){
			showMessage("\n Client Terminated Connection");
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}finally{
			closeCrap(); 
		}
	}
	
	//connect to server
	private void connectToServer() throws IOException{
		showMessage("Attempting Connection... \n");
		connection = new Socket(InetAddress.getByName(serverIP),6789);
	}
	 
	//set up Streams to send and recieve messages
	private void setupStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n Input and Output Streams are Ready \n");
	}
	
	//while chatting with server
	private void whileChatting() throws IOException{
		ableToType(true);
		do{
			try{
				message = (String)input.readObject();
				showMessage("\n"+message);
			}catch(ClassNotFoundException cnf){
				showMessage("\n Object Type Not Recognised");
			}
		}while(!message.equals("SERVER - END"));
	}
	
	private void closeCrap(){
		showMessage("\n Closing crap down");
		ableToType(false);
		try{
			output.close();
			input.close();
			connection.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	//send message to server
	private void sendMessage(String message){
		try{
			output.writeObject("CLIENT : "+message);
			output.flush();
			showMessage("\n CLIENT : "+message);
		}catch(IOException ioe){
			chatWindow.append("\n Some Issues while Sending Message");
		}
	}
	
	//change/update	chatWindow
	private void showMessage(final String m){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				chatWindow.append(m);
			}
		});
	}
	
	//gives user permission to type crap into the text box
	private void ableToType(final boolean tof){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				userText.setEditable(tof);
			}
		});
	}
		
}
