package com.abhyaastech.interfaces;


import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		Machine mach1 = new Machine();
		mach1.start();
		
		Person person1 = new Person("Optimus Prime");
		person1.greet();
		
		
		List<String> list = new ArrayList<>();
		
		//Up-casting 
		Info info1 = new Machine();
		//info1.showInfo();	
		
		Info info2 = person1;
		info2.showInfo();
		
		outputInfo(mach1);
		//outputInfo(person1);

	}
	
	private static void outputInfo(Info info) {
		
		info.showInfo();
		
	}

}
