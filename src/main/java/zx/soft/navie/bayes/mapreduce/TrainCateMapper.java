package zx.soft.navie.bayes.mapreduce;

import java.io.IOException;
import java.util.Vector;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * 统计每个类别对应的词数，即：cate——>size(words)
 * @author zhu mm
 *
 */
public class TrainCateMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context) throws InterruptedException, IOException {

		String[] words = value.toString().split("\\s+"); //正则  空格分开
		Vector<String> cates = NavieBayesDistribute.tokenizeLabels(words[0]);
		Vector<String> text = NavieBayesDistribute.tokenizeDoc(words);

		for (String cate : cates) {
			context.write(new Text(cate), new IntWritable(text.size()));
		}
	}

}
