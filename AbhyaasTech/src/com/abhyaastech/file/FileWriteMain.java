package com.abhyaastech.file;

import java.io.BufferedWriter;
import java.io.File;


public class FileWriteMain {

	public static void main(String[] args) {
		
		System.out.println("Start the Program\n");
		
		File outFile = new File("myfile.dat");

		FileWriteClass fileWriteObj = new FileWriteClass();

		BufferedWriter outBr = fileWriteObj.fileWriteOpen(outFile);
		
		fileWriteObj.fileWrite(outBr, "This is Line 1");
		fileWriteObj.fileWrite(outBr, "This is Line 2");
		
		fileWriteObj.fileClose(outBr);
		
		System.out.println("\nEnd of Program");
		
		String abc = "Hello";
		
		System.out.println("Hello obj : " +abc);
		
		abc = abc + "world";
		
		System.out.println("Hello World : " +abc);
		
		/*
		 * TODO:
		 * Read the content of the above file and display the content in the console
		 * Hint:
		 * You can make use of FileReadClass.java
		 * 
		 */
		

	}

}
