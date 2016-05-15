package test.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * ArrayLists manage arrays internally
		 * [0][1][2][3]...
		 */
		
		List<Integer> arrayList = new ArrayList<Integer>();
		
		/*
		 * LisnkedLists consists of elements where each element has a reference to previous and next element
		 * [0]->[1]->[2]->[3]
		 *    <-   <-   <-
		 */
		
		List<Integer> linkedList = new LinkedList<Integer>();

		doTimings("ArrayList", arrayList);
		doTimings("LinkedList", linkedList);
	}
	
	//Let's define a method - look at 2nd argument You can pass anything that implements List interface to this method.	
	private static void doTimings(String type, List<Integer> list){
		
		//Let's populate the list with 100k elements
		for(int i=0; i<1E5; i++) {
			list.add(i);
		}
		
		long start = System.currentTimeMillis();
		
//		//Add items to the end of list
//		for(int i=0; i<1E5; i++) {
//			list.add(i);
//		}
		
		//Add items to the beginning of list
		for(int i=0; i<2E5; i++) {
			list.add(0, i);
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken: " + (end - start) + "ms for " + type);
		
	}

}
