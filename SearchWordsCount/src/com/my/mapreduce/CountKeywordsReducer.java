package com.my.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CountKeywordsReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	int count = 0;
	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		
		count = 0;
		//[(Portland, abhyaas),{1, 1, 1}]
		//Portland, hadoop
		//Portland, technology

		for(IntWritable val : values){
			
			//count += val.get();
			count = ++count;
			//count = count++; // does not work
			
		}
		
		System.out.println("count : " +count);
		
		String[] result = key.toString().split(",");
		String city = result[0]; // Portland
		String word = result[1]; // abhyaas
		System.out.println("City:" +city +"searching the word:"+word +count +"times" );
		context.write(key, new IntWritable(count));
		
		
	}

	
	
	
	

}
