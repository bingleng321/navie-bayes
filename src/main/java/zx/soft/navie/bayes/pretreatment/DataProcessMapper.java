package zx.soft.navie.bayes.pretreatment;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import zx.soft.navie.bayes.analyzer.AnalyzerTool;

/**
 * processing source data,format as follows: catei wordi wordj wordk
 * @author zhumm
 *
 */

public class DataProcessMapper extends Mapper<LongWritable, Text, LongWritable, Text> {

	private static final AnalyzerTool analyzerTool = new AnalyzerTool();
	private static InputSplit inputSplit;
	private static FileSplit filesplit;
	private static String fileName;
	private static String cate;
	private static String reval = null;

	@Override
	public void map(LongWritable key, Text value, Context context) throws InterruptedException, IOException {

		if (value.toString().length() > 0) {
			inputSplit = context.getInputSplit();
			filesplit = (FileSplit) inputSplit;
			fileName = filesplit.getPath().toUri().toString();
			cate = fileName.substring(fileName.lastIndexOf("/") + 1);
			reval = analyzerTool.analyzerTextToStr(value.toString(), " ");
			context.write(key, new Text(cate + " " + reval));
		}

	}
}
