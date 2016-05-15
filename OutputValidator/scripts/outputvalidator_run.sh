#!/bin/bash

#Create hdfs directory
#hdfs dfs -mkdir /data/apple
#hdfs dfs -mkdir /data/orange
#hdfs dfs -mkdir /data/ctl_file

#hdfs dfs -mkdir /data/paltforminputs

if $(hadoop fs -test -d /output/outputvalidator); then
    echo "exists"
    hadoop fs -rm -r /output/outputvalidator
else
    echo "not exists"
fi

#Copy data from local to hdfs
cd /home/abhyaastech/hdpbatch_apr16/data/outputvalidator
hadoop fs -put apple_output.dat /data/paltforminputs
hadoop fs -put orange_output.dat /data/paltforminputs
hadoop fs -put ctl_file.dat /data/ctl_file

#Execute hadoop job
hadoop jar /home/abhyaastech/hdpbatch_apr16/jar/OutputValidator.jar /data/paltforminputs /output/outputvalidator /data/ctl_file/ctl_file.dat
