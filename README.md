# YouTube-Data-Analysis
Analysis of YouTube Data using Hadoop Mapreduce framework in Java.

Repository contains 4 folders:

Dataset- YouTube dataset is a csv file downloaded from Kaggle.

YouTube Data Analysis- is the java implementation of mapper, reducer and combiner
for total number of videos uploaded in each genre on YouTube based on the dataset.

Top Viewed Categories- is the java implementation of mapper, reducer and partitioner
for finding the top categories of videos on YouTube.

Top Categories Output- folder contain all the output files of Top Viewed Categories.
One output file for each partition.

The output is obtained by creating a .jar file using the following lines of code on Linux terminal

Step #1 Make an input directory in Hadoop filesystem: 
hdfs dfs -mkdir /YouTubeInput

Step #2 Put input data from Linux filesystem to Hadoop DFS: 
hdfs dfs -put /Downloads/YouTubeDataAnalysis/GBvideos.csv /YouTubeInput

Step #3 Create and execute a jar file and save results in ouptut directory in hdfs: 
hadoop jar /home/hadoop/TopViewedCategories.jar TopCategoryDriver /YouTubeInput /YouTubeOutput

Step #4 View results: hdfs dfs -cat /YouTubeOutput/*

Step #5: Get results from Hadoop DFS to Linux filesystem:
hdfs dfs -get /YouTubeOutput/* /Downloads/YouTubeAnalysis/TopCategoryOutput
