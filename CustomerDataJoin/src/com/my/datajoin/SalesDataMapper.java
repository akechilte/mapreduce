package com.my.datajoin;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SalesDataMapper extends Mapper<LongWritable , Text, IntWritable, Text> {

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		String line = value.toString();
		String label = "S";
		String[] result = line.split("|");
		String userid = result[0];
		String year = result[1];
		String month = result[2];
		String amount = result[3];
		String code = result[4];
		String outputValue = label + "|" + year + "|" + month + "|" + amount + "|" + code;
		context.write(new IntWritable(Integer.parseInt(userid)), new Text(outputValue));
	}
	
	

}
