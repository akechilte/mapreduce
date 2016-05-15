package com.abhyaastech.interfaces;

public class Machine implements Info {

	private int id = 7;
	
	public void start() {
		System.out.println("\nMachine has started");
	}

	@Override
	public void showInfo() {
		System.out.println("\nMachine ID is : " +id);
		
	}
	

	

}
