# YouTube Data Analysis
It analyse YouTube data and gives most popular genres on YouTube based on views and uploads.

## Structure

1. GBvideos.csv (Dataset)

2. YouTube Data Analysis (Implementation MapReduce model to find the most popular genre on YouTube based on uploads)

3. Top Viewed Categories (Implementation MapReduce model to find the most popular genre on YouTube based on views)

4. Top Categories Output (Output files)

## Reading Output file

The output is obtained by creating a ```.jar``` file using the following lines of code on Linux terminal

### Steps
1. Make an input directory in Hadoop filesystem: 
```bash
hdfs dfs -mkdir /YouTubeInput
```

2. Put input data from Linux filesystem to Hadoop DFS: 
  ```bash
  hdfs dfs -put /Downloads/YouTubeDataAnalysis/GBvideos.csv /YouTubeInput
  ```

3. Create and execute a jar file and save results in ouptut directory in hdfs: 
  ```bash 
  hadoop jar /home/hadoop/TopViewedCategories.jar TopCategoryDriver /YouTubeInput /YouTubeOutput
  ```

4. To view results: 
  ```bash 
  hdfs dfs -cat /YouTubeOutput/*
  ```

5. Get results from Hadoop DFS to Linux filesystem:
  ```bash 
  hdfs dfs -get /YouTubeOutput/* /Downloads/YouTubeAnalysis/TopCategoryOutput
  ```
