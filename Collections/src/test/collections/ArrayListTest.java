package test.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//List interface...This says - values variable can point to anything which implements List interface. Going to point to an
		// object specifically of type ArrayList.
		// List is an interface, it's not a class. So you cant create a new List. You can only create a new Arraylist or LinkedList etc
		
 		List<Integer> numbers = new ArrayList<Integer>();
 		
 		//adding elements to ArrayList 		
 		numbers.add(10);
 		numbers.add(100);
 		numbers.add(40);
 		
 		//Retrieving  		
 		System.out.println(numbers.get(0));
 		
 		System.out.println("\n Iteration #1: ");
 		
 		//Indexed for loop iteration
 		
 		for(int i=0; i<numbers.size(); i++) {
 			System.out.println(numbers.get(i));
 		}
 		
 		//Remove item (careful)
 		numbers.remove(numbers.size() -1);
 		
 		//This is VERY slow
 		numbers.remove(0);
 		
 		System.out.println("\n Iteration #2: ");
 		
 		for(Integer value: numbers) {
 			System.out.println(value);
 		} 		
 		
	}

}
