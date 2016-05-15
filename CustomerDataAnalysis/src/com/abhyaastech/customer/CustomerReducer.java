package com.abhyaastech.customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

/*
 * @Author Abhyaas Technologies
 */

public class CustomerReducer extends Reducer<Text, Text, Text, NullWritable> {

	private Map<String, String> segCdMap = new HashMap<>();
	private Path[] lookupFile = new Path[1];
	
	/**
	 * Read the file from distributed cache and put the content in the map
	 */

	@Override
	protected void setup(Context context) throws IOException,
			InterruptedException {	

		// Get the files from distributed cache
		lookupFile = context.getLocalCacheFiles();
		String ctlFileName = lookupFile[0].toString();
		readFile(ctlFileName);

		System.out.println("Lookup File Name : " + ctlFileName);

	}

	// Method to read a file
	protected void readFile(String fileName) throws IOException {

		BufferedReader br = null;
		String line = "";

		br = new BufferedReader(new FileReader(fileName));
		while ((line = br.readLine()) != null) {
			
			System.out.println("line : " +line.toString());
			
			StringTokenizer tokenizer = new StringTokenizer(line.toString(), "|");
			
			while (tokenizer.hasMoreTokens()) {
				segCdMap.put(tokenizer.nextToken(), tokenizer.nextToken());
				
				//01, Auto
				//02|Gambling
			}
		}

		br.close();
		
		System.out.println("Size of Map : " +segCdMap.size());
	}

	/**
	{123}
	{D|AZ|86309}
	
	{123}
	{S|2015|8000.0}
	
	
	hadoop, (1,1,1)
	[123,(D|AZ|86309), (S|2015|8000.0|01)]
	
	{234}
	{D|AZ|83456}
	
	[234,(D|AZ|83456)]
	
	
	*/
	
	@Override
	public void reduce(Text key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {

		String custId = "";
		String stateCd = "";
		String zipcode = "";
		String year = "";
		String mon = "";
		String amount = "";
		String segCd = "";
		String segDescription = "";
		String fileTag;

		custId = key.toString();

		for (Text value : values) {
			String valueStr = value.toString();
			
			StringTokenizer tokenizer = new StringTokenizer(valueStr, "|");
			
			while (tokenizer.hasMoreTokens()) {
				fileTag = tokenizer.nextToken();
				
				if (fileTag.equals("D")) {
					stateCd = tokenizer.nextToken();
					zipcode = tokenizer.nextToken();
				} else if (fileTag.equals("S")) {
					year = tokenizer.nextToken();;
					mon = tokenizer.nextToken();
					amount = tokenizer.nextToken();
					segCd = tokenizer.nextToken();
					segDescription = segCdMap.get(segCd);
				}
				
			}

		}

		StringBuffer sb = new StringBuffer();
		sb.append(custId).append("|").append(stateCd).append("|")
				.append(zipcode).append("|").append(year).append("|")
				.append(mon).append("|").append(amount).append("|")
				.append(segDescription);
		
		/**
		 * Writing entire line as key. It's not mandatory to have values always.
		 * This is an example of NullWritable.
		 */
		context.write(new Text(sb.toString()), NullWritable.get());

	}

}