package com.abhyaastech.serialization;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
 
 
 
public class ReadObjects {
 
     
    public static void main(String[] args) {
    	
        System.out.println("Reading objects...");
 
        try(FileInputStream fi = new FileInputStream("people.dat")) {
             
            ObjectInputStream os = new ObjectInputStream(fi);
             
//            Person person1 = (Person)os.readObject();
//            Person person2 = (Person)os.readObject();
            
            
            Person person;
            
            while((person = (Person)os.readObject()) != null) {
            	System.out.println(person);
            }
             
            os.close();
             
            
//            System.out.println(person2);
             
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("End of File");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }
 
}