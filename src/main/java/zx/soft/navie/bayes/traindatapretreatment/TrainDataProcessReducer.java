package zx.soft.navie.bayes.traindatapretreatment;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * processing source data,format as follows: catei wordi wordj wordk
											   catej wordi wordj wordk
 * @author zhumm
 *
 */

public class TrainDataProcessReducer extends Reducer<LongWritable, Text, NullWritable, Text> {

	@Override
	public void reduce(LongWritable key, Iterable<Text> values, Context context) throws InterruptedException,
			IOException {

		for (Text value : values) {
			context.write(NullWritable.get(), value);
		}

	}
}
