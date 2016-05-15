package com.abhyaastech.setterandthis;

public class Frog {
	
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	//just an example	
	public void setInfo(String name, int age) {
		setName(name);
		setAge(age);
	}

}
