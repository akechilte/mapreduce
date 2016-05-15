package com.abhyaastech.customer;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/*
 * @Author Abhyaas Technologies
 */

public class CustomerMapper {

	public static class DemoMapper extends
			Mapper<LongWritable, Text, Text, Text> {

		private String custId;
		private String stateCd;
		private String zipcode;
		private String fileTag = "D";

		@Override
		public void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {

			String line = value.toString();

			StringTokenizer tokenizer = new StringTokenizer(line, "|");

			while (tokenizer.hasMoreTokens()) {

				custId = tokenizer.nextToken();
				stateCd = tokenizer.nextToken();
				zipcode = tokenizer.nextToken();
			}

			StringBuffer sb = new StringBuffer();
			sb.append(fileTag).append("|").append(stateCd).append("|")
					.append(zipcode);

			context.write(new Text(custId), new Text(sb.toString()));
		}
	}

	public static class SalesMapper extends
			Mapper<LongWritable, Text, Text, Text> {

		private String custId;
		private String year;
		private String mon;
		private String amount;
		private String segCd;

		private String fileTag = "S";

		@Override
		public void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {

			String line = value.toString();

			StringTokenizer tokenizer = new StringTokenizer(line, "|");

			while (tokenizer.hasMoreTokens()) {

				custId = tokenizer.nextToken();
				year = tokenizer.nextToken();
				mon = tokenizer.nextToken();
				amount = tokenizer.nextToken();
				segCd = tokenizer.nextToken();
			}

			StringBuffer sb = new StringBuffer();
			sb.append(fileTag).append("|").append(year).append("|").append(mon)
					.append("|").append(amount).append("|").append(segCd);

			context.write(new Text(custId), new Text(sb.toString()));
		}
	}
}
