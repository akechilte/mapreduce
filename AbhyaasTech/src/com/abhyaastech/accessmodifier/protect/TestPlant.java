package com.abhyaastech.accessmodifier.protect;
import com.abhyaastech.accessmodifier.protect.Plant;
 
/*
 * private --- only within same class
 * public --- from anywhere
 * protected -- same class, subclass, and same package
 * no modifier -- same package only
 */
 
public class TestPlant {
 

    public static void main(String[] args) {
        Plant plant = new Plant();
         
        System.out.println("I am " + plant.name + " plant\n");
         
        // size is protected
        // Will work as Plant is in same package
        System.out.println("I am " +plant.size + " size");
 
    }
 
}