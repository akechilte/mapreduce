package com.abhyaastech.abstractexample;

public class App {
 
    public static void main(String[] args) {
    	
    	System.out.println("\nLet's create one object \n");
        Camera cam1 = new Camera();
        cam1.setId(5);
        
        cam1.run();
        
        System.out.println("\nLet's call each methods separately \n");
        cam1.doStuff();
        cam1.start();
        
        System.out.println("\nLet's create another object \n");
         
        Car car1 = new Car();
        car1.setId(4);
         
        car1.run();

    }
 
}