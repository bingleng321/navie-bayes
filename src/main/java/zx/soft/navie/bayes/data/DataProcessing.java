package zx.soft.navie.bayes.data;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class DataProcessing extends Configured implements Tool {

	/**
	 * 删除HDFS中的某个目录
	 * @param conf
	 * @param path
	 * @throws IOException
	 */
	public static void delete(Configuration conf, Path path) throws IOException {
		FileSystem fs = path.getFileSystem(conf);
		if (fs.exists(path)) {
			fs.delete(path, true);
		}
	}

	@Override
	public int run(String[] args) throws Exception {

		Configuration conf = getConf();
		int numReduceTasks = conf.getInt("numReduceTasks", 8);

		Path sourceDataPath = new Path(conf.get("sourceData"));
		Path dstDataPath = new Path(conf.get("processData"));

		DataProcessing.delete(conf, dstDataPath);

		Job dataProcessJob = new Job(conf, "zx-soft-navie-bayes-dataProcessing");
		dataProcessJob.setJarByClass(DataProcessing.class);
		dataProcessJob.setMapperClass(DataProcessMapper.class);
		dataProcessJob.setReducerClass(DataProcessReducer.class);

		dataProcessJob.setNumReduceTasks(numReduceTasks);

		dataProcessJob.setMapOutputKeyClass(LongWritable.class);
		dataProcessJob.setMapOutputValueClass(Text.class);
		dataProcessJob.setOutputKeyClass(NullWritable.class);
		dataProcessJob.setOutputValueClass(Text.class);

		FileInputFormat.addInputPath(dataProcessJob, sourceDataPath);
		FileOutputFormat.setOutputPath(dataProcessJob, dstDataPath);

		if (!dataProcessJob.waitForCompletion(true)) {
			System.err.println("ERROR: DataProcessing failed!");
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		try {
			int exitCode = ToolRunner.run(new DataProcessing(), args);
			System.exit(exitCode);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
