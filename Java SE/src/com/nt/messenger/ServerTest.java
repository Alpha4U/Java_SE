package com.nt.messenger;

import javax.swing.JFrame;

public class ServerTest {

	public static void main(String[] args) {
		Server srvr = new Server();
		srvr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		srvr.startRunning();
	}

}
