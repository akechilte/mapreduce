package com.abhyaastech.mapreduce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.StringTokenizer;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.filecache.DistributedCache;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

/*
 * @Author Abhiaas Tutorial
 */

public class OutputValidatorMapper extends Mapper<LongWritable, Text, Text, Text> {

	private String fileName = new String();
	private Path[] ctlFile = new Path[1];
	private String inputDelim = "";

	private String custId = "";
	private String custLoc = "";
	private String custZip = "";
	private String spendYear = "";
	private String spendMon = "";
	private String spendAmt = "";

	@Override
	protected void setup(Context context) throws IOException, InterruptedException {

		// Extract the input file name based on the split the map has received
		FileSplit fileSplit = (FileSplit) context.getInputSplit();
		fileName = fileSplit.getPath().getName();

		// It's recommended not to put print statement when you are running job
		// in production mode
		System.out.println("Directory name : " + fileSplit.getPath().toString());
		System.out.println("File name : " + fileName);

		//Get the files from distributed cache 
		ctlFile = context.getLocalCacheFiles();
		String ctlFileName = ctlFile[0].toString();
		inputDelim = readFile(ctlFileName);
		
		System.out.println("Input File Delimiter : " +inputDelim);

	}

	//Method to read a file
	protected String readFile(String fileName) throws IOException {

		BufferedReader br = null;
		String line = "";
		String delim = "";

		br = new BufferedReader(new FileReader(fileName));
		while ((line = br.readLine()) != null) {
			delim = line.toString().trim();
		}

		br.close();

		return delim;
	}

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		StringBuffer sb = new StringBuffer();

		String line = value.toString();
		StringTokenizer tokenizer = new StringTokenizer(line, inputDelim);

		while (tokenizer.hasMoreTokens()) {

			custId = tokenizer.nextToken();
			custLoc = tokenizer.nextToken();
			custZip = tokenizer.nextToken();
			spendYear = tokenizer.nextToken();
			spendMon = tokenizer.nextToken();
			spendAmt = tokenizer.nextToken();
		}

		if (fileName.contains("apple")) {
			sb.append("APPLE~");
		} else if (fileName.contains("orange")) {
			sb.append("ORANGE~");
		}

		sb.append(custLoc).append("~").append(custZip).append("~").append(spendYear).append("~").append(spendMon)
				.append("~").append(spendAmt);

		/*
		 * ONLY FOR TESTING WITH LOW VOLUME DATA. DO NOT USE IT IN PRODUCTION
		 */
		System.out.println("Cust ID : " + custId);
		System.out.println("Value : " + sb.toString());
		
		
		/*
		 * Key   : 123
		 * Value : APPLE~AZ~85032~2015~Jan~800.00
		 */

		context.write(new Text(custId), new Text(sb.toString()));
	}

}
