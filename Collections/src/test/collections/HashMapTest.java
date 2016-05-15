package test.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//HashMap does not maintain the order of the entries entered
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(5, "Five");
		map.put(8, "Eight");
		map.put(6, "Six");
		map.put(4, "Four");
		map.put(2, "Two");
		
		String text = map.get(6);
		
		System.out.println(text);
		
		//Iterating over HashMap
		
		for(Map.Entry<Integer, String> entry: map.entrySet()) {
			
			int key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println(key + ":" +value);
		}

	}

}
