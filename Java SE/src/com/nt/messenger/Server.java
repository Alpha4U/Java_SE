package com.nt.messenger;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Server extends JFrame {

	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;

	// constructor
	public Server() {
		super("Alpha Messenger");
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				sendMessage(event.getActionCommand());
				userText.setText("");
			}
		});
		add(userText, BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow));
		setSize(300, 150);
		setVisible(true);
	}

	// set up and run the server
	public void startRunning(){
			try{
				server = new ServerSocket(6789,100);
			while(true){
				try{
					waitForConnection();
					setupStreams();
					whileChatting();
				}catch(EOFException eof){
					showMessage("\n Server ended the connection");
				}finally{
					closeCrap();
				}
			}
		}catch(IOException ioe){	
			ioe.printStackTrace();	
		}
	}
	
	//wait for connection, then display connection information
	private void waitForConnection() throws IOException{
		showMessage("Waiting For Someone To Connect..... \n");
		connection = server.accept();
		showMessage("Now Connected To "+connection.getInetAddress().getHostName());
	}
	
	private void setupStreams()throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n Streams are Now Setup");
	}
	
	private void whileChatting()throws IOException{
		String message = "You Are Now Connected";
		sendMessage(message); 
		ableToType(true);
		do{
			//have a conversation
			try{
				message  = (String)input.readObject();
				showMessage("\n"+message);
			}catch(ClassNotFoundException cnf){
				showMessage("\n idk wtf the user sent");
			}
		}while(!message.equals("Client - End"));
	}
	
	//close streams and sockets after you are done chatting
	private void closeCrap(){
		showMessage("\n Closing Connections ..... ");
		ableToType(false);
		try{
			output.close();
			input.close();
			connection.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	//send a message to client
	private void sendMessage(String message){
		try{
			output.writeObject("Server - " + message);
			output.flush();
			showMessage("\nServer - "+message);
		}catch(IOException ioe){
			chatWindow.append("\n Message Cannot Be Sent");
		}
	}
	
	//updates chatWindow
	private void showMessage(final String text){
		SwingUtilities.invokeLater(
			new Runnable(){
			@Override
			public void run() {
				chatWindow.append(text);
			}
		});
	}
	
	//let the user type stuff into their box
	private void ableToType(final boolean tof){
		SwingUtilities.invokeLater(
				new Runnable() {
					@Override
					public void run() {
						userText.setEditable(tof);
					}
				});
	}
	
}
