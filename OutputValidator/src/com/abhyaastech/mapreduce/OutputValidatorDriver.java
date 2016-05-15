package com.abhyaastech.mapreduce;


import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/*
 * @Author Abhyaas Technologies
 */

public class OutputValidatorDriver extends Configured implements Tool{

	@Override
	public int run(String[] args) throws Exception {
		
		//Get configuration of current job
		Configuration conf = new Configuration();
		
		//Set output file separator by overriding configuration parameter
		conf.set("mapred.textoutputformat.separator", ",");
		
		Job job = Job.getInstance(conf);
		job.setJobName("Validate Result");
        job.setJarByClass(OutputValidatorDriver.class);
        
        job.setMapperClass(OutputValidatorMapper.class);
        job.setReducerClass(OutputValidatorReducer.class);
        
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        
        
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        
        //Let's Put the control file content in distributed cache
        String cacheFile = args[2];       
        job.addCacheFile(new URI(cacheFile));
		
        return job.waitForCompletion(true) ? 0: 1;
	}
	
	public static void main(String[] args) throws Exception {
		OutputValidatorDriver wordsizeDriver = new OutputValidatorDriver();
		int res = ToolRunner.run(wordsizeDriver, args);
		System.exit(res);
	}

}
