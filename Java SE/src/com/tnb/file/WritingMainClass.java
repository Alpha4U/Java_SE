package com.tnb.file;

public class WritingMainClass {

	public static void main(String[] args) {
		WritingToFile write = new WritingToFile();
		write.openFile();
		write.addRecords();
		write.closeFile();
	}

}
