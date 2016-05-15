package com.abhyaastech.classenobject;

public class Person {

	
	//Classes can contain 
	// 1. Data
	// 2. subroutines (methods)
	
	//Instance variable (data or "state")
	public String name;
	public int age;
	
	/*
	 * TODO:
	 * Make above instance variables private and make changes to the programs accordingly
	 * 
	 */

	
	//Subroutines/Method
	
	public void speak() {
		System.out.println("My name is : " +name +" and I am " +age + " years old");
	}
	
	public void sayHello() {
		System.out.println("\nHello there : " +name);
	}
	
	public int calculateYearsToRetirement(int ages) {
		
		int yearsLeft = 65 - age;
		
		return yearsLeft;
	}
	
	// getter methods encapsulates the variables. stop other class to access it directly

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
	
	
	
	
	
	
}
