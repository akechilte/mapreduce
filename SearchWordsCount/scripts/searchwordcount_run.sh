#!/bin/bash

# hadoop jar <jar name> <class name with main method> <input directory name> <output directory name>
hadoop jar /home/abhyaastech/practice/jar/SearchWordsCount-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.my.mapreduce.CountKeywordsDriver /user/bebee/data/searchkeys/searchkeywords /user/bebee/output/searchcount
