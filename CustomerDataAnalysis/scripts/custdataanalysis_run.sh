#!/bin/bash

hadoop jar /home/abhyaastech/hdpbatch_apr16/jar/CustomerDataAnalysis-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.abhyaastech.customer.CustomerDriver /data/custdemo /data/custsales /data/segment_lookup/segment_lookup.dat /output/custanalysis
