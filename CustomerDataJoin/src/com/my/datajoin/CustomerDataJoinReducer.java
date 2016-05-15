package com.my.datajoin;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CustomerDataJoinReducer extends Reducer<IntWritable, Text, Object, Object> {

}
