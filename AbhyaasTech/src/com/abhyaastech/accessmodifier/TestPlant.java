package com.abhyaastech.accessmodifier;
import com.abhyaastech.accessmodifier.protect.Plant;
 
/*
 * private --- only within same class
 * public --- from anywhere
 * protected -- same class, subclass, and same package
 * no modifier -- same package only
 */
 
public class TestPlant {
 

    public static void main(String[] args) {
        Plant bananaPlat = new Plant();
         
        System.out.println(bananaPlat.name);
         
        System.out.println(bananaPlat.ID);

         
        // size is protected; App is not in the same package as Plant.
        // Won't work
        //System.out.println(bananaPlat.size);
 
    }
 
}