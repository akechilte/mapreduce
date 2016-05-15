package com.abhyaastech.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
 
 
 
public class WriteObjects {
 
    public static void main(String[] args) {
    	
        System.out.println("Writing objects...");
 
        Person ironMan = new Person(543, "Iron Man");
        Person spiderMan = new Person(123, "Spider Man");
         
        System.out.println(ironMan);
        System.out.println(spiderMan);
         
        try(FileOutputStream fs = new FileOutputStream("people.dat")) {
             
            ObjectOutputStream os = new ObjectOutputStream(fs);
             
            os.writeObject(ironMan);
            os.writeObject(spiderMan);
             
            os.close();
             
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     
    }
 
}