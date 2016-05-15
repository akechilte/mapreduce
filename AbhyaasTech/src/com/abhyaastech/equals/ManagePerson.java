package com.abhyaastech.equals;

public class ManagePerson {

	public static void main(String[] args) {
		
		Person person1 = new Person(20, "Bumblebee");
		Person person2 = new Person(20, "Bumblebee");
		
		System.out.println(person1 == person2); //true/false
		
		System.out.println(person1);
		System.out.println(person2);
		
		System.out.println("Person 1: " +person1.toString());
		System.out.println("Person 2: " +person2.toString());
		
		System.out.println(person1.equals(person2));
		
		String str1 = "str1";
		String str2 = "str1";
		
		str1.equals("str1");
		
		
		Double value1 = 7.2;
		Double value2 = 7.2;
		
		System.out.println(value1 == value2);
		System.out.println(value1.equals(value2));
		
		Integer int1 = 6;
		Integer int2 = 6;
		
		System.out.println(int1 == int2);

	}

}
