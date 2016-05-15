package test.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//to sort List in any order other than natural way, you need to create a class that implements 'comparator' interface

//Let's sort elements of animals based of their length

class StringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		
		int len1 = s1.length();
		int len2 = s2.length();
		
		if (len1 > len2) {
			return 1;
		}
		else if (len1 < len2) {
			return -1;
		}
		
		return 0;
		
	}
	
}

class AlphabeticalComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		
		/*
		 * compareTo method is returning 	+1 if s1 > s2
		 * 									-1 if s1 < s2
		 * 									0  if s1 = s2
		 * You can write the same thing using if-else as shown above 
		 */
		
		return s1.compareTo(s2);
	}
	
}

class ReverseAlphabeticalComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		return -s1.compareTo(s2);
	}
	
}

//Define your own class. We will sort objects of this class using comparator

class Person2 {
	
	private int id;
	private String name;
	
	//let's give it a constructor
	
	public Person2(int id, String name){
		this.id = id;
		this.name = name;
	}

	//let's have getter and setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//let's have a method - toString
	
	public String toString() {
		return id + ":" +name;
	}
		
}

public class ComparatorTest {

	public static void main(String[] args) {
		
		
		/////////////////Sorting Strings/////////////////////////
		
		List<String> animals = new ArrayList<String>();
		
		animals.add("tiger");
		animals.add("lion");
		animals.add("cat");
		animals.add("snake");
		animals.add("mongoose");
		animals.add("elephant");
		
		//We can sort the animals arraylist by a static method 'sort' of Collections class
		//This will sort elements of animals in natural order : Collections.sort(animals);
		//To use the comparator defined above, you need to provide 'sort' method with an instance of it.
		
		Collections.sort(animals, new StringLengthComparator());
		
		for (String animal : animals) {
			System.out.println(animal);
		}
		
		System.out.println("\nAlphabeticalComparator");
		
		Collections.sort(animals, new AlphabeticalComparator());
		
		for (String animal : animals) {
			System.out.println(animal);
		}
		
		System.out.println("\nReverseAlphabeticalComparator");
		
		Collections.sort(animals, new ReverseAlphabeticalComparator());
		
		for (String animal : animals) {
			System.out.println(animal);
		}
		
		
		///////////////Sorting Numbers/////////////////////////
		
		List<Integer> numbers = new ArrayList<Integer>();
		
		numbers.add(3);
		numbers.add(7);
		numbers.add(36);
		numbers.add(73);
		numbers.add(40);
		numbers.add(1);
		
		Collections.sort(numbers);
		
		for (Integer number : numbers) {
			System.out.println(number);
		}

		/*
		 * You do not have to always write a class for implementing comparator, you can do it as follows as well.
		 * i.e. using anonymous class
		 */
		
		System.out.println("\nReverse Numerical Order");
		
		Collections.sort(numbers, new Comparator<Integer>() {

			@Override
			public int compare(Integer num1, Integer num2) {
				
				return -num1.compareTo(num2);
			}
			
		});
		
		for (Integer number : numbers) {
			System.out.println(number);
		}
		
		///////////////Sorting Random Objects/////////////////////////
		
		List<Person2> people = new ArrayList<Person2>();
		
		people.add(new Person2(1, "Joe"));
		people.add(new Person2(3, "Bob"));
		people.add(new Person2(4, "Clare"));
		people.add(new Person2(2, "Sue"));
		
		Collections.sort(people, new Comparator<Person2>() {

			//Sort in order of ID - using if-else
			@Override
			public int compare(Person2 p1, Person2 p2) {
				
				if(p1.getId() > p2.getId()) {
					return 1;
				}
				else if(p1.getId() < p2.getId()) {
					return -1;
				}
				else
				return 0;
			}
			
		});
		
		System.out.println("\nSort People2 objects by ID: ");
		
		for (Person2 person2 : people) {
			System.out.println(person2);
		}
		
		Collections.sort(people, new Comparator<Person2>() {

			//Sort in order of Name - using compareTo method
			@Override
			public int compare(Person2 p1, Person2 p2) {
				
				return p1.getName().compareTo(p2.getName());
			}
			
		});
		
		System.out.println("\nSort People2 objects by Name: ");
		
		for (Person2 person2 : people) {
			System.out.println(person2);
		}
		
	}

}

