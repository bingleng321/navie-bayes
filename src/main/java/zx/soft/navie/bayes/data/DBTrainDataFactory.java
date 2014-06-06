package zx.soft.navie.bayes.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBTrainDataFactory implements TrainDataFactory {

	private static Logger logger = LoggerFactory.getLogger(TextTrainDataFactory.class);

	@Override
	public String[] getCates() {
		return null;
	}

	@Override
	public void setCates(String[] cates) {

	}

	@Override
	public double numOfSampleInCate(String cate) {
		return 0;
	}

	@Override
	public int totalNumOfSample() {
		return 0;
	}

	@Override
	public String[] getPathSet(String cate) {
		return null;
	}

	@Override
	public String getSampleContent(String sampleDir) {
		return null;
	}

}