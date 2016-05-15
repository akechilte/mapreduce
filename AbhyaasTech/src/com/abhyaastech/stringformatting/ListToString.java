package com.abhyaastech.stringformatting;

import java.util.ArrayList;
import java.util.List;

public class ListToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> arrayList = new ArrayList<String>();

		arrayList.add("One");
		arrayList.add("two");
		arrayList.add("three");

		listToString(arrayList, ",");

		List<String> arrayList2 = new ArrayList<String>();

		arrayList2.add("Ram");
		arrayList2.add("Sam");
		arrayList2.add("Hari");

		listToString(arrayList2, "#");
		
		

	}

	public static String listToString(List<String> inputList,
			String rowSeperator) {
		


		StringBuilder sb = new StringBuilder();

		for (String element : inputList) {

			sb.append(element).append(rowSeperator);

			System.out.println("sb output :" + sb.toString());

		}

		System.out.println("Final String :"
				+ sb.toString().substring(0, sb.length() - 1));

		return sb.toString().substring(0, sb.length() - 1);
	}

}
