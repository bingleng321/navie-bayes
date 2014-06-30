package zx.soft.navie.bayes.mapreduce;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.types.Pair;
import org.junit.Before;
import org.junit.Test;

public class JoinModelMapperTest {

	MapDriver<Text, Text, Text, Text> mapdriver;

	@Before
	public void setUp() throws Exception {
		JoinModelMapper mapper = new JoinModelMapper();
		mapdriver = MapDriver.newMapDriver(mapper);
	}

	@Test
	public void test() {

		Pair<Text, Text> inputRecord = new Pair<Text, Text>(new Text("测试"), new Text("cate1:1 cate2:2 cate3:1"));
		mapdriver.withInput(inputRecord);
		Pair<Text, Text> outputRecord = inputRecord;
		mapdriver.withOutput(outputRecord);
		mapdriver.runTest();
	}
}
