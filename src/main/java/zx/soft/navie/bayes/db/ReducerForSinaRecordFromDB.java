package zx.soft.navie.bayes.db;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import zx.soft.navie.bayes.analyzer.AnalyzerTool;

public class ReducerForSinaRecordFromDB extends Reducer<LongWritable, SinaRecordWithInputWritable, NullWritable, Text> {

	private static final AnalyzerTool analyzerTool = new AnalyzerTool();

	@Override
	protected void reduce(LongWritable key, Iterable<SinaRecordWithInputWritable> values, Context context)
			throws IOException, InterruptedException {

		for (SinaRecordWithInputWritable value : values) {
			context.write(NullWritable.get(),
					new Text(value.getWid() + " " + analyzerTool.analyzerTextToStr(value.getText(), " ")));
		}

	}
}
