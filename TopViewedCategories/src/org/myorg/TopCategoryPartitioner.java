package org.myorg;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class TopCategoryPartitioner extends Partitioner < Text, Text >{

	@Override
	public int getPartition(Text key, Text value, int numReduceTasks) {
		// TODO Auto-generated method stub
		String[] str = value.toString().split("\t");
        int videoLength = Integer.parseInt(str[4]);
        
        if(numReduceTasks == 0)
        {
           return 0;
        }
        
        if(videoLength<=500)
        {
           return 0;
        }
        else if(videoLength>500 && videoLength<=1000)
        {
           return 1 % numReduceTasks;
        }
        else if(videoLength>1000 && videoLength<=2000)
        {
           return 2 % numReduceTasks;
        }
        else if(videoLength>2000 && videoLength<=3000)
        {
            return 3 % numReduceTasks;
        }
        else if(videoLength>3000 && videoLength<=5000)
        {
           return 4 % numReduceTasks;
        }
        else
        {
           return 5 % numReduceTasks;
        }
	}

}
