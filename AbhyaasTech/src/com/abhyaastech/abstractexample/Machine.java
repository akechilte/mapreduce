package com.abhyaastech.abstractexample;

public abstract class Machine {
    private int id;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
     
    public abstract void start();
    public abstract void doStuff();
    public abstract void shutdown();
     
    public void run() {
    	System.out.println("Run method of object id = " +this.id);
        start();
        doStuff();
        shutdown();
    }
}