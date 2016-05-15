package com.abhyaastech.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadClass {

	public static void fileRead(String fileName) {
		
		File file = new File(fileName);

		BufferedReader br = null;

		try {
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);

			String line;

			while ((line = br.readLine()) != null) {

				System.out.println(line);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File Not found : " + file.toString());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Unable to read file : " + file.toString());
			e.printStackTrace();
		}

		finally {
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("Unable to close file : " + file.toString());
				e.printStackTrace();
			} catch (NullPointerException ex) {
				System.out.println("File was probably never opened");
			}
		}

	}

}

