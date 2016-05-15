package com.abhyaastech.misc;

public class TwoMaxNumbers {

	public void printTwoMaxNumbers(int[] nums) {
		int maxOne = 0;
		int maxTwo = 0;
		for (int n : nums) {
			if (maxOne < n) {
				maxTwo = maxOne;
				maxOne = n;
			} else if (maxTwo < n) {
				maxTwo = n;
			}
		}
		System.out.println("First Max Number: " + maxOne);
		System.out.println("Second Max Number: " + maxTwo);
	}

	public static void main(String a[]) {
		int num[] = { 14, 34, 84, 2, 55, 1, 106, 23 };
		TwoMaxNumbers tmn = new TwoMaxNumbers();
		tmn.printTwoMaxNumbers(num);
	}
}
