package com.java.ocjp;

public class FloatTest {

	public static void main(String[] args) {
		Float pi = new Float(3.14f);
		if (pi > 3) {
		System.out.print("pi is bigger than 3. ");
		}
		else {
		System.out.print("pi is not bigger than 3. ");
		}
		
		//if you enable the following code, it will be compilation error.
		/*
		finally {
		System.out.println("Have a nice day.");
		}
		*/
	}
}
