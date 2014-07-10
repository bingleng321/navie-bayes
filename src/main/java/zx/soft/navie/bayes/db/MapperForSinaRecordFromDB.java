package zx.soft.navie.bayes.db;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class MapperForSinaRecordFromDB extends
		Mapper<LongWritable, SinaRecordWithInputWritable, LongWritable, SinaRecordWithInputWritable> {
	@Override
	protected void map(LongWritable key, SinaRecordWithInputWritable value, Context context) throws IOException,
			InterruptedException {

		context.write(key, value);

	}
}
