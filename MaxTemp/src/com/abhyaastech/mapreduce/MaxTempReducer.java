package com.abhyaastech.mapreduce;

import java.io.IOException;

/*
 * @Author Abhiaas Tutorial
 */

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


/*
 * @Author AbhyaasTech
 */

public class MaxTempReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	
	//[(2007,jan), {112, 97, 100}]
	@Override
	public void reduce(Text key, Iterable<IntWritable> values,
			Context context) throws IOException, InterruptedException {

		int maxTemp = 0;

		for (IntWritable val : values) {
			
			//Get method of an IntWritable object returns an integer value
			int inputTemp = val.get();
			
			//Compare the current value with previous max
			
        	if(inputTemp > maxTemp)
        	{
        		maxTemp = inputTemp;
        	}
			
			
		}
		
		//Write to the output
		context.write(key, new IntWritable(maxTemp));
		
		//2007,jan	112
		//2008,feb	100
		
		//TODO:
		//2007,jan,112
		//2008,feb,100

	}

}