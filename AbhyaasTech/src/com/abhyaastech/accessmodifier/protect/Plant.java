package com.abhyaastech.accessmodifier.protect;
 
class Something {
     
}
 
public class Plant {

    public String name;
    
    public final static int ID = 8;
     
    private String type;
     
    protected String size;
     
    int height;
     
    public Plant() {
        this.name = "Mango";
        this.type = "plant";
        this.size = "medium";
        this.height = 8;
    }
}