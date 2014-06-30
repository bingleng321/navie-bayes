package zx.soft.navie.bayes.mapreduce;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Before;
import org.junit.Test;

public class JoinTestMapperTest {
	MapDriver<LongWritable, Text, Text, Text> mapdriver;

	@Before
	public void setUp() throws Exception {
		JoinTestMapper mapper = new JoinTestMapper();
		mapdriver = MapDriver.newMapDriver(mapper);
	}

	@Test
	public void test() {
		mapdriver.withInput(new LongWritable(1), new Text("cate1,cate2 测试 数据"));
		mapdriver.withOutput(new Text("测试"), new Text("1,cate1,cate2"));
		mapdriver.withOutput(new Text("数据"), new Text("1,cate1,cate2"));
	}
}
