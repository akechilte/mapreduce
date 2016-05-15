package com.abhyaastech.constructor;

public class Machine {
	
	private String name;
	private int age;
	

	public Machine() {
		
		System.out.println("First Constructor running");
		
		this.name = "AhyaasTeh";
	}
	
	public Machine(String name, int age) {
		System.out.println("\nSecond constructor running");
		this.name = name;
		this.age = age;
	}
	
	
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
	
	

}
