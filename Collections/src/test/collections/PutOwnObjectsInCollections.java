package test.collections;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

//Let's define own class. We will create object of this class and enter into our collection
class Person {
	private int id;
	private String name;
	
	//let's give it a constructor
	public Person(int id, String name){
		this.id = id;
		this.name= name;
	}
	
	//let's give it a method
	
	public String toString(){
		return "{ID is : " + id + "; Name is : " + name +"}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}

public class PutOwnObjectsInCollections {

	public static void main(String[] args) {
		
		//Going to create 4 person objects
		
		Person p1 = new Person(0, "Bob");
		Person p2 = new Person(1, "Sue");
		Person p3 = new Person(2, "Mike");
		Person p4 = new Person(1, "Sue");
		
		//Map or Set cant tell sue in p2 and p4 are same. Set or Map can't go inside your object and tell that they have same ID and name.
		//Set or Map are not goin to go into your objects and examine the content of it
		//How to avoind it????
		//If you want to use your own object as key of the map or input of the set (which is little unusual), you should use 
		//hashCode() and equals() methods.
		//You can do that by Eclipse
		
		Map<Person, Integer> map = new LinkedHashMap<Person, Integer>();
		
		map.put(p1, 1);
		map.put(p2, 2);
		map.put(p3, 3);
		map.put(p4, 1);
		
		for (Person key : map.keySet()) {
			System.out.println(key + ":" +map.get(key));
		}

		Set<Person> set = new LinkedHashSet<Person>();
		
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
		
		for (Person element : set) {
			System.out.println(element);
		}

	}

}
