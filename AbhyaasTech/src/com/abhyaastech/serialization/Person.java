package com.abhyaastech.serialization;

import java.io.Serializable;
 
public class Person implements Serializable {
//public class Person {
     
    /**
	 * 
	 */
	//private static final long serialVersionUID = -3312167737043756485L;
	//private static final long serialVersionUID = 4801633306273802062L;
     
    private int id;
    private String name;
     
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
 
    @Override
    public String toString() {
    	
    	System.out.println("I am the overrided toString() method for Person");
        return "Person [id=" + id + ", name=" + name + "]";
    }
}