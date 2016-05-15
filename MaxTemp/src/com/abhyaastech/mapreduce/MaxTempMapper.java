package com.abhyaastech.mapreduce;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;


/*
 * @Author Abhyaas Technologies
 */

public class MaxTempMapper extends
 Mapper<LongWritable, Text, Text, IntWritable>{
	
	//private Text year = new Text();
	private String year;
	private String month;
	private int temp;
	private String mapKey;
	
	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		StringBuffer sb = new StringBuffer();
		
		String line = value.toString();
		StringTokenizer tokenizer = new StringTokenizer(line, ",");

		while (tokenizer.hasMoreTokens()) {
			
			//First Token will be patent
			//2007,jan,40
			year = tokenizer.nextToken().trim(); //2007
			month = tokenizer.nextToken().trim(); //jan
			String t = tokenizer.nextToken().trim(); //112
			//String to integer
			int temp = Integer.parseInt(t);
			
			sb.append(year).append(",").append(month);
			//2007,jan
			//2012,feb
			
			//Write to Map output
			context.write(new Text(sb.toString()), new IntWritable(temp));
		}
	
	}

}
