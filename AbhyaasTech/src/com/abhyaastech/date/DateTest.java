package com.abhyaastech.date;

import com.abhyaastech.dateconverter.SimpleConverter;

public class DateTest {

	public static void main(String[] args) {
		System.out.println("Date testing\n");
		
		String date = "2016-04-16";
		
		System.out.println(date + " converted to Date Object " + SimpleConverter.yyyymmddToDate(date));

	}

}
