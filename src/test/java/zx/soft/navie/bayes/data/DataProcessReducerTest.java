package zx.soft.navie.bayes.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

public class DataProcessReducerTest {

	ReduceDriver<LongWritable, Text, NullWritable, Text> reduceDriver;

	@Before
	public void SetUp() throws Exception {
		DataProcessReducer dataProcessReducer = new DataProcessReducer();
		reduceDriver = ReduceDriver.newReduceDriver(dataProcessReducer);
	}

	@Test
	public void test() {

		List<Text> list = new ArrayList<>();
		list.add(new Text("如果"));
		list.add(new Text("见到我"));
		list.add(new Text("测试"));
		list.add(new Text("通过"));
		reduceDriver.withInput(new LongWritable(1), list);
		reduceDriver.withOutput(NullWritable.get(), new Text("如果 见到我 测试 通过"));
	}
}
