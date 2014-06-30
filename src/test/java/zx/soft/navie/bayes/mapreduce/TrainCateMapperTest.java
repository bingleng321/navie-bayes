package zx.soft.navie.bayes.mapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.types.Pair;
import org.junit.Before;
import org.junit.Test;

public class TrainCateMapperTest {

	MapDriver<LongWritable, Text, Text, IntWritable> mapdriver;

	@Before
	public void setUp() throws Exception {
		TrainCateMapper mapper = new TrainCateMapper();
		mapdriver = MapDriver.newMapDriver(mapper);
	}

	@Test
	public void test() {
		Pair<LongWritable, Text> inputRecord = new Pair<LongWritable, Text>(new LongWritable(1), new Text(
				"cate1,cate2 测试 数据"));
		mapdriver.withInput(inputRecord);
		mapdriver.withOutput(new Text("cate1"), new IntWritable(2));
		mapdriver.withOutput(new Text("cate2"), new IntWritable(2));
	}

}
