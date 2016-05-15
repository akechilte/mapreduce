package com.abhyaastech.setterandthis;

public class App {

	public static void main(String[] args) {
		
		Frog frog1 = new Frog();
		
		//frog1.name = "Johny";
		//frog1.age = 1; 
		
		frog1.setName("Johny");
		frog1.setAge(1);
		
		System.out.println(frog1.getName());

	}

}
