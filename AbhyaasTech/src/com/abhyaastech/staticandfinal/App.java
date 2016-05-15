package com.abhyaastech.staticandfinal;

public class App {

	public static void main(String[] args) {
		
		Thing.setDescription("I am a thing");
		
		System.out.println(Thing.getDescription());
		
		System.out.println("Count before creating object : " +Thing.count);
		
		Thing thing1 = new Thing();
		Thing thing2 = new Thing();
		
		System.out.println("Count after creating object : " +Thing.count);
			
		thing1.setName("Optimus Prime");
		thing2.setName("Bumblebee");
		
		thing1.showName();
		thing2.showName();
		
		System.out.println(Math.PI);

		System.out.println(Thing.LUCKY_NUMBER);
	}

}
