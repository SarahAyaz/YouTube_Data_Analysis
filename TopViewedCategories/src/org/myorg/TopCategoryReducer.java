package org.myorg;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TopCategoryReducer extends Reducer<Text, Text,Text, LongWritable>{
	public long max = -1;
    public void reduce(Text key, Iterable <Text> values, Context context) 
    		throws IOException, InterruptedException
    {
       max = 0;
			
       for (Text val : values)
       {
          String [] str = val.toString().split("\t");
          if(str.length > 2)
          max += Long.parseLong(str[5]);
       }
			
       context.write(new Text(key), new LongWritable(max));
    }
}
