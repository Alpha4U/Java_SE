package com.tnb.adapterclasses;

import javax.swing.JFrame;

public class MainClass {

	public static void main(String[] args) {
		
		/*adapter class internally implements the interface and overrides all the methods with empty body
		   and the whatever class extends from an adapter class can override desired method no need  to 
		   provide definition for all the methods*/
		
		UseAdapterClass goObj = new UseAdapterClass();
		goObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		goObj.setSize(300,200);
		goObj.setVisible(true);

	}

}
