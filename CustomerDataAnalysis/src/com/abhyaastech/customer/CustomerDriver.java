package com.abhyaastech.customer;


import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.filecache.DistributedCache;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.abhyaastech.customer.CustomerMapper.DemoMapper;
import com.abhyaastech.customer.CustomerMapper.SalesMapper;

/*
 * @Author Abhyaas Technologies
 */

public class CustomerDriver extends Configured implements Tool{

	@Override
	public int run(String[] args) throws Exception {
		
		//Get configuration of current job
		Configuration conf = new Configuration();
		
		Job job = Job.getInstance(conf);
		job.setJobName("Customer Data Anaylysis");
        job.setJarByClass(CustomerDriver.class);
        
        job.setReducerClass(CustomerReducer.class);
        
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        
        MultipleInputs.addInputPath(job, new Path(args[0]), 
                TextInputFormat.class, DemoMapper.class);
        
        MultipleInputs.addInputPath(job, new Path(args[1]), 
                TextInputFormat.class, SalesMapper.class);
        
        //Let's Put the control file content in distributed cache
        String cacheFile = args[2];       
        job.addCacheFile(new URI(cacheFile));
        
        FileOutputFormat.setOutputPath(job, new Path(args[3]));
		
        return job.waitForCompletion(true) ? 0: 1;
	}
	
	public static void main(String[] args) throws Exception {
		CustomerDriver customerDriver = new CustomerDriver();
		int res = ToolRunner.run(customerDriver, args);
		System.exit(res);
	}

}
