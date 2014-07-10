package zx.soft.navie.bayes.data;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Before;
import org.junit.Test;

import zx.soft.navie.bayes.traindatapretreatment.TrainDataProcessMapper;

public class DataProcessMapperTest {

	private MapDriver<LongWritable, Text, LongWritable, Text> mapDriver;

	@Before
	public void setUp() {
		TrainDataProcessMapper mapper = new TrainDataProcessMapper();
		mapDriver = MapDriver.newMapDriver(mapper);
	}

	@Test
	public void test() {
		//mapDriver.withInput(new LongWritable(555), new Text(
		//	"俺妈咪现在没事就溜达到万达吃个甜甜圈、冰激凌神马的，老资老清新[神马][咖啡] //@Super-吉吉:他们没拿阿！"));
		//mapDriver.withOutput(key, val)
		//not finished;
	}
}
