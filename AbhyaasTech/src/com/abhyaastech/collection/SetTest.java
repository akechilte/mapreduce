package com.abhyaastech.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		// Set contains unique values
		
		//HashSet does not retain order
		Set<String> setHashSet = new HashSet<String>();
		
		//LinkedHashSet remembers the order you added items in
		Set<String> setLinkedHashSet = new LinkedHashSet<String>();
		
		//LinkedHashSet remembers the order you added items in
		Set<String> setTreeSet = new TreeSet<String>();
		
		System.out.println("\nPrint Element of HashSet");
		DataEntrySet("HashSet", setHashSet);
		
		System.out.println("\nPrint Element of LinkedHashSet");
		DataEntrySet("LinkedHashSet", setLinkedHashSet);

		System.out.println("\nPrint Element of TreeSet");
		DataEntrySet("setTreeSet", setTreeSet);
	}
	
	public static void DataEntrySet(String type, Set<String> set){
		
		if (set.isEmpty())	{
			System.out.println("Set is Empty");
		}
		
		set.add("dog");
		set.add("cat");
		set.add("mouse");
		set.add("snake");
		set.add("bear");
		
		//Adding duplicate item does nothing. Quite helpful feature
		
		set.add("mouse");
		
		System.out.println(set);
		
		//Iterate thru set
		
		for (String element : set) {
			System.out.println(element);
		}
		
		//Does set contains a given item?
			
		if (set.contains("chuha"))	{
			System.out.println("Set sontains Chuha");
		}
		
		if (set.contains("cat"))	{
			System.out.println("Set sontains cat");
		}
	}

}
