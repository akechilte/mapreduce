package com.abhyaastech.mapreduce;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/*
 * @Author Abhiaas Tutorial
 */

public class OutputValidatorReducer extends Reducer<Text, Text, Text, Text> {

	private String appleDataStr = null;
	private String orangeDataStr = null;
	private String[] appleArray = null;
	private String[] orangeArray = null;
	private boolean appleData = false;
	private boolean orangeData = false;
	private boolean diff = false;
	private boolean missing = false;
	private int count = 0;
	String missingOutput = "";
	
	/*
	 * key   : 123
	 * Value : {APPLE~AZ~85032~2015~Jan~800.00, ORANGE~AZ~85032~2015~Jan~800.00}
	 */

	@Override
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

		appleDataStr = null;
		orangeDataStr = null;
		appleArray = null;
		orangeArray = null;
		appleData = false;
		orangeData = false;
		diff = false;
		missing = false;
		count = 0;
		missingOutput = "";

		for (Text tmp : values) {

			String val = tmp.toString();
			System.out.println("Reduce Key : " +key);
			System.out.println("Reduce Value : " +val);
			
			if (val.startsWith("APPLE")) {
				appleDataStr = val;
				appleArray = val.split("~");
				appleData = true;
				count = count + 1;
			} else if (val.startsWith("ORANGE")) {
				orangeDataStr = val;
				orangeArray = val.split("~");
				orangeData = true;
				count = count + 1;
			} 
		}

		if (count == 2 && appleData && orangeData && (appleArray != null && appleArray.length == 6)
				&& (orangeArray != null && orangeArray.length == 6)) {
			
			for (int i = 1; i <= appleArray.length - 1; i++) {

				if (!appleArray[i].equalsIgnoreCase(orangeArray[i])) {
					diff = true;
				}
				
				if (diff) {
					break;
				}
			}

		} else if(count == 1 && appleData) {	
			missing = true;
			missingOutput = appleDataStr;
			
		} else if(count == 1 && orangeData) {	
			missing = true;
			missingOutput = orangeDataStr;			
		}
		
		/*
		* If there is any difference in records for apple and orange platform,
		* write both records into output file so that you can analyze it later
		*/
		
		if(diff)
		{
			context.write(new Text(key.toString().trim()), new Text(appleDataStr));
			context.write(new Text(key.toString().trim()), new Text(orangeDataStr));
		} else if(missing) {
			context.write(new Text(key.toString().trim()), new Text(missingOutput));	
		}

	}

}