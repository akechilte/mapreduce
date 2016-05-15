package com.abhyaastech.overloading;

public class TestCalculation {

	public static void main(String[] args) {
		int intSum;
		double doubleSum;

		Calculation obj = new Calculation();

		intSum = obj.sum(20, 20);
		System.out.println("Sum of 2 int values : " + intSum);

		intSum = obj.sum(10, 10, 10);
		System.out.println("Sum of 3 int values : " + intSum);
		
		doubleSum = obj.sum(10.5,10.5); 
		System.out.println("Sum of 2 double values : " + doubleSum);

	}

}
