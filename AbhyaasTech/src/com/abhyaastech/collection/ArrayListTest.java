package com.abhyaastech.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		
 		ArrayList<Integer> numbers = new ArrayList<Integer>();
 		
 		//adding elements to ArrayList 		
 		numbers.add(10);
 		numbers.add(100);
 		numbers.add(40);
 		
 		
 		//Retrieving  		
 		System.out.println(numbers.get(1));
 		
 		System.out.println("\n Iteration #1: ");
 		
 		//Indexed for loop iteration
 		
 		for(int i=0; i<numbers.size(); i++) {
 			System.out.println(numbers.get(i));
 		}
 		
 		
 	
 		numbers.remove(0);
 		
 		System.out.println("\n Iteration #2: ");
 		
 		for(Integer value: numbers) {
 			System.out.println(value);
 		} 
 		
 		
	}

}
