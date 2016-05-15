package com.abhyaastech.polymorphism;

public class App {
 
    public static void main(String[] args) {
         
        // Tree is a kind of Plant (it extends Plant)
        Tree tree = new Tree();
        
        tree.grow();
        
        //Plant is parent class
        //Tree is child class
        //a parent class reference is used to refer to a child class object
        Plant plant2 = new Tree();
        
         
        // plant2 references a Tree, so the Tree grow() method is called.
        plant2.grow();
        
        //Will not work, because parent class does not have this method.
        //plant2.shedLeaves();
        
        //this will work
        tree.shedLeaves();        
    }
    
 
}