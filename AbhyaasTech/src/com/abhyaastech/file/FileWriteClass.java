package com.abhyaastech.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteClass {

	public BufferedWriter fileWriteOpen(File outFile) {
		
		FileWriter outFr = null;
		try {
			outFr = new FileWriter(outFile);
			BufferedWriter outBr = new BufferedWriter(outFr);
			
			System.out.println("File Open Success");
			
			return outBr;
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Problem in reading file : fileWriteOpen");
			
			return null;
		}
		
	}
	
	public void fileWrite(BufferedWriter outBr, String outRec) {

			try {
				outBr.write(outRec);
				outBr.newLine();
				
				System.out.println("Wrote the file");
				
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Problem in writing file : fileWrite");
			}
	}
	
	public void fileClose(BufferedWriter outBr) {
		
		try {
			outBr.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Problem in file close : fileClose");
		}
		
	}

}
