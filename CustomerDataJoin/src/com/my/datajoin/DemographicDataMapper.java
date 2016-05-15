package com.my.datajoin;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * Mapper <InputKey, Inputvalue, Outputkey, OutputValue>
 * Mapper <LongWritable, Text, Text, IntWritable>
 * LongWritable - Similar as long in Java
 * IntWritable - Similar as int in Java
 * Text - Similar as String in Java
 */

public class DemographicDataMapper extends Mapper<LongWritable, Text, IntWritable, Text> {

	@Override
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException{
		
		String line = value.toString();
		String label = "D";
		String[] result = line.split("|");
		String userid = result[0];
		String state = result[1];
		String zipcode = result[2];
		String outputValue = label + "|" + state + "|" + zipcode;
		
		context.write(new IntWritable(Integer.parseInt(userid)), new Text(outputValue));
		
	}
	

}
