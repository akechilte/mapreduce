package test.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortedMapsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer, String> hashMap = new HashMap<Integer, String>();		
		Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
		Map<Integer, String> treeMap = new TreeMap<Integer, String>();
		
		//No guaranteed order on HashMap
		testMap("hashMap", hashMap);
		
		//Maintains the order of the elements the way they are entered
		testMap("linkedHashMap", linkedHashMap);
		
		//Sort the keys in their natural order
		testMap("treeMap", treeMap);

	}
	
	//You can pass all these Maps using Map interface as they all implement Map interface
	public static void testMap(String type, Map<Integer, String> map) {
		
		map.put(9, "fox");
		map.put(4, "cat");
		map.put(8, "dog");
		map.put(1, "giraffe");
		map.put(0, "swan");
		map.put(15, "bear");
		map.put(6, "snake");
		
		System.out.println("\nType of Map : " +type);
		
		//Iterate over set. map.keySet() actually returns a collection called set.
		for(Integer key: map.keySet()) {
			String value = map.get(key);
			System.out.println(key + ":" +value);
		}
		
		
		//Another way of iterating over Map
		System.out.println("\nType of Map : " +type);
		
		for(Map.Entry<Integer, String> entry: map.entrySet()) {			
			
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + ":" +value);
		}
		
	}

}
