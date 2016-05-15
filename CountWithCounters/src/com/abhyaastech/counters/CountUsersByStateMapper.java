package com.abhyaastech.counters;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/*
 * @Author AbhyaasTech
 */

public class CountUsersByStateMapper extends Mapper<Object, Text, NullWritable, NullWritable> {

	public static final String STATE_COUNTER_GROUP = "State";
	public static final String DEBUG = "Debug";

	private String[] statesArray = new String[] { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI",
			"ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH",
			"NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SF", "TN", "TX", "UT", "VT", "VA", "WA",
			"WV", "WI", "WY" };

	private HashSet<String> states = new HashSet<String>(Arrays.asList(statesArray));

	@Override
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

		// Parse the input into a nice map.
		Map<String, String> parsed = com.abhyaastech.commonutils.MRDPUtils.transformXmlToMap(value.toString());

		// Get the value for the Location attribute
		String location = parsed.get("Location");

		// Look for a state abbreviation code if the location is not null or
		// empty
		if (location != null && !location.isEmpty()) {
			boolean unknown = true;
			// Make location uppercase and split on white space
			String[] tokens = location.toUpperCase().split("\\s");
			// For each token
			for (String state : tokens) {
				// Check if it is a state
				if (states.contains(state)) {

					// If so, increment the state's counter by 1 and flag it
					// as not unknown
					context.getCounter(STATE_COUNTER_GROUP, state).increment(1);
					unknown = false;
					break;
				}
			}

			// If the state is unknown, increment the counter
			if (unknown) {
				context.getCounter(DEBUG, "Unknown").increment(1);
			}
		} else {
			// If it is empty or null, increment the counter by 1
			context.getCounter(DEBUG, "NullOrEmpty").increment(1);
		}
	}
}
