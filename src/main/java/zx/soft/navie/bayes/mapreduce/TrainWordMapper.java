package zx.soft.navie.bayes.mapreduce;

import java.io.IOException;
import java.util.Vector;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * 读取输入文件数据，输出为word——>cate格式。 
 * @author wgybzb
 *
 */
public class TrainWordMapper extends Mapper<LongWritable, Text, Text, Text> {

	@Override
	public void map(LongWritable key, Text value, Context context) throws InterruptedException, IOException {

		String[] words = value.toString().split("\\s+"); //正则  空格分开
		Vector<String> cates = NavieBayesDistribute.tokenizeLabels(words[0]);
		Vector<String> text = NavieBayesDistribute.tokenizeDoc(words);

		for (String cate : cates) {
			for (String word : text) {
				// (C = c, W = w)
				context.write(new Text(word), new Text(cate));
			}
		}
	}

}
