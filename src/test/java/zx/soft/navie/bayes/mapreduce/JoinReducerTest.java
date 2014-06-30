package zx.soft.navie.bayes.mapreduce;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

public class JoinReducerTest {

	ReduceDriver<Text, Text, Text, Text> reducerdriver;

	@Before
	public void setUp() throws Exception {
		JoinReducer reducer = new JoinReducer();
		reducerdriver = ReduceDriver.newReduceDriver(reducer);
	}

	@Test
	public void test() {
		List<Text> values = new ArrayList<>();
		values.add(new Text("cate1:1 cate2:2 cate3:1"));
		values.add(new Text("1,cate1,cate2"));
		values.add(new Text("2,cate2,cate3"));
		reducerdriver.withInput(new Text("测试"), values);
		reducerdriver.withOutput(new Text("测试"), new Text("cate1:1 cate2:2 cate3:1::1,cate1,cate2::2,cate2,cate3"));
	}
}
