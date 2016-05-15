package com.abhyaastech.constructor;

public class App {

	public static void main(String[] args) {
		
		String myName;
		int age;
		
		//Let's create a machine object
		Machine machine1 = new Machine();
		
		myName = machine1.getName();
		
		System.out.println("machine1 : " +myName);
		
		//Lets create another Machine Object
		Machine machine2 = new Machine("AbhyaasTechAgain", 23);	
		
		myName = machine2.getName();
		age = machine2.getAge();
		
		System.out.println("machine2 : " +myName);
		System.out.println("machine2 : " +age);

	}

}
