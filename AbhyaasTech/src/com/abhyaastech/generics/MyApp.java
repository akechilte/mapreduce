package com.abhyaastech.generics;
import java.util.ArrayList;
import java.util.HashMap;
 
class Animal {
     
}
 
 
public class MyApp {
 
    public static void main(String[] args) {

         
        ArrayList<String> stringList = new ArrayList<String>();
         
        stringList.add("lion");
        stringList.add("tiger");
        stringList.add("leopard");
         
        String animal = stringList.get(1);
         
        System.out.println(animal);
        
        ArrayList<Integer> intList = new ArrayList<Integer>();
        
        /**
         * TODO
         */
        //What is the diff between Integer and int?
        
        intList.add(10);
        intList.add(20);
        intList.add(30);
        
        System.out.println("Integer List : " +intList.toString());
        
    }
 
}