package com.abhyaastech.classenobject;

public class ManagePerson {

	public static void main(String[] args) {
		
		int myAge;
		String myName;
		
		//Create an object of Person class
		
		
		Person person1 = new Person();
		
		System.out.println("person1 object created : " +person1);
		
		person1.setName("Optimus Prime");
		person1.setAge(40);
	
		
		
		//Can you guess what will be the output?
		//System.out.println(person1.toString());
		
		person1.speak();	
		person1.sayHello();
		
		
		//Get Person's Name and Age
		myAge = person1.getAge();
		myName = person1.getName();
		
		System.out.println("\nAge : " +myAge);
		System.out.println("Name : " + myName);
		
		int years = person1.calculateYearsToRetirement(person1.getAge());
		System.out.println("\nYears till retirement : " +years + "\n\n");
		

		//Create another object of Person class
		Person person2 = new Person();
		
		System.out.println("person2 object created : " +person2);
		
		person2.setName("Bumblebee");
		person2.setAge(26);
		
		person2.speak();
		person2.sayHello();
		
		//Let's access the the variables in Person object directly
		System.out.println("\nMy Name is : " +person1.name);
		System.out.println("My Age is  : " +person1.age);
		

	}

}
