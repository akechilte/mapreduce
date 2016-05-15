package com.abhyaastech.interfaces;

public class Person implements Info {
	
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public void greet() {
		System.out.println("\nI am a Person");
	}


	@Override
	public void showInfo() {
		System.out.println("\nPerson's name is : " +name);
		
	}
	

}
