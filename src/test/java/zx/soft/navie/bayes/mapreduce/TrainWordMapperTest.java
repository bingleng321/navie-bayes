package zx.soft.navie.bayes.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Before;
import org.junit.Test;

public class TrainWordMapperTest {

	private MapDriver<LongWritable, Text, Text, Text> mapDriver;

	@Before
	public void setUp() {
		TrainWordMapper mapper = new TrainWordMapper();
		mapDriver = MapDriver.newMapDriver(mapper);
	}

	@Test
	public void testTrainWordMapper() throws IOException {
		mapDriver.withInput(new LongWritable(2L), new Text("cate1,cate2 测试 数据"));
		mapDriver.withOutput(new Text("测试"), new Text("cate1"));
		mapDriver.withOutput(new Text("数据"), new Text("cate1"));
		mapDriver.withOutput(new Text("测试"), new Text("cate2"));
		mapDriver.withOutput(new Text("数据"), new Text("cate2"));
		mapDriver.runTest();
	}
}
