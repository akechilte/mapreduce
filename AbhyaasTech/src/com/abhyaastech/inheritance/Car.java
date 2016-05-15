package com.abhyaastech.inheritance;

public class Car extends Machine{
	

	
	@Override
	public void start() {
		System.out.println("Car Started (method override)");
	}

	public void wipeWindShield(){
		System.out.println("Wipe Wind Shield");
	}

}
