package com.abhyaastech.staticandfinal;

public class Thing {
	
	public final static int LUCKY_NUMBER = 7;

	
	public String name;
	public static String description;
	
	public static int count = 0;
	
	public int id;
	
	public Thing() {
		
		id = count;
		count++;
		
	}
	
	
	public void showName() {
		
		System.out.println("Object ID: " +id + "," + description + ":" +name);
	}
	
	public static void showInfo() {
		System.out.println(description);
		
		/**
		 * TODO:
		 * Try to print name variable and let us know your observation
		 */
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public static String getDescription() {
		return description;
	}


	public static void setDescription(String description) {
		Thing.description = description;
	}
	
	
	
	

}
