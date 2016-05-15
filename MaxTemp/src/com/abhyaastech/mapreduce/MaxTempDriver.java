package com.abhyaastech.mapreduce;


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


public class MaxTempDriver extends Configured implements Tool{

	@Override
	public int run(String[] args) throws Exception {
		
		Job job = Job.getInstance(getConf());
		job.setJobName("Find Maximun Temperature of Year");
        job.setJarByClass(MaxTempDriver.class);
        
        job.setMapperClass(MaxTempMapper.class);
        job.setReducerClass(MaxTempReducer.class);
        
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        
		
        return job.waitForCompletion(true) ? 0: 1;
	}
	
	public static void main(String[] args) throws Exception {
		MaxTempDriver maxTempDriver = new MaxTempDriver();
		int res = ToolRunner.run(maxTempDriver, args);
		System.exit(res);
	}

}
