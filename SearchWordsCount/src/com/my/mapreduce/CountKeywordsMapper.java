package com.my.mapreduce;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

/**
 * Mapper <InputKey, Inputvalue, Outputkey, OutputValue>
 * 
 */

public class CountKeywordsMapper extends
		Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		String line = value.toString();

		// OR, Portland, abhyaas hadoop technology
		String[] result = line.split(",");
			String state = result[0]; // OR
			String city = result[1]; // Portland
			String words = result[2]; // abhyaas hadoop technology

			StringTokenizer token = new StringTokenizer(words); // default delimeter " "

			// abhyaas hadoop technology
			while (token.hasMoreTokens()) {
				String temp = token.nextToken();

				// Write to Map output
				context.write(new Text(city + "," + temp), new IntWritable(1));
				
		}
	}

}
