package org.myorg;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class YouTubeDataReducer extends Reducer<Text, LongWritable,Text, LongWritable>{
	private LongWritable percentView = new LongWritable();
	public void reduce(Text key, Iterable<LongWritable> values,Context context )
			throws IOException, InterruptedException {
        long sum = 0;
        String str[]=key.toString().split("\t");
        sum = Long.parseLong(str[1]);
        for (LongWritable val : values) {
            percentView.set((val.get()/sum)*100);
        }
        context.write(key, percentView);
	}
}
