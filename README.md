# YouTube Data Analysis
It is the java implementation of mapper, reducer and combiner for total number of videos uploaded in each genre on YouTube based on the dataset. It analysis YouTube Data using Hadoop Mapreduce framework in Java.

## Structure

1. GBVideos
YouTube dataset for Great BRitain is a csv file downloaded from Kaggle.

2. YouTube Data Analysis


3. Top Viewed Categories 
Java implementation of mapper, reducer and partitioner for finding the top categories of videos on YouTube.

4. Top Categories Output
Folder contain all the output files of Top Viewed Categories.

## Reading Output file

One output file for each partition. The output is obtained by creating a .jar file using the following lines of code on Linux terminal

### Steps
1. Make an input directory in Hadoop filesystem: 
  `hdfs dfs -mkdir /YouTubeInput`

2. Put input data from Linux filesystem to Hadoop DFS: 
  `hdfs dfs -put /Downloads/YouTubeDataAnalysis/GBvideos.csv /YouTubeInput`

3. Create and execute a jar file and save results in ouptut directory in hdfs: 
  `hadoop jar /home/hadoop/TopViewedCategories.jar TopCategoryDriver /YouTubeInput /YouTubeOutput`

4. To view results: 
  `hdfs dfs -cat /YouTubeOutput/*`

5. Get results from Hadoop DFS to Linux filesystem:
  `hdfs dfs -get /YouTubeOutput/* /Downloads/YouTubeAnalysis/TopCategoryOutput`
