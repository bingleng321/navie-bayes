package zx.soft.navie.bayes.mapreduce;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

public class TrainCateReducerTest {

	ReduceDriver<Text, IntWritable, Text, Text> reducedriver;

	@Before
	public void setUp() throws Exception {
		TrainCateReducer reducer = new TrainCateReducer();
		reducedriver = ReduceDriver.newReduceDriver(reducer);
	}

	@Test
	public void test() {
		List<IntWritable> values = new ArrayList<>();
		values.add(new IntWritable(1));
		values.add(new IntWritable(2));
		values.add(new IntWritable(3));
		reducedriver.withInput(new Text("cate1"), values);
		reducedriver.withOutput(new Text("cate1"), new Text("3:6"));

	}
}
