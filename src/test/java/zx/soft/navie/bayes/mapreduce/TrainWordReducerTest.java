package zx.soft.navie.bayes.mapreduce;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

public class TrainWordReducerTest {

	ReduceDriver<Text, Text, Text, Text> reducedriver;

	@Before
	public void setUp() throws Exception {
		TrainWordReducer reducer = new TrainWordReducer();
		reducedriver = ReduceDriver.newReduceDriver(reducer);
	}

	@Test
	public void test() {
		List<Text> values = new ArrayList<>();
		values.add(new Text("cate1"));
		values.add(new Text("cate2"));
		values.add(new Text("cate3"));
		values.add(new Text("cate2"));
		reducedriver.withInput(new Text("测试"), values);
		reducedriver.withOutput(new Text("测试"), new Text("cate1:1 cate2:2 cate3:1"));

	}
}
