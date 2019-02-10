package org.myorg;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class YouTubeDataCombiner extends Reducer<Text, LongWritable,Text, LongWritable>{
	private Text category = new Text();
	public void reduce(Text key, Iterable<LongWritable> values,Context context )
			throws IOException, InterruptedException {
        long sum = 0;
        int count = 0;
        for (LongWritable val : values) {
            sum += val.get();
            count += 1;
        }
        category.set(key+"	"+Integer.toString(count));
        context.write(category, new LongWritable(sum));
	}
}
