package com.abhyaastech.stringformatting;

public class App {

	public static void main(String[] args) {
		
		String info = "";
		
		info += "My name is Bob";		
		info += " ";
		info += "I am a builder";
		
		System.out.println(info);
		
		//More efficient
		
		StringBuilder sb = new StringBuilder("");
		
		sb.append("My name is Sue");
		sb.append(" ");
		sb.append("I am a lion tamer");
		
		System.out.println(sb.toString());
		
		StringBuilder s = new StringBuilder();
		
		
		//////Method chaining//////////
		
		s.append("I am Rocky")
		.append(".")
		.append("I am a Java developer");
		
		System.out.println(s.toString());
		
		/////Formatting//////
		
		System.out.println("Here is some text.\tThat was a tab.\n That was a new line");
		System.out.println(" More text");
		
		System.out.printf("Total cost %-10d", 50);
		
		for (int i = 0; i < 5; i++) {
			System.out.printf("%-2d: %s\n",i, "here is some text");
		}
		
		//////Formatting floating point value
		
		System.out.printf("Total value: %.2f\n", 3.64323);
		System.out.printf("Total value: %-6.2f\n", 363.64323);
		
	}

}
